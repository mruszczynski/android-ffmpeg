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
--enable-memalign-hack --arch=x86 --target-os=mingw32 --cross-prefix=i686-mingw32- \
\
--enable-runtime-cpudetect \
--enable-pic \
--enable-shared \
--enable-version3 \
--enable-memalign-hack \
--disable-doc \
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
|| die "Failed to configure ffmpeg"

#\
#--enable-hwaccels \
#\
#--enable-runtime-cpudetect \
#\
#--disable-asm \
#--disable-yasm \

#\
#--enable-network \
#--enable-protocol=tcp \
#--enable-protocol=udp \
#--enable-demuxer=rtsp \

#--enable-small \
#--enable-libspeex \
#--enable-zlib \
#\
#--extra-cflags="-I../speex/include/" \
#--extra-ldflags="-L../speex/libspeex/.libs/" \


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



