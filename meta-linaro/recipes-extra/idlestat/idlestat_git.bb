DESCRIPTION = "tool to show how long a CPU or cluster enters idle state"
SUMMARY = "Idlestat is a tool which can show how long a CPU or cluster \
enters idle state. This infomation is obtained using traces from trace-cmd \
or ftrace tools."
LICENSE = "GPL-2.0"
LIC_FILES_CHKSUM = "file://Makefile;md5=1e2d28a88b081f97157089bb67d4249d"
SRCREV = "da6a8c94a8f8124711db0ae84a3ef4e0e186b388"
PV = "0.2+git${SRCPV}"

SRC_URI = "git://git.linaro.org/people/zoran.markovic/idlestat.git"

S = "${WORKDIR}/git"

do_install () {
    install -D -p -m0755 idlestat ${D}/${sbindir}/idlestat
}
