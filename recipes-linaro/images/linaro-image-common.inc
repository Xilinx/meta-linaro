inherit core-image

IMAGE_FEATURES += "ssh-server-openssh nfs-server"

IMAGE_INSTALL += " \
	linaro-lava-tests \
    perf \
	sudo \
    "
