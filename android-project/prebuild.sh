#!/bin/bash
pushd `dirname $0`
. settings.sh

function die {
  echo "$1 failed" && exit 1
}

pushd ../speex

./autogen.sh || die "Error running speex/autogen.sh"
./configure || die "Error configuring speex"
make clean || die "Error making speex"
make || die "Error making speex"

popd

pushd ../libaacplus-2.0.2

./autogen.sh || die "running libaacplus/autogen.sh"
./configure || die "configuring libaacplus"
make || die "Error making libaacplus"

popd

popd


