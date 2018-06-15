/*
 * Event.h
 *
 *  Created on: Apr 4, 2018
 *      Author: tmax
 */

#ifndef EVENT_H_
#define EVENT_H_

#include <iostream>
#include <cstring>
#include "Job.h"
#include "../utils/json/json.h"

class Event
{
public:
	const static int TASK_FINISH_EVENT 				= 1000;
	const static int TASK_SUSPENDED_EVENT			= 1001;
	const static int LOCK_RELEASE_EVENT 			= 1002;
	const static int NETWORK_RESPONSE_SUCCESS_EVENT	= 1003;
	const static int NETWORK_RESPONSE_FAIL_EVENT	= 1004;
	Json::Value jsonObject;
	int type = 0;
	Job* job;
	Event(int type, Job* job)
	{
		this->type = type;
		this->job = job;
		this->jsonObject;
	};
	Event(int type, Job* job, const Json::Value& jsonObject)
	{
		this->type = type;
		this->job = job;
		this->jsonObject.copy(jsonObject);
	};
/*	Event(int type, Job* job, const char* message)
	{
		this->type = type;
		this->job = job;
		this->message = new char[strlen(message) - 1];
		strcpy(this->message, message);
	};
	~Event()
	{
		if(message != nullptr)
			delete message;
	}*/
};


#endif /* EVENT_H_ */
