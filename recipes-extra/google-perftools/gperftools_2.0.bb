LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://COPYING;md5=762732742c73dc6c7fbe8632f06c059a"

SRC_URI = "${DEBIAN_MIRROR}/main/g/google-perftools/google-perftools_${PV}.orig.tar.gz"

SRC_URI[md5sum] = "13f6e8961bc6a26749783137995786b6"
SRC_URI[sha256sum] = "7de3dd91f018825b1e7d332af1edace15c6211f430186febede1835069861080"

inherit autotools
