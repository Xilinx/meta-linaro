DESCRIPTION = "tool to show how long a CPU or cluster enters idle state"
SUMMARY = "Idlestat is a tool which can show how long a CPU or cluster \
enters idle state. This infomation is obtained using traces from trace-cmd \
or ftrace tools."
LICENSE = "GPL-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=eb723b61539feef013de476e68b5c50a"
SRCREV = "7398755f136d551c03ebc1e784625e9e3f77c1de"
PV = "0.6+git${SRCPV}"

SRC_URI = "git://git.linaro.org/power/idlestat.git \
           file://Makefile.patch \
           file://0001-Replace-deprecated-readdir_r-with-readdir.patch \
           file://0002-topology-remove-check-for-same-cpuid-cannot-exist-in.patch \
           file://0003-fix-memory-leak-in-cpuidle_get_target_residency-free.patch \
           file://0004-Fix-TRACE_IPIIRQ_FORMAT-string-format-width-overflow.patch \
           file://0005-Use-zu-format-specifier-for-size_t-types.patch \
"

S = "${WORKDIR}/git"

do_compile() {
    oe_runmake CC='${CC}'
}

do_install () {
    install -D -p -m0755 idlestat ${D}/${sbindir}/idlestat
}
