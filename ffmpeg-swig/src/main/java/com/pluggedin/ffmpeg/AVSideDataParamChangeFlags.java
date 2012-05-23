/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.6
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package com.pluggedin.ffmpeg;

public enum AVSideDataParamChangeFlags {
  AV_SIDE_DATA_PARAM_CHANGE_CHANNEL_COUNT(0x0001),
  AV_SIDE_DATA_PARAM_CHANGE_CHANNEL_LAYOUT(0x0002),
  AV_SIDE_DATA_PARAM_CHANGE_SAMPLE_RATE(0x0004),
  AV_SIDE_DATA_PARAM_CHANGE_DIMENSIONS(0x0008);

  public final int swigValue() {
    return swigValue;
  }

  public static AVSideDataParamChangeFlags swigToEnum(int swigValue) {
    AVSideDataParamChangeFlags[] swigValues = AVSideDataParamChangeFlags.class.getEnumConstants();
    if (swigValue < swigValues.length && swigValue >= 0 && swigValues[swigValue].swigValue == swigValue)
      return swigValues[swigValue];
    for (AVSideDataParamChangeFlags swigEnum : swigValues)
      if (swigEnum.swigValue == swigValue)
        return swigEnum;
    throw new IllegalArgumentException("No enum " + AVSideDataParamChangeFlags.class + " with value " + swigValue);
  }

  @SuppressWarnings("unused")
  private AVSideDataParamChangeFlags() {
    this.swigValue = SwigNext.next++;
  }

  @SuppressWarnings("unused")
  private AVSideDataParamChangeFlags(int swigValue) {
    this.swigValue = swigValue;
    SwigNext.next = swigValue+1;
  }

  @SuppressWarnings("unused")
  private AVSideDataParamChangeFlags(AVSideDataParamChangeFlags swigEnum) {
    this.swigValue = swigEnum.swigValue;
    SwigNext.next = this.swigValue+1;
  }

  private final int swigValue;

  private static class SwigNext {
    private static int next = 0;
  }
}
