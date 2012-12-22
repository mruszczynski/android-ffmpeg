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
//  public void testFft()
//  {
//    int N = 1024;
//    FFT fft = new FFT(N);
//    AEC aec = new AEC(8000, N, 256);
//
//    double x[] = new double[N];
//    short short_in[] = new short[N];
//    Complex X[] = null;
//
//    System.out.println("input:");
//    for (int i = 0; i < N; i++)
//    {
//      x[i] = i;
//      short_in[i] = (short) i;
//      System.out.println("x[i]: " + x[i]);
//    }
//
//    // short[] no_echo = aec.echo_capture(short_in);
//
//    // x[0] = 1;
//    System.out.println("fft...");
//        X = fft.fwd_r2c(x);
//    for (int i = 0; i < N; i++)
//    {
//      System.out.println("X[" + i + "]: " + X[i].re() + ", " + X[i].im() + "i");
//    }
//
//    System.out.println("ifft...");
//    x = fft.inv_c2r(X);
//    System.out.println("reconstructed output after ifft:");
//    for (int i = 0; i < N; i++)
//    {
//      System.out.println("x[i]: " + x[i] / N);
//    }
//    Assert.assertTrue(true);
//  }

//  @Test
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
          int frame_size = 1024, filter_size = 256, length = 8000*10, err = 1;
          short[] captured_frame = new short[frame_size];
          short[] frame_on_speakers = new short[frame_size];
          Random random = new Random();
          AEC aec = new AEC(8000, frame_size, filter_size);
          short[] filtered_frame = new short[frame_size];
          for(int i1=0;i1<length;i1+=frame_size)
          {
            for (int i = 0; i < frame_size; i++)
            {                
              frame_on_speakers[i] = (short) (random.nextInt() >> 16);
              captured_frame[i] = (short) (random.nextInt() >> 16);
            }
             err = aec.echo_cancel(captured_frame, frame_on_speakers, filtered_frame);
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
