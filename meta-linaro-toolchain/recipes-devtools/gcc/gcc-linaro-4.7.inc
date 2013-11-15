require recipes-devtools/gcc/gcc-4.7.inc
require gcc-linaro-common-4.7.inc

MMYY = "13.11"
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

SRC_URI[md5sum] = "f6fbca5dc4a3a30ed3c17c8aefd03a3d"
SRC_URI[sha256sum] = "d0ea2c72ceb66d3851986840dd8962941824a2980a8aca2a800abb5b489acedf"

S = "${TMPDIR}/work-shared/gcc-${PV}-${PR}/gcc-${PV}-${RELEASE}"
B = "${WORKDIR}/gcc-${PV}-${RELEASE}/build.${HOST_SYS}.${TARGET_SYS}"
