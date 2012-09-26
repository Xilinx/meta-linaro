KERNEL_ENABLE_CGROUPS = "1"

require recipes-kernel/linux/linux.inc

PR = "r2"

SRC_URI = "git://git.linaro.org/people/omarrmz/linux-aarch64.git;branch=linaro-armv8"

S = "${WORKDIR}/git"

SRCREV="${AUTOREV}"

PV = "3.6-rc+git${SRCPV}"

COMPATIBLE_HOST = "aarch64"

SRC_URI += "file://defconfig"

KERNEL_IMAGETYPE = "Image"
