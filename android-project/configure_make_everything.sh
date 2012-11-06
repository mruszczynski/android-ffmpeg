#!/bin/bash

function die {
  echo "$1 failed" && exit 1
}

pushd `dirname $0`
. settings.sh
./clean.sh
./prebuild.sh || die "Prebuild"
./make_android.sh || die "ndk-build"
./configure_x264.sh || die "X264 configure"
./make_x264.sh || die "X264 make"
./configure_ffmpeg.sh || die "FFMPEG configure"
#./make_ffmpeg.sh || die "FFMPEG make"
ndk-build || die "ndk-build"
popd



