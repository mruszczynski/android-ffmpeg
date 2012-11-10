#!/bin/bash
pushd `dirname $0`
. settings.sh

pushd ../ffmpeg

#make distclean || die "make distclean (ffmpeg)"

# Causes build to fail... we must need to enable some stuff:
#--disable-everything \

./configure \
\
\
--enable-memalign-hack --arch=x86 --target-os=mingw32 --cross-prefix=i686-mingw32- \
\
--enable-runtime-cpudetect \
--enable-pic \
--enable-shared \
--enable-static \
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
--extra-cflags="-O0 -I../speex/include/" \
--extra-ldflags="-L../speex/libspeex/.libs/" \
|| die "Failed to configure"

popd;

cp ../ffmpeg/config.h config.h.orig
patch ../ffmpeg/config.h config.h.patch

popd

exit 0;




# This stuff doesn't build for windows yet:
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
--extra-cflags="-O0 -I../speex/include/ -I../libvpx -I../theora/include/ -I../vorbis/include/ -I../ogg/include/" \
--extra-ldflags="-L../speex/libspeex/.libs/ -L../libvpx -L../theora/lib/.libs/ -L../vorbis/lib/.libs/ -L../ogg/src/.libs/" \


# Old windows build params:
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


