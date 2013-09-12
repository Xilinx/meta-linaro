require recipes-devtools/qemu/qemu.inc

SRCREV = "${AUTOREV}"

LIC_FILES_CHKSUM = "file://COPYING;md5=441c28d2cf86e15a37fa47e15a72fbac \
                    file://COPYING.LIB;endline=24;md5=c04def7ae38850e7d3ef548588159913"

PV = "1.6.0+git${SRCPV}"
PR = "r2"

#COMPATIBLE_HOST_append="aarch64 armeb"
SRC_URI_prepend = "git://git.qemu.org/qemu.git"
SRC_URI_aarch64_append = "file://aarch64-softmmu.patch"
S = "${WORKDIR}/git"
EXTRA_OECONF+="--enable-kvm --enable-fdt"
EXTRA_OECONF_aarch64+="--target-list=aarch64-softmmu --enable-tcg-interpreter"

DEFAULT_PREFERENCE_arm = "1"
DEFAULT_PREFERENCE_aarch64 = "1"
DEFAULT_PREFERENCE_armeb = "1"
