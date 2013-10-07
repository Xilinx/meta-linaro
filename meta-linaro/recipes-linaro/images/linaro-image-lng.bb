require linaro-image-common.inc

IMAGE_INSTALL += " \
    arndale-pre-boot \
    bridge-utils \
    calibrator \
    curl \
    fping \
    lmbench \
    ltp \
    netperf \
    openvswitch \
    procps \
    qemu \
    rt-tests \
    systemtap \
    tunctl \
    valgrind \
    "

IMAGE_INSTALL_append_genericarmv7a = "python-numpy"

IMAGE_FEATURES += "\
    dev-pkgs \
    staticdev-pkgs \
    tools-debug \
    tools-sdk \
    "
