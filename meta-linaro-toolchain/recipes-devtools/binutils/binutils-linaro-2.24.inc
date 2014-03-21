BPV = "2.24"
MMYY = "14.03"
RELEASE = "20${MMYY}"
PR = "r${RELEASE}"

LIC_FILES_CHKSUM="\
    file://src-release;endline=17;md5=4830a9ef968f3b18dd5e9f2c00db2d35\
    file://COPYING;md5=59530bdf33659b29e73d4adb9f9f6552\
    file://COPYING.LIB;md5=9f604d8a4f8e74f4f5140845a21b6674\
    file://COPYING3;md5=d32239bcb673463ab874e80d47fae504\
    file://COPYING3.LIB;md5=6a6a8e020838b23406c81b19c1d46df6\
    file://gas/COPYING;md5=d32239bcb673463ab874e80d47fae504\
    file://include/COPYING;md5=59530bdf33659b29e73d4adb9f9f6552\
    file://include/COPYING3;md5=d32239bcb673463ab874e80d47fae504\
    file://libiberty/COPYING.LIB;md5=a916467b91076e631dd8edb7424769c7\
    file://bfd/COPYING;md5=d32239bcb673463ab874e80d47fae504\
    "

SRC_URI = "\
     http://releases.linaro.org/${MMYY}/components/toolchain/binutils-linaro/binutils-linaro-${BPV}-${RELEASE}.tar.xz \
     file://binutils-uclibc-100-uclibc-conf.patch \
     file://binutils-uclibc-300-001_ld_makefile_patch.patch \
     file://binutils-uclibc-300-006_better_file_error.patch \
     file://binutils-uclibc-300-012_check_ldrunpath_length.patch \
     file://binutils-uclibc-gas-needs-libm.patch \
     file://libtool-2.4-update.patch \
     file://libiberty_path_fix.patch \
     file://binutils-poison.patch \
     file://libtool-rpath-fix.patch \
     file://binutils-armv5e.patch \
     file://mips64-default-ld-emulation.patch \
     file://binutils-xlp-support.patch \
     file://fix-pr15815.patch;apply=no \
     file://fix-pr2404.patch \
     file://fix-pr16476.patch \
     file://0001-AArch64-Define-LP64-LE-loader-name.patch \
     file://0001-AArch64-Define-LP64-BE-linker-name.patch \
     "

SRC_URI[md5sum] = "36e455b8c2677787ab12a18bcade5924"
SRC_URI[sha256sum] = "8c0552fd52c7a5ee29dcc046c781eb2b4d86d008eb37980c4c3cc1f434d5f0b2"

S = "${WORKDIR}/binutils-${PV}-${RELEASE}"
