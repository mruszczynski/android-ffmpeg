#!/bin/bash
pushd `dirname $0`
. settings.sh

pushd ../ffmpeg

./configure \
\
--enable-runtime-cpudetect \
--enable-pic \
--enable-shared \
--enable-version3 \
--enable-memalign-hack \
--disable-doc \
\
--disable-everything \
\
--enable-filter=aresample \
\
--enable-encoder=aac \
--enable-decoder=aac \
--enable-parser=aac \
\
--enable-encoder=mpeg4 \
--enable-decoder=mpeg4 \
--enable-parser=mpeg4video \
\
--enable-encoder=nellymoser \
--enable-decoder=nellymoser \
--enable-encoder=flv \
--enable-decoder=flv \
--enable-muxer=flv \
--enable-demuxer=flv \
--enable-protocol=rtmp \
\
--enable-encoder=libspeex \
--enable-decoder=libspeex \
\
--disable-ffmpeg \
--disable-ffplay \
--disable-ffprobe \
--disable-ffserver \
--disable-avdevice \
--disable-devices \
\
--disable-asm \
--disable-yasm \
\
--enable-hwaccels \
--enable-network \
\
--enable-libspeex \
--enable-zlib \
\
--extra-cflags="-O0 -I../speex/include/ " \
--extra-ldflags="-L../speex/libspeex/.libs/" \
|| die "Failed to configure"

popd; 
popd

exit 0;




\
--disable-stripping \
--enable-debug=3 \
--disable-optimizations \

