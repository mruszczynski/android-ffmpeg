/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.6
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package com.pluggedin.ffmpeg;

public class AVFormatContext {
  private long swigCPtr;
  protected boolean swigCMemOwn;

  protected AVFormatContext(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  public static long getCPtr(AVFormatContext obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        ffmpegJNI.delete_AVFormatContext(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void setIformat(AVInputFormat value) {
    ffmpegJNI.AVFormatContext_iformat_set(swigCPtr, this, AVInputFormat.getCPtr(value), value);
  }

  public AVInputFormat getIformat() {
    long cPtr = ffmpegJNI.AVFormatContext_iformat_get(swigCPtr, this);
    return (cPtr == 0) ? null : new AVInputFormat(cPtr, false);
  }

  public void setOformat(AVOutputFormat value) {
    ffmpegJNI.AVFormatContext_oformat_set(swigCPtr, this, AVOutputFormat.getCPtr(value), value);
  }

  public AVOutputFormat getOformat() {
    long cPtr = ffmpegJNI.AVFormatContext_oformat_get(swigCPtr, this);
    return (cPtr == 0) ? null : new AVOutputFormat(cPtr, false);
  }

  public void setPriv_data(long value) {
    ffmpegJNI.AVFormatContext_priv_data_set(swigCPtr, this, value);
  }

  public long getPriv_data() {
    return ffmpegJNI.AVFormatContext_priv_data_get(swigCPtr, this);
  }

  public void setPb(AVIOContext value) {
    ffmpegJNI.AVFormatContext_pb_set(swigCPtr, this, AVIOContext.getCPtr(value), value);
  }

  public AVIOContext getPb() {
    long cPtr = ffmpegJNI.AVFormatContext_pb_get(swigCPtr, this);
    return (cPtr == 0) ? null : new AVIOContext(cPtr, false);
  }

  public void setCtx_flags(int value) {
    ffmpegJNI.AVFormatContext_ctx_flags_set(swigCPtr, this, value);
  }

  public int getCtx_flags() {
    return ffmpegJNI.AVFormatContext_ctx_flags_get(swigCPtr, this);
  }

  public void setNb_streams(long value) {
    ffmpegJNI.AVFormatContext_nb_streams_set(swigCPtr, this, value);
  }

  public long getNb_streams() {
    return ffmpegJNI.AVFormatContext_nb_streams_get(swigCPtr, this);
  }

  public void setStreams(SWIGTYPE_p_p_AVStream value) {
    ffmpegJNI.AVFormatContext_streams_set(swigCPtr, this, SWIGTYPE_p_p_AVStream.getCPtr(value));
  }

  public SWIGTYPE_p_p_AVStream getStreams() {
    long cPtr = ffmpegJNI.AVFormatContext_streams_get(swigCPtr, this);
    return (cPtr == 0) ? null : new SWIGTYPE_p_p_AVStream(cPtr, false);
  }

  public void setFilename(String value) {
    ffmpegJNI.AVFormatContext_filename_set(swigCPtr, this, value);
  }

  public String getFilename() {
    return ffmpegJNI.AVFormatContext_filename_get(swigCPtr, this);
  }

  public void setStart_time(long value) {
    ffmpegJNI.AVFormatContext_start_time_set(swigCPtr, this, value);
  }

  public long getStart_time() {
    return ffmpegJNI.AVFormatContext_start_time_get(swigCPtr, this);
  }

  public void setDuration(long value) {
    ffmpegJNI.AVFormatContext_duration_set(swigCPtr, this, value);
  }

  public long getDuration() {
    return ffmpegJNI.AVFormatContext_duration_get(swigCPtr, this);
  }

  public void setBit_rate(int value) {
    ffmpegJNI.AVFormatContext_bit_rate_set(swigCPtr, this, value);
  }

  public int getBit_rate() {
    return ffmpegJNI.AVFormatContext_bit_rate_get(swigCPtr, this);
  }

  public void setPacket_size(long value) {
    ffmpegJNI.AVFormatContext_packet_size_set(swigCPtr, this, value);
  }

  public long getPacket_size() {
    return ffmpegJNI.AVFormatContext_packet_size_get(swigCPtr, this);
  }

  public void setMax_delay(int value) {
    ffmpegJNI.AVFormatContext_max_delay_set(swigCPtr, this, value);
  }

  public int getMax_delay() {
    return ffmpegJNI.AVFormatContext_max_delay_get(swigCPtr, this);
  }

  public void setFlags(int value) {
    ffmpegJNI.AVFormatContext_flags_set(swigCPtr, this, value);
  }

  public int getFlags() {
    return ffmpegJNI.AVFormatContext_flags_get(swigCPtr, this);
  }

  public void setProbesize(long value) {
    ffmpegJNI.AVFormatContext_probesize_set(swigCPtr, this, value);
  }

  public long getProbesize() {
    return ffmpegJNI.AVFormatContext_probesize_get(swigCPtr, this);
  }

  public void setMax_analyze_duration(int value) {
    ffmpegJNI.AVFormatContext_max_analyze_duration_set(swigCPtr, this, value);
  }

  public int getMax_analyze_duration() {
    return ffmpegJNI.AVFormatContext_max_analyze_duration_get(swigCPtr, this);
  }

  public void setKey(SWIGTYPE_p_unsigned_char value) {
    ffmpegJNI.AVFormatContext_key_set(swigCPtr, this, SWIGTYPE_p_unsigned_char.getCPtr(value));
  }

  public SWIGTYPE_p_unsigned_char getKey() {
    long cPtr = ffmpegJNI.AVFormatContext_key_get(swigCPtr, this);
    return (cPtr == 0) ? null : new SWIGTYPE_p_unsigned_char(cPtr, false);
  }

  public void setKeylen(int value) {
    ffmpegJNI.AVFormatContext_keylen_set(swigCPtr, this, value);
  }

  public int getKeylen() {
    return ffmpegJNI.AVFormatContext_keylen_get(swigCPtr, this);
  }

  public void setNb_programs(long value) {
    ffmpegJNI.AVFormatContext_nb_programs_set(swigCPtr, this, value);
  }

  public long getNb_programs() {
    return ffmpegJNI.AVFormatContext_nb_programs_get(swigCPtr, this);
  }

  public void setPrograms(SWIGTYPE_p_p_AVProgram value) {
    ffmpegJNI.AVFormatContext_programs_set(swigCPtr, this, SWIGTYPE_p_p_AVProgram.getCPtr(value));
  }

  public SWIGTYPE_p_p_AVProgram getPrograms() {
    long cPtr = ffmpegJNI.AVFormatContext_programs_get(swigCPtr, this);
    return (cPtr == 0) ? null : new SWIGTYPE_p_p_AVProgram(cPtr, false);
  }

  public void setVideo_codec_id(CodecID value) {
    ffmpegJNI.AVFormatContext_video_codec_id_set(swigCPtr, this, value.swigValue());
  }

  public CodecID getVideo_codec_id() {
    return CodecID.swigToEnum(ffmpegJNI.AVFormatContext_video_codec_id_get(swigCPtr, this));
  }

  public void setAudio_codec_id(CodecID value) {
    ffmpegJNI.AVFormatContext_audio_codec_id_set(swigCPtr, this, value.swigValue());
  }

  public CodecID getAudio_codec_id() {
    return CodecID.swigToEnum(ffmpegJNI.AVFormatContext_audio_codec_id_get(swigCPtr, this));
  }

  public void setSubtitle_codec_id(CodecID value) {
    ffmpegJNI.AVFormatContext_subtitle_codec_id_set(swigCPtr, this, value.swigValue());
  }

  public CodecID getSubtitle_codec_id() {
    return CodecID.swigToEnum(ffmpegJNI.AVFormatContext_subtitle_codec_id_get(swigCPtr, this));
  }

  public void setMax_index_size(long value) {
    ffmpegJNI.AVFormatContext_max_index_size_set(swigCPtr, this, value);
  }

  public long getMax_index_size() {
    return ffmpegJNI.AVFormatContext_max_index_size_get(swigCPtr, this);
  }

  public void setMax_picture_buffer(long value) {
    ffmpegJNI.AVFormatContext_max_picture_buffer_set(swigCPtr, this, value);
  }

  public long getMax_picture_buffer() {
    return ffmpegJNI.AVFormatContext_max_picture_buffer_get(swigCPtr, this);
  }

  public void setNb_chapters(long value) {
    ffmpegJNI.AVFormatContext_nb_chapters_set(swigCPtr, this, value);
  }

  public long getNb_chapters() {
    return ffmpegJNI.AVFormatContext_nb_chapters_get(swigCPtr, this);
  }

  public void setChapters(SWIGTYPE_p_p_AVChapter value) {
    ffmpegJNI.AVFormatContext_chapters_set(swigCPtr, this, SWIGTYPE_p_p_AVChapter.getCPtr(value));
  }

  public SWIGTYPE_p_p_AVChapter getChapters() {
    long cPtr = ffmpegJNI.AVFormatContext_chapters_get(swigCPtr, this);
    return (cPtr == 0) ? null : new SWIGTYPE_p_p_AVChapter(cPtr, false);
  }

  public void setMetadata(AVDictionary value) {
    ffmpegJNI.AVFormatContext_metadata_set(swigCPtr, this, AVDictionary.getCPtr(value), value);
  }

  public AVDictionary getMetadata() {
    long cPtr = ffmpegJNI.AVFormatContext_metadata_get(swigCPtr, this);
    return (cPtr == 0) ? null : new AVDictionary(cPtr, false);
  }

  public void setStart_time_realtime(long value) {
    ffmpegJNI.AVFormatContext_start_time_realtime_set(swigCPtr, this, value);
  }

  public long getStart_time_realtime() {
    return ffmpegJNI.AVFormatContext_start_time_realtime_get(swigCPtr, this);
  }

  public void setFps_probe_size(int value) {
    ffmpegJNI.AVFormatContext_fps_probe_size_set(swigCPtr, this, value);
  }

  public int getFps_probe_size() {
    return ffmpegJNI.AVFormatContext_fps_probe_size_get(swigCPtr, this);
  }

  public void setError_recognition(int value) {
    ffmpegJNI.AVFormatContext_error_recognition_set(swigCPtr, this, value);
  }

  public int getError_recognition() {
    return ffmpegJNI.AVFormatContext_error_recognition_get(swigCPtr, this);
  }

  public void setInterrupt_callback(AVIOInterruptCB value) {
    ffmpegJNI.AVFormatContext_interrupt_callback_set(swigCPtr, this, AVIOInterruptCB.getCPtr(value), value);
  }

  public AVIOInterruptCB getInterrupt_callback() {
    long cPtr = ffmpegJNI.AVFormatContext_interrupt_callback_get(swigCPtr, this);
    return (cPtr == 0) ? null : new AVIOInterruptCB(cPtr, false);
  }

  public void setDebug(int value) {
    ffmpegJNI.AVFormatContext_debug_set(swigCPtr, this, value);
  }

  public int getDebug() {
    return ffmpegJNI.AVFormatContext_debug_get(swigCPtr, this);
  }

  public void setTs_id(int value) {
    ffmpegJNI.AVFormatContext_ts_id_set(swigCPtr, this, value);
  }

  public int getTs_id() {
    return ffmpegJNI.AVFormatContext_ts_id_get(swigCPtr, this);
  }

  public void setAudio_preload(int value) {
    ffmpegJNI.AVFormatContext_audio_preload_set(swigCPtr, this, value);
  }

  public int getAudio_preload() {
    return ffmpegJNI.AVFormatContext_audio_preload_get(swigCPtr, this);
  }

  public void setMax_chunk_duration(int value) {
    ffmpegJNI.AVFormatContext_max_chunk_duration_set(swigCPtr, this, value);
  }

  public int getMax_chunk_duration() {
    return ffmpegJNI.AVFormatContext_max_chunk_duration_get(swigCPtr, this);
  }

  public void setMax_chunk_size(int value) {
    ffmpegJNI.AVFormatContext_max_chunk_size_set(swigCPtr, this, value);
  }

  public int getMax_chunk_size() {
    return ffmpegJNI.AVFormatContext_max_chunk_size_get(swigCPtr, this);
  }

  public void setPacket_buffer(AVPacketList value) {
    ffmpegJNI.AVFormatContext_packet_buffer_set(swigCPtr, this, AVPacketList.getCPtr(value), value);
  }

  public AVPacketList getPacket_buffer() {
    long cPtr = ffmpegJNI.AVFormatContext_packet_buffer_get(swigCPtr, this);
    return (cPtr == 0) ? null : new AVPacketList(cPtr, false);
  }

  public void setPacket_buffer_end(AVPacketList value) {
    ffmpegJNI.AVFormatContext_packet_buffer_end_set(swigCPtr, this, AVPacketList.getCPtr(value), value);
  }

  public AVPacketList getPacket_buffer_end() {
    long cPtr = ffmpegJNI.AVFormatContext_packet_buffer_end_get(swigCPtr, this);
    return (cPtr == 0) ? null : new AVPacketList(cPtr, false);
  }

  public void setData_offset(long value) {
    ffmpegJNI.AVFormatContext_data_offset_set(swigCPtr, this, value);
  }

  public long getData_offset() {
    return ffmpegJNI.AVFormatContext_data_offset_get(swigCPtr, this);
  }

  public void setRaw_packet_buffer(AVPacketList value) {
    ffmpegJNI.AVFormatContext_raw_packet_buffer_set(swigCPtr, this, AVPacketList.getCPtr(value), value);
  }

  public AVPacketList getRaw_packet_buffer() {
    long cPtr = ffmpegJNI.AVFormatContext_raw_packet_buffer_get(swigCPtr, this);
    return (cPtr == 0) ? null : new AVPacketList(cPtr, false);
  }

  public void setRaw_packet_buffer_end(AVPacketList value) {
    ffmpegJNI.AVFormatContext_raw_packet_buffer_end_set(swigCPtr, this, AVPacketList.getCPtr(value), value);
  }

  public AVPacketList getRaw_packet_buffer_end() {
    long cPtr = ffmpegJNI.AVFormatContext_raw_packet_buffer_end_get(swigCPtr, this);
    return (cPtr == 0) ? null : new AVPacketList(cPtr, false);
  }

  public void setParse_queue(AVPacketList value) {
    ffmpegJNI.AVFormatContext_parse_queue_set(swigCPtr, this, AVPacketList.getCPtr(value), value);
  }

  public AVPacketList getParse_queue() {
    long cPtr = ffmpegJNI.AVFormatContext_parse_queue_get(swigCPtr, this);
    return (cPtr == 0) ? null : new AVPacketList(cPtr, false);
  }

  public void setParse_queue_end(AVPacketList value) {
    ffmpegJNI.AVFormatContext_parse_queue_end_set(swigCPtr, this, AVPacketList.getCPtr(value), value);
  }

  public AVPacketList getParse_queue_end() {
    long cPtr = ffmpegJNI.AVFormatContext_parse_queue_end_get(swigCPtr, this);
    return (cPtr == 0) ? null : new AVPacketList(cPtr, false);
  }

  public void setRaw_packet_buffer_remaining_size(int value) {
    ffmpegJNI.AVFormatContext_raw_packet_buffer_remaining_size_set(swigCPtr, this, value);
  }

  public int getRaw_packet_buffer_remaining_size() {
    return ffmpegJNI.AVFormatContext_raw_packet_buffer_remaining_size_get(swigCPtr, this);
  }

  public void setAvio_flags(int value) {
    ffmpegJNI.AVFormatContext_avio_flags_set(swigCPtr, this, value);
  }

  public int getAvio_flags() {
    return ffmpegJNI.AVFormatContext_avio_flags_get(swigCPtr, this);
  }

  public AVFormatContext() {
    this(ffmpegJNI.new_AVFormatContext(), true);
  }

}
