%module ffmpeg

#define MKBETAG(a,b,c,d) makeCodecTag(a,b,c,d)

%javaconst(1);
%include "enums.swg"
%include "typemaps.i"
%include "stdint.i"
%include "carrays.i"
%include "various.i"

%{
#include "../ffmpeg/libavutil/opt.h"
#include "../ffmpeg/libavutil/mem.h"
#include "../ffmpeg/libavutil/attributes.h"
#include "../ffmpeg/libavutil/common.h"
#include "../ffmpeg/libavutil/samplefmt.h"
#include "../ffmpeg/libavutil/rational.h"
#include "../ffmpeg/libavutil/internal.h"
#include "../ffmpeg/libavutil/pixfmt.h"
#include "../ffmpeg/libavutil/avutil.h"
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

%inline %{

static unsigned char* getByte2d(unsigned char** self, int index) {
    return self[index];
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
%include "../ffmpeg/libswscale/swscale.h";
%include "../ffmpeg/libavcodec/avcodec.h";
%include "../ffmpeg/libavfilter/avfilter.h";
%include "../ffmpeg/libavformat/avformat.h";
%include "../ffmpeg/libswresample/swresample.h";
