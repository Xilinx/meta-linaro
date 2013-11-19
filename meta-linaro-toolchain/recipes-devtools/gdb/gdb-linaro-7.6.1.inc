LICENSE="GPLv2 & GPLv3 & LGPLv2 & LGPLv3"
LIC_FILES_CHKSUM = "file://COPYING;md5=59530bdf33659b29e73d4adb9f9f6552 \
		    file://COPYING3;md5=d32239bcb673463ab874e80d47fae504 \
		    file://COPYING3.LIB;md5=6a6a8e020838b23406c81b19c1d46df6 \
		    file://COPYING.LIB;md5=9f604d8a4f8e74f4f5140845a21b6674"


MMYY = "13.10"
RELEASE = "20${MMYY}"
PR = "r${RELEASE}"
BINV = "7.6.1"

S = "${WORKDIR}/${BPN}-${PV}-${RELEASE}"

FILESPATH = "${@base_set_filespath([ '${FILE_DIRNAME}/gdb-${BINV}' ], d)}"

SRC_URI = "https://releases.linaro.org/${MMYY}/components/toolchain/gdb-linaro/gdb-${PV}-${RELEASE}.tar.bz2"
SRC_URI[md5sum] = "d735bed03e94d05fbefbb3b2eb897f99"
SRC_URI[sha256sum] = "dcaad3f40a5ceef7923b3f7863df28ea26919e973dd475256c8affc90ed6c78f"
