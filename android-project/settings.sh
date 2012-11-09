#!/bin/bash

if [[ "x$NDK_BASE" == "x" ]]; then
    echo "No NDK_BASE set"
    exit 1
fi

export NDK_PLATFORM_VERSION=8
export NDK_SYSROOT=$NDK_BASE/platforms/android-$NDK_PLATFORM_VERSION/arch-arm
export NDK_UNAME=`uname -s | tr '[A-Z]' '[a-z]'`
export NDK_TOOLCHAIN_BASE=$NDK_BASE/toolchains/arm-linux-androideabi-4.4.3/prebuilt/$NDK_UNAME-x86
export CC="$NDK_TOOLCHAIN_BASE/bin/arm-linux-androideabi-gcc --sysroot=$NDK_SYSROOT"
export LD=$NDK_TOOLCHAIN_BASE/bin/arm-linux-androideabi-ld

if [[ ! -d $NDK_SYSROOT ]]; then
    echo "NDK Platform Directory not found: $NDK_SYSROOT"
    exit 1
fi

if [[ ! -d "$NDK_TOOLCHAIN_BASE/bin" ]]; then
    echo "NDK Tools Directory not found: $NDK_TOOLCHAIN_BASE/bin"
    exit 1
fi

# i use only a small number of formats - set this to 0 if you want everything.
# changed 0 to the default, so it'll compile shitloads of codecs normally
if [[ "x$minimal_featureset" == "x" ]]; then
minimal_featureset=1
fi

function current_dir {
  echo "$(cd "$(dirname $0)"; pwd)"
}

function die {
  echo "$1 failed" && exit 1
}

