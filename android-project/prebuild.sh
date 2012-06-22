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

popd


