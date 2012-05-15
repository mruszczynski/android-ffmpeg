/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.6
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package com.pluggedin.ffmpeg;

public class AVFilterBufferRefVideoProps {
  private long swigCPtr;
  protected boolean swigCMemOwn;

  protected AVFilterBufferRefVideoProps(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(AVFilterBufferRefVideoProps obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        ffmpegJNI.delete_AVFilterBufferRefVideoProps(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void setW(int value) {
    ffmpegJNI.AVFilterBufferRefVideoProps_w_set(swigCPtr, this, value);
  }

  public int getW() {
    return ffmpegJNI.AVFilterBufferRefVideoProps_w_get(swigCPtr, this);
  }

  public void setH(int value) {
    ffmpegJNI.AVFilterBufferRefVideoProps_h_set(swigCPtr, this, value);
  }

  public int getH() {
    return ffmpegJNI.AVFilterBufferRefVideoProps_h_get(swigCPtr, this);
  }

  public void setSample_aspect_ratio(AVRational value) {
    ffmpegJNI.AVFilterBufferRefVideoProps_sample_aspect_ratio_set(swigCPtr, this, AVRational.getCPtr(value), value);
  }

  public AVRational getSample_aspect_ratio() {
    long cPtr = ffmpegJNI.AVFilterBufferRefVideoProps_sample_aspect_ratio_get(swigCPtr, this);
    return (cPtr == 0) ? null : new AVRational(cPtr, false);
  }

  public void setInterlaced(int value) {
    ffmpegJNI.AVFilterBufferRefVideoProps_interlaced_set(swigCPtr, this, value);
  }

  public int getInterlaced() {
    return ffmpegJNI.AVFilterBufferRefVideoProps_interlaced_get(swigCPtr, this);
  }

  public void setTop_field_first(int value) {
    ffmpegJNI.AVFilterBufferRefVideoProps_top_field_first_set(swigCPtr, this, value);
  }

  public int getTop_field_first() {
    return ffmpegJNI.AVFilterBufferRefVideoProps_top_field_first_get(swigCPtr, this);
  }

  public void setPict_type(AVPictureType value) {
    ffmpegJNI.AVFilterBufferRefVideoProps_pict_type_set(swigCPtr, this, value.swigValue());
  }

  public AVPictureType getPict_type() {
    return AVPictureType.swigToEnum(ffmpegJNI.AVFilterBufferRefVideoProps_pict_type_get(swigCPtr, this));
  }

  public void setKey_frame(int value) {
    ffmpegJNI.AVFilterBufferRefVideoProps_key_frame_set(swigCPtr, this, value);
  }

  public int getKey_frame() {
    return ffmpegJNI.AVFilterBufferRefVideoProps_key_frame_get(swigCPtr, this);
  }

  public AVFilterBufferRefVideoProps() {
    this(ffmpegJNI.new_AVFilterBufferRefVideoProps(), true);
  }

}
