#!/bin/bash
DIR=`dirname $0`
pushd $DIR
. settings.sh
pushd ../ffmpeg-swig
make -j4 || die "Error making swig"
mvn install || die "Error in mvn instal swig";
popd; 
find ../ffmpeg-swig -name '*.so.*' -exec ln -s \{\} \;
popd

