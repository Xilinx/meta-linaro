require linaro-image-common.inc

IMAGE_INSTALL += " \
    ${LAMP_IMAGE_INSTALL} \
    ${SDK_IMAGE_INSTALL}"

IMAGE_FEATURES += "\
	dev-pkgs \
	staticdev-pkgs \
	tools-debug \
	tools-sdk \
	"
