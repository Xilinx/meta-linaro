inherit core-image

IMAGE_FEATURES += "ssh-server-openssh nfs-server"

IMAGE_INSTALL += " \
	linaro-lava-tests \
	sudo \
    "

IMAGE_INSTALL_aarch64 += "perf"
