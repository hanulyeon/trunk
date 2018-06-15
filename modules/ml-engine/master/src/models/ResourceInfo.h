/**
 * Project Untitled
 */


#ifndef _RESOURCEINFO_H
#define _RESOURCEINFO_H

#include <string>
#include <vector>

#include "TrainingProcess.h"

using namespace std;

class ResourceInfo
{
public:
	ResourceInfo(int owner, Job* job) : owner(owner), job(job) {}
	~ResourceInfo()
	{
		clearMemory();
	}
	struct NodeInfo
	{
		int idex;
		int fd;
		vector<TrainingProcess*> TrainingProcessVector;
		NodeInfo(int idex, int fd) : idex(idex), fd(fd) {}
	};
	NodeInfo* addNode(int index, int fd)
	{
		NodeInfo* info = new NodeInfo(index, fd);
		NodeInfoVector.push_back(info);

		return info;
	}
	NodeInfo* getNode(int index)
	{
		auto iter = std::begin(NodeInfoVector);

		while (iter != std::end(NodeInfoVector))
		{
			if((*iter)->idex == index)
				return (*iter);
			++iter;
		}
		return nullptr;
	}
	vector<NodeInfo*> getNodeInfoVector(){
		return NodeInfoVector;

	}
private:
	void clearMemory()
	{
		// 모든 요소마다 일일이 지워줘야 데이터삭제됨
		auto nodeIter = std::begin(NodeInfoVector);

		while (nodeIter != std::end(NodeInfoVector))
		{
			// 모든 요소마다 일일이 지워줘야 데이터삭제됨
			auto processIter = std::begin((*nodeIter)->TrainingProcessVector);

			while (processIter != std::end((*nodeIter)->TrainingProcessVector))
			{
				delete (*processIter);
				(*nodeIter)->TrainingProcessVector.erase(processIter);
			}

			// iter 지워주면서 자동으로 vector 크기 줄음
			// No need to do 'iter++'
			delete (*nodeIter);
			// erase 전에 반드시 delete먼저 수행해야함
			NodeInfoVector.erase(nodeIter);
		}
	}
public:
	int owner;
	Job* job;
	vector<NodeInfo*> NodeInfoVector;

};

#endif //_RESOURCEINFO_H
