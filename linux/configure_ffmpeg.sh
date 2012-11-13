#!/bin/bash
DIR=`dirname $0`
pushd $DIR
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
--extra-cflags="-O0 -I../speex/include/ -I../libvpx -I../theora/include/ -I../vorbis/include/ -I../ogg/include/" \
--extra-ldflags="-L../speex/libspeex/.libs/ -L../libvpx -L../theora/lib/.libs/ -L../vorbis/lib/.libs/ -L../ogg/src/.libs/" \
|| die "Failed to configure"

popd; 
popd

exit 0;

\
--disable-everything \



\
--enable-encoder=pcm_s16be \
--enable-decoder=pcm_s16be \
--enable-encoder=pcm_s16le \
--enable-decoder=pcm_s16le \

--enable-decoder=libopus \
--enable-libopus \

\
--disable-stripping \
--enable-debug=3 \
--disable-optimizations \

