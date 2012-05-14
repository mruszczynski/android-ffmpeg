/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.6
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package com.pluggedin.ffmpeg;

public class AVProfile {
  private long swigCPtr;
  protected boolean swigCMemOwn;

  protected AVProfile(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(AVProfile obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        ffmpegJNI.delete_AVProfile(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void setProfile(int value) {
    ffmpegJNI.AVProfile_profile_set(swigCPtr, this, value);
  }

  public int getProfile() {
    return ffmpegJNI.AVProfile_profile_get(swigCPtr, this);
  }

  public void setName(String value) {
    ffmpegJNI.AVProfile_name_set(swigCPtr, this, value);
  }

  public String getName() {
    return ffmpegJNI.AVProfile_name_get(swigCPtr, this);
  }

  public AVProfile() {
    this(ffmpegJNI.new_AVProfile(), true);
  }

}