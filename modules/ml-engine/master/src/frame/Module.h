/*
 * Module.h
 *
 *  Created on: Apr 5, 2018
 *      Author: tmax
 */

#ifndef MODULE_H_
#define MODULE_H_

#include "Job.h"
#include "Log.h"
#include <list>
#include <algorithm>
#include <mutex>

class Module{
public:
	bool acquireLock(Job* job);
	void releaseLock();
	virtual ~Module();

private:
	bool lockFlag = false;
	std::list<Job*> waitList;
    std::mutex mtxLock;
};



#endif /* MODULE_H_ */
