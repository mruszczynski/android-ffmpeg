/* 
 * File:   plggdn_fft_FFTW.h
 * Author: michu
 *
 * Created on 7 grudzień 2012, 00:19
 */

#ifndef PLGGDN_FFT_FFTW_H
#define	PLGGDN_FFT_FFTW_H

#ifdef	__cplusplus
extern "C" {
#endif
    
    #include "plggdn_fft.h"
    #include "fftw3.h"
#include "plggdn_fft_base.h"

    enum plan_type {FWD_R2C=0, INV_C2R=1, FWD_C2C=2, INV_C2C=3 };
    
    plggdn_float *_plggdn_float_alloc_fftw(int N);    
    plggdn_complex *_plggdn_complex_alloc_fftw(int N);
    void _plggdn_free_fftw(void *c);

    typedef struct plggdn_fft_fftw_attr {
//        union {
//            plggdn_fft_t fft;
//        } base;
//        plggdn_complex *complex_in, *complex_out;
//        double *real_in, *real_out;
//        
        fftw_plan p[4];
        unsigned flags;    
    } plggdn_fft_fftw_attr;
    
//    typedef struct plggdn_fft_fftw_t {
//        union {
//            plggdn_fft_fftw_attr fftw;
//            plggdn_fft_attr fft;
//        } base;
//        
//        #define _plggdn_fft_fftw(self) (&(self)->base.fftw)
//    } plggdn_fft_fftw_t;
    
    int plggdn_fft_init_fftw(plggdn_fft_t *ptr, void *opaque);

    int plggdn_fft_r2c_fftw(plggdn_fft_t *ptr, double *in,  plggdn_complex *out);

    int plggdn_ifft_c2r_fftw(plggdn_fft_t *ptr, plggdn_complex *in, double *out);

    int plggdn_fft_fftw(plggdn_fft_t *ptr, plggdn_complex *in, plggdn_complex *out);

    int plggdn_ifft_fftw(plggdn_fft_t *ptr, plggdn_complex *in, plggdn_complex *out);

    int plggdn_fft_deinit_fftw(plggdn_fft_t *ptr);
    
    extern struct plggdn_fft_kernel_vtable plggdn_fft_fftw_vt;
    
#ifdef	__cplusplus
}
#endif

#endif	/* PLGGDN_FFT_FFTW_H */

