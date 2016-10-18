SUMMARY = "OPTEE Client"
HOMEPAGE = "https://github.com/OP-TEE/optee_client"

LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://${S}/LICENSE;md5=69663ab153298557a59c67a60a743e5b"

PV = "2.2.0+git${SRCPV}"

inherit pythonnative systemd

SRC_URI = "git://github.com/OP-TEE/optee_client.git \
           file://tee-supplicant.service"
S = "${WORKDIR}/git"

SRCREV = "658ae538f76a2624b7f9c40539a600d281d872b4"

SYSTEMD_SERVICE_${PN} = "tee-supplicant.service"

do_compile() {
    install -d ${D}${prefix}
    oe_runmake EXPORT_DIR=${D}${prefix}/
}

do_install() {
    install -d ${D}${prefix}
    oe_runmake install EXPORT_DIR=${D}${prefix}

    ( cd ${D}${prefix}/lib
      rm libteec.so libteec.so.1
      ln -s libteec.so.1.0 libteec.so.1
      ln -s libteec.so.1.0 libteec.so
    )

    sed -i -e s:/etc:${sysconfdir}:g \
           -e s:/usr/bin:${bindir}:g \
              ${WORKDIR}/tee-supplicant.service

    install -D -p -m0644 ${WORKDIR}/tee-supplicant.service ${D}${systemd_system_unitdir}/tee-supplicant.service
}

