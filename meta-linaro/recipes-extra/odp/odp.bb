DESCRIPTION = "OpenDataPlane (ODP) provides a data plane application programming \
	environment that is easy to use, high performance, and portable between networking SoCs."
HOMEPAGE = "http://www.opendataplane.org"
SECTION = "console/network"

LICENSE = "BSD | GPLv2"
LIC_FILES_CHKSUM = "file://LICENSE;md5=4ccfa994aa96974cfcd39a59faee20a2"
PV = "20140820+git${SRCPV}"

DEPENDS = "openssl"

SRC_URI = "git://git.linaro.org/lng/odp.git;name=odp"

SRCREV_odp = "26238333b5b0896366c844aeb7253e60abd99f5a"
SRCREV_FORMAT = "odp"

S = "${WORKDIR}/git"

inherit autotools

RDEPENDS_${PN} = "libcrypto"

# ODP primary shipped as static library plus some API test and samples/
FILES_${PN}-staticdev += "${datadir}/opendataplane/*.la"
