/*
 * EventManager.h
 *
 *  Created on: Apr 4, 2018
 *      Author: tmax
 */

#ifndef EVENTMANAGER_H_
#define EVENTMANAGER_H_

#include <map>
#include <list>
#include <vector>
#include <string>
#include <utility>
#include <iostream>

#include <errno.h>
#include <unistd.h>
#include <sys/epoll.h>

#include "Job.h"
#include "Pipe.h"
#include "Task.h"
#include "Event.h"
#include "WorkerThreadPool.h"
#include "DynamicSingleton.h"
#include "EventManagerConst.h"

#include "../utils/json/json.h"

//For TEST
#include "../tasks/CustomTask.h"
#include "../managers/JobManager.h"
#include "../tasks/TrainingStartTask.h"
#include "../utils/NetworkUtil.h"

class WorkerThreadPool;

class EventManager :public DynamicSingleton<EventManager>{
protected:
    ~EventManager();
public :
    // Run and Stop
	void stop();
	int runService(const char *pszAddr, unsigned short port);

	// Configuration
    void setThreadCount(int count/*, int*/);

    // Receive internal events
    void pushEvent(Event* evt);

    // Not used yet
    int getWorkingThreadCount();
    bool checkEventQueueEmpty();

    // Lite-Task processing functions
    void pushInputDataToManager();
    void getInputDataFromManager();

    // A method for workers to send a message to fd directly
	bool writeData(int fd, const char *format, ...);


private:
	void notify();
	void dealNewConnection();
	void dealFdEvent(int fd);
	void dealOtherSrvEvent(int fd);

	void clearTaskCache(Job* job);
	Task* findTaskbyJob(Job* job);

	bool readData(int fd, char *buf);
	int recvMessageWebsocket(int fd, char *rcvBuffer);
	bool start(const char *pszAddr, unsigned short port);
	bool parseToJson(const char* buf, Json::Value& jsonObject);


	// TEST CODE
	void TESTFUNCTION_runTask(int fd);
private :
	int epollFd;
	bool running;
	int socketFd;
	char address[64];
	unsigned short port;

	std::list<Event*> eventList;

	std::vector<int> acceptedFds;
    WorkerThreadPool* workerThreadPool;
	std::list<std::pair<unsigned int, Task*>> jobIdTaskPtrList;
//    std::map<int, Task*> jobIdTaskPtrMap;
};

#endif /* EVENTMANAGER_H_ */
