require openjdk-8-common.inc

PR = "${INC_PR}.0"

OPENJDK_URI = "\
	git://git.linaro.org/leg/openjdk/jdk8.git;destsuffix=git/jdk8;name=jdk8 \
	git://git.linaro.org/leg/openjdk/corba.git;destsuffix=git/jdk8/corba;name=corba \
	git://git.linaro.org/leg/openjdk/hotspot.git;destsuffix=git/jdk8/hotspot;name=hotspot \
	git://git.linaro.org/leg/openjdk/jaxp.git;destsuffix=git/jdk8/jaxp;name=jaxp \
	git://git.linaro.org/leg/openjdk/jaxws.git;destsuffix=git/jdk8/jaxws;name=jaxws \
	git://git.linaro.org/leg/openjdk/jdk.git;destsuffix=git/jdk8/jdk;name=jdk \
	git://git.linaro.org/leg/openjdk/langtools.git;destsuffix=git/jdk8/langtools;name=langtools \
	git://git.linaro.org/leg/openjdk/nashorn.git;destsuffix=git/jdk8/nashorn;name=nashorn"

SRCREV_jdk8 = "${AUTOREV}"
SRCREV_corba = "${AUTOREV}"
SRCREV_hotspot = "${AUTOREV}"
SRCREV_jaxp = "${AUTOREV}"
SRCREV_jaxws = "${AUTOREV}"
SRCREV_jdk = "${AUTOREV}"
SRCREV_langtools = "${AUTOREV}"
SRCREV_nashorn = "${AUTOREV}"

S = "${WORKDIR}/git/jdk8"

LIC_FILES_CHKSUM="file://LICENSE;md5=7b4baeedfe2d40cb03536573bc2c89b1"

BUILD_DIR="linux-aarch64-normal-clientANDserver-release/images"
