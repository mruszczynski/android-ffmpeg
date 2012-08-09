#!/bin/bash
DIR=`dirname $0`
pushd $DIR
. settings.sh

pushd ../ffmpeg
make -j8 || die "Failed to make ffmpeg"
popd; 

ln -s ../ffmpeg/libavutil/libavutil.so.51 ;
ln -s ../ffmpeg/libavcodec/libavcodec.so.54 ;
ln -s ../ffmpeg/libavfilter/libavfilter.so.3 ;
ln -s ../ffmpeg/libavformat/libavformat.so.54 ;
#ln -s ../ffmpeg/libavresample/libavresample.so.0 ;
ln -s ../ffmpeg/libswresample/libswresample.so.0 ;
ln -s ../ffmpeg/libswscale/libswscale.so.2 ;

popd

