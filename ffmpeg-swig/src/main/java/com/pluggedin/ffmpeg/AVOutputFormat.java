/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.6
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package com.pluggedin.ffmpeg;

public class AVOutputFormat {
  private long swigCPtr;
  protected boolean swigCMemOwn;

  protected AVOutputFormat(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(AVOutputFormat obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        ffmpegJNI.delete_AVOutputFormat(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void setName(String value) {
    ffmpegJNI.AVOutputFormat_name_set(swigCPtr, this, value);
  }

  public String getName() {
    return ffmpegJNI.AVOutputFormat_name_get(swigCPtr, this);
  }

  public void setLong_name(String value) {
    ffmpegJNI.AVOutputFormat_long_name_set(swigCPtr, this, value);
  }

  public String getLong_name() {
    return ffmpegJNI.AVOutputFormat_long_name_get(swigCPtr, this);
  }

  public void setMime_type(String value) {
    ffmpegJNI.AVOutputFormat_mime_type_set(swigCPtr, this, value);
  }

  public String getMime_type() {
    return ffmpegJNI.AVOutputFormat_mime_type_get(swigCPtr, this);
  }

  public void setExtensions(String value) {
    ffmpegJNI.AVOutputFormat_extensions_set(swigCPtr, this, value);
  }

  public String getExtensions() {
    return ffmpegJNI.AVOutputFormat_extensions_get(swigCPtr, this);
  }

  public void setPriv_data_size(int value) {
    ffmpegJNI.AVOutputFormat_priv_data_size_set(swigCPtr, this, value);
  }

  public int getPriv_data_size() {
    return ffmpegJNI.AVOutputFormat_priv_data_size_get(swigCPtr, this);
  }

  public void setAudio_codec(CodecID value) {
    ffmpegJNI.AVOutputFormat_audio_codec_set(swigCPtr, this, value.swigValue());
  }

  public CodecID getAudio_codec() {
    return CodecID.swigToEnum(ffmpegJNI.AVOutputFormat_audio_codec_get(swigCPtr, this));
  }

  public void setVideo_codec(CodecID value) {
    ffmpegJNI.AVOutputFormat_video_codec_set(swigCPtr, this, value.swigValue());
  }

  public CodecID getVideo_codec() {
    return CodecID.swigToEnum(ffmpegJNI.AVOutputFormat_video_codec_get(swigCPtr, this));
  }

  public void setWrite_header(SWIGTYPE_p_f_p_struct_AVFormatContext__int value) {
    ffmpegJNI.AVOutputFormat_write_header_set(swigCPtr, this, SWIGTYPE_p_f_p_struct_AVFormatContext__int.getCPtr(value));
  }

  public SWIGTYPE_p_f_p_struct_AVFormatContext__int getWrite_header() {
    long cPtr = ffmpegJNI.AVOutputFormat_write_header_get(swigCPtr, this);
    return (cPtr == 0) ? null : new SWIGTYPE_p_f_p_struct_AVFormatContext__int(cPtr, false);
  }

  public void setWrite_packet(SWIGTYPE_p_f_p_struct_AVFormatContext_p_struct_AVPacket__int value) {
    ffmpegJNI.AVOutputFormat_write_packet_set(swigCPtr, this, SWIGTYPE_p_f_p_struct_AVFormatContext_p_struct_AVPacket__int.getCPtr(value));
  }

  public SWIGTYPE_p_f_p_struct_AVFormatContext_p_struct_AVPacket__int getWrite_packet() {
    long cPtr = ffmpegJNI.AVOutputFormat_write_packet_get(swigCPtr, this);
    return (cPtr == 0) ? null : new SWIGTYPE_p_f_p_struct_AVFormatContext_p_struct_AVPacket__int(cPtr, false);
  }

  public void setWrite_trailer(SWIGTYPE_p_f_p_struct_AVFormatContext__int value) {
    ffmpegJNI.AVOutputFormat_write_trailer_set(swigCPtr, this, SWIGTYPE_p_f_p_struct_AVFormatContext__int.getCPtr(value));
  }

  public SWIGTYPE_p_f_p_struct_AVFormatContext__int getWrite_trailer() {
    long cPtr = ffmpegJNI.AVOutputFormat_write_trailer_get(swigCPtr, this);
    return (cPtr == 0) ? null : new SWIGTYPE_p_f_p_struct_AVFormatContext__int(cPtr, false);
  }

  public void setFlags(int value) {
    ffmpegJNI.AVOutputFormat_flags_set(swigCPtr, this, value);
  }

  public int getFlags() {
    return ffmpegJNI.AVOutputFormat_flags_get(swigCPtr, this);
  }

  public void setDummy(SWIGTYPE_p_void value) {
    ffmpegJNI.AVOutputFormat_dummy_set(swigCPtr, this, SWIGTYPE_p_void.getCPtr(value));
  }

  public SWIGTYPE_p_void getDummy() {
    long cPtr = ffmpegJNI.AVOutputFormat_dummy_get(swigCPtr, this);
    return (cPtr == 0) ? null : new SWIGTYPE_p_void(cPtr, false);
  }

  public void setInterleave_packet(SWIGTYPE_p_f_p_struct_AVFormatContext_p_struct_AVPacket_p_struct_AVPacket_int__int value) {
    ffmpegJNI.AVOutputFormat_interleave_packet_set(swigCPtr, this, SWIGTYPE_p_f_p_struct_AVFormatContext_p_struct_AVPacket_p_struct_AVPacket_int__int.getCPtr(value));
  }

  public SWIGTYPE_p_f_p_struct_AVFormatContext_p_struct_AVPacket_p_struct_AVPacket_int__int getInterleave_packet() {
    long cPtr = ffmpegJNI.AVOutputFormat_interleave_packet_get(swigCPtr, this);
    return (cPtr == 0) ? null : new SWIGTYPE_p_f_p_struct_AVFormatContext_p_struct_AVPacket_p_struct_AVPacket_int__int(cPtr, false);
  }

  public void setCodec_tag(SWIGTYPE_p_p_AVCodecTag value) {
    ffmpegJNI.AVOutputFormat_codec_tag_set(swigCPtr, this, SWIGTYPE_p_p_AVCodecTag.getCPtr(value));
  }

  public SWIGTYPE_p_p_AVCodecTag getCodec_tag() {
    long cPtr = ffmpegJNI.AVOutputFormat_codec_tag_get(swigCPtr, this);
    return (cPtr == 0) ? null : new SWIGTYPE_p_p_AVCodecTag(cPtr, false);
  }

  public void setSubtitle_codec(CodecID value) {
    ffmpegJNI.AVOutputFormat_subtitle_codec_set(swigCPtr, this, value.swigValue());
  }

  public CodecID getSubtitle_codec() {
    return CodecID.swigToEnum(ffmpegJNI.AVOutputFormat_subtitle_codec_get(swigCPtr, this));
  }

  public void setPriv_class(SWIGTYPE_p_AVClass value) {
    ffmpegJNI.AVOutputFormat_priv_class_set(swigCPtr, this, SWIGTYPE_p_AVClass.getCPtr(value));
  }

  public SWIGTYPE_p_AVClass getPriv_class() {
    long cPtr = ffmpegJNI.AVOutputFormat_priv_class_get(swigCPtr, this);
    return (cPtr == 0) ? null : new SWIGTYPE_p_AVClass(cPtr, false);
  }

  public void setQuery_codec(SWIGTYPE_p_f_enum_CodecID_int__int value) {
    ffmpegJNI.AVOutputFormat_query_codec_set(swigCPtr, this, SWIGTYPE_p_f_enum_CodecID_int__int.getCPtr(value));
  }

  public SWIGTYPE_p_f_enum_CodecID_int__int getQuery_codec() {
    long cPtr = ffmpegJNI.AVOutputFormat_query_codec_get(swigCPtr, this);
    return (cPtr == 0) ? null : new SWIGTYPE_p_f_enum_CodecID_int__int(cPtr, false);
  }

  public void setGet_output_timestamp(SWIGTYPE_p_f_p_struct_AVFormatContext_int_p_long_long_p_long_long__void value) {
    ffmpegJNI.AVOutputFormat_get_output_timestamp_set(swigCPtr, this, SWIGTYPE_p_f_p_struct_AVFormatContext_int_p_long_long_p_long_long__void.getCPtr(value));
  }

  public SWIGTYPE_p_f_p_struct_AVFormatContext_int_p_long_long_p_long_long__void getGet_output_timestamp() {
    long cPtr = ffmpegJNI.AVOutputFormat_get_output_timestamp_get(swigCPtr, this);
    return (cPtr == 0) ? null : new SWIGTYPE_p_f_p_struct_AVFormatContext_int_p_long_long_p_long_long__void(cPtr, false);
  }

  public void setNext(AVOutputFormat value) {
    ffmpegJNI.AVOutputFormat_next_set(swigCPtr, this, AVOutputFormat.getCPtr(value), value);
  }

  public AVOutputFormat getNext() {
    long cPtr = ffmpegJNI.AVOutputFormat_next_get(swigCPtr, this);
    return (cPtr == 0) ? null : new AVOutputFormat(cPtr, false);
  }

  public AVOutputFormat() {
    this(ffmpegJNI.new_AVOutputFormat(), true);
  }

}