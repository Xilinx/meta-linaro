DESCRIPTION = "OpenDataPlane (ODP) provides a data plane application programming \
	environment that is easy to use, high performance, and portable between networking SoCs."
HOMEPAGE = "https://wiki.linaro.org/LNG/Engineering/OpenDataPlane"
SECTION = "console/tools"

LICENSE = "BSD | GPLv2"
LIC_FILES_CHKSUM = "file://LICENSE;md5=dd8b05a36dd5410381ad0679f9151808"
PV = "20131227"

SRC_URI = "git://git.linaro.org/lng/odp.git;name=odp"

SRCREV_odp = "9dde32f3d5f4201293f279b2ea51ee21f5335093"
SRCREV_FORMAT = "odp"

S = "${WORKDIR}/git"

do_install() {
	oe_runmake install DESTDIR=${D}
}

# ODP
# ODP primary shipped as static library plus some API test and samples/
# Current makefile installs it to /usr/share/odp so use this folder here.
FILES_${PN}-dbg += "${datadir}/odp/.debug"

