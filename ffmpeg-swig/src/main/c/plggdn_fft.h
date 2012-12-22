/* 
 * File:   plggdn_fft.h
 * Author: michu
 *
 * Created on 5 grudzień 2012, 21:52
 */

#ifndef PLGGDN_FFT_H
#define	PLGGDN_FFT_H

#ifdef	__cplusplus
extern "C" {
#endif
        
#define PLGGDN_USE_FFTW
/**BEFORE DEFINING FLOAT_PRECISION, MAKE SURE FFTW IS COMPILED FOR USING FLOATS*/
//#define PLGGDN_USE_FLOAT_PRECISION
#define USE_C99_COMPLEX_H
    
#ifndef PLGGDN_USE_FLOAT_PRECISION
        typedef double plggdn_float;
//    #define plggdn_float double
#elif PLGGDN_USE_FLOAT_PRECISION
    typedef float plggdn_float;
#endif
    
   // let's define our complex type
    typedef struct plggdn_complex_attr {
        double re, im;
    } plggdn_complex_attr;
    
#ifdef USE_C99_COMPLEX_H
    // so we can manipulate complex numbers with ordinary arithmetic
    #include <complex.h>

//#include "plggdn_fft_base.h"
//    #define plggdn_complex plggdn_float complex
    
    typedef double _Complex plggdn_complex;    
       
//    typedef union plggdn_complex {
//        plggdn_complex_attr plggdn;
////        double plggdn[2];
//        double _Complex Z;
//    } plggdn_complex;
#elif defined PLGGDN_USE_FFTW
    typedef fftw_complex plggdn_complex;
#else
    typedef plggdn_float plggdn_complex[2];
//    typedef union {
//        plggdn_complex_attr plggdn;
////        double plggdn[2];
//        plggdn_complex_attr c99;
//    } plggdn_complex;    
#endif
    
    #define _plggdn_complex(ptr) ((plggdn_complex*)ptr)
    #define __plggdn_complex(ptr) ((plggdn_complex**)&ptr)
    
    extern plggdn_float *(*plggdn_float_malloc)(int N);
    extern plggdn_complex *(*plggdn_complex_malloc)(int N);
    extern void (*plggdn_free)(void *c);
    void plggdn_freep(void **c) ;

    plggdn_complex *plggdn_complex_create2(double re, double im);
    
//#ifdef PLGGDN_USE_FFTW
//    #include "fftw3.h"
//#endif

    #define PLGGDN_FFT_FORWARD 1
    #define PLGGDN_FFT_INVERSE -1

    typedef struct plggdn_fft_t plggdn_fft_t;

    typedef struct plggdn_fft_attr {         
        int N;
        
        void *opaque;
        
         /**vtable to store implementation methods*/
        struct  plggdn_fft_kernel_vtable *impl;
    } plggdn_fft_attr;
    
    /** base plggdn-FFT interface*/
    typedef struct plggdn_fft_kernel_vtable {    

        /**simplest constructor function*/
        int(*init)(struct plggdn_fft_t *fft, void *opaque);
        
        /**destructor function*/
        int(*deinit)(struct plggdn_fft_t *fft);
        

        /**forward fft from real input to complex output*/
        int(*fft_r2c)(struct plggdn_fft_t *fft, plggdn_float *in,  plggdn_complex *out);

        /**inverse fft from complex input to real output*/
        int(*ifft_c2r)(struct plggdn_fft_t *fft, plggdn_complex *in,  plggdn_float *out);

        /**forward complex fft*/
        int(*fft)(struct plggdn_fft_t *fft, plggdn_complex *in, plggdn_complex *out);

        /**inverse complex fft*/
        int(*ifft)(struct plggdn_fft_t *fft, plggdn_complex *in, plggdn_complex *out);

    } plggdn_fft_kernel_vtable;

    /** kernel structure for plggdn-FFT*/
    struct plggdn_fft_t {
        /**union to introduce inheritance*/
//        union {
//            plggdn_fft_attr fft;
//        } base;
        
        plggdn_complex *complex_in, *complex_out;
        plggdn_float *real_in, *real_out;
        
        int N;
        
        void *opaque;
        
//        /**vtable to store implementation methods*/
        struct  plggdn_fft_kernel_vtable *vtable;

        /**macro to cast pointer to class*/
//        #define _plggdn_fft(self) (self)
//        #define _plggdn_fft(self) (&(self)->base.fft)
//
//        /**macro to execute functions*/
//        #define _plggdn_fft_vt(self) ((self)->vtable)
    };
    
    struct plggdn_fft_t *plggdn_fft_create(plggdn_fft_attr *attr);
    
    int plggdn_fft_init(struct plggdn_fft_t *ptr, plggdn_fft_attr *attr);

    int plggdn_fft_fwd_r2c(struct plggdn_fft_t *ptr, double *in,  plggdn_complex *out);

    int plggdn_fft_inv_c2r(struct plggdn_fft_t *ptr, plggdn_complex *in, double *out);

    int plggdn_fft_fwd(struct plggdn_fft_t *ptr, plggdn_complex *in, plggdn_complex *out);

    int plggdn_fft_inv(struct plggdn_fft_t *ptr, plggdn_complex *in, plggdn_complex *out);

    int plggdn_fft_deinit(struct plggdn_fft_t *ptr);
    
    int plggdn_fft_release(struct plggdn_fft_t **ptr);
    
#ifdef	__cplusplus
}
#endif

#endif	/* PLGGDN_FFT_H */

