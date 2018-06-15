/*
 * SingleThreadServer.cpp
 *
 *  Created on: Apr 4, 2018
 *      Author: tmax
 */
#include "Client.h"


Client::~Client() {
	if (running){
		running = false;
		close(socketFd);
	}
}

bool Client::setConfiguration(unsigned int jobId, const char* targetIp, int targetPort, int nodeIndex, int tpNum)
{
	this->jobId = jobId;
	this->nodeIndex = nodeIndex;
	this->tpNum = tpNum;
	socketFd = socket(PF_INET, SOCK_STREAM, 0);
	if(socketFd == -1)
	{
		Log::i("[Client]", "socket() error");
		return false;
	}
	memset(&serv_addr, 0, sizeof(serv_addr));
	serv_addr.sin_family = AF_INET;
	serv_addr.sin_addr.s_addr=inet_addr(targetIp);
	serv_addr.sin_port=htons(targetPort);

	return true;
}


bool Client::start()
{
	if(connect(socketFd,(struct sockaddr*)&serv_addr, sizeof(serv_addr)) == -1)
	{
		printf("Server IP = %s\n", inet_ntoa(serv_addr.sin_addr));
		printf("Server port = %d\n", ntohs(serv_addr.sin_port));
		Log::i("[Client]", "connect() error");
		return false;
	}

	Log::i("[Client]", "Successfully connected to server");
	Log::i("[Client]", "Server IP = %s", inet_ntoa(serv_addr.sin_addr));
	Log::i("[Client]", "Server port = %d", ntohs(serv_addr.sin_port));

	sendThread = std::thread(sendMessage, socketFd, jobId, nodeIndex, tpNum);
	receiveThread = std::thread(recvMessage, socketFd);

	receiveThread.join();
	sendThread.join();

	close(socketFd);
	return true;
}

void Client::sendMessage(int socketFd, unsigned int jobId, int nodeIndex, int tpNum )
{
	bool isInitialReport = true;
	char message[BUFSIZE];

	while(1){
		// clear buffer
		memset(message, 0, sizeof(message));
		if(isInitialReport)
		{
			Log::d("[Client]", "Try initial report - jobId: %d", jobId);
			isInitialReport = false;

			Json::Value root;
			Json::Value itemResource;
			Json::Value itemPort;
			Json::Value itemResponse;

			//TODO
			// Node's index will be set by IaaS Master
			itemResource[EVENT_MANAGER_CONST::RESOURCE::INDEX] = nodeIndex;/* this will be given by IaaS Master */
			itemResource[EVENT_MANAGER_CONST::RESOURCE::STATUS] = "ready";
			itemResource[EVENT_MANAGER_CONST::RESOURCE::IP] = NetworkUtil::getIPAddress();
			Log::d("[Client]", "getIPAddress: %s", itemResource[EVENT_MANAGER_CONST::RESOURCE::IP].asCString());
			std::vector<int> portVec;
			NetworkUtil::getOpenPorts(tpNum, portVec);
			for(int i = 0 ; i < tpNum; i++)
			{
				Log::d("[Client]", "port: %d", portVec.back());
				itemPort.append(portVec.back());
				portVec.pop_back();
			}
			itemResource[EVENT_MANAGER_CONST::RESOURCE::PORT] = itemPort;
			root[EVENT_MANAGER_CONST::RESOURCE::TYPE] = itemResource;

			itemResponse["success"] = true;
			itemResponse["job_id"] = jobId;
			itemResponse["message"] = "";
			root["Response"] = itemResponse;
			// TODO    item initialization issue
			Json::StyledWriter writer;
			std::string str = writer.write(root);
			sprintf(message, str.c_str());
			write(socketFd, message, strlen(message));
		}
		else
		{
			fgets(message, BUFSIZE, stdin);
			if(!strcmp(message, "q\n")) {
				close(socketFd);
				exit(0);
			}
			//		sprintf(name_message, "%s", message);
			write(socketFd, message, strlen(message));
		}
	}
}

void Client::recvMessage(int socketFd)
{
	char buf[BUFSIZE];
	std::string str = "";
	while(1)
	{
		// clear buffer
		memset(buf, 0, sizeof(buf));
		auto count = read(socketFd, buf, BUFSIZE);
		Log::d("[Client]", "incoming message from %d, size %d", socketFd, count);

		// EOF - remote closed connection
		if (count == 0)
		{
			Log::i("[Client]", "Connection closed %d", socketFd);
			close(socketFd);
			break;
		}
		// Need to read more
		else if(count == BUFSIZE)
		{
			str.append(buf);
			Log::d("[Client]", "length of str %d", str.length());
		}
		// Respond
		else
		{
			str.append(buf);
			Log::d("[Client]", "Complete message from %d, size %d\n%s", socketFd, count, str.c_str());

			Json::Value jsonObject;

			Json::Reader reader;
			bool parsingRet = reader.parse(str, jsonObject);

			if (!parsingRet)
			{
				Log::w("[Client]", "Failed to parse Json");
				std::cout << reader.getFormattedErrorMessages() << std::endl;
			}
			// Incoming Json Request
			else
			{
				if(jsonObject.isMember(EVENT_MANAGER_CONST::TRAINING::TYPE))
				{
					const Json::Value trainingItem = jsonObject[EVENT_MANAGER_CONST::TRAINING::TYPE];
					const Json::Value processItem = jsonObject[EVENT_MANAGER_CONST::PROCESS::TYPE];

					std::string filePath1 = "job.py";

					unsigned int jobId 	= trainingItem[EVENT_MANAGER_CONST::TRAINING::JOB_ID].asUInt();
					bool isSynchronous	= trainingItem[EVENT_MANAGER_CONST::CLUSTER_CONFIGURATION::IS_SYNCHRONOUS].asBool();

					std::string psHosts;
					std::string workerHosts;
					for (auto iter = processItem.begin(); iter != processItem.end(); iter++)
					{
						if (iter->isObject())
						{
							if( (*iter)[EVENT_MANAGER_CONST::PROCESS::JOB_NAME] == EVENT_MANAGER_CONST::TRAINING::PS)
							{
								if(psHosts.length() != 0)
								{
									psHosts += ',';
								}
								psHosts += (*iter)[EVENT_MANAGER_CONST::PROCESS::IP].asString();
								psHosts += ":";
								psHosts += std::to_string( (*iter)[EVENT_MANAGER_CONST::PROCESS::PORT].asInt() );
							}
							else
							{
								if(workerHosts.length() != 0)
								{
									workerHosts += ',';
								}
								workerHosts += (*iter)[EVENT_MANAGER_CONST::PROCESS::IP].asString();
								workerHosts += ":";
								workerHosts +=  std::to_string( (*iter)[EVENT_MANAGER_CONST::PROCESS::PORT].asInt() );
							}

						}
					}

					// write File
					std::ofstream writeFile(filePath1.data());
					if( writeFile.is_open() ){
						writeFile << trainingItem[EVENT_MANAGER_CONST::TRAINING::SCRIPT].asCString();
						writeFile.close();
					}

					char args[200];
					for (auto iter = processItem.begin(); iter != processItem.end(); iter++)
					{
						memset(args, 0,sizeof(args));
						if (iter->isObject())
						{
							if((*iter)[EVENT_MANAGER_CONST::PROCESS::IP].asString() == NetworkUtil::getIPAddress())
							{
								sprintf(args, "--job_name=%s --task_index=%d --ps_hosts=%s --worker_hosts=%s",
										(*iter)[EVENT_MANAGER_CONST::PROCESS::JOB_NAME].asCString(),
										(*iter)[EVENT_MANAGER_CONST::PROCESS::INDEX].asInt(),
										psHosts.c_str(),
										workerHosts.c_str());
								int state = ProcessManager::getInstance()->runCommand(args);
								if(state == ProcessManager::PROCESS_EXECUTION_FAIL)
								{
									//TODO
									// o 테스크 수행 실패했다는 제이슨 메세지 전달
									// o -> (EM)테스크 수행 중지 테스크 실행
								}
								else
								{
									Log::d("[Client]", "successfully finished running %s of %d index\ncommand: %s",
											(*iter)[EVENT_MANAGER_CONST::PROCESS::JOB_NAME].asCString(),
											(*iter)[EVENT_MANAGER_CONST::PROCESS::INDEX].asInt(),
											args);
								}
							}
						}
					}
				}
			}

			str = "";
		}
	}
}
