require linux-libc-headers.inc

PR = "r0"
PV = "3.7+rc6"

SRC_URI = "http://www.kernel.org/pub/linux/kernel/v3.x/testing/linux-3.7-rc6.tar.xz"

SRCREV = "1c9c5f19c8f049436e3f12ee675d49ce822d8181"

S = "${WORKDIR}/linux-3.7-rc6"

SRC_URI[md5sum] = "66a670a84bacec902d548362e9679112"
SRC_URI[sha256sum] = "43bc96a2fe7419620d89476a3c35321212eca80ecc5e22ef81dca7b60dc67f83"
