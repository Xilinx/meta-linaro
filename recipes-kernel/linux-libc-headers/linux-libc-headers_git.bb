require linux-libc-headers.inc

PV = "3.7-rc0+git${SRCPV}"
PR = "r0"

SRC_URI = "git://git.kernel.org/pub/scm/linux/kernel/git/torvalds/linux-2.6.git"

SRCREV = "b5356a19ced273ef8a941be226f4dfdb95c23073"

S = "${WORKDIR}/git"

DEFAULT_PREFERENCE = "10"
