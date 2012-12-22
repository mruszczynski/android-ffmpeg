#include "plggdn_fft_FFTW.h"
#include "plggdn_fft_base.h"
#include <stdlib.h>
#include <memory.h>

plggdn_float *_plggdn_float_alloc_fftw(int N) {
    return fftw_alloc_real(N);
}

plggdn_complex *_plggdn_complex_alloc_fftw(int N) {
    return fftw_alloc_complex(N);//sizeof(plggdn_complex));
}

void _plggdn_free_fftw(void *c) {
    fftw_free((void*)c);
}

plggdn_fft_kernel_vtable plggdn_fft_fftw_vt = {
            &plggdn_fft_init_fftw,
            &plggdn_fft_deinit_fftw,

            &plggdn_fft_r2c_fftw,
            &plggdn_ifft_c2r_fftw,
            &plggdn_fft_fftw,
            &plggdn_ifft_fftw        
        };

int plggdn_fft_init_fftw(plggdn_fft_t *fft, void *opaque) {
        // init data memory, plggdn_fft_t stores only pointers, 
        // all memory operations take place in this implementation
        fft->real_in = (plggdn_float*) fftw_malloc(sizeof(plggdn_float) * fft->N);

        fft->complex_in = (fftw_complex*) fftw_malloc(sizeof(fftw_complex) * fft->N);

        fft->real_out = (plggdn_float*) fftw_malloc(sizeof(plggdn_float) * fft->N);

        fft->complex_out = (fftw_complex*) fftw_malloc(sizeof(fftw_complex) * fft->N);
                
        plggdn_fft_fftw_attr *fftw_attr = 
                (plggdn_fft_fftw_attr*) malloc(sizeof(plggdn_fft_fftw_attr));
        memset(fftw_attr, 0, sizeof(plggdn_fft_fftw_attr));
        
        fft->opaque = fftw_attr;
        
        // init plans                
        fftw_attr->p[FWD_R2C] = fftw_plan_dft_r2c_1d(fft->N, fft->real_in, fft->complex_out, FFTW_MEASURE);
        fftw_attr->p[INV_C2R] = fftw_plan_dft_c2r_1d(fft->N, fft->complex_in, fft->real_out, FFTW_MEASURE);
        
        fftw_attr->p[FWD_C2C] = fftw_plan_dft_1d(fft->N, fft->complex_in, fft->complex_out, FFTW_FORWARD, FFTW_MEASURE);
        fftw_attr->p[INV_C2C] = fftw_plan_dft_1d(fft->N, fft->complex_in, fft->complex_out, FFTW_BACKWARD, FFTW_MEASURE);
        
        return 0;
    }

    int plggdn_fft_r2c_fftw(plggdn_fft_t *fft, plggdn_float *in,  plggdn_complex *out) {
        // copy input to transform input array
        memcpy(fft->real_in, in, sizeof(plggdn_float) * fft->N);
        // execute transform
        plggdn_fft_fftw_attr *fftw_attr = fft->opaque;
        fftw_execute(fftw_attr->p[FWD_R2C]);
        // copy from transform output to output array
        memcpy(out, fft->complex_out, sizeof(plggdn_complex) * fft->N);
        return 0;
    }

    int plggdn_ifft_c2r_fftw(plggdn_fft_t *fft, plggdn_complex *in, plggdn_float *out) {
        // copy input to transform input array
        memcpy(fft->complex_in, in, sizeof(plggdn_complex) * fft->N);
        // execute transform
        plggdn_fft_fftw_attr *fftw_attr = fft->opaque;
        fftw_execute(fftw_attr->p[INV_C2R]);
        // copy from transform output to output array
        memcpy(out, fft->real_out, sizeof(plggdn_float) * fft->N);
        return 0;
    }

    int plggdn_fft_fftw(plggdn_fft_t *fft, plggdn_complex *in, plggdn_complex *out) {
        // copy input to transform input array
        memcpy(fft->complex_in, in, sizeof(plggdn_complex) * fft->N);
        // execute transform
        plggdn_fft_fftw_attr *fftw_attr = fft->opaque;
        fftw_execute(fftw_attr->p[FWD_C2C]);
        // copy from transform output to output array
        memcpy(out, fft->complex_out, sizeof(plggdn_complex) * fft->N);
        return 0;
    }

    int plggdn_ifft_fftw(plggdn_fft_t *fft, plggdn_complex *in, plggdn_complex *out) {
        // copy input to transform input array
        memcpy(fft->complex_in, in, sizeof(plggdn_complex) * fft->N);
        // execute transform
        plggdn_fft_fftw_attr *fftw_attr = fft->opaque;
        fftw_execute(fftw_attr->p[INV_C2C]);
        // copy from transform output to output array
        memcpy(out, fft->complex_out, sizeof(plggdn_complex) * fft->N);
        return 0;
    }

    int plggdn_fft_deinit_fftw(plggdn_fft_t *fft) {
        // free data memory
        fftw_free(fft->real_in);
        fftw_free(fft->real_out);
        fftw_free(fft->complex_in);
        fftw_free(fft->complex_out);
        
        plggdn_fft_fftw_attr *fftw_attr = fft->opaque;
        // free plans
        for(int i=0; i<4; i++) {
            fftw_destroy_plan(fftw_attr->p[i]);
        }
        
        return 0;
    }
