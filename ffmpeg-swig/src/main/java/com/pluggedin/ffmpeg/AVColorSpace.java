/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.6
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package com.pluggedin.ffmpeg;

public enum AVColorSpace {
  AVCOL_SPC_RGB(0),
  AVCOL_SPC_BT709(1),
  AVCOL_SPC_UNSPECIFIED(2),
  AVCOL_SPC_FCC(4),
  AVCOL_SPC_BT470BG(5),
  AVCOL_SPC_SMPTE170M(6),
  AVCOL_SPC_SMPTE240M(7),
  AVCOL_SPC_YCGCO(8),
  AVCOL_SPC_NB;

  public final int swigValue() {
    return swigValue;
  }

  public static AVColorSpace swigToEnum(int swigValue) {
    AVColorSpace[] swigValues = AVColorSpace.class.getEnumConstants();
    if (swigValue < swigValues.length && swigValue >= 0 && swigValues[swigValue].swigValue == swigValue)
      return swigValues[swigValue];
    for (AVColorSpace swigEnum : swigValues)
      if (swigEnum.swigValue == swigValue)
        return swigEnum;
    throw new IllegalArgumentException("No enum " + AVColorSpace.class + " with value " + swigValue);
  }

  @SuppressWarnings("unused")
  private AVColorSpace() {
    this.swigValue = SwigNext.next++;
  }

  @SuppressWarnings("unused")
  private AVColorSpace(int swigValue) {
    this.swigValue = swigValue;
    SwigNext.next = swigValue+1;
  }

  @SuppressWarnings("unused")
  private AVColorSpace(AVColorSpace swigEnum) {
    this.swigValue = swigEnum.swigValue;
    SwigNext.next = this.swigValue+1;
  }

  private final int swigValue;

  private static class SwigNext {
    private static int next = 0;
  }
}

