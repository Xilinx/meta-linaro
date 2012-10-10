KERNEL_ENABLE_CGROUPS = "1"

require recipes-kernel/linux/linux.inc

PR = "r1"

SRC_URI = "git://git.linaro.org/kernel/linaro-aarch64.git;branch=linaro-aarch64-3.6;name=kernel \
           git://git.kernel.org/pub/scm/linux/kernel/git/cmarinas/boot-wrapper-aarch64.git;name=bootwrapper;destsuffix=bootwrapper \
"

SRCREV_FORMAT = "kernel"

S = "${WORKDIR}/git"

SRCREV = "${AUTOREV}"

PV = "3.6.0+git${SRCPV}"

COMPATIBLE_HOST = "aarch64"

SRC_URI += "file://defconfig"

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
	install -d ${DEPLOY_DIR_IMAGE}
	install -m 0644 ${BW}/linux-system-ve.axf ${DEPLOY_DIR_IMAGE}/linux-system-ve-${KERNEL_IMAGE_BASE_NAME}.axf
	install -m 0644 ${BW}/linux-system-foundation.axf ${DEPLOY_DIR_IMAGE}/linux-system-foundation-${KERNEL_IMAGE_BASE_NAME}.axf
	cd ${DEPLOY_DIR_IMAGE}
	ln -sf linux-system-ve-${KERNEL_IMAGE_BASE_NAME}.axf linux-system-ve.axf
	ln -sf linux-system-foundation-${KERNEL_IMAGE_BASE_NAME}.axf linux-system-foundation.axf
}
