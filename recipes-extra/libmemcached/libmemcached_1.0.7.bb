LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://COPYING;md5=865490941c91ba790f0ea78dec93bd60"

SRC_URI = "http://launchpad.net/libmemcached/1.0/${PV}/+download/libmemcached-${PV}.tar.gz "

SRC_URI[md5sum] = "d59a462a92d296f76bff2d9bc72b2516"
SRC_URI[sha256sum] = "3efa86c9733eaad55d7119cb16769424e2aa6c22b3392e8f973946fce6678d81"

DEPENDS = "libevent util-linux"

TARGET_LDFLAGS += "-luuid"

inherit autotools gettext pkgconfig

do_configure_prepend_aarch64() {
    export ac_cv_c_endian=little
}
