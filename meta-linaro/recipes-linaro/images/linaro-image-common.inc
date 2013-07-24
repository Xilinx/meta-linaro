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
    acpica \
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
    dmidecode \
    efibootmgr \
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
    ltp \
    ncurses \
    onig \
    openldap \
    openssl \
    python \
    readline \
    tbb \
    zlib \
    sshfs-fuse \
    xserver-xorg-xvfb \
    "
