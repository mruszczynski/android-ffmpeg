all: target/ffmpeg_wrap.so
clean:
	rm -rf src/ target/

src/main/c/ffmpeg_wrap.c: ffmpeg.i
	mkdir -p src/main/java/com/pluggedin/ffmpeg
	mkdir -p src/main/c
	swig -java -package com.pluggedin.ffmpeg -outdir src/main/java/com/pluggedin/ffmpeg -o src/main/c/ffmpeg_wrap.c ffmpeg.i
	sed 's/int\.swigToEnum//g' -i src/main/java/com/pluggedin/ffmpeg/*.java

target/ffmpeg_wrap.so: src/main/c/ffmpeg_wrap.c
	mkdir -p target
	gcc -fPIC \
		-I/usr/lib/jvm/java-6-openjdk/include/ \
		-I../ffmpeg \
		-I/usr/include/ \
		-c src/main/c/ffmpeg_wrap.c \
		-o target/ffmpeg_wrap.o
	gcc -shared -Wl,-soname,ffmpegjni.so.1 \
		-o target/ffmpegjni.so.1.0 \
		target/ffmpeg_wrap.o

