#!/bin/bash

function die {
  echo "$1 failed" && exit 1
}

echo "====================="
echo "Mac Build v0.1"
echo "====================="
echo ""
echo ""

echo ""
echo "====================="
echo "Cleaning"
echo "====================="
echo ""
echo ""

./clean.sh

echo ""
echo "====================="
echo "Build Prerequisites"
echo "====================="
echo ""
echo ""

./prebuild.sh || die "Prebuild"
#./configure_x264.sh || die "X264 configure"
#./make_x264.sh || die "X264 make"

echo ""
echo "====================="
echo "Configure FFMPEG"
echo "====================="
echo ""
echo ""

./configure_ffmpeg.sh || die "FFMPEG configure"

echo ""
echo "====================="
echo "Make FFMPEG"
echo "====================="
echo ""
echo ""

./make_ffmpeg.sh || die "FFMPEG make"

echo ""
echo "====================="
echo "Make SWIG Library"
echo "====================="
echo ""
echo ""

./make_swig.sh || die "FFMPEG make"

echo ""
echo "====================="
echo "Make Links"
echo "====================="
echo ""
echo ""

for f in *.so*; do 
  ls -alh $f; 
  LD_LIBRARY_PATH=. ldd $f; 
done
