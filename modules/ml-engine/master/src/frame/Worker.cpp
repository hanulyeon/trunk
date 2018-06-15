/*
 * Worker.cpp
 *
 *  Created on: Apr 4, 2018
 *      Author: tmax
 */


#include "Worker.h"



Worker::Worker(int id) : workerId(id)
{
	workerPipe = new Pipe();
	thrd = std::thread(&Worker::ready, this);
	std::cout << "[Worker] I'm worker No." << workerId <<std::endl;
}

Worker::~Worker()
{
	delete workerPipe;
}

void Worker::setTask(Task* task){
	this->task = task;
	std::cout << "[Worker] Task is allocated : " << task->getJob()->getId() <<std::endl;
}
Task* Worker::getTask(){
	return this->task;
}
void Worker::ready()
{
	EventManager* mng = EventManager::getInstance();
    for(;;)
    {
    	std::cout << "[Worker] Ready to read pipe : " << workerId <<std::endl;
    	// read message
    		// 작업관련된 이벤트 수신 시 작업 재시작
    	workerPipe->readPipe();
        std::cout << "[Worker] just read pipe : " << workerId <<std::endl;


        std::cout << "[Worker] start doing task - worker: " << workerId << ", jobId: " << this->task->getJob()->getId() <<std::endl;
        this->task->start();
        std::cout << "[Worker] finishing task - worker: " << workerId << ", jobId: " << this->task->getJob()->getId() <<std::endl;
        //If task is done
        if (this->task->isTaskFinished()){
        	Event* evt = new Event(Event::TASK_FINISH_EVENT, this->task->getJob());

        	mng->pushEvent(evt);
        }
        // else, this task will be suspended
        else{
        	Event* evt = new Event(Event::TASK_SUSPENDED_EVENT, this->task->getJob());

        	mng->pushEvent(evt);
        }
    }
}


Pipe* Worker::getPipe()
{
	return workerPipe;
}


int Worker::getId() {
	return workerId;
}


