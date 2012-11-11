#!/bin/bash
pushd `dirname $0`
. settings.sh

find .. -name '*.o' -delete
find .. -name '*.dylib' -delete

pushd ../speex
make distclean
make clean
popd

pushd ../libvpx
make distclean
make clean
popd

pushd ../opus
make distclean
make clean
popd

pushd ../theora
make distclean
make clean
popd

pushd ../vorbis
make distclean
make clean
popd

pushd ../ffmpeg
make distclean
make clean
popd

popd



