//============================================================================
// Name        : frame.cpp
// Author      : saemaro_moon
// Version     :
// Copyright   : tmax
//============================================================================
#include <iostream>
#include <cstdlib>
#include <sstream>

#include "../controllers/Client.h"
using namespace std;

int main(int argc, const char **argv) {
	unsigned int jobId;

	cout << "Client Test" << endl;

	if(argc != 6)
	{
		printf("Usage : %s <target ip> <target port> <job id> <node index> <process num>\n", argv[0]);
		exit(1);
	}
	printf("JOB: %s\n", argv[3]);
	printf("IP: %s\n", argv[1]);
	printf("PORT: %s\n", argv[2]);
	printf("NODE INDEX: %s\n", argv[4]);
	printf("TP NUM: %s\n", argv[5]);


	Client *client = Client::getInstance();
	stringstream strValue;
	strValue << argv[3];
	strValue >> jobId;

	if(client->setConfiguration(jobId, argv[1], atoi(argv[2]), atoi(argv[4]), atoi(argv[5])))
	{
		client->start();
	}

	printf("done");
	return 0;
}
