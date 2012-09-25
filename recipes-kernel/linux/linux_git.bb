KERNEL_ENABLE_CGROUPS = "1"

require recipes-kernel/linux/linux.inc

PR = "r1"

SRC_URI = "git://git.kernel.org/pub/scm/linux/kernel/git/cmarinas/linux-aarch64.git;branch=soc-armv8-model"

S = "${WORKDIR}/git"

# tag: v3.4 76e10d158efb6d4516018846f60c2ab5501900bc
SRCREV="${AUTOREV}"

PR = "r0"
PV = "3.6-rc5+git${SRCPV}"

COMPATIBLE_HOST = "aarch64"

SRC_URI += "file://defconfig"

KERNEL_IMAGETYPE = "Image"
