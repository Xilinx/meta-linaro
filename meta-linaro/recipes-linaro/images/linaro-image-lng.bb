require linaro-image-common.inc

IMAGE_INSTALL += " \
    rt-tests \
    netperf \
    ltp"

IMAGE_FEATURES += "\
	dev-pkgs \
	staticdev-pkgs \
	tools-debug \
	tools-sdk \
	"
