cmake_minimum_required(VERSION 3.8)

project(ml-engine-master)

include_directories(.)
include_directories($ENV{GTEST_INC_PATH})
include_directories($ENV{BOOST_INC_PATH})
include_directories($ENV{LD_LIB_PATH})
include_directories($ENV{TB_7_FRAME})

set(CMAKE_CXX_STANDARD 11)
set(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -std=c++11")

set(MANAGER_TEST_FILES 
		src/tests/manager_test_main.cpp
		src/managers/JobManager.cpp 
		src/managers/InputDataManager.cpp 
		src/utils/ScriptBuilder.cpp 
		src/frame/Job.cpp 
		src/models/InputData.cpp
)

set(JSON_TEST_FILES 
		src/tests/json_test.cpp
		src/utils/jsoncpp.cpp
		src/utils/json/json.h 
)
set(MEMORY_TEST_FILES 
		src/tests/memory_test.cpp 
)
set(RACE_TEST_FILES 
		src/tests/race_test.cpp 
)
#set(TASK_TEST_FILES 
#		$ENV{TB_7_FRAME}/Task.cpp 
#		$ENV{TB_7_FRAME}/Event.hpp 
#		$ENV{TB_7_FRAME}/Lock.cpp  
#		$ENV{TB_7_FRAME}/ErrorHandling.cpp 
#		src/tasks/TrainingStartTask.cpp 
#		src/tests/task_test_main.cpp
#)

set(SOURCE_FILES 
		src/frame/EventManager.cpp
		src/frame/WorkerThreadPool.cpp
		src/frame/Worker.cpp
		src/frame/Job.cpp
		src/frame/Module.cpp
		src/frame/Task.h
		src/frame/Pipe.cpp
		src/frame/Log.h
		
		src/models/Script.cpp
		src/models/ResourceInfo.h
		src/models/TrainingProcess.h
		
		src/managers/JobManager.cpp 
		src/managers/ResourceManager.cpp
		src/managers/SampleManager.cpp
		src/managers/SampleManager2.cpp
		
		src/tasks/TrainingStartTask.cpp
		src/tasks/CustomTask.cpp
		src/utils/NetworkUtil.cpp
		src/utils/jsoncpp.cpp
		src/utils/json/json.h 
		src/utils/ScriptBuilder.cpp
	
		src/tests/main.cpp
)

link_directories($ENV{GTEST_LIB_PATH})
link_directories($ENV{BOOST_LIB_PATH})
link_directories($ENV{LD_LIB_PATH})
link_directories($ENV{TB_7_FRAME})


add_executable(managerTest ${MANAGER_TEST_FILES})
add_executable(jsonTest ${JSON_TEST_FILES})
add_executable(memoryTest ${MEMORY_TEST_FILES})
add_executable(testMaster ${SOURCE_FILES})
add_executable(testRace ${RACE_TEST_FILES})
#add_executable(taskTest ${TASK_TEST_FILES})

target_link_libraries(testMaster rt pthread)
target_link_libraries(testRace rt pthread)
target_link_libraries(managerTest pthread boost_system rt gtest gtest_main )
#target_link_libraries(taskTest boost_serialization boost_filesystem gtest pthread boost_system rt boost_thread )
 
