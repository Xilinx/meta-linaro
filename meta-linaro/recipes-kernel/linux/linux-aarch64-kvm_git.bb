require linux-linaro.inc

SRC_URI = " \
           git://git.kernel.org/pub/scm/linux/kernel/git/maz/arm-platforms.git;branch=kvm-arm64/kvm;name=kernel \
           git://git.linaro.org/arm/models/boot-wrapper-aarch64.git;branch=master;name=bootwrapper;destsuffix=bootwrapper \
"

FILESEXTRAPATHS_prepend := "${THISDIR}/files:"
SRC_URI_append = " file://kvm-config"

DEFAULT_PREFERENCE = "-1"

do_configure_prepend() {
    ARCH=arm64 make defconfig
    cat ../kvm-config >> .config
    ARCH=arm64 make oldconfig

}
