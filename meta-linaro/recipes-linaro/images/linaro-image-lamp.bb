require linaro-image-common.inc

IMAGE_INSTALL += " \
    apache2 \
    mysql5-server \
    mysql5-client \
    openjdk-8-jre \
    openjdk-8-jdk \
    php-fpm \
    php-fpm-apache2 \
    xserver-xorg-xvfb \
    ${SDK_IMAGE_INSTALL}"

IMAGE_FEATURES += "\
	dev-pkgs \
	staticdev-pkgs \
	tools-debug \
	tools-sdk \
	"
