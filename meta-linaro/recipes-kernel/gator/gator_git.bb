DESCRIPTION = "Target-side daemon gathering data for ARM Streamline Performance Analyzer."
SUMMARY  = "DS-5 Gator daemon"

LICENSE = "GPL-2"
LIC_FILES_CHKSUM = "file://driver/LICENSE;md5=b234ee4d69f5fce4486a80fdaf4a4263"

SRC_URI = "git://git.linaro.org/arm/ds5/gator.git"

SRCREV = "${AUTOREV}"

S = "${WORKDIR}/git"

PV = "5.15+git${SRCPV}"
PR = "r1"

do_compile() {
    cd daemon
    # aarch64 makefile will work just fine for any arch
    make -f Makefile_aarch64 CROSS_COMPILE=${TARGET_PREFIX} SYSROOT=${STAGING_DIR_TARGET}
}

do_install() {
    install -D -p -m0755  daemon/gatord ${D}/${sbindir}/gatord
}
