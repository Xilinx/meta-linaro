DESCRIPTION = "Linaro Stable Kernel For Vexpress/KVM"

require linaro-kernel.inc

PV = "3.10+git${SRCPV}"

KERNEL_DEVICETREE = "vexpress-v2p-ca15-tc1.dtb"

BOOTARGS_COMMON = "root=/dev/mmcblk0p2 console=ttyAMA0 consolelog=9 mem=1024M rw rootwait"

SRC_URI = "git://git.linaro.org/kernel/linux-linaro-stable.git;branch=lsk"


