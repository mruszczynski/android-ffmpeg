#!/bin/bash
DIR=`dirname $0`
pushd $DIR
. settings.sh
pushd ../x264
make -j4
popd;
#find ../x264 -name '*.so' -exec cp \{\} ./ \;
find ../x264 -name '*.so.*' -exec ln -s \{\} \;
popd;

