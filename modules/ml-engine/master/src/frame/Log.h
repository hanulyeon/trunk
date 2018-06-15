/*
 * Log.h
 *
 *  Created on: May 15, 2018
 *      Author: tmax
 */

#ifndef LOG_H_
#define LOG_H_


#include <iostream>
#include <cstdarg>
#include <fstream>
#include <string>

class Log
{
private:
	const static int isDebug = true;
public:
	static void d(const char* pre, const char * format, ...)
	{
		if(isDebug)
		{
		    char* sMessage = NULL;
		    int nLength = 0;
		    va_list args;
		    va_start(args, format);
		    //  Return the number of characters in the string referenced the list of arguments.
		    // _vscprintf doesn't count terminating '\0' (that's why +1)
		    nLength = _vscprintf(format, args) + 1;
		    sMessage = new char[nLength];
//		    vsprintf_s(sMessage, nLength, format, args);
		    vsprintf(sMessage, format, args);

		    std::cout << "[Debug]"<< pre << " " << sMessage << std::endl;

		    va_end(args);

		    delete [] sMessage;
		}
	}
	static void i(const char* pre, const char * format, ...)
	{
		char* sMessage = NULL;
		int nLength = 0;
		va_list args;
		va_start(args, format);
		nLength = _vscprintf(format, args) + 1;
		sMessage = new char[nLength];
		vsprintf(sMessage, format, args);

		std::cout << "[Info]"<< pre << " " << sMessage << std::endl;

		va_end(args);

		delete [] sMessage;
	}
	static void w(const char* pre, const char * format, ...)
	{
		char* sMessage = NULL;
		int nLength = 0;
		va_list args;
		va_start(args, format);
		nLength = _vscprintf(format, args) + 1;
		sMessage = new char[nLength];
		vsprintf(sMessage, format, args);

		std::cout << "[Warning]"<< pre << " " << sMessage << std::endl;

		va_end(args);

		delete [] sMessage;
	}
private:
	 static int _vscprintf (const char * format, va_list pargs) {
	      int retval;
	      va_list argcopy;
	      va_copy(argcopy, pargs);
	      retval = vsnprintf(NULL, 0, format, argcopy);
	      va_end(argcopy);
	      return retval;
	   }
};

#endif /* EVENT_H_ */
