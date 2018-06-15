/*
 * CustomTask.cpp
 *
 *  Created on: Apr 4, 2018
 *      Author: tmax
 */

#ifndef CUSTOMTASK_H_
#define CUSTOMTASK_H_

#include "../frame/Task.h"
#include "../frame/Log.h"
#include <string>
#include "../frame/Event.h"
#include "../managers/SampleManager.h"
#include "../managers/SampleManager2.h"
//
//enum CUSTOMTASK_EVENT_TYPE {
//	EVENT_A = 2001,
//	EVENT_B = 2002,
//	EVENT_C = 2003
//};

//class CustomTask: public Task<CustomTask>{
class CustomTask: public Task{
public:
	const static int TASK_ID = 1001;
	const static int EVENT_A = 2001;
	const static int EVENT_B = 2002;
	const static int EVENT_C = 2003;

	Event *eventA;
	Event *eventB;
	Event *eventC;

private:
	bool isEventAChecked = false;
	bool isEventBChecked = false;
	bool isEventCChecked = false;
	bool isLockAcquisitionPassed = false;

public:
	CustomTask(Job* job);
	void main() override;
	void handleEvent(Event* evt) override;
};

#endif /* CUSTOMTASK_H_ */
