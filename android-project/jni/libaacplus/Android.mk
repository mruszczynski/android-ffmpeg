LOCAL_PATH := $(call my-dir)/libaacplus/
include $(CLEAR_VARS)
LOCAL_MODULE    := libaacplus

LOCAL_SRC_FILES := \
	src/aacplusenc.c \
	src/adts.c

LOCAL_C_INCLUDES += include
LOCAL_C_INCLUDES += src
LOCAL_CFLAGS = -DFIXED_POINT -DEXPORT="" -UHAVE_CONFIG_H -I$(LOCAL_PATH)/include -I$(LOCAL_PATH)/src
include $(BUILD_STATIC_LIBRARY)
include $(CLEAR_VARS)


