require recipes-devtools/gcc/gcc-4.7.inc
require gcc-linaro-common-4.7.inc

PR = "r9"
RELEASE = "2013.03"
BINV = "4.7.3"

FILESPATH = "${@base_set_filespath([ '${FILE_DIRNAME}/gcc-${PV}' ], d)}"

SRC_URI = "https://launchpad.net/gcc-linaro/4.7/4.7-${RELEASE}/+download/gcc-${PV}-${RELEASE}.tar.bz2 \
	   file://gcc-4.3.1-ARCH_FLAGS_FOR_TARGET.patch \
	   file://64bithack.patch \
	   file://optional_libstdc.patch \
	   file://use-defaults.h-and-t-oe-in-B.patch \
	   file://fix-g++-sysroot.patch \
	  "

SRC_URI[md5sum] = "72e37ed0601f72e4d7e842d7e5373148"
SRC_URI[sha256sum] = "b46960070614c72c21587f3294f88fc21896ac1aab8bd007ddc1731255daabeb"

S = "${TMPDIR}/work-shared/gcc-${PV}-${PR}/gcc-${PV}-${RELEASE}"
B = "${WORKDIR}/gcc-${PV}-${RELEASE}/build.${HOST_SYS}.${TARGET_SYS}"
