# CMAKE generated file: DO NOT EDIT!
# Generated by "Unix Makefiles" Generator, CMake Version 3.11

# Delete rule output on recipe failure.
.DELETE_ON_ERROR:


#=============================================================================
# Special targets provided by cmake.

# Disable implicit rules so canonical targets will work.
.SUFFIXES:


# Remove some rules from gmake that .SUFFIXES does not remove.
SUFFIXES =

.SUFFIXES: .hpux_make_needs_suffix_list


# Suppress display of executed commands.
$(VERBOSE).SILENT:


# A target that is always out of date.
cmake_force:

.PHONY : cmake_force

#=============================================================================
# Set environment variables for the build.

# The shell in which to execute make rules.
SHELL = /bin/sh

# The CMake executable.
CMAKE_COMMAND = /mnt/NewData/work/hyperdata/trunk/modules/ml-engine/tools/cmake-3.11.3/bin/cmake

# The command to remove a file.
RM = /mnt/NewData/work/hyperdata/trunk/modules/ml-engine/tools/cmake-3.11.3/bin/cmake -E remove -f

# Escaping for special characters.
EQUALS = =

# The top-level source directory on which CMake was run.
CMAKE_SOURCE_DIR = /mnt/NewData/work/hyperdata/trunk/modules/ml-engine/master

# The top-level build directory on which CMake was run.
CMAKE_BINARY_DIR = /mnt/NewData/work/hyperdata/trunk/modules/ml-engine/master/build

# Include any dependencies generated for this target.
include CMakeFiles/jsonTest.dir/depend.make

# Include the progress variables for this target.
include CMakeFiles/jsonTest.dir/progress.make

# Include the compile flags for this target's objects.
include CMakeFiles/jsonTest.dir/flags.make

CMakeFiles/jsonTest.dir/src/tests/json_test.cpp.o: CMakeFiles/jsonTest.dir/flags.make
CMakeFiles/jsonTest.dir/src/tests/json_test.cpp.o: ../src/tests/json_test.cpp
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=/mnt/NewData/work/hyperdata/trunk/modules/ml-engine/master/build/CMakeFiles --progress-num=$(CMAKE_PROGRESS_1) "Building CXX object CMakeFiles/jsonTest.dir/src/tests/json_test.cpp.o"
	/usr/bin/c++  $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -o CMakeFiles/jsonTest.dir/src/tests/json_test.cpp.o -c /mnt/NewData/work/hyperdata/trunk/modules/ml-engine/master/src/tests/json_test.cpp

CMakeFiles/jsonTest.dir/src/tests/json_test.cpp.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing CXX source to CMakeFiles/jsonTest.dir/src/tests/json_test.cpp.i"
	/usr/bin/c++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -E /mnt/NewData/work/hyperdata/trunk/modules/ml-engine/master/src/tests/json_test.cpp > CMakeFiles/jsonTest.dir/src/tests/json_test.cpp.i

CMakeFiles/jsonTest.dir/src/tests/json_test.cpp.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling CXX source to assembly CMakeFiles/jsonTest.dir/src/tests/json_test.cpp.s"
	/usr/bin/c++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -S /mnt/NewData/work/hyperdata/trunk/modules/ml-engine/master/src/tests/json_test.cpp -o CMakeFiles/jsonTest.dir/src/tests/json_test.cpp.s

CMakeFiles/jsonTest.dir/src/utils/jsoncpp.cpp.o: CMakeFiles/jsonTest.dir/flags.make
CMakeFiles/jsonTest.dir/src/utils/jsoncpp.cpp.o: ../src/utils/jsoncpp.cpp
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=/mnt/NewData/work/hyperdata/trunk/modules/ml-engine/master/build/CMakeFiles --progress-num=$(CMAKE_PROGRESS_2) "Building CXX object CMakeFiles/jsonTest.dir/src/utils/jsoncpp.cpp.o"
	/usr/bin/c++  $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -o CMakeFiles/jsonTest.dir/src/utils/jsoncpp.cpp.o -c /mnt/NewData/work/hyperdata/trunk/modules/ml-engine/master/src/utils/jsoncpp.cpp

CMakeFiles/jsonTest.dir/src/utils/jsoncpp.cpp.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing CXX source to CMakeFiles/jsonTest.dir/src/utils/jsoncpp.cpp.i"
	/usr/bin/c++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -E /mnt/NewData/work/hyperdata/trunk/modules/ml-engine/master/src/utils/jsoncpp.cpp > CMakeFiles/jsonTest.dir/src/utils/jsoncpp.cpp.i

CMakeFiles/jsonTest.dir/src/utils/jsoncpp.cpp.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling CXX source to assembly CMakeFiles/jsonTest.dir/src/utils/jsoncpp.cpp.s"
	/usr/bin/c++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -S /mnt/NewData/work/hyperdata/trunk/modules/ml-engine/master/src/utils/jsoncpp.cpp -o CMakeFiles/jsonTest.dir/src/utils/jsoncpp.cpp.s

# Object files for target jsonTest
jsonTest_OBJECTS = \
"CMakeFiles/jsonTest.dir/src/tests/json_test.cpp.o" \
"CMakeFiles/jsonTest.dir/src/utils/jsoncpp.cpp.o"

# External object files for target jsonTest
jsonTest_EXTERNAL_OBJECTS =

jsonTest: CMakeFiles/jsonTest.dir/src/tests/json_test.cpp.o
jsonTest: CMakeFiles/jsonTest.dir/src/utils/jsoncpp.cpp.o
jsonTest: CMakeFiles/jsonTest.dir/build.make
jsonTest: CMakeFiles/jsonTest.dir/link.txt
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --bold --progress-dir=/mnt/NewData/work/hyperdata/trunk/modules/ml-engine/master/build/CMakeFiles --progress-num=$(CMAKE_PROGRESS_3) "Linking CXX executable jsonTest"
	$(CMAKE_COMMAND) -E cmake_link_script CMakeFiles/jsonTest.dir/link.txt --verbose=$(VERBOSE)

# Rule to build all files generated by this target.
CMakeFiles/jsonTest.dir/build: jsonTest

.PHONY : CMakeFiles/jsonTest.dir/build

CMakeFiles/jsonTest.dir/clean:
	$(CMAKE_COMMAND) -P CMakeFiles/jsonTest.dir/cmake_clean.cmake
.PHONY : CMakeFiles/jsonTest.dir/clean

CMakeFiles/jsonTest.dir/depend:
	cd /mnt/NewData/work/hyperdata/trunk/modules/ml-engine/master/build && $(CMAKE_COMMAND) -E cmake_depends "Unix Makefiles" /mnt/NewData/work/hyperdata/trunk/modules/ml-engine/master /mnt/NewData/work/hyperdata/trunk/modules/ml-engine/master /mnt/NewData/work/hyperdata/trunk/modules/ml-engine/master/build /mnt/NewData/work/hyperdata/trunk/modules/ml-engine/master/build /mnt/NewData/work/hyperdata/trunk/modules/ml-engine/master/build/CMakeFiles/jsonTest.dir/DependInfo.cmake --color=$(COLOR)
.PHONY : CMakeFiles/jsonTest.dir/depend
