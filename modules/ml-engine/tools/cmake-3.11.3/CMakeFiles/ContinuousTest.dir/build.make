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
CMAKE_COMMAND = /mnt/NewData/work/hyperdata/trunk/modules/ml-engine/tools/cmake-3.11.3/Bootstrap.cmk/cmake

# The command to remove a file.
RM = /mnt/NewData/work/hyperdata/trunk/modules/ml-engine/tools/cmake-3.11.3/Bootstrap.cmk/cmake -E remove -f

# Escaping for special characters.
EQUALS = =

# The top-level source directory on which CMake was run.
CMAKE_SOURCE_DIR = /mnt/NewData/work/hyperdata/trunk/modules/ml-engine/tools/cmake-3.11.3

# The top-level build directory on which CMake was run.
CMAKE_BINARY_DIR = /mnt/NewData/work/hyperdata/trunk/modules/ml-engine/tools/cmake-3.11.3

# Utility rule file for ContinuousTest.

# Include the progress variables for this target.
include CMakeFiles/ContinuousTest.dir/progress.make

CMakeFiles/ContinuousTest:
	/usr/local/bin/ctest -D ContinuousTest

ContinuousTest: CMakeFiles/ContinuousTest
ContinuousTest: CMakeFiles/ContinuousTest.dir/build.make

.PHONY : ContinuousTest

# Rule to build all files generated by this target.
CMakeFiles/ContinuousTest.dir/build: ContinuousTest

.PHONY : CMakeFiles/ContinuousTest.dir/build

CMakeFiles/ContinuousTest.dir/clean:
	$(CMAKE_COMMAND) -P CMakeFiles/ContinuousTest.dir/cmake_clean.cmake
.PHONY : CMakeFiles/ContinuousTest.dir/clean

CMakeFiles/ContinuousTest.dir/depend:
	cd /mnt/NewData/work/hyperdata/trunk/modules/ml-engine/tools/cmake-3.11.3 && $(CMAKE_COMMAND) -E cmake_depends "Unix Makefiles" /mnt/NewData/work/hyperdata/trunk/modules/ml-engine/tools/cmake-3.11.3 /mnt/NewData/work/hyperdata/trunk/modules/ml-engine/tools/cmake-3.11.3 /mnt/NewData/work/hyperdata/trunk/modules/ml-engine/tools/cmake-3.11.3 /mnt/NewData/work/hyperdata/trunk/modules/ml-engine/tools/cmake-3.11.3 /mnt/NewData/work/hyperdata/trunk/modules/ml-engine/tools/cmake-3.11.3/CMakeFiles/ContinuousTest.dir/DependInfo.cmake --color=$(COLOR)
.PHONY : CMakeFiles/ContinuousTest.dir/depend

