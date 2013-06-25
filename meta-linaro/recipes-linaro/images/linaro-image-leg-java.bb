require linaro-image-lamp.bb

DESCRIPTION = "A Lamp-based image for Linaro Enterprise Java validation."

IMAGE_INSTALL += "openjdk-7-jre openjdk-7-jdk xserver-xorg-xvfb"

