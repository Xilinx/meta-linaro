SRC_URI_append= " git://git.kernel.org/pub/scm/linux/kernel/git/cmarinas/boot-wrapper-aarch64.git;protocol=http;branch=master;name=bootwrapper;destsuffix=bootwrapper \
"

SRCREV_bootwrapper = "2ff0b45423226d3de898a52a81b8e90b20fecd60"
BW = "${WORKDIR}/bootwrapper"
DTBDIR="${S}/arch/arm64/boot/dts/"

# Bootwrapper needs libgcc_s.so
DEPENDS =+ "libgcc"

export WRAPCFLAGS = "${CFLAGS}"
export WRAPCPPFLAGS = "${CPPFLAGS}"
export WRAPCXXFLAGS = "${CXXFLAGS}"
export WRAPLDFLAGS = "${LDFLAGS}"

do_compile_append() {
    cd ${S}
    oe_runmake dtbs
    cd ${BW}

    # Ensure the compile can find libgcc.a and other userspace friends
    export CFLAGS="${WRAPCFLAGS}"
    export CPPFLAGS="${WRAPCPPFLAGS}"
    export CXXFLAGS="${WRAPCXXFLAGS}"
    export LDFLAGS="${WRAPLDFLAGS}"

    autoreconf -vfi
    ./configure --host=aarch64-linux-gnu \
                --with-kernel-dir="${S}" \
                --with-cmdline="${BOOTARGS_COMMON} root=/dev/vda"
    make IMAGE=linux-system-foundation.axf clean
    make DTC=${S}/scripts/dtc/dtc \
         KERNEL_DTB="${DTBDIR}/foundation-v8.dtb" \
         IMAGE=linux-system-foundation.axf
    make IMAGE=img-foundation.axf clean
    ./configure --host=aarch64-linux-gnu \
                --with-kernel-dir="${S}" \
                --with-cmdline="${BOOTARGS_COMMON} root=/dev/vda2"
    make DTC=${S}/scripts/dtc/dtc \
         KERNEL_DTB="${DTBDIR}/foundation-v8.dtb" \
         IMAGE=img-foundation.axf
    make IMAGE=img.axf clean
    ./configure --host=aarch64-linux-gnu \
                --with-kernel-dir="${S}" \
                --with-cmdline="${BOOTARGS_COMMON} root=/dev/mmcblk0p2"
    make DTC=${S}/scripts/dtc/dtc \
         KERNEL_DTB="${DTBDIR}/rtsm_ve-aemv8a.dtb" \
         IMAGE=img.axf
}

do_install_append() {
         install -m 0644 ${BW}/img-foundation.axf ${D}/boot/img-foundation.axf
}

do_deploy_append() {
    install -d ${DEPLOYDIR}
    install -m 0644 ${BW}/img.axf ${DEPLOYDIR}/img-${PV}.axf
    install -m 0644 ${BW}/linux-system-foundation.axf ${DEPLOYDIR}/linux-system-foundation-${PV}.axf
    install -m 0644 ${BW}/img-foundation.axf ${DEPLOYDIR}/img-foundation-${PV}.axf
    cd ${DEPLOYDIR}
    ln -sf img-${PV}.axf img.axf
    ln -sf linux-system-foundation-${PV}.axf linux-system-foundation.axf
    ln -sf img-foundation-${PV}.axf img-foundation.axf
}

PACKAGES =+ "kernel-bootwrapper"
FILES_kernel-bootwrapper = "/boot/img-foundation.axf"
