/*
 * FlowEngine.h
 *
 *  Created on: Jun 1, 2018
 *      Author: tmax
 */

#ifndef TRUNK_ML_ENGINE_TEST_FLOWENGINE_H_
#define TRUNK_ML_ENGINE_TEST_FLOWENGINE_H_

#include "../../../master/src/frame/DynamicSingleton.h"
#include "../../../master/src/frame/Log.h"
#include "../../../master/src/utils/json/json.h"

#include <thread>
#include <vector>

#include <cstdio>
#include <cstdlib>
#include <cstring>
#include <unistd.h>
#include <arpa/inet.h>
#include <sys/types.h>
#include <sys/socket.h>


#define BUFSIZE 512


class FlowEngine :public DynamicSingleton<FlowEngine>{
protected:
    ~FlowEngine();
public :

	bool setConfiguration(const char* targetIp, int targetPort);
	bool start();
private:
    static void sendMessage(int socketFd);
    static void recvMessage(int socketFd);

private :
	bool running;
	int socketFd;
	struct sockaddr_in serv_addr;
	std::thread sendThread, receiveThread;
	void* thread_result;
};

#endif /* TRUNK_ML_ENGINE_TEST_FLOWENGINE_H_ */

