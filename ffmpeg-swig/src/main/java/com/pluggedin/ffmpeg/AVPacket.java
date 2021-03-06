/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.6
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package com.pluggedin.ffmpeg;

public class AVPacket {
  private long swigCPtr;
  protected boolean swigCMemOwn;

  protected AVPacket(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(AVPacket obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        ffmpegJNI.delete_AVPacket(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void setPts(long value) {
    ffmpegJNI.AVPacket_pts_set(swigCPtr, this, value);
  }

  public long getPts() {
    return ffmpegJNI.AVPacket_pts_get(swigCPtr, this);
  }

  public void setDts(long value) {
    ffmpegJNI.AVPacket_dts_set(swigCPtr, this, value);
  }

  public long getDts() {
    return ffmpegJNI.AVPacket_dts_get(swigCPtr, this);
  }

  public void setData(SWIGTYPE_p_unsigned_char value) {
    ffmpegJNI.AVPacket_data_set(swigCPtr, this, SWIGTYPE_p_unsigned_char.getCPtr(value));
  }

  public SWIGTYPE_p_unsigned_char getData() {
    long cPtr = ffmpegJNI.AVPacket_data_get(swigCPtr, this);
    return (cPtr == 0) ? null : new SWIGTYPE_p_unsigned_char(cPtr, false);
  }

  public void setSize(int value) {
    ffmpegJNI.AVPacket_size_set(swigCPtr, this, value);
  }

  public int getSize() {
    return ffmpegJNI.AVPacket_size_get(swigCPtr, this);
  }

  public void setStream_index(int value) {
    ffmpegJNI.AVPacket_stream_index_set(swigCPtr, this, value);
  }

  public int getStream_index() {
    return ffmpegJNI.AVPacket_stream_index_get(swigCPtr, this);
  }

  public void setFlags(int value) {
    ffmpegJNI.AVPacket_flags_set(swigCPtr, this, value);
  }

  public int getFlags() {
    return ffmpegJNI.AVPacket_flags_get(swigCPtr, this);
  }

  public void setSide_data_elems(int value) {
    ffmpegJNI.AVPacket_side_data_elems_set(swigCPtr, this, value);
  }

  public int getSide_data_elems() {
    return ffmpegJNI.AVPacket_side_data_elems_get(swigCPtr, this);
  }

  public void setDuration(int value) {
    ffmpegJNI.AVPacket_duration_set(swigCPtr, this, value);
  }

  public int getDuration() {
    return ffmpegJNI.AVPacket_duration_get(swigCPtr, this);
  }

  public void setDestruct(SWIGTYPE_p_f_p_struct_AVPacket__void value) {
    ffmpegJNI.AVPacket_destruct_set(swigCPtr, this, SWIGTYPE_p_f_p_struct_AVPacket__void.getCPtr(value));
  }

  public SWIGTYPE_p_f_p_struct_AVPacket__void getDestruct() {
    long cPtr = ffmpegJNI.AVPacket_destruct_get(swigCPtr, this);
    return (cPtr == 0) ? null : new SWIGTYPE_p_f_p_struct_AVPacket__void(cPtr, false);
  }

  public void setPriv(long value) {
    ffmpegJNI.AVPacket_priv_set(swigCPtr, this, value);
  }

  public long getPriv() {
    return ffmpegJNI.AVPacket_priv_get(swigCPtr, this);
  }

  public void setPos(long value) {
    ffmpegJNI.AVPacket_pos_set(swigCPtr, this, value);
  }

  public long getPos() {
    return ffmpegJNI.AVPacket_pos_get(swigCPtr, this);
  }

  public void setConvergence_duration(long value) {
    ffmpegJNI.AVPacket_convergence_duration_set(swigCPtr, this, value);
  }

  public long getConvergence_duration() {
    return ffmpegJNI.AVPacket_convergence_duration_get(swigCPtr, this);
  }

  public AVPacket_side_data getSide_data() {
    long cPtr = ffmpegJNI.AVPacket_side_data_get(swigCPtr, this);
    return (cPtr == 0) ? null : new AVPacket_side_data(cPtr, false);
  }

  public AVPacket() {
    this(ffmpegJNI.new_AVPacket(), true);
  }

}
