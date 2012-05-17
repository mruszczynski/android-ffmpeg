/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.6
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package com.pluggedin.ffmpeg;

public class AVFrame {
  private long swigCPtr;
  protected boolean swigCMemOwn;

  protected AVFrame(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  public static long getCPtr(AVFrame obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        ffmpegJNI.delete_AVFrame(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void setData(SWIGTYPE_p_p_unsigned_char value) {
    ffmpegJNI.AVFrame_data_set(swigCPtr, this, SWIGTYPE_p_p_unsigned_char.getCPtr(value));
  }

  public SWIGTYPE_p_p_unsigned_char getData() {
    long cPtr = ffmpegJNI.AVFrame_data_get(swigCPtr, this);
    return (cPtr == 0) ? null : new SWIGTYPE_p_p_unsigned_char(cPtr, false);
  }

  public void setLinesize(SWIGTYPE_p_int value) {
    ffmpegJNI.AVFrame_linesize_set(swigCPtr, this, SWIGTYPE_p_int.getCPtr(value));
  }

  public SWIGTYPE_p_int getLinesize() {
    long cPtr = ffmpegJNI.AVFrame_linesize_get(swigCPtr, this);
    return (cPtr == 0) ? null : new SWIGTYPE_p_int(cPtr, false);
  }

  public void setBase(SWIGTYPE_p_p_unsigned_char value) {
    ffmpegJNI.AVFrame_base_set(swigCPtr, this, SWIGTYPE_p_p_unsigned_char.getCPtr(value));
  }

  public SWIGTYPE_p_p_unsigned_char getBase() {
    long cPtr = ffmpegJNI.AVFrame_base_get(swigCPtr, this);
    return (cPtr == 0) ? null : new SWIGTYPE_p_p_unsigned_char(cPtr, false);
  }

  public void setKey_frame(int value) {
    ffmpegJNI.AVFrame_key_frame_set(swigCPtr, this, value);
  }

  public int getKey_frame() {
    return ffmpegJNI.AVFrame_key_frame_get(swigCPtr, this);
  }

  public void setPict_type(AVPictureType value) {
    ffmpegJNI.AVFrame_pict_type_set(swigCPtr, this, value.swigValue());
  }

  public AVPictureType getPict_type() {
    return AVPictureType.swigToEnum(ffmpegJNI.AVFrame_pict_type_get(swigCPtr, this));
  }

  public void setPts(long value) {
    ffmpegJNI.AVFrame_pts_set(swigCPtr, this, value);
  }

  public long getPts() {
    return ffmpegJNI.AVFrame_pts_get(swigCPtr, this);
  }

  public void setCoded_picture_number(int value) {
    ffmpegJNI.AVFrame_coded_picture_number_set(swigCPtr, this, value);
  }

  public int getCoded_picture_number() {
    return ffmpegJNI.AVFrame_coded_picture_number_get(swigCPtr, this);
  }

  public void setDisplay_picture_number(int value) {
    ffmpegJNI.AVFrame_display_picture_number_set(swigCPtr, this, value);
  }

  public int getDisplay_picture_number() {
    return ffmpegJNI.AVFrame_display_picture_number_get(swigCPtr, this);
  }

  public void setQuality(int value) {
    ffmpegJNI.AVFrame_quality_set(swigCPtr, this, value);
  }

  public int getQuality() {
    return ffmpegJNI.AVFrame_quality_get(swigCPtr, this);
  }

  public void setAge(int value) {
    ffmpegJNI.AVFrame_age_set(swigCPtr, this, value);
  }

  public int getAge() {
    return ffmpegJNI.AVFrame_age_get(swigCPtr, this);
  }

  public void setReference(int value) {
    ffmpegJNI.AVFrame_reference_set(swigCPtr, this, value);
  }

  public int getReference() {
    return ffmpegJNI.AVFrame_reference_get(swigCPtr, this);
  }

  public void setQscale_table(SWIGTYPE_p_signed_char value) {
    ffmpegJNI.AVFrame_qscale_table_set(swigCPtr, this, SWIGTYPE_p_signed_char.getCPtr(value));
  }

  public SWIGTYPE_p_signed_char getQscale_table() {
    long cPtr = ffmpegJNI.AVFrame_qscale_table_get(swigCPtr, this);
    return (cPtr == 0) ? null : new SWIGTYPE_p_signed_char(cPtr, false);
  }

  public void setQstride(int value) {
    ffmpegJNI.AVFrame_qstride_set(swigCPtr, this, value);
  }

  public int getQstride() {
    return ffmpegJNI.AVFrame_qstride_get(swigCPtr, this);
  }

  public void setMbskip_table(SWIGTYPE_p_unsigned_char value) {
    ffmpegJNI.AVFrame_mbskip_table_set(swigCPtr, this, SWIGTYPE_p_unsigned_char.getCPtr(value));
  }

  public SWIGTYPE_p_unsigned_char getMbskip_table() {
    long cPtr = ffmpegJNI.AVFrame_mbskip_table_get(swigCPtr, this);
    return (cPtr == 0) ? null : new SWIGTYPE_p_unsigned_char(cPtr, false);
  }

  public void setMb_type(SWIGTYPE_p_unsigned_int value) {
    ffmpegJNI.AVFrame_mb_type_set(swigCPtr, this, SWIGTYPE_p_unsigned_int.getCPtr(value));
  }

  public SWIGTYPE_p_unsigned_int getMb_type() {
    long cPtr = ffmpegJNI.AVFrame_mb_type_get(swigCPtr, this);
    return (cPtr == 0) ? null : new SWIGTYPE_p_unsigned_int(cPtr, false);
  }

  public void setMotion_subsample_log2(byte value) {
    ffmpegJNI.AVFrame_motion_subsample_log2_set(swigCPtr, this, value);
  }

  public byte getMotion_subsample_log2() {
    return ffmpegJNI.AVFrame_motion_subsample_log2_get(swigCPtr, this);
  }

  public void setOpaque(long value) {
    ffmpegJNI.AVFrame_opaque_set(swigCPtr, this, value);
  }

  public long getOpaque() {
    return ffmpegJNI.AVFrame_opaque_get(swigCPtr, this);
  }

  public void setError(SWIGTYPE_p_unsigned_long_long value) {
    ffmpegJNI.AVFrame_error_set(swigCPtr, this, SWIGTYPE_p_unsigned_long_long.getCPtr(value));
  }

  public SWIGTYPE_p_unsigned_long_long getError() {
    long cPtr = ffmpegJNI.AVFrame_error_get(swigCPtr, this);
    return (cPtr == 0) ? null : new SWIGTYPE_p_unsigned_long_long(cPtr, false);
  }

  public void setType(int value) {
    ffmpegJNI.AVFrame_type_set(swigCPtr, this, value);
  }

  public int getType() {
    return ffmpegJNI.AVFrame_type_get(swigCPtr, this);
  }

  public void setRepeat_pict(int value) {
    ffmpegJNI.AVFrame_repeat_pict_set(swigCPtr, this, value);
  }

  public int getRepeat_pict() {
    return ffmpegJNI.AVFrame_repeat_pict_get(swigCPtr, this);
  }

  public void setQscale_type(int value) {
    ffmpegJNI.AVFrame_qscale_type_set(swigCPtr, this, value);
  }

  public int getQscale_type() {
    return ffmpegJNI.AVFrame_qscale_type_get(swigCPtr, this);
  }

  public void setInterlaced_frame(int value) {
    ffmpegJNI.AVFrame_interlaced_frame_set(swigCPtr, this, value);
  }

  public int getInterlaced_frame() {
    return ffmpegJNI.AVFrame_interlaced_frame_get(swigCPtr, this);
  }

  public void setTop_field_first(int value) {
    ffmpegJNI.AVFrame_top_field_first_set(swigCPtr, this, value);
  }

  public int getTop_field_first() {
    return ffmpegJNI.AVFrame_top_field_first_get(swigCPtr, this);
  }

  public void setPan_scan(AVPanScan value) {
    ffmpegJNI.AVFrame_pan_scan_set(swigCPtr, this, AVPanScan.getCPtr(value), value);
  }

  public AVPanScan getPan_scan() {
    long cPtr = ffmpegJNI.AVFrame_pan_scan_get(swigCPtr, this);
    return (cPtr == 0) ? null : new AVPanScan(cPtr, false);
  }

  public void setPalette_has_changed(int value) {
    ffmpegJNI.AVFrame_palette_has_changed_set(swigCPtr, this, value);
  }

  public int getPalette_has_changed() {
    return ffmpegJNI.AVFrame_palette_has_changed_get(swigCPtr, this);
  }

  public void setBuffer_hints(int value) {
    ffmpegJNI.AVFrame_buffer_hints_set(swigCPtr, this, value);
  }

  public int getBuffer_hints() {
    return ffmpegJNI.AVFrame_buffer_hints_get(swigCPtr, this);
  }

  public void setDct_coeff(SWIGTYPE_p_short value) {
    ffmpegJNI.AVFrame_dct_coeff_set(swigCPtr, this, SWIGTYPE_p_short.getCPtr(value));
  }

  public SWIGTYPE_p_short getDct_coeff() {
    long cPtr = ffmpegJNI.AVFrame_dct_coeff_get(swigCPtr, this);
    return (cPtr == 0) ? null : new SWIGTYPE_p_short(cPtr, false);
  }

  public void setRef_index(SWIGTYPE_p_p_signed_char value) {
    ffmpegJNI.AVFrame_ref_index_set(swigCPtr, this, SWIGTYPE_p_p_signed_char.getCPtr(value));
  }

  public SWIGTYPE_p_p_signed_char getRef_index() {
    long cPtr = ffmpegJNI.AVFrame_ref_index_get(swigCPtr, this);
    return (cPtr == 0) ? null : new SWIGTYPE_p_p_signed_char(cPtr, false);
  }

  public void setReordered_opaque(long value) {
    ffmpegJNI.AVFrame_reordered_opaque_set(swigCPtr, this, value);
  }

  public long getReordered_opaque() {
    return ffmpegJNI.AVFrame_reordered_opaque_get(swigCPtr, this);
  }

  public void setHwaccel_picture_private(long value) {
    ffmpegJNI.AVFrame_hwaccel_picture_private_set(swigCPtr, this, value);
  }

  public long getHwaccel_picture_private() {
    return ffmpegJNI.AVFrame_hwaccel_picture_private_get(swigCPtr, this);
  }

  public void setPkt_pts(long value) {
    ffmpegJNI.AVFrame_pkt_pts_set(swigCPtr, this, value);
  }

  public long getPkt_pts() {
    return ffmpegJNI.AVFrame_pkt_pts_get(swigCPtr, this);
  }

  public void setPkt_dts(long value) {
    ffmpegJNI.AVFrame_pkt_dts_set(swigCPtr, this, value);
  }

  public long getPkt_dts() {
    return ffmpegJNI.AVFrame_pkt_dts_get(swigCPtr, this);
  }

  public void setOwner(AVCodecContext value) {
    ffmpegJNI.AVFrame_owner_set(swigCPtr, this, AVCodecContext.getCPtr(value), value);
  }

  public AVCodecContext getOwner() {
    long cPtr = ffmpegJNI.AVFrame_owner_get(swigCPtr, this);
    return (cPtr == 0) ? null : new AVCodecContext(cPtr, false);
  }

  public void setThread_opaque(long value) {
    ffmpegJNI.AVFrame_thread_opaque_set(swigCPtr, this, value);
  }

  public long getThread_opaque() {
    return ffmpegJNI.AVFrame_thread_opaque_get(swigCPtr, this);
  }

  public void setNb_samples(int value) {
    ffmpegJNI.AVFrame_nb_samples_set(swigCPtr, this, value);
  }

  public int getNb_samples() {
    return ffmpegJNI.AVFrame_nb_samples_get(swigCPtr, this);
  }

  public void setExtended_data(SWIGTYPE_p_p_unsigned_char value) {
    ffmpegJNI.AVFrame_extended_data_set(swigCPtr, this, SWIGTYPE_p_p_unsigned_char.getCPtr(value));
  }

  public SWIGTYPE_p_p_unsigned_char getExtended_data() {
    long cPtr = ffmpegJNI.AVFrame_extended_data_get(swigCPtr, this);
    return (cPtr == 0) ? null : new SWIGTYPE_p_p_unsigned_char(cPtr, false);
  }

  public void setBest_effort_timestamp(long value) {
    ffmpegJNI.AVFrame_best_effort_timestamp_set(swigCPtr, this, value);
  }

  public long getBest_effort_timestamp() {
    return ffmpegJNI.AVFrame_best_effort_timestamp_get(swigCPtr, this);
  }

  public void setPkt_pos(long value) {
    ffmpegJNI.AVFrame_pkt_pos_set(swigCPtr, this, value);
  }

  public long getPkt_pos() {
    return ffmpegJNI.AVFrame_pkt_pos_get(swigCPtr, this);
  }

  public void setSample_aspect_ratio(AVRational value) {
    ffmpegJNI.AVFrame_sample_aspect_ratio_set(swigCPtr, this, AVRational.getCPtr(value), value);
  }

  public AVRational getSample_aspect_ratio() {
    long cPtr = ffmpegJNI.AVFrame_sample_aspect_ratio_get(swigCPtr, this);
    return (cPtr == 0) ? null : new AVRational(cPtr, false);
  }

  public void setWidth(int value) {
    ffmpegJNI.AVFrame_width_set(swigCPtr, this, value);
  }

  public int getWidth() {
    return ffmpegJNI.AVFrame_width_get(swigCPtr, this);
  }

  public void setHeight(int value) {
    ffmpegJNI.AVFrame_height_set(swigCPtr, this, value);
  }

  public int getHeight() {
    return ffmpegJNI.AVFrame_height_get(swigCPtr, this);
  }

  public void setFormat(int value) {
    ffmpegJNI.AVFrame_format_set(swigCPtr, this, value);
  }

  public int getFormat() {
    return ffmpegJNI.AVFrame_format_get(swigCPtr, this);
  }

  public AVFrame() {
    this(ffmpegJNI.new_AVFrame(), true);
  }

}
