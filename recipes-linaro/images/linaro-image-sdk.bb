require linaro-image-common.inc

DESCRIPTION = "A small SDK based image for Linaro development work."

PR = "r2"

IMAGE_INSTALL += "\
	ltp \
	"

# add hiphopvm dependencies

IMAGE_INSTALL += " \
	bison \
	boost-date-time \
	boost-filesystem \
	boost-graph \
	boost-iostreams \
	boost-program-options \
	boost-regex \
	boost-signals \
	boost-system \
	boost-thread \
	libbz2 \
	cmake \
	elfutils-dev \
	expat \
	flex \
	gd \
	google-glog \
	icu \
	libcap \
	libevent-fb \
	libmcrypt \
	libmemcached \
	libpam \
	libxml2 \
	libmysqlclient-r \
	ncurses \
	onig \
	openldap \
	openssl \
	libpcre \
	readline \
	zlib \
	"

IMAGE_FEATURES += "\
	dev-pkgs \
	staticdev-pkgs \
	tools-debug \
	tools-sdk \
	package-management \
	"
