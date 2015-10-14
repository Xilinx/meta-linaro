DESCRIPTION = "OpenDataPlane (ODP) provides a data plane application programming \
	environment that is easy to use, high performance, and portable between networking SoCs."
HOMEPAGE = "http://www.opendataplane.org"
SECTION = "console/network"

LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=4ccfa994aa96974cfcd39a59faee20a2"

DEPENDS = "openssl cunit"

SRC_URI = "git://git.linaro.org/lng/odp.git;name=odp \
	   file://run-ptest"

SRCREV_odp = "1bc6f09703cfa1cb0cb6632af2106ed4238784b0"
SRCREV_FORMAT = "odp"

S = "${WORKDIR}/git"

inherit autotools ptest

PACKAGECONFIG[perf] = "--enable-test-perf,,,"

do_configure_ptest() {
	oe_runconf --enable-test-vald
}

do_compile_ptest() {
	oe_runmake -C test/validation buildtest-TESTS
}

do_install_ptest() {
	DESTDIR=${D}/${PTEST_PATH}/test/
	oe_runmake -C test/validation install-binPROGRAMS \
			BUILDDIR=${B} DESTDIR=${DESTDIR}
	find ${DESTDIR} -type f -executable -exec mv -f {} ${DESTDIR} \;
	rm -rf ${DESTDIR}/usr
}

# ODP is primarily shipped as static library plus some API test and samples/
FILES_${PN}-staticdev += "${datadir}/opendataplane/*.la"

RDEPENDS_${PN} = "bash libcrypto"
RDEPENDS_${PN}-ptest = "cunit"
