package com.pluggedin.dsp;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Semaphore;

import junit.framework.Assert;

import org.junit.Test;

import com.pluggedin.dsp.Complex;
import com.pluggedin.dsp.FFT;

public class AppTest
{
  // @Test
  public void testFft()
  {
    int N = 16;
    FFT fft = new FFT(N);
    AEC aec = new AEC(16, 16 * 10);

    double x[] = new double[N];
    short short_in[] = new short[N];
    Complex X[] = null;

    System.out.println("input:");
    for (int i = 0; i < N; i++)
    {
      x[i] = i;
      short_in[i] = (short) i;
      System.out.println("x[i]: " + x[i]);
    }

    // short[] no_echo = aec.echo_capture(short_in);

    // x[0] = 1;
    System.out.println("fft...");
    X = fft.fwd_r2c(x);
    for (int i = 0; i < N; i++)
    {
      System.out.println("X[" + i + "]: " + X[i].re() + ", " + X[i].im() + "i");
    }

    System.out.println("ifft...");
    x = fft.inv_c2r(X);
    System.out.println("reconstructed output after ifft:");
    for (int i = 0; i < N; i++)
    {
      System.out.println("x[i]: " + x[i] / N);
    }
    Assert.assertTrue(true);
  }

  @Test
  public void testAEC() throws IOException, InterruptedException
  {
    
    extractAndLoad("libspeex.so.1");
    extractAndLoad("libspeexdsp.so.1");
    
    extractAndLoad("libavutil.so.51");
    extractAndLoad("libswresample.so.0");
    extractAndLoad("libavcodec.so.54");
    extractAndLoad("libavformat.so.54");
    extractAndLoad("libswscale.so.2");
    extractAndLoad("libavfilter.so.2");
    
    extractAndLoad("libffmpegjni.so.1");

    List<Semaphore> semaphores = new ArrayList<Semaphore>();
    for(int i2=0;i2<10;i2++)
    {
      final Semaphore semaphore = new Semaphore(0);
      semaphores.add(semaphore);
      new Thread(new Runnable()
      {
        @Override
        public void run()
        {
          int length = 100, err = 1;
          short[] input = new short[length];
          short[] mic = new short[length];
          Random random = new Random();
          AEC aec = new AEC(length, length);
          short[] filtered = new short[length];
          for(int i1=0;i1<length;i1++)
          {
            for (int i = 0; i < input.length; i++)
            {
              input[i] = (short) (random.nextInt() >> 16);
              mic[i] = (short) (random.nextInt() >> 16);
            }
             err = aec.echo_cancel(input, mic, filtered);
          }
          semaphore.release();
        }
      }).start();
    }
    
    for(Semaphore semaphore : semaphores)
    {
      semaphore.acquire();
    }
    
  }

  private void extractAndLoad(String name) throws IOException
  {
    extract(name);
    System.load(new File(name).getAbsolutePath());
  }

  private void extract(String name) throws IOException
  {
    FileOutputStream out = new FileOutputStream(name);
    InputStream in = this.getClass().getClassLoader().getResourceAsStream(name);
    byte[] buffer = new byte[1024];
    int read = in.read(buffer);
    while(0 < read)
    {
      out.write(buffer, 0, read);
      read = in.read(buffer);
    }
    out.close();
  }

}
