require recipes-devtools/gcc/gcc-4.7.inc
require gcc-linaro-common-4.7.inc

MMYY = "13.10"
RELEASE = "20${MMYY}"
PR = "r${RELEASE}"
BINV = "4.7.4"

FILESPATH = "${@base_set_filespath([ '${FILE_DIRNAME}/gcc-${PV}' ], d)}"

SRC_URI = "http://releases.linaro.org/${MMYY}/components/toolchain/gcc-linaro/${BASEPV}/gcc-${PV}-${RELEASE}.tar.bz2 \
	   file://gcc-4.3.1-ARCH_FLAGS_FOR_TARGET.patch \
	   file://64bithack.patch \
	   file://optional_libstdc.patch \
	   file://use-defaults.h-and-t-oe-in-B.patch \
	   file://fix-g++-sysroot.patch \
	  "

SRC_URI[md5sum] = "8a70c02360fab28ed97d82a6aff3b4cf"
SRC_URI[sha256sum] = "c1bab9a588b623f0e81aeb72de30eb42f4cd52d05d6a3d5584de7cd28cd3afae"

S = "${TMPDIR}/work-shared/gcc-${PV}-${PR}/gcc-${PV}-${RELEASE}"
B = "${WORKDIR}/gcc-${PV}-${RELEASE}/build.${HOST_SYS}.${TARGET_SYS}"
