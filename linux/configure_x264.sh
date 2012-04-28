#!/bin/bash
pushd `dirname $0`
. settings.sh

pushd ../x264

./configure \
--enable-pic \
--enable-static \
--disable-cli

popd;popd
