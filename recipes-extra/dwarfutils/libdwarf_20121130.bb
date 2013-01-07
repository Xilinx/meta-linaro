require dwarf.inc

SRC_URI += "file://fix-gennames.patch"

do_install() {
    install -d ${D}${libdir} ${D}${includedir}
    install -m 0755 libdwarf.a ${D}${libdir}
    install -m 0644 dwarf.h libdwarf.h ${D}${includedir}
}

BBCLASSEXTEND = "native"
