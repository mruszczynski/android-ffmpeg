LOCAL_PATH := $(call my-dir)
#NDK_PROJECT_PATH := LOCAL_PATH

include $(CLEAR_VARS)

LOCAL_MODULE    := speex

LOCAL_SRC_FILES := \
	speex/libspeex/testenc_uwb.c \
	speex/libspeex/hexc_10_32_table.c \
	speex/libspeex/vbr.c \
	speex/libspeex/scal.c \
	speex/libspeex/testdenoise.c \
	speex/libspeex/sb_celp.c \
	speex/libspeex/vorbis_psy.c \
	speex/libspeex/high_lsp_tables.c \
	speex/libspeex/lsp.c \
	speex/libspeex/filters.c \
	speex/libspeex/exc_20_32_table.c \
	speex/libspeex/testenc.c \
	speex/libspeex/speex_header.c \
	speex/libspeex/speex_callbacks.c \
	speex/libspeex/bits.c \
	speex/libspeex/lpc.c \
	speex/libspeex/resample.c \
	speex/libspeex/exc_10_32_table.c \
	speex/libspeex/quant_lsp.c \
	speex/libspeex/exc_5_64_table.c \
	speex/libspeex/modes_wb.c \
	speex/libspeex/hexc_table.c \
	speex/libspeex/kiss_fftr.c \
	speex/libspeex/gain_table_lbr.c \
	speex/libspeex/exc_10_16_table.c \
	speex/libspeex/jitter.c \
	speex/libspeex/filterbank.c \
	speex/libspeex/mdf.c \
	speex/libspeex/window.c \
	speex/libspeex/exc_5_256_table.c \
	speex/libspeex/testjitter.c \
	speex/libspeex/testresample.c \
	speex/libspeex/testenc_wb.c \
	speex/libspeex/smallft.c \
	speex/libspeex/preprocess.c \
	speex/libspeex/nb_celp.c \
	speex/libspeex/exc_8_128_table.c \
	speex/libspeex/kiss_fft.c \
	speex/libspeex/speex.c \
	speex/libspeex/modes.c \
	speex/libspeex/stereo.c \
	speex/libspeex/testecho.c \
	speex/libspeex/buffer.c \
	speex/libspeex/cb_search.c \
	speex/libspeex/gain_table.c \
	speex/libspeex/lsp_tables_nb.c \
	speex/libspeex/ltp.c \
	speex/libspeex/vq.c

#	speex/libspeex/fftwrap.c \

LOCAL_C_INCLUDES += speex/include
LOCAL_CFLAGS = -DFIXED_POINT -DEXPORT="" -UHAVE_CONFIG_H -I$(LOCAL_PATH)/speex/include
include $(BUILD_STATIC_LIBRARY)


