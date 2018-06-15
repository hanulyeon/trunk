/*
 * SampleManager.cpp
 *
 *  Created on: Apr 5, 2018
 *      Author: tmax
 */

#include "SampleManager.h"



void SampleManager::doSomething(){
	std::cout << "[SampleManager] doing something... " << std::endl;
	usleep(8000);
	std::cout << "[SampleManager] done doing something... " << std::endl;
}
