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
include CMakeFiles/testRace.dir/depend.make

# Include the progress variables for this target.
include CMakeFiles/testRace.dir/progress.make

# Include the compile flags for this target's objects.
include CMakeFiles/testRace.dir/flags.make

CMakeFiles/testRace.dir/src/tests/race_test.cpp.o: CMakeFiles/testRace.dir/flags.make
CMakeFiles/testRace.dir/src/tests/race_test.cpp.o: ../src/tests/race_test.cpp
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=/mnt/NewData/work/hyperdata/trunk/modules/ml-engine/master/build/CMakeFiles --progress-num=$(CMAKE_PROGRESS_1) "Building CXX object CMakeFiles/testRace.dir/src/tests/race_test.cpp.o"
	/usr/bin/c++  $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -o CMakeFiles/testRace.dir/src/tests/race_test.cpp.o -c /mnt/NewData/work/hyperdata/trunk/modules/ml-engine/master/src/tests/race_test.cpp

CMakeFiles/testRace.dir/src/tests/race_test.cpp.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing CXX source to CMakeFiles/testRace.dir/src/tests/race_test.cpp.i"
	/usr/bin/c++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -E /mnt/NewData/work/hyperdata/trunk/modules/ml-engine/master/src/tests/race_test.cpp > CMakeFiles/testRace.dir/src/tests/race_test.cpp.i

CMakeFiles/testRace.dir/src/tests/race_test.cpp.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling CXX source to assembly CMakeFiles/testRace.dir/src/tests/race_test.cpp.s"
	/usr/bin/c++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -S /mnt/NewData/work/hyperdata/trunk/modules/ml-engine/master/src/tests/race_test.cpp -o CMakeFiles/testRace.dir/src/tests/race_test.cpp.s

# Object files for target testRace
testRace_OBJECTS = \
"CMakeFiles/testRace.dir/src/tests/race_test.cpp.o"

# External object files for target testRace
testRace_EXTERNAL_OBJECTS =

testRace: CMakeFiles/testRace.dir/src/tests/race_test.cpp.o
testRace: CMakeFiles/testRace.dir/build.make
testRace: CMakeFiles/testRace.dir/link.txt
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --bold --progress-dir=/mnt/NewData/work/hyperdata/trunk/modules/ml-engine/master/build/CMakeFiles --progress-num=$(CMAKE_PROGRESS_2) "Linking CXX executable testRace"
	$(CMAKE_COMMAND) -E cmake_link_script CMakeFiles/testRace.dir/link.txt --verbose=$(VERBOSE)

# Rule to build all files generated by this target.
CMakeFiles/testRace.dir/build: testRace

.PHONY : CMakeFiles/testRace.dir/build

CMakeFiles/testRace.dir/clean:
	$(CMAKE_COMMAND) -P CMakeFiles/testRace.dir/cmake_clean.cmake
.PHONY : CMakeFiles/testRace.dir/clean

CMakeFiles/testRace.dir/depend:
	cd /mnt/NewData/work/hyperdata/trunk/modules/ml-engine/master/build && $(CMAKE_COMMAND) -E cmake_depends "Unix Makefiles" /mnt/NewData/work/hyperdata/trunk/modules/ml-engine/master /mnt/NewData/work/hyperdata/trunk/modules/ml-engine/master /mnt/NewData/work/hyperdata/trunk/modules/ml-engine/master/build /mnt/NewData/work/hyperdata/trunk/modules/ml-engine/master/build /mnt/NewData/work/hyperdata/trunk/modules/ml-engine/master/build/CMakeFiles/testRace.dir/DependInfo.cmake --color=$(COLOR)
.PHONY : CMakeFiles/testRace.dir/depend

