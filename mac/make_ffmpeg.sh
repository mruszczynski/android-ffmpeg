#!/bin/bash
DIR=`dirname $0`
pushd $DIR
. settings.sh
pushd ../ffmpeg
make -j4
popd; 
find ../ffmpeg -name '*.dylib' -exec ln -s \{\} ./ \;
ln -s ../ffmpeg/ffmpeg
popd

