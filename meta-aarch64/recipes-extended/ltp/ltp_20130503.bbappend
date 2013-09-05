FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI_append = " file://ltp-arm64.patch \
                   file://0001-realtime-testsuite-update-the-install-rule.patch \
                   file://0002-realtime-parser-remove-unused-and-depricated-imports.patch \
                   file://0003-runltp-rework-echo-n-to-printf-POSIX-compliant.patch \
                 "

EXTRA_OECONF = " --with-power-management-testsuite --with-realtime-testsuite "
RDEPENDS_${PN}_append = " e2fsprogs-mke2fs "
