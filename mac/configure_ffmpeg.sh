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
--disable-stripping \
--enable-debug=3 \
--disable-optimizations \
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
--enable-libspeex \
--enable-encoder=libspeex \
--enable-decoder=libspeex \
\
--enable-libtheora \
--enable-encoder=libtheora \
--enable-decoder=theora \
\
--enable-libvpx \
--enable-encoder=libvpx \
--enable-decoder=libvpx \
\
--enable-libvorbis \
--enable-encoder=libvorbis \
--enable-decoder=libvorbis \
\
--enable-encoder=flac \
--enable-decoder=flac \
\
--enable-encoder=zmbv \
--enable-decoder=zmbv \
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
--extra-cflags="-I../speex/include/ " \
--extra-ldflags="-L../speex/libspeex/.libs/" \
\
--prefix=/tmp/.pluggedin \
\
|| die "Failed to configure"

popd; 
popd

exit 0;


# Old mac flags:

\
--disable-stripping \
--enable-debug=3 \
\
--enable-runtime-cpudetect \
--enable-pic \
--enable-shared \
--enable-small \
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
--enable-zlib \
--enable-libspeex \
\
--enable-ffmpeg \
--disable-ffplay \
--disable-ffprobe \
--disable-ffserver \
--disable-avdevice \
--disable-devices \
\
--extra-cflags="-I../speex/include/ " \
--extra-ldflags="-L../speex/libspeex/.libs/" \
\
--prefix=/tmp/.pluggedin \


popd; 
popd



