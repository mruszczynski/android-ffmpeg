/* 
 * File:   test.c
 * Author: michu
 *
 * Created on 5 grudzień 2012, 00:05
 */

#include <stdio.h>
#include <stdlib.h>
#include <memory.h>

#include "plggdn_fft.h"
#include "plggdn_fft_base.h"

#include "plggdn_aec.h"
#include "plggdn_aec_speex.h"

void test_funct() {
    //plggdn_fft_open();
    
    int N  = 16;
    
    plggdn_aec_base_attr base = {
       .frame_size = N,
       .filter_length = N*15
    };
    
    plggdn_aec_t *aec = plggdn_aec_create(&plggdn_aec_speex_vt, &base);
    
    
    
    plggdn_fft_t *fft_kernel = plggdn_fft_create(N);
    
    double x[N]; 
    memset(x, 0, sizeof(double) * N);
    
    // dirac delta
    x[0] = 1;
    for(int i=0; i<N; i++) {
        // straight line
//        x[i] = (double)i;
        printf("x[%i]: %f\n", i, x[i]);
    }
    
    plggdn_aec_echo_capture(aec, x, x);
    
    plggdn_complex X[N];
    
    printf("fft...\n");
    plggdn_fft_fwd_r2c(fft_kernel, x, X);
    
    for(int i=0; i<N; i++) {
        printf("X[%i]: %f, %f\n", i, creal(X[i]), cimag(X[i]));
    }
    
    printf("ifft...\n");
    plggdn_fft_inv_c2r(fft_kernel, X, x);
    
    for(int i=0; i<N; i++) {
        printf("x[%i]: %f\n", i, x[i]);
    }
    
    plggdn_fft_release(&fft_kernel);
    
    plggdn_aec_release(&aec);
    
    //plggdn_fft_close();
}

/*
 * 
 */
int main(int argc, char** argv) {
    test_funct();
    
    return (EXIT_SUCCESS);
}

