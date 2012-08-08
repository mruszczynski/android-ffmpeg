#!/bin/bash
DIR=`dirname $0`
pushd $DIR
. settings.sh

pushd ../speex
./autogen.sh || die "Error running speex/autogen.sh"
./configure || die "Error configuring speex"
make clean || die "Error making speex"
make || die "Error making speex"
popd
ln -s ../speex/libspeex/.libs/libspeexdsp.so.1 ;
ln -s ../speex/libspeex/.libs/libspeex.so.1 ;

popd


