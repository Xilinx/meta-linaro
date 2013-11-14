require recipes-devtools/qemu/qemu.inc

DEPENDS = "glib-2.0 zlib alsa-lib virtual/libx11 pixman dtc libsdl jpeg"
DEPENDS_class-native = "zlib-native alsa-lib-native glib-2.0-native pixman-native dtc-native"
DEPENDS_class-nativesdk = "nativesdk-zlib nativesdk-libsdl nativesdk-glib-2.0 nativesdk-pixman nativesdk-dtc"

SRCREV = "5c5432e7d630592ddcc1876ac8a1505f8f14ef15"

LIC_FILES_CHKSUM = "file://COPYING;md5=441c28d2cf86e15a37fa47e15a72fbac \
                    file://COPYING.LIB;endline=24;md5=c04def7ae38850e7d3ef548588159913"

PV = "1.6.90+git${SRCPV}"

SRC_URI = "git://git.qemu.org/qemu.git \
           file://powerpc_rom.bin \
           "

S = "${WORKDIR}/git"
EXTRA_OECONF+="--enable-kvm --enable-fdt "
EXTRA_OECONF_aarch64+="--target-list=aarch64-softmmu --enable-tcg-interpreter"
EXTRA_OECONF_class-native = "--target-list='arm-linux-user armeb-linux-user' --extra-cflags='${CFLAGS}'"

DEFAULT_PREFERENCE_arm = "1"
DEFAULT_PREFERENCE_aarch64 = "1"
DEFAULT_PREFERENCE_armeb = "1"
