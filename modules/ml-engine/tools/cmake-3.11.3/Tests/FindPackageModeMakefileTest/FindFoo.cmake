
find_library(FOO_LIBRARY NAMES foo HINTS "/mnt/NewData/work/hyperdata/trunk/modules/ml-engine/tools/cmake-3.11.3/Tests/FindPackageModeMakefileTest" )
find_path(FOO_INCLUDE_DIR NAMES foo.h HINTS "/mnt/NewData/work/hyperdata/trunk/modules/ml-engine/tools/cmake-3.11.3/Tests/FindPackageModeMakefileTest" )

set(FOO_LIBRARIES ${FOO_LIBRARY})
set(FOO_INCLUDE_DIRS "${FOO_INCLUDE_DIR}"  "/some/path/with a space/include" )

add_library(Foo::Foo INTERFACE IMPORTED)

include(FindPackageHandleStandardArgs)
find_package_handle_standard_args(Foo  DEFAULT_MSG  FOO_LIBRARY FOO_INCLUDE_DIR )
