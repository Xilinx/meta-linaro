FILESEXTRAPATHS_prepend := "${THISDIR}/openldap-2.4.23/:"

SRC_URI_append = " \ 
    file://kill-icu.patch"
