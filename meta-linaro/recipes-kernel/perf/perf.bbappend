LICENSE = "GPL-2"
LIC_FILES_CHKSUM = "file://COPYING;md5=d7810fab7487fb0aad327b76f1be7cd7"

PV = "3.18.5"

FILESEXTRAPATHS_prepend := "${THISDIR}/files:"
SRC_URI = "${DEBIAN_MIRROR}/main/l/linux-tools/linux-tools_3.18.5.orig.tar.xz"

SRC_URI[md5sum] = "c9ee8f5c1f88e562f1c1d6997c442c7f"
SRC_URI[sha256sum] = "bf79397874cc211e81eed47e2c2591632ba7b03d3de73aea867f2a78917b9720"

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
