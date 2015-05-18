SUMMARY = "DS-5 Gator daemon"
DESCRIPTION = "Target-side daemon gathering data for ARM Streamline Performance Analyzer."

LICENSE = "GPL-2"
LIC_FILES_CHKSUM = "file://driver/COPYING;md5=b234ee4d69f5fce4486a80fdaf4a4263"

SRCREV = "f0ddf6b40e42579f2275974620399fb3406d0c18"
PV = "5.21.1+git${SRCPV}"

SRC_URI = "git://git.linaro.org/arm/ds5/gator.git;protocol=http;branch=linaro \
           file://gator.init"

S = "${WORKDIR}/git"

inherit update-rc.d

EXTRA_OEMAKE = "'CFLAGS=${CFLAGS} ${TARGET_CC_ARCH} -DETCDIR=\"${sysconfdir}\"' \
    'LDFLAGS=${LDFLAGS} ${TARGET_CC_ARCH}' 'CROSS_COMPILE=${TARGET_PREFIX}' \
    'CXXFLAGS=${CXXFLAGS} ${TARGET_CC_ARCH} -fno-rtti'"

do_compile() {
    # The regular makefile tries to be 'smart' by hardcoding ABI assumptions, let's use the clean makefile for everything.
    cp ${S}/daemon/Makefile_aarch64 ${S}/daemon/Makefile	
    oe_runmake -C daemon CC='${CC}' CXX='${CXX}'
}

do_install() {
    install -D -p -m0755 daemon/gatord ${D}/${sbindir}/gatord
    install -D -p -m0755 ${WORKDIR}/gator.init ${D}/${sysconfdir}/init.d/gator
}

INITSCRIPT_NAME = "gator"
INITSCRIPT_PARAMS = "defaults 66"
