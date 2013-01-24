require linaro-image-common.inc

DESCRIPTION = "A small SDK based image for Linaro development work."

PR = "r2"

IMAGE_INSTALL += "\
	ltp \
	"

IMAGE_FEATURES += "\
	dev-pkgs \
	staticdev-pkgs \
	tools-debug \
	tools-sdk \
	package-management \
	"
