require recipes-devtools/gcc/gcc-4.7.inc
require gcc-linaro-common-4.7.inc

PR = "r5"
RELEASE = "2012.10"
BINV = "4.7.3"

FILESPATH = "${@base_set_filespath([ '${FILE_DIRNAME}/gcc-${PV}-${RELEASE}' ], d)}"

SRC_URI = "http://launchpad.net/gcc-linaro/${BASEPV}/${BASEPV}-${RELEASE}/+download/gcc-${PV}-${RELEASE}.tar.bz2 \
	   file://gcc-4.3.1-ARCH_FLAGS_FOR_TARGET.patch \
	   file://64bithack.patch \
	   file://optional_libstdc.patch \
	   file://use-defaults.h-and-t-oe-in-B.patch \
	   file://fix-g++-sysroot.patch \
	  "

SRC_URI[md5sum] = "a5ca87667350f1395d4da40c94ef059c"
SRC_URI[sha256sum] = "74ef10e86fe3343e89a7e20f22f4f75b2403fa23e45e97441cc11898c9075e59"

S = "${TMPDIR}/work-shared/gcc-${PV}-${PR}/gcc-${PV}-${RELEASE}"
B = "${WORKDIR}/gcc-${PV}-${RELEASE}/build.${HOST_SYS}.${TARGET_SYS}"
