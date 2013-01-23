DEPENDS = " \
binutils \
bison-native \
boost \
bzip2 \
cmake \
elfutils \
expat \
flex-native \
gd \
google-glog \
icu \
libcap \
libc-client \
libevent-fb \
libmcrypt \
libmemcached \
libxml2 \
mysql5 \
ncurses \
onig \
openldap \
openssl \
libpam \
pcre \
readline \
zlib \
tbb \
"

# optional (for now) dependencies:
#DEPENDS += "libdwarf libunwind google-perftools"

LICENSE = "PHP Zend"

LIC_FILES_CHKSUM = " \
		file://LICENSE.PHP;md5=cb564efdf78cce8ea6e4b5a4f7c05d97 \
		file://LICENSE.ZEND;md5=69e7a9c51846dd6692f1b946f95f6c60"

SRC_URI = "git://github.com/facebook/hiphop-php.git \
           file://disable-not-available-for-aarch64.patch"

SRCREV = "${AUTOREV}"

S = "${WORKDIR}/git"

PV = "0.0+git${SRCPV}"
PR = "r1"

do_configure_prepend() {
	export HPHP_HOME="${B}"
	export HPHP_LIB="${B}"/bin
	export USE_HHVM=1
	export BOOST_INCLUDEDIR=${STAGING_INCDIR}
	export BOOST_LIBRARYDIR=${STAGING_LIBDIR}
	export LIBGLOG_INCLUDE_DIR=${STAGING_INCDIR}
	export LIBGLOG_LIBRARY=${STAGING_LIBDIR}
}

inherit cmake
