/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pluggedin.dsp;

/**
 *
 * @author michu
 */
public class FFT {
    private long cPtr;
    
    public FFT(int N) {
        cPtr = FFTJNI.create(N);
    }
        
    public Complex[] fwd(Complex in[]) {
        return FFTJNI.fwd(cPtr, in);
    }
    public Complex[] inv( Complex in[]) {
        return FFTJNI.inv(cPtr, in);
    }
    public Complex[] fwd_r2c(double in[]) {
        return FFTJNI.fwd_r2c(cPtr, in);
    }
    public double[] inv_c2r(Complex in[]) {
        return FFTJNI.inv_c2r(cPtr, in);
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize(); //To change body of generated methods, choose Tools | Templates.
        FFTJNI.destroy(cPtr);
    }
        
}
