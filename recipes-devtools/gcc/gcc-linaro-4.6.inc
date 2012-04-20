require recipes-devtools/gcc/gcc-common.inc

PR = "r0"
RELEASE = "2012.04"
BINV = "4.6.4"

FILESPATH = "${@base_set_filespath([ '${FILE_DIRNAME}/gcc-linaro-4.6-${RELEASE}' ], d)}"
DEPENDS =+ "mpfr gmp libmpc"
NATIVEDEPS = "mpfr-native gmp-native libmpc-native zlib-native"

LICENSE="GPL-3.0-with-GCC-exception & GPLv3"

LIC_FILES_CHKSUM = "file://COPYING;md5=59530bdf33659b29e73d4adb9f9f6552 \
                   file://COPYING3;md5=d32239bcb673463ab874e80d47fae504 \
                   file://COPYING3.LIB;md5=6a6a8e020838b23406c81b19c1d46df6 \
                   file://COPYING.LIB;md5=2d5025d4aa3495befef8f17206a5b0a1 \
		   file://COPYING.RUNTIME;md5=fe60d87048567d4fe8c8a0ed2448bcc8"

SRC_URI = "https://launchpad.net/gcc-linaro/4.6/4.6-${RELEASE}/+download/gcc-${PV}-${RELEASE}.tar.bz2 \
	   file://optional_libstdc.patch \
	   file://use-defaults.h-and-t-oe-in-B.patch \
	  "

SRC_URI[md5sum] = "f9be35eddfed2d5f4325901a373b37f9"
SRC_URI[sha256sum] = "9b934d0589c32ea9df27cca5d659f5751a213dacb1530f91f43e92b06b084938"

S = "${TMPDIR}/work-shared/gcc-${PV}-${PR}/gcc-${PV}-${RELEASE}"
B = "${WORKDIR}/gcc-${PV}-${RELEASE}/build.${HOST_SYS}.${TARGET_SYS}"

# Language Overrides
FORTRAN = ""
JAVA = ""

EXTRA_OECONF_BASE = " --enable-lto \
			--enable-libssp \
			--disable-bootstrap \
			--disable-libgomp \
			--disable-libmudflap \
			--with-system-zlib \
			--with-linker-hash-style=${LINKER_HASH_STYLE} \
			--enable-cheaders=c_global "

EXTRA_OECONF_INITIAL = "--disable-libmudflap \
			--disable-libgomp \
			--disable-libssp \
			--disable-libquadmath \
			--with-system-zlib \
			--disable-lto \
			--disable-plugin \
			--enable-decimal-float=no"

EXTRA_OECONF_INTERMEDIATE = "--disable-libmudflap \
				--disable-libgomp \
				--disable-libquadmath \
				--with-system-zlib \
				--disable-lto \
				--disable-plugin \
				--disable-libssp"

EXTRA_OECONF_append_linux-uclibc = " --disable-decimal-float "
EXTRA_OECONF_append_linux-uclibceabi = " --disable-decimal-float "
EXTRA_OECONF_append_linux-uclibcspe = " --disable-decimal-float "
