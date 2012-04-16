#!/bin/bash
pushd `dirname $0`
. settings.sh
pushd android-project/
ndk-build
popd;popd

