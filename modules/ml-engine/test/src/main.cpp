/*
 * main.cpp
 *
 *  Created on: Jun 1, 2018
 *      Author: tmax
 */


#include <iostream>
#include <cstdlib>
#include <sstream>

#include "flowengine/FlowEngine.h"
using namespace std;

int main(int argc, const char **argv) {
	unsigned int jobId;

	cout << "FlowEngine Test" << endl;

	if(argc != 3)
	{
		printf("Usage : %s <target ip> <target port>\n", argv[0]);
		exit(1);
	}
	printf("IP: %s\n", argv[1]);
	printf("PORT: %s\n", argv[2]);


	FlowEngine *client = FlowEngine::getInstance();
	stringstream strValue;
	strValue << argv[3];
	strValue >> jobId;

	if(client->setConfiguration(argv[1], atoi(argv[2])))
	{
		client->start();
	}

	printf("done");
	return 0;
}

