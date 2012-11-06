LOCAL_PATH := $(call my-dir)
include $(CLEAR_VARS)
LOCAL_MODULE    := ffmpeg_swig

LOCAL_SRC_FILES := ffmpeg_wrap.c
LOCAL_C_INCLUDES := $(LOCAL_PATH)/../ffmpeg/ffmpeg
LOCAL_SHARED_LIBRARIES := libavutil libavcodec libavformat libswresample libswscale libpostproc libavresample
# libavfilter 
LOCAL_STRIP_MODULE := false

include $(BUILD_SHARED_LIBRARY)


