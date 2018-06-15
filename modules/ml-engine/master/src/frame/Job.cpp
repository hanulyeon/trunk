/**
 * Project Untitled
 */


#include "Job.h"

/**
 * Job implementation
 */

Job::Job(unsigned int id, int targetStep, int owner){
	this->id = id;
	this->targetStep = targetStep;
	this->owner = owner;
}
/**
 * @param id
 */
unsigned int Job::getId() {
	return this->id;
}
/**
 * @param owner
 */
void Job::setOwner(int owner)
{
	this->owner = owner;
}
int Job::getOwner()
{
	return this->owner;
}
/**
 * @param status
 */
void Job::setStatus(int status) {

}

void Job::getStatus() {

}

/**
 * @param loss
 */
void Job::addLoss(float loss) {

}

void Job::updateStep() {

}

