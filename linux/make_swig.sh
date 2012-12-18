#!/bin/bash
DIR=`dirname $0`
pushd $DIR
. settings.sh

pushd ../ffmpeg-swig
make -j4 || die "make swig"
#mvn install || die "mvn instal swig";
popd; 

find ../ffmpeg-swig -name '*.so.*' -exec ln -s \{\} \;

popd

