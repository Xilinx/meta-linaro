SUMMARY = "DS-5 Gator daemon"
DESCRIPTION = "Target-side daemon gathering data for ARM Streamline Performance Analyzer."
LICENSE = "GPL-2"
LIC_FILES_CHKSUM = "file://driver/LICENSE;md5=b234ee4d69f5fce4486a80fdaf4a4263"
SRCREV = "ba783f1443773505231ac2808c9a3716c3c2f3ae"
PV = "5.18+git${SRCPV}"

SRC_URI = "git://git.linaro.org/arm/ds5/gator.git;protocol=http \
           file://gator.init"

S = "${WORKDIR}/git"

inherit update-rc.d

do_compile() {
    cd daemon
    # aarch64 makefile will work just fine for any arch
    make -f Makefile_aarch64 CROSS_COMPILE=${TARGET_PREFIX} SYSROOT=${STAGING_DIR_TARGET}
}

do_install() {
    install -D -p -m0755 daemon/gatord ${D}/${sbindir}/gatord
    install -D -p -m0755 ${WORKDIR}/gator.init ${D}/${sysconfdir}/init.d/gator
}

INITSCRIPT_NAME = "gator"
INITSCRIPT_PARAMS = "defaults 66"
