KERNEL_ENABLE_CGROUPS = "1"

require recipes-kernel/linux/linux.inc

PR = "r1"

SRC_URI = "git://git.kernel.org/pub/scm/linux/kernel/git/torvalds/linux-2.6.git;name=kernel \
           git://git.kernel.org/pub/scm/linux/kernel/git/cmarinas/boot-wrapper-aarch64.git;name=bootwrapper;destsuffix=bootwrapper \
"

SRCREV_FORMAT = "kernel"

S = "${WORKDIR}/git"

SRCREV_kernel = "e9296e89b85604862bd9ec2d54dc43edad775c0d"
SRCREV_bootwrapper = "${AUTOREV}"

PV = "3.7.0+rc7+git${SRCPV}"

COMPATIBLE_HOST = "aarch64"

SRC_URI += "file://defconfig \
            file://0001-arm64-versatile-express-foundation-device-tree.patch \
            file://0007-arm64-Force-use-of-common-clk-at-architecture-level.patch \
            file://0008-arm64-Include-the-clkdev.h-generic-header.patch \
            file://0014-mmc-mmci-use-io-read-write-_rep-accessors-instead-of.patch \
            file://0015-net-smc91x-use-io-read-write-_rep-accessors-instead-.patch \
            file://0016-irqchip-Add-ARM-Generic-Interrupt-Controller-support.patch \
            file://0017-arm64-ARMv8-software-model-SoC-support.patch \
            file://0018-arm64-Add-CLCD-support-to-the-ARMv8-model-platform.patch \
            file://0019-arm64-Add-simple-earlyprintk-support.patch \
            file://0020-arm64-libgcc.a-breakage.patch \
            "

KERNEL_IMAGETYPE = "Image"

BW = "${WORKDIR}/bootwrapper"

BOOTARGS_COMMON = "console=ttyAMA0 mem=2048M devtmpfs.mount=1 earlyprintk rw"

do_compile_append() {
    install -m 0644 ${S}/arch/arm64/boot/Image ${BW}/
    cd ${BW}
    make clean
    oe_runmake DTC=${S}/scripts/dtc/dtc \
         FDT_SRC=${S}/arch/arm64/boot/dts/vexpress-v2p-aarch64.dts \
         CC="${CC}" LD="${LD}" \
         IMAGE=linux-system-ve.axf \
         BOOTARGS='"${BOOTARGS_COMMON} root=/dev/mmcblk0"'
    make clean
    oe_runmake DTC=${S}/scripts/dtc/dtc \
         FDT_SRC=${S}/arch/arm64/boot/dts/vexpress-foundation-v8.dts \
         CC="${CC}" LD="${LD}" \
         IMAGE=linux-system-foundation.axf \
         BOOTARGS='"${BOOTARGS_COMMON} root=/dev/vda"'
}

do_deploy_append() {
	install -d ${DEPLOYDIR}
	install -m 0644 ${BW}/linux-system-ve.axf ${DEPLOYDIR}/linux-system-ve-${KERNEL_IMAGE_BASE_NAME}.axf
	install -m 0644 ${BW}/linux-system-foundation.axf ${DEPLOYDIR}/linux-system-foundation-${KERNEL_IMAGE_BASE_NAME}.axf
	cd ${DEPLOYDIR}
	ln -sf linux-system-ve-${KERNEL_IMAGE_BASE_NAME}.axf linux-system-ve.axf
	ln -sf linux-system-foundation-${KERNEL_IMAGE_BASE_NAME}.axf linux-system-foundation.axf
}
