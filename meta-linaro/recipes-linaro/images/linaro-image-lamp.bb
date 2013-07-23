require linaro-image-common.inc

IMAGE_INSTALL += " \
    apache2 \
    mysql5-server \
    mysql5-client \
    php-fpm \
    php-fpm-apache2 \
    ${SDK_IMAGE_INSTALL}"

IMAGE_FEATURES += "\
	dev-pkgs \
	staticdev-pkgs \
	tools-debug \
	tools-sdk \
	"
