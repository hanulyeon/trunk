if(NOT "/mnt/NewData/work/hyperdata/trunk/modules/ml-engine/tools/cmake-3.11.3/Tests/CMakeTests" MATCHES "^/")
  set(slash /)
endif()
set(url "file://${slash}/mnt/NewData/work/hyperdata/trunk/modules/ml-engine/tools/cmake-3.11.3/Tests/CMakeTests/FileDownloadInput.png")
set(dir "/mnt/NewData/work/hyperdata/trunk/modules/ml-engine/tools/cmake-3.11.3/Tests/CMakeTests/downloads")

file(DOWNLOAD
  ${url}
  ${dir}/file3.png
  TIMEOUT 2
  STATUS status
  EXPECTED_HASH SHA1=5555555555555555555555555555555555555555
  )
