/*
 * Task.hpp
 *
 *  Created on: Apr 4, 2018
 *      Author: tmax
 */

#ifndef TASK_H_
#define TASK_H_
#include "Job.h"
#include "Event.h"
#include <iostream>

//template<class T>
class Task{
public:
	Task() : taskFinished(false){}
	void start() {
//		static_cast<T*>(this)->main();
		main();
	}
	virtual ~Task() {};
	virtual void main() = 0;
	virtual void handleEvent(Event* evt) = 0;
	bool isTaskFinished(){ return taskFinished; };
	void setTaskFinished(bool val){ this->taskFinished = val;};
	Job* getJob(){ return this->job; };
	void setJob(Job* job){
		this->job = job;
//		std::cout << "[Task] job is .. "<< this->job->getId() << std::endl;
	}
private:
	bool taskFinished;
	Job* job;
};


#endif /* TASK_H_ */
