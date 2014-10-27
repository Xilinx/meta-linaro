DESCRIPTION = "Linaro LNG Kernel For x86"

require linaro-lng.inc

PV = "3.14+git${SRCPV}"

inherit kernel siteinfo

SRC_URI = "git://git.linaro.org/kernel/linux-linaro-lng.git;branch=linux-linaro-lng-v3.14-rt"
