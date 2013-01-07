FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI_append = " \
          file://fix-build-on-aarch64.patch \
          file://fix-testsuite.patch \
"


do_configure() {
    gnu-configize --force
    mv config.sub config.guess build/autoconf
    oe_runconf
}
   
