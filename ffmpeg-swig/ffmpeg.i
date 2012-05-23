%module ffmpeg

#define MKBETAG(a,b,c,d) makeCodecTag(a,b,c,d)
#define FF_API_OLD_ENCODE_VIDEO 1

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
#include "../ffmpeg/libavformat/avio.h"

#undef  malloc
#define malloc av_malloc
#undef  free
#define free av_free

%}

%clear unsigned char *;

%apply unsigned long { void * }
%apply int8_t * { unsigned char *, uint8_t * }
%apply int8_t { unsigned char, uint8_t }

%array_class(int,intArray);
%array_class(double,doubleArray);

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
    fflush(stdout);
}
%}

%inline %{

typedef struct DecodeResult {
    int returnCode;
    int gotPicture;
} DecodeResult;

static DecodeResult* decodeVideo(AVCodecContext *avctx, AVFrame *picture, AVPacket *avpkt)
{
    DecodeResult *result = av_malloc(sizeof(DecodeResult));
    result->gotPicture = 0;
    result->returnCode = avcodec_decode_video2(avctx, picture, &(result->gotPicture), avpkt);
    return result;
}

static AVStream* getAVStream(AVStream** array, int pos)
{
    return array[pos];
}

static AVPacket* newPacket()
{
    AVPacket *packet = av_malloc(sizeof(AVPacket));
    av_init_packet(packet);
    return packet;
}

static AVFormatContext* init_input_formatcontext(const char *filename, const char *format_name)
{
    AVFormatContext *ctx = avformat_alloc_context();
    int result =  avformat_open_input(&ctx, filename, format_name, NULL);
    if(0 > result)
    {
        //av_log(ctx, AV_LOG_ERROR, "Error opening input: %s (%s)\n", filename, result);
        return NULL;
    }
    return ctx;
}

static int write_video_frame(AVFormatContext *oc, AVStream *st, unsigned char* data, int size)
{
    AVCodecContext *c = st->codec;
    AVPacket pkt;
    av_init_packet(&pkt);
    if (c->coded_frame->pts != AV_NOPTS_VALUE) pkt.pts = av_rescale_q(c->coded_frame->pts, c->time_base, st->time_base);
    if (c->coded_frame->key_frame) pkt.flags |= AV_PKT_FLAG_KEY;
    pkt.stream_index = st->index;
    pkt.data = data;
    pkt.size = size;
    return av_interleaved_write_frame(oc, &pkt);
}

static AVFormatContext* init_output_context(const char *format_name, const char *filename) {
    AVFormatContext *ctx = 0;
    int result = avformat_alloc_output_context2(&ctx, NULL, format_name, filename);
    if(0 > result)
    {
        return NULL;
    }
    else
    {
        return ctx;
    }
}

static int init_avformatcontext_pb(AVFormatContext*s, const char *url, int flags)
{
    return avio_open(&(s->pb), url, flags);
}

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
%include "../ffmpeg/libavformat/avio.h"
