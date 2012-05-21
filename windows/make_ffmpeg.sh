#!/bin/bash
DIR=`dirname $0`
pushd $DIR
. settings.sh
pushd ../ffmpeg
make -j4
popd; 
find ../ffmpeg -name '*.so.*' -exec cp \{\} ./ \;
cp -u ../ffmpeg/ffmpeg ./
popd

