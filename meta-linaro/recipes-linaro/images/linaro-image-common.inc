inherit core-image

IMAGE_FEATURES += "ssh-server-openssh nfs-server package-management"

IMAGE_INSTALL += " \
    e2fsprogs-e2fsck \
    linaro-lava-tests \
    sudo \
    stress-dbg \
    stress \
    nss-myhostname \
    bash \
    procps \
    util-linux-fsck \
    "

IMAGE_INSTALL_append_aarch64 = "libhugetlbfs"

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
    gator \
    gd \
    git \
    glog \
    icu \
    idlestat \
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
    lshw \
    ltp \
    ncurses \
    onig \
    openldap \
    openssh-sftp-server \
    openssl \
    powerdebug \
    powertop \
    python \
    qemu \
    readline \
    tbb \
    xz \
    zlib \
    sshfs-fuse \
    xserver-xorg-xvfb \
    "

IMAGE_PREPROCESS_COMMAND += "make_boot_verbose; "


fakeroot make_boot_verbose () {
    sed -i -e 's/VERBOSE=no/VERBOSE=yes/' ${IMAGE_ROOTFS}/etc/default/rcS
}
