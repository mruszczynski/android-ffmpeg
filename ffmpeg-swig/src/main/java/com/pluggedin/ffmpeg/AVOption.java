/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.6
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package com.pluggedin.ffmpeg;

public class AVOption {
  private long swigCPtr;
  protected boolean swigCMemOwn;

  protected AVOption(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(AVOption obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        ffmpegJNI.delete_AVOption(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void setName(byte[] value) {
    ffmpegJNI.AVOption_name_set(swigCPtr, this, value);
  }

  public byte[] getName() {
    return ffmpegJNI.AVOption_name_get(swigCPtr, this);
  }

  public void setHelp(byte[] value) {
    ffmpegJNI.AVOption_help_set(swigCPtr, this, value);
  }

  public byte[] getHelp() {
    return ffmpegJNI.AVOption_help_get(swigCPtr, this);
  }

  public void setOffset(int value) {
    ffmpegJNI.AVOption_offset_set(swigCPtr, this, value);
  }

  public int getOffset() {
    return ffmpegJNI.AVOption_offset_get(swigCPtr, this);
  }

  public void setType(AVOptionType value) {
    ffmpegJNI.AVOption_type_set(swigCPtr, this, value.swigValue());
  }

  public AVOptionType getType() {
    return AVOptionType.swigToEnum(ffmpegJNI.AVOption_type_get(swigCPtr, this));
  }

  public void setMin(double value) {
    ffmpegJNI.AVOption_min_set(swigCPtr, this, value);
  }

  public double getMin() {
    return ffmpegJNI.AVOption_min_get(swigCPtr, this);
  }

  public void setMax(double value) {
    ffmpegJNI.AVOption_max_set(swigCPtr, this, value);
  }

  public double getMax() {
    return ffmpegJNI.AVOption_max_get(swigCPtr, this);
  }

  public void setFlags(int value) {
    ffmpegJNI.AVOption_flags_set(swigCPtr, this, value);
  }

  public int getFlags() {
    return ffmpegJNI.AVOption_flags_get(swigCPtr, this);
  }

  public void setUnit(byte[] value) {
    ffmpegJNI.AVOption_unit_set(swigCPtr, this, value);
  }

  public byte[] getUnit() {
    return ffmpegJNI.AVOption_unit_get(swigCPtr, this);
  }

  public AVOption_default_val getDefault_val() {
    long cPtr = ffmpegJNI.AVOption_default_val_get(swigCPtr, this);
    return (cPtr == 0) ? null : new AVOption_default_val(cPtr, false);
  }

  public AVOption() {
    this(ffmpegJNI.new_AVOption(), true);
  }

}
