FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI_append = " \
file://glibc-fsf-v1-eaf6f205-elf.patch \
file://glibc-fsf-v1-eaf6f205.patch \
"

PRINC = "3"
