#!/bin/bash
DIR=`dirname $0`
pushd $DIR
. settings.sh

function die {
  echo "$1 failed" && exit 1
}

pushd ../speex

./autogen.sh || die "speex/autogen.sh"

#  CC          C compiler command
export CC=`which i686-mingw32-gcc`
#  CFLAGS      C compiler flags
#  LDFLAGS     linker flags, e.g. -L<lib dir> if you have libraries in a
#              nonstandard directory <lib dir>
#  LIBS        libraries to pass to the linker, e.g. -l<library>
#  CPPFLAGS    C/C++/Objective C preprocessor flags, e.g. -I<include dir> if
#              you have headers in a nonstandard directory <include dir>
#  CPP         C preprocessor
#  PKG_CONFIG  path to pkg-config utility
#  FFT_CFLAGS  C compiler flags for FFT, overriding pkg-config
#  FFT_LIBS    linker flags for FFT, overriding pkg-config

#--enable-memalign-hack --arch=x86 --target-os=mingw32 --cross-prefix=i686-mingw32- \

./configure \
\
--enable-memalign-hack --host \
\
 || die "configuring speex"

make clean || die "making speex"
make || die "making speex"
popd
find ../speex -name '*.so.*' -exec cp \{\} ./ \;

popd


