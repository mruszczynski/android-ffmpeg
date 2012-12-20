LOCAL_PATH := $(call my-dir)

include $(CLEAR_VARS)
LOCAL_MODULE    := ffmpeg_swig

LOCAL_SRC_FILES := src/ffmpeg_wrap.c \
  src/plggdn_aec.c \
  src/com_pluggedin_dsp_AECJNI.c \
  src/plggdn_aec_speex.c

#  src/com_pluggedin_dsp_FFTJNI.c \
#  src/plggdn_fft_FFTW.c \
#  src/plggdn_fft.c \
#  src/com_pluggedin_dsp_ComplexJNI.c \
#  src/test.c \

LOCAL_C_INCLUDES := $(LOCAL_PATH)/../ffmpeg/ffmpeg $(LOCAL_PATH)/../speex/speex/include
LOCAL_SHARED_LIBRARIES := speex libavutil libavcodec libavformat libswresample libswscale
LOCAL_STRIP_MODULE := false
include $(BUILD_SHARED_LIBRARY)


