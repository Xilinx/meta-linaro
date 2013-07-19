FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI_append = " file://ltp-arm64.patch \
                   file://0001-realtime-testsuite-update-the-install-rule.patch \
                 "

EXTRA_OECONF = " --with-power-management-testsuite --with-realtime-testsuite "
