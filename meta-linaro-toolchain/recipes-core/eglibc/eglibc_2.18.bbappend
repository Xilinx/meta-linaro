MMYY = "13.10"
RELEASE = "20${MMYY}"
PR = "r${RELEASE}"

SRC_URI = "http://releases.linaro.org/${MMYY}/components/toolchain/eglibc-linaro/eglibc-linaro-${PV}-${RELEASE}.tar.bz2 \
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
           file://0001-ARM-Pass-dl_hwcap-to-IFUNC-resolver.patch \
          "

SRC_URI[md5sum] = "3effe2d563db9dcf6f789db647d1b03d"
SRC_URI[sha256sum] = "a62f36a1f26d92504f697ab62283401e82972f9bd357df1576890d89f7b87b6f"

LIC_FILES_CHKSUM = "file://LICENSES;md5=e9a558e243b36d3209f380deb394b213 \
      file://COPYING;md5=393a5ca445f6965873eca0259a17f833 \
      file://posix/rxspencer/COPYRIGHT;md5=dc5485bb394a13b2332ec1c785f5d83a \
      file://COPYING.LIB;md5=bbb461211a33b134d42ed5ee802b37ff "

S = "${WORKDIR}/eglibc-linaro-${PV}-${RELEASE}"
