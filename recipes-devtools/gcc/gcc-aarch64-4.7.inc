require gcc-common.inc

PR = "r2+svn${SRCPV}"

# Third digit in PV should be incremented after a minor release
# happens from this branch on gcc e.g. currently its 4.7.1
# when 4.7.2 is releases and we bump SRCREV beyond the release
# on branch then PV should be incremented to 4.7.2+svnr${SRCPV}
# to reflect that change

# using 4.7.1.0 for upgrade path when we move past 4.7.2 release
# then we should drop the last 0 as well.

#PV = "4.7.2"

# BINV should be incremented after updating to a revision
# after a minor gcc release (e.g. 4.7.1 or 4.7.2) has been made
# the value will be minor-release+1 e.g. if current minor release was
# 4.7.1 then the value below will have 2 which will mean 4.7.2
# which will be next minor release and so on.

DEFAULT_PREFERENCE_aarch64 = "1"

BINV = "4.7.2"

SRCREV = "191389"
BRANCH = "aarch64-4.7-branch"
SRC_BRANCH = "ARM/${BRANCH}"

DEPENDS =+ "mpfr gmp libmpc"
NATIVEDEPS = "mpfr-native gmp-native libmpc-native zlib-native"

LICENSE="GPL-3.0-with-GCC-exception & GPLv3"

LIC_FILES_CHKSUM = "file://COPYING;md5=59530bdf33659b29e73d4adb9f9f6552 \
                   file://COPYING3;md5=d32239bcb673463ab874e80d47fae504 \
                   file://COPYING3.LIB;md5=6a6a8e020838b23406c81b19c1d46df6 \
                   file://COPYING.LIB;md5=2d5025d4aa3495befef8f17206a5b0a1 \
		   file://COPYING.RUNTIME;md5=fe60d87048567d4fe8c8a0ed2448bcc8"

SRC_URI = "svn://gcc.gnu.org/svn/gcc/branches;module=${SRC_BRANCH} \
file://optional_libstdc.patch \
file://kill-multiarch.patch \
"

S = "${TMPDIR}/work-shared/gcc-${PV}-${PR}/${SRC_BRANCH}"
B = "${WORKDIR}/${BRANCH}/build.${HOST_SYS}.${TARGET_SYS}"

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
			--with-ppl=no \
			--with-cloog=no \
			--enable-checking=release \
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

EXTRA_OECONF_append_libc-uclibc = " --disable-decimal-float "

EXTRA_OECONF_PATHS = " \ 
                      --with-gxx-include-dir=${STAGING_DIR_TARGET}${target_includedir}/c++ \ 
                      --with-sysroot=${STAGING_DIR_TARGET} \ 
                      --with-build-sysroot=${STAGING_DIR_TARGET}"

do_configure_prepend () {
        # teach gcc to find correct target includedir when checking libc ssp support
        mkdir -p ${B}/gcc
        echo "NATIVE_SYSTEM_HEADER_DIR = ${SYSTEMHEADERS}" > ${B}/gcc/t-oe
        cat ${S}/gcc/defaults.h | grep -v "\#endif.*GCC_DEFAULTS_H" > ${B}/gcc/defaults.h.new
        cat >>${B}/gcc/defaults.h.new <<_EOF
#ifndef STANDARD_STARTFILE_PREFIX_1
#define STANDARD_STARTFILE_PREFIX_1 "${SYSTEMLIBS}"
#endif
#ifndef STANDARD_STARTFILE_PREFIX_2
#define STANDARD_STARTFILE_PREFIX_2 "${SYSTEMLIBS1}"
#endif
#define SYSTEMLIBS_DIR "${SYSTEMLIBS}"
#endif /* ! GCC_DEFAULTS_H */
_EOF
        mv ${B}/gcc/defaults.h.new ${B}/gcc/defaults.h
}

