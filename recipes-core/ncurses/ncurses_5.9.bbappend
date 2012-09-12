do_configure_prepend() {
	install -m 0755 ${STAGING_DATADIR_NATIVE}/gnu-config/config.{guess,sub} ${S}
}
