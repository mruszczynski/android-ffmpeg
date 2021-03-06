#!/bin/bash
DIR=`dirname $0`
pushd $DIR
. settings.sh

pushd ../ffmpeg
make clean || die "make clean (ffmpeg)"
make -j8 || die "make (ffmpeg)"
popd;

ln -s ../ffmpeg/libavutil/avutil-51.dll
ln -s ../ffmpeg/libavcodec/avcodec-54.dll
ln -s ../ffmpeg/libavfilter/avfilter-2.dll
ln -s ../ffmpeg/libavformat/avformat-54.dll
#ln -s ../ffmpeg/libavresample/avresample-0.dll
ln -s ../ffmpeg/libswresample/swresample-0.dll
ln -s ../ffmpeg/libswscale/swscale-2.dll
#ln -s ../ffmpeg/libpostproc/postproc-52.dll
#ln -s ../ffmpeg/ffmpeg.exe
popd

