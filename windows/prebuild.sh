#!/bin/bash
DIR=`dirname $0`
pushd $DIR
. settings.sh

function die {
  echo "$1 failed" && exit 1
}

pushd ../speex

./autogen.sh || die "Error running speex/autogen.sh"

./configure \
\
--enable-memalign-hack --arch=x86 --target-os=mingw32 --cross-prefix=i686-mingw32- \
\
 || die "Error configuring speex"

make clean || die "Error making speex"
make || die "Error making speex"
popd
find ../speex -name '*.so.*' -exec cp \{\} ./ \;

popd


