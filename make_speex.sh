#!/bin/bash
pushd `dirname $0`
. settings.sh
pushd speex
make clean
make -j4
popd;popd
