LICENSE = "GPL-2"
LIC_FILES_CHKSUM = "file://COPYING;md5=d7810fab7487fb0aad327b76f1be7cd7"

PV = "4.0.2"

FILESEXTRAPATHS_prepend := "${THISDIR}/files:"
SRC_URI = "${DEBIAN_MIRROR}/main/l/linux-tools/linux-tools_4.0.2.orig.tar.xz"

SRC_URI[md5sum] = "2bf7891f174843b40603395e94bde29d"
SRC_URI[sha256sum] = "9c149a18e2d0ec3aba9200fdf49b124849a74130574e15abcb526f7481c2147e"

S = "${WORKDIR}/linux-tools-${PV}"
B = "${WORKDIR}/linux-tools-${PV}-build"

do_compile_prepend() {
    mkdir -p ${S}/include/generated
    echo "#define UTS_RELEASE \"${PV}\"" > ${S}/include/generated/utsrelease.h
}

# Ensure the above tarball gets fetched, unpackaged and patched
python () {
	d.delVarFlag("do_fetch", "noexec")
	d.delVarFlag("do_unpack", "noexec")
	d.delVarFlag("do_patch", "noexec")
}
