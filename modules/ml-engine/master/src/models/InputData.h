/**
 * Project Untitled
 */


#ifndef _INPUTDATA_H
#define _INPUTDATA_H


#include "MetaData.h"
#include <vector>
#include <iostream>

using namespace std;

class InputData{
public:
	InputData(int jobId);

	int getJobId();
	void append(MetaData* meta);
	MetaData* readMetaDataWithOption(bool isSeq);
	void deleteAllMeta();

private:
	int jobId;
	vector<MetaData*> metaList;
	vector<bool> checkList;
};

#endif //_JOB_H
