BPV = "2.24.0"
MMYY = "14.11"
RELEASE = "20${MMYY}-2"
PR = "r${RELEASE}"

LIC_FILES_CHKSUM="\
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
     file://fix-pr16428.patch \
     file://replace_macros_with_static_inline.patch;apply=no \
     file://0001-Fix-MMIX-build-breakage-from-bfd_set_section_vma-cha.patch;apply=no \
     file://binutils-uninitialised-warning.patch \
     file://0001-AArch64-Define-LP64-LE-loader-name.patch \
     file://0001-AArch64-Define-LP64-BE-linker-name.patch \
     "

SRC_URI[md5sum] = "05c1d4bc718ec05f6d53785eea10763f"
SRC_URI[sha256sum] = "9196bb6f53c6f113681f06fc396f615101e5f367a4ea48dbcbe45616d5eb1d06"

S = "${WORKDIR}/binutils-linaro-${BPV}-${RELEASE}"
