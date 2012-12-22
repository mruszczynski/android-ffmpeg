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
    native static long create(int sample_rate, int frame_size, int filter_length);
    native static int destroy(long ptr);
    
    native static int echo_cancel(long cptr, short[] input, short[] echo, short[] filter_out);
    
    native static int echo_playback(long cptr, short[] echo);
    native static int echo_capture(long cptr, short[] input, short[] filter_out);
}
