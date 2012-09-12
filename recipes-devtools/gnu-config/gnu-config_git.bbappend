LIC_FILES_CHKSUM = "file://config.guess;endline=39;md5=b79a4663475f4d724846463277817e0d"

SRCREV = "062587eaa891396c936555ae51f7e77eeb71a5fe"
PV = "20120814+git${SRCPV}"
PR = "r0"

SRC_URI = "git://git.sv.gnu.org/config.git;protocol=git \
           file://config-guess-uclibc.patch \
           file://gnu-configize.in"

DEFAULT_PREFERENCE = "1"
FILESEXTRAPATHS_prepend := "${THISDIR}/${BPN}:"
