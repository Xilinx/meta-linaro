DESCRIPTION = "Ganglia is a scalable distributed monitoring \
system for high-performance computing systems such as \
clusters and Grids."
HOMEPAGE = "http://ganglia.sourceforge.net/"
SECTION = "console/utils"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://NEWS;md5=ff8c91481123c7d3be4e31fcac997747"
DEPENDS = "apr confuse pcre python"

SRC_URI = "\
    ${SOURCEFORGE_MIRROR}/${BPN}/${BPN}-${PV}.tar.gz \
    "

SRC_URI[md5sum] = "05926bb18c22af508a3718a90b2e9a2c"
SRC_URI[sha256sum] = "89eae02e1a117040d60b3b561fe55f88d7f8cf41b94af1492969ef68e6797886"

inherit autotools pythonnative

# The ganglia autoconf setup doesn't include libmetrics in its
# AC_OUTPUT list -- it reconfigures libmetrics using its own rules.
# Unfortunately this means an OE autoreconf will not regenerate
# ltmain.sh (and others) in libmetrics and as such the build will
# fail.  We explicitly force regeneration of that directory.

do_configure_append() {
       autoreconf -fvi
       (cd libmetrics; autoreconf -fvi)
}

BBCLASSEXTEND = "native"
