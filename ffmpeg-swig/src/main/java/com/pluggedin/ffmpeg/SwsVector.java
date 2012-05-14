/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.6
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package com.pluggedin.ffmpeg;

public class SwsVector {
  private long swigCPtr;
  protected boolean swigCMemOwn;

  protected SwsVector(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(SwsVector obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        ffmpegJNI.delete_SwsVector(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void setCoeff(SWIGTYPE_p_double value) {
    ffmpegJNI.SwsVector_coeff_set(swigCPtr, this, SWIGTYPE_p_double.getCPtr(value));
  }

  public SWIGTYPE_p_double getCoeff() {
    long cPtr = ffmpegJNI.SwsVector_coeff_get(swigCPtr, this);
    return (cPtr == 0) ? null : new SWIGTYPE_p_double(cPtr, false);
  }

  public void setLength(int value) {
    ffmpegJNI.SwsVector_length_set(swigCPtr, this, value);
  }

  public int getLength() {
    return ffmpegJNI.SwsVector_length_get(swigCPtr, this);
  }

  public SwsVector() {
    this(ffmpegJNI.new_SwsVector(), true);
  }

}