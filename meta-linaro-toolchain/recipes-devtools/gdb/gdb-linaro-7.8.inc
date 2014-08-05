LICENSE="GPLv2 & GPLv3 & LGPLv2 & LGPLv3"
LIC_FILES_CHKSUM = "file://COPYING;md5=59530bdf33659b29e73d4adb9f9f6552 \
		    file://COPYING3;md5=d32239bcb673463ab874e80d47fae504 \
		    file://COPYING3.LIB;md5=6a6a8e020838b23406c81b19c1d46df6 \
		    file://COPYING.LIB;md5=9f604d8a4f8e74f4f5140845a21b6674"


MMYY = "14.08"
RELEASE = "20${MMYY}"
PR = "r${RELEASE}"
BINV = "7.8"

S = "${WORKDIR}/${BPN}-${PV}-${RELEASE}"

FILESPATH = "${@base_set_filespath([ '${FILE_DIRNAME}/gdb-${BINV}' ], d)}"

SRC_URI = "https://releases.linaro.org/${MMYY}/components/toolchain/gdb-linaro/gdb-${PV}-${RELEASE}.tar.bz2"
SRC_URI[md5sum] = "c6cbbc260667bb3115858a9ba4d75339"
SRC_URI[sha256sum] = "dc3802d250fccff9092f615c2e215df9e986f4f350d73fcc3c4bb9650b218f4d"
