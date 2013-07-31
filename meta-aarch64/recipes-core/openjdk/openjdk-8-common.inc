DESCRIPTION = "Java runtime based upon the OpenJDK8"
HOMEPAGE = "http://icedtea.classpath.org"
LICENSE  = "GPL-2.0-with-classpath-exception"
PRIORITY = "optional"
SECTION  = "libs"
INHIBIT_PACKAGE_STRIP = "1"
#INHIBIT_PACKAGE_DEBUG_SPLIT = "1"

INC_PR = "r6"

SRC_URI = " \
  ${OPENJDK_URI} \
  "

libdir_jvm ?= "${libdir}/jvm"

JDKPN = "openjdk-8"
JDK_DIR = "java-8-openjdk"
JDK_HOME = "${libdir_jvm}/${JDK_DIR}"

PN = "${JDKPN}-jre"
PROVIDES += "${JDKPN}"

DEPENDS = " \
	   icedtea7-native \
	   zip-native \
	   zlib \
	   jpeg libpng giflib \
	   gtk+ glib-2.0 \
	   cups fontconfig \
	   libxt libxinerama libxrender libxtst libxi \
	   freetype alsa-lib libffi libxt \
	  "

# No package should directly depend on this (it should require
# java2-runtime instead).
PRIVATE_LIBS = "\
	libunpack.so libverify.so libjava.so libzip.so libnpt.so \
	libjava_crw_demo.so libhprof.so libnet.so libnio.so \
	libmanagement.so libinstrument.so libjsound.so libjsoundalsa.so \
	libj2pcsc.so libj2pkcs11.so libj2gss.so libmlib_image.so \
	libawt.so libsplashscreen.so libfreetype.so.6 libfontmanager.so \
	libjpeg.so liblcms.so librmi.so libjawt.so libjaas_unix.so \
	libattach.so libjdwp.so libdt_socket.so libhpi.so libjli.so \
	libmawt.so libjvm.so \
	libversionCheck.so libcompiledMethodLoad.so libgctest.so \
	libheapViewer.so libheapTracker.so libminst.so libmtrace.so \
	libwaiters.so libhprof.so \
       "

JAVA_HOME[unexport] = "1"
S="${WORKDIR}/jdk8"

do_configure() {
	unset MAKE
	bash ./configure --with-debug-level=release --with-jvm-variants=client --with-sys-root=${STAGING_DIR_TARGET} --enable-unlimited-crypto --openjdk-target=aarch64-oe-linux --with-cacerts-file=${STAGING_LIBDIR_NATIVE}/jvm/icedtea7-native/jre/lib/security/cacerts --with-zlib=system --with-stdc++lib=dynamic --with-boot-jdk=${STAGING_LIBDIR_NATIVE}/jvm/icedtea7-native
}

do_compile() {
	make images
}

do_install() {
	install -d ${D}${libdir_jvm}
	cp -R ${S}/build/${BUILD_DIR}/j2sdk-image ${D}${JDK_HOME}
	chmod u+rw -R ${D}${JDK_HOME}
}

PACKAGES = " \
	    ${JDKPN}-jdk \
	    ${JDKPN}-doc \
	    ${JDKPN}-source \
	    ${JDKPN}-demo \
	    ${JDKPN}-jre \
	   "

FILES_${JDKPN}-jdk = " \
		       ${JDK_HOME}/bin \
		       ${JDK_HOME}/lib \
		       ${JDK_HOME}/include \
		       ${JDK_HOME}/ASSEMBLY_EXCEPTION \
		       ${JDK_HOME}/release \
		       ${JDK_HOME}/THIRD_PARTY_README \
		       ${JDK_HOME}/LICENSE \
		      "

FILES_${JDKPN}-doc = " \
		       ${JDK_HOME}/man \
		      "

FILES_${JDKPN}-source = " \
		          ${JDK_HOME}/src.zip \
			"

FILES_${JDKPN}-demo = " \
		        ${JDK_HOME}/demo \
                        ${JDK_HOME}/sample \
                      "

FILES_${PN} = " \
	        ${JDK_HOME}/jre \
              "

INSANE_SKIP_${JDKPN}-jdk = "dev-so"
INSANE_SKIP_${JDKPN}-jre = "dev-so"

RPROVIDES_${JDKPN}-jre = "java2-runtime"
RPROVIDES_${JDKPN}-jre = "java2-vm"

RDEPENDS_${JDKPN}-demo = "java2-runtime"

inherit update-alternatives

pkg_postinst_${JDKPN}-jre () {
    update-alternatives --install ${bindir}/java java ${JDK_HOME}/jre/bin/java 75
}

pkg_prerm_${JDKPN}-jre () {
    update-alternatives --remove java ${JDK_HOME}/jre/bin/java
}

pkg_postinst_${JDKPN}-jdk () {
    update-alternatives --install ${bindir}/java javac ${JDK_HOME}/bin/java 100
    update-alternatives --install ${bindir}/javac javac ${JDK_HOME}/bin/javac 100
}

pkg_prerm_${JDKPN}-jdk () {
    update-alternatives --remove java ${JDK_HOME}/bin/java
    update-alternatives --remove javac ${JDK_HOME}/bin/javac
}
