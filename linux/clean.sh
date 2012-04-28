#!/bin/bash
pushd `dirname $0`
. settings.sh

find .. -name \*.o -delete
ndk-build clean

pushd ../speex
make clean
popd

pushd ../opencore
make clean
popd

pushd ../faac-1.28
make clean
popd

pushd ../libaacplus-2.0.2
make clean
popd


pushd ../x264
make clean
popd

pushd ../ffmpeg
make clean
popd





