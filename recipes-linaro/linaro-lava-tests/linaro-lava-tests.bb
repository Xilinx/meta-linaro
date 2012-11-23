DESCRIPTION = "Scripts and files for LAVA tests"
LICENSE = "Expat"
LIC_FILES_CHKSUM = "file://LICENSE;md5=3725c2bb543d06ff759f9db9b5d986ac"

SRC_URI = "\
        file://hello.c \
        file://hello.cc \
        file://info.php \
        file://LICENSE \
        "

S = "${WORKDIR}"

do_install() {
    install -d ${D}/root ${D}/usr/share/apache2/htdocs/
    install -m 0644 hello.c  ${D}/root/
    install -m 0644 hello.cc ${D}/root/
    install -m 0644 info.php ${D}/usr/share/apache2/htdocs/
}

FILES_${PN} = "/"
