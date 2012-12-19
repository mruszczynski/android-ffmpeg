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
    native static long create(int frame_size, int filter_length);
    native static void destroy(long ptr);
    
    native static short[] echo_cancel(long cptr, short[] input, short[] echo);
    
    native static void echo_playback(long cptr, short[] echo);
    native static short[] echo_capture(long cptr, short[] input);
}
