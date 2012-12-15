/* 
 * File:   plggdn_fft_kernel.h
 * Author: michu
 *
 * Created on 7 grudzień 2012, 00:16
 */

#ifndef PLGGDN_FFT_KERNEL_H
#define	PLGGDN_FFT_KERNEL_H

#ifdef	__cplusplus
extern "C" {
#endif
    
#include "plggdn_fft.h"
    

    typedef struct plggdn_fft_attr {    
        /** few pointers to internally allocd memory*/
        plggdn_complex *complex_in, *complex_out;
        plggdn_float *real_in, *real_out;
        
        int N;
        
        /** implementation private data*/
        void *priv;
    } plggdn_fft_attr;
    
    /** base plggdn-FFT interface*/
    typedef struct plggdn_fft_kernel_vtable {    

        /**simplest constructor function*/
        int(*init)(struct plggdn_fft_t *fft);
        
        /**destructor function*/
        int(*deinit)(struct plggdn_fft_t *fft);
        

        /**forward fft from real input to complex output*/
        int(*fft_r2c)(struct plggdn_fft_t *fft, double *in,  plggdn_complex *out);

        /**inverse fft from complex input to real output*/
        int(*ifft_c2r)(struct plggdn_fft_t *fft, plggdn_complex *in,  double *out);

        /**forward complex fft*/
        int(*fft)(struct plggdn_fft_t *fft, plggdn_complex *in, plggdn_complex *out);

        /**inverse complex fft*/
        int(*ifft)(struct plggdn_fft_t *fft, plggdn_complex *in, plggdn_complex *out);

    } plggdn_fft_kernel_vtable;


    /** kernel structure for plggdn-FFT*/
    typedef struct plggdn_fft_t {
        /**union to introduce inheritance*/
        union {
            plggdn_fft_attr plggdn_fft;
        } base;

//        int N;
//        
//        /** implementation private data*/
//        void *priv;
        
        /**vtable to store implementation methods*/
        struct  plggdn_fft_kernel_vtable *vtable;

        /**macro to cast pointer to class*/
//        #define _plggdn_fft(self) (self)
        #define _plggdn_fft(self) (&(self)->base.plggdn_fft)

        /**macro to execute functions*/
        #define _plggdn_fft_vt(self) ((self)->vtable)
    } plggdn_fft_t;


#ifdef	__cplusplus
}
#endif

#endif	/* PLGGDN_FFT_KERNEL_H */

