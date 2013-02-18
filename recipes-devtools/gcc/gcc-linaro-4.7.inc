require recipes-devtools/gcc/gcc-4.7.inc
require gcc-linaro-common-4.7.inc

PR = "r9"
RELEASE = "2013.02"
BINV = "4.7.3"

#SRC_URI = "https://launchpad.net/gcc-linaro/4.7/4.7-${RELEASE}/+download/gcc-${PV}-${RELEASE}.tar.bz2 

SRC_URI = "http://cbuild.validation.linaro.org/snapshots/gcc-${PV}-${RELEASE}-01.tar.bz2 \
	   file://gcc-4.3.1-ARCH_FLAGS_FOR_TARGET.patch \
	   file://64bithack.patch \
	   file://optional_libstdc.patch \
	   file://use-defaults.h-and-t-oe-in-B.patch \
	   file://fix-g++-sysroot.patch \
	  "

SRC_URI[md5sum] = "4c8d749eb6358a7b6a3ce617e96eb5a9"
SRC_URI[sha256sum] = "cff6680c01c0512564ae78ae42f5498507c8a01f59ec34f7d8766a34db655f43"

S = "${TMPDIR}/work-shared/gcc-${PV}-${PR}/gcc-${PV}-${RELEASE}-01"
B = "${WORKDIR}/gcc-${PV}-${RELEASE}/build.${HOST_SYS}.${TARGET_SYS}"
