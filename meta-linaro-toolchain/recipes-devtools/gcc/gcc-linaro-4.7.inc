require recipes-devtools/gcc/gcc-4.7.inc
PV = "linaro-${BASEPV}"
MMYY = "14.01"
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

SRC_URI[md5sum] = "f93f561312bdb1b4b0267a57275aefdc"
SRC_URI[sha256sum] = "3550ea4627071dadf296722891f712a901ce46a00398cca4084f8fe01ed5ca14"

S = "${TMPDIR}/work-shared/gcc-${PV}-${PR}/gcc-${PV}-${RELEASE}"
B = "${WORKDIR}/gcc-${PV}-${RELEASE}/build.${HOST_SYS}.${TARGET_SYS}"
