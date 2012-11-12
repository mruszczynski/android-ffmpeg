LOCAL_PATH := $(call my-dir)

include $(CLEAR_VARS) 
LOCAL_MODULE := libavutil
LOCAL_SRC_FILES := ffmpeg/libavutil/libavutil.so
include $(PREBUILT_SHARED_LIBRARY)

include $(CLEAR_VARS) 
LOCAL_MODULE := libavcodec
LOCAL_SRC_FILES := ffmpeg/libavcodec/libavcodec.so
include $(PREBUILT_SHARED_LIBRARY)

include $(CLEAR_VARS) 
LOCAL_MODULE := libavformat
LOCAL_SRC_FILES := ffmpeg/libavformat/libavformat.so
include $(PREBUILT_SHARED_LIBRARY)

include $(CLEAR_VARS) 
LOCAL_MODULE := libswscale
LOCAL_SRC_FILES := ffmpeg/libswscale/libswscale.so
include $(PREBUILT_SHARED_LIBRARY)

include $(CLEAR_VARS) 
LOCAL_MODULE := libswresample
LOCAL_SRC_FILES := ffmpeg/libswresample/libswresample.so
include $(PREBUILT_SHARED_LIBRARY)

include $(CLEAR_VARS) 
LOCAL_MODULE := libavfilter
LOCAL_SRC_FILES := ffmpeg/libavfilter/libavfilter.so
include $(PREBUILT_SHARED_LIBRARY)


