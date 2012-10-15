# we do not have libaio yet
#
FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

DEPENDS_aarch64 = "attr"

SRC_URI = "${SOURCEFORGE_MIRROR}/ltp/ltp-full-${PV}.bz2 \
           file://ltp-arm64.patch" 
