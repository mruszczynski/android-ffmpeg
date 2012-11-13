#!/bin/bash
DIR=`dirname $0`
pushd $DIR
. settings.sh

pushd ../ffmpeg
make -j8 || die "Failed to make ffmpeg"
popd; 

function makelink {
  FILE=../ffmpeg/$1
  if [ ! -e $FILE ]; then die "ln $1"; fi
  ln -s $FILE || die "ln $1"
}

makelink libavutil/libavutil.so.51 ;
makelink libavcodec/libavcodec.so.54 ;
makelink libavfilter/libavfilter.so.2 ;
makelink libavformat/libavformat.so.54 ;
#makelink libavresample/libavresample.so.0 ;
makelink libswresample/libswresample.so.0 ;
makelink libswscale/libswscale.so.2 ;

popd

