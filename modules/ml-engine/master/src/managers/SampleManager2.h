/*
 * SampleManager2.h
 *
 *  Created on: Apr 5, 2018
 *      Author: tmax
 */


#ifndef _SAMPLEMANAGER2_H
#define _SAMPLEMANAGER2_H

#include "../frame/Module.h"
#include "../frame/DynamicSingleton.h"
#include <unistd.h>
#include <iostream>

class SampleManager2: public Module, public DynamicSingleton<SampleManager2>
{
public:
	void doSomething();
};


#endif
