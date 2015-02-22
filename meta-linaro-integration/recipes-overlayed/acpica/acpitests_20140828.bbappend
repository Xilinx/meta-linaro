FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI += "file://0001-aaptisrun-alter-to-allow-destination-directory-as-ar.patch"

do_install_append() {
    install -m0755 tests/aapits/bin/aapitsrun ${D}${bindir}
}
