# so far postgresql does not have spinlock support on AArch64

EXTRA_OECONF_aarch64 += " --disable-spinlocks "
