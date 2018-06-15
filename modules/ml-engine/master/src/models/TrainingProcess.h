/*
 * TrainingProcess.h
 *
 *  Created on: May 29, 2018
 *      Author: tmax
 */

#ifndef _TRAININGPROCESS_H_
#define _TRAININGPROCESS_H_

#include <string>

class TrainingProcess {
public:
	TrainingProcess(int index, std::string jobName, std::string ip, int port):
		index(index), jobName(jobName), ip(ip), port(port){};

public:
	int index;
	std::string jobName;
	std::string ip;
	int port;
};

#endif /* _TRAININGPROCESS_H_ */
