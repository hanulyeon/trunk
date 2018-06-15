/**
 * Project Untitled
 */


#ifndef _METADATA_H
#define _METADATA_H

#include <string>
using namespace std;

struct MetaData {
	string fileLocation;
	string fileName;
	MetaData(string fileLocation, string fileName){
		this->fileLocation = fileLocation;
		this->fileName = fileName;
	}
};

#endif //_METADATA_H
