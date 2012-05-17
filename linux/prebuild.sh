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
find ../speex -name '*.so' -exec cp \{\} ./ \;
find ../speex -name '*.so.*' -exec cp \{\} ./ \;

#pushd ../ffmpeg-swig
#mvn clean
#make || die "Error making ffmpeg-swig"
#mvn install
#popd
#find ../ffmpeg-swig -name '*.so' -exec cp \{\} ./ \;
#find ../ffmpeg-swig -name '*.so.*' -exec cp \{\} ./ \;

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


