FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI_append = " file://add-arm64-support.patch"

COMPATIBLE_HOST = "(x86_64|i.86|arm|aarch64|powerpc|mips).*-(linux|freebsd.*)"
