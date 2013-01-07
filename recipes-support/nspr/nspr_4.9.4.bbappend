FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI_append = " \
          file://fix-build-on-aarch64.patch \
          file://fix-testsuite.patch \
"

do_configure_prepend() {
    gnu-configize --force
    mv config.sub config.guess build/autoconf
}
