require gcc-linaro-common-5.1.inc
require recipes-devtools/gcc/gcc-crosssdk-initial_${BASEPV}.bb

EXTRA_OECONF += " --with-native-system-header-dir=${SYSTEMHEADERS} "
