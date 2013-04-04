PACKAGES =+ "libelf libasm libdw libdw-dev libasm-dev libelf-dev"

FILES_libelf = "${libdir}/libelf-${PV}.so ${libdir}/libelf.so.*"
FILES_libasm = "${libdir}/libasm-${PV}.so ${libdir}/libasm.so.*"
FILES_libdw  = "${libdir}/libdw-${PV}.so ${libdir}/libdw.so.* ${libdir}/elfutils/lib*"
FILES_libelf-dev = "${libdir}/libelf.so ${includedir}"
FILES_libasm-dev = "${libdir}/libasm.so ${includedir}/elfutils/libasm.h"
FILES_libdw-dev  = "${libdir}/libdw.so  ${includedir}/dwarf.h ${includedir}/elfutils/libdw*.h"
FILES_SOLIBSDEV = ""

INSANE_SKIP_${MLPREFIX}libdw = "dev-so"
