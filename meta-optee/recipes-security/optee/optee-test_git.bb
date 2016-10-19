SUMMARY = "OP-TEE sanity testsuite"
HOMEPAGE = "https://github.com/OP-TEE/optee_test"

LICENSE = "BSD & GPLv2"
LIC_FILES_CHKSUM = "file://${S}/LICENSE.md;md5=daa2bcccc666345ab8940aab1315a4fa"

DEPENDS = "optee-client optee-os python-pycrypto-native"

inherit pythonnative

PV = "2.2.0+git${SRCPV}"

SRC_URI = "git://github.com/OP-TEE/optee_test.git"
S = "${WORKDIR}/git"

SRCREV = "a00eeb15ddfaa5b7d2cb340faeb36748d5aabffb"

OPTEE_CLIENT_EXPORT = "${STAGING_DIR_HOST}${prefix}"
TEEC_EXPORT         = "${STAGING_DIR_HOST}${prefix}"
TA_DEV_KIT_DIR      = "${STAGING_INCDIR}/optee/export-user_ta"

EXTRA_OEMAKE = " TA_DEV_KIT_DIR=${TA_DEV_KIT_DIR} \
                 OPTEE_CLIENT_EXPORT=${OPTEE_CLIENT_EXPORT} \
                 TEEC_EXPORT=${TEEC_EXPORT} \
                 CROSS_COMPILE_HOST=${TARGET_PREFIX} \
                 CROSS_COMPILE_TA=${TARGET_PREFIX} \
                 V=1 \
               "

do_compile() {
    # Top level makefile doesn't seem to handle parallel make gracefully
    oe_runmake xtest
    oe_runmake ta
}

do_install () {
    install -d ${D}${bindir}
    install -d ${D}${base_libdir}/optee_armtz

    install ${S}/out/xtest/xtest ${D}${bindir}

    find ${S}/out/ta -name '*.ta' | while read name; do
        install -m 444 $name ${D}${base_libdir}/optee_armtz/
    done
}

FILES_${PN} += "${base_libdir}/optee_armtz/"

# Imports machine specific configs from staging to build
PACKAGE_ARCH = "${MACHINE_ARCH}"
