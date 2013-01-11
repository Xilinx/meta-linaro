DESCRIPTION = "The glog library implements application-level logging. This \
library provides logging APIs based on C++-style streams and various helper \
macros."
HOMEPAGE = "https://code.google.com/p/google-glog/"

LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://COPYING;md5=dc9db360e0bbd4e46672f3fd91dd6c4b"

SRC_URI = "svn://google-glog.googlecode.com/svn/;module=trunk;protocol=http"

SRCREV = "${AUTOREV}"

PV = "0.3.2+svn${SRCREV}"

S = "${WORKDIR}/trunk"

inherit autotools pkgconfig
