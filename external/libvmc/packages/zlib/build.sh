PACKAGE_VERSION="1.2.12"
PACKAGE_SRCURL="https://www.zlib.net/zlib-$PACKAGE_VERSION.tar.xz"
PACKAGE_SHA256="7db46b8d7726232a621befaab4a1c870f00a90805511c0e0090441dac57def18"

builder_step_configure() {
	CFLAGS+=" $CPPFLAGS -fPIC"
	LDFLAGS+=" -fPIC"
	"$PACKAGE_SRCDIR"/configure \
		--prefix="$PACKAGE_INSTALL_PREFIX" --static
}
