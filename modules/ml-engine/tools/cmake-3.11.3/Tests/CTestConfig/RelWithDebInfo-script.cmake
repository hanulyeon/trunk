set(CTEST_CMAKE_GENERATOR "Unix Makefiles")
set(CTEST_CMAKE_GENERATOR_PLATFORM "")
set(CTEST_CMAKE_GENERATOR_TOOLSET "")
set(CTEST_PROJECT_NAME "CTestConfig")
set(CTEST_SOURCE_DIRECTORY "/mnt/NewData/work/hyperdata/trunk/modules/ml-engine/tools/cmake-3.11.3/Tests/CTestConfig")
set(CTEST_BINARY_DIRECTORY "/mnt/NewData/work/hyperdata/trunk/modules/ml-engine/tools/cmake-3.11.3/Tests/CTestConfig/RelWithDebInfo-script")

ctest_start(Experimental)

ctest_configure(BUILD "${CTEST_BINARY_DIRECTORY}" RETURN_VALUE rv)
if(NOT rv STREQUAL 0)
  message(FATAL_ERROR "*** error in ctest_configure ***")
endif()

ctest_build(BUILD "${CTEST_BINARY_DIRECTORY}" RETURN_VALUE rv)
if(NOT rv STREQUAL 0)
  message(FATAL_ERROR "*** error in ctest_build ***")
endif()

ctest_test(BUILD "${CTEST_BINARY_DIRECTORY}" RETURN_VALUE rv)
if(NOT rv STREQUAL 0)
  message(FATAL_ERROR "*** error in ctest_test ***")
endif()