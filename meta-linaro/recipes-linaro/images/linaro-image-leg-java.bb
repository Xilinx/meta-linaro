require linaro-image-lamp.bb

DESCRIPTION = "A Lamp-based image for Linaro Enterprise Java validation."

IMAGE_INSTALL += " \
    openjdk-7-common \
    openjdk-7-jre \
    openjdk-7-jdk \
    openjdk-8-jre \
    openjdk-8-jdk \
    x11vnc \
    xauth \
    xserver-xorg-xvfb \
    zip \
    "
