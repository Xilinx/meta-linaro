require linaro-image-lamp.bb

DESCRIPTION = "A Lamp-based image for Linaro Enterprise Java validation."

IMAGE_INSTALL += " \
    ganglia \
    git \
    htop \
    links \
    openjdk-8-jdk \
    openjdk-8-jre \
    x11vnc \
    xauth \
    xserver-xorg-xvfb \
    zip \
    "
