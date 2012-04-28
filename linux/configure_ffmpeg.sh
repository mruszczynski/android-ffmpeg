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
--enable-runtime-cpudetect \
--enable-pic \
--enable-static \
--enable-small \
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
--enable-libspeex \
--enable-libx264 \
--enable-zlib \
--extra-cflags="-I../x264 -I../speex/include/ -I../faac-1.28/include/" \
--extra-ldflags="-L../x264 -L../speex/libspeex/.libs/" \
--disable-avdevice \
--disable-devices


# --enable-shared \


# Requires --enable-nonfree:
#
#--enable-libaacplus \
#--enable-libfaac \

# Doesn't work:
#
#--enable-libvo-aacenc \


popd; 

popd



