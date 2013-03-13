DESCRIPTION = "LAVA test runner"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=751419260aa954499f7abaabaa882bbe"

SRC_URI = "bzr://code.launchpad.net/+branch/lava-dispatcher"
SRCREV = "${AUTOREV}"
#PV = "0.${SRCPV}"

RDEPENDS_${PN} = "bash"

S = "${WORKDIR}/lava-dispatcher"

do_install() {
    install -d ${D}/lava/bin ${D}/lava/results
    install -m 0755 lava_test_shell/lava-test-runner-ubuntu ${D}/lava/bin/lava-test-runner
    install -m 0755 lava_test_shell/lava-test-shell ${D}/lava/bin
}

FILES_${PN} += "/lava"

inherit allarch
