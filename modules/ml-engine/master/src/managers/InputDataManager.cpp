/**
 * Project Untitled
 */


#include "InputDataManager.h"

/**
 * InputDataManager implementation
 */


/**
 * @param jobId
 * @param random
 */
MetaData* InputDataManager::getMetaDataWithJobId(int jobId, bool isSeq) {
	return (findInputDatabyJobId(jobId))->readMetaDataWithOption(isSeq);
}

/**
 * @param jobId
 * @param data
 */
void InputDataManager::putMetaDataWithJobId(int jobId, MetaData* data) {
	(findInputDatabyJobId(jobId))->append(data);
}

/**
 * @param jobId
 */
void InputDataManager::assignJob(int jobId) {
	InputData* inputData = new InputData(jobId);
	this->inputDataList.push_back(inputData);
}

/**
 * @param jobId
 */
void InputDataManager::removeJob(int jobId) {
	vector<InputData*>::iterator iter;

	for(iter = this->inputDataList.begin(); iter != this->inputDataList.end(); iter++) {
	    if(jobId == (*iter)->getJobId()){
	    	(*iter)->deleteAllMeta();
	    	if(this->inputDataList.size() == 1){
	    		this->inputDataList.clear();
	    		break;
	    	}else{
	    		this->inputDataList.erase(iter);
	    	}
	    }
	}
	cout << "size of inputDataList" << this->inputDataList.size() << endl;
}

/**
 * @param jobId
 */
InputData* InputDataManager::findInputDatabyJobId(int jobId) {
	vector<InputData*>::iterator iter;

	for(iter = this->inputDataList.begin(); iter != this->inputDataList.end(); iter++) {
	    if(jobId == (*iter)->getJobId()){
			return (*iter);
		}
	}
	return NULL;
}
