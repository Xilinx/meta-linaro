require recipes-devtools/gcc/gcc-common.inc
require recipes-devtools/gcc/gcc-4.7.inc

PV = "aarch64-4.7"

# BINV should be incremented after updating to a revision
# after a minor gcc release (e.g. 4.7.1 or 4.7.2) has been made
# the value will be minor-release+1 e.g. if current minor release was
# 4.7.1 then the value below will have 2 which will mean 4.7.2
# which will be next minor release and so on.

BINV = "4.7.3"

DEFAULT_PREFERENCE_aarch64 = "1"

SRCREV = "${AUTOREV}"
BRANCH = "aarch64-4.7-branch"
SRC_BRANCH = "ARM/${BRANCH}"

SRC_URI = "svn://gcc.gnu.org/svn/gcc/branches;module=${SRC_BRANCH} \
           file://gcc-4.3.1-ARCH_FLAGS_FOR_TARGET.patch \
           file://100-uclibc-conf.patch \
           file://gcc-uclibc-locale-ctype_touplow_t.patch \
           file://200-uclibc-locale.patch  \
           file://203-uclibc-locale-no__x.patch; \
           file://204-uclibc-locale-wchar_fix.patch; \
           file://205-uclibc-locale-update.patch; \
           file://301-missing-execinfo_h.patch  \
           file://302-c99-snprintf.patch  \
           file://303-c99-complex-ugly-hack.patch  \
           file://304-index_macro.patch  \
           file://305-libmudflap-susv3-legacy.patch  \
           file://306-libstdc++-namespace.patch  \
           file://740-sh-pr24836.patch  \
           file://800-arm-bigendian.patch  \
           file://gcc-poison-system-directories.patch \
           file://gcc-poison-dir-extend.patch \
           file://gcc-4.3.3-SYSROOT_CFLAGS_FOR_TARGET.patch \
           file://64bithack.patch \
           file://optional_libstdc.patch \
           file://disable_relax_pic_calls_flag.patch \
           file://COLLECT_GCC_OPTIONS.patch \
           file://use-defaults.h-and-t-oe-in-B.patch \
           file://ppc_with_cpu.patch \
           file://ppce5500-e6500-support.patch \
           file://rs6000-tables.patch \
           file://define_insn_reservation.patch \
           file://pr32219.patch \
           file://fortran-cross-compile-hack.patch \
           file://libgcc-sjlj-check.patch \
           file://cpp-honor-sysroot.patch \
           file://mips64-default-n64.patch \
           file://GLIBC_DYNAMIC_LINKER.patch \
           file://arm-hard-float-loader.patch \
           file://gcc-argument-list-too-long.patch \
           file://fix-g++-sysroot.patch \
           file://disablesdt.patch \
           file://libtool.patch \
           file://gcc-armv4-pass-fix-v4bx-to-ld.patch \
           file://ppc_no_crtsavres.patch \
           file://0001-crtstuff.c-USE_PT_GNU_EH_FRAME-Define-for-systems-us.patch \
           file://0001-Makefile.in-vis_hide-gen-hide-list-Do-not-make-defin.patch \
"

S = "${TMPDIR}/work-shared/gcc-${PV}-${PR}/${SRC_BRANCH}"
B = "${WORKDIR}/${BRANCH}/build.${HOST_SYS}.${TARGET_SYS}"
