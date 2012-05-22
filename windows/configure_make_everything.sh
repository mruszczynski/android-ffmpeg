#!/bin/bash

function die {
  echo "$1 failed" && exit 1
}

./clean.sh
#./prebuild.sh || die "Prebuild"
./configure_ffmpeg.sh || die "FFMPEG configure"
./make_ffmpeg.sh || die "FFMPEG make"
./make_swig.sh || die "SWIG make"

