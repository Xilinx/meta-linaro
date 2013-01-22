# Copyright (C) 2013 Unknow User <unknow@user.org>
# Released under the MIT license (see COPYING.MIT for the terms)

DESCRIPTION = "parallelism library for C++ - runtime files \
 TBB is a library that helps you leverage multi-core processor \
 performance without having to be a threading expert. It represents a \
 higher-level, task-based parallelism that abstracts platform details \
 and threading mechanism for performance and scalability."
HOMEPAGE = "http://threadingbuildingblocks.org/"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=2c7f2caf277a3933e3acdf7f89d54cc1"
PRDATE = "20121003"
PR = "r0"

SRC_URI = "http://threadingbuildingblocks.org/sites/default/files/software_releases/source/tbb41_${PRDATE}oss_src.tgz \
           file://tbb41-aarch64.patch \
           file://cross-compile.patch \
           file://tbb.pc"

S = "${WORKDIR}/tbb41_${PRDATE}oss/"

SRC_URI[md5sum] = "2a684fefb855d2d0318d1ef09afa75ff"
SRC_URI[sha256sum] = "5383727b9582a54cf4c4adbf22186b70e8eba276fcd3be81d746a937c5b47afc"

do_compile() {
    oe_runmake compiler=gcc arch=aarch64 runtime=cc4.7_libc2.17_kernel3.8 tbb tbbmalloc
}

do_install() {
    install -d ${D}${includedir} ${D}${libdir}/pkgconfig
    rm ${S}/include/tbb/index.html -f
    cp -a ${S}/include/tbb ${D}${includedir}
    install -m 0755 ${B}/build/linux_*_release/lib*.so* ${D}${libdir}
    install -m 0644 ${WORKDIR}/tbb.pc ${D}${libdir}/pkgconfig
}
