/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.6
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package com.pluggedin.ffmpeg;

public class AVCodecParserContext {
  private long swigCPtr;
  protected boolean swigCMemOwn;

  protected AVCodecParserContext(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(AVCodecParserContext obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        ffmpegJNI.delete_AVCodecParserContext(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void setPriv_data(long value) {
    ffmpegJNI.AVCodecParserContext_priv_data_set(swigCPtr, this, value);
  }

  public long getPriv_data() {
    return ffmpegJNI.AVCodecParserContext_priv_data_get(swigCPtr, this);
  }

  public void setParser(AVCodecParser value) {
    ffmpegJNI.AVCodecParserContext_parser_set(swigCPtr, this, AVCodecParser.getCPtr(value), value);
  }

  public AVCodecParser getParser() {
    long cPtr = ffmpegJNI.AVCodecParserContext_parser_get(swigCPtr, this);
    return (cPtr == 0) ? null : new AVCodecParser(cPtr, false);
  }

  public void setFrame_offset(SWIGTYPE_p_int64_t value) {
    ffmpegJNI.AVCodecParserContext_frame_offset_set(swigCPtr, this, SWIGTYPE_p_int64_t.getCPtr(value));
  }

  public SWIGTYPE_p_int64_t getFrame_offset() {
    return new SWIGTYPE_p_int64_t(ffmpegJNI.AVCodecParserContext_frame_offset_get(swigCPtr, this), true);
  }

  public void setCur_offset(SWIGTYPE_p_int64_t value) {
    ffmpegJNI.AVCodecParserContext_cur_offset_set(swigCPtr, this, SWIGTYPE_p_int64_t.getCPtr(value));
  }

  public SWIGTYPE_p_int64_t getCur_offset() {
    return new SWIGTYPE_p_int64_t(ffmpegJNI.AVCodecParserContext_cur_offset_get(swigCPtr, this), true);
  }

  public void setNext_frame_offset(SWIGTYPE_p_int64_t value) {
    ffmpegJNI.AVCodecParserContext_next_frame_offset_set(swigCPtr, this, SWIGTYPE_p_int64_t.getCPtr(value));
  }

  public SWIGTYPE_p_int64_t getNext_frame_offset() {
    return new SWIGTYPE_p_int64_t(ffmpegJNI.AVCodecParserContext_next_frame_offset_get(swigCPtr, this), true);
  }

  public void setPict_type(int value) {
    ffmpegJNI.AVCodecParserContext_pict_type_set(swigCPtr, this, value);
  }

  public int getPict_type() {
    return ffmpegJNI.AVCodecParserContext_pict_type_get(swigCPtr, this);
  }

  public void setRepeat_pict(int value) {
    ffmpegJNI.AVCodecParserContext_repeat_pict_set(swigCPtr, this, value);
  }

  public int getRepeat_pict() {
    return ffmpegJNI.AVCodecParserContext_repeat_pict_get(swigCPtr, this);
  }

  public void setPts(SWIGTYPE_p_int64_t value) {
    ffmpegJNI.AVCodecParserContext_pts_set(swigCPtr, this, SWIGTYPE_p_int64_t.getCPtr(value));
  }

  public SWIGTYPE_p_int64_t getPts() {
    return new SWIGTYPE_p_int64_t(ffmpegJNI.AVCodecParserContext_pts_get(swigCPtr, this), true);
  }

  public void setDts(SWIGTYPE_p_int64_t value) {
    ffmpegJNI.AVCodecParserContext_dts_set(swigCPtr, this, SWIGTYPE_p_int64_t.getCPtr(value));
  }

  public SWIGTYPE_p_int64_t getDts() {
    return new SWIGTYPE_p_int64_t(ffmpegJNI.AVCodecParserContext_dts_get(swigCPtr, this), true);
  }

  public void setLast_pts(SWIGTYPE_p_int64_t value) {
    ffmpegJNI.AVCodecParserContext_last_pts_set(swigCPtr, this, SWIGTYPE_p_int64_t.getCPtr(value));
  }

  public SWIGTYPE_p_int64_t getLast_pts() {
    return new SWIGTYPE_p_int64_t(ffmpegJNI.AVCodecParserContext_last_pts_get(swigCPtr, this), true);
  }

  public void setLast_dts(SWIGTYPE_p_int64_t value) {
    ffmpegJNI.AVCodecParserContext_last_dts_set(swigCPtr, this, SWIGTYPE_p_int64_t.getCPtr(value));
  }

  public SWIGTYPE_p_int64_t getLast_dts() {
    return new SWIGTYPE_p_int64_t(ffmpegJNI.AVCodecParserContext_last_dts_get(swigCPtr, this), true);
  }

  public void setFetch_timestamp(int value) {
    ffmpegJNI.AVCodecParserContext_fetch_timestamp_set(swigCPtr, this, value);
  }

  public int getFetch_timestamp() {
    return ffmpegJNI.AVCodecParserContext_fetch_timestamp_get(swigCPtr, this);
  }

  public void setCur_frame_start_index(int value) {
    ffmpegJNI.AVCodecParserContext_cur_frame_start_index_set(swigCPtr, this, value);
  }

  public int getCur_frame_start_index() {
    return ffmpegJNI.AVCodecParserContext_cur_frame_start_index_get(swigCPtr, this);
  }

  public void setCur_frame_offset(SWIGTYPE_p_int64_t value) {
    ffmpegJNI.AVCodecParserContext_cur_frame_offset_set(swigCPtr, this, SWIGTYPE_p_int64_t.getCPtr(value));
  }

  public SWIGTYPE_p_int64_t getCur_frame_offset() {
    long cPtr = ffmpegJNI.AVCodecParserContext_cur_frame_offset_get(swigCPtr, this);
    return (cPtr == 0) ? null : new SWIGTYPE_p_int64_t(cPtr, false);
  }

  public void setCur_frame_pts(SWIGTYPE_p_int64_t value) {
    ffmpegJNI.AVCodecParserContext_cur_frame_pts_set(swigCPtr, this, SWIGTYPE_p_int64_t.getCPtr(value));
  }

  public SWIGTYPE_p_int64_t getCur_frame_pts() {
    long cPtr = ffmpegJNI.AVCodecParserContext_cur_frame_pts_get(swigCPtr, this);
    return (cPtr == 0) ? null : new SWIGTYPE_p_int64_t(cPtr, false);
  }

  public void setCur_frame_dts(SWIGTYPE_p_int64_t value) {
    ffmpegJNI.AVCodecParserContext_cur_frame_dts_set(swigCPtr, this, SWIGTYPE_p_int64_t.getCPtr(value));
  }

  public SWIGTYPE_p_int64_t getCur_frame_dts() {
    long cPtr = ffmpegJNI.AVCodecParserContext_cur_frame_dts_get(swigCPtr, this);
    return (cPtr == 0) ? null : new SWIGTYPE_p_int64_t(cPtr, false);
  }

  public void setFlags(int value) {
    ffmpegJNI.AVCodecParserContext_flags_set(swigCPtr, this, value);
  }

  public int getFlags() {
    return ffmpegJNI.AVCodecParserContext_flags_get(swigCPtr, this);
  }

  public void setOffset(SWIGTYPE_p_int64_t value) {
    ffmpegJNI.AVCodecParserContext_offset_set(swigCPtr, this, SWIGTYPE_p_int64_t.getCPtr(value));
  }

  public SWIGTYPE_p_int64_t getOffset() {
    return new SWIGTYPE_p_int64_t(ffmpegJNI.AVCodecParserContext_offset_get(swigCPtr, this), true);
  }

  public void setCur_frame_end(SWIGTYPE_p_int64_t value) {
    ffmpegJNI.AVCodecParserContext_cur_frame_end_set(swigCPtr, this, SWIGTYPE_p_int64_t.getCPtr(value));
  }

  public SWIGTYPE_p_int64_t getCur_frame_end() {
    long cPtr = ffmpegJNI.AVCodecParserContext_cur_frame_end_get(swigCPtr, this);
    return (cPtr == 0) ? null : new SWIGTYPE_p_int64_t(cPtr, false);
  }

  public void setKey_frame(int value) {
    ffmpegJNI.AVCodecParserContext_key_frame_set(swigCPtr, this, value);
  }

  public int getKey_frame() {
    return ffmpegJNI.AVCodecParserContext_key_frame_get(swigCPtr, this);
  }

  public void setConvergence_duration(SWIGTYPE_p_int64_t value) {
    ffmpegJNI.AVCodecParserContext_convergence_duration_set(swigCPtr, this, SWIGTYPE_p_int64_t.getCPtr(value));
  }

  public SWIGTYPE_p_int64_t getConvergence_duration() {
    return new SWIGTYPE_p_int64_t(ffmpegJNI.AVCodecParserContext_convergence_duration_get(swigCPtr, this), true);
  }

  public void setDts_sync_point(int value) {
    ffmpegJNI.AVCodecParserContext_dts_sync_point_set(swigCPtr, this, value);
  }

  public int getDts_sync_point() {
    return ffmpegJNI.AVCodecParserContext_dts_sync_point_get(swigCPtr, this);
  }

  public void setDts_ref_dts_delta(int value) {
    ffmpegJNI.AVCodecParserContext_dts_ref_dts_delta_set(swigCPtr, this, value);
  }

  public int getDts_ref_dts_delta() {
    return ffmpegJNI.AVCodecParserContext_dts_ref_dts_delta_get(swigCPtr, this);
  }

  public void setPts_dts_delta(int value) {
    ffmpegJNI.AVCodecParserContext_pts_dts_delta_set(swigCPtr, this, value);
  }

  public int getPts_dts_delta() {
    return ffmpegJNI.AVCodecParserContext_pts_dts_delta_get(swigCPtr, this);
  }

  public void setCur_frame_pos(SWIGTYPE_p_int64_t value) {
    ffmpegJNI.AVCodecParserContext_cur_frame_pos_set(swigCPtr, this, SWIGTYPE_p_int64_t.getCPtr(value));
  }

  public SWIGTYPE_p_int64_t getCur_frame_pos() {
    long cPtr = ffmpegJNI.AVCodecParserContext_cur_frame_pos_get(swigCPtr, this);
    return (cPtr == 0) ? null : new SWIGTYPE_p_int64_t(cPtr, false);
  }

  public void setPos(SWIGTYPE_p_int64_t value) {
    ffmpegJNI.AVCodecParserContext_pos_set(swigCPtr, this, SWIGTYPE_p_int64_t.getCPtr(value));
  }

  public SWIGTYPE_p_int64_t getPos() {
    return new SWIGTYPE_p_int64_t(ffmpegJNI.AVCodecParserContext_pos_get(swigCPtr, this), true);
  }

  public void setLast_pos(SWIGTYPE_p_int64_t value) {
    ffmpegJNI.AVCodecParserContext_last_pos_set(swigCPtr, this, SWIGTYPE_p_int64_t.getCPtr(value));
  }

  public SWIGTYPE_p_int64_t getLast_pos() {
    return new SWIGTYPE_p_int64_t(ffmpegJNI.AVCodecParserContext_last_pos_get(swigCPtr, this), true);
  }

  public AVCodecParserContext() {
    this(ffmpegJNI.new_AVCodecParserContext(), true);
  }

}
