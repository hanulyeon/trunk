//============================================================================
// Name        : frame.cpp
// Author      : saemaro_moon
// Version     :
// Copyright   : tmax
//============================================================================
#include "../frame/EventManager.h"
#include "../managers/SampleManager.h"
#include "../managers/SampleManager2.h"
#include "../managers/JobManager.h"

#include <iostream>
using namespace std;

int main() {
	cout << "EventManager Test" << endl;

	EventManager *em = EventManager::getInstance();
	JobManager *jobManager = JobManager::getInstance();
    SampleManager *mng = SampleManager::getInstance();
    SampleManager2 *mng2 = SampleManager2::getInstance();

    em->setThreadCount(3);

    em->runService("127.0.0.1", 9999);


	return 0;
}
