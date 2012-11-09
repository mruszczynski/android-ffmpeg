#!/bin/bash
DIR=`dirname $0`
pushd $DIR
. settings.sh

pushd ../ffmpeg

./configure \
\
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
--disable-stripping \
--enable-debug=3 \
--disable-optimizations \
\
--disable-everything \
\
--enable-swresample \
--enable-postproc \
\
--enable-filter=aresample \
\
--enable-libspeex \
--enable-encoder=libspeex \
--enable-decoder=libspeex \
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
--enable-zlib \
\
--extra-cflags="-I../speex/include/ -I/home/shared/android-ndk-r8b/platforms/android-8/arch-arm/usr/include/" \
--extra-ldflags="-L../android-project/obj/local/armeabi/" \
\
--disable-avdevice \
--disable-devices \
\
|| die "Failed to configure"

find -name 'Makefile' -exec sed -i 's|include $(SUBDIR)../config.mak||g' \{\} \;

popd

cp ../ffmpeg/config.h ./config.h.original
patch ../ffmpeg/config.h ./config.h.diff

popd

exit 0;

--extra-cflags="-I../x264 -I../speex/include/" \
--extra-ldflags="-L../x264 -L../android-project/obj/local/armeabi/" \
--disable-avdevice \
--disable-devices





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
--extra-cflags="-O0 -I../speex/include/ -I../libvpx -I../theora/include/ -I../vorbis/include/ -I../ogg/include/" \
--extra-ldflags="-L../speex/libspeex/.libs/ -L../libvpx -L../theora/lib/.libs/ -L../vorbis/lib/.libs/ -L../ogg/src/.libs/" \

