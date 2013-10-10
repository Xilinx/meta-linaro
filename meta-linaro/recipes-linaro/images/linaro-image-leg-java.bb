require linaro-image-lamp.bb

DESCRIPTION = "A Lamp-based image for Linaro Enterprise Java validation."

IMAGE_INSTALL += " \
    links \
    openjdk-8-jre \
    openjdk-8-jdk \
    x11vnc \
    xauth \
    xserver-xorg-xvfb \
    zip \
    "
