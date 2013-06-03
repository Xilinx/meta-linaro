require gcc-linaro-common-4.7.inc
require recipes-devtools/gcc/gcc_${BASEPV}.bb

ARCH_FLAGS_FOR_TARGET += "-isystem${STAGING_INCDIR} -I${B}/gcc/include/ "

DEPENDS =+ "gmp-native"
