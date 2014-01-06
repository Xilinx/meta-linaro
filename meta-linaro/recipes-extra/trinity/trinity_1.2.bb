SUMMARY = "a Linux System call fuzz teste."
DESCRIPTION = "Trinity, a Linux System call fuzz tester."
HOMEPAGE = "http://codemonkey.org.uk/projects/trinity/"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${S}/COPYING;md5=96094d47cfbd2cc45eb46ce0fc423c04"

COMPATIBLE_HOST = "(x86_64|arm|aarch64).*-linux"

# v1.2 tag
SRCREV = "bdd0bdcaef753e8d340fc25fbc72a11be47639b0"
SRC_URI = "git://github.com/kernelslacker/trinity.git;protocol=https \
           file://0001-scripts-TRINITY_PATH-defaults-to.patch \
           file://0002-scripts-change-mkdir-tmp-to-mktemp.patch \
           file://0003-tables.c-change-the-output-format-of-L.patch \
           file://0004-add-support-for-the-AArch64-architecture.patch \
          "

S = "${WORKDIR}/git"

inherit useradd

USERADD_PACKAGES = "${PN}"
USERADD_PARAM_${PN} = "--system --create-home --shell /bin/sh ${PN} "

do_configure () {
    ./configure.sh
}

# workaround random build failures
do_compile () {
    ${MAKE}
}

do_install () {
    oe_runmake install DESTDIR=${D}/usr
    install -o ${PN} -d -m 0755 ${D}/${datadir}/${PN}
    install -o ${PN} -m 0755 ${S}/scripts/test-all-syscalls-parallel.sh     ${D}/${datadir}/${PN}
    install -o ${PN} -m 0755 ${S}/scripts/test-all-syscalls-sequentially.sh ${D}/${datadir}/${PN}
    install -o ${PN} -m 0755 ${S}/scripts/test-multi.sh                     ${D}/${datadir}/${PN}
    install -o ${PN} -m 0755 ${S}/scripts/test-vm.sh                        ${D}/${datadir}/${PN}
}

PACKAGES =+ "${PN}-example"

FILES_${PN} = "${bindir}/trinity"
FILES_${PN}-example = "${datadir}/${PN}"
