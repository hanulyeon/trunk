/*
 * WorkerThreadPool.h
 *
 *  Created on: Apr 4, 2018
 *      Author: tmax
 */

#ifndef WORKERTHREADPOOL_H_
#define WORKERTHREADPOOL_H_

#include "Log.h"

#include <queue>
#include <vector>
#include <utility>
#include <algorithm>
#include <map>

#include "Pipe.h"
#include "Worker.h"
#include "Task.h"

class Worker;

class WorkerThreadPool {

public:
	WorkerThreadPool(int cnt);
    ~WorkerThreadPool();

    void runTask(Task* task);
    void setWorkerDone(unsigned int jobId);
    void setWorkerSuspended(unsigned int jobId);
    int getWorkingThreadCount();
    int getWaitingThreadCount();

private:
    Worker* findWorkerbyJobId(unsigned int jobId);
    void runRemainingTask();
    void setWorkerIdle(unsigned int jobId, int workerId);

private:
    std::vector<Worker*> workerVector;
    std::list<Task*> remainingTaskList;
    std::list<std::pair<unsigned int, Worker*>> jobIdWorkerPtrList;
//    std::vector<std::pair<unsigned int, Worker*>> jobIdWorkerPtrVector;
    std::queue<int> idleWorkerQueue;
    std::size_t workerCount;
};


#endif /* WORKERTHREADPOOL_H_ */
