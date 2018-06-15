/*
 * TrainingStartTask.cpp
 *
 *  Created on: May 24, 2018
 *      Author: tmax
 */

#include "TrainingStartTask.h"


TrainingStartTask::TrainingStartTask(Job* job,  Json::Value& target)
{
	this->setJob(job);
	Log::d("[TrainingStartTask]", "%d, %d", target.isNull(), jsonRequest.isNull());
	jsonRequest.copy(target);

	jobMng = JobManager::getInstance();
	resourceInfo = nullptr;
	resourceMng = ResourceManager::getInstance();
	configuration = ClusterConfiguration();
}
void TrainingStartTask::main()
{
	if (isEventAChecked == false)
	{
		Log::d("[TrainingStartTask]", "starting Subroutine A %d", getJob()->getId());
		Json::Value item = jsonRequest[EVENT_MANAGER_CONST::CLUSTER_CONFIGURATION::TYPE];

		configuration.clusterSize 	= item[EVENT_MANAGER_CONST::CLUSTER_CONFIGURATION::CLUSTER_SIZE].asInt();
		configuration.psNum 		= item[EVENT_MANAGER_CONST::CLUSTER_CONFIGURATION::PS_NUMBER].asInt();
		configuration.workerNum		= item[EVENT_MANAGER_CONST::CLUSTER_CONFIGURATION::WORKER_NUMBER].asInt();
		configuration.isSynchronous	= item[EVENT_MANAGER_CONST::CLUSTER_CONFIGURATION::IS_SYNCHRONOUS].asBool();

		resourceInfo = resourceMng->requestProvision(
				getJob()->getOwner(), getJob(),
				configuration.clusterSize,
				configuration.psNum,
				configuration.workerNum);

		//TODO:
		// o 이떄는 프로비져닝 요청만 하는 상태!
		// o 그리고 Worker Node 결과(fd)는 EM을 통해 Event로 들어옴.
		// o 이 data 저장해야함

		Log::d("[TrainingStartTask]", "Resource Info - Owner: %d Job_id: %d", getJob()->getOwner(), getJob()->getId());

		Log::d("[TrainingStartTask]", "finishing Subroutine A %d", getJob()->getId());
	}
	else
	{
		Log::d("[TrainingStartTask]", "Event A passed %d", getJob()->getId());
	}
	if (isEventBChecked == false && isEventAChecked == true)
	{
		Log::d("[TrainingStartTask]", "Not checked Event B %d", getJob()->getId());
	}
	else
	{
		Log::d("[TrainingStartTask]", "Event B passed %d", getJob()->getId());
	}
	if (isEventCChecked == false && isEventBChecked == true && isEventAChecked == true)
	{
		Log::d("[TrainingStartTask]", "Not checked Event C %d", getJob()->getId());

		ScriptBuilder* builder = new ScriptBuilder();
		Script* script = new Script();
		script->batchSize = 100;
		script->pixelSize = 28;
		script->trainingSteps = 1500;
		script->hiddenUnits = 100;
		script->learningRate = 0.01f;
		std::string str = builder->build(script);


		jobMng->dispatch(resourceInfo, getJob(), str.c_str(), configuration.isSynchronous);

		delete builder;
		delete script;

		// TODO
		// o Should it be set by itself or need response message from worker node?
		isEventCChecked = true;
	}
	else
	{
		Log::d("[TrainingStartTask]", "Event C passed %d", getJob()->getId());
	}
	if (isEventAChecked && isEventBChecked && isEventCChecked)
	{
		Log::i("[TrainingStartTask]", "Task(Job %d) finished!!", getJob()->getId());
		this->setTaskFinished(true);
	}
}
void TrainingStartTask::handleEvent(Event* evt)
{
	if (evt->type == EVENT_A)
	{
		// set FD to a nodeInfo in resourceInfo object
		resourceInfo->getNode(evt->jsonObject[EVENT_MANAGER_CONST::RESOURCE::INDEX].asInt())
				->fd = evt->jsonObject[EVENT_MANAGER_CONST::RESOURCE::NODE_FD].asInt();

		auto vector = resourceInfo->getNode(evt->jsonObject[EVENT_MANAGER_CONST::RESOURCE::INDEX].asInt())
				->TrainingProcessVector;
		Json::Value portItem = evt->jsonObject[EVENT_MANAGER_CONST::RESOURCE::PORT];

		int portCount = 0;
		auto iter = std::begin(vector);
		while (iter != std::end(vector))
		{
			(*iter)->ip = evt->jsonObject[EVENT_MANAGER_CONST::RESOURCE::IP].asString();
			(*iter)->port = portItem[portCount++].asInt();
			++iter;
		}
		isEventAChecked = true;

		responseCount++;
		if(responseCount == configuration.clusterSize)
		{
			isEventBChecked = true;
		}
		//		resourceInfo->addNode(
		//				evt->jsonObject[EVENT_MANAGER_CONST::RESOURCE::INDEX].asInt(),
		//				evt->jsonObject[EVENT_MANAGER_CONST::RESOURCE::NODE_FD].asInt());
	}
	else if (evt->type == EVENT_C)
	{
		isEventCChecked = true;
	}
	Log::d("[TrainingStartTask]", "handleEvent event type %d", evt->type);
}

