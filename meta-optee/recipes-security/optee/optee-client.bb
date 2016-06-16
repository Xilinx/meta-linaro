SUMMARY = "OPTEE Client"
HOMEPAGE = "https://github.com/OP-TEE/optee_client"

LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://${S}/LICENSE;md5=69663ab153298557a59c67a60a743e5b"

PV = "2.0.0+git${SRCPV}"

inherit pythonnative

SRC_URI = "git://github.com/OP-TEE/optee_client.git"
S = "${WORKDIR}/git"

SRCREV = "17d1addc465a667f375837cdbe4fa7ebac08539b"

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
}

