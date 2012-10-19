inherit core-image

PR = "r1"

IMAGE_INSTALL += "\
	apache2 \
	mysql5-server \
	mysql5-client \
	modphp \
	"

IMAGE_FEATURES += "package-management ssh-server-openssh"
