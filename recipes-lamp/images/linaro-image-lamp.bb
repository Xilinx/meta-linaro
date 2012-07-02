inherit core-image

IMAGE_INSTALL += "\
	lighttpd \
	lighttpd-module-fastcgi \
	mysql5-server \
	mysql5-client \
	php-cgi \
	php-pear \
	"

IMAGE_FEATURES += "package-management ssh-server-dropbear"
