package com.pluggedin.ffmpeg;

public class CodecUtil
{
  public static int makeCodecTag(int a, char b, char c, char d)
  {
    assert(0==a);
    return makeCodecTag('0',b,c,d);
  }
  
  public static int makeCodecTag(char a, char b, char c, char d)
  {
    return ((d) | (((int)c) << 8) | (((int)b) << 16) | (((int)a) << 24));
  }

}
