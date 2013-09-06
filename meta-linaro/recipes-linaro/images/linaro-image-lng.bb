require linaro-image-common.inc

IMAGE_INSTALL += " \
    arndale-pre-boot \
    calibrator \
    fping \
    ltp \
    netperf \
    openvswitch \
    procps \
    rt-tests \
    systemtap \
    valgrind \
    python-numpy \
    "

IMAGE_FEATURES += "\
	dev-pkgs \
	staticdev-pkgs \
	tools-debug \
	tools-sdk \
	"
