DEFAULTTUNE ?= "aarch64"

ARMPKGARCH ?= "aarch64"

TUNEVALID[aarch64] = "Enable instructions for aarch64"
TUNECONFLICTS[aarch64] = ""
MACHINEOVERRIDES .= "${@bb.utils.contains("TUNE_FEATURES", "aarch64", ":aarch64", "" ,d)}"

# Little Endian base configs
AVAILTUNES += "aarch64"
TUNE_FEATURES_tune-aarch64 ?= "aarch64"

TUNE_ARCH = "aarch64"
TUNE_PKGARCH = "aarch64"

PACKAGE_EXTRA_ARCHS += "aarch64"

# toolchain bits which were in conf/site.conf

GCCVERSION       ?= "linaro-4.7"
SDKGCCVERSION    ?= "linaro-4.7"
BINUVERSION      ?= "2.23.51%"
LINUXLIBCVERSION ?= "3.7%"
