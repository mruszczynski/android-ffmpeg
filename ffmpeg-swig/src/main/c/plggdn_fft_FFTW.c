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

plggdn_fft_kernel_vtable plggdn_fft_implement_fftw = {
            &plggdn_fft_init_fftw,
            &plggdn_fft_deinit_fftw,

            &plggdn_fft_r2c_fftw,
            &plggdn_ifft_c2r_fftw,
            &plggdn_fft_fftw,
            &plggdn_ifft_fftw        
        };

int plggdn_fft_init_fftw(plggdn_fft_t *ptr) {
        plggdn_fftw_attr *attr = (plggdn_fftw_attr*) malloc(sizeof(plggdn_fftw_attr));
        
        _plggdn_fft(ptr)->priv = attr;
        
        // init data memory, plggdn_fft_t stores only pointers, 
        // all memory operations take place in this implementation
        _plggdn_fft(ptr)->real_in = 
                attr->real_in = (plggdn_float*) fftw_malloc(sizeof(plggdn_float) * _plggdn_fft(ptr)->N);
        
        _plggdn_fft(ptr)->complex_in = 
                attr->complex_in = (fftw_complex*) fftw_malloc(sizeof(fftw_complex) * _plggdn_fft(ptr)->N);
        
        _plggdn_fft(ptr)->real_out = 
                attr->real_out = (plggdn_float*) fftw_malloc(sizeof(plggdn_float) * _plggdn_fft(ptr)->N);
        
        _plggdn_fft(ptr)->complex_out = 
                attr->complex_out = (fftw_complex*) fftw_malloc(sizeof(fftw_complex) * _plggdn_fft(ptr)->N);
        
        // init plans
        attr->p[FWD_R2C] = fftw_plan_dft_r2c_1d(_plggdn_fft(ptr)->N, attr->real_in, attr->complex_out, FFTW_MEASURE);
        attr->p[INV_C2R] = fftw_plan_dft_c2r_1d(_plggdn_fft(ptr)->N, attr->complex_in, attr->real_out, FFTW_MEASURE);
        
        attr->p[FWD_C2C] = fftw_plan_dft_1d(_plggdn_fft(ptr)->N, attr->complex_in, attr->complex_out, FFTW_FORWARD, FFTW_MEASURE);
        attr->p[INV_C2C] = fftw_plan_dft_1d(_plggdn_fft(ptr)->N, attr->complex_in, attr->complex_out, FFTW_BACKWARD, FFTW_MEASURE);
        
        return 0;
    }

    int plggdn_fft_r2c_fftw(plggdn_fft_t *ptr, plggdn_float *in,  plggdn_complex *out) {
        plggdn_fftw_attr *attr = (plggdn_fftw_attr*) _plggdn_fft(ptr)->priv;
        // copy input to transform input array
        memcpy(attr->real_in, in, sizeof(plggdn_float) * _plggdn_fft(ptr)->N);
        // execute transform
        fftw_execute(attr->p[FWD_R2C]);
        // copy from transform output to output array
        memcpy(out, attr->complex_out, sizeof(plggdn_complex) * _plggdn_fft(ptr)->N);
        return 0;
    }

    int plggdn_ifft_c2r_fftw(plggdn_fft_t *ptr, plggdn_complex *in, plggdn_float *out) {
        plggdn_fftw_attr *attr = (plggdn_fftw_attr*) _plggdn_fft(ptr)->priv;
        // copy input to transform input array
        memcpy(attr->complex_in, in, sizeof(plggdn_complex) * _plggdn_fft(ptr)->N);
        // execute transform
        fftw_execute(attr->p[INV_C2R]);
        // copy from transform output to output array
        memcpy(out, attr->real_out, sizeof(plggdn_float) * _plggdn_fft(ptr)->N);
        return 0;
    }

    int plggdn_fft_fftw(plggdn_fft_t *ptr, plggdn_complex *in, plggdn_complex *out) {
        plggdn_fftw_attr *attr = (plggdn_fftw_attr*) _plggdn_fft(ptr)->priv;
        // copy input to transform input array
        memcpy(attr->complex_in, in, sizeof(plggdn_complex) * _plggdn_fft(ptr)->N);
        // execute transform
        fftw_execute(attr->p[FWD_C2C]);
        // copy from transform output to output array
        memcpy(out, attr->complex_out, sizeof(plggdn_complex) * _plggdn_fft(ptr)->N);
        return 0;
    }

    int plggdn_ifft_fftw(plggdn_fft_t *ptr, plggdn_complex *in, plggdn_complex *out) {
        plggdn_fftw_attr *attr = (plggdn_fftw_attr*) _plggdn_fft(ptr)->priv;
        // copy input to transform input array
        memcpy(attr->complex_in, in, sizeof(plggdn_complex) * _plggdn_fft(ptr)->N);
        // execute transform
        fftw_execute(attr->p[INV_C2C]);
        // copy from transform output to output array
        memcpy(out, attr->complex_out, sizeof(plggdn_complex) * _plggdn_fft(ptr)->N);
        return 0;
    }

    int plggdn_fft_deinit_fftw(plggdn_fft_t *ptr) {
        plggdn_fftw_attr *attr = (plggdn_fftw_attr*) _plggdn_fft(ptr)->priv;
        
        // free data memory
        fftw_free(attr->real_in);
        fftw_free(attr->real_out);
        fftw_free(attr->complex_in);
        fftw_free(attr->complex_out);
        
        // free plans
        for(int i=0; i<4; i++) {
            fftw_destroy_plan(attr->p[i]);
        }
        
        return 0;
    }
