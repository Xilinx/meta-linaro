require recipes-devtools/gcc/gcc-4.6.inc
require gcc-linaro-common-4.6.inc

PR = "r5"
RELEASE = "2013.01"
BINV = "4.6.4"

FILESPATH = "${@base_set_filespath([ '${FILE_DIRNAME}/gcc-${PV}' ], d)}"

SRC_URI = "https://launchpad.net/gcc-linaro/4.6/4.6-${RELEASE}/+download/gcc-${PV}-${RELEASE}.tar.bz2 \
	   file://gcc-4.3.1-ARCH_FLAGS_FOR_TARGET.patch \
	   file://64bithack.patch \
	   file://optional_libstdc.patch \
	   file://use-defaults.h-and-t-oe-in-B.patch \
	  "

SRC_URI[md5sum] = "8ab7868a9abc5693cabc936e7965e669"
SRC_URI[sha256sum] = "55d943f3d08a11feee29fd885a14ede863aff205657bdb9d7dd36482b80a2f77"

S = "${TMPDIR}/work-shared/gcc-${PV}-${PR}/gcc-${PV}-${RELEASE}"
B = "${WORKDIR}/gcc-${PV}-${RELEASE}/build.${HOST_SYS}.${TARGET_SYS}"
