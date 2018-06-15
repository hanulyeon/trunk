/*
 * TrainingStartTask.h
 *
 *  Created on: May 24, 2018
 *      Author: tmax
 */

#ifndef _TRAININGSTARTTASK_H
#define _TRAININGSTARTTASK_H

#include <string>

#include "../frame/Log.h"
#include "../frame/Task.h"
#include "../frame/Event.h"
#include "../frame/EventManager.h"
#include "../frame/EventManagerConst.h"
#include "../utils/json/json.h"
#include "../utils/ScriptBuilder.h"
#include "../managers/JobManager.h"
#include "../managers/ResourceManager.h"

class JobManager;
class TrainingStartTask: public Task{
public:
	const static int TASK_ID = 1000;
	// Event about getting training resources from IaaS master
	// o 생성된 리소스가 마스터에 붙어야 이벤트 핸들링 됨
	const static int EVENT_A = 2001;
	// Event that checking response count from training node
	const static int EVENT_B = 2002;
	// Event about sending script to worker
	const static int EVENT_C = 2003;

private:
	bool isEventAChecked = false;
	bool isEventBChecked = false;
	bool isEventCChecked = false;
	int responseCount = 0;

	Json::Value jsonRequest;

	JobManager* jobMng;
	ResourceInfo* resourceInfo;
	ResourceManager* resourceMng;

	ClusterConfiguration configuration;


public:
	TrainingStartTask(Job* job, Json::Value &target);
	void main() override;
	void handleEvent(Event* evt) override;
};

#endif /* _TRAININGSTARTTASK_H */
