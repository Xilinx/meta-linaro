require qemu.inc

LIC_FILES_CHKSUM = "file://COPYING;md5=441c28d2cf86e15a37fa47e15a72fbac \
                    file://COPYING.LIB;endline=24;md5=c04def7ae38850e7d3ef548588159913"

PV = "1.5.git${SRCPV}"
PR = "r0"

QEMU_TARGETS_aarch64 = ""
EXTRA_OECONF_aarch64 += "--enable-tcg-interpreter --enable-kvm --enable-fdt --target-list=aarch64-softmmu"

SRC_URI = "git://git.linaro.org/people/pmaydell/qemu-aarch64.git;branch=kvm-aarch64-wip"
S = "${WORKDIR}/git"

SRCREV = "${AUTOREV}"

