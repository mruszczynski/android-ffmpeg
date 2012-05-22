/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.6
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package com.pluggedin.ffmpeg;

public enum AVOptionType {
  AV_OPT_TYPE_FLAGS,
  AV_OPT_TYPE_INT,
  AV_OPT_TYPE_INT64,
  AV_OPT_TYPE_DOUBLE,
  AV_OPT_TYPE_FLOAT,
  AV_OPT_TYPE_STRING,
  AV_OPT_TYPE_RATIONAL,
  AV_OPT_TYPE_BINARY,
  AV_OPT_TYPE_CONST(128),
  AV_OPT_TYPE_IMAGE_SIZE(makeCodecTag('S','I','Z','E'));

  public final int swigValue() {
    return swigValue;
  }

  public static AVOptionType swigToEnum(int swigValue) {
    AVOptionType[] swigValues = AVOptionType.class.getEnumConstants();
    if (swigValue < swigValues.length && swigValue >= 0 && swigValues[swigValue].swigValue == swigValue)
      return swigValues[swigValue];
    for (AVOptionType swigEnum : swigValues)
      if (swigEnum.swigValue == swigValue)
        return swigEnum;
    throw new IllegalArgumentException("No enum " + AVOptionType.class + " with value " + swigValue);
  }

  @SuppressWarnings("unused")
  private AVOptionType() {
    this.swigValue = SwigNext.next++;
  }

  @SuppressWarnings("unused")
  private AVOptionType(int swigValue) {
    this.swigValue = swigValue;
    SwigNext.next = swigValue+1;
  }

  @SuppressWarnings("unused")
  private AVOptionType(AVOptionType swigEnum) {
    this.swigValue = swigEnum.swigValue;
    SwigNext.next = this.swigValue+1;
  }

  private final int swigValue;

  private static class SwigNext {
    private static int next = 0;
  }
}

