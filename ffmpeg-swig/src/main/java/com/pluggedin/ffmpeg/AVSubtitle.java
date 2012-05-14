/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.6
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package com.pluggedin.ffmpeg;

public class AVSubtitle {
  private long swigCPtr;
  protected boolean swigCMemOwn;

  protected AVSubtitle(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(AVSubtitle obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        ffmpegJNI.delete_AVSubtitle(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void setFormat(int value) {
    ffmpegJNI.AVSubtitle_format_set(swigCPtr, this, value);
  }

  public int getFormat() {
    return ffmpegJNI.AVSubtitle_format_get(swigCPtr, this);
  }

  public void setStart_display_time(long value) {
    ffmpegJNI.AVSubtitle_start_display_time_set(swigCPtr, this, value);
  }

  public long getStart_display_time() {
    return ffmpegJNI.AVSubtitle_start_display_time_get(swigCPtr, this);
  }

  public void setEnd_display_time(long value) {
    ffmpegJNI.AVSubtitle_end_display_time_set(swigCPtr, this, value);
  }

  public long getEnd_display_time() {
    return ffmpegJNI.AVSubtitle_end_display_time_get(swigCPtr, this);
  }

  public void setNum_rects(long value) {
    ffmpegJNI.AVSubtitle_num_rects_set(swigCPtr, this, value);
  }

  public long getNum_rects() {
    return ffmpegJNI.AVSubtitle_num_rects_get(swigCPtr, this);
  }

  public void setRects(SWIGTYPE_p_p_AVSubtitleRect value) {
    ffmpegJNI.AVSubtitle_rects_set(swigCPtr, this, SWIGTYPE_p_p_AVSubtitleRect.getCPtr(value));
  }

  public SWIGTYPE_p_p_AVSubtitleRect getRects() {
    long cPtr = ffmpegJNI.AVSubtitle_rects_get(swigCPtr, this);
    return (cPtr == 0) ? null : new SWIGTYPE_p_p_AVSubtitleRect(cPtr, false);
  }

  public void setPts(long value) {
    ffmpegJNI.AVSubtitle_pts_set(swigCPtr, this, value);
  }

  public long getPts() {
    return ffmpegJNI.AVSubtitle_pts_get(swigCPtr, this);
  }

  public AVSubtitle() {
    this(ffmpegJNI.new_AVSubtitle(), true);
  }

}
