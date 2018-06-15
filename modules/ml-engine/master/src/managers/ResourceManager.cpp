/**
 * Project Untitled
 */


#include "ResourceManager.h"

/**
 * ResourceManager implementation
 */


/**
 * @param owner
 */
ResourceInfo* ResourceManager::requestProvision(int owner, Job* job, int clusterSize, int psNum, int workerNum)
{
	//TODO:
	// real way to communicate to IaaS master

	// IaaS마스터로부터 Response 메시지가 도착해야 리소스 생성작업이 완료된것으로 처리하지만
	// IaaS마스터 통신부가 추상화되어 있으므로 그냥 자체적으로 통과시킴

	// Send job, owner, clusterSize

	// Request ->  Resource - node 	- training process
	//								- training process
	//						- node	- training process
	//						- ...
	ResourceInfo* resource = new ResourceInfo(owner, job);
	resourceList.push_back(resource);

	// role <jobName, index>
	deque<std::pair<string,int>> role;
	int trainingProcessCountPerNode = (psNum + workerNum)/clusterSize;

	for(int psCount = 0 ; psCount < psNum; psCount++)
	{
		role.push_back(std::make_pair(EVENT_MANAGER_CONST::TRAINING::PS, psCount));
	}
	for(int workerCount = 0 ; workerCount < workerNum; workerCount++)
	{
		role.push_back(std::make_pair(EVENT_MANAGER_CONST::TRAINING::WORKER, workerCount));
	}

	for(int nodeCount = 0; nodeCount < clusterSize; nodeCount++)
	{
		ResourceInfo::NodeInfo* info = resource->addNode(nodeCount, /* this should be set later */-1);

		for(int trainingProcessCount = 0; trainingProcessCount < trainingProcessCountPerNode; trainingProcessCount++)
		{
			info->TrainingProcessVector.push_back(new TrainingProcess(role.front().second, role.front().first, "", -1));
			role.pop_front();
		}
	}
	// o 프로세스가 균일하게 나누어 떨어지지 않을 경우, 마지막 노드에 나머지 할당
	if((trainingProcessCountPerNode * clusterSize) != (psNum + workerNum))
	{
		int restCount = (psNum + workerNum) - (trainingProcessCountPerNode * clusterSize);
		if(restCount < 0)
		{
			Log::w("[ResourceManager]", "training process count error");
		}
		else
		{
			for(int count = 1; count <= restCount; count++)
			{
				resource->getNode(count)->TrainingProcessVector.push_back(
						new TrainingProcess(role.front().second + count, role.front().first, "", -1));
				role.pop_front();
			}
		}
	}

	return resource;
}
//
//void ResourceManager::addNode(int owner, Job* job, int index, int fd)
//{
//	ResourceInfo* resource = new ResourceInfo(owner, job);
//	resource->addNode(index, fd);
//
//	resourceList.push_back(resource);
//}
/**
 * @param owner
 */
bool ResourceManager::releaseResource(int owner, Job* job)
{
	auto iter = std::begin(resourceList);

	while (iter != std::end(resourceList))
	{
		if ((*iter)->owner == owner && (*iter)->job->getId() == job->getId() )
		{
			// TODO
			// o 딜리트 먼저인지 리무브 먼저인지 명확지 않음...
			// o 리소스 해제 방법 리소스 인스턴스 자체를 전달해서 지울 수 있음 방법 고안 필요
			delete (*iter);
			resourceList.remove(*iter);
			return true;
		}
		else
		{
			++iter;
		}
	}

	return false;
}

/**
 * @param owner
 */
ResourceInfo* ResourceManager::getResourceInfo(int owner, Job* job)
{
	auto iter = std::begin(resourceList);

	while (iter != std::end(resourceList))
	{
		if ((*iter)->owner == owner && (*iter)->job->getId() == job->getId() )
			return (*iter);
		else
			++iter;
	}
	return nullptr;
}
