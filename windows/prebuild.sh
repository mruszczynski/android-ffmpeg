#!/bin/bash
DIR=`dirname $0`
pushd $DIR
. settings.sh

function die {
  echo "$1 failed" && exit 1
}


pushd ../speex
./autogen.sh || die "speex/autogen.sh"
export CC=`which i686-mingw32-gcc`
export LD=`which i686-mingw32-ld`
export RANLIB=`which i686-mingw32-ranlib`
export AR=`which i686-mingw32-ar`
./configure \
\
--enable-memalign-hack \
--host=i686-mingw32 \
--enable-shared \
--with-gnu-ld \
\
 || die "configuring speex"
make clean || die "making speex"
make || die "making speex"
popd
find ../speex -name '*.dll' -exec ln -s \{\} \;

popd


