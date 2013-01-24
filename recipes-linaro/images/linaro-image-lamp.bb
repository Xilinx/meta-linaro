require linaro-image-common.inc

PR = "r3"

IMAGE_INSTALL += "\
	apache2 \
	mysql5-server \
	mysql5-client \
	php-fpm \
	php-fpm-apache2 \
	"

IMAGE_FEATURES += "package-management"
