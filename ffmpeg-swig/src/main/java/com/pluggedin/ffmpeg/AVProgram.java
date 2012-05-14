/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.6
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package com.pluggedin.ffmpeg;

public class AVProgram {
  private long swigCPtr;
  protected boolean swigCMemOwn;

  protected AVProgram(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(AVProgram obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        ffmpegJNI.delete_AVProgram(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void setId(int value) {
    ffmpegJNI.AVProgram_id_set(swigCPtr, this, value);
  }

  public int getId() {
    return ffmpegJNI.AVProgram_id_get(swigCPtr, this);
  }

  public void setFlags(int value) {
    ffmpegJNI.AVProgram_flags_set(swigCPtr, this, value);
  }

  public int getFlags() {
    return ffmpegJNI.AVProgram_flags_get(swigCPtr, this);
  }

  public void setDiscard(AVDiscard value) {
    ffmpegJNI.AVProgram_discard_set(swigCPtr, this, value.swigValue());
  }

  public AVDiscard getDiscard() {
    return AVDiscard.swigToEnum(ffmpegJNI.AVProgram_discard_get(swigCPtr, this));
  }

  public void setStream_index(SWIGTYPE_p_unsigned_int value) {
    ffmpegJNI.AVProgram_stream_index_set(swigCPtr, this, SWIGTYPE_p_unsigned_int.getCPtr(value));
  }

  public SWIGTYPE_p_unsigned_int getStream_index() {
    long cPtr = ffmpegJNI.AVProgram_stream_index_get(swigCPtr, this);
    return (cPtr == 0) ? null : new SWIGTYPE_p_unsigned_int(cPtr, false);
  }

  public void setNb_stream_indexes(long value) {
    ffmpegJNI.AVProgram_nb_stream_indexes_set(swigCPtr, this, value);
  }

  public long getNb_stream_indexes() {
    return ffmpegJNI.AVProgram_nb_stream_indexes_get(swigCPtr, this);
  }

  public void setMetadata(SWIGTYPE_p_AVDictionary value) {
    ffmpegJNI.AVProgram_metadata_set(swigCPtr, this, SWIGTYPE_p_AVDictionary.getCPtr(value));
  }

  public SWIGTYPE_p_AVDictionary getMetadata() {
    long cPtr = ffmpegJNI.AVProgram_metadata_get(swigCPtr, this);
    return (cPtr == 0) ? null : new SWIGTYPE_p_AVDictionary(cPtr, false);
  }

  public void setProgram_num(int value) {
    ffmpegJNI.AVProgram_program_num_set(swigCPtr, this, value);
  }

  public int getProgram_num() {
    return ffmpegJNI.AVProgram_program_num_get(swigCPtr, this);
  }

  public void setPmt_pid(int value) {
    ffmpegJNI.AVProgram_pmt_pid_set(swigCPtr, this, value);
  }

  public int getPmt_pid() {
    return ffmpegJNI.AVProgram_pmt_pid_get(swigCPtr, this);
  }

  public void setPcr_pid(int value) {
    ffmpegJNI.AVProgram_pcr_pid_set(swigCPtr, this, value);
  }

  public int getPcr_pid() {
    return ffmpegJNI.AVProgram_pcr_pid_get(swigCPtr, this);
  }

  public AVProgram() {
    this(ffmpegJNI.new_AVProgram(), true);
  }

}