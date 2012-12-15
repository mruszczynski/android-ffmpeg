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
    
    public AEC(int frame_size, int filter_samples) {
        cPtr = AECJNI.create(frame_size, filter_samples);
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
     * @return filtered input
     */
    public short[] echo_cancel(short[] input, short[] echo) {
        return AECJNI.echo_cancel(cPtr, input, echo);
    }
    
    /**
     * asynchronous aec, run this each time frame is pushed to sound card
     * @param output 
     */
    public void echo_playback(short[] output) {
        AECJNI.echo_playback(cPtr, output);
    }
    
    /**
     * asyncrhounous aec, run this each time frame is received from sound card
     * @param input
     * @return 
     */
    public short[] echo_capture(short[] input) {
        return AECJNI.echo_capture(cPtr, input);
    }
    
}
