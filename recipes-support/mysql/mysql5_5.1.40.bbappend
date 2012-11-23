do_configure_append() {
     # handle distros with different values of ${libexecdir}
     libexecdir2=`echo ${libexecdir} | sed -e 's+/usr/++g'`
     sed -i -e "s:/libexec:/$libexecdir2:g" ${S}/scripts/mysql_install_db.sh
     sed -i -e "s:mysqld libexec:mysqld $libexecdir2:g" ${S}/scripts/mysql_install_db.sh
     sed -i -e "s:/libexec:/$libexecdir2:g" ${S}/scripts/mysqld_safe.sh
}
