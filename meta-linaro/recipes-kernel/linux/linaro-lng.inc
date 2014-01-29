DESCRIPTION = "Linaro LNG Kernel Basic support recipe"
SECTION = "kernel"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=d7810fab7487fb0aad327b76f1be7cd7"

SRCREV = "${AUTOREV}"
SRCREV_FORMAT = "kernel"
S = "${WORKDIR}/git"

do_configure_prepend_lng-x86-64() {
    scripts/kconfig/merge_config.sh -m arch/x86/configs/x86_64_defconfig \
     linaro/configs/hugepage.conf linaro/configs/ovs.conf \
     linaro/configs/kvm-host.conf linaro/configs/no_hz_full.conf
    scripts/config -e CONFIG_DEVTMPFS
    scripts/config -e CONFIG_DEVTMPFS_MOUNT
    scripts/config -e CONFIG_E1000E
    scripts/config -e CONFIG_IXGBE
}

do_configure_prepend_lng-rt-x86-64() {
    scripts/kconfig/merge_config.sh -m arch/x86/configs/x86_64_defconfig \
     linaro/configs/hugepage.conf linaro/configs/preempt-rt.conf \
     linaro/configs/ovs.conf linaro/configs/kvm-host.conf \
     linaro/configs/no_hz_full.conf
    scripts/config -e CONFIG_DEVTMPFS
    scripts/config -e CONFIG_DEVTMPFS_MOUNT
    scripts/config -e CONFIG_E1000E
    scripts/config -e CONFIG_IXGBE
}
