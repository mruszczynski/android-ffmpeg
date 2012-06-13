#!/bin/bash
pushd `dirname $0`
. settings.sh

if [[ $DEBUG == 1 ]]; then
  echo "DEBUG = 1"
  DEBUG_FLAG="--disable-stripping"
fi

pushd ../ffmpeg

./configure \
$DEBUG_FLAG \
--enable-cross-compile \
--arch=arm \
--cpu=cortex-a8 \
--target-os=linux \
--enable-runtime-cpudetect \
--enable-pic \
--enable-shared \
--enable-small \
--cross-prefix=$NDK_TOOLCHAIN_BASE/bin/arm-linux-androideabi- \
--sysroot="$NDK_SYSROOT" \
--enable-version3 \
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
--enable-libspeex \
--enable-zlib \
--extra-cflags="-I../x264 -I../speex/include/" \
--extra-ldflags="-L../x264 -L../android-project/obj/local/armeabi/" \
--disable-avdevice \
--disable-devices


find -name 'Makefile' -exec sed -i 's|include $(SUBDIR)../config.mak||g' \{\} \;


popd; 
popd


