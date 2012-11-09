#!/bin/bash
pushd `dirname $0`
DIR=`pwd`
. settings.sh

pushd ../ffmpeg
make -j8
popd; 

popd
