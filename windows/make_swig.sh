#!/bin/bash
DIR=`dirname $0`
pushd $DIR
. settings.sh

pushd ../ffmpeg-swig
make -f Makefile.win -j4 || die "make swig"
mvn install || die "Error in mvn instal swig";
popd; 

find ../ffmpeg-swig -name '*.dll' -exec ln -s \{\} ./ \;

popd

