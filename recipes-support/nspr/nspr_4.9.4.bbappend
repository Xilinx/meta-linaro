FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI_append = " \
          file://fix-build-on-aarch64.patch;patch=1 \
"


do_configure() {
    gnu-configize --force
    mv config.sub config.guess build/autoconf
    oe_runconf
}
   
