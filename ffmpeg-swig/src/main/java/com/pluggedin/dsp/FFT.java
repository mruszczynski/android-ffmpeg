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
        
//    public Complex[] fwd(Complex[] in, Complex[] out) {
//        return FFTJNI.fwd(cPtr, in);
//    }
//    public Complex[] inv( Complex[] in) {
//        return FFTJNI.inv(cPtr, in);
//    }
//    public Complex[] fwd_r2c(double[] in) {
//        return FFTJNI.fwd_r2c(cPtr, in);
//    }
//    public double[] inv_c2r(Complex[] in) {
//        return FFTJNI.inv_c2r(cPtr, in);
//    }
    
    public int fwd(double[] c_in, double[] c_out) {
        return FFTJNI.fwd(cPtr, c_in, c_out);
    }
    
    public int inv(double[] c_in, double[] c_out) {
        return FFTJNI.inv(cPtr, c_in, c_out);
    }
    
    public int fwd_r2c(double[] r_in, double[] c_out) {
        return FFTJNI.fwd_r2c(cPtr, r_in, c_out);
    }
    public int inv_c2r(double[] c_in, double[] r_out) {
        return FFTJNI.inv_c2r(cPtr, c_in, r_out);
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize(); //To change body of generated methods, choose Tools | Templates.
        FFTJNI.destroy(cPtr);
    }
        
}
