inherit core-image

DESCRIPTION = "A small SDK based image for Linaro development work."

IMAGE_INSTALL = "\
	task-core-boot \
	${ROOTFS_PKGMANAGE_BOOTSTRAP} \
	${CORE_IMAGE_EXTRA_INSTALL} \
	"

IMAGE_FEATURES += "\
	dev-pkgs \
	tools-debug \
	tools-sdk \
	ssh-server-openssh \
	package-management \
	"
