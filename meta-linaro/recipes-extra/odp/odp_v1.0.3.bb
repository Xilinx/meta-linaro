DESCRIPTION = "OpenDataPlane (ODP) provides a data plane application programming \
	environment that is easy to use, high performance, and portable between networking SoCs."
HOMEPAGE = "http://www.opendataplane.org"
SECTION = "console/network"

LICENSE = "BSD | GPLv2"
LIC_FILES_CHKSUM = "file://LICENSE;md5=4ccfa994aa96974cfcd39a59faee20a2"

DEPENDS = "openssl"

SRC_URI = "git://git.linaro.org/lng/odp.git;name=odp"

SRCREV_odp = "1bc6f09703cfa1cb0cb6632af2106ed4238784b0"
SRCREV_FORMAT = "odp"

S = "${WORKDIR}/git"

inherit autotools

RDEPENDS_${PN} = "bash libcrypto"

#PACKAGECONFIG ?= "perf"
#PACKAGECONFIG ?= "perf vald" NOTE: add 'vald' to above list and uncomment
#the PACKAGECONFIG[vald] line below to enable cunit tests when available
PACKAGECONFIG[perf] = "--enable-test-perf,,,"
#PACKAGECONFIG[vald] = "--enable-test-vald,,cunit,cunit"

# ODP primary shipped as static library plus some API test and samples/
FILES_${PN}-staticdev += "${datadir}/opendataplane/*.la"
