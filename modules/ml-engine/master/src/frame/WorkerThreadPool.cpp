/*
 * WorkerThreadPool.cpp
 *
 *  Created on: Apr 4, 2018
 *      Author: tmax
 */

#include "WorkerThreadPool.h"

//WorkerThreadPool::WorkerThreadPool(int cnt, Pipe* emPipe) : workerCount(cnt), emPipe(emPipe)
//{
//    Worker* worker = nullptr;
//    for (std::size_t i = 0; i < workerCount; i++)
//    {
//        worker = new Worker(i);
//
//        idleWorkerQueue.push(i);
//        workerVector.push_back(worker);
//    }
//    Log::i("[WorkerThreadPool]", "%d workers are prepared",workerVector.size());
//
//}
WorkerThreadPool::WorkerThreadPool(int cnt) : workerCount(cnt)
{
    Worker* worker = nullptr;
    for (std::size_t i = 0; i < workerCount; i++)
    {
        worker = new Worker(i);

        idleWorkerQueue.push(i);
        workerVector.push_back(worker);
    }
    Log::i("[WorkerThreadPool]", "%d workers are prepared",workerVector.size());

}

WorkerThreadPool::~WorkerThreadPool()
{
    for (std::size_t i = 0; i < workerCount; i++)
    {
    	delete workerVector[i];
    }

}

Worker* WorkerThreadPool::findWorkerbyJobId(unsigned int jobId)
{
//	map<unsigned int, Worker*>::iterator iter;
//	iter = jobIdWorkerMap.find( jobId );
//	if ( iter == jobIdWorkerMap.end() )
//	{
//		// not found
//		std::cout << "[WorkerThreadPool] CAN NOT FIND MATCHING Worker... job id: " << jobId <<std::endl;
//		return nullptr;
//	} else {
//		// found
//		return (*iter).second;
//	}
//	for(int i = 0; i < jobIdWorkerPtrVector.size() ; i++)
//	{
//		std::pair<int, Worker*> part = jobIdWorkerPtrVector[i];
//		if(part.first == jobId)
//		{
////			std::cout << "[WorkerThreadPool] Found matching worker... job id: " << jobId <<std::endl;
//			return part.second;
//		}
//	}
//	return nullptr;
	auto iter = std::begin(jobIdWorkerPtrList);

	while (iter != std::end(jobIdWorkerPtrList))
	{
		if ((*iter).first == jobId)
			// Found matching worker
			return (*iter).second;
		else
			++iter;
	}
	return nullptr;
}
void WorkerThreadPool::setWorkerDone(unsigned int jobId)
{
	Worker* worker = findWorkerbyJobId(jobId);
	if (worker != nullptr)
	{
		setWorkerIdle(jobId, worker->getId());
	}
	// if available workers exist...
	if(!idleWorkerQueue.empty())
	{
		//run a remaining task
		if(remainingTaskList.size() > 0)
		{
			Task* task = remainingTaskList.front();
			remainingTaskList.pop_front();
			WorkerThreadPool::runTask(task);
		}
	}
}
void WorkerThreadPool::setWorkerSuspended(unsigned int jobId)
{
	Worker* worker = findWorkerbyJobId(jobId);
	if (worker != nullptr)
	{
		setWorkerIdle(jobId, worker->getId());

//		std::map<int, Worker*>::iterator iter = jobIdWorkerMap.begin();
//	    while ((iter = std::find_if(iter, jobIdWorkerMap.end(), jobId)) != jobIdWorkerMap.end())
//	    	jobIdWorkerMap.erase(iter++);

		Log::d("[WorkerThreadPool]","Push suspended task(Job#%d) into remainingTaskList", jobId);

        remainingTaskList.push_back(worker->getTask());
	}
}

//template<typename AnyTask>
//void WorkerThreadPool::runTask(Task<AnyTask>* task)
void WorkerThreadPool::runTask(Task* task)
{
 	// 해당 작업을 수행하는 Worker가 있는지 판단
	Worker* worker = findWorkerbyJobId(task->getJob()->getId());
	if (worker == nullptr)
	{
		// Available workers exist
		if(!idleWorkerQueue.empty())
		{
			// check if the task exists in remainingTaskList
			// 수행 Task가 Suspended Job일 경우 리스트에서 삭제
			auto iter = std::begin(remainingTaskList);
			while (iter != std::end(remainingTaskList))
			{
				if ((*iter)->getJob()->getId() == task->getJob()->getId())
				{
					// erase if it exists
					Log::d("[WorkerThreadPool]","remove from remainingTaskList %d", task->getJob()->getId() );
					iter = remainingTaskList.erase(iter);
				}
				else
				{
					++iter;
				}
			}

			worker = workerVector[idleWorkerQueue.front()];
			idleWorkerQueue.pop();

			Log::d("[WorkerThreadPool]","Start running task : %d", task->getJob()->getId() );
			Log::d("[WorkerThreadPool]","Worker id %d", worker->getId() );

			worker->setTask(task);
			Pipe* workerPipe = worker->getPipe();
			try
			{
				workerPipe->writePipe();

				// add jobId WorkerPtr pair in this list
//				jobIdWorkerPtrVector.push_back(std::make_pair(task->getJob()->getId(), worker));
				jobIdWorkerPtrList.push_back(std::make_pair(task->getJob()->getId(), worker));
			}
			catch (...)
			{
				std::cout<<"[TP]write Message error"<<std::endl;
			}
		}
		// No available workers
		else
		{
			Log::d("[WorkerThreadPool]", "No idle worker thread");
			Log::d("[WorkerThreadPool]", "Push Task(Job#%d) into remainingTaskList for later processing",task->getJob()->getId());

			remainingTaskList.push_back(task);
		}
	}
}

void WorkerThreadPool::setWorkerIdle (unsigned int jobId, int workerId)
{  
	auto iter = std::begin(jobIdWorkerPtrList);

	while (iter != std::end(jobIdWorkerPtrList))
	{
		if ((*iter).first == jobId)
		{
			iter = jobIdWorkerPtrList.erase(iter);
			break;
		}
		else
		{
			++iter;
		}
	}
//	auto iter = std::begin(jobIdWorkerPtrVector);
//
//	while (iter != std::end(jobIdWorkerPtrVector)) {
//		// Do some stuff
//		if ((*iter).first == jobId)
//			iter = jobIdWorkerPtrVector.erase(iter);
//		else
//			++iter;
//	}
	idleWorkerQueue.push(workerId);
}


int WorkerThreadPool::getWorkingThreadCount()
{
    return workerCount - idleWorkerQueue.size();
}

int WorkerThreadPool::getWaitingThreadCount()
{
    return idleWorkerQueue.size();
}
