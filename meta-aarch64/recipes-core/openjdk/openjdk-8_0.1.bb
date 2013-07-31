require openjdk-8-common.inc

PR = "${INC_PR}.0"

OPENJDK_URI = "http://people.linaro.org/~andrew.mcdermott/jdk8.tar.xz"

SRC_URI[md5sum] = "ddb7b9e44638795eaef9c2e36153358e"
SRC_URI[sha256sum] = "7a24536b5e14e30328cec08543788743d5aac12f65fe51db543d2fe6f8e4a0ab"

LIC_FILES_CHKSUM="file://LICENSE;md5=7b4baeedfe2d40cb03536573bc2c89b1"

BUILD_DIR="linux-aarch64-normal-client-release/images"
