DESCRIPTION = "Linaro recipe for Aarch64 fast model kernels"

SRCREV_kernel="e72caa28875ec600a6d1bb3e11813fd21c4adb16"
PV = "3.15+git${SRCPV}"

SRC_URI_append = " git://git.linaro.org/git/kernel/linux-linaro-tracking.git;protocol=http;branch=linux-linaro;name=kernel "

include linaro-kernel.inc
include bootwrapper.inc

COMPATIBLE_HOST = "aarch64"
KERNEL_IMAGETYPE = "Image"
BOOTARGS_COMMON = "console=ttyAMA0 mem=2048M devtmpfs.mount=1 earlyprintk=pl011,0x1c090000 consolelog=9 rw"

do_configure_prepend() {
    . ../ubuntu-ci/configs/vexpress64.cfg
    ARCH=arm64 scripts/kconfig/merge_config.sh -m $linaro_base_config_frags $ubuntu_config_frag $board_config_frags
}
