RDEPENDS_packagegroup-self-hosted-host-tools = "\
    connman \
    connman-plugin-ethernet \
    dhcp-client \
    e2fsprogs \
    e2fsprogs-e2fsck \
    e2fsprogs-mke2fs \
    e2fsprogs-tune2fs \
    genext2fs \
    hdparm \
    iptables \
    lsb \
    mc \
    parted \
    pseudo \
    screen \
    vte \
    "

RRECOMMENDS_packagegroup-self-hosted-host-tools = "\
    kernel-module-tun \
    kernel-module-iptable-raw \
    kernel-module-iptable-nat \
    kernel-module-iptable-mangle \
    kernel-module-iptable-filter \
	"

RDEPENDS_packagegroup-self-hosted-debug = " \
    gdb \
    gdbserver \
    rsync \
    tcf-agent"


RDEPENDS_packagegroup-self-hosted-extended = "\
    bzip2 \
    chkconfig \
    chrpath \
    cpio \
    curl \
    diffstat \
    diffutils \
    elfutils \
    expat \
    gamin \
    gawk \
    gdbm \
    gettext \
    gettext-runtime \
    git \
    grep \
    groff \
    gzip \
    hicolor-icon-theme \
    libusb1 \
    libxml2 \
    lrzsz \
    lsof \
    lzo \
    man \
    man-pages \
    mdadm \
    minicom \
    mtools \
    ncurses \
    neon \
    nfs-utils \
    nfs-utils-client \
    openssl \
    opkg \
    opkg-utils \
    patch \
    perl \
    perl-dev \
    perl-modules \
    perl-pod \
    ${PTH} \
    python \
    python-compile \
    python-compiler \
    python-compression \
    python-core \
    python-curses \
    python-datetime \
    python-distutils \
    python-elementtree \
    python-email \
    python-fcntl \
    python-logging \
    python-misc \
    python-multiprocessing \
    python-netclient \
    python-netserver \
    python-pickle \
    python-pkgutil \
    python-re \
    python-rpm \
    python-shell \
    python-sqlite3 \
    python-subprocess \
    python-textutils \
    python-unixadmin \
    python-xmlrpc \
    quota \
    readline \
    rpm \
    setserial \
    socat \
    subversion \
    sudo \
    sysstat \
    tar \
    tcl \
    texi2html \
    texinfo \
    unzip \
    usbutils \
    watchdog \
    wget \
    which \
    xinetd \
    zip \
    zlib \
    "
