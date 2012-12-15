/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pluggedin.dsp;

/**
 *
 * @author michu
 */
public class AECJNI {
    static {
        System.loadLibrary("plggdn_dsp");
    }
    
    
    public native static long create(int frame_size, int filter_length);
    public native static void destroy(long ptr);
    
    public native static short[] echo_cancel(long cptr, short[] input, short[] echo);
    
    public native static void echo_playback(long cptr, short[] echo);
    public native static short[] echo_capture(long cptr, short[] input);
}
