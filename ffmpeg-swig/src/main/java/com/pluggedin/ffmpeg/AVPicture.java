/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.6
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package com.pluggedin.ffmpeg;

public class AVPicture {
  private long swigCPtr;
  protected boolean swigCMemOwn;

  protected AVPicture(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(AVPicture obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        ffmpegJNI.delete_AVPicture(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void setData(SWIGTYPE_p_p_unsigned_char value) {
    ffmpegJNI.AVPicture_data_set(swigCPtr, this, SWIGTYPE_p_p_unsigned_char.getCPtr(value));
  }

  public SWIGTYPE_p_p_unsigned_char getData() {
    long cPtr = ffmpegJNI.AVPicture_data_get(swigCPtr, this);
    return (cPtr == 0) ? null : new SWIGTYPE_p_p_unsigned_char(cPtr, false);
  }

  public void setLinesize(SWIGTYPE_p_int value) {
    ffmpegJNI.AVPicture_linesize_set(swigCPtr, this, SWIGTYPE_p_int.getCPtr(value));
  }

  public SWIGTYPE_p_int getLinesize() {
    long cPtr = ffmpegJNI.AVPicture_linesize_get(swigCPtr, this);
    return (cPtr == 0) ? null : new SWIGTYPE_p_int(cPtr, false);
  }

  public AVPicture() {
    this(ffmpegJNI.new_AVPicture(), true);
  }

}
