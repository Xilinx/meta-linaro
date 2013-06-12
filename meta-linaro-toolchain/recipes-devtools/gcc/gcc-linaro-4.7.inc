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

SRC_URI[md5sum] = "123666fb25ecfd89912e6922ad10e15b"
SRC_URI[sha256sum] = "41c0e7e2decf71d5a141e6000fb0790b0dcfaa9b9dccaad02f2d3fb1cf71ec96"

S = "${TMPDIR}/work-shared/gcc-${PV}-${PR}/gcc-${PV}-${RELEASE}"
B = "${WORKDIR}/gcc-${PV}-${RELEASE}/build.${HOST_SYS}.${TARGET_SYS}"
