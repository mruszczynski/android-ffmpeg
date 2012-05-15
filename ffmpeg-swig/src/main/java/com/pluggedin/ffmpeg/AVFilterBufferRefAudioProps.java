/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.6
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package com.pluggedin.ffmpeg;

public class AVFilterBufferRefAudioProps {
  private long swigCPtr;
  protected boolean swigCMemOwn;

  protected AVFilterBufferRefAudioProps(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(AVFilterBufferRefAudioProps obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        ffmpegJNI.delete_AVFilterBufferRefAudioProps(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void setChannel_layout(SWIGTYPE_p_uint64_t value) {
    ffmpegJNI.AVFilterBufferRefAudioProps_channel_layout_set(swigCPtr, this, SWIGTYPE_p_uint64_t.getCPtr(value));
  }

  public SWIGTYPE_p_uint64_t getChannel_layout() {
    return new SWIGTYPE_p_uint64_t(ffmpegJNI.AVFilterBufferRefAudioProps_channel_layout_get(swigCPtr, this), true);
  }

  public void setNb_samples(int value) {
    ffmpegJNI.AVFilterBufferRefAudioProps_nb_samples_set(swigCPtr, this, value);
  }

  public int getNb_samples() {
    return ffmpegJNI.AVFilterBufferRefAudioProps_nb_samples_get(swigCPtr, this);
  }

  public void setSample_rate(int value) {
    ffmpegJNI.AVFilterBufferRefAudioProps_sample_rate_set(swigCPtr, this, value);
  }

  public int getSample_rate() {
    return ffmpegJNI.AVFilterBufferRefAudioProps_sample_rate_get(swigCPtr, this);
  }

  public void setPlanar(int value) {
    ffmpegJNI.AVFilterBufferRefAudioProps_planar_set(swigCPtr, this, value);
  }

  public int getPlanar() {
    return ffmpegJNI.AVFilterBufferRefAudioProps_planar_get(swigCPtr, this);
  }

  public AVFilterBufferRefAudioProps() {
    this(ffmpegJNI.new_AVFilterBufferRefAudioProps(), true);
  }

}
