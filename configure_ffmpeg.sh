#!/bin/bash
pushd `dirname $0`
. settings.sh

if [[ $DEBUG == 1 ]]; then
  echo "DEBUG = 1"
  DEBUG_FLAG="--disable-stripping"
fi

pushd ffmpeg

./configure \
$DEBUG_FLAG \
--enable-cross-compile \
--arch=arm \
--cpu=cortex-a8 \
--target-os=linux \
--enable-runtime-cpudetect \
--prefix=/data/data/org.witness.sscvideoproto \
--enable-pic \
--disable-shared \
--enable-static \
--enable-small \
--cross-prefix=$NDK_TOOLCHAIN_BASE/bin/arm-linux-androideabi- \
--sysroot="$NDK_SYSROOT" \
--enable-version3 \
--enable-gpl \
--enable-memalign-hack \
--disable-doc \
\
--disable-asm \
--disable-yasm \
\
--enable-hwaccels \
\
--enable-ffmpeg \
--disable-ffplay \
--disable-ffprobe \
--disable-ffserver \
--enable-libx264 \
--enable-libspeex \
--enable-zlib \
--extra-cflags="-I../x264" \
--extra-ldflags="-L../x264" \
--disable-avdevice \
--disable-devices

popd; popd


