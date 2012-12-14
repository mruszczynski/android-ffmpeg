#!/bin/bash
DIR=`dirname $0`
pushd $DIR
. settings.sh

pushd ../ffmpeg
make -j4 || die "make"
popd; 

find ../ffmpeg -name '*.dylib' -exec ln -s \{\} ./ \;

popd

