require recipes-core/images/core-image-minimal.bb
require linaro-image-common.inc

IMAGE_INSTALL += "\
    ${@bb.utils.contains("TUNE_FEATURES", "ilp32", "kernel-image", "", d)} \
    ltp \
"
