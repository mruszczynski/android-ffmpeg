#!/bin/bash
DIR=`dirname $0`
pushd $DIR
. settings.sh

pushd ../speex
./autogen.sh || die "running speex/autogen.sh"
./configure || die "configuring speex"
make clean || die "cleaning speex"
make -j8 || die "making speex"
popd
#ln -s ../speex/libspeex/.libs/libspeexdsp.so.1 ;
ln -s ../speex/libspeex/.libs/libspeex.so.1 ;

pushd ../libvpx
./configure --disable-static --enable-shared --enable-pic --enable-debug --enable-unit-tests || die "configuring libvpx"
make clean || die "cleaning libvpx"
make -j8 || die "making libvpx"
popd
ln -s ../libvpx/libvpx.so.0 ;

pushd ../ogg
./autogen.sh || die "running ogg/autogen.sh"
mkdir build;pushd build/;export OGGDIR=`pwd`;popd
./configure --prefix=$OGGDIR || die "configuring libogg"
make clean || die "cleaning libogg"
make -j8 || die "making libogg"
make install || die "install libogg"
popd
ln -s ../ogg/build/lib/libogg.so.0

pushd ../vorbis
./autogen.sh --with-ogg=$OGGDIR || die "running vorbis/autogen.sh"
make clean || die "cleaning vorbis"
make -j8 || die "making vorbis"
popd
ln -s ../vorbis/lib/.libs/libvorbisenc.so.2 ;
ln -s ../vorbis/lib/.libs/libvorbis.so.0 ;

pushd ../opus
./autogen.sh || die "running opus/autogen.sh"
./configure || die "configuring opus"
make clean || die "cleaning opus"
make -j8 || die "making opus"
popd
#ln -s ../opus/.libs/libopus.so.0

pushd ../theora
./autogen.sh --with-ogg=$OGGDIR || die "running theora/autogen.sh"
make clean || die "cleaning theora"
make -j8 || die "making theora"
popd
ln -s ../theora/lib/.libs/libtheoraenc.so.1 ;
ln -s ../theora/lib/.libs/libtheoradec.so.1 ;
ln -s ../theora/lib/.libs/libtheora.so.0 ;

popd


