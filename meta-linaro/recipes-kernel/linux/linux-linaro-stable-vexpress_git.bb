DESCRIPTION = "Linaro Stable Kernel For Vexpress/KVM"

PV = "3.10+git${SRCPV}"
SRCREV_kernel="bfbceba4d4e9a3a538a80a1a0af18db55c9924a4"
SRC_URI_append = " git://git.linaro.org/git/kernel/linux-linaro-stable.git;protocol=http;branch=linux-linaro-lsk;name=kernel "
require linaro-kernel.inc

KERNEL_DEVICETREE = "vexpress-v2p-ca15-tc1.dtb"
BOOTARGS_COMMON = "root=/dev/mmcblk0p2 console=ttyAMA0 consolelog=9 mem=1024M rw rootwait"
COMPATIBLE_HOST = "arm.*"
KERNEL_IMAGETYPE = "zImage"

do_configure_prepend() {
    . ../ubuntu-ci/configs/lsk-vexpress.cfg
    ARCH=arm scripts/kconfig/merge_config.sh -m $linaro_base_config_frags $ubuntu_config_frag $board_config_frags
}
