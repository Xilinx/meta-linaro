DESCRIPTION = "OpenDataPlane (ODP) provides a data plane application programming \
	environment that is easy to use, high performance, and portable between networking SoCs."
HOMEPAGE = "http://www.opendataplane.org"
SECTION = "console/network"

LICENSE = "BSD | GPLv2"
LIC_FILES_CHKSUM = "file://LICENSE;md5=4ccfa994aa96974cfcd39a59faee20a2"
PV = "20140711+git${SRCPV}"

SRC_URI = "git://git.linaro.org/lng/odp.git;name=odp"

SRCREV_odp = "d626f0107f34f024de6cdeadbddda3cd52e06127"
SRCREV_FORMAT = "odp"

S = "${WORKDIR}/git"

inherit autotools

# ODP primary shipped as static library plus some API test and samples/
FILES_${PN}-staticdev += "${datadir}/opendataplane/*.la"
