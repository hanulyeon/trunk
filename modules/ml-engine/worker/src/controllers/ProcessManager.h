/*
 * ProcessManager.h
 *
 *  Created on: May 30, 2018
 *      Author: tmax
 */

#ifndef TRUNK_ML_ENGINE_WORKER_SRC_CONTROLLERS_PROCESSMANAGER_H_
#define TRUNK_ML_ENGINE_WORKER_SRC_CONTROLLERS_PROCESSMANAGER_H_

#include <unistd.h>

#include <array>
#include <cstdio>
#include <memory>
#include <string>
#include <vector>
#include <iostream>
#include <iterator>
#include <stdexcept>

#include "../../../master/src/frame/Log.h"
#include "../../../master/src/frame/DynamicSingleton.h"

class ProcessManager:public DynamicSingleton<ProcessManager>
{
public:
	const static int PROCESS_EXECUTION_FAIL = -1;
public:
	int runCommand(const char* cmd);
private:
	pid_t execute(const char* cmd);
	void split(const std::string& str, const std::string& delim, std::vector<std::string> &tokens);
private:
	std::vector<int> processVector;
};

#endif /* TRUNK_ML_ENGINE_WORKER_SRC_CONTROLLERS_PROCESSMANAGER_H_ */
