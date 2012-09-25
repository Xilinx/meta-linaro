DEPENDS = "linux dtc-native"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=bb63326febfb5fb909226c8e7ebcef5c"
PR = "r0"

SRC_URI = "git://git.kernel.org/pub/scm/linux/kernel/git/cmarinas/boot-wrapper-aarch64.git"

S = "${WORKDIR}/git"
SRCREV = "${AUTOREV}"

COMPATIBLE_HOST = "aarch64"

do_configure() {

     install -m 0644 ${STAGING_KERNEL_DIR}/arch/arm64/boot/dts/vexpress-v2p-aarch64.dts	${S}/vexpress-v2p-aarch64.dts
     install -m 0644 ${STAGING_KERNEL_DIR}/arch/arm64/boot/dts/vexpress-v2m-rs1.dtsi	${S}/vexpress-v2m-rs1.dtsi
     install -m 0644 ${STAGING_KERNEL_DIR}/arch/arm64/boot/dts/skeleton.dtsi			${S}/skeleton.dtsi
     install -m 0644 ${DEPLOY_DIR_IMAGE}/Image ${S}/Image
}

do_deploy() {
	install -m 0644 ${S}/linux-system.axf ${DEPLOY_DIR_IMAGE}
}

addtask deploy before do_build after do_install
