/*
 * Module.cpp
 *
 *  Created on: Apr 5, 2018
 *      Author: tmax
 */


#include "Module.h"
#include "EventManager.h"

Module::~Module()
{

}
bool Module::acquireLock(Job* job)
{
	mtxLock.lock();
	if(lockFlag == false)
	{
		lockFlag = true;

		mtxLock.unlock();
		return true;
	}
	else
	{
		mtxLock.unlock();

		Log::d("[Module]","waitListSize: %d, jobId: %d", waitList.size(), job->getId());
		if(waitList.size() == 0)
		{
			waitList.push_back(job);
		}
		else
		{
			auto iter = std::begin(waitList);

			while (iter != std::end(waitList)) {
				if ((*iter)->getId() == job->getId())
					return false;
				else
					++iter;
			}
			waitList.push_back(job);

		}
		return false;
	}
}

void Module::releaseLock()
{
	lockFlag = false;
	if( waitList.size() > 0 )
	{
		Job* job = waitList.front();
		waitList.pop_front();
		EventManager* mng = EventManager::getInstance();
		Event* evt = new Event(Event::LOCK_RELEASE_EVENT, job);
		mng->pushEvent(evt);
	}
}
