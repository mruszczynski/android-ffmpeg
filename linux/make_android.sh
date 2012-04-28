#!/bin/bash
pushd `dirname $0`
. settings.sh
ndk-build
popd

