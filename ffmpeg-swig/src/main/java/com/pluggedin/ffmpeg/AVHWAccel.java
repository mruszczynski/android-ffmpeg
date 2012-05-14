/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.6
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package com.pluggedin.ffmpeg;

public class AVHWAccel {
  private long swigCPtr;
  protected boolean swigCMemOwn;

  protected AVHWAccel(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(AVHWAccel obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        ffmpegJNI.delete_AVHWAccel(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void setName(String value) {
    ffmpegJNI.AVHWAccel_name_set(swigCPtr, this, value);
  }

  public String getName() {
    return ffmpegJNI.AVHWAccel_name_get(swigCPtr, this);
  }

  public void setType(AVMediaType value) {
    ffmpegJNI.AVHWAccel_type_set(swigCPtr, this, value.swigValue());
  }

  public AVMediaType getType() {
    return AVMediaType.swigToEnum(ffmpegJNI.AVHWAccel_type_get(swigCPtr, this));
  }

  public void setId(CodecID value) {
    ffmpegJNI.AVHWAccel_id_set(swigCPtr, this, value.swigValue());
  }

  public CodecID getId() {
    return CodecID.swigToEnum(ffmpegJNI.AVHWAccel_id_get(swigCPtr, this));
  }

  public void setPix_fmt(int value) {
    ffmpegJNI.AVHWAccel_pix_fmt_set(swigCPtr, this, value);
  }

  public int getPix_fmt() {
    return (ffmpegJNI.AVHWAccel_pix_fmt_get(swigCPtr, this));
  }

  public void setCapabilities(int value) {
    ffmpegJNI.AVHWAccel_capabilities_set(swigCPtr, this, value);
  }

  public int getCapabilities() {
    return ffmpegJNI.AVHWAccel_capabilities_get(swigCPtr, this);
  }

  public void setNext(AVHWAccel value) {
    ffmpegJNI.AVHWAccel_next_set(swigCPtr, this, AVHWAccel.getCPtr(value), value);
  }

  public AVHWAccel getNext() {
    long cPtr = ffmpegJNI.AVHWAccel_next_get(swigCPtr, this);
    return (cPtr == 0) ? null : new AVHWAccel(cPtr, false);
  }

  public void setStart_frame(SWIGTYPE_p_f_p_struct_AVCodecContext_p_q_const__unsigned_char_unsigned_int__int value) {
    ffmpegJNI.AVHWAccel_start_frame_set(swigCPtr, this, SWIGTYPE_p_f_p_struct_AVCodecContext_p_q_const__unsigned_char_unsigned_int__int.getCPtr(value));
  }

  public SWIGTYPE_p_f_p_struct_AVCodecContext_p_q_const__unsigned_char_unsigned_int__int getStart_frame() {
    long cPtr = ffmpegJNI.AVHWAccel_start_frame_get(swigCPtr, this);
    return (cPtr == 0) ? null : new SWIGTYPE_p_f_p_struct_AVCodecContext_p_q_const__unsigned_char_unsigned_int__int(cPtr, false);
  }

  public void setDecode_slice(SWIGTYPE_p_f_p_struct_AVCodecContext_p_q_const__unsigned_char_unsigned_int__int value) {
    ffmpegJNI.AVHWAccel_decode_slice_set(swigCPtr, this, SWIGTYPE_p_f_p_struct_AVCodecContext_p_q_const__unsigned_char_unsigned_int__int.getCPtr(value));
  }

  public SWIGTYPE_p_f_p_struct_AVCodecContext_p_q_const__unsigned_char_unsigned_int__int getDecode_slice() {
    long cPtr = ffmpegJNI.AVHWAccel_decode_slice_get(swigCPtr, this);
    return (cPtr == 0) ? null : new SWIGTYPE_p_f_p_struct_AVCodecContext_p_q_const__unsigned_char_unsigned_int__int(cPtr, false);
  }

  public void setEnd_frame(SWIGTYPE_p_f_p_struct_AVCodecContext__int value) {
    ffmpegJNI.AVHWAccel_end_frame_set(swigCPtr, this, SWIGTYPE_p_f_p_struct_AVCodecContext__int.getCPtr(value));
  }

  public SWIGTYPE_p_f_p_struct_AVCodecContext__int getEnd_frame() {
    long cPtr = ffmpegJNI.AVHWAccel_end_frame_get(swigCPtr, this);
    return (cPtr == 0) ? null : new SWIGTYPE_p_f_p_struct_AVCodecContext__int(cPtr, false);
  }

  public void setPriv_data_size(int value) {
    ffmpegJNI.AVHWAccel_priv_data_size_set(swigCPtr, this, value);
  }

  public int getPriv_data_size() {
    return ffmpegJNI.AVHWAccel_priv_data_size_get(swigCPtr, this);
  }

  public AVHWAccel() {
    this(ffmpegJNI.new_AVHWAccel(), true);
  }

}