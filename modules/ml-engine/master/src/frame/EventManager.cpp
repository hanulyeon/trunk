/*
 * EventManager.cpp
 *
 *  Created on: Apr 4, 2018
 *      Author: tmax
 */

#include "EventManager.h"


//EventManager::EventManager(){
//	emPipe = new Pipe();
//}
//
EventManager::~EventManager() {
	delete workerThreadPool;
	if (running){
		running = false;
		close(socketFd);
	}
}

void EventManager::setThreadCount(int count)
{
	workerThreadPool = new WorkerThreadPool(count);
	Log::i("[EventManger]", "Worker Thread Pool is ready");
}

void EventManager::pushInputDataToManager(){}
void EventManager::getInputDataFromManager(){}

void EventManager::pushEvent(Event* evt)
{
	eventList.push_back(evt);
}
void EventManager::notify()
{
	if(eventList.size() > 0)
	{
		Event* evt = eventList.front();
		eventList.pop_front();
		std::cout << "[EventManger] notify event: " << evt->type << std::endl;

		// Default Events
		if(evt->type == Event::LOCK_RELEASE_EVENT)
		{
			Task* task = findTaskbyJob(evt->job);
			workerThreadPool->runTask(task);
		}
		else if(evt->type == Event::TASK_SUSPENDED_EVENT)
		{
			workerThreadPool->setWorkerSuspended(evt->job->getId());
		}
		else if(evt->type == Event::TASK_FINISH_EVENT)
		{
			workerThreadPool->setWorkerDone(evt->job->getId());

			//TODO
			// Task에 따라 다른 메세지 리턴형식 지정
			Json::Value item;
			Json::Value root;
			item[EVENT_MANAGER_CONST::RESPONSE::SUCCESS] = true;
			item[EVENT_MANAGER_CONST::RESPONSE::MESSAGE] = "finished";
			item[EVENT_MANAGER_CONST::RESPONSE::JOB_ID] = evt->job->getId();
			root[EVENT_MANAGER_CONST::RESPONSE::TYPE] = item;
			Json::StyledWriter writer;
			std::string str = writer.write(root);
			writeData(evt->job->getOwner(), str.c_str());

			clearTaskCache(evt->job);
		}
		else if(evt->type == Event::NETWORK_RESPONSE_FAIL_EVENT)
		{
			writeData(evt->job->getOwner(),
					"Job %d running failed.\n message: %s",
					evt->job->getId(), evt->jsonObject[EVENT_MANAGER_CONST::RESPONSE::MESSAGE].asCString());

			clearTaskCache(evt->job);
		}
		else if(evt->type == Event::NETWORK_RESPONSE_SUCCESS_EVENT)
		{

		}
		// Custom Events
		else
		{
			// Task와 관련된 Event만 찾아서 보내므로 Default Event외에
			// Custom Event간 Event구분번호는 중복되도 관계없음
			// example) A_task.eventA(#2001) != B_task.eventB(#2001)
			Task *task = findTaskbyJob(evt->job);
			//이벤트 헨들링 이후 이벤트 삭제
			task->handleEvent(evt);
			workerThreadPool->runTask(task);
		}

		delete evt;
	}
}

Task* EventManager::findTaskbyJob(Job* job)
{
	auto iter = std::begin(jobIdTaskPtrList);

	while (iter != std::end(jobIdTaskPtrList))
	{
		//		Log::d("[EventManager]", "job id: %d", (*iter).first );
		if ((*iter).first == job->getId())
			return (*iter).second;
		else
			++iter;
	}
	return nullptr;

	//	map<int, Task*>::iterator iter;
	//	iter = jobIdTaskPtrMap.find(job->getId());
	//	if ( iter == jobIdTaskPtrMap.end() ) {
	//		// not found
	//		std::cout << "[EventManger] CAN NOT FIND MATCHING TASK... job id: " << job->getId() <<std::endl;
	//		return nullptr;
	//	} else {
	//		// found
	//		return (*iter).second;
	//	}

	//	for(int i = 0; i < jobIdTaskPtrVector.size() ; i++)
	//	{
	//		std::pair<int, Task*> part = jobIdTaskPtrVector[i];
	////		std::cout << "[EventManger] job id: " << part.first <<std::endl;
	//		if(part.first == job->getId())
	//		{
	//			return part.second;
	//		}
	//	}
}
void EventManager::clearTaskCache(Job* job)
{
	Task* task = findTaskbyJob(job);
	// job 관리는 모두 JobManager가 담당하므로 원소삭제 임무 담당
	JobManager::getInstance()->removeJob(job->getId());

	auto iter = std::begin(jobIdTaskPtrList);

	while (iter != std::end(jobIdTaskPtrList))
	{
		if ((*iter).first == job->getId())
		{
			//원소삭제
			this->jobIdTaskPtrList.erase(iter);
			break;
		}
		else
			++iter;
	}
	// 작업완료된 Task 삭제
	delete task;
}

void EventManager::TESTFUNCTION_runTask(int fd)
{
	std::cout << "[EventManager] TESTFUNCTION_runTask started\n" << std::endl;

	JobManager *jobManager = JobManager::getInstance();
	Job* job_1 = jobManager->createJob(20000, fd);
	Job* job_2 = jobManager->createJob(26000, fd);
	Job* job_3 = jobManager->createJob(30000, fd);
	Job* job_4 = jobManager->createJob(10050, fd);
	std::cout << "[EventManger] Jobs are created" << std::endl;

	CustomTask* task_1 = new CustomTask(job_1);
	CustomTask* task_2 = new CustomTask(job_2);
	CustomTask* task_3 = new CustomTask(job_3);
	CustomTask* task_4 = new CustomTask(job_4);
	std::cout << "[EventManger] Tasks are created\n" << std::endl;

	std::cout << "[EventManger] task_1, job_id: " << task_1->getJob()->getId() << std::endl;
	std::cout << "[EventManger] task_2, job_id: " << task_2->getJob()->getId() << std::endl;
	std::cout << "[EventManger] task_3, job_id: " << task_3->getJob()->getId() << std::endl;
	std::cout << "[EventManger] task_4, job_id: " << task_4->getJob()->getId() << std::endl;

	this->jobIdTaskPtrList.push_back(std::make_pair(job_1->getId(), task_1));
	this->jobIdTaskPtrList.push_back(std::make_pair(job_2->getId(), task_2));
	this->jobIdTaskPtrList.push_back(std::make_pair(job_3->getId(), task_3));
	this->jobIdTaskPtrList.push_back(std::make_pair(job_4->getId(), task_4));

	//	this->jobIdTaskPtrVector.push_back(std::make_pair(8, task_1));
	//	this->jobIdTaskPtrVector.push_back(std::make_pair(9, task_2));
	//	this->jobIdTaskPtrVector.push_back(std::make_pair(10, task_3));
	//	this->jobIdTaskPtrVector.push_back(std::make_pair(11, task_4));

	//	this->jobIdTaskPtrMap.insert(std::make_pair(job_1->getId(), task_1));
	//	this->jobIdTaskPtrMap.insert(std::make_pair(job_2->getId(), task_2));
	//	this->jobIdTaskPtrMap.insert(std::make_pair(job_3->getId(), task_3));
	//	this->jobIdTaskPtrMap.insert(std::make_pair(job_4->getId(), task_4));


	std::cout << "[EventManger] jobIdTaskPtrVector ready" << std::endl;

	this->workerThreadPool->runTask(task_1);
	this->workerThreadPool->runTask(task_2);
	this->workerThreadPool->runTask(task_3);
	this->workerThreadPool->runTask(task_4);
	std::cout << "[EventManger] TESTFUNCTION_runTask done" << std::endl;
}



bool EventManager::start(const char *pszAddr, unsigned short port)
{
	int fd = NetworkUtil::createSocket(SOCK_STREAM);
	if (fd <= 0)
		return false;
	this->socketFd = fd;
	if (!NetworkUtil::setNonBlock(fd))
	{
		ERROR_PRINT("set nonblock error");
		return false;
	}
	int n = NetworkUtil::startBinding(fd, pszAddr, port);
	if (n != 0)
	{
		ERROR_PRINT("fd bind error");
		return false;
	}
	n = NetworkUtil::startListening(fd, 5);
	if (n != 0)
	{
		ERROR_PRINT("fd listen error");
		return false;
	}
	int epfd = epoll_create(EVENT_MANAGER_CONST::MAX_EPOLL_SIZE);
	if (epfd == -1)
	{
		ERROR_PRINT("epoll create error");
		return false;
	}
	this->epollFd = epfd;
	struct epoll_event ev;
	memset(&ev, 0x00, sizeof ev);
	//수신할 데이터가 있다 || 송신 가능하다
	ev.events = EPOLLIN || EPOLLOUT;
	ev.data.fd = fd;
	if (epoll_ctl(this->epollFd, EPOLL_CTL_ADD, fd, &ev) == -1)
	{
		ERROR_PRINT("epoll ctl add fd error");
		return false;
	}
	running = true;
	return true;
}

void EventManager::stop()
{
	close(socketFd);
	running = false;
}

int EventManager::runService(const char *pszAddr, unsigned short port)
{
	bool b = start(pszAddr, port);
	if (!b)
	{
		printf("Start server error\n");
		return -1;
	}

	Log::i("[EventManger]", "Start running server");
	Log::i("[EventManger]", "addr: %s, port: %d",pszAddr, port);

	struct epoll_event events[EVENT_MANAGER_CONST::MAX_EPOLL_SIZE];
	enum {EPOLL_TIMEOUT = 50};
	while(running)
	{
		//성공시 이벤트 발생한 파일 디스크립터 개수 반환, 실패시 -1 반환
		int nfds = epoll_wait(this->epollFd, events, EVENT_MANAGER_CONST::MAX_EPOLL_SIZE, EPOLL_TIMEOUT);
		if (nfds == -1)
		{
			if (errno == EINTR)
			{
				continue;
			}
			else
			{
				ERROR_PRINT("Failed to epoll_wait");
				return -1;
				break;
			}
		}
		for (int i = 0; i < nfds; ++i)
		{
			int fd = events[i].data.fd;
			//서버 소켓에 이벤트
			if (fd == this->socketFd)
			{
				//accept 처리
				dealNewConnection();
			}
			else
			{
				// handle message
				//  - read, write, close socket 처리
				dealFdEvent(fd);
			}
		}
		// Handle pushed event
		// Notify event to workers
		this->notify();
	}
}

void EventManager::dealNewConnection()
{
	int newfd = NetworkUtil::startAcception(this->socketFd);
	if (newfd <= 0)
	{
		ERROR_PRINT("accept new fd error");
		return;
	}
	NetworkUtil::setNonBlock(newfd);
	struct epoll_event ev;
	memset(&ev, 0x00, sizeof ev);
	ev.events = EPOLLIN || EPOLLET;
	ev.data.fd = newfd;
	if (epoll_ctl(this->epollFd, EPOLL_CTL_ADD, newfd, &ev) == -1)
	{
		ERROR_PRINT("epoll ctl add fd error");
		return;
	}
	Log::d("[EventManger]", "new connection is accepted: %d", newfd);

	this->acceptedFds.push_back(newfd);
}

void EventManager::dealFdEvent(int fd)
{

	Log::d("[EventManger]", "incoming message from %d", fd);
	char buf[512];
	// clear buffer
	memset(buf, 0, sizeof(buf));
	readData(fd, buf);
	Json::Value jsonObject;
	Log::d("[EventManger]", "says %s", buf);

	// Incoming Json Request
	if(parseToJson(buf, jsonObject))
	{
		// Network Response from clients
		if(jsonObject.isMember(EVENT_MANAGER_CONST::RESPONSE::TYPE))
		{
			const Json::Value item = jsonObject[EVENT_MANAGER_CONST::RESPONSE::TYPE];
			JobManager *jobManager = JobManager::getInstance();
			Job* job = jobManager->findJob(item[EVENT_MANAGER_CONST::RESPONSE::JOB_ID].asInt());
			if(item[EVENT_MANAGER_CONST::RESPONSE::SUCCESS])
			{
				// If response contains Resource information
				if(jsonObject.isMember(EVENT_MANAGER_CONST::RESOURCE::TYPE))
				{
					Json::Value resourceObject = jsonObject[EVENT_MANAGER_CONST::RESOURCE::TYPE];
					resourceObject[EVENT_MANAGER_CONST::RESOURCE::NODE_FD] = fd;
					Event* evt = new Event(TrainingStartTask::EVENT_A, job, resourceObject);
					pushEvent(evt);
				}
				// Default Network Response Event
				else
				{
					Event* evt = new Event(Event::NETWORK_RESPONSE_SUCCESS_EVENT, job);
					pushEvent(evt);
				}
			}
			// failed
			else
			{
				Event* evt = new Event(Event::NETWORK_RESPONSE_FAIL_EVENT, job,	item);
				pushEvent(evt);
			}
		}
		// Task Request from clients
		else if(jsonObject.isMember(EVENT_MANAGER_CONST::TASK::TYPE))
		{
			const Json::Value taskItem = jsonObject[EVENT_MANAGER_CONST::TASK::TYPE];
			const Json::Value modelItem = jsonObject[EVENT_MANAGER_CONST::MODEL::TYPE];

			JobManager *jobManager = JobManager::getInstance();
			Job* job_1 = jobManager->createJob(
					modelItem[EVENT_MANAGER_CONST::MODEL::STEP_SIZE].asInt(), fd);

			switch(taskItem[EVENT_MANAGER_CONST::TASK::TASK_ID].asInt())
			{
			case TrainingStartTask::TASK_ID:
				std::cout << "[EventManger] StartTrainingTask started\n" << std::endl;

				if(job_1 != nullptr)
				{
					TrainingStartTask* task_1 = new TrainingStartTask(job_1, jsonObject);
					Log::d("[EventManger]", "Task is created");
					Log::d("[EventManger]", "task_1, job_id: %d", task_1->getJob()->getId());

					this->jobIdTaskPtrList.push_back(std::make_pair(job_1->getId(), task_1));

					this->workerThreadPool->runTask(task_1);
					Log::d("[EventManger]", "Starting TrainingStartTask done");
				}
				break;
			case CustomTask::TASK_ID:
				break;
			}
		}
		else{
			Log::d("[EventManger]", "It is a json message but not able to understand");
		}
	}
	// Incoming message but not a json type
	else
	{
		if(strstr(buf, "test") != nullptr)
		{
			TESTFUNCTION_runTask(fd);
		}
		else if(strstr(buf, "word") != nullptr)
		{
			writeData(fd,
					"\
DDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDD\
DDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDD\
DDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDD\
DDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDD\
DDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDD\
DDDDDDDDDD1\n");
		}
	}

#ifdef WEB_SOCKET
	char buf[1024];
	this->recvMessageWebsocket(fd, buf);
#endif
}
bool EventManager::parseToJson(const char* string, Json::Value& jsonObject)
{
	Json::Reader reader;
	bool parsingRet = reader.parse(string, jsonObject);

	if (!parsingRet)
	{
		Log::w("[EventManager]", "Failed to parse Json");
		std::cout << reader.getFormattedErrorMessages() << std::endl;
		return false;
	}
	return true;
}
bool EventManager::writeData(int fd, const char* format, ...)
{
	Log::d("[EventManager]", "Try to send message to %d", fd);
	char* sMessage = NULL;
	int nLength = 0;
	va_list args;
	va_start(args, format);

	int retval;
	va_list argcopy;
	va_copy(argcopy, args);
	retval = vsnprintf(NULL, 0, format, argcopy);
	va_end(argcopy);
	nLength = retval + 1;

	sMessage = new char[nLength];
	vsprintf(sMessage, format, args);

	va_end(args);

	write(fd, sMessage, strlen(sMessage));
	//	send(fd, sMessage, strlen(sMessage), 0);

	delete [] sMessage;

	return true;
}
bool EventManager::readData(int fd, char* buf)
{
	auto count = read(fd, buf, 512);
	if (count == -1)
	{
		if (errno == EAGAIN) // read all data
		{
			return false;
		}
	}
	else if (count == 0) // EOF - remote closed connection
	{
		std::cout << "[I] Close " << fd << "\n";
		close(fd);
		return false;
	}
	return true;
}

/*  The following is websocket data frame:
 0                   1                   2                   3
 0 1 2 3 4 5 6 7 8 9 0 1 2 3 4 5 6 7 8 9 0 1 2 3 4 5 6 7 8 9 0 1
 +-+-+-+-+-------+-+-------------+-------------------------------+
 |F|R|R|R| opcode|M| Payload len |   Extended payload length     |
 |I|S|S|S|   (4) |A|     (7)     |            (16/64)            |
 |N|V|V|V|       |S|             |  (if payload len==126/127)    |
 | |1|2|3|       |K|             |                               |
 +-+-+-+-+-------+-+-------------+ - - - - - - - - - - - - - - - +
 |    Extended payload length continued, if payload len == 127   |
 + - - - - - - - - - - - - - - - +-------------------------------+
 |                               |Masking-key, if MASK set to 1  |
 +-------------------------------+-------------------------------+
 | Masking-key (continued)       |         Payload Data          |
 +-------------------------------- - - - - - - - - - - - - - - - +
 :                     Payload Data continued ...                :
 + - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - +
 |                     Payload Data continued ...                |
 +---------------------------------------------------------------+
 */
int EventManager::recvMessageWebsocket(int fd, char *rcvbuf)
{
	// just example
	::recv(fd, rcvbuf, 1024, 0);
	return 0;
}
