SUMMARY = "HipHop VM porting SDK (target tools)"
LICENSE = "MIT"
PR = "r0"

inherit packagegroup

RDEPENDS_${PN} = "\
    packagegroup-core-standalone-sdk-target \
    binutils-dev \
    binutils-staticdev \
    bison \
    boost \
    bzip2-dev \
    cmake \
    elfutils-dev \
    elfutils-staticdev \
    expat \
    flex \
    gd-dev \
    gd-staticdev \
    google-glog-dev \
    icu-dev \
    libcap-dev \
    libcap-staticdev \
    libc-client-dev \
    libc-client-staticdev \
    libevent-fb-dev \
    libevent-fb-staticdev \
    libglade-dev \
    libmcrypt-dev \
    libmemcached-dev \
    libmemcached-staticdev \
    libmysqlclient-dev \
    libmysqlclient-staticdev \
    libpam-dev \
    libpcre-dev \
    libpcre-staticdev \
    libxml2-dev \
    libxml2-staticdev \
    ncurses-dev \
    ncurses-staticdev \
    onig-dev \
    openldap-dev \
    openssl-dev \
    openssl-staticdev \
    readline-dev \
    tbb-dev \
    zlib-dev \
    "
