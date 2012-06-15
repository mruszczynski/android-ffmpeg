#!/bin/bash
pushd `dirname $0`
. settings.sh

pushd ../ffmpeg

./configure \
\
--disable-stripping \
--enable-debug=3 \
--disable-optimizations \
\
--enable-runtime-cpudetect \
--enable-pic \
--enable-shared \
--enable-version3 \
--enable-memalign-hack \
--disable-doc \
\
--disable-asm \
--disable-yasm \
\
--enable-hwaccels \
\
--enable-network \
--enable-protocol=tcp \
--enable-protocol=udp \
--enable-demuxer=rtsp \
\
--enable-ffmpeg \
--disable-ffplay \
--disable-ffprobe \
--disable-ffserver \
--disable-avdevice \
--disable-devices \
\
--enable-libspeex \
--enable-zlib \
\
--extra-cflags="-O0 -I../speex/include/ " \
--extra-ldflags="-L../speex/libspeex/.libs/" \


# --enable-small \


#--extra-cflags="-I../x264 -I../speex/include/ -I../faac-1.28/include/" \
#--extra-ldflags="-L../x264 -L../speex/libspeex/.libs/" \

#--enable-static \
#--enable-gpl \
#--enable-libx264 \


# Requires --enable-nonfree:
#
#--enable-libaacplus \
#--enable-libfaac \

# Doesn't work:
#
#--enable-libvo-aacenc \


popd; 

popd



