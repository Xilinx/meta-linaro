require recipes-devtools/gcc/gcc-4.7.inc
require gcc-linaro-common-4.7.inc

PR = "r6"
RELEASE = "2012.10"
BINV = "4.7.3"
SRCREV = "115029"

FILESPATH = "${@base_set_filespath([ '${FILE_DIRNAME}/gcc-${PV}-${RELEASE}' ], d)}"

SRC_URI = "http://builds.linaro.org/toolchain/snapshots/gcc-linaro-4.7+bzr${SRCREV}.tar.xz \
	   file://gcc-4.3.1-ARCH_FLAGS_FOR_TARGET.patch \
	   file://64bithack.patch \
	   file://optional_libstdc.patch \
	   file://use-defaults.h-and-t-oe-in-B.patch \
	   file://fix-g++-sysroot.patch \
	  "

SRC_URI[md5sum] = "dc62be93e736812949b48f2846f06bf9"
SRC_URI[sha256sum] = "8518732973742c3234bc0e54c5cd549c2fc81d6349aa8cb4c7d326aeee74fca2"

S = "${TMPDIR}/work-shared/gcc-${PV}-${PR}/gcc-${PV}+bzr${SRCREV}"
B = "${WORKDIR}/gcc-${PV}+bzr${SRCREV}/build.${HOST_SYS}.${TARGET_SYS}"
