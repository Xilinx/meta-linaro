require recipes-devtools/gcc/gcc-common.inc

PR = "r0"

FILESPATH = "${@base_set_filespath([ '${FILE_DIRNAME}/gcc-linaro-4.6-2012.02' ], d)}"
DEPENDS =+ "mpfr gmp libmpc"
NATIVEDEPS = "mpfr-native gmp-native libmpc-native zlib-native"

LICENSE="GPL-3.0-with-GCC-exception & GPLv3"

LIC_FILES_CHKSUM = "file://COPYING;md5=59530bdf33659b29e73d4adb9f9f6552 \
                   file://COPYING3;md5=d32239bcb673463ab874e80d47fae504 \
                   file://COPYING3.LIB;md5=6a6a8e020838b23406c81b19c1d46df6 \
                   file://COPYING.LIB;md5=2d5025d4aa3495befef8f17206a5b0a1 \
		   file://COPYING.RUNTIME;md5=fe60d87048567d4fe8c8a0ed2448bcc8"

BINV = "4.6.3"
SRC_URI = "http://launchpad.net/gcc-linaro/4.6/4.6-2012.02/+download/gcc-linaro-4.6-2012.02.tar.bz2"

SRC_URI[md5sum] = "2b7887846f8e5ac1ca58fe4dfaabf5a6"
SRC_URI[sha256sum] = "cddc96360c46366a98de38c806e0e4eced61dfee5e544e587de636e913b74fe3"

S = "${TMPDIR}/work-shared/gcc-${PV}-${PR}/gcc-${PV}-2012.02"
B = "${WORKDIR}/gcc-${PV}-2012.02/build.${HOST_SYS}.${TARGET_SYS}"

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
