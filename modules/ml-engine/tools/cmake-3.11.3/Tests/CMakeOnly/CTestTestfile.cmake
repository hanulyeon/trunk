# CMake generated Testfile for 
# Source directory: /mnt/NewData/work/hyperdata/trunk/modules/ml-engine/tools/cmake-3.11.3/Tests/CMakeOnly
# Build directory: /mnt/NewData/work/hyperdata/trunk/modules/ml-engine/tools/cmake-3.11.3/Tests/CMakeOnly
# 
# This file includes the relevant testing commands required for 
# testing this directory and lists subdirectories to be tested as well.
add_test(CMakeOnly.LinkInterfaceLoop "/mnt/NewData/work/hyperdata/trunk/modules/ml-engine/tools/cmake-3.11.3/bin/cmake" "-DTEST=LinkInterfaceLoop" "-P" "/mnt/NewData/work/hyperdata/trunk/modules/ml-engine/tools/cmake-3.11.3/Tests/CMakeOnly/Test.cmake")
set_tests_properties(CMakeOnly.LinkInterfaceLoop PROPERTIES  TIMEOUT "90")
add_test(CMakeOnly.CheckSymbolExists "/mnt/NewData/work/hyperdata/trunk/modules/ml-engine/tools/cmake-3.11.3/bin/cmake" "-DTEST=CheckSymbolExists" "-P" "/mnt/NewData/work/hyperdata/trunk/modules/ml-engine/tools/cmake-3.11.3/Tests/CMakeOnly/Test.cmake")
add_test(CMakeOnly.CheckCXXSymbolExists "/mnt/NewData/work/hyperdata/trunk/modules/ml-engine/tools/cmake-3.11.3/bin/cmake" "-DTEST=CheckCXXSymbolExists" "-P" "/mnt/NewData/work/hyperdata/trunk/modules/ml-engine/tools/cmake-3.11.3/Tests/CMakeOnly/Test.cmake")
add_test(CMakeOnly.CheckCXXCompilerFlag "/mnt/NewData/work/hyperdata/trunk/modules/ml-engine/tools/cmake-3.11.3/bin/cmake" "-DTEST=CheckCXXCompilerFlag" "-P" "/mnt/NewData/work/hyperdata/trunk/modules/ml-engine/tools/cmake-3.11.3/Tests/CMakeOnly/Test.cmake")
add_test(CMakeOnly.CheckLanguage "/mnt/NewData/work/hyperdata/trunk/modules/ml-engine/tools/cmake-3.11.3/bin/cmake" "-DTEST=CheckLanguage" "-P" "/mnt/NewData/work/hyperdata/trunk/modules/ml-engine/tools/cmake-3.11.3/Tests/CMakeOnly/Test.cmake")
add_test(CMakeOnly.CheckStructHasMember "/mnt/NewData/work/hyperdata/trunk/modules/ml-engine/tools/cmake-3.11.3/bin/cmake" "-DTEST=CheckStructHasMember" "-P" "/mnt/NewData/work/hyperdata/trunk/modules/ml-engine/tools/cmake-3.11.3/Tests/CMakeOnly/Test.cmake")
add_test(CMakeOnly.CompilerIdC "/mnt/NewData/work/hyperdata/trunk/modules/ml-engine/tools/cmake-3.11.3/bin/cmake" "-DTEST=CompilerIdC" "-P" "/mnt/NewData/work/hyperdata/trunk/modules/ml-engine/tools/cmake-3.11.3/Tests/CMakeOnly/Test.cmake")
add_test(CMakeOnly.CompilerIdCXX "/mnt/NewData/work/hyperdata/trunk/modules/ml-engine/tools/cmake-3.11.3/bin/cmake" "-DTEST=CompilerIdCXX" "-P" "/mnt/NewData/work/hyperdata/trunk/modules/ml-engine/tools/cmake-3.11.3/Tests/CMakeOnly/Test.cmake")
add_test(CMakeOnly.AllFindModules "/mnt/NewData/work/hyperdata/trunk/modules/ml-engine/tools/cmake-3.11.3/bin/cmake" "-DTEST=AllFindModules" "-DCMAKE_ARGS=-DCMake_TEST_CMakeOnly.AllFindModules_NO_VERSION=" "-P" "/mnt/NewData/work/hyperdata/trunk/modules/ml-engine/tools/cmake-3.11.3/Tests/CMakeOnly/Test.cmake")
add_test(CMakeOnly.SelectLibraryConfigurations "/mnt/NewData/work/hyperdata/trunk/modules/ml-engine/tools/cmake-3.11.3/bin/cmake" "-DTEST=SelectLibraryConfigurations" "-P" "/mnt/NewData/work/hyperdata/trunk/modules/ml-engine/tools/cmake-3.11.3/Tests/CMakeOnly/Test.cmake")
add_test(CMakeOnly.TargetScope "/mnt/NewData/work/hyperdata/trunk/modules/ml-engine/tools/cmake-3.11.3/bin/cmake" "-DTEST=TargetScope" "-P" "/mnt/NewData/work/hyperdata/trunk/modules/ml-engine/tools/cmake-3.11.3/Tests/CMakeOnly/Test.cmake")
add_test(CMakeOnly.find_library "/mnt/NewData/work/hyperdata/trunk/modules/ml-engine/tools/cmake-3.11.3/bin/cmake" "-DTEST=find_library" "-P" "/mnt/NewData/work/hyperdata/trunk/modules/ml-engine/tools/cmake-3.11.3/Tests/CMakeOnly/Test.cmake")
add_test(CMakeOnly.find_path "/mnt/NewData/work/hyperdata/trunk/modules/ml-engine/tools/cmake-3.11.3/bin/cmake" "-DTEST=find_path" "-P" "/mnt/NewData/work/hyperdata/trunk/modules/ml-engine/tools/cmake-3.11.3/Tests/CMakeOnly/Test.cmake")
add_test(CMakeOnly.ProjectInclude "/mnt/NewData/work/hyperdata/trunk/modules/ml-engine/tools/cmake-3.11.3/bin/cmake" "-DTEST=ProjectInclude" "-DCMAKE_ARGS=-DCMAKE_PROJECT_ProjectInclude_INCLUDE=/mnt/NewData/work/hyperdata/trunk/modules/ml-engine/tools/cmake-3.11.3/Tests/CMakeOnly/ProjectInclude/include.cmake" "-P" "/mnt/NewData/work/hyperdata/trunk/modules/ml-engine/tools/cmake-3.11.3/Tests/CMakeOnly/Test.cmake")
add_test(CMakeOnly.MajorVersionSelection-PythonLibs_2 "/mnt/NewData/work/hyperdata/trunk/modules/ml-engine/tools/cmake-3.11.3/bin/cmake" "-DTEST=MajorVersionSelection-PythonLibs_2" "-DTEST_SOURCE=MajorVersionSelection" "-DCMAKE_ARGS=-DMAJOR_TEST_MODULE=PythonLibs;-DMAJOR_TEST_VERSION=2;-DMAJOR_TEST_NO_LANGUAGES=FALSE;-DMAJOR_TEST_VERSION_VAR=PYTHONLIBS_VERSION_STRING" "-P" "/mnt/NewData/work/hyperdata/trunk/modules/ml-engine/tools/cmake-3.11.3/Tests/CMakeOnly/Test.cmake")
add_test(CMakeOnly.MajorVersionSelection-PythonLibs_3 "/mnt/NewData/work/hyperdata/trunk/modules/ml-engine/tools/cmake-3.11.3/bin/cmake" "-DTEST=MajorVersionSelection-PythonLibs_3" "-DTEST_SOURCE=MajorVersionSelection" "-DCMAKE_ARGS=-DMAJOR_TEST_MODULE=PythonLibs;-DMAJOR_TEST_VERSION=3;-DMAJOR_TEST_NO_LANGUAGES=FALSE;-DMAJOR_TEST_VERSION_VAR=PYTHONLIBS_VERSION_STRING" "-P" "/mnt/NewData/work/hyperdata/trunk/modules/ml-engine/tools/cmake-3.11.3/Tests/CMakeOnly/Test.cmake")
add_test(CMakeOnly.MajorVersionSelection-PythonInterp_2 "/mnt/NewData/work/hyperdata/trunk/modules/ml-engine/tools/cmake-3.11.3/bin/cmake" "-DTEST=MajorVersionSelection-PythonInterp_2" "-DTEST_SOURCE=MajorVersionSelection" "-DCMAKE_ARGS=-DMAJOR_TEST_MODULE=PythonInterp;-DMAJOR_TEST_VERSION=2;-DMAJOR_TEST_NO_LANGUAGES=TRUE;-DMAJOR_TEST_VERSION_VAR=PYTHON_VERSION_STRING" "-P" "/mnt/NewData/work/hyperdata/trunk/modules/ml-engine/tools/cmake-3.11.3/Tests/CMakeOnly/Test.cmake")
add_test(CMakeOnly.MajorVersionSelection-PythonInterp_3 "/mnt/NewData/work/hyperdata/trunk/modules/ml-engine/tools/cmake-3.11.3/bin/cmake" "-DTEST=MajorVersionSelection-PythonInterp_3" "-DTEST_SOURCE=MajorVersionSelection" "-DCMAKE_ARGS=-DMAJOR_TEST_MODULE=PythonInterp;-DMAJOR_TEST_VERSION=3;-DMAJOR_TEST_NO_LANGUAGES=TRUE;-DMAJOR_TEST_VERSION_VAR=PYTHON_VERSION_STRING" "-P" "/mnt/NewData/work/hyperdata/trunk/modules/ml-engine/tools/cmake-3.11.3/Tests/CMakeOnly/Test.cmake")
add_test(CMakeOnly.MajorVersionSelection-Qt_3 "/mnt/NewData/work/hyperdata/trunk/modules/ml-engine/tools/cmake-3.11.3/bin/cmake" "-DTEST=MajorVersionSelection-Qt_3" "-DTEST_SOURCE=MajorVersionSelection" "-DCMAKE_ARGS=-DMAJOR_TEST_MODULE=Qt;-DMAJOR_TEST_VERSION=3;-DMAJOR_TEST_NO_LANGUAGES=FALSE;-DMAJOR_TEST_VERSION_VAR=QT_VERSION_STRING" "-P" "/mnt/NewData/work/hyperdata/trunk/modules/ml-engine/tools/cmake-3.11.3/Tests/CMakeOnly/Test.cmake")
add_test(CMakeOnly.MajorVersionSelection-Qt_4 "/mnt/NewData/work/hyperdata/trunk/modules/ml-engine/tools/cmake-3.11.3/bin/cmake" "-DTEST=MajorVersionSelection-Qt_4" "-DTEST_SOURCE=MajorVersionSelection" "-DCMAKE_ARGS=-DMAJOR_TEST_MODULE=Qt;-DMAJOR_TEST_VERSION=4;-DMAJOR_TEST_NO_LANGUAGES=FALSE;-DMAJOR_TEST_VERSION_VAR=QT_VERSION_STRING" "-P" "/mnt/NewData/work/hyperdata/trunk/modules/ml-engine/tools/cmake-3.11.3/Tests/CMakeOnly/Test.cmake")