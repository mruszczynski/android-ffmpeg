/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.6
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package com.pluggedin.ffmpeg;

public class AVFilterBuffer {
  private long swigCPtr;
  protected boolean swigCMemOwn;

  protected AVFilterBuffer(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(AVFilterBuffer obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        ffmpegJNI.delete_AVFilterBuffer(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void setData(SWIGTYPE_p_p_uint8_t value) {
    ffmpegJNI.AVFilterBuffer_data_set(swigCPtr, this, SWIGTYPE_p_p_uint8_t.getCPtr(value));
  }

  public SWIGTYPE_p_p_uint8_t getData() {
    long cPtr = ffmpegJNI.AVFilterBuffer_data_get(swigCPtr, this);
    return (cPtr == 0) ? null : new SWIGTYPE_p_p_uint8_t(cPtr, false);
  }

  public void setLinesize(SWIGTYPE_p_int value) {
    ffmpegJNI.AVFilterBuffer_linesize_set(swigCPtr, this, SWIGTYPE_p_int.getCPtr(value));
  }

  public SWIGTYPE_p_int getLinesize() {
    long cPtr = ffmpegJNI.AVFilterBuffer_linesize_get(swigCPtr, this);
    return (cPtr == 0) ? null : new SWIGTYPE_p_int(cPtr, false);
  }

  public void setRefcount(long value) {
    ffmpegJNI.AVFilterBuffer_refcount_set(swigCPtr, this, value);
  }

  public long getRefcount() {
    return ffmpegJNI.AVFilterBuffer_refcount_get(swigCPtr, this);
  }

  public void setPriv(long value) {
    ffmpegJNI.AVFilterBuffer_priv_set(swigCPtr, this, value);
  }

  public long getPriv() {
    return ffmpegJNI.AVFilterBuffer_priv_get(swigCPtr, this);
  }

  public void setFree(SWIGTYPE_p_f_p_struct_AVFilterBuffer__void value) {
    ffmpegJNI.AVFilterBuffer_free_set(swigCPtr, this, SWIGTYPE_p_f_p_struct_AVFilterBuffer__void.getCPtr(value));
  }

  public SWIGTYPE_p_f_p_struct_AVFilterBuffer__void getFree() {
    long cPtr = ffmpegJNI.AVFilterBuffer_free_get(swigCPtr, this);
    return (cPtr == 0) ? null : new SWIGTYPE_p_f_p_struct_AVFilterBuffer__void(cPtr, false);
  }

  public void setFormat(int value) {
    ffmpegJNI.AVFilterBuffer_format_set(swigCPtr, this, value);
  }

  public int getFormat() {
    return ffmpegJNI.AVFilterBuffer_format_get(swigCPtr, this);
  }

  public void setW(int value) {
    ffmpegJNI.AVFilterBuffer_w_set(swigCPtr, this, value);
  }

  public int getW() {
    return ffmpegJNI.AVFilterBuffer_w_get(swigCPtr, this);
  }

  public void setH(int value) {
    ffmpegJNI.AVFilterBuffer_h_set(swigCPtr, this, value);
  }

  public int getH() {
    return ffmpegJNI.AVFilterBuffer_h_get(swigCPtr, this);
  }

  public AVFilterBuffer() {
    this(ffmpegJNI.new_AVFilterBuffer(), true);
  }

}
