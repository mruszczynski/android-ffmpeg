all: target/libffmpegjni.so
clean:
	rm -rf target/

src/main/c/ffmpeg_wrap.c: ffmpeg.i
	mkdir -p src/main/java/com/pluggedin/ffmpeg
	mkdir -p src/main/c
	swig -java -package com.pluggedin.ffmpeg -outdir src/main/java/com/pluggedin/ffmpeg -o src/main/c/ffmpeg_wrap.c ffmpeg.i
	sed 's/int\.swigToEnum//g' -i src/main/java/com/pluggedin/ffmpeg/*.java
	sed 's/(makeCodecTag(/(CodecUtil.makeCodecTag(/g' -i src/main/java/com/pluggedin/ffmpeg/CodecID.java

target/ffmpeg_wrap.o: src/main/c/ffmpeg_wrap.c
	mkdir -p target
	gcc -fPIC \
		-I/usr/lib/jvm/java-6-openjdk/include/ \
		-I../ffmpeg \
		-I/usr/include/ \
		-c src/main/c/ffmpeg_wrap.c \
		-g \
		-o target/ffmpeg_wrap.o

target/libffmpegjni.so.1: target/ffmpeg_wrap.o
	gcc -shared -Wl,-soname,libffmpegjni.so.1 \
		-L../linux \
		-lavfilter \
		-lavformat \
		-lavutil \
		-lavcodec \
		-lswscale \
		-o target/libffmpegjni.so.1 \
		target/ffmpeg_wrap.o

target/libffmpegjni.so: target/libffmpegjni.so.1
	ln -s libffmpegjni.so.1 target/libffmpegjni.so


