SUMMARY = "ACPICA tools for the development and debug of ACPI tables"
DESCRIPTION = "The ACPI Component Architecture (ACPICA) project provides an \
OS-independent reference implementation of the Advanced Configuration and \
Power Interface Specification (ACPI). ACPICA code contains those portions of \
ACPI meant to be directly integrated into the host OS as a kernel-resident \
subsystem, and a small set of tools to assist in developing and debugging \
ACPI tables."
HOMEPAGE = "http://www.acpica.org/"
SECTION = "console/tools"
LICENSE = "BSD | GPLv2"
LIC_FILES_CHKSUM = "file://generate/unix/readme.txt;md5=204407e197c1a01154a48f6c6280c3aa"
DEPENDS = "bison flex"
SRCREV = "5dac68d8af691cb66191c071771d6cf4abb54277"
PV = "20131115+git${SRCPV}"

SRC_URI = "git://git.linaro.org/people/ahs3/acpica-tools.git \
    file://fix_ftbfs_debian-kfreebsd.patch \
    file://debian-big_endian.patch \
    file://debian-unaligned.patch \
    file://fix_ftbfs_debian-hurd.patch \
    file://add-testing.patch \
    file://name-miscompare.patch \
    file://aapits-linux.patch \
    file://cross-compile.patch \
    file://no-werror.patch \
    "

S = "${WORKDIR}/git"

EXTRA_OEMAKE = "'OPT_CFLAGS=-Wall'"

do_install() {
    install -D -p -m0755 generate/unix/bin*/iasl ${D}${bindir}/iasl
    install -D -p -m0755 generate/unix/bin*/acpibin ${D}${bindir}/acpibin
    install -D -p -m0755 generate/unix/bin*/acpiexec ${D}${bindir}/acpiexec
    install -D -p -m0755 generate/unix/bin*/acpihelp ${D}${bindir}/acpihelp
    install -D -p -m0755 generate/unix/bin*/acpinames ${D}${bindir}/acpinames
    install -D -p -m0755 generate/unix/bin*/acpisrc ${D}${bindir}/acpisrc
    install -D -p -m0755 generate/unix/bin*/acpixtract ${D}${bindir}/acpixtract
}

COMPATIBLE_HOST = "(i.86|x86_64|arm|aarch64).*-linux"

