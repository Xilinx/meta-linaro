FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI += " ${CONFIGFILESURI} "

CONFIGFILESURI_armeb = " \
    file://config.h \
    file://numpyconfig.h \
"
