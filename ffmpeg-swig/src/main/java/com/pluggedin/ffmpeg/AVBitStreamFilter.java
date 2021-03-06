/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.6
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package com.pluggedin.ffmpeg;

public class AVBitStreamFilter {
  private long swigCPtr;
  protected boolean swigCMemOwn;

  protected AVBitStreamFilter(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(AVBitStreamFilter obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        ffmpegJNI.delete_AVBitStreamFilter(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void setName(String value) {
    ffmpegJNI.AVBitStreamFilter_name_set(swigCPtr, this, value);
  }

  public String getName() {
    return ffmpegJNI.AVBitStreamFilter_name_get(swigCPtr, this);
  }

  public void setPriv_data_size(int value) {
    ffmpegJNI.AVBitStreamFilter_priv_data_size_set(swigCPtr, this, value);
  }

  public int getPriv_data_size() {
    return ffmpegJNI.AVBitStreamFilter_priv_data_size_get(swigCPtr, this);
  }

  public void setClose(SWIGTYPE_p_f_p_struct_AVBitStreamFilterContext__void value) {
    ffmpegJNI.AVBitStreamFilter_close_set(swigCPtr, this, SWIGTYPE_p_f_p_struct_AVBitStreamFilterContext__void.getCPtr(value));
  }

  public SWIGTYPE_p_f_p_struct_AVBitStreamFilterContext__void getClose() {
    long cPtr = ffmpegJNI.AVBitStreamFilter_close_get(swigCPtr, this);
    return (cPtr == 0) ? null : new SWIGTYPE_p_f_p_struct_AVBitStreamFilterContext__void(cPtr, false);
  }

  public void setNext(AVBitStreamFilter value) {
    ffmpegJNI.AVBitStreamFilter_next_set(swigCPtr, this, AVBitStreamFilter.getCPtr(value), value);
  }

  public AVBitStreamFilter getNext() {
    long cPtr = ffmpegJNI.AVBitStreamFilter_next_get(swigCPtr, this);
    return (cPtr == 0) ? null : new AVBitStreamFilter(cPtr, false);
  }

  public AVBitStreamFilter() {
    this(ffmpegJNI.new_AVBitStreamFilter(), true);
  }

}
