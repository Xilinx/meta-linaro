DEPENDS = "liboil avahi libsamplerate0 libsndfile1 libtool \
           ${@base_contains('DISTRO_FEATURES', 'x11', 'virtual/libx11 libxtst libice libsm libxcb gtk+', '', d)}"
DEPENDS += "libjson gdbm speex libxml-parser-perl-native"
