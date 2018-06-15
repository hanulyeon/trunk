/*
 * SampleManager.h
 *
 *  Created on: Apr 5, 2018
 *      Author: tmax
 */


#ifndef _SAMPLEMANAGER_H
#define _SAMPLEMANAGER_H

#include "../frame/Module.h"
#include "../frame/DynamicSingleton.h"
#include <unistd.h>
#include <iostream>

class SampleManager: public Module, public DynamicSingleton<SampleManager>
{
public:
	void doSomething();
};


#endif
