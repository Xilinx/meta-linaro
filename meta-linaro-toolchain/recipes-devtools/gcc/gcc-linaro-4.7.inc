require recipes-devtools/gcc/gcc-4.7.inc
require gcc-linaro-common-4.7.inc

MMYY = "13.06"
RELEASE = "20${MMYY}"
PR = "r${RELEASE}"
BINV = "4.7.4"

FILESPATH = "${@base_set_filespath([ '${FILE_DIRNAME}/gcc-${PV}' ], d)}"

#SRC_URI = "https://releases.linaro.org/${MMYY}/components/toolchain/gcc-linaro/${BASEPV}/gcc-${PV}-${RELEASE}.tar.bz2
SRC_URI = "http://cbuild.validation.linaro.org/snapshots/gcc-${PV}-${RELEASE}.tar.bz2 \
	   file://gcc-4.3.1-ARCH_FLAGS_FOR_TARGET.patch \
	   file://64bithack.patch \
	   file://optional_libstdc.patch \
	   file://use-defaults.h-and-t-oe-in-B.patch \
	   file://fix-g++-sysroot.patch \
	  "
SRC_URI[md5sum] = "d7c04132de8b81794bea4c526f87899a"
SRC_URI[sha256sum] = "3095d4cf7b8902078dc70c24b3626aa40159eb11ec6b7ab4313a93942ce5cddb"

S = "${TMPDIR}/work-shared/gcc-${PV}-${PR}/gcc-${PV}-${RELEASE}"
B = "${WORKDIR}/gcc-${PV}-${RELEASE}/build.${HOST_SYS}.${TARGET_SYS}"
