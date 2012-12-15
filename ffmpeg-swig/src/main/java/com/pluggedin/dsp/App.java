package com.pluggedin.dsp;

/**
 * Hello world!
 *
 */
public class App 
{
    private static void simple_test() {
        int N = 16;
        FFT fft = new FFT(N);
       
        double x[] = new double[N];
        Complex X[] = null;
        System.out.println("input:");
        for(int i=0; i<N; i++) {
            x[i] = i;
            System.out.println("x[i]: " +x[i]);
        }
//        x[0] = 1;
        System.out.println("fft...");
        X = fft.fwd_r2c(x);
        for(int i=0; i<N; i++) {
           System.out.println("X[" + i + "]: " + X[i].re() + ", " + X[i].im() + "i");
        }
        
        System.out.println("ifft...");
        x = fft.inv_c2r(X);
       System.out.println("reconstructed output after ifft:");
       for(int i=0; i<N; i++) {
           System.out.println("x[i]: " +x[i]/N);
       }
    }
    
    public static void main( String[] args )
    {        
//        simple_test();
    }
}
