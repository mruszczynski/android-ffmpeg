%module ffmpeg

#define MKBETAG(a,b,c,d) makeCodecTag(a,b,c,d)

%javaconst(1);
%include "enums.swg"
%include "typemaps.i"
%include "stdint.i"
%include "carrays.i"
%include "various.i"

%{
#include <jni.h>
#include "../ffmpeg/libavutil/opt.h"
#include "../ffmpeg/libavutil/mem.h"
#include "../ffmpeg/libavutil/attributes.h"
#include "../ffmpeg/libavutil/common.h"
#include "../ffmpeg/libavutil/samplefmt.h"
#include "../ffmpeg/libavutil/rational.h"
#include "../ffmpeg/libavutil/internal.h"
#include "../ffmpeg/libavutil/pixfmt.h"
#include "../ffmpeg/libavutil/avutil.h"
#include "../ffmpeg/libavutil/log.h"
#include "../ffmpeg/libswscale/swscale.h"
#include "../ffmpeg/libavcodec/avcodec.h"
#include "../ffmpeg/libavfilter/avfilter.h"
#include "../ffmpeg/libavformat/avformat.h"
#include "../ffmpeg/libswresample/swresample.h"
%}

%clear unsigned char *;

%apply unsigned long { void * }
%apply int8_t * { unsigned char *, uint8_t * }
%apply int8_t { unsigned char, uint8_t }

%array_class(int,intArray);

%{
SWIGEXPORT void JNICALL Java_com_pluggedin_ffmpeg_ffmpegJNI_copyBytesIn(JNIEnv *jenv, jclass jcls, jlong ptr, jbyteArray array, jint length, jint offset) {
    (*jenv)->SetByteArrayRegion(jenv, array, offset, length, *(unsigned char **)&ptr);
}
SWIGEXPORT void JNICALL Java_com_pluggedin_ffmpeg_ffmpegJNI_copyBytesOut(JNIEnv *jenv, jclass jcls, jlong ptr, jbyteArray array, jint length, jint offset) {
    (*jenv)->GetByteArrayRegion(jenv, array, offset, length, *(unsigned char **)&ptr);
}
void log_callback_stdout(void* ptr, int level, const char* fmt, va_list vl)
{
    vfprintf(stdout, fmt, vl);
}
%}

%inline %{

static void init_log() {
    av_log_set_callback(log_callback_stdout);
}

static AVRational* newAVRational(int numerator, int denominator) {
    AVRational *rational = av_malloc(sizeof(AVRational));
    rational->num = numerator;
    rational->den = denominator;
    return rational;
}

static void copyBytesIn(unsigned char* self, jbyteArray array, int length, int offset) {
    // The signature forces the java classes to generate the proper wrappers to call the above jni method
    // TODO: Figure out how to make this elegant and not require manual editing
}


static void copyBytesOut(unsigned char* self, jbyteArray array, int length, int offset) {
    // The signature forces the java classes to generate the proper wrappers to call the above jni method
    // TODO: Figure out how to make this elegant and not require manual editing
}

static unsigned char* getByte2d(unsigned char** self, int index) {
    return self[index];
}
static unsigned char* getByteOffset(unsigned char* self, int index) {
    return self + index;
}
static void setByte2d(unsigned char** self, int index, unsigned char* item) {
     self[index] = item;
}
static unsigned char** newByteArray2d(int size) {
    return av_malloc(size * sizeof(int8_t*));
}
static void delByteArray2d(unsigned char** self) {
    av_free(self);
}


static unsigned char getByte(unsigned char* self, int index) {
    return self[index];
}
static void setByte(unsigned char* self, int index, unsigned char item) {
     self[index] = item;
}
static unsigned char* newByteArray(int size) {
    return av_malloc(size * sizeof(char));
}
static void delByteArray(unsigned char* self) {
    av_free(self);
}


%}

%ignore av_vlog;
%ignore av_log_default_callback;
%ignore av_log_format_line;

%ignore AVBitStreamFilter::filter;
%ignore AVFrame::motion_val;
%ignore please_use_av_free;

%include "../ffmpeg/libavutil/opt.h"
%include "../ffmpeg/libavutil/mem.h"
%include "../ffmpeg/libavutil/attributes.h";
%include "../ffmpeg/libavutil/samplefmt.h"
%include "../ffmpeg/libavutil/common.h"
%include "../ffmpeg/libavutil/rational.h"
%include "../ffmpeg/libavutil/internal.h"
%include "../ffmpeg/libavutil/pixfmt.h"
%include "../ffmpeg/libavutil/avutil.h";
%include "../ffmpeg/libavutil/log.h"
%include "../ffmpeg/libswscale/swscale.h";
%include "../ffmpeg/libavcodec/avcodec.h";
%include "../ffmpeg/libavfilter/avfilter.h";
%include "../ffmpeg/libavformat/avformat.h";
%include "../ffmpeg/libswresample/swresample.h";
