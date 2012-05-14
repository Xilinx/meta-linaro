KMACHINE_qemuarmv7a  = "arm-versatile-926ejs"
KBRANCH_qemuarmv7a = "standard/default/arm-versatile-926ejs"

COMPATIBLE_MACHINE_qemuarmv7a = "qemuarmv7a"

# To find the defconfig in case of "qemuarmv7a" BitBake searches the
# $MACHINE subdir automatically. Therefore it is sufficient to add the
# location of this bbappend file to the FILESEXTRAPATHS variable.
FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

DEFCONFIG = ""
DEFCONFIG_qemuarmv7a = "file://defconfig"
SRC_URI += "${DEFCONFIG}"
