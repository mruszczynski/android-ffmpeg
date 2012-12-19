/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pluggedin.dsp;

/**
 *
 * @author michu
 */
public class FFTJNI {
    
    native static long create(int N);
    native static void destroy(long cptr);
    
    native static Complex[] fwd(long cptr, Complex in[]);
    native static Complex[] inv(long cptr, Complex in[]);
    native static Complex[] fwd_r2c(long cptr, double in[]);
    native static double[] inv_c2r(long cptr, Complex in[]);
}
