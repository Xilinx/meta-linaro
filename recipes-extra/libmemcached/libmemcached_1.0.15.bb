LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://COPYING;md5=865490941c91ba790f0ea78dec93bd60"

SRC_URI = "http://launchpad.net/libmemcached/1.0/${PV}/+download/libmemcached-${PV}.tar.gz \
           file://crosscompile.patch"

SRC_URI[md5sum] = "616297a1aedefc52b3f6922eda5d559a"
SRC_URI[sha256sum] = "dd7e9560029835bddf761a5b4c2339d9e5c7374558659b6c11b2c95e7d3a4325"

DEPENDS = "libevent util-linux cyrus-sasl"

TARGET_LDFLAGS += "-luuid"

inherit autotools gettext pkgconfig
