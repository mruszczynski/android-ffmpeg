#!/bin/bash
pushd `dirname $0`
. settings.sh

pushd ../ffmpeg
FFMPEG_PATH=`pwd`
popd

pushd jni
if [[ ! -e Application.mk.$1 ]]; then
    echo "Application.mk.$1 not found"
    exit 1
fi
if [[ ! -e Android.mk.$1 ]]; then
    echo "Android.mk.$1 not found"
    exit 1
fi
rm Application.mk
rm Android.mk
ln -s Application.mk.$1 Application.mk
ln -s Android.mk.$1 Android.mk
popd

ndk-build -j8 || die 'ndk-build'
popd

