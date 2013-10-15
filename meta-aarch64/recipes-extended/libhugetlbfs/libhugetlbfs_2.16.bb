DESCRIPTION = " libhugetlbfs is a library which provides easy access to huge \
pages of memory. It is a wrapper for the hugetlbfs file system. Applications \
can use huge pages to fulfill malloc() requests without being recompiled by \
using LD_PRELOAD. Alternatively, applications can be linked against \
libhugetlbfs without source modifications to load BSS or BSS, data, and \
text segments into large pages."
SUMMARY = "A library which provides easy access to huge pages of memory"
HOMEPAGE = "http://libhugetlbfs.sourceforge.net/"
LICENSE = "LGPL-2.1"
LIC_FILES_CHKSUM = "file://LGPL-2.1;md5=2d5025d4aa3495befef8f17206a5b0a1"

SRCREV = "${AUTOREV}"
PV = "2.16+git${SRCPV}"
PR = "r1"

SRC_URI = "git://git.linaro.org/people/stevecapper/libhugetlbfs.git;branch=aarch64-support \
    file://cross-compile.patch \
    file://install64-fix.patch \
"

S = "${WORKDIR}/git"

LIBARGS_aarch64 = "LIB32=lib32 LIB64=${baselib} V=1"

do_compile() {
    ${MAKE} ARCH=${HOST_ARCH} ${LIBARGS}
}

do_install() {
    ${MAKE} install ARCH=${HOST_ARCH} PREFIX=${prefix} DESTDIR=${D} ${LIBARGS}
    ${MAKE} install-tests ARCH=${HOST_ARCH} PREFIX=${prefix} DESTDIR=${D} ${LIBARGS}

    # nuke the perl libraries
    rm -rf ${D}${libdir}/perl5

    # nuke oprofile scripts
    rm -f ${D}${bindir}/oprofile_*
}

RDEPENDS_${PN} = "python-resource python-subprocess"

INHIBIT_PACKAGE_DEBUG_SPLIT = "1"
