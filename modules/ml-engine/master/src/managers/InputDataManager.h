/**
 * Project Untitled
 */


#ifndef _INPUTDATAMANAGER_H
#define _INPUTDATAMANAGER_H

#include "models/MetaData.h"
#include "models/InputData.h"
#include <vector>
#include <iostream>
using namespace std;

class InputDataManager {
public: 
	
	/**
	 * @param jobId
	 * @param random
	 */
	MetaData* getMetaDataWithJobId(int jobId, bool isSeq);
	
	/**
	 * @param jobId
	 * @param data
	 */
	void putMetaDataWithJobId(int jobId, MetaData* data);
	
	/**
	 * @param jobId
	 */
	void assignJob(int jobId);
	
	/**
	 * @param jobId
	 */
	void removeJob(int jobId);
private: 
	vector<InputData*> inputDataList;
	
	/**
	 * @param jobId
	 */
	InputData* findInputDatabyJobId(int jobId);
};

#endif //_INPUTDATAMANAGER_H
