/* 
 * File:   plggdn_fft.c
 * Author: michu
 *
 * Created on 5 grudzień 2012, 21:57
 */

#include <stdio.h>
#include <stdlib.h>
#include <memory.h>

#include "plggdn_fft_base.h"

//plggdn_float *(*plggdn_float_malloc)(size_t N);
//plggdn_complex *(*plggdn_complex_malloc)(size_t N);
//void (*plggdn_free)(void *c) ;

#ifdef PLGGDN_USE_FFTW
    #include "plggdn_fft_FFTW.h"

    plggdn_float *(*plggdn_float_malloc)(int N) = &_plggdn_float_alloc_fftw;
    plggdn_complex *(*plggdn_complex_malloc)(int N) = &_plggdn_complex_alloc_fftw;
    void (*plggdn_free)(void *c) = &_plggdn_free_fftw;
#else
    plggdn_float *(*plggdn_float_malloc)(int N) = &_plggdn_float_alloc;
    plggdn_complex *(*plggdn_complex_malloc)(int N) = &_plggdn_complex_alloc;
    void (*plggdn_free)(void *c) = &_plggdn_free;
#endif
    
plggdn_float *_plggdn_float_alloc(int N) {
    return malloc(sizeof(plggdn_float) * N); 
}

plggdn_complex *_plggdn_complex_alloc(int N) {
    return malloc(sizeof(plggdn_complex) * N);
}

void _plggdn_free(void *ptr) {
    free(ptr);
}
    
plggdn_complex *plggdn_complex_create2(double re, double im) {
    plggdn_complex *c = plggdn_complex_malloc(1);
    __real__ *c = re;
    __imag__ *c = im;
    return c;
}

void plggdn_freep(void **c) {
    plggdn_free(*c);
    *c = 0;
}

plggdn_fft_t *plggdn_fft_create(int N) {
    plggdn_fft_t *ptr = (plggdn_fft_t*) malloc(sizeof(plggdn_fft_t));
    
    plggdn_fft_init(ptr, N);
    
    return ptr;
}

int plggdn_fft_init(plggdn_fft_t *ptr, int N) {
    /**set implementation*/
#ifdef PLGGDN_USE_FFTW
    _plggdn_fft_vt(ptr) = &plggdn_fft_implement_fftw;
#else
    printf("PLGGDN_USE_FFTW not defined, no other implementation exists, exiting...\n");
    exit(1);
#endif
    
    _plggdn_fft(ptr)->N = N;
    
    /**call constructor routine*/    
    _plggdn_fft_vt(ptr)->init(ptr);
}

int plggdn_fft_fwd_r2c(plggdn_fft_t *ptr, double *in,  plggdn_complex *out) {
    return _plggdn_fft_vt(ptr)->fft_r2c(ptr, in, out);
}

int plggdn_fft_inv_c2r(plggdn_fft_t *ptr, plggdn_complex *in, double *out) {
    return _plggdn_fft_vt(ptr)->ifft_c2r(ptr, in, out);
}

int plggdn_fft_fwd(plggdn_fft_t *ptr, plggdn_complex *in, plggdn_complex *out) {
    return _plggdn_fft_vt(ptr)->fft(ptr, in, out);
}

int plggdn_fft_inv(plggdn_fft_t *ptr, plggdn_complex *in, plggdn_complex *out) {
    return _plggdn_fft_vt(ptr)->ifft(ptr, in, out);
}

int plggdn_fft_deinit(plggdn_fft_t *ptr) {
    return _plggdn_fft_vt(ptr)->deinit(ptr);  
}

int plggdn_fft_release(plggdn_fft_t **ptr) {          
    plggdn_fft_deinit(*ptr);
    free(*ptr);
    *ptr = NULL;
}
