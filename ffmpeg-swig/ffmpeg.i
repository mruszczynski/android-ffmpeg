%module ffmpeg

#define MKBETAG(a,b,c,d) makeCodecTag(a,b,c,d)

%javaconst(1);
%include "enums.swg"
%include "typemaps.i"
//%include "stdint.i"
%include "carrays.i"
%include "various.i"

%array_class(unsigned char, char_array_1d);

%apply unsigned long { void * }

%clear char *;
%apply char * { unsigned char * }
%apply char * { uint8_t * }
%typemap(jni) char *, char *&, char[ANY], char[]               "jbyteArray"
%typemap(jtype) char *, char *&, char[ANY], char[]               "byte[]"
%typemap(jstype) char *, char *&, char[ANY], char[]               "byte[]"
%typemap(in)      (char *STRING, size_t LENGTH) {
    $1 = (char *) JCALL2(GetByteArrayElements, jenv, $input, 0);
    $2 = (size_t) JCALL1(GetArrayLength,       jenv, $input);
}
%typemap(in)      (char *STRING) {
    $1 = (char *) JCALL2(GetByteArrayElements, jenv, $input, 0);
}
%typemap(argout)  (char *STRING) {
    JCALL3(ReleaseByteArrayElements, jenv, $input, (jbyte *)$1, 0);
}
%typemap(out)  (char *STRING) {
    JCALL3(ReleaseByteArrayElements, jenv, $input, (jbyte *)$1, 0);
}


%{
#include "../ffmpeg/libavutil/opt.h"
#include "../ffmpeg/libavutil/mem.h"
#include "../ffmpeg/libavutil/attributes.h"
#include "../ffmpeg/libavutil/common.h"
#include "../ffmpeg/libavutil/pixfmt.h"
#include "../ffmpeg/libavutil/samplefmt.h"
#include "../ffmpeg/libavutil/avutil.h"
#include "../ffmpeg/libswscale/swscale.h"
#include "../ffmpeg/libavcodec/avcodec.h"
#include "../ffmpeg/libavfilter/avfilter.h"
#include "../ffmpeg/libavformat/avformat.h"
#include "../ffmpeg/libswresample/swresample.h"
%}

%ignore AVBitStreamFilter::filter;
%ignore AVFrame::motion_val;

%include "../ffmpeg/libavutil/opt.h"
%include "../ffmpeg/libavutil/mem.h"
%include "../ffmpeg/libavutil/attributes.h";
%include "../ffmpeg/libavutil/common.h"
%include "../ffmpeg/libavutil/pixfmt.h"
%include "../ffmpeg/libavutil/samplefmt.h"
%include "../ffmpeg/libavutil/avutil.h";
%include "../ffmpeg/libswscale/swscale.h";
%include "../ffmpeg/libavcodec/avcodec.h";
%include "../ffmpeg/libavfilter/avfilter.h";
%include "../ffmpeg/libavformat/avformat.h";
%include "../ffmpeg/libswresample/swresample.h";


/*

  
  public static int makeCodecTag(int a, char b, char c, char d)
  {
    assert(0==a);
    return makeCodecTag('0',b,c,d);
  }
  
  public static int makeCodecTag(char a, char b, char c, char d)
  {
    return ((d) | (((int)c) << 8) | (((int)b) << 16) | (((int)a) << 24));
  }

*/