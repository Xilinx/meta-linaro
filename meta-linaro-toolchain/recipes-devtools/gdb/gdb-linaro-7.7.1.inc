LICENSE="GPLv2 & GPLv3 & LGPLv2 & LGPLv3"
LIC_FILES_CHKSUM = "file://COPYING;md5=59530bdf33659b29e73d4adb9f9f6552 \
		    file://COPYING3;md5=d32239bcb673463ab874e80d47fae504 \
		    file://COPYING3.LIB;md5=6a6a8e020838b23406c81b19c1d46df6 \
		    file://COPYING.LIB;md5=9f604d8a4f8e74f4f5140845a21b6674"


MMYY = "14.06"
RELEASE = "20${MMYY}-1"
PR = "r${RELEASE}"
BINV = "7.7.1"

S = "${WORKDIR}/${BPN}-${PV}-${RELEASE}"

FILESPATH = "${@base_set_filespath([ '${FILE_DIRNAME}/gdb-${BINV}' ], d)}"

SRC_URI = "https://releases.linaro.org/${MMYY}/components/toolchain/gdb-linaro/gdb-${PV}-${RELEASE}.tar.bz2"
SRC_URI[md5sum] = "efc3c547c501ead7b643e3d1c2fd9fd6"
SRC_URI[sha256sum] = "9ec65e3e7ec9de03d9f2c7dba7cd4e0aa9b716f5f9f5a82901ed22f6d9eb8bf5"
