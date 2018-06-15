/**
 * Project Untitled
 */


#ifndef _SCRIPT_H
#define _SCRIPT_H


#include <string>
#include "BaseAlgorithm.h"
using namespace std;

class Script {
public:
	/**
	 * @param libs
	 */
	void addLibrary(string* libs);
	
	/**
	 * @param algorithm
	 */
	void setAlgorithm();
public:
	string program;

	int pixelSize;
	int trainingSteps;
	int hiddenUnits;
	int batchSize;
	int learningRate;
private: 

	string libraryList;
	BaseAlgorithm algorithm;
};

#endif //_SCRIPT_H
