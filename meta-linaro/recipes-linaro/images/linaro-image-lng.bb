require linaro-image-common.inc

IMAGE_INSTALL += " \
    arndale-pre-boot \
    bridge-utils \
    calibrator \
    curl \
    fping \
    git \
    lmbench \
    lng-network-config \
    ltp \
    netperf \
    openvswitch \
    packagegroup-core-buildessential \
    procps \
    python-numpy \
    qemu \
    rt-tests \
    tunctl \
    usecpu \
    "

IMAGE_INSTALL_append_armv7a = " \
    latency-test \
    systemtap \
    valgrind \
    trinity-example \
    odp \
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
IMAGE_FSTYPES_append_qemux86 += "cpio.gz"
IMAGE_FSTYPES_lng-x86-64 = "tar.gz cpio.gz"
IMAGE_FSTYPES_lng-rt-x86-64 = "tar.gz cpio.gz"
