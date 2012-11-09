LOCAL_PATH := $(call my-dir)

include $(CLEAR_VARS) 
LOCAL_MODULE := libavutil_a
LOCAL_SRC_FILES := ffmpeg/libavutil/libavutil.a
include $(PREBUILT_STATIC_LIBRARY)

include $(CLEAR_VARS) 
LOCAL_MODULE := libavcodec_a
LOCAL_SRC_FILES := ffmpeg/libavcodec/libavcodec.a
include $(PREBUILT_STATIC_LIBRARY)

include $(CLEAR_VARS) 
LOCAL_MODULE := libavformat_a
LOCAL_SRC_FILES := ffmpeg/libavformat/libavformat.a
include $(PREBUILT_STATIC_LIBRARY)

include $(CLEAR_VARS) 
LOCAL_MODULE := libswscale_a
LOCAL_SRC_FILES := ffmpeg/libswscale/libswscale.a
include $(PREBUILT_STATIC_LIBRARY)

include $(CLEAR_VARS) 
LOCAL_MODULE := libswresample_a
LOCAL_SRC_FILES := ffmpeg/libswresample/libswresample.a
include $(PREBUILT_STATIC_LIBRARY)

include $(CLEAR_VARS) 
LOCAL_MODULE := libavfilter_a
LOCAL_SRC_FILES := ffmpeg/libavfilter/libavfilter.a
include $(PREBUILT_STATIC_LIBRARY)




include $(CLEAR_VARS) 
LOCAL_MODULE := libavutil
LOCAL_STATIC_LIBRARIES := libavutil_a
include $(BUILD_SHARED_LIBRARY)

include $(CLEAR_VARS) 
LOCAL_MODULE := libavcodec
LOCAL_STATIC_LIBRARIES := libavcodec_a
LOCAL_SHARED_LIBRARIES := libavutil speex
include $(BUILD_SHARED_LIBRARY)

include $(CLEAR_VARS) 
LOCAL_MODULE := libavformat
LOCAL_STATIC_LIBRARIES := libavformat_a
LOCAL_SHARED_LIBRARIES := libavutil libavcodec
include $(BUILD_SHARED_LIBRARY)

include $(CLEAR_VARS) 
LOCAL_MODULE := libswscale
LOCAL_STATIC_LIBRARIES := libswscale_a
LOCAL_SHARED_LIBRARIES := libavutil
include $(BUILD_SHARED_LIBRARY)

include $(CLEAR_VARS) 
LOCAL_MODULE := libswresample
LOCAL_STATIC_LIBRARIES := libswresample_a
LOCAL_SHARED_LIBRARIES := libavutil
include $(BUILD_SHARED_LIBRARY)

include $(CLEAR_VARS) 
LOCAL_MODULE := libavfilter
LOCAL_STATIC_LIBRARIES := libavfilter_a
LOCAL_SHARED_LIBRARIES := libavutil speex libswscale libswresample libavformat libavcodec
include $(BUILD_SHARED_LIBRARY)

