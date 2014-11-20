LICENSE = "GPL-2"
LIC_FILES_CHKSUM = "file://COPYING;md5=d7810fab7487fb0aad327b76f1be7cd7"

PV = "3.17"

FILESEXTRAPATHS_prepend := "${THISDIR}/files:"
SRC_URI = "${DEBIAN_MIRROR}/main/l/linux-tools/linux-tools_3.17.orig.tar.xz \
           file://0001-perf-tools-Fix-arm64-build-error.patch \
           file://0001-perf-tools-Fix-build-breakage-on-arm64-targets.patch \
"

SRC_URI[md5sum] = "6c78f25c86761a60b89235e12bc109a8"
SRC_URI[sha256sum] = "51162320841053fcf06070b6d5a6d984fb4c429e3ba3dc6d4eec021d374b926f"

S = "${WORKDIR}/linux-tools-${PV}"
B = "${WORKDIR}/linux-tools-${PV}"

do_compile_prepend() {
    mkdir -p ${S}/include/generated
    echo "#define UTS_RELEASE \"${PV}\"" > ${S}/include/generated/utsrelease.h
}
