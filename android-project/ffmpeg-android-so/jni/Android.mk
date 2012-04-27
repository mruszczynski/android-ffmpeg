MY_PATH := $(call my-dir)
LOCAL_PATH := $(MY_PATH)/../../obj/local/armeabi/

include $(CLEAR_VARS)
LOCAL_MODULE    := libspeex
LOCAL_SRC_FILES := libspeex.a
include $(PREBUILT_STATIC_LIBRARY)

LOCAL_PATH := $(MY_PATH)/../../../ffmpeg/

include $(CLEAR_VARS)
LOCAL_MODULE    := libavutil
LOCAL_SRC_FILES := libavutil/libavutil.a
include $(PREBUILT_STATIC_LIBRARY)

include $(CLEAR_VARS)
LOCAL_MODULE    := libpostproc
LOCAL_SRC_FILES := libpostproc/libpostproc.a
include $(PREBUILT_STATIC_LIBRARY)

include $(CLEAR_VARS)
LOCAL_MODULE    := libswscale
LOCAL_SRC_FILES := libswscale/libswscale.a
include $(PREBUILT_STATIC_LIBRARY)

include $(CLEAR_VARS)
LOCAL_MODULE    := libavcodec
LOCAL_SRC_FILES := libavcodec/libavcodec.a
include $(PREBUILT_STATIC_LIBRARY)

include $(CLEAR_VARS)
LOCAL_MODULE    := libavfilter
LOCAL_SRC_FILES := libavfilter/libavfilter.a
include $(PREBUILT_STATIC_LIBRARY)

include $(CLEAR_VARS)
LOCAL_MODULE    := libavformat
LOCAL_SRC_FILES := libavformat/libavformat.a
include $(PREBUILT_STATIC_LIBRARY)

include $(CLEAR_VARS)
LOCAL_MODULE    := libswresample
LOCAL_SRC_FILES := libswresample/libswresample.a
include $(PREBUILT_STATIC_LIBRARY)

include $(CLEAR_VARS)
LOCAL_MODULE    := ffmpeg
LOCAL_WHOLE_STATIC_LIBRARIES := libavutil libpostproc libswscale libavcodec libavfilter libavformat libswresample libspeex
include $(BUILD_SHARED_LIBRARY)

