/**
 * Project Untitled
 */


#ifndef _JOB_H
#define _JOB_H

#include <vector>
using namespace std;

class Job {
public: 
	Job(unsigned int id, int targetStep, int owner);
	/**
	 * @param id
	 */
	unsigned int getId();
	/**
	 * @param owner
	 */
	void setOwner(int owner);
	int getOwner();
	/**
	 * @param status
	 */
	void setStatus(int status);
	void getStatus();
	
	/**
	 * @param loss
	 */
	void addLoss(float loss);
	
	void updateStep();

private: 
	unsigned int id;
	int owner;
	int status;
	int targetStep;
	int currentStep;
	vector<float> lossList;
};

#endif //_JOB_H
