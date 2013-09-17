require linux-linaro-fastmodel.inc

SRC_URI = " \
           git://git.linaro.org/kernel/linux-linaro-tracking.git;branch=linux-linaro;name=kernel \
           git://git.kernel.org/pub/scm/linux/kernel/git/cmarinas/boot-wrapper-aarch64.git;branch=master;name=bootwrapper;destsuffix=bootwrapper \
"

do_configure_prepend() {
    ARCH=arm64 scripts/kconfig/merge_config.sh -m linaro/configs/linaro-base.conf \
      linaro/configs/linaro-base64.conf linaro/configs/vexpress64.conf \
      linaro/configs/distribution.conf
}
