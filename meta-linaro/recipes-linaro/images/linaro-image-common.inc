inherit core-image

IMAGE_FEATURES += "ssh-server-openssh nfs-server package-management"

IMAGE_INSTALL += " \
    linaro-lava-tests \
    powertop \
    sudo \
    stress-dbg \
    nss-myhostname \
    bash \
    "

IMAGE_INSTALL_append_aarch64 += "perf"

SDK_IMAGE_INSTALL += "\
    ltp \
    bison \
    boost-date-time \
    boost-filesystem \
    boost-graph \
    boost-iostreams \
    boost-program-options \
    boost-regex \
    boost-signals \
    boost-system \
    boost-thread \
    cmake \
    curl \
    elfutils-dev \
    expat \
    flex \
    gd \
    glog \
    icu \
    libbz2 \
    libcap \
    libc-client-dev \
    libdwarf-dev \
    libevent-fb \
    libmcrypt \
    libmemcached \
    libmysqlclient-r \
    libpam \
    libpcre \
    libunwind \
    libxml2 \
    ncurses \
    onig \
    openldap \
    openssl \
    readline \
    tbb \
    zlib \
    sshfs-fuse \
    "

LAMP_IMAGE_INSTALL += "\
    apache2 \
    mysql5-server \
    mysql5-client \
    php-fpm \
    php-fpm-apache2 \
    "
