SUMMARY = "Uses the CPU"
DESCRIPTION = "This program uses the CPU on a System"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/GPL-2.0;endline=39;md5=c16edc6b3353707bb4789198c72f7e48"
SRCREV = "e246c70aa6cac5df0e593ef3416380ff75a70dc0"
PV = "0.1+git${SRCPV}"

SRC_URI = "git://git.linaro.org/people/anders.roxell/usecpu.git"

S = "${WORKDIR}/git"

do_compile() {
    oe_runmake use_cpu
}

do_install() {
    install -D -p -m0755 use_cpu ${D}${bindir}/use_cpu
}
