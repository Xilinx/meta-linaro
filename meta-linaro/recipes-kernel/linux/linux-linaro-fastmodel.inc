DESCRIPTION = "Linaro recipes for Aarch64 fast model kernels"
SECTION = "kernel"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=d7810fab7487fb0aad327b76f1be7cd7"

inherit kernel siteinfo

PV = "3.11+git${SRCPV}"

SRCREV_bootwrapper = "${AUTOREV}"
SRCREV_kernel = "${AUTOREV}"
SRCREV_FORMAT = "kernel"

S = "${WORKDIR}/git"
BW = "${WORKDIR}/bootwrapper"

COMPATIBLE_HOST = "aarch64"
KERNEL_IMAGETYPE = "Image"

PACKAGES =+ "kernel-bootwrapper"
FILES_kernel-bootwrapper = "/boot/img-foundation.axf"

BOOTARGS_COMMON = "console=ttyAMA0 mem=2048M devtmpfs.mount=1 earlyprintk=pl011,0x1c090000 consolelog=9 rw"

do_compile_append() {
    CROSS=`echo $CC|sed -e s/gcc.*//`
    install -m 0644 ${S}/arch/arm64/boot/Image ${BW}/
    install -m 0644 ${S}/arch/arm64/boot/dts/*.dts* ${BW}/
    cd ${BW}
    make clean
    make DTC=${S}/scripts/dtc/dtc \
         FDT_SRC=foundation-v8.dts \
         CROSS_COMPILE=$CROSS \
         IMAGE=linux-system-foundation.axf \
         BOOTARGS='"${BOOTARGS_COMMON} root=/dev/vda"'
    make clean
    make DTC=${S}/scripts/dtc/dtc \
         FDT_SRC=foundation-v8.dts \
         CROSS_COMPILE=$CROSS \
         IMAGE=img-foundation.axf \
         BOOTARGS='"${BOOTARGS_COMMON} root=/dev/vda2"'
    make clean
    make DTC=${S}/scripts/dtc/dtc \
         FDT_SRC=rtsm_ve-aemv8a.dts \
         CROSS_COMPILE=$CROSS \
         IMAGE=linux-system-ve.axf \
         BOOTARGS='"${BOOTARGS_COMMON} root=/dev/mmcblk0"'
}

do_install_append() {
         install -m 0644 ${BW}/img-foundation.axf ${D}/boot/img-foundation.axf
}

do_deploy_append() {
	install -d ${DEPLOYDIR}
	install -m 0644 ${BW}/linux-system-ve.axf ${DEPLOYDIR}/linux-system-ve-${KERNEL_IMAGE_BASE_NAME}.axf
	install -m 0644 ${BW}/linux-system-foundation.axf ${DEPLOYDIR}/linux-system-foundation-${KERNEL_IMAGE_BASE_NAME}.axf
	install -m 0644 ${BW}/img-foundation.axf ${DEPLOYDIR}/img-foundation-${KERNEL_IMAGE_BASE_NAME}.axf
	cd ${DEPLOYDIR}
	ln -sf linux-system-ve-${KERNEL_IMAGE_BASE_NAME}.axf linux-system-ve.axf
	ln -sf linux-system-foundation-${KERNEL_IMAGE_BASE_NAME}.axf linux-system-foundation.axf
	ln -sf img-foundation-${KERNEL_IMAGE_BASE_NAME}.axf img-foundation.axf
}
