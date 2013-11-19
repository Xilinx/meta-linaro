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
    python-numpy \
    qemu \
    rt-tests \
    tunctl \
    "

IMAGE_INSTALL_append_armv7a = " \
    latency-test \
    systemtap \
    valgrind \
    trinity-example \
    "

IMAGE_INSTALL_append_aarch64 = " \
    trinity-example \
    "

IMAGE_FEATURES += "\
    dev-pkgs \
    staticdev-pkgs \
    tools-debug \
    tools-sdk \
    "
