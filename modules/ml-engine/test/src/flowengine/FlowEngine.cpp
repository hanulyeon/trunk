/*
 * FlowEngine.cpp
 *
 *  Created on: Jun 1, 2018
 *      Author: tmax
 */

#include "../flowengine/FlowEngine.h"


#include "../flowengine/FlowEngine.h"

namespace SERVER_CONST
{
const static char* RESPONSE	= "Response";
const static char* SUCCESS	= "success";
const static char* JOB_ID	= "job_id";
const static char* MESSAGE	= "message";

const static char* TASK		= "Task";
const static int TASK_START	= 1000;
const static int TASK_STOP	= 1001;

}

FlowEngine::~FlowEngine() {
	if (running){
		running = false;
		close(socketFd);
	}
}

bool FlowEngine::setConfiguration(const char* targetIp, int targetPort)
{
	socketFd = socket(PF_INET, SOCK_STREAM, 0);
	if(socketFd == -1)
	{
		Log::i("[FlowEngine]", "socket() error");
		return false;
	}
	memset(&serv_addr, 0, sizeof(serv_addr));
	serv_addr.sin_family = AF_INET;
	serv_addr.sin_addr.s_addr=inet_addr(targetIp);
	serv_addr.sin_port=htons(targetPort);

	return true;
}


bool FlowEngine::start()
{
	if(connect(socketFd,(struct sockaddr*)&serv_addr, sizeof(serv_addr)) == -1)
	{
		printf("Server IP = %s\n", inet_ntoa(serv_addr.sin_addr));
		printf("Server port = %d\n", ntohs(serv_addr.sin_port));
		Log::i("[FlowEngine]", "connect() error");
		return false;
	}

	Log::i("[FlowEngine]", "Successfully connected to server");
	Log::i("[FlowEngine]", "Server IP = %s", inet_ntoa(serv_addr.sin_addr));
	Log::i("[FlowEngine]", "Server port = %d", ntohs(serv_addr.sin_port));

	sendThread = std::thread(sendMessage, socketFd);
	receiveThread = std::thread(recvMessage, socketFd);

	receiveThread.join();
	sendThread.join();

	close(socketFd);
	return true;
}

void FlowEngine::sendMessage(int socketFd)
{
	fputs("Enter 'training' to sent a request to ML Master\n", stdout);
	char message[BUFSIZE];

	while(1){
		fgets(message, BUFSIZE, stdin);
		if(!strcmp(message, "q\n"))
		{
			close(socketFd);
			exit(0);
		}
		else if(!strcmp(message, "training\n"))
		{
			Json::Value root;
			Json::Value item1;
			Json::Value item2;
			Json::Value item3;

			item1["task_id"] = 1000;
			root["Task"] = item1;

			item2["batch_size"] = 32;
			item2["step_size"] = 150000;
			item2["algorithm_name"] = "Mnist";
			root["Model"] = item2;

			item3["cluster_size"] = 1;
			item3["ps_number"] = 1;
			item3["worker_number"] = 2;
			item3["is_synchronous"] = true;
			root["ClusterConfiguration"] = item3;

			Json::StyledWriter writer;
			std::string str = writer.write(root);
			sprintf(message, str.c_str());
			write(socketFd, message, strlen(message));
		}
		else
		{
			write(socketFd, message, strlen(message));
		}
	}
}

void FlowEngine::recvMessage(int socketFd)
{
	char buf[BUFSIZE];
	while(1)
	{
	    // clear buffer
	    memset(buf, 0, BUFSIZE);
		auto count = read(socketFd, buf, 512);
		Log::d("[FlowEngine]", "incoming message from %d", socketFd);
		if (count == 0) // EOF - remote closed connection
		{
			Log::i("[FlowEngine]", "Connection closed %d", socketFd);
			close(socketFd);
			break;
		}

		if(count == BUFSIZE)
		{
			Log::d("[FlowEngine]", "length of str %d", strlen(buf));
			Log::d("[FlowEngine]", "last word = %c, BUFSIZE = %c", buf[BUFSIZE-1], buf[BUFSIZE]);
			if(buf[count] == 0)
			{
				Log::d("[FlowEngine]", "TEA!!");
			}
			//			Log::d("[Client]", "last word = %c, -2 = %c", buf[BUFSIZE-1], buf[BUFSIZE-2]);
		}

		Json::Value jsonObject;

		Json::Reader reader;
		bool parsingRet = reader.parse(buf, jsonObject);

		if (!parsingRet)
		{
			Log::w("[FlowEngine]", "Failed to parse Json");
			std::cout << reader.getFormattedErrorMessages() << std::endl;
			Log::d("[FlowEngine]", "says %s", buf);
		}
		// Incoming Json Request
		else
		{
			fputs(buf, stdout);
		}
	}
}
