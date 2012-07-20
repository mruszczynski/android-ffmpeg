MY_LOCAL_PATH := $(call my-dir)
APP_MODULES := speex libavutil libavcodec libavformat libswresample libswscale libpostproc libavfilter libavresample ffmpeg_swig
#APP_OPTIM := release 
APP_OPTIM := debug 
APP_ABI := armeabi armeabi-v7a
APP_CFLAGS += -g
APP_CFLAGS += -fuse-ld=gold 
APP_CFLAGS += -Wl,--pic-veneer,-pie -fPIE -fPIC
#APP_GNUSTL_FORCE_CPP_FEATURES := exceptions rtti

