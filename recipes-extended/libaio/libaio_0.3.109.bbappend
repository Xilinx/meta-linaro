FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI_append = " \ 
           file://libaio-generic.patch \
           file://libaio-aarch64.patch \
"
