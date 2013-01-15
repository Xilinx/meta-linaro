require recipes-devtools/gcc/gcc-4.7.inc
require gcc-linaro-common-4.7.inc

PR = "r9"
RELEASE = "2013.01"
BINV = "4.7.3"

SRC_URI = "http://cbuild.validation.linaro.org/snapshots/gcc-linaro-4.7-2013.01.tar.bz2 \
	   file://gcc-4.3.1-ARCH_FLAGS_FOR_TARGET.patch \
	   file://64bithack.patch \
	   file://optional_libstdc.patch \
	   file://use-defaults.h-and-t-oe-in-B.patch \
	   file://fix-g++-sysroot.patch \
	  "

SRC_URI[md5sum] = "823516979de64df3ab6351c5ad3a9773"
SRC_URI[sha256sum] = "63793c9a616a039ee17d0bae685fd0f8ed4137d3b743ae5dcf73cde8fc063fd7"

S = "${TMPDIR}/work-shared/gcc-${PV}-${PR}/gcc-${PV}-${RELEASE}"
B = "${WORKDIR}/gcc-${PV}-${RELEASE}/build.${HOST_SYS}.${TARGET_SYS}"
