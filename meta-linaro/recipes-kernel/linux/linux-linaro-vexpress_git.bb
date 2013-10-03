DESCRIPTION = "Linaro Kernel For Vexpress/KVM"

require linaro-kernel.inc

SRCREV = "2a0563041d1672e7e2e09703aa4d3feffc72053c"
PV = "3.11+git${SRCPV}"

KERNEL_DEVICETREE = "vexpress-v2p-ca15-tc1.dtb"

BOOTARGS_COMMON = "root=/dev/mmcblk0p2 console=ttyAMA0 consolelog=9 mem=1024M rw rootwait"

SRC_URI = "git://git.linaro.org/kernel/linux-linaro-tracking.git;branch=linux-linaro"


