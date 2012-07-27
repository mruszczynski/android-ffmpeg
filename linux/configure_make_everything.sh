#!/bin/bash

function die {
  echo "$1 failed" && exit 1
}

./clean.sh
./prebuild.sh || die "Prebuild"
#./configure_x264.sh || die "X264 configure"
#./make_x264.sh || die "X264 make"
./configure_ffmpeg.sh || die "FFMPEG configure"
./make_ffmpeg.sh || die "FFMPEG make"
./make_swig.sh || die "Swig make"

for f in *.so*; do 
  ls -alh $f; 
  LD_LIBRARY_PATH=. ldd $f; 
done
