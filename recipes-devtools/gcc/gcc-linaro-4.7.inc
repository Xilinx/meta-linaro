require recipes-devtools/gcc/gcc-4.7.inc
require gcc-linaro-common-4.7.inc

PR = "r2"
RELEASE = "2012.05"
BINV = "4.7.1"

FILESPATH = "${@base_set_filespath([ '${FILE_DIRNAME}/gcc-${PV}-${RELEASE}' ], d)}"

SRC_URI = "http://launchpad.net/gcc-linaro/${BASEPV}/${BASEPV}-${RELEASE}/+download/gcc-${PV}-${RELEASE}.tar.bz2 \
	   file://gcc-4.3.1-ARCH_FLAGS_FOR_TARGET.patch \
	   file://64bithack.patch \
	   file://optional_libstdc.patch \
	   file://use-defaults.h-and-t-oe-in-B.patch \
	  "

SRC_URI[md5sum] = "28b2366c74dc7f263d200f1e6f985179"
SRC_URI[sha256sum] = "1b8cceea7d168a64f4b63197f445e7a8bbc913dc8fde472ce2ca4c26f6e4b3c5"

S = "${TMPDIR}/work-shared/gcc-${PV}-${PR}/gcc-${PV}-${RELEASE}"
B = "${WORKDIR}/gcc-${PV}-${RELEASE}/build.${HOST_SYS}.${TARGET_SYS}"
