/**
 * Project Untitled
 */


#include "JobManager.h"

/**
 * JobManager implementation
 */

Job* JobManager::createJob(int targetStep, int owner)
{
	if(this->jobList.size() == std::numeric_limits<unsigned int>::max())
	{
		Log::w("[JobManager]", "CAN NOT CREATE JOB ANYMORE!!");
		return nullptr;
	}
	else{
		Job* job = new Job(this->jobList.size()+1, targetStep, owner);
		this->jobList.push_back(job);
		return job;
	}
}

/**
 * @param jobId
 */
void JobManager::removeJob(unsigned int jobId)
{
	auto iter = std::begin(jobList);

	while (iter != std::end(jobList))
	{
		if ((*iter)->getId() == jobId)
		{
			this->jobList.erase(iter);
			break;
		}
		else
			++iter;
	}
}

// o 같은 명령이 여러 노드에 반복해서 보내짐
// o 각 노드가 여러 노드에 흩어져 있는 프로세스들의 포트 및 아이피를 알아야 Distributed 트레이닝 가능
void JobManager::dispatch(ResourceInfo* resource, Job* job, const char* script, bool isSynchronous)
{
	Log::d("[JobManager]", "dispatch: %d, script: %s", job->getId(), script);

	vector<ResourceInfo::NodeInfo*> nodeInfoVector;
	nodeInfoVector = resource->getNodeInfoVector();

	Json::Value root;
	Json::Value trainingItem;
	Json::Value processListItem;

	trainingItem[EVENT_MANAGER_CONST::TRAINING::JOB_ID] = job->getId();
	trainingItem[EVENT_MANAGER_CONST::TRAINING::SCRIPT] = script;
	trainingItem[EVENT_MANAGER_CONST::CLUSTER_CONFIGURATION::IS_SYNCHRONOUS] = isSynchronous;

	root[EVENT_MANAGER_CONST::TRAINING::TYPE] = trainingItem;
	auto nodeIter = std::begin(nodeInfoVector);
	while (nodeIter != std::end(nodeInfoVector))
	{
		auto processIter = std::begin((*nodeIter)->TrainingProcessVector);
		while (processIter != std::end((*nodeIter)->TrainingProcessVector))
		{
			Json::Value processItem;
			processItem[EVENT_MANAGER_CONST::PROCESS::JOB_NAME] = (*processIter)->jobName;
			processItem[EVENT_MANAGER_CONST::PROCESS::INDEX] = (*processIter)->index;
			processItem[EVENT_MANAGER_CONST::PROCESS::IP] = (*processIter)->ip;
			processItem[EVENT_MANAGER_CONST::PROCESS::PORT] = (*processIter)->port;

			processListItem.append(processItem);
			++processIter;
		}
		++nodeIter;
	}
	root[EVENT_MANAGER_CONST::PROCESS::TYPE] = processListItem;

	nodeIter = std::begin(nodeInfoVector);
	while (nodeIter != std::end(nodeInfoVector))
	{
		Json::StyledWriter writer;
		std::string str = writer.write(root);

		EventManager::getInstance()->writeData((*nodeIter)->fd, str.c_str());
		++nodeIter;
	}
}

Job* JobManager::findJob(int id)
{
	auto iter = std::begin(jobList);

	while (iter != std::end(jobList))
	{
		if ((*iter)->getId() == id)
		{
			return (*iter);
		}
		else
			++iter;
	}
	return nullptr;
}
void JobManager::showJobList()
{
	Log::d("[JobManager]", "Total Jobs: %d", this->jobList.size());
	auto iter = std::begin(jobList);

	while (iter != std::end(jobList))
	{
		Log::d("[JobManager]", " - id: %d", (*iter)->getId());
		++iter;
	}
}
