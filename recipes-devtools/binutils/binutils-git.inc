#FILESPATHPKG =. "binutils-git:"
SRCREV = "356e60f035fc024240085a6e3ddd800e8351ff17"
PR_append = "+gitr${SRCPV}"
LICENSE = "GPLv3"

PV = "2.23.51.20121130"
PR = "r0"

S = "${WORKDIR}/git"

SRC_URI = "git://sourceware.org/git/binutils.git;branch=master;protocol=git \
           file://aarch64-new-macros.patch \
           file://aarch64-elf_backend_grok_prstatus.patch \
"

DEFAULT_PREFERENCE = "1"

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
