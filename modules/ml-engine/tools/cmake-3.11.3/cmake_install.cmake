# Install script for directory: /mnt/NewData/work/hyperdata/trunk/modules/ml-engine/tools/cmake-3.11.3

# Set the install prefix
if(NOT DEFINED CMAKE_INSTALL_PREFIX)
  set(CMAKE_INSTALL_PREFIX "/usr/local")
endif()
string(REGEX REPLACE "/$" "" CMAKE_INSTALL_PREFIX "${CMAKE_INSTALL_PREFIX}")

# Set the install configuration name.
if(NOT DEFINED CMAKE_INSTALL_CONFIG_NAME)
  if(BUILD_TYPE)
    string(REGEX REPLACE "^[^A-Za-z0-9_]+" ""
           CMAKE_INSTALL_CONFIG_NAME "${BUILD_TYPE}")
  else()
    set(CMAKE_INSTALL_CONFIG_NAME "")
  endif()
  message(STATUS "Install configuration: \"${CMAKE_INSTALL_CONFIG_NAME}\"")
endif()

# Set the component getting installed.
if(NOT CMAKE_INSTALL_COMPONENT)
  if(COMPONENT)
    message(STATUS "Install component: \"${COMPONENT}\"")
    set(CMAKE_INSTALL_COMPONENT "${COMPONENT}")
  else()
    set(CMAKE_INSTALL_COMPONENT)
  endif()
endif()

# Install shared libraries without execute permission?
if(NOT DEFINED CMAKE_INSTALL_SO_NO_EXE)
  set(CMAKE_INSTALL_SO_NO_EXE "1")
endif()

# Is this installation the result of a crosscompile?
if(NOT DEFINED CMAKE_CROSSCOMPILING)
  set(CMAKE_CROSSCOMPILING "FALSE")
endif()

if("x${CMAKE_INSTALL_COMPONENT}x" STREQUAL "xUnspecifiedx" OR NOT CMAKE_INSTALL_COMPONENT)
  file(INSTALL DESTINATION "${CMAKE_INSTALL_PREFIX}/doc/cmake-3.11" TYPE FILE FILES "/mnt/NewData/work/hyperdata/trunk/modules/ml-engine/tools/cmake-3.11.3/Copyright.txt")
endif()

if("x${CMAKE_INSTALL_COMPONENT}x" STREQUAL "xUnspecifiedx" OR NOT CMAKE_INSTALL_COMPONENT)
  file(INSTALL DESTINATION "${CMAKE_INSTALL_PREFIX}/share/cmake-3.11" TYPE DIRECTORY PERMISSIONS OWNER_READ OWNER_WRITE GROUP_READ WORLD_READ DIR_PERMISSIONS OWNER_READ OWNER_EXECUTE OWNER_WRITE GROUP_READ GROUP_EXECUTE WORLD_READ WORLD_EXECUTE FILES
    "/mnt/NewData/work/hyperdata/trunk/modules/ml-engine/tools/cmake-3.11.3/Help"
    "/mnt/NewData/work/hyperdata/trunk/modules/ml-engine/tools/cmake-3.11.3/Modules"
    "/mnt/NewData/work/hyperdata/trunk/modules/ml-engine/tools/cmake-3.11.3/Templates"
    REGEX "/[^/]*\\.sh[^/]*$" PERMISSIONS OWNER_READ OWNER_EXECUTE OWNER_WRITE GROUP_READ GROUP_EXECUTE WORLD_READ WORLD_EXECUTE REGEX "Help/dev($|/)" EXCLUDE)
endif()

if(NOT CMAKE_INSTALL_LOCAL_ONLY)
  # Include the install script for each subdirectory.
  include("/mnt/NewData/work/hyperdata/trunk/modules/ml-engine/tools/cmake-3.11.3/Source/kwsys/cmake_install.cmake")
  include("/mnt/NewData/work/hyperdata/trunk/modules/ml-engine/tools/cmake-3.11.3/Utilities/KWIML/cmake_install.cmake")
  include("/mnt/NewData/work/hyperdata/trunk/modules/ml-engine/tools/cmake-3.11.3/Utilities/cmlibrhash/cmake_install.cmake")
  include("/mnt/NewData/work/hyperdata/trunk/modules/ml-engine/tools/cmake-3.11.3/Utilities/cmzlib/cmake_install.cmake")
  include("/mnt/NewData/work/hyperdata/trunk/modules/ml-engine/tools/cmake-3.11.3/Utilities/cmcurl/cmake_install.cmake")
  include("/mnt/NewData/work/hyperdata/trunk/modules/ml-engine/tools/cmake-3.11.3/Utilities/cmcompress/cmake_install.cmake")
  include("/mnt/NewData/work/hyperdata/trunk/modules/ml-engine/tools/cmake-3.11.3/Utilities/cmexpat/cmake_install.cmake")
  include("/mnt/NewData/work/hyperdata/trunk/modules/ml-engine/tools/cmake-3.11.3/Utilities/cmbzip2/cmake_install.cmake")
  include("/mnt/NewData/work/hyperdata/trunk/modules/ml-engine/tools/cmake-3.11.3/Utilities/cmliblzma/cmake_install.cmake")
  include("/mnt/NewData/work/hyperdata/trunk/modules/ml-engine/tools/cmake-3.11.3/Utilities/cmlibarchive/cmake_install.cmake")
  include("/mnt/NewData/work/hyperdata/trunk/modules/ml-engine/tools/cmake-3.11.3/Utilities/cmjsoncpp/cmake_install.cmake")
  include("/mnt/NewData/work/hyperdata/trunk/modules/ml-engine/tools/cmake-3.11.3/Utilities/cmlibuv/cmake_install.cmake")
  include("/mnt/NewData/work/hyperdata/trunk/modules/ml-engine/tools/cmake-3.11.3/Source/CursesDialog/form/cmake_install.cmake")
  include("/mnt/NewData/work/hyperdata/trunk/modules/ml-engine/tools/cmake-3.11.3/Source/cmake_install.cmake")
  include("/mnt/NewData/work/hyperdata/trunk/modules/ml-engine/tools/cmake-3.11.3/Utilities/cmake_install.cmake")
  include("/mnt/NewData/work/hyperdata/trunk/modules/ml-engine/tools/cmake-3.11.3/Tests/cmake_install.cmake")
  include("/mnt/NewData/work/hyperdata/trunk/modules/ml-engine/tools/cmake-3.11.3/Auxiliary/cmake_install.cmake")

endif()

if(CMAKE_INSTALL_COMPONENT)
  set(CMAKE_INSTALL_MANIFEST "install_manifest_${CMAKE_INSTALL_COMPONENT}.txt")
else()
  set(CMAKE_INSTALL_MANIFEST "install_manifest.txt")
endif()

string(REPLACE ";" "\n" CMAKE_INSTALL_MANIFEST_CONTENT
       "${CMAKE_INSTALL_MANIFEST_FILES}")
file(WRITE "/mnt/NewData/work/hyperdata/trunk/modules/ml-engine/tools/cmake-3.11.3/${CMAKE_INSTALL_MANIFEST}"
     "${CMAKE_INSTALL_MANIFEST_CONTENT}")