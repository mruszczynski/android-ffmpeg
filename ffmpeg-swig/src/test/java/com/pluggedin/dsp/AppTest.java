package com.pluggedin.dsp;

import junit.framework.Assert;

import org.junit.Test;

import com.pluggedin.dsp.Complex;
import com.pluggedin.dsp.FFT;

public class AppTest
{
  //@Test
  public void testFft()
  {
      int N = 16;
      FFT fft = new FFT(N);
      AEC aec = new AEC(16, 16*10);
     
      double x[] = new double[N];
      short short_in[] = new short[N];
      Complex X[] = null;
      
      System.out.println("input:");
      for(int i=0; i<N; i++) {
          x[i] = i;
          short_in[i] = (short) i;
          System.out.println("x[i]: " +x[i]);
      }
      
//      short[] no_echo = aec.echo_capture(short_in);
      
//      x[0] = 1;
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
      Assert.assertTrue( true );
  }


}
