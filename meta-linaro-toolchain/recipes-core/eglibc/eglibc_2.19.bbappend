# In case of aarch64_be install symlink to ld-linux-aarch64_be.so.1
# to enable transition of toolchain and executables that are not yet
# aware about aarch64_be run-time linker name change.
#
# Currently there is no use case that requires both LE and BE eglibc
# installed into the same rootfs, so our transitional symlink should
# be fine.
#
do_install_append_aarch64-be() {
    ln -sf ld-linux-aarch64_be.so.1 ${D}${base_libdir}/ld-linux-aarch64.so.1
}
