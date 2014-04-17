DESCRIPTION = "Linaro Kernel common bits"
SECTION = "kernel"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=d7810fab7487fb0aad327b76f1be7cd7"

inherit kernel siteinfo
require recipes-kernel/linux/linux-dtb.inc

SRC_URI = " \
           git://git.linaro.org/git/ci/ubuntu-kernel-ci.git;protocol=http;branch=master;name=ubuntu-ci;destsuffix=ubuntu-ci \
"
S = "${WORKDIR}/git"

SRCREV_ubuntu-ci = "96be0fe881ec11d47eee24357cf74a970288d208"
SRCREV_FORMAT = "kernel"
