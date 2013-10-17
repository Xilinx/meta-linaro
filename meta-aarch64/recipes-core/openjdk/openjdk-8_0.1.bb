require openjdk-8-common.inc

PR = "${INC_PR}.0"

OPENJDK_URI = "http://snapshots.linaro.org/openembedded/sources/openjdk8-aarch64-port-snapshot.tar.bz2"

# The tarball is generated nightly and to avoid updating this file
# each and every day we ignore checksums.

SRC_URI[md5sum] = ""
SRC_URI[sha256sum] = ""

BB_STRICT_CHECKSUM = "0"

LIC_FILES_CHKSUM="file://LICENSE;md5=7b4baeedfe2d40cb03536573bc2c89b1"

BUILD_DIR="linux-aarch64-normal-clientANDserver-release/images"
