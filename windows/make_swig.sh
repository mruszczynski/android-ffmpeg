#!/bin/bash
DIR=`dirname $0`
pushd $DIR
. settings.sh
pushd ../ffmpeg-swig
make -f Makefile.win -j4 || die "Failed to make swig"
popd; 
find ../ffmpeg-swig -name '*.dll' -exec cp \{\} ./ \;
popd

