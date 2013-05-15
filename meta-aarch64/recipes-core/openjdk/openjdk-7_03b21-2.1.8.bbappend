FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

WITH_ADDITIONAL_VMS_aarch64 = ""

OEPATCHES_append_aarch64 = " \
            file://aarch64-configure.patch \
  "

ICEDTEAPATCHES_append_aarch64 = " \
            file://icedtea-openjdk-aarch64.patch;apply=no \
            file://icedtea-prebuilt-files.patch;apply=no \
  "

DISTRIBUTION_PATCHES_append_aarch64 = " \
            patches/icedtea-openjdk-aarch64.patch \
            patches/icedtea-prebuilt-files.patch \
  "
