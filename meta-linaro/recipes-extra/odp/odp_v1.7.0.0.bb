DESCRIPTION = "OpenDataPlane (ODP) provides a data plane application programming \
	environment that is easy to use, high performance, and portable between networking SoCs."
HOMEPAGE = "http://www.opendataplane.org"
SECTION = "console/network"

LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=4ccfa994aa96974cfcd39a59faee20a2"

DEPENDS = "openssl cunit libpcap"

SRC_URI = "git://git.linaro.org/lng/odp.git;name=odp"

SRCREV_odp = "bbd5ac81d9e606415f2ad2ecb999c2ff8c3716c9"
SRCREV_FORMAT = "odp"

S = "${WORKDIR}/git"

inherit autotools ptest

PACKAGECONFIG[perf] = "--enable-test-perf,,,"

do_configure_ptest() {
	oe_runconf --enable-test-vald --with-testdir=${PTEST_PATH}/test/
}

do_install_ptest() {
	oe_runmake DESTDIR=${D} install
	ln -s test/run-test ${D}/${PTEST_PATH}/run-ptest
}

# ODP is primarily shipped as static library plus some API test and samples/
FILES_${PN}-staticdev += "${datadir}/opendataplane/*.la"

RDEPENDS_${PN} = "bash libcrypto"
RDEPENDS_${PN}-ptest = "cunit"
