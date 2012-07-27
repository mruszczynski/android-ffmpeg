#!/bin/bash
DIR=`dirname $0`
pushd $DIR
. settings.sh

function die {
  echo "$1 failed" && exit 1
}

pushd ../speex
./autogen.sh || die "Error running speex/autogen.sh"
./configure || die "Error configuring speex"
make clean || die "Error making speex"
make || die "Error making speex"
popd
ln -s ../speex/libspeex/.libs/libspeexdsp.so.1 ;
ln -s ../speex/libspeex/.libs/libspeex.so.1 ;

#pushd ../libaacplus-2.0.2
#./autogen.sh || die "running libaacplus/autogen.sh"
#./configure || die "configuring libaacplus"
#make || die "Error making libaacplus"
#popd

#pushd ../faac-1.28
#./autogen.sh || die "running libaacplus/autogen.sh"
#./configure || die "configuring libaacplus"
#make || die "Error making libaacplus"
#popd

popd


