require recipes-devtools/gcc/gcc-4.6.inc
require gcc-linaro-common-4.6.inc

PR = "r4"
RELEASE = "2012.12"
BINV = "4.6.4"

FILESPATH = "${@base_set_filespath([ '${FILE_DIRNAME}/gcc-${PV}' ], d)}"

SRC_URI = "https://launchpad.net/gcc-linaro/4.6/4.6-${RELEASE}/+download/gcc-${PV}-${RELEASE}.tar.bz2 \
	   file://gcc-4.3.1-ARCH_FLAGS_FOR_TARGET.patch \
	   file://64bithack.patch \
	   file://optional_libstdc.patch \
	   file://use-defaults.h-and-t-oe-in-B.patch \
	  "

SRC_URI[md5sum] = "6b6c6a4faa026edd1193cf6426309039"
SRC_URI[sha256sum] = "2a6be41a50b31446ba158558f666591978a8adfeab8fbe60131441d78722f119"

S = "${TMPDIR}/work-shared/gcc-${PV}-${PR}/gcc-${PV}-${RELEASE}"
B = "${WORKDIR}/gcc-${PV}-${RELEASE}/build.${HOST_SYS}.${TARGET_SYS}"
