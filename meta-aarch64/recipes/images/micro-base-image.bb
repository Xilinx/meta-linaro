# micro-base-image
#
# Image configuration for the OE Micro Linux Distribuion (micro, micro-uclibc)
#

# Install basic files only
IMAGE_INSTALL = "base-files \
	         base-passwd \
		 dropbear \
		 netbase \
		 busybox \
		 sysvinit sysvinit-pidof"
IMAGE_LINGUAS = ""

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=3f40d7994397109285ec7b81fdeb3b58 \
                    file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

inherit image
