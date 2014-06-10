require recipes-devtools/gdb/gdb-cross.inc
require gdb-${PV}.inc

SRC_URI += "file://sim-install-6.6.patch"
SRC_URI += "file://elf_prstatus-size.patch"
