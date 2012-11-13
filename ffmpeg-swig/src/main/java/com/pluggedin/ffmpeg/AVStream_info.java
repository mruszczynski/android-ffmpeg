/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.6
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package com.pluggedin.ffmpeg;

public class AVStream_info {
  private long swigCPtr;
  protected boolean swigCMemOwn;

  protected AVStream_info(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(AVStream_info obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        ffmpegJNI.delete_AVStream_info(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void setLast_dts(long value) {
    ffmpegJNI.AVStream_info_last_dts_set(swigCPtr, this, value);
  }

  public long getLast_dts() {
    return ffmpegJNI.AVStream_info_last_dts_get(swigCPtr, this);
  }

  public void setDuration_gcd(long value) {
    ffmpegJNI.AVStream_info_duration_gcd_set(swigCPtr, this, value);
  }

  public long getDuration_gcd() {
    return ffmpegJNI.AVStream_info_duration_gcd_get(swigCPtr, this);
  }

  public void setDuration_count(int value) {
    ffmpegJNI.AVStream_info_duration_count_set(swigCPtr, this, value);
  }

  public int getDuration_count() {
    return ffmpegJNI.AVStream_info_duration_count_get(swigCPtr, this);
  }

  public void setDuration_error(SWIGTYPE_p_a_2__a__60_12_6___double value) {
    ffmpegJNI.AVStream_info_duration_error_set(swigCPtr, this, SWIGTYPE_p_a_2__a__60_12_6___double.getCPtr(value));
  }

  public SWIGTYPE_p_a_2__a__60_12_6___double getDuration_error() {
    long cPtr = ffmpegJNI.AVStream_info_duration_error_get(swigCPtr, this);
    return (cPtr == 0) ? null : new SWIGTYPE_p_a_2__a__60_12_6___double(cPtr, false);
  }

  public void setCodec_info_duration(long value) {
    ffmpegJNI.AVStream_info_codec_info_duration_set(swigCPtr, this, value);
  }

  public long getCodec_info_duration() {
    return ffmpegJNI.AVStream_info_codec_info_duration_get(swigCPtr, this);
  }

  public void setFound_decoder(int value) {
    ffmpegJNI.AVStream_info_found_decoder_set(swigCPtr, this, value);
  }

  public int getFound_decoder() {
    return ffmpegJNI.AVStream_info_found_decoder_get(swigCPtr, this);
  }

  public void setFps_first_dts(long value) {
    ffmpegJNI.AVStream_info_fps_first_dts_set(swigCPtr, this, value);
  }

  public long getFps_first_dts() {
    return ffmpegJNI.AVStream_info_fps_first_dts_get(swigCPtr, this);
  }

  public void setFps_first_dts_idx(int value) {
    ffmpegJNI.AVStream_info_fps_first_dts_idx_set(swigCPtr, this, value);
  }

  public int getFps_first_dts_idx() {
    return ffmpegJNI.AVStream_info_fps_first_dts_idx_get(swigCPtr, this);
  }

  public void setFps_last_dts(long value) {
    ffmpegJNI.AVStream_info_fps_last_dts_set(swigCPtr, this, value);
  }

  public long getFps_last_dts() {
    return ffmpegJNI.AVStream_info_fps_last_dts_get(swigCPtr, this);
  }

  public void setFps_last_dts_idx(int value) {
    ffmpegJNI.AVStream_info_fps_last_dts_idx_set(swigCPtr, this, value);
  }

  public int getFps_last_dts_idx() {
    return ffmpegJNI.AVStream_info_fps_last_dts_idx_get(swigCPtr, this);
  }

  public AVStream_info() {
    this(ffmpegJNI.new_AVStream_info(), true);
  }

}
