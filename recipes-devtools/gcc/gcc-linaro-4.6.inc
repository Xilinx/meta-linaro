require recipes-devtools/gcc/gcc-4.6.inc
require gcc-linaro-common-4.6.inc

PR = "r3"
RELEASE = "2012.06"
BINV = "4.6.4"

FILESPATH = "${@base_set_filespath([ '${FILE_DIRNAME}/gcc-${PV}' ], d)}"

SRC_URI = "https://launchpad.net/gcc-linaro/4.6/4.6-${RELEASE}/+download/gcc-${PV}-${RELEASE}.tar.bz2 \
	   file://gcc-4.3.1-ARCH_FLAGS_FOR_TARGET.patch \
	   file://64bithack.patch \
	   file://optional_libstdc.patch \
	   file://use-defaults.h-and-t-oe-in-B.patch \
	   file://revert-r106893.patch \
	  "

SRC_URI[md5sum] = "5104039954c65904648e62ee7a20ba1f"
SRC_URI[sha256sum] = "214232fa957f3d90cd923d50a7d3ed3728a31742f4f0b56107c4cafbd8a0a227"

S = "${TMPDIR}/work-shared/gcc-${PV}-${PR}/gcc-${PV}-${RELEASE}"
B = "${WORKDIR}/gcc-${PV}-${RELEASE}/build.${HOST_SYS}.${TARGET_SYS}"
