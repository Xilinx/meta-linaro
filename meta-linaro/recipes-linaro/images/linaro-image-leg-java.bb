require linaro-image-lamp.bb

DESCRIPTION = "A Lamp-based image for Linaro Enterprise Java validation."

IMAGE_INSTALL += " \
    ganglia \
    git \
    htop \
    links \
    openjdk-8-doc \
    openjdk-8-jdk \
    openjdk-8-jre \
    openjdk-8-jtreg \
    openjdk-8-source \
    tmux \
    vim \
    x11vnc \
    xauth \
    xserver-xorg-xvfb \
    zip \
    "
