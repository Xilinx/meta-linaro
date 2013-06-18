require linaro-image-common.inc

IMAGE_INSTALL += " \
    rt-tests \
    netperf \
    ${COMMON_SDK_IMAGE_INSTALL}"

IMAGE_FEATURES += "\
	dev-pkgs \
	staticdev-pkgs \
	tools-debug \
	tools-sdk \
	"
