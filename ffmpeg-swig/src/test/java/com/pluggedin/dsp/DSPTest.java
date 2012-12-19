package com.pluggedin.dsp;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Random;
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

    @Test
    public void testFFT() throws IOException {
        int N = 16;
        FFT fft = new FFT(N);

        double x[] = new double[N];
        Complex X[] = null;

        System.out.println("input:");
        for (int i = 0; i < N; i++) {
            x[i] = i;
            System.out.println("x[i]: " + x[i]);
        }

        // x[0] = 1;
        System.out.println("fft...");
        X = fft.fwd_r2c(x);
        for (int i = 0; i < N; i++) {
            System.out.println("X[" + i + "]: " + X[i].re() + ", " + X[i].im() + "i");
        }

        System.out.println("ifft...");
        x = fft.inv_c2r(X);
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

    @Test
    public void testAEC() throws IOException {
        AEC aec = new AEC(16, 16 * 10);
        short[] input = new short[100];
        short[] mic = new short[100];
        Random random = new Random();
        for (int i = 0; i < input.length; i++) {
            input[i] = (short) (random.nextInt() >> 16);
            mic[i] = (short) (random.nextInt() >> 16);
        }
        short[] filtered = aec.echo_cancel(input, mic);
        try {
            aec.finalize();
        } catch (Throwable ex) {
            Logger.getLogger(DSPTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Assert.assertTrue(true);
    }
}
