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

plggdn_fft_t *plggdn_fft_create(plggdn_fft_attr *attr) {
    plggdn_fft_t *ptr = (plggdn_fft_t*) malloc(sizeof(plggdn_fft_t));
    memset(ptr, 0, sizeof(plggdn_fft_t));
        
    plggdn_fft_init(ptr, attr);
    
    return ptr;
}

int plggdn_fft_init(plggdn_fft_t *fft, plggdn_fft_attr *attr) {
    fft->N = attr->N;
    
    fft->vtable = attr->impl;
    
    /**call constructor routine*/    
    return fft->vtable->init(fft, attr->opaque);
}

int plggdn_fft_fwd_r2c(plggdn_fft_t *fft, double *in,  plggdn_complex *out) {
    return fft->vtable->fft_r2c(fft, in, out);
}

int plggdn_fft_inv_c2r(plggdn_fft_t *fft, plggdn_complex *in, double *out) {
    return fft->vtable->ifft_c2r(fft, in, out);
}

int plggdn_fft_fwd(plggdn_fft_t *fft, plggdn_complex *in, plggdn_complex *out) {
    return fft->vtable->fft(fft, in, out);
}

int plggdn_fft_inv(plggdn_fft_t *fft, plggdn_complex *in, plggdn_complex *out) {
    return fft->vtable->ifft(fft, in, out);
}

int plggdn_fft_deinit(plggdn_fft_t *fft) {
    return fft->vtable->deinit(fft);  
}

int plggdn_fft_release(plggdn_fft_t **ptr) {          
    plggdn_fft_deinit(*ptr);
    free(*ptr);
    *ptr = NULL;
    return 0;
}
