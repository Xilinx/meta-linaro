inherit core-image

IMAGE_INSTALL = " \
    packagegroup-core-standalone-hhvm-sdk-target \
    "

IMAGE_FEATURES += "\
    dev-pkgs \
    staticdev-pkgs \
    "
