DESCRIPTION = "Linux Kernel"
SECTION = "kernel"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=d7810fab7487fb0aad327b76f1be7cd7"

inherit kernel siteinfo

PV = "3.8+git${SRCPV}"

SRC_URI = " \
           git://git.linaro.org/kernel/linux-linaro-tracking.git;branch=linux-linaro;name=kernel \
           git://git.linaro.org/arm/models/boot-wrapper-aarch64.git;branch=ubuntu;name=bootwrapper;destsuffix=bootwrapper \
"

SRCREV_bootwrapper = "${AUTOREV}"
SRCREV_kernel = "${AUTOREV}"
SRCREV_FORMAT = "kernel"

S = "${WORKDIR}/git"
BW = "${WORKDIR}/bootwrapper"

COMPATIBLE_HOST = "aarch64"
KERNEL_IMAGETYPE = "Image"

BOOTARGS_COMMON = "console=ttyAMA0 mem=2048M devtmpfs.mount=1 earlyprintk=pl011,0x1c0900000 rw"

do_configure_prepend() {
    ARCH=arm64 scripts/kconfig/merge_config.sh -m linaro/configs/linaro-base.conf \
    linaro/configs/vexpress64.conf linaro/configs/ubuntu-minimal.conf
}

do_compile_append() {
    install -m 0644 ${S}/arch/arm64/boot/Image ${BW}/
    cd ${BW}
    make clean
    oe_runmake DTC=${S}/scripts/dtc/dtc \
         FDT_SRC=${S}/arch/arm64/boot/dts/foundation-v8.dts \
         CC="${CC}" LD="${LD}" \
         IMAGE=linux-system-foundation.axf \
         BOOTARGS='"${BOOTARGS_COMMON} root=/dev/vda"'
    make clean
    oe_runmake DTC=${S}/scripts/dtc/dtc \
         FDT_SRC=${S}/arch/arm64/boot/dts/vexpress-v2p-aarch64.dts \
         CC="${CC}" LD="${LD}" \
         IMAGE=linux-system-ve.axf \
         BOOTARGS='"${BOOTARGS_COMMON} root=/dev/mmcblk0"'
}

do_deploy_append() {
	install -d ${DEPLOYDIR}
	install -m 0644 ${BW}/linux-system-ve.axf ${DEPLOYDIR}/linux-system-ve-${KERNEL_IMAGE_BASE_NAME}.axf
	install -m 0644 ${BW}/linux-system-foundation.axf ${DEPLOYDIR}/linux-system-foundation-${KERNEL_IMAGE_BASE_NAME}.axf
	cd ${DEPLOYDIR}
	ln -sf linux-system-ve-${KERNEL_IMAGE_BASE_NAME}.axf linux-system-ve.axf
	ln -sf linux-system-foundation-${KERNEL_IMAGE_BASE_NAME}.axf linux-system-foundation.axf
}
