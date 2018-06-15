
err()
{
  echo -e "error: $1"
  exit 1
}
msg()
{
    echo "$1"
}
msg_line()
{
    echo -n "$1..."
}
msg_done()
{
    if [[ -n "$1" ]]; then
        echo "$1"
    else
        echo "done"
    fi
}
# Check source directory
is_src_dir()
{
    [[ -f "$1/CMakeLists.txt" ]]
}
# Determine Git branch, if found

################################################################################
PREFIX=""
SRC_DIR="$PWD/master/"
BUILD_DIR="$PWD/master/build/"
CMAKE_DIR="$PWD/tools/cmake-3.11.3/"
CMAKE_OPTIONS=""
################################################################################

msg "Checking pre-requisites for builing"

if [ ! -d "$CMAKE_DIR/bin" ]; then
    msg_line "Build cmake"
    (cd $CMAKE_DIR; sudo ./bootstrap && sudo make && sudo make install)
    msg_done
else
    msg "Found cmake in '$CMAKE_DIR'/bin/ directory"
fi
[[ ! -d "$CMAKE_DIR" ]] && err "cannot find '$CMAKE_DIR' directory"


################################################################################
msg "Preparing for building"

# Create build directory
if [ ! -d "$BUILD_DIR" ]; then
    msg_line "Creating build directory in '$BUILD_DIR'"
    mkdir -p $BUILD_DIR
    msg_done
fi
[[ ! -d "$BUILD_DIR" ]] && err "cannot find '$BUILD_DIR' directory"


################################################################################


# Run cmake
msg "Running CMake in build directory '$BUILD_DIR'"



(cd $BUILD_DIR; $CMAKE_DIR/bin/cmake ../)
(cd $BUILD_DIR; $CMAKE_DIR/bin/cmake --build . --target testMaster)



################################################################################

SRC_DIR="$PWD/worker/"
BUILD_DIR="$PWD/worker/build/"

################################################################################


# Create build directory
if [ ! -d "$BUILD_DIR" ]; then
    msg_line "Creating build directory in '$BUILD_DIR'"
    mkdir -p $BUILD_DIR
    msg_done
fi
[[ ! -d "$BUILD_DIR" ]] && err "cannot find '$BUILD_DIR' directory"

# Run cmake
msg "Running CMake in build directory '$BUILD_DIR'"
msg "CMake options:"
msg " ${CMAKE_OPTIONS}"

(cd $BUILD_DIR; $CMAKE_DIR/bin/cmake ../)
(cd $BUILD_DIR; $CMAKE_DIR/bin/cmake --build . --target testWorker)


################################################################################

