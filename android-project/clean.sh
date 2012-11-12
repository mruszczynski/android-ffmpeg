#!/bin/bash
DIR=`dirname $0`
pushd $DIR
. settings.sh

rm -rf obj

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



