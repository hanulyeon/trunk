/**
 * Project Untitled
 */


#include "InputData.h"

InputData::InputData(int jobId){
	this->jobId = jobId;
}
int InputData::getJobId(){
	return this->jobId;
}
void InputData::append(MetaData* meta){
	this->metaList.push_back(meta);
	this->checkList.push_back(false);
	cout << " job: "<< this->jobId << ", size of list: " << this->metaList.size() << endl;
}
MetaData* InputData::readMetaDataWithOption(bool isSeq){

	switch (isSeq) {
		case true:
			for(int i = 0; i < this->checkList.size(); i++){
				if(false == this->checkList[i]){
					this->checkList[i] = true;
					return this->metaList[i];
				}
			}
			this->checkList.assign(false, this->checkList.size());
			this->checkList.at(0) = true;
			return  this->metaList[0];
			break;
		case false:
			break;
		default:
			break;
	}
}
void InputData::deleteAllMeta(){
	vector<MetaData*>::iterator iter;

	for(iter = this->metaList.begin(); iter != this->metaList.end(); iter++) {
		delete (*iter);
	}
}
