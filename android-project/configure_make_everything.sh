#!/bin/bash
DIR=`dirname $0`
pushd $DIR

. settings.sh
./clean.sh
./prebuild.sh || die "Prebuild"
./make_android.sh || die "ndk-build"
./configure_ffmpeg.sh || die "FFMPEG configure"
./make_ffmpeg.sh || die "FFMPEG make"
ndk-build -j8 || die "ndk-build"
#./make_swig.sh || die "Swig make"

for f in *.so*; do 
  ls -alh $f; 
  LD_LIBRARY_PATH=. ldd $f; 
done

popd;

