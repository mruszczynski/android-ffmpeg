all: target/libffmpegjni.so
clean:
	rm -rf target/

src/main/c/ffmpeg_wrap.c: ffmpeg.i
	mkdir -p src/main/java/com/pluggedin/ffmpeg
	mkdir -p src/main/c
	swig -java -package com.pluggedin.ffmpeg -outdir src/main/java/com/pluggedin/ffmpeg -o src/main/c/ffmpeg_wrap.c ffmpeg.i
	sed 's/int\.swigToEnum//g' -i src/main/java/com/pluggedin/ffmpeg/*.java
	sed 's/(makeCodecTag(/(CodecUtil.makeCodecTag(/g' -i src/main/java/com/pluggedin/ffmpeg/CodecID.java
	sed 's/strncpy/av_strlcpy/g' -i src/main/c/ffmpeg_wrap.c
	sed -i "/ReleaseStringUTFChars/ s/^/\/\//g" src/main/c/ffmpeg_wrap.c

ffmpeg_objects = target/ffmpeg_wrap.o
speex_objects = target/plggdn_aec.o target/com_pluggedin_dsp_AECJNI.o target/plggdn_aec_speex.o
#fftw_objects = target/com_pluggedin_dsp_FFTJNI.o target/plggdn_fft_FFTW.o target/plggdn_fft.o target/com_pluggedin_dsp_ComplexJNI.o
objects = target/test.o $(ffmpeg_objects) $(speex_objects) $(fftw_objects)

$(objects): target/%.o: src/main/c/%.c
	mkdir -p target
	gcc -fPIC -std=c99 \
		-I$(JAVA_HOME)/include/ \
		-I$(JAVA_HOME)/include/linux/ \
		-I../ffmpeg \
		-I../speex/include \
		-I/usr/include/ \
		-c $< \
		-g \
		-o $@

target/libffmpegjni.so.1: $(objects)
	gcc -shared -Wl,-soname,libffmpegjni.so.1 \
		-L../speex/libspeex/.libs/ \
		-lspeex \
		-lspeexdsp \
		-L../ffmpeg/libavfilter \
		-lavfilter \
		-L../ffmpeg/libavformat \
		-lavformat \
		-L../ffmpeg/libavutil \
		-lavutil \
		-L../ffmpeg/libavcodec \
		-lavcodec \
		-L../ffmpeg/libswscale \
		-lswscale \
		-o target/libffmpegjni.so.1 \
		$(objects)

target/libffmpegjni.so: target/libffmpegjni.so.1
	ln -s libffmpegjni.so.1 target/libffmpegjni.so


