cmake_minimum_required(VERSION 3.8)

project(ml-engine-worker)

include_directories(.)
include_directories($ENV{GTEST_INC_PATH})
include_directories($ENV{BOOST_INC_PATH})
include_directories($ENV{LD_LIB_PATH}) 

set(CMAKE_CXX_STANDARD 11)
set(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -std=c++11")
  

set(SOURCE_FILES 
		src/flowengine/FlowEngine.cpp  
		
		../master/src/utils/jsoncpp.cpp 
		src/main.cpp
)

link_directories($ENV{GTEST_LIB_PATH})
link_directories($ENV{BOOST_LIB_PATH})
link_directories($ENV{LD_LIB_PATH}) 


add_executable(testFE ${SOURCE_FILES}) 
 
target_link_libraries(testFE pthread boost_system rt gtest gtest_main ) 
 
