PR = "r5"

SRC_URI = "http://releases.linaro.org/13.07/components/toolchain/eglibc-linaro/eglibc-linaro-2.17-2013.07.tar.bz2 \
           file://eglibc-svn-arm-lowlevellock-include-tls.patch \
           file://IO-acquire-lock-fix.patch \
           file://mips-rld-map-check.patch \
           file://etc/ld.so.conf \
           file://generate-supported.mk \
           file://glibc.fix_sqrt2.patch \
           file://multilib_readlib.patch \
           file://ppc-sqrt_finite.patch \
           file://GLRO_dl_debug_mask.patch \
           file://initgroups_keys.patch \
           file://eglibc_fix_findidx_parameters.patch \
           file://ppc_slow_ieee754_sqrt.patch \
           file://fileops-without-wchar-io.patch \
           file://add_resource_h_to_wait_h.patch \
           file://0001-eglibc-menuconfig-support.patch \
           file://0002-eglibc-menuconfig-hex-string-options.patch \
           file://0003-eglibc-menuconfig-build-instructions.patch \
           file://fsl-ppc-no-fsqrt.patch \
           file://0001-R_ARM_TLS_DTPOFF32.patch \
           file://tzselect-sh.patch \
           file://tzselect-awk.patch \
           file://0001-eglibc-run-libm-err-tab.pl-with-specific-dirs-in-S.patch \
           file://fix-tibetian-locales.patch \
          "

SRC_URI[md5sum] = "95209b5f7adf666ecae5142bd85cf568"
SRC_URI[sha256sum] = "f8c5164e45dfc2fce5eeb98b2416dc797a949a3842649f61e743b6d0e854ae93"

S = "${WORKDIR}/eglibc-linaro-2.17-2013.07"

LIC_FILES_CHKSUM = "file://LICENSES;md5=e9a558e243b36d3209f380deb394b213 \
      file://COPYING;md5=393a5ca445f6965873eca0259a17f833 \
      file://posix/rxspencer/COPYRIGHT;md5=dc5485bb394a13b2332ec1c785f5d83a \
      file://COPYING.LIB;md5=bbb461211a33b134d42ed5ee802b37ff "

