%javaconst(1);
%include "enums.swg"
%include "typemaps.i"
%include "stdint.i"

%module ffmpeg
%{
#include "../ffmpeg/libavutil/attributes.h"
#include "../ffmpeg/libavutil/common.h"
#include "../ffmpeg/libavutil/avutil.h"
#include "../ffmpeg/libswscale/swscale.h"
#include "../ffmpeg/libavcodec/avcodec.h"
#include "../ffmpeg/libavfilter/avfilter.h"
#include "../ffmpeg/libavformat/avformat.h"
#include "../ffmpeg/libswresample/swresample.h"
%}

%ignore AVBitStreamFilter::filter;
%ignore AVFrame::motion_val;

%include "../ffmpeg/libavutil/attributes.h";
%include "../ffmpeg/libavutil/common.h"

%include "../ffmpeg/libavutil/avutil.h";
%include "../ffmpeg/libswscale/swscale.h";
%include "../ffmpeg/libavcodec/avcodec.h";
%include "../ffmpeg/libavfilter/avfilter.h";
%include "../ffmpeg/libavformat/avformat.h";
%include "../ffmpeg/libswresample/swresample.h";


