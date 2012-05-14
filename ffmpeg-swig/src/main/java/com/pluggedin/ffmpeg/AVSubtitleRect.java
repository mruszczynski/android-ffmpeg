/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.6
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package com.pluggedin.ffmpeg;

public class AVSubtitleRect {
  private long swigCPtr;
  protected boolean swigCMemOwn;

  protected AVSubtitleRect(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(AVSubtitleRect obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        ffmpegJNI.delete_AVSubtitleRect(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void setX(int value) {
    ffmpegJNI.AVSubtitleRect_x_set(swigCPtr, this, value);
  }

  public int getX() {
    return ffmpegJNI.AVSubtitleRect_x_get(swigCPtr, this);
  }

  public void setY(int value) {
    ffmpegJNI.AVSubtitleRect_y_set(swigCPtr, this, value);
  }

  public int getY() {
    return ffmpegJNI.AVSubtitleRect_y_get(swigCPtr, this);
  }

  public void setW(int value) {
    ffmpegJNI.AVSubtitleRect_w_set(swigCPtr, this, value);
  }

  public int getW() {
    return ffmpegJNI.AVSubtitleRect_w_get(swigCPtr, this);
  }

  public void setH(int value) {
    ffmpegJNI.AVSubtitleRect_h_set(swigCPtr, this, value);
  }

  public int getH() {
    return ffmpegJNI.AVSubtitleRect_h_get(swigCPtr, this);
  }

  public void setNb_colors(int value) {
    ffmpegJNI.AVSubtitleRect_nb_colors_set(swigCPtr, this, value);
  }

  public int getNb_colors() {
    return ffmpegJNI.AVSubtitleRect_nb_colors_get(swigCPtr, this);
  }

  public void setPict(AVPicture value) {
    ffmpegJNI.AVSubtitleRect_pict_set(swigCPtr, this, AVPicture.getCPtr(value), value);
  }

  public AVPicture getPict() {
    long cPtr = ffmpegJNI.AVSubtitleRect_pict_get(swigCPtr, this);
    return (cPtr == 0) ? null : new AVPicture(cPtr, false);
  }

  public void setType(AVSubtitleType value) {
    ffmpegJNI.AVSubtitleRect_type_set(swigCPtr, this, value.swigValue());
  }

  public AVSubtitleType getType() {
    return AVSubtitleType.swigToEnum(ffmpegJNI.AVSubtitleRect_type_get(swigCPtr, this));
  }

  public void setText(String value) {
    ffmpegJNI.AVSubtitleRect_text_set(swigCPtr, this, value);
  }

  public String getText() {
    return ffmpegJNI.AVSubtitleRect_text_get(swigCPtr, this);
  }

  public void setAss(String value) {
    ffmpegJNI.AVSubtitleRect_ass_set(swigCPtr, this, value);
  }

  public String getAss() {
    return ffmpegJNI.AVSubtitleRect_ass_get(swigCPtr, this);
  }

  public AVSubtitleRect() {
    this(ffmpegJNI.new_AVSubtitleRect(), true);
  }

}