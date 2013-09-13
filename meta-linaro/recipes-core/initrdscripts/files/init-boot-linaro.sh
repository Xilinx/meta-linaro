#!/bin/sh

HOME=/root
PATH=/sbin:/bin:/usr/sbin:/usr/bin
PS1="linaro-test [rc=$(echo \$?)]# "
export HOME PS1 PATH

early_setup() {
    mkdir /proc /sys /tmp /run
    mount -t proc proc /proc
    mount -t sysfs sysfs /sys

    ln -s /run /var/run

    mknod /dev/ttyO0 c 253 0
    mknod /dev/ttyO2 c 253 2
    mknod /dev/ttyAMA0 c 204 64
    mknod /dev/ttyAMA2 c 204 66
    mknod /dev/ttySAC2 c 204 66
}

read_args() {
    [ -z "$CMDLINE" ] && CMDLINE=`cat /proc/cmdline`
    for arg in $CMDLINE; do
        optarg=`expr "x$arg" : 'x[^=]*=\(.*\)'`
        case $arg in
            console=*)
                tty=${arg#console=}
                tty=${tty#/dev/}

                case $tty in
                    tty[a-zA-Z]* )
                        port=${tty%%,*}
                esac ;;
            debug) set -x ;;
        esac
    done
}

early_setup
read_args

exec setsid sh -l </dev/${port} >/dev/${port} 2>&1
