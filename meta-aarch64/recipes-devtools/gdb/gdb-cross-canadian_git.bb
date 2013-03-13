require gdb-common.inc
require recipes-devtools/gdb/gdb-cross-canadian.inc

PR = "${INC_PR}.0"

GDBPROPREFIX = "--program-prefix='${TARGET_PREFIX}'"
