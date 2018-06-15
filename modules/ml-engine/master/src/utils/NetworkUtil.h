/*
 * net_util.h
 *
 *  Created on: Apr 5, 2018
 *      Author: tmax
 */




#ifndef NETWORKUTIL_H_
#define NETWORKUTIL_H_

#include <sys/types.h>
#include <sys/socket.h>
#include <unistd.h>
#include <fcntl.h>
#include <arpa/inet.h>
#include <cstdio>
#include <ifaddrs.h>
#include <cstring>
#include <vector>
#include <string>

#define ERROR_PRINT(x) \
		printf("desc=%s,file=%s,line=%d,errno=%d,err=%s\n", x, __FILE__, __LINE__, errno, strerror(errno));

class NetworkUtil
{
public:
	static int createSocket(int type);
	static int startBinding(int fd, const char *pszAddr, unsigned short unPort);
	static int startListening(int fd, int backlog);
	static bool setNonBlock(int fd);
	static void setSocketBuffSize(int fd, int nRcvBuffSize, int nSndBuffSize);
	static int startConnection(int fd, const char *pszAddr, unsigned short port);
	static int startAcception(int fd);
	static std::string getIPAddress();
	static int getOpenPorts(int num, std::vector<int> &vec);
};


#endif // NETWORKUTIL_H_
