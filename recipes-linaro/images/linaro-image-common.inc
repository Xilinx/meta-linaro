inherit core-image

IMAGE_FEATURES += "ssh-server-openssh nfs-server"

IMAGE_INSTALL += " \
	linaro-lava-tests \
	sudo \
	stress \
    "

IMAGE_INSTALL_append_aarch64 += "perf"
