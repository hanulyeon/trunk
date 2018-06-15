/**
 * Project Untitled
 */


#ifndef _RESOURCEMANAGER_H
#define _RESOURCEMANAGER_H


#include <deque>
#include <list>

#include "../frame/Job.h"
#include "../frame/Log.h"
#include "../frame/DynamicSingleton.h"
#include "../frame/EventManagerConst.h"
#include "../models/ResourceInfo.h"
#include "../models/TrainingProcess.h"

using namespace std;

class ResourceManager :public DynamicSingleton<ResourceManager>{
public: 
	
	/**
	 * @param owner
	 */
	ResourceInfo* requestProvision(int owner, Job* job, int clusterSize, int psNum, int workerNum);
	

	/**
	 * @param owner
	 */
	bool releaseResource(int owner, Job* job);
	
	/**
	 * @param owner
	 */
	ResourceInfo* getResourceInfo(int owner, Job* job);
private: 
	list<ResourceInfo*> resourceList;
};

#endif //_RESOURCEMANAGER_H
