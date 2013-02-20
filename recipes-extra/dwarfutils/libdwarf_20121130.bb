require dwarf.inc

SRC_URI += "file://fix-gennames.patch"

do_install() {
    install -d ${D}${libdir} ${D}${includedir}/libdwarf
    install -m 0755 libdwarf.a ${D}${libdir}
    install -m 0644 dwarf.h libdwarf.h ${D}${includedir}/libdwarf
}

ALLOW_EMPTY_${PN} = "1"

BBCLASSEXTEND = "native"
