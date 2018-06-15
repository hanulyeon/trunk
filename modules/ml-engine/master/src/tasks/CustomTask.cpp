/*
 * CustomTask.cpp
 *
 *  Created on: Apr 4, 2018
 *      Author: tmax
 */

#include "CustomTask.h"


CustomTask::CustomTask(Job* job){
	this->setJob(job);

	eventA = new Event(EVENT_A, job);
	eventB = new Event(EVENT_B, job);
	eventC = new Event(EVENT_C, job);
}
void CustomTask::main(){
	if (isEventAChecked == false){
		Log::d("[CustomTask]", "Not checked Event A %d", getJob()->getId());
		SampleManager* mng = SampleManager::getInstance();
		if( mng->acquireLock( this->getJob() ) ){
			Log::d("[CustomTask]", "starting Subroutine A %d", getJob()->getId());
			mng->doSomething();
			mng->releaseLock();

			// TODO
			// TEST CODE: This event should come from outside
			this->handleEvent(eventA);
			// need to be replaced in other way

			Log::d("[CustomTask]", "finishing Subroutine A %d", getJob()->getId());
		}else{
			Log::d("[CustomTask]", "Lock acquisition for Subroutine A failed %d", getJob()->getId());
		}
	}else{
		Log::d("[CustomTask]", "Event A passed %d", getJob()->getId());
	}
	if (isEventBChecked == false && isEventAChecked == true){
		Log::d("[CustomTask]", "Not checked Event B %d", getJob()->getId());
		SampleManager2* mng = SampleManager2::getInstance();
		if(mng->acquireLock( this->getJob() ) ){
			Log::d("[CustomTask]", "starting Subroutine B %d", getJob()->getId());
			mng->doSomething();
			mng->releaseLock();
			this->handleEvent(eventB);
			Log::d("[CustomTask]", "finishing Subroutine B %d", getJob()->getId());
		}else{
			Log::d("[CustomTask]", "Lock acquisition for Subroutine B failed %d", getJob()->getId());
		}
	}else{
		Log::d("[CustomTask]", "Event B passed %d", getJob()->getId());
	}
	if (isEventAChecked && isEventBChecked){
		Log::i("[CustomTask]", "Task(Job %d) finished!!", getJob()->getId());
		this->setTaskFinished(true);
	}
}
void CustomTask::handleEvent(Event* evt) {
	if (evt->type == eventA->type){
		isEventAChecked = true;
	}else if (evt->type == eventB->type){
		isEventBChecked = true;
	}else if (evt->type == eventC->type){
		isEventCChecked = true;
	}else if (evt->type == Event::LOCK_RELEASE_EVENT){
		isLockAcquisitionPassed = true;
	}
	Log::d("[CustomTask]", "handleEvent event type %d", evt->type);
}

