/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.6
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package com.pluggedin.ffmpeg;

public interface ffmpegConstants {
  public final static int AV_OPT_FLAG_ENCODING_PARAM = 1;
  public final static int AV_OPT_FLAG_DECODING_PARAM = 2;
  public final static int AV_OPT_FLAG_METADATA = 4;
  public final static int AV_OPT_FLAG_AUDIO_PARAM = 8;
  public final static int AV_OPT_FLAG_VIDEO_PARAM = 16;
  public final static int AV_OPT_FLAG_SUBTITLE_PARAM = 32;
  public final static int AV_OPT_SEARCH_CHILDREN = 0x0001;
  public final static int AV_OPT_SEARCH_FAKE_OBJ = 0x0002;
  public final static int INT16_MIN = (-0x7fff-1);
  public final static int INT16_MAX = 0x7fff;
  public final static int INT32_MIN = (-0x7fffffff-1);
  public final static int INT32_MAX = 0x7fffffff;
  public final static int UINT32_MAX = 0xffffffff;
  public final static long INT64_MIN = (-0x7fffffffffffffffL-1);
  public final static int LIBAVUTIL_VERSION_MAJOR = 51;
  public final static int LIBAVUTIL_VERSION_MINOR = 32;
  public final static int LIBAVUTIL_VERSION_MICRO = 0;
  public final static int LIBAVUTIL_VERSION_INT = (51 << 16|32 << 8|0);
  public final static int LIBAVUTIL_BUILD = (51 << 16|32 << 8|0);
  public final static String LIBAVUTIL_IDENT = "Lavu51.32.0";
  public final static int FF_LAMBDA_SHIFT = 7;
  public final static int FF_LAMBDA_SCALE = (1 << 7);
  public final static int FF_QP2LAMBDA = 118;
  public final static int FF_LAMBDA_MAX = (256*128-1);
  public final static int FF_QUALITY_SCALE = (1 << 7);
  public final static int AV_TIME_BASE = 1000000;
  public final static int LIBSWSCALE_VERSION_MAJOR = 2;
  public final static int LIBSWSCALE_VERSION_MINOR = 1;
  public final static int LIBSWSCALE_VERSION_MICRO = 0;
  public final static int LIBSWSCALE_VERSION_INT = (2 << 16|1 << 8|0);
  public final static int LIBSWSCALE_BUILD = (2 << 16|1 << 8|0);
  public final static String LIBSWSCALE_IDENT = "SwS2.1.0";
  public final static int SWS_FAST_BILINEAR = 1;
  public final static int SWS_BILINEAR = 2;
  public final static int SWS_BICUBIC = 4;
  public final static int SWS_X = 8;
  public final static int SWS_POINT = 0x10;
  public final static int SWS_AREA = 0x20;
  public final static int SWS_BICUBLIN = 0x40;
  public final static int SWS_GAUSS = 0x80;
  public final static int SWS_SINC = 0x100;
  public final static int SWS_LANCZOS = 0x200;
  public final static int SWS_SPLINE = 0x400;
  public final static int SWS_SRC_V_CHR_DROP_MASK = 0x30000;
  public final static int SWS_SRC_V_CHR_DROP_SHIFT = 16;
  public final static int SWS_PARAM_DEFAULT = 123456;
  public final static int SWS_PRINT_INFO = 0x1000;
  public final static int SWS_FULL_CHR_H_INT = 0x2000;
  public final static int SWS_FULL_CHR_H_INP = 0x4000;
  public final static int SWS_DIRECT_BGR = 0x8000;
  public final static int SWS_ACCURATE_RND = 0x40000;
  public final static int SWS_BITEXACT = 0x80000;
  public final static int SWS_CPU_CAPS_MMX = 0x80000000;
  public final static int SWS_CPU_CAPS_MMX2 = 0x20000000;
  public final static int SWS_CPU_CAPS_3DNOW = 0x40000000;
  public final static int SWS_CPU_CAPS_ALTIVEC = 0x10000000;
  public final static int SWS_CPU_CAPS_BFIN = 0x01000000;
  public final static int SWS_CPU_CAPS_SSE2 = 0x02000000;
  public final static double SWS_MAX_REDUCE_CUTOFF = 0.002;
  public final static int SWS_CS_ITU709 = 1;
  public final static int SWS_CS_FCC = 4;
  public final static int SWS_CS_ITU601 = 5;
  public final static int SWS_CS_ITU624 = 5;
  public final static int SWS_CS_SMPTE170M = 5;
  public final static int SWS_CS_SMPTE240M = 7;
  public final static int SWS_CS_DEFAULT = 5;
  public final static int FF_INPUT_BUFFER_PADDING_SIZE = 16;
  public final static int FF_MIN_BUFFER_SIZE = 16384;
  public final static int FF_MAX_B_FRAMES = 16;
  public final static int CODEC_FLAG_QSCALE = 0x0002;
  public final static int CODEC_FLAG_4MV = 0x0004;
  public final static int CODEC_FLAG_QPEL = 0x0010;
  public final static int CODEC_FLAG_GMC = 0x0020;
  public final static int CODEC_FLAG_MV0 = 0x0040;
  public final static int CODEC_FLAG_INPUT_PRESERVED = 0x0100;
  public final static int CODEC_FLAG_PASS1 = 0x0200;
  public final static int CODEC_FLAG_PASS2 = 0x0400;
  public final static int CODEC_FLAG_GRAY = 0x2000;
  public final static int CODEC_FLAG_EMU_EDGE = 0x4000;
  public final static int CODEC_FLAG_PSNR = 0x8000;
  public final static int CODEC_FLAG_TRUNCATED = 0x00010000;
  public final static int CODEC_FLAG_NORMALIZE_AQP = 0x00020000;
  public final static int CODEC_FLAG_INTERLACED_DCT = 0x00040000;
  public final static int CODEC_FLAG_LOW_DELAY = 0x00080000;
  public final static int CODEC_FLAG_GLOBAL_HEADER = 0x00400000;
  public final static int CODEC_FLAG_BITEXACT = 0x00800000;
  public final static int CODEC_FLAG_AC_PRED = 0x01000000;
  public final static int CODEC_FLAG_CBP_RD = 0x04000000;
  public final static int CODEC_FLAG_QP_RD = 0x08000000;
  public final static int CODEC_FLAG_LOOP_FILTER = 0x00000800;
  public final static int CODEC_FLAG_INTERLACED_ME = 0x20000000;
  public final static int CODEC_FLAG_CLOSED_GOP = 0x80000000;
  public final static int CODEC_FLAG2_FAST = 0x00000001;
  public final static int CODEC_FLAG2_STRICT_GOP = 0x00000002;
  public final static int CODEC_FLAG2_NO_OUTPUT = 0x00000004;
  public final static int CODEC_FLAG2_LOCAL_HEADER = 0x00000008;
  public final static int CODEC_FLAG2_SKIP_RD = 0x00004000;
  public final static int CODEC_FLAG2_CHUNKS = 0x00008000;
  public final static int CODEC_FLAG2_SHOW_ALL = 0x00400000;
  public final static int CODEC_CAP_DRAW_HORIZ_BAND = 0x0001;
  public final static int CODEC_CAP_DR1 = 0x0002;
  public final static int CODEC_CAP_TRUNCATED = 0x0008;
  public final static int CODEC_CAP_HWACCEL = 0x0010;
  public final static int CODEC_CAP_DELAY = 0x0020;
  public final static int CODEC_CAP_SMALL_LAST_FRAME = 0x0040;
  public final static int CODEC_CAP_HWACCEL_VDPAU = 0x0080;
  public final static int CODEC_CAP_SUBFRAMES = 0x0100;
  public final static int CODEC_CAP_EXPERIMENTAL = 0x0200;
  public final static int CODEC_CAP_CHANNEL_CONF = 0x0400;
  public final static int CODEC_CAP_NEG_LINESIZES = 0x0800;
  public final static int CODEC_CAP_FRAME_THREADS = 0x1000;
  public final static int CODEC_CAP_SLICE_THREADS = 0x2000;
  public final static int CODEC_CAP_LOSSLESS = 0x80000000;
  public final static int MB_TYPE_INTRA4x4 = 0x0001;
  public final static int MB_TYPE_INTRA16x16 = 0x0002;
  public final static int MB_TYPE_INTRA_PCM = 0x0004;
  public final static int MB_TYPE_16x16 = 0x0008;
  public final static int MB_TYPE_16x8 = 0x0010;
  public final static int MB_TYPE_8x16 = 0x0020;
  public final static int MB_TYPE_8x8 = 0x0040;
  public final static int MB_TYPE_INTERLACED = 0x0080;
  public final static int MB_TYPE_DIRECT2 = 0x0100;
  public final static int MB_TYPE_ACPRED = 0x0200;
  public final static int MB_TYPE_GMC = 0x0400;
  public final static int MB_TYPE_SKIP = 0x0800;
  public final static int MB_TYPE_P0L0 = 0x1000;
  public final static int MB_TYPE_P1L0 = 0x2000;
  public final static int MB_TYPE_P0L1 = 0x4000;
  public final static int MB_TYPE_P1L1 = 0x8000;
  public final static int MB_TYPE_L0 = (0x1000|0x2000);
  public final static int MB_TYPE_L1 = (0x4000|0x8000);
  public final static int MB_TYPE_L0L1 = ((0x1000|0x2000)|(0x4000|0x8000));
  public final static int MB_TYPE_QUANT = 0x00010000;
  public final static int MB_TYPE_CBP = 0x00020000;
  public final static int FF_QSCALE_TYPE_MPEG1 = 0;
  public final static int FF_QSCALE_TYPE_MPEG2 = 1;
  public final static int FF_QSCALE_TYPE_H264 = 2;
  public final static int FF_QSCALE_TYPE_VP56 = 3;
  public final static int FF_BUFFER_TYPE_INTERNAL = 1;
  public final static int FF_BUFFER_TYPE_USER = 2;
  public final static int FF_BUFFER_TYPE_SHARED = 4;
  public final static int FF_BUFFER_TYPE_COPY = 8;
  public final static int FF_BUFFER_HINTS_VALID = 0x01;
  public final static int FF_BUFFER_HINTS_READABLE = 0x02;
  public final static int FF_BUFFER_HINTS_PRESERVE = 0x04;
  public final static int FF_BUFFER_HINTS_REUSABLE = 0x08;
  public final static int AV_PKT_FLAG_KEY = 0x0001;
  public final static int AV_PKT_FLAG_CORRUPT = 0x0002;
  public final static int AV_NUM_DATA_POINTERS = 8;
  public final static int FF_ASPECT_EXTENDED = 15;
  public final static int FF_RC_STRATEGY_XVID = 1;
  public final static int FF_BUG_AUTODETECT = 1;
  public final static int FF_BUG_OLD_MSMPEG4 = 2;
  public final static int FF_BUG_XVID_ILACE = 4;
  public final static int FF_BUG_UMP4 = 8;
  public final static int FF_BUG_NO_PADDING = 16;
  public final static int FF_BUG_AMV = 32;
  public final static int FF_BUG_AC_VLC = 0;
  public final static int FF_BUG_QPEL_CHROMA = 64;
  public final static int FF_BUG_STD_QPEL = 128;
  public final static int FF_BUG_QPEL_CHROMA2 = 256;
  public final static int FF_BUG_DIRECT_BLOCKSIZE = 512;
  public final static int FF_BUG_EDGE = 1024;
  public final static int FF_BUG_HPEL_CHROMA = 2048;
  public final static int FF_BUG_DC_CLIP = 4096;
  public final static int FF_BUG_MS = 8192;
  public final static int FF_BUG_TRUNCATED = 16384;
  public final static int FF_COMPLIANCE_VERY_STRICT = 2;
  public final static int FF_COMPLIANCE_STRICT = 1;
  public final static int FF_COMPLIANCE_NORMAL = 0;
  public final static int FF_COMPLIANCE_UNOFFICIAL = -1;
  public final static int FF_COMPLIANCE_EXPERIMENTAL = -2;
  public final static int FF_DCT_AUTO = 0;
  public final static int FF_DCT_FASTINT = 1;
  public final static int FF_DCT_INT = 2;
  public final static int FF_DCT_MMX = 3;
  public final static int FF_DCT_MLIB = 4;
  public final static int FF_DCT_ALTIVEC = 5;
  public final static int FF_DCT_FAAN = 6;
  public final static int FF_IDCT_AUTO = 0;
  public final static int FF_IDCT_INT = 1;
  public final static int FF_IDCT_SIMPLE = 2;
  public final static int FF_IDCT_SIMPLEMMX = 3;
  public final static int FF_IDCT_LIBMPEG2MMX = 4;
  public final static int FF_IDCT_PS2 = 5;
  public final static int FF_IDCT_MLIB = 6;
  public final static int FF_IDCT_ARM = 7;
  public final static int FF_IDCT_ALTIVEC = 8;
  public final static int FF_IDCT_SH4 = 9;
  public final static int FF_IDCT_SIMPLEARM = 10;
  public final static int FF_IDCT_H264 = 11;
  public final static int FF_IDCT_VP3 = 12;
  public final static int FF_IDCT_IPP = 13;
  public final static int FF_IDCT_XVIDMMX = 14;
  public final static int FF_IDCT_CAVS = 15;
  public final static int FF_IDCT_SIMPLEARMV5TE = 16;
  public final static int FF_IDCT_SIMPLEARMV6 = 17;
  public final static int FF_IDCT_SIMPLEVIS = 18;
  public final static int FF_IDCT_WMV2 = 19;
  public final static int FF_IDCT_FAAN = 20;
  public final static int FF_IDCT_EA = 21;
  public final static int FF_IDCT_SIMPLENEON = 22;
  public final static int FF_IDCT_SIMPLEALPHA = 23;
  public final static int FF_IDCT_BINK = 24;
  public final static int FF_EC_GUESS_MVS = 1;
  public final static int FF_EC_DEBLOCK = 2;
  public final static int FF_PRED_LEFT = 0;
  public final static int FF_PRED_PLANE = 1;
  public final static int FF_PRED_MEDIAN = 2;
  public final static int FF_DEBUG_PICT_INFO = 1;
  public final static int FF_DEBUG_RC = 2;
  public final static int FF_DEBUG_BITSTREAM = 4;
  public final static int FF_DEBUG_MB_TYPE = 8;
  public final static int FF_DEBUG_QP = 16;
  public final static int FF_DEBUG_MV = 32;
  public final static int FF_DEBUG_DCT_COEFF = 0x00000040;
  public final static int FF_DEBUG_SKIP = 0x00000080;
  public final static int FF_DEBUG_STARTCODE = 0x00000100;
  public final static int FF_DEBUG_PTS = 0x00000200;
  public final static int FF_DEBUG_ER = 0x00000400;
  public final static int FF_DEBUG_MMCO = 0x00000800;
  public final static int FF_DEBUG_BUGS = 0x00001000;
  public final static int FF_DEBUG_VIS_QP = 0x00002000;
  public final static int FF_DEBUG_VIS_MB_TYPE = 0x00004000;
  public final static int FF_DEBUG_BUFFERS = 0x00008000;
  public final static int FF_DEBUG_THREADS = 0x00010000;
  public final static int FF_DEBUG_VIS_MV_P_FOR = 0x00000001;
  public final static int FF_DEBUG_VIS_MV_B_FOR = 0x00000002;
  public final static int FF_DEBUG_VIS_MV_B_BACK = 0x00000004;
  public final static int FF_CMP_SAD = 0;
  public final static int FF_CMP_SSE = 1;
  public final static int FF_CMP_SATD = 2;
  public final static int FF_CMP_DCT = 3;
  public final static int FF_CMP_PSNR = 4;
  public final static int FF_CMP_BIT = 5;
  public final static int FF_CMP_RD = 6;
  public final static int FF_CMP_ZERO = 7;
  public final static int FF_CMP_VSAD = 8;
  public final static int FF_CMP_VSSE = 9;
  public final static int FF_CMP_NSSE = 10;
  public final static int FF_CMP_W53 = 11;
  public final static int FF_CMP_W97 = 12;
  public final static int FF_CMP_DCTMAX = 13;
  public final static int FF_CMP_DCT264 = 14;
  public final static int FF_CMP_CHROMA = 256;
  public final static int FF_DTG_AFD_SAME = 8;
  public final static int FF_DTG_AFD_4_3 = 9;
  public final static int FF_DTG_AFD_16_9 = 10;
  public final static int FF_DTG_AFD_14_9 = 11;
  public final static int FF_DTG_AFD_4_3_SP_14_9 = 13;
  public final static int FF_DTG_AFD_16_9_SP_14_9 = 14;
  public final static int FF_DTG_AFD_SP_4_3 = 15;
  public final static int FF_DEFAULT_QUANT_BIAS = 999999;
  public final static int FF_CODER_TYPE_VLC = 0;
  public final static int FF_CODER_TYPE_AC = 1;
  public final static int FF_CODER_TYPE_RAW = 2;
  public final static int FF_CODER_TYPE_RLE = 3;
  public final static int FF_CODER_TYPE_DEFLATE = 4;
  public final static int SLICE_FLAG_CODED_ORDER = 0x0001;
  public final static int SLICE_FLAG_ALLOW_FIELD = 0x0002;
  public final static int SLICE_FLAG_ALLOW_PLANE = 0x0004;
  public final static int FF_MB_DECISION_SIMPLE = 0;
  public final static int FF_MB_DECISION_BITS = 1;
  public final static int FF_MB_DECISION_RD = 2;
  public final static int FF_PROFILE_UNKNOWN = -99;
  public final static int FF_PROFILE_RESERVED = -100;
  public final static int FF_PROFILE_AAC_MAIN = 0;
  public final static int FF_PROFILE_AAC_LOW = 1;
  public final static int FF_PROFILE_AAC_SSR = 2;
  public final static int FF_PROFILE_AAC_LTP = 3;
  public final static int FF_PROFILE_DTS = 20;
  public final static int FF_PROFILE_DTS_ES = 30;
  public final static int FF_PROFILE_DTS_96_24 = 40;
  public final static int FF_PROFILE_DTS_HD_HRA = 50;
  public final static int FF_PROFILE_DTS_HD_MA = 60;
  public final static int FF_PROFILE_MPEG2_422 = 0;
  public final static int FF_PROFILE_MPEG2_HIGH = 1;
  public final static int FF_PROFILE_MPEG2_SS = 2;
  public final static int FF_PROFILE_MPEG2_SNR_SCALABLE = 3;
  public final static int FF_PROFILE_MPEG2_MAIN = 4;
  public final static int FF_PROFILE_MPEG2_SIMPLE = 5;
  public final static int FF_PROFILE_H264_CONSTRAINED = (1 << 9);
  public final static int FF_PROFILE_H264_INTRA = (1 << 11);
  public final static int FF_PROFILE_H264_BASELINE = 66;
  public final static int FF_PROFILE_H264_CONSTRAINED_BASELINE = (66|(1 << 9));
  public final static int FF_PROFILE_H264_MAIN = 77;
  public final static int FF_PROFILE_H264_EXTENDED = 88;
  public final static int FF_PROFILE_H264_HIGH = 100;
  public final static int FF_PROFILE_H264_HIGH_10 = 110;
  public final static int FF_PROFILE_H264_HIGH_10_INTRA = (110|(1 << 11));
  public final static int FF_PROFILE_H264_HIGH_422 = 122;
  public final static int FF_PROFILE_H264_HIGH_422_INTRA = (122|(1 << 11));
  public final static int FF_PROFILE_H264_HIGH_444 = 144;
  public final static int FF_PROFILE_H264_HIGH_444_PREDICTIVE = 244;
  public final static int FF_PROFILE_H264_HIGH_444_INTRA = (244|(1 << 11));
  public final static int FF_PROFILE_H264_CAVLC_444 = 44;
  public final static int FF_PROFILE_VC1_SIMPLE = 0;
  public final static int FF_PROFILE_VC1_MAIN = 1;
  public final static int FF_PROFILE_VC1_COMPLEX = 2;
  public final static int FF_PROFILE_VC1_ADVANCED = 3;
  public final static int FF_PROFILE_MPEG4_SIMPLE = 0;
  public final static int FF_PROFILE_MPEG4_SIMPLE_SCALABLE = 1;
  public final static int FF_PROFILE_MPEG4_CORE = 2;
  public final static int FF_PROFILE_MPEG4_MAIN = 3;
  public final static int FF_PROFILE_MPEG4_N_BIT = 4;
  public final static int FF_PROFILE_MPEG4_SCALABLE_TEXTURE = 5;
  public final static int FF_PROFILE_MPEG4_SIMPLE_FACE_ANIMATION = 6;
  public final static int FF_PROFILE_MPEG4_BASIC_ANIMATED_TEXTURE = 7;
  public final static int FF_PROFILE_MPEG4_HYBRID = 8;
  public final static int FF_PROFILE_MPEG4_ADVANCED_REAL_TIME = 9;
  public final static int FF_PROFILE_MPEG4_CORE_SCALABLE = 10;
  public final static int FF_PROFILE_MPEG4_ADVANCED_CODING = 11;
  public final static int FF_PROFILE_MPEG4_ADVANCED_CORE = 12;
  public final static int FF_PROFILE_MPEG4_ADVANCED_SCALABLE_TEXTURE = 13;
  public final static int FF_PROFILE_MPEG4_SIMPLE_STUDIO = 14;
  public final static int FF_PROFILE_MPEG4_ADVANCED_SIMPLE = 15;
  public final static int FF_LEVEL_UNKNOWN = -99;
  public final static int FF_COMPRESSION_DEFAULT = -1;
  public final static int FF_THREAD_FRAME = 1;
  public final static int FF_THREAD_SLICE = 2;
  public final static int AV_EF_CRCCHECK = (1 << 0);
  public final static int AV_EF_BITSTREAM = (1 << 1);
  public final static int AV_EF_BUFFER = (1 << 2);
  public final static int AV_EF_EXPLODE = (1 << 3);
  public final static int AV_EF_CAREFUL = (1 << 16);
  public final static int AV_EF_COMPLIANT = (1 << 17);
  public final static int AV_EF_AGGRESSIVE = (1 << 18);
  public final static int AVPALETTE_SIZE = 1024;
  public final static int AVPALETTE_COUNT = 256;
  public final static int FF_LOSS_RESOLUTION = 0x0001;
  public final static int FF_LOSS_DEPTH = 0x0002;
  public final static int FF_LOSS_COLORSPACE = 0x0004;
  public final static int FF_LOSS_ALPHA = 0x0008;
  public final static int FF_LOSS_COLORQUANT = 0x0010;
  public final static int FF_LOSS_CHROMA = 0x0020;
  public final static int AV_PARSER_PTS_NB = 4;
  public final static int PARSER_FLAG_COMPLETE_FRAMES = 0x0001;
  public final static int PARSER_FLAG_ONCE = 0x0002;
  public final static int PARSER_FLAG_FETCHED_OFFSET = 0x0004;
  public final static int LIBAVFILTER_VERSION_MAJOR = 2;
  public final static int LIBAVFILTER_VERSION_MINOR = 53;
  public final static int LIBAVFILTER_VERSION_MICRO = 0;
  public final static int LIBAVFILTER_VERSION_INT = (2 << 16|53 << 8|0);
  public final static int LIBAVFILTER_BUILD = (2 << 16|53 << 8|0);
  public final static int AV_PERM_READ = 0x01;
  public final static int AV_PERM_WRITE = 0x02;
  public final static int AV_PERM_PRESERVE = 0x04;
  public final static int AV_PERM_REUSE = 0x08;
  public final static int AV_PERM_REUSE2 = 0x10;
  public final static int AV_PERM_NEG_LINESIZES = 0x20;
  public final static int AV_PERM_ALIGN = 0x40;
  public final static int AVFILTER_ALIGN = 16;
  public final static int AVFILTER_CMD_FLAG_ONE = 1;
  public final static int AVFILTER_CMD_FLAG_FAST = 2;
  public final static int AVPROBE_SCORE_MAX = 100;
  public final static int AVPROBE_PADDING_SIZE = 32;
  public final static int AVFMT_NOFILE = 0x0001;
  public final static int AVFMT_NEEDNUMBER = 0x0002;
  public final static int AVFMT_SHOW_IDS = 0x0008;
  public final static int AVFMT_RAWPICTURE = 0x0020;
  public final static int AVFMT_GLOBALHEADER = 0x0040;
  public final static int AVFMT_NOTIMESTAMPS = 0x0080;
  public final static int AVFMT_GENERIC_INDEX = 0x0100;
  public final static int AVFMT_TS_DISCONT = 0x0200;
  public final static int AVFMT_VARIABLE_FPS = 0x0400;
  public final static int AVFMT_NODIMENSIONS = 0x0800;
  public final static int AVFMT_NOSTREAMS = 0x1000;
  public final static int AVFMT_NOBINSEARCH = 0x2000;
  public final static int AVFMT_NOGENSEARCH = 0x4000;
  public final static int AVFMT_NO_BYTE_SEEK = 0x8000;
  public final static int AVFMT_TS_NONSTRICT = 0x8000000;
  public final static int AVINDEX_KEYFRAME = 0x0001;
  public final static int AV_DISPOSITION_DEFAULT = 0x0001;
  public final static int AV_DISPOSITION_DUB = 0x0002;
  public final static int AV_DISPOSITION_ORIGINAL = 0x0004;
  public final static int AV_DISPOSITION_COMMENT = 0x0008;
  public final static int AV_DISPOSITION_LYRICS = 0x0010;
  public final static int AV_DISPOSITION_KARAOKE = 0x0020;
  public final static int AV_DISPOSITION_FORCED = 0x0040;
  public final static int AV_DISPOSITION_HEARING_IMPAIRED = 0x0080;
  public final static int AV_DISPOSITION_VISUAL_IMPAIRED = 0x0100;
  public final static int AV_DISPOSITION_CLEAN_EFFECTS = 0x0200;
  public final static int MAX_STD_TIMEBASES = (60*12+5);
  public final static int MAX_PROBE_PACKETS = 2500;
  public final static int MAX_REORDER_DELAY = 16;
  public final static int AV_PROGRAM_RUNNING = 1;
  public final static int AVFMTCTX_NOHEADER = 0x0001;
  public final static int AVFMT_FLAG_GENPTS = 0x0001;
  public final static int AVFMT_FLAG_IGNIDX = 0x0002;
  public final static int AVFMT_FLAG_NONBLOCK = 0x0004;
  public final static int AVFMT_FLAG_IGNDTS = 0x0008;
  public final static int AVFMT_FLAG_NOFILLIN = 0x0010;
  public final static int AVFMT_FLAG_NOPARSE = 0x0020;
  public final static int AVFMT_FLAG_CUSTOM_IO = 0x0080;
  public final static int AVFMT_FLAG_DISCARD_CORRUPT = 0x0100;
  public final static int AVFMT_FLAG_MP4A_LATM = 0x8000;
  public final static int AVFMT_FLAG_SORT_DTS = 0x10000;
  public final static int AVFMT_FLAG_PRIV_OPT = 0x20000;
  public final static int AVFMT_FLAG_KEEP_SIDE_DATA = 0x40000;
  public final static int FF_FDEBUG_TS = 0x0001;
  public final static int RAW_PACKET_BUFFER_SIZE = 2500000;
  public final static int AVSEEK_FLAG_BACKWARD = 1;
  public final static int AVSEEK_FLAG_BYTE = 2;
  public final static int AVSEEK_FLAG_ANY = 4;
  public final static int AVSEEK_FLAG_FRAME = 8;
  public final static int LIBSWRESAMPLE_VERSION_MAJOR = 0;
  public final static int LIBSWRESAMPLE_VERSION_MINOR = 5;
  public final static int LIBSWRESAMPLE_VERSION_MICRO = 0;
  public final static int SWR_CH_MAX = 16;
  public final static int SWR_FLAG_RESAMPLE = 1;
}
