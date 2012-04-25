require recipes-devtools/gcc/gcc-4.7.inc
require gcc-linaro-common-4.7.inc

PR = "r0"
RELEASE = "2012.04"
BINV = "4.7.1"

FILESPATH = "${@base_set_filespath([ '${FILE_DIRNAME}/gcc-${PV}-${RELEASE}' ], d)}"

SRC_URI = "http://launchpad.net/gcc-linaro/${BASEPV}/${BASEPV}-${RELEASE}/+download/gcc-${PV}-${RELEASE}.tar.bz2 \
	   file://optional_libstdc.patch \
	   file://use-defaults.h-and-t-oe-in-B.patch \
	  "

SRC_URI[md5sum] = "6dab459c1177fc9ae2969e7a39549d44"
SRC_URI[sha256sum] = "69cbff3408972de4f149215f09b1074d615bfb4dfec5ab50c96ab02f0ef165a9"

S = "${TMPDIR}/work-shared/gcc-${PV}-${PR}/gcc-${PV}-${RELEASE}"
B = "${WORKDIR}/gcc-${PV}-${RELEASE}/build.${HOST_SYS}.${TARGET_SYS}"
