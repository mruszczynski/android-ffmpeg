#!/bin/bash

function die {
  echo "$1 failed" && exit 1
}

pushd `dirname $0`
. settings.sh
pushd ../ffmpeg
make -j4 || die 'make'
popd; 
popd
