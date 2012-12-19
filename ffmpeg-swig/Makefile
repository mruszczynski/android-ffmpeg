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

# ffmpeg stuff
ffmpeg_objects = target/ffmpeg_wrap.o

# plggdn-dsp base
plggdn_dsp_base = target/plggdn_fft.o target/plggdn_aec.o 
plggdn_dsp_base_JNI = target/com_pluggedin_dsp_FFTJNI.o target/com_pluggedin_dsp_AECJNI.o target/com_pluggedin_dsp_ComplexJNI.o	

# plggdn-dsp FFTW and SPEEX implementation
plggdn_dsp_3rd_party = target/plggdn_fft_FFTW.o target/plggdn_aec_speex.o

plggdn_dsp_objects = $(plggdn_dsp_base) $(plggdn_dsp_base_JNI) $(plggdn_dsp_3rd_party)

objects = target/test.o $(ffmpeg_objects) $(plggdn_dsp_objects)

$(objects): target/%.o: src/main/c/%.c
	mkdir -p target
	gcc -fPIC -std=c99 \
		-I$(JAVA_HOME)/include/ \
		-I$(JAVA_HOME)/include/linux/ \
		-I../ffmpeg \
		-I../speex/include \
		-I../fftw/include \
		-I/usr/include/ \
		-c $< \
		-g \
		-o $@

target/libffmpegjni.so.1: $(objects)
	gcc -shared -Wl,-soname,libffmpegjni.so.1 \
		-L../fftw/.libs \
		-lfftw3 \
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


