package com.pluggedin.dsp;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

import junit.framework.Assert;

import org.junit.Test;

public class DSPTest {

    public DSPTest() throws IOException {
        extractAndLoad("libfftw3.so.3");
        extractAndLoad("libspeex.so.1");
        extractAndLoad("libspeexdsp.so.1");

        extractAndLoad("libavutil.so.51");
        extractAndLoad("libswresample.so.0");
        extractAndLoad("libavcodec.so.54");
        extractAndLoad("libavformat.so.54");
        extractAndLoad("libswscale.so.2");
        extractAndLoad("libavfilter.so.2");

        extractAndLoad("libffmpegjni.so.1");
    }

    private void extractAndLoad(String name) throws IOException {
        extract(name);
        System.load(new File(name).getAbsolutePath());
    }

    private void extract(String name) throws IOException {
        FileOutputStream out = new FileOutputStream(name);
        InputStream in = this.getClass().getClassLoader().getResourceAsStream(name);
        byte[] buffer = new byte[1024];
        int read = in.read(buffer);
        while (0 < read) {
            out.write(buffer, 0, read);
            read = in.read(buffer);
        }
        out.close();
    }

//    @Test
//    public void testFFT() throws IOException {
//        int N = 16;
//        FFT fft = new FFT(N);
//
//        double x[] = new double[N];
//        Complex X[] = null;
//
//        System.out.println("input:");
//        for (int i = 0; i < N; i++) {
//            x[i] = i;
//            System.out.println("x[i]: " + x[i]);
//        }
//
//        // x[0] = 1;
//        System.out.println("fft...");
//        X = fft.fwd_r2c(x);
//        for (int i = 0; i < N; i++) {
//            System.out.println("X[" + i + "]: " + X[i].re() + ", " + X[i].im() + "i");
//        }
//
//        System.out.println("ifft...");
//        x = fft.inv_c2r(X);
//        System.out.println("reconstructed output after ifft:");
//        for (int i = 0; i < N; i++) {
//            System.out.println("x[i]: " + x[i] / N);
//        }
//        try {
//            fft.finalize();
//        } catch (Throwable ex) {
//            Logger.getLogger(DSPTest.class.getName()).log(Level.SEVERE, null, ex);
//        }
//            
//        Assert.assertTrue(true);
//    }
    
//    @Test
    public void testFFT2()  {        
        int err = 0, N = 16;
        FFT fft = new FFT(N);

        double x[] = new double[N];
        double X[] = new double[N*2];

        System.out.println("input:");
        for (int i = 0; i < N; i++) {
            x[i] = i;
            System.out.println("x[i]: " + x[i]);
        }

        // x[0] = 1;
        System.out.println("forward...");
        err = fft.fwd_r2c(x, X);
        if(err != 0) {
            System.out.println("fft error\n");
            //Assert.fail();
        }
        
        for (int i = 0; i < N*2; i+=2) {
            System.out.println("X[" + i + "]: " + X[i] + ", " + X[i+1] + "i");
        }

        System.out.println("inverse...");
        err = fft.inv_c2r(X, x);
        if(err != 0) {
            System.out.println("ifft error\n");
            //Assert.fail();
        }
        System.out.println("reconstructed output after ifft:");
        for (int i = 0; i < N; i++) {
            System.out.println("x[i]: " + x[i] / N);
        }
        try {
            fft.finalize();
        } catch (Throwable ex) {
            Logger.getLogger(DSPTest.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        Assert.assertTrue(true);
    }

//    @Test
//    public void testAEC() throws IOException {
//        AEC aec = new AEC(16, 16 * 10);
//        short[] input = new short[100];
//        short[] mic = new short[100];
//        Random random = new Random();
//        short[] filtered = new short[100];
//        int err = 1;
//        for (int i = 0; i < input.length; i++) {
//            input[i] = (short) (random.nextInt() >> 16);
//            mic[i] = (short) (random.nextInt() >> 16);
//        }
//        err = aec.echo_cancel(input, mic, filtered);
//        try {
//            aec.finalize();
//        } catch (Throwable ex) {
//            Logger.getLogger(DSPTest.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        
//        Assert.assertTrue(err == 0);
//    }
    
    @Test
    public void testAEC_kernel() throws IOException {
        int sample_rate = 16000,
                  frame_size = 1024, // frame size in powers of two, as speex doc suggests
                  filter_size = 256, // filter size <= frame_size
                  signal_length = 16000*10; // bunch of samples
          
          short[] captured_frame = new short[frame_size];
          short[] frame_on_speakers = new short[frame_size];
          Random random = new Random();
          AEC aec = new AEC(sample_rate, frame_size, filter_size);
          short[] filtered_frame = new short[frame_size];
          for(int j=0;j<signal_length;j+=frame_size)
          {
            for (int i = 0; i < frame_size; i++)
            {                
              frame_on_speakers[i] = (short) (random.nextInt() >> 16);
              captured_frame[i] = (short) (random.nextInt() >> 16);
            }
             int err = aec.echo_cancel(captured_frame, frame_on_speakers, filtered_frame);
             if(err != 0) {
                 System.out.println("aec_echo_cancel error " + err);
             }
          }
    }
    
//    @Test
  public void testAEC() throws InterruptedException
  {
    
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
              try {
                  testAEC_kernel();
              } catch (IOException ex) {
                  Logger.getLogger(DSPTest.class.getName()).log(Level.SEVERE, null, ex);
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
}
