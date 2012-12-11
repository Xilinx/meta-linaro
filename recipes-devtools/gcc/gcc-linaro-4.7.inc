require recipes-devtools/gcc/gcc-4.7.inc
require gcc-linaro-common-4.7.inc

PR = "r8"
RELEASE = "2012.12"
BINV = "4.7.3"

SRC_URI = "http://cbuild.validation.linaro.org/snapshots/gcc-linaro-4.7-${RELEASE}.tar.bz2 \
	   file://gcc-4.3.1-ARCH_FLAGS_FOR_TARGET.patch \
	   file://64bithack.patch \
	   file://optional_libstdc.patch \
	   file://use-defaults.h-and-t-oe-in-B.patch \
	   file://fix-g++-sysroot.patch \
	  "

SRC_URI[md5sum] = "247b15687358bc7958eeb91ab22637d1"
SRC_URI[sha256sum] = "18a09d585dab16314446336dc582c4dffba19cc9e6ec3b7a405eb40449a847c2"

S = "${TMPDIR}/work-shared/gcc-${PV}-${PR}/gcc-${PV}-${RELEASE}"
B = "${WORKDIR}/gcc-${PV}-${RELEASE}/build.${HOST_SYS}.${TARGET_SYS}"
