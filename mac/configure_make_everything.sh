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

./clean.sh || die "clean"

echo ""
echo "====================="
echo "Build Prerequisites"
echo "====================="
echo ""
echo ""

./prebuild.sh || die "Prebuild"

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
