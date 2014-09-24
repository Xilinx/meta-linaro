inherit core-image

IMAGE_FEATURES += "ssh-server-openssh nfs-server package-management"

HUGETLB_armv7a = "libhugetlbfs-tests"
HUGETLB_aarch64 = "libhugetlbfs-tests"
HUGETLB ?= ""

IMAGE_INSTALL += " \
    bash \
    e2fsprogs-e2fsck \
    kexec-tools \
    linaro-lava-tests \
    nss-myhostname \
    procps \
    stress \
    stress-dbg \
    sudo \
    util-linux-fsck \
    "

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
    libc-client-dev \
    libcap \
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
    pm-qa \
    powerdebug \
    powertop \
    python \
    python-misc \
    python-multiprocessing \
    python-scons \
    python-shell \
    python-threading \
    qemu \
    readline \
    sshfs-fuse \
    tbb \
    trace-cmd \
    xserver-xorg-xvfb \
    xz \
    zlib \
    ${HUGETLB} \
    "

IMAGE_PREPROCESS_COMMAND += "make_boot_verbose; "


fakeroot make_boot_verbose () {
    sed -i -e 's/VERBOSE=no/VERBOSE=yes/' ${IMAGE_ROOTFS}/etc/default/rcS
}
