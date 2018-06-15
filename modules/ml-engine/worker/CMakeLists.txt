cmake_minimum_required(VERSION 3.8)

project(ml-engine-worker)

include_directories(.)
include_directories($ENV{LD_LIB_PATH}) 

set(CMAKE_CXX_STANDARD 11)
set(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -std=c++11")
  

set(SOURCE_FILES 
		src/tests/main.cpp
		src/controllers/Client.cpp
		src/controllers/ProcessManager.cpp
		
		../master/src/models/TrainingProcess.h
		../master/src/utils/jsoncpp.cpp 
		../master/src/utils/NetworkUtil.cpp
)

set(IPADDR_FILES 
		src/tests/ipaddr_test.cpp
		../master/src/utils/NetworkUtil.cpp
)

link_directories($ENV{LD_LIB_PATH}) 


add_executable(testWorker ${SOURCE_FILES}) 
add_executable(testIpaddr ${IPADDR_FILES}) 

 
target_link_libraries(testWorker pthread rt) 
 
