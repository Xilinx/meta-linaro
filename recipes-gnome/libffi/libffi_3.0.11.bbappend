FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI_append = " \
		  file://add-aarch64-support.patch \
		  file://aarch64-adding-build-support.patch \
"
