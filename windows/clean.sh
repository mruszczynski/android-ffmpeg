#!/bin/bash
pushd `dirname $0`
. settings.sh

find .. -name '*.o' -delete
find .. -name '*.so' -delete
find .. -name '*.so.*' -delete
find .. -name '*.a' -delete
find .. -name '*.dll' -delete

pushd ../speex
make distclean
make clean
popd

pushd ../ffmpeg
make distclean
make clean
popd

popd



