#require recipes-bsp/grub/grub2.inc
LICENSE = "GPLv3"

SRC_URI = "file://COPYING"
LIC_FILES_CHKSUM = "file://${WORKDIR}/COPYING;md5=ed1dca40ee0852c630f19c06fdecf6bc \
"

inherit deploy

DEFAULT_PREFERENCE = "-1"
DEFAULT_PREFERENCE_arm = "1"

PV = "2.00-prebuilt"

COMPATIBLE_HOST = '(x86_64.*|i.86.*|arm.*|aarch64.*)-(linux.*|freebsd.*)'

# grubaa64.efi needs to be compiled in 64bit mode. grub compilation references userspace header
# files but in ILP32 build we don't have 64bit specific headers which results in build failure.
# Workaround by using a prebuilt grub efi application.
do_install() {
    wget -q http://releases.linaro.org/reference-platform/embedded/hikey/16.12/rpb/grubaa64.efi -O ${B}/grubaa64.efi
}

do_deploy() {
    cp -a ${B}/grubaa64.efi ${DEPLOYDIR}
}

ALLOW_EMPTY_${PN} = "1"

addtask deploy before do_build after do_install
