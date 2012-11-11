#!/bin/bash
DIR=`dirname $0`
pushd $DIR
. settings.sh

echo ""
echo "====================="
echo "Build Speex"
echo "====================="
echo ""
echo ""

pushd ../speex
ACLOCAL_FLAGS="-I /opt/local/share/aclocal" \
./autogen.sh || die "Error running speex/autogen.sh"
./configure --prefix=/tmp/.pluggedin \
 || die "Error configuring speex"
make clean || die "Error making speex"
make || die "Error making speex"
popd
find ../speex -name '*.dylib' -exec ln -s \{\} ./ \;

popd


