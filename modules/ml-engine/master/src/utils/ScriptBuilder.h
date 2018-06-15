/**
 * Project Untitled
 */


#ifndef _SCRIPTBUILDER_H
#define _SCRIPTBUILDER_H

#include <string>
using namespace std;

#include "../models/Script.h"
#include "../models/ClusterConfiguration.h"

class ScriptBuilder {
public:
	ScriptBuilder();
	/**
	 * @param script
	 */
	string build(Script* script);
	string build(string content);
private: 
	string content;
	
	string test;
	/**
	 * @param config
	 */
	void addModules(Script* script);
	void addConfiguration(Script* script);
	void addMainFunction(Script* script);
	void addReturnStatement(Script* script);
	void setClusterConfiguration(ClusterConfiguration config);
};

#endif //_SCRIPTBUILDER_H
