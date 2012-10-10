require linux-libc-headers.inc

PR = "r1"
PV = "3.6+git${SRCPV}"

SRC_URI = "git://git.linaro.org/kernel/linaro-aarch64.git;branch=linaro-aarch64-3.6"

SRCREV = "1c9c5f19c8f049436e3f12ee675d49ce822d8181"

S = "${WORKDIR}/git"
