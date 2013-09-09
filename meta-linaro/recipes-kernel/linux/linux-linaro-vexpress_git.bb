DESCRIPTION = "Linaro Kernel For Vexpress/KVM"
SECTION = "kernel"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=d7810fab7487fb0aad327b76f1be7cd7"

inherit kernel siteinfo
require recipes-kernel/linux/linux-dtb.inc

PV = "3.11+git${SRCPV}"

SRCREV = "${AUTOREV}"
SRCREV_FORMAT = "kernel"
S = "${WORKDIR}/git"

COMPATIBLE_HOST = "arm.*"
KERNEL_IMAGETYPE = "zImage"
KERNEL_DEVICETREE = "vexpress-v2p-ca15-tc1.dtb"

BOOTARGS_COMMON = "root=/dev/mmcblk0p2 console=ttyAMA0 consolelog=9 mem=1024M rw rootwait"

SRC_URI = "git://git.linaro.org/kernel/linux-linaro-tracking.git;branch=linux-linaro"

do_configure_prepend() {
    ARCH=arm scripts/kconfig/merge_config.sh -m linaro/configs/linaro-base.conf \
      linaro/configs/distribution.conf linaro/configs/vexpress.conf \ 
      linaro/configs/kvm-guest.conf linaro/configs/kvm-host.conf
}

