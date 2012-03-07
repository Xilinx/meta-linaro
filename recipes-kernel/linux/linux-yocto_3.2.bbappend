KMACHINE_qemuarmv7a  = "arm-versatile-926ejs"
KBRANCH_qemuarmv7a = "standard/default/arm-versatile-926ejs"

COMPATIBLE_MACHINE = "(qemuarm|qemuarmv7a|qemux86|qemuppc|qemumips|qemux86-64)"

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}/${MACHINE}:"

SRC_URI_append = " file://defconfig"
