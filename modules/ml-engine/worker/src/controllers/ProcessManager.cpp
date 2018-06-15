/*
 * ProcessManager.cpp
 *
 *  Created on: May 30, 2018
 *      Author: tmax
 */

#include "../controllers/ProcessManager.h"


int ProcessManager::runCommand(const char* cmd)
{
	pid_t pid = execute(cmd);

	// only parent process is expected to access here
	this->processVector.push_back(pid);

	return pid;
}
// returns child's process id
pid_t ProcessManager::execute(const char* args)
{
	pid_t pid = fork();

	std::vector<std::string> wordsVector;
	switch( pid )
	{
	case -1:
		perror( "[fork-exec-test] fork failed" );
		return PROCESS_EXECUTION_FAIL;
		break;
	case 0:
		// only child process is expected to access here
		// the program should receive its own command as argv[0]

		split(std::string(args), " ", wordsVector);

		execlp("python", "python", "job.py",
				wordsVector.at(0).c_str(),
				wordsVector.at(1).c_str(),
				wordsVector.at(2).c_str(),
				wordsVector.at(3).c_str(), NULL );
		// should't return
		perror( "[fork-exec-test] exec failed" );
		exit( EXIT_FAILURE );
		break;

	default:
		break;
	}

	return pid;
}
void ProcessManager::split(const std::string& str, const std::string& delim, std::vector<std::string> &tokens)
{
	size_t prev = 0, pos = 0;
	do
	{
		pos = str.find(delim, prev);
		if (pos == std::string::npos) pos = str.length();
		std::string token = str.substr(prev, pos-prev);
		if (!token.empty()) tokens.push_back(token);
		prev = pos + delim.length();
	}
	while (pos < str.length() && prev < str.length());
}

//std::string ProcessManager::runCommand(const char* cmd)
//{
//	std::array<char, 128> buffer;
//	std::string result;
//	std::shared_ptr<FILE> pipe(popen(cmd, "r"), pclose);
//	if (!pipe) throw std::runtime_error("popen() failed!");
//	while (!feof(pipe.get()))
//	{
//		if (fgets(buffer.data(), 128, pipe.get()) != nullptr)
//		{
//			Log::d("[ProcessManager]", "%s", buffer.data());
//			result += buffer.data();
//		}
//	}
//	return result;
//}
