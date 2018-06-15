/*
 * net_util.cpp
 *
 *  Created on: Apr 5, 2018
 *      Author: tmax
 */

#include "NetworkUtil.h"

int NetworkUtil::createSocket(int type)
{
	return socket(PF_INET, type, 0);
}

int NetworkUtil::startBinding(int fd, const char *pszAddr, unsigned short port)
{
	struct sockaddr_in addr;
	addr.sin_family = PF_INET;
	addr.sin_port = htons(port);
	if (!pszAddr || strcmp(pszAddr, "") == 0){
		addr.sin_addr.s_addr = INADDR_ANY;
	}
	else {
		addr.sin_addr.s_addr = inet_addr(pszAddr);
	}
	int f = -1;
	int len = sizeof(int);
	setsockopt(fd, SOL_SOCKET, SO_REUSEADDR, &f, len);
	return bind(fd, (const struct sockaddr *)&addr, sizeof addr);
}

int NetworkUtil::startListening(int fd, int backlog)
{
	return listen(fd, backlog);
}

bool NetworkUtil::setNonBlock(int fd)
{
	int flags = fcntl(fd, F_GETFL) || O_NONBLOCK ;
	return fcntl(fd, F_SETFL, flags) == 0;
}

void NetworkUtil::setSocketBuffSize(int fd, int nRcvBuffSize, int nSndBuffSize)
{
	setsockopt(fd, SOL_SOCKET, SO_RCVBUF, (const int *)&nRcvBuffSize, sizeof(int));
	setsockopt(fd, SOL_SOCKET, SO_SNDBUF, (const int *)&nSndBuffSize, sizeof(int));
}

int NetworkUtil::startConnection(int fd, const char *pszAddr, unsigned short port)
{
	struct sockaddr_in addr;
	memset(&addr, 0x00, sizeof addr);
	addr.sin_family = PF_INET;
	addr.sin_port = htons(port);
	addr.sin_addr.s_addr = inet_addr(pszAddr);

	return connect(fd, (struct sockaddr *)&addr, sizeof addr);
}

int NetworkUtil::startAcception(int fd)
{
	struct sockaddr_in other_addr;
	socklen_t len;
	return accept(fd, (struct sockaddr *)&other_addr, &len);
}

std::string NetworkUtil::getIPAddress()
{
	std::string ipAddress="Unable to get IP Address";
	struct ifaddrs *interfaces = NULL;
	struct ifaddrs *temp_addr = NULL;
	int success = 0;
	// retrieve the current interfaces - returns 0 on success
	success = getifaddrs(&interfaces);
	if (success == 0) {
		// Loop through linked list of interfaces
		temp_addr = interfaces;
		while(temp_addr != NULL) {
			if(temp_addr->ifa_addr->sa_family == AF_INET) {
				// Check if interface is en0 which is the wifi connection on the iPhone
				if(strcmp(temp_addr->ifa_name, "en0")){
					ipAddress=inet_ntoa(((struct sockaddr_in*)temp_addr->ifa_addr)->sin_addr);
				}
			}
			temp_addr = temp_addr->ifa_next;
		}
	}
	// Free memory
	freeifaddrs(interfaces);
	return ipAddress;
}
int NetworkUtil::getOpenPorts(int num, std::vector<int> &vec)
{
	int foundCount = 0;
	struct sockaddr_in addr;
	addr.sin_family       = AF_INET;
	addr.sin_addr.s_addr  = htonl( INADDR_LOOPBACK );
	bool bTCP = false;

	for( unsigned int nPort = 8000; nPort < 65536; nPort++)
	{
		//udp uses SOCK_DGRAM, tcp uses SOCK_STREAM
		int fd = socket( AF_INET,  (bTCP?SOCK_STREAM:SOCK_DGRAM) , 0);
		if ( fd != -1 )
		{
			addr.sin_port = htons( nPort );
			if ( bind( fd, (const struct sockaddr *)&addr, sizeof addr ) == 0 )
			{
				if(foundCount < num)
				{
					vec.push_back(nPort);
					foundCount++;
				}
				else
				{
					break;
				}
			}
		}
		close(fd);
	}
}
