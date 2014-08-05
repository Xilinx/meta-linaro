SUMMARY = "DS-5 Gator daemon"
DESCRIPTION = "Target-side daemon gathering data for ARM Streamline Performance Analyzer."

LICENSE = "GPL-2"
LIC_FILES_CHKSUM = "file://driver/LICENSE;md5=b234ee4d69f5fce4486a80fdaf4a4263"

SRCREV = "bc8a84cf0b138a2951679581453da7bd93003db6"
PV = "5.19+git${SRCPV}"

SRC_URI = "git://git.linaro.org/arm/ds5/gator.git;protocol=http;branch=linaro \
           file://gator.init"

S = "${WORKDIR}/git"

inherit update-rc.d

EXTRA_OEMAKE = "'CFLAGS=${CFLAGS} ${TARGET_CC_ARCH} -DETCDIR=\"${sysconfdir}\"' \
    'LDFLAGS=${LDFLAGS} ${TARGET_CC_ARCH}' 'CROSS_COMPILE=${TARGET_PREFIX}'"

do_compile() {
    oe_runmake -C daemon
}

do_install() {
    install -D -p -m0755 daemon/gatord ${D}/${sbindir}/gatord
    install -D -p -m0755 ${WORKDIR}/gator.init ${D}/${sysconfdir}/init.d/gator
}

INITSCRIPT_NAME = "gator"
INITSCRIPT_PARAMS = "defaults 66"
