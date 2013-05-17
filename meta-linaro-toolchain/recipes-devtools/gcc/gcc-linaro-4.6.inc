require recipes-devtools/gcc/gcc-4.6.inc
require gcc-linaro-common-4.6.inc

RELEASE = "2013.04"
PR = "r${RELEASE}"
BINV = "4.6.4"

FILESPATH = "${@base_set_filespath([ '${FILE_DIRNAME}/gcc-${PV}' ], d)}"

#SRC_URI = "http://cbuild.validation.linaro.org/snapshots/gcc-${PV}-${RELEASE}.tar.bz2
SRC_URI = "https://releases.linaro.org/13.04/components/toolchain/gcc-linaro/${BASEPV}/gcc-${PV}-${RELEASE}.tar.bz2 \
	   file://gcc-4.3.1-ARCH_FLAGS_FOR_TARGET.patch \
	   file://64bithack.patch \
	   file://optional_libstdc.patch \
	   file://use-defaults.h-and-t-oe-in-B.patch \
	  "

SRC_URI[md5sum] = "737c3a3109f80a12a620f6eae2dc8ac9"
SRC_URI[sha256sum] = "509c7d1e133c6783920391c305bb916b15b32524e0e6af37300d63ff4d81de53"

S = "${TMPDIR}/work-shared/gcc-${PV}-${PR}/gcc-${PV}-${RELEASE}"
B = "${WORKDIR}/gcc-${PV}-${RELEASE}/build.${HOST_SYS}.${TARGET_SYS}"
