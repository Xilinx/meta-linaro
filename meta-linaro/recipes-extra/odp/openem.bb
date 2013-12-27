DESCRIPTION = "Open Event Machine and Intel DPDK used for OpenDataPlane (ODP) for reference implementation and performance measurements."
SECTION = "console/tools"

LICENSE = "BSD | GPLv2"
LIC_FILES_CHKSUM = "file://LICENSE;md5=dd8b05a36dd5410381ad0679f9151808"
PV = "20131206"

SRC_URI = "git://git.linaro.org/lng/odp.git;name=odp \
	   git://git.linaro.org/lng/dpdk.git;destsuffix=git/dpdk;name=dpdk \
	   git://git.linaro.org/lng/eventmachine-code.git;destsuffix=git/openem;name=openem"

SRCREV_odp = "66cd614e9036084242ce7d3d742a4fa00791b59d"
SRCREV_dpdk = "0e108af9f3cb50020a50903f8b22447257ebbac1"
SRCREV_openem = "a38131fb2284a006b06be8becd5ccdffe90f17a7"
SRCREV_FORMAT = "odp"

S = "${WORKDIR}/git"

# Openem works badly with parallel make. Because of this code will be dropped in future,
# unsetting parallel make here.
PARALLEL_MAKE = ""

# DPDK unables to parse syntax with white spaces like: CC=...-gcc --sysbin=../ --.  DPDK itself is huge
# project which has 54 different make files half of them are generated through configs. And the idea was to use this hack and
# do not spend time on fixing external project, because we are integrating code from dpdk and openem to odp. So that both
# dpdk and openem reference will be dropped and we will go only with single odp.
EXTRA_OEMAKE = "CC=`echo ${CC} | cut -d " " -f 1`  LD=`echo ${LD} | cut -d " " -f 1` AR=`echo ${AR} | cut -d " " -f 1`"

do_compile() {
	# Unset prefix is hack around dpdk. It uses $prefix almost everywhere.
	# And openem prefix corrupts makefile logic. So it has to be unset.
	unset prefix
	oe_runmake dpdk
	oe_runmake openem
}

do_install() {
	#ODP project now builds from odp.bb, however we use for openem and dpdk
	#old tree of odp which has all all makefiles in it.
	#oe_runmake install DESTDIR=${D}

	#copy dpdk files to image
	install -d ${D}/${libdir}/dpdk
	cp -a dpdk/generic_32-default-linuxapp-gcc-openem/lib/* ${D}/${libdir}/dpdk/
	install -d ${D}/${includedir}/dpdk
	cp -rL dpdk/generic_32-default-linuxapp-gcc-openem/include ${D}/${includedir}/dpdk/

	#copy openem
	install -d ${D}/${libdir}/openem
	find openem -type f -perm -o+rx  -exec cp {} ${D}/${libdir}/openem \;
}

# DPDK
# DPDK is software framework which consist of static libraries
# and include files to build applications with that static libraries.
# Include files MUST be in same package as static libraries.
PACKAGES =+ "${PN}-dpdk-staticdev"
FILES_${PN}-dpdk-staticdev += "${libdir}/dpdk/*.a"
FILES_${PN}-dpdk-staticdev += "${includedir}/dpdk"

# OPENEM
PACKAGES =+ "${PN}-example"
PACKAGES =+ "${PN}-example-dbg"
FILES_${PN}-example-dbg += "${libdir}/openem/.debug"
FILES_${PN}-example += "${libdir}/openem"

