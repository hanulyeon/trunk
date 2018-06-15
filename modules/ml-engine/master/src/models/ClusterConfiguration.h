/**
 * Project Untitled
 */


#ifndef _CLUSTERCONFIGURATION_H
#define _CLUSTERCONFIGURATION_H


#include <string>
using namespace std;

class ClusterConfiguration {
public: 
	int clusterSize;
	int psNum;
	int workerNum;
//	int gpuNum;
	bool isSynchronous;
//	string* psHostList;
//	string* workerHostList;
};

#endif //_CLUSTERCONFIGURATION_H
