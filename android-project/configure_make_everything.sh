#!/bin/bash
pushd `dirname $0`

#. settings.sh
function die {
  echo "$1 failed" && exit 1
}

./clean.sh
./prebuild.sh || die "Prebuild"
./make_android.sh prebuild || die "ndk-build prebuild"
./configure_ffmpeg.sh || die "FFMPEG configure"
./make_ffmpeg.sh || die "FFMPEG make"
./make_android.sh all || die "ndk-build all"

popd;

