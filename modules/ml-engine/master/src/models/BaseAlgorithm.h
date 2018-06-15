/**
 * Project Untitled
 */


#ifndef _BASEALGORITHM_H
#define _BASEALGORITHM_H

#include <string>
using namespace std;

class BaseAlgorithm {
public: 
	
	/**
	 * @param name
	 */
	void setAlgorithmName(string name);
	
	/**
	 * @param steps
	 */
	void setStepSize(int steps);
	
	/**
	 * @param size
	 */
	void setMiniBatchSize(int size);
	
	void getAlgorithmName();
	
	void getStepSize();
	
	void getMiniBatchSize();
private: 
	int stepSize;
	int miniBatchSize;
	string algorithmName;
};

#endif //_BASEALGORITHM_H
