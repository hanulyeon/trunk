/*
 * Worker.h
 *
 *  Created on: Apr 4, 2018
 *      Author: tmax
 */

#ifndef WORKER_H
#define WORKER_H

#include <iostream>
#include <thread>
#include <atomic>
#include "Task.h"
#include "EventManager.h"
#include "Pipe.h"

class Worker {
public:
    Worker(int id);
    ~Worker();

    void ready();

    void setTask(Task *task);

    Task* getTask();
    int getId();

    Pipe* getPipe();

//    void setEventManagerPipe(Pipe* em_pipe);
//    void setDone();
//    void joinThrd();

private:
    Task* task;

    int workerId;
    Pipe* workerPipe;

    std::thread thrd;
};

#endif /* WORKER_H */
