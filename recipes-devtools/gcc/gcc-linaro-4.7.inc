require recipes-devtools/gcc/gcc-4.7.inc
require gcc-linaro-common-4.7.inc

PR = "r9"
RELEASE = "2013.02"
BINV = "4.7.3"

#SRC_URI = "https://launchpad.net/gcc-linaro/4.7/4.7-${RELEASE}/+download/gcc-${PV}-${RELEASE}.tar.bz2 

SRC_URI = "http://cbuild.validation.linaro.org/snapshots/gcc-${PV}-${RELEASE}.tar.bz2 \
	   file://gcc-4.3.1-ARCH_FLAGS_FOR_TARGET.patch \
	   file://64bithack.patch \
	   file://optional_libstdc.patch \
	   file://use-defaults.h-and-t-oe-in-B.patch \
	   file://fix-g++-sysroot.patch \
	  "

SRC_URI[md5sum] = "6bdbed74c49c278ec4e87ddeca03e87f"
SRC_URI[sha256sum] = "42f0e78d3a9fbb4c7c070b9d39614af6a8521f968891f3d0a7889ee28450a405"

S = "${TMPDIR}/work-shared/gcc-${PV}-${PR}/gcc-${PV}-${RELEASE}"
B = "${WORKDIR}/gcc-${PV}-${RELEASE}/build.${HOST_SYS}.${TARGET_SYS}"
