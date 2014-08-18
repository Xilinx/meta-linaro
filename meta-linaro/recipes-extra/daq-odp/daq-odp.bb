SUMMARY = "OpenDataPlane Data Acquisition (DAQ) module for Snort."
HOMEPAGE = "https://github.com/muvarov/daq-odp"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://LICENSE;md5=2713c79cde0756d6a56337304277b711"

DEPENDS = "odp daq"
PV = "20140818+git${SRCPV}"

SRC_URI = "git://github.com/muvarov/daq-odp.git"
SRCREV = "c1dafe0ce4ea93401726ac53b3d129bb89b634ff"
SRCREV_FORMAT = "daq-odp"

S = "${WORKDIR}/git"

inherit autotools

FILES_odp-daq += "${libdir}/daq"
