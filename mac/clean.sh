#!/bin/bash
pushd `dirname $0`
. settings.sh

find .. -name '*.o' -delete
find .. -name '*.dylib' -delete

pushd ../speex
make distclean
make clean
popd

pushd ../opencore
make distclean
make clean
popd

pushd ../faac-1.28
make distclean
make clean
popd

pushd ../libaacplus-2.0.2
make distclean
make clean
popd

pushd ../x264
make distclean
make clean
popd

pushd ../ffmpeg
make distclean
make clean
popd

popd



