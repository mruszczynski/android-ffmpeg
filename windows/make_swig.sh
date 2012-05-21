#!/bin/bash
DIR=`dirname $0`
pushd $DIR
. settings.sh
pushd ../ffmpeg-swig
make -f Makefile.win -j4
popd; 
find ../ffmpeg-swig -name '*.so.*' -exec cp \{\} ./ \;
popd

