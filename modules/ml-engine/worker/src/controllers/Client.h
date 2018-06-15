/*
 * Client.h
 *
 *  Created on: Apr 4, 2018
 *      Author: tmax
 */

#ifndef CLIENT_H_
#define CLIENT_H_


#include <thread>
#include <vector>
#include <cstdio>
#include <cstdlib>
#include <cstring>
#include <fstream>
#include <unistd.h>
#include <arpa/inet.h>
#include <sys/types.h>
#include <sys/socket.h>

#include "ClientConst.h"
#include "ProcessManager.h"

#include "../../../master/src/frame/Log.h"
#include "../../../master/src/utils/json/json.h"
#include "../../../master/src/utils/NetworkUtil.h"
#include "../../../master/src/frame/DynamicSingleton.h"
#include "../../../master/src/frame/EventManagerConst.h"



#define BUFSIZE 512


class Client :public DynamicSingleton<Client>
{
protected:
    ~Client();
public :

	bool start();
	bool setConfiguration(unsigned int jobId, const char* targetIp, int targetPort, int nodeIndex, int tpNum);
private:
    static void recvMessage(int socketFd);
    static void sendMessage(int socketFd, unsigned int jobId, int nodeIndex, int tpNum);

private :
    unsigned int jobId;
    int nodeIndex;
    int tpNum;
	bool running;
	int socketFd;
	struct sockaddr_in serv_addr;
	std::thread sendThread, receiveThread;
	void* thread_result;
};

#endif /* CLIENT_H_ */
