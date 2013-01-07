FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI_append = " \
          file://fix-build-on-aarch64.patch \
          file://fix-testsuite.patch \
"
