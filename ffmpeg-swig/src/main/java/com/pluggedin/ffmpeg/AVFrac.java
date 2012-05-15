/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.6
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package com.pluggedin.ffmpeg;

public class AVFrac {
  private long swigCPtr;
  protected boolean swigCMemOwn;

  protected AVFrac(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(AVFrac obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        ffmpegJNI.delete_AVFrac(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void setVal(SWIGTYPE_p_int64_t value) {
    ffmpegJNI.AVFrac_val_set(swigCPtr, this, SWIGTYPE_p_int64_t.getCPtr(value));
  }

  public SWIGTYPE_p_int64_t getVal() {
    return new SWIGTYPE_p_int64_t(ffmpegJNI.AVFrac_val_get(swigCPtr, this), true);
  }

  public void setNum(SWIGTYPE_p_int64_t value) {
    ffmpegJNI.AVFrac_num_set(swigCPtr, this, SWIGTYPE_p_int64_t.getCPtr(value));
  }

  public SWIGTYPE_p_int64_t getNum() {
    return new SWIGTYPE_p_int64_t(ffmpegJNI.AVFrac_num_get(swigCPtr, this), true);
  }

  public void setDen(SWIGTYPE_p_int64_t value) {
    ffmpegJNI.AVFrac_den_set(swigCPtr, this, SWIGTYPE_p_int64_t.getCPtr(value));
  }

  public SWIGTYPE_p_int64_t getDen() {
    return new SWIGTYPE_p_int64_t(ffmpegJNI.AVFrac_den_get(swigCPtr, this), true);
  }

  public AVFrac() {
    this(ffmpegJNI.new_AVFrac(), true);
  }

}
