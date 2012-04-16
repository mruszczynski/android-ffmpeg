#!/bin/bash
pushd `dirname $0`
. settings.sh

function die {
  echo "$1 failed" && exit 1
}

pushd speex

./autogen.sh || die "Error running speex/autogen.sh"
./configure

popd;popd
