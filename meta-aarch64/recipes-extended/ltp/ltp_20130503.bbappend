FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI_append = " file://ltp-arm64.patch" 

EXTRA_OECONF = " --with-power-management-testsuite --with-realtime-testsuite "
