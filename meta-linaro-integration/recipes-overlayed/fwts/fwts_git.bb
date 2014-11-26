SUMMARY = "Firmware testsuite"
DESCRIPTION = "The tool fwts comprises of over fifty tests that are designed to exercise and test different aspects of a machine's firmware. Many of these tests need super user access to read BIOS data and ACPI tables, so the tool requires running with super user privileges (e.g. with sudo)."
HOMEPAGE = "https://wiki.ubuntu.com/Kernel/Reference/fwts"

LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://src/main.c;beginline=1;endline=16;md5=deb8af5388e838d133eaa036f4d1496f"

PV = "14.09.00"

SRCREV = "cf14f3b4bab716dea95de772ad52786c1cbe862a"
SRC_URI = "git://kernel.ubuntu.com/hwe/fwts.git \
           file://0001-ACPI-improve-the-return-values-and-the-log-info-in-t.patch \
           file://0002-ACPI-add-the-hardware-reduced-mode-check-function-in.patch \
           file://0003-ACPI-a-missing-FACS-table-can-be-ignored-under-some.patch \
          "

S = "${WORKDIR}/git"

DEPENDS = "libpcre json-c glib-2.0"

inherit autotools-brokensep

FILES_${PN} += "${libdir}/fwts/lib*${SOLIBS}"
FILES_${PN}-dev += "${libdir}/fwts/lib*${SOLIBSDEV} ${libdir}/fwts/lib*.la"
FILES_${PN}-staticdev += "${libdir}/fwts/lib*a"
FILES_${PN}-dbg += "${libdir}/fwts/.debug"
