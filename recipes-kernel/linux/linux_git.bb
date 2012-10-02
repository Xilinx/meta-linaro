KERNEL_ENABLE_CGROUPS = "1"

require recipes-kernel/linux/linux.inc

PR = "r3"

SRC_URI = "git://git.linaro.org/people/omarrmz/linux-aarch64.git;branch=linaro-armv8;name=kernel \
           git://git.kernel.org/pub/scm/linux/kernel/git/cmarinas/boot-wrapper-aarch64.git;name=bootwrapper;destsuffix=bootwrapper \
           file://change-cmdline.patch;striplevel=0 \
"

SRCREV_FORMAT = "kernel"

S = "${WORKDIR}/git"

SRCREV = "${AUTOREV}"

PV = "3.6-rc+git${SRCPV}"

COMPATIBLE_HOST = "aarch64"

SRC_URI += "file://defconfig"

KERNEL_IMAGETYPE = "Image"

BW = "${WORKDIR}/bootwrapper"

do_compile_append() {
    install -m 0644 ${S}/arch/arm64/boot/Image ${BW}/
    cd ${BW}
    oe_runmake DTC=${S}/scripts/dtc/dtc \
         FDT_SRC=${S}/arch/arm64/boot/dts/vexpress-v2p-aarch64.dts \
         CC="${CC}" LD="${LD}"
}

do_deploy_append() {
	install -d ${DEPLOY_DIR_IMAGE}
	install -m 0644 ${BW}/linux-system.axf ${DEPLOY_DIR_IMAGE}/linux-system-${KERNEL_IMAGE_BASE_NAME}.axf
	cd ${DEPLOY_DIR_IMAGE}
	ln -sf linux-system-${KERNEL_IMAGE_BASE_NAME}.axf linux-system.axf
}
