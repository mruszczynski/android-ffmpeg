#!/bin/bash
pushd `dirname $0`
. settings.sh

pushd ../x264

./configure \
--enable-pic \
--enable-shared \
--disable-cli

#--enable-static \

popd;popd
