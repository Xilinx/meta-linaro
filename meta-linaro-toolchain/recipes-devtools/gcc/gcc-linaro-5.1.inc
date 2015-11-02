require recipes-devtools/gcc/gcc-5.1.inc
PV = "linaro-${BASEPV}"

MMYY = "15.08"
RELEASE = "20${MMYY}"
PR = "r${RELEASE}"
BINV = "5.1.1"

FILESPATH = "${@base_set_filespath([ '${FILE_DIRNAME}/gcc-${PV}' ], d)}"

SRC_URI = "https://releases.linaro.org/components/toolchain/gcc-linaro/${BASEPV}-${RELEASE}/gcc-${PV}-${RELEASE}.tar.xz \
           file://0001-gcc-4.3.1-ARCH_FLAGS_FOR_TARGET.patch \
           file://0002-uclibc-conf.patch \
           file://0003-gcc-uclibc-locale-ctype_touplow_t.patch \
           file://0004-uclibc-locale.patch \
           file://0005-uclibc-locale-no__x.patch \
           file://0006-uclibc-locale-wchar_fix.patch \
           file://0007-uclibc-locale-update.patch \
           file://0008-missing-execinfo_h.patch \
           file://0009-c99-snprintf.patch \
           file://0010-gcc-poison-system-directories.patch \
           file://0011-gcc-poison-dir-extend.patch \
           file://0012-gcc-4.3.3-SYSROOT_CFLAGS_FOR_TARGET.patch \
           file://0013-64-bit-multilib-hack.patch \
           file://0014-optional-libstdc.patch \
           file://0015-gcc-disable-MASK_RELAX_PIC_CALLS-bit.patch \
           file://0016-COLLECT_GCC_OPTIONS.patch \
           file://0017-Use-the-defaults.h-in-B-instead-of-S-and-t-oe-in-B.patch \
           file://0018-fortran-cross-compile-hack.patch \
           file://0019-libgcc-sjlj-check.patch \
           file://0020-cpp-honor-sysroot.patch \
           file://0021-MIPS64-Default-to-N64-ABI.patch \
           file://0022-Define-GLIBC_DYNAMIC_LINKER-and-UCLIBC_DYNAMIC_LINKE.patch \
           file://0023-gcc-Fix-argument-list-too-long-error.patch \
           file://0024-Disable-sdt.patch \
           file://0025-libtool.patch \
           file://0026-gcc-armv4-pass-fix-v4bx-to-linker-to-support-EABI.patch \
           file://0027-Use-the-multilib-config-files-from-B-instead-of-usin.patch \
           file://0028-Avoid-using-libdir-from-.la-which-usually-points-to-.patch \
           file://0029-export-CPP.patch \
           file://0030-Enable-SPE-AltiVec-generation-on-powepc-linux-target.patch \
           file://0031-Disable-the-MULTILIB_OSDIRNAMES-and-other-multilib-o.patch \
           file://0032-Ensure-target-gcc-headers-can-be-included.patch \
           file://0033-gcc-4.8-won-t-build-with-disable-dependency-tracking.patch \
           file://0034-Don-t-search-host-directory-during-relink-if-inst_pr.patch \
           file://0035-Dont-link-the-plugins-with-libgomp-explicitly.patch \
           file://0036-Use-SYSTEMLIBS_DIR-replacement-instead-of-hardcoding.patch \
           file://0037-pr65779.patch \
           file://0038-fix-g++-sysroot.patch \
           file://0039-libcc1-fix-libcc1-s-install-path-and-rpath.patch \
           file://0040-nativesdk-gcc-support.patch \
           file://0041-handle-target-sysroot-multilib.patch \
           file://0042-cxxflags-for-build.patch \
          "

#           file://AArch64-Define-BE-loader-name-default-be.patch 
#           file://use-lib-for-aarch64.patch

SRC_URI[md5sum] = "dc8b8d363be10e16a2904eeea4257cf1"
SRC_URI[sha256sum] = "3adb05b95e575e06db786adfa00a866d52eb735d14a763dccf1b47d8682f31b4"

S = "${TMPDIR}/work-shared/gcc-${PV}-${PR}/gcc-${PV}-${RELEASE}"
B = "${WORKDIR}/gcc-${PV}-${RELEASE}/build.${HOST_SYS}.${TARGET_SYS}"

EXTRA_OECONF_append_aarchilp32 = " --with-abi=ilp32"
