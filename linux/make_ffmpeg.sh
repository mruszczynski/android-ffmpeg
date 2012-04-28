#!/bin/bash
pushd `dirname $0`
. settings.sh
pushd ../ffmpeg
make -j4
popd; 
cp -u ../ffmpeg/ffmpeg ./
popd
