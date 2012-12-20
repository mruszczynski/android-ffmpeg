/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pluggedin.dsp;

/**
 *
 * @author michu
 */
public class AEC {    
    private long cPtr;
    
    public AEC(int frame_size, int filter_length) {
        cPtr = AECJNI.create(frame_size, filter_length);
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize(); //To change body of generated methods, choose Tools | Templates.
        
        AECJNI.destroy(cPtr);
    }
    
    /**
     * synchronous way to cancel echo
     * @param input - what mic received
     * @param echo - what speakers played
     * @param filter_out - filtered input
     * @return errcode
     */
    public int echo_cancel(short[] input, short[] echo, short[] filter_out) {
        return AECJNI.echo_cancel(cPtr, input, echo, filter_out);
    }
    
    /**
     * asynchronous aec, run this each time frame is pushed to sound card
     * @param output
     * @return 
     */
    public int echo_playback(short[] output) {
        return AECJNI.echo_playback(cPtr, output);
    }
    
    /**
     * asyncrhounous aec, run this each time frame is received from sound card
     * @param input
     * @return 
     */
    public int echo_capture(short[] input, short[] filtered_input) {
        return AECJNI.echo_capture(cPtr, input, filtered_input);
    }
    
}
