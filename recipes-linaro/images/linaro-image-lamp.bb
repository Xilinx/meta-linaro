inherit core-image

PR = "r2"

IMAGE_INSTALL += "\
	apache2 \
	mysql5-server \
	mysql5-client \
	modphp \
	sudo \
	linaro-lava-tests \
	"

IMAGE_FEATURES += "package-management ssh-server-openssh"
