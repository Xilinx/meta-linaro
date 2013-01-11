FILESEXTRAPATHS_prepend := "${THISDIR}/libav-0.8.3:"

SRC_URI_append = " \
          file://0001-configure-enable-pic-for-AArch64.patch \
"
