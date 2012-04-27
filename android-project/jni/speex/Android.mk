LOCAL_PATH := $(call my-dir)/speex
include $(CLEAR_VARS)
LOCAL_MODULE    := speex

LOCAL_SRC_FILES := \
	libspeex/testenc_uwb.c \
	libspeex/hexc_10_32_table.c \
	libspeex/vbr.c \
	libspeex/scal.c \
	libspeex/testdenoise.c \
	libspeex/sb_celp.c \
	libspeex/vorbis_psy.c \
	libspeex/high_lsp_tables.c \
	libspeex/lsp.c \
	libspeex/filters.c \
	libspeex/exc_20_32_table.c \
	libspeex/testenc.c \
	libspeex/speex_header.c \
	libspeex/speex_callbacks.c \
	libspeex/bits.c \
	libspeex/lpc.c \
	libspeex/resample.c \
	libspeex/exc_10_32_table.c \
	libspeex/quant_lsp.c \
	libspeex/exc_5_64_table.c \
	libspeex/modes_wb.c \
	libspeex/hexc_table.c \
	libspeex/kiss_fftr.c \
	libspeex/gain_table_lbr.c \
	libspeex/exc_10_16_table.c \
	libspeex/jitter.c \
	libspeex/filterbank.c \
	libspeex/mdf.c \
	libspeex/window.c \
	libspeex/exc_5_256_table.c \
	libspeex/testjitter.c \
	libspeex/testresample.c \
	libspeex/testenc_wb.c \
	libspeex/smallft.c \
	libspeex/preprocess.c \
	libspeex/nb_celp.c \
	libspeex/exc_8_128_table.c \
	libspeex/kiss_fft.c \
	libspeex/speex.c \
	libspeex/modes.c \
	libspeex/stereo.c \
	libspeex/testecho.c \
	libspeex/buffer.c \
	libspeex/cb_search.c \
	libspeex/gain_table.c \
	libspeex/lsp_tables_nb.c \
	libspeex/ltp.c \
	libspeex/vq.c

LOCAL_C_INCLUDES += include
LOCAL_CFLAGS = -DFIXED_POINT -DEXPORT="" -UHAVE_CONFIG_H -I$(LOCAL_PATH)/include
include $(BUILD_STATIC_LIBRARY)
include $(CLEAR_VARS)


