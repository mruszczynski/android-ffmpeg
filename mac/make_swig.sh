#!/bin/bash
DIR=`dirname $0`
pushd $DIR
. settings.sh
pushd ../ffmpeg-swig
make -f Makefile.mac -j4
popd; 
find ../ffmpeg-swig -name '*.dylib' -exec ln -s \{\} \;
popd

