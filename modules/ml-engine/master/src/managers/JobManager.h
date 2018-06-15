/**
 * Project Untitled
 */


#ifndef _JOBMANAGER_H
#define _JOBMANAGER_H

#include <list>
#include <string>
#include <limits>
#include <iostream>

#include "../frame/Job.h"
#include "../frame/Log.h"
#include "../frame/Module.h"
#include "../frame/EventManager.h"
#include "../frame/DynamicSingleton.h"
#include "../frame/EventManagerConst.h"
#include "../models/ResourceInfo.h"

using namespace std;

class JobManager: public Module, public DynamicSingleton<JobManager>
{
public: 
	Job* createJob(int targetStep, int owner);
	/**
	 * @param jobId
	 */
	void removeJob(unsigned int jobId);
	void dispatch(ResourceInfo* resource, Job* job, const char* script, bool isSynchronous);
	
	Job* findJob(int id);
	void showJobList();

private: 
	list<Job*> jobList;
	int jobIndex = 0;

};

#endif //_JOBMANAGER_H
