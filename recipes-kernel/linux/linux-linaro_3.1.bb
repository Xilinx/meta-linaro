inherit kernel

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=d7810fab7487fb0aad327b76f1be7cd7"

FILESDIR = "${@os.path.dirname(bb.data.getVar('FILE',d,1))}/linux-linaro-3.1/${MACHINE}"

DESCRIPTION = "Linaro 3.1 kernel"

SRC_URI = "git://git.linaro.org/kernel/linux-linaro-3.1.git;protocol=git \
           file://defconfig \
	   "

SRCREV = "${AUTOREV}"
#SRCREV = "2150f72fe35397cc6d6ce39866bd0462cfbcc916"

PV = "3.1+git${SRCPV}"

PR = "r0"

COMPATIBLE_MACHINE = "qemuarmv7a"

S = "${WORKDIR}/git"
