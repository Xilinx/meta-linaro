require recipes-devtools/gcc/gcc-4.6.inc
require gcc-linaro-common-4.6.inc

PR = "r5"
RELEASE = "2013.03"
BINV = "4.6.4"

FILESPATH = "${@base_set_filespath([ '${FILE_DIRNAME}/gcc-${PV}' ], d)}"

#SRC_URI = "https://launchpad.net/gcc-linaro/4.6/4.6-${RELEASE}/+download/gcc-${PV}-${RELEASE}.tar.bz2 

SRC_URI = "http://cbuild.validation.linaro.org/snapshots/gcc-${PV}-${RELEASE}.tar.bz2 \
	   file://gcc-4.3.1-ARCH_FLAGS_FOR_TARGET.patch \
	   file://64bithack.patch \
	   file://optional_libstdc.patch \
	   file://use-defaults.h-and-t-oe-in-B.patch \
	  "

SRC_URI[md5sum] = "3c7988b91f3a12a6d8cc3617bc43913b"
SRC_URI[sha256sum] = "a2d7f88f698df530413e7073f8091eba451ca5ad2af5830cb378c8ded53db813"

S = "${TMPDIR}/work-shared/gcc-${PV}-${PR}/gcc-${PV}-${RELEASE}"
B = "${WORKDIR}/gcc-${PV}-${RELEASE}/build.${HOST_SYS}.${TARGET_SYS}"
