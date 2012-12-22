//#include "com_pluggedin_dsp_ComplexJNI_help.h"
#include "com_pluggedin_dsp_FFTJNI.h"

#include "plggdn_fft.h"
#include "plggdn_fft_base.h"
#include "plggdn_fft_FFTW.h"

#include <stdio.h>
#include <memory.h>

#ifndef PLGGDN_USE_FLOAT_PRECISION
jdoubleArray plggdn_create_float_array_jni(JNIEnv *env, plggdn_float *in, int N, int javaOwnMem) {
    jdoubleArray out = (*env)->NewDoubleArray(env, N);
    (*env)->SetDoubleArrayRegion(env, out, 0, N, in);    

    // we can safely release primitive-mapped array
    return out;
}
#else
jdoubleArray plggdn_create_float_array_jni(JNIEnv *env, plggdn_float *in, int N, int javaOwnMem) {
    jfloatArray out = (*env)->NewFloatArray(env, N);
    (*env)->SetFloatArrayRegion(env, out, 0, N, in);        
    return out;
}
#endif

JNIEXPORT jlong JNICALL Java_com_pluggedin_dsp_FFTJNI_create
  (JNIEnv *env, jclass cls, jint N) {    
    
    plggdn_fft_attr fftw = {
        .N = N,
        .opaque = 0,
        .impl = &plggdn_fft_fftw_vt
    };
    
    return (jlong) plggdn_fft_create(&fftw);
}

JNIEXPORT void JNICALL Java_com_pluggedin_dsp_FFTJNI_destroy
  (JNIEnv *env, jclass cls, jlong ptr) {
    plggdn_fft_release((plggdn_fft_t**)&ptr);
}

//JNIEXPORT jobjectArray JNICALL Java_com_pluggedin_dsp_FFTJNI_fwd
//  (JNIEnv *env, jclass cls, jlong ptr, jobjectArray jIn) {
//    plggdn_fft_t *fft = (plggdn_fft_t*)ptr;
//    
//    /** fetch data from input array*/
//    int n_elem = (*env)->GetArrayLength(env, jIn);
//    for(int i=0; i<n_elem; i++) {
//        jobject element = (*env)->GetObjectArrayElement(env, jIn, i);
//        jclass cls = (*env)->GetObjectClass(env, element);
//        jfieldID field = (*env)->GetFieldID(env, cls, "cPtr", "J");
//        jlong elem_ptr = (*env)->GetLongField(env, element, field);
//        
//        // assign value to internally allocd memory
//        _plggdn_fft(fft)->complex_in[i] = *(plggdn_complex*)elem_ptr;
//    }
//    
//    /** transform*/
//    _plggdn_fft_vt(fft)->fft(fft, _plggdn_fft(fft)->complex_in, _plggdn_fft(fft)->complex_out);
//    
//    /** return back internal data struct wrapped in Complex[] Java array*/
//    return plggdn_create_complex_array_jni(env, _plggdn_fft(fft)->complex_out, n_elem, 0);
//}
//
//JNIEXPORT jobjectArray JNICALL Java_com_pluggedin_dsp_FFTJNI_inv
//  (JNIEnv *env, jclass cls, jlong ptr, jobjectArray jIn) {
//    plggdn_fft_t *fft = (plggdn_fft_t*)ptr;
//    
//    /** fetch data from input array*/
//    int n_elem = (*env)->GetArrayLength(env, jIn);
//    for(int i=0; i<n_elem; i++) {
//        jobject element = (*env)->GetObjectArrayElement(env, jIn, i);
//        jclass cls = (*env)->GetObjectClass(env, element);
//        jfieldID field = (*env)->GetFieldID(env, cls, "cPtr", "J");
//        jlong elem_ptr = (*env)->GetLongField(env, element, field);
//        
//        // assign value directly to internally allocd memory
//        _plggdn_fft(fft)->complex_in[i] = *(plggdn_complex*)elem_ptr;
//    }
//    
//    /** transform*/
//    _plggdn_fft_vt(fft)->ifft(fft, _plggdn_fft(fft)->complex_in, _plggdn_fft(fft)->complex_out);
//    
//    /** return back internal data struct wrapped in new Complex[] Java array, with memory owned by C*/
//    return plggdn_create_complex_array_jni(env, _plggdn_fft(fft)->complex_out, n_elem, 0);
//}
//
//JNIEXPORT jobjectArray JNICALL Java_com_pluggedin_dsp_FFTJNI_fwd_r2c
//  (JNIEnv *env, jclass cls, jlong ptr, jdoubleArray jIn) {
//    plggdn_fft_t *fft = (plggdn_fft_t*)ptr;
//    
//    /** fetch data from input array*/
//    int n_elem = (*env)->GetArrayLength(env, jIn);
//    jdouble *elems = (*env)->GetPrimitiveArrayCritical(env, jIn, 0);
//    if(!elems) // memory exception
//        goto memory_exception;
//    
//    memcpy(_plggdn_fft(fft)->real_in, elems, sizeof(double) * n_elem);
//    (*env)->ReleasePrimitiveArrayCritical(env, jIn, elems, 0);
//    
//    /** transform*/
//    _plggdn_fft_vt(fft)->fft_r2c(fft, _plggdn_fft(fft)->real_in, _plggdn_fft(fft)->complex_out);
//    
//    /** return back internal data struct wrapped in new Complex[] Java array, with memory owned by C*/
//    return plggdn_create_complex_array_jni(env, _plggdn_fft(fft)->complex_out, n_elem, 0);
//    
//    memory_exception:
//    (*env)->ReleasePrimitiveArrayCritical(env, jIn, elems, 0);
//    return NULL;
//}
//
//JNIEXPORT jdoubleArray JNICALL Java_com_pluggedin_dsp_FFTJNI_inv_c2r
//  (JNIEnv *env, jclass cls, jlong ptr, jobjectArray jIn) {
//    plggdn_fft_t *fft = (plggdn_fft_t*)ptr;
//    
//    /** fetch data from input array*/
//    int n_elem = (*env)->GetArrayLength(env, jIn);
//    for(int i=0; i<n_elem; i++) {
//        jobject element = (*env)->GetObjectArrayElement(env, jIn, i);
//        jclass cls = (*env)->GetObjectClass(env, element);
//        jfieldID field = (*env)->GetFieldID(env, cls, "cPtr", "J");
//        jlong elem_ptr = (*env)->GetLongField(env, element, field);
//        
//        // assign value directly to internally allocd memory
//        _plggdn_fft(fft)->complex_in[i] = *(plggdn_complex*)elem_ptr;
//    }
//    
//    /** transform*/
//    _plggdn_fft_vt(fft)->ifft_c2r(fft, _plggdn_fft(fft)->complex_in, _plggdn_fft(fft)->real_out);
//    
//    /** return back internal data struct wrapped in new Complex[] Java array, with memory owned by C*/
//    return plggdn_create_float_array_jni(env, _plggdn_fft(fft)->real_out, n_elem, 0);
//}

JNIEXPORT jint JNICALL Java_com_pluggedin_dsp_FFTJNI_fwd
  (JNIEnv *env, jclass cls, jlong ptr, jdoubleArray jIn, jdoubleArray jOut) {
    plggdn_fft_t *fft = *(plggdn_fft_t**)&ptr;
    
    /** fetch data from input array*/
    jint err = 0, n_elem = (*env)->GetArrayLength(env, jIn);
    jdouble *in = (jdouble*) (*env)->GetPrimitiveArrayCritical(env, jIn, 0);
    if(!in) {
        err = 1;
        goto exception;
    }
    memcpy((void*)fft->complex_in, (void*)in, sizeof(plggdn_float) * n_elem);
    (*env)->ReleasePrimitiveArrayCritical(env, jIn, in, 0);
    in = NULL;
    
    /** transform*/
    err = (jint) fft->vtable->fft(fft, fft->complex_in, fft->complex_out);
    if(err != 0)
        goto exception;
    
    jdouble *out = (jdouble*) (*env)->GetPrimitiveArrayCritical(env, jOut, 0);
    if(!out)
        goto exception;
    
    n_elem = (*env)->GetArrayLength(env, jOut);
    memcpy((void*)out, (void*)fft->complex_out, sizeof(plggdn_float) * n_elem);
    
    exception:
    if(in)
        (*env)->ReleasePrimitiveArrayCritical(env, jIn, in, 0);
    if(out)
        (*env)->ReleasePrimitiveArrayCritical(env, jOut, out, 0);
    
    return err;
}

JNIEXPORT jint JNICALL Java_com_pluggedin_dsp_FFTJNI_inv
  (JNIEnv *env, jclass cls, jlong ptr, jdoubleArray jIn, jdoubleArray jOut) {
    plggdn_fft_t *fft = *(plggdn_fft_t**)&ptr;
    
    /** fetch data from input array*/
    jint err = 0, n_elem = (*env)->GetArrayLength(env, jIn);
    jdouble *in = (jdouble*) (*env)->GetPrimitiveArrayCritical(env, jIn, 0);
    if(!in) {
        err = 1;
        goto exception;
    }
    
    memcpy((void*)fft->complex_in, (void*)in, sizeof(plggdn_float) * n_elem);
    (*env)->ReleasePrimitiveArrayCritical(env, jIn, in, 0);
    in = NULL;
    
    /** transform*/
    err = (jint) fft->vtable->ifft(fft, fft->complex_in, fft->complex_out);
    if(err != 0)
        goto exception;
    
    jdouble *out = (jdouble*) (*env)->GetPrimitiveArrayCritical(env, jOut, 0);
    if(!out) {
        err = 1;
        goto exception;
    }
    
    n_elem = (*env)->GetArrayLength(env, jOut);
    memcpy((void*)out, (void*)fft->complex_out, sizeof(plggdn_float) * n_elem);
    
    exception:
    if(in)
        (*env)->ReleasePrimitiveArrayCritical(env, jIn, in, 0);
    if(out)
        (*env)->ReleasePrimitiveArrayCritical(env, jOut, out, 0);
    
    return err;
}

JNIEXPORT jint JNICALL Java_com_pluggedin_dsp_FFTJNI_fwd_1r2c
  (JNIEnv *env, jclass cls, jlong ptr, jdoubleArray jIn, jdoubleArray jOut) {
    plggdn_fft_t *fft = *(plggdn_fft_t**)&ptr;
    
    /** fetch data from input array*/
    printf("fetch\n");
    jint err = 0, n_elem = (*env)->GetArrayLength(env, jIn);
    jdouble *in = (jdouble*) (*env)->GetPrimitiveArrayCritical(env, jIn, 0);
    if(!in) {
        err = 1;
        goto exception;
    }
    memcpy(fft->real_in, in, sizeof(plggdn_float) * n_elem);
    (*env)->ReleasePrimitiveArrayCritical(env, jIn, in, 0);
    in = NULL;
    
    /** transform*/
    printf("transform\n");
    err = (jint) fft->vtable->fft_r2c(fft, fft->real_in, fft->complex_out);
    if(err != 0)
        goto exception;
    
    printf("copy back\n");
    jdouble *out = (jdouble*) (*env)->GetPrimitiveArrayCritical(env, jOut, 0);
    if(!out) {
        err = 1;
        goto exception;
    }
    n_elem = (*env)->GetArrayLength(env, jOut);
    memcpy((void*)out, (void*)fft->complex_out, sizeof(plggdn_float) * n_elem);
    
    exception:
    if(in)
        (*env)->ReleasePrimitiveArrayCritical(env, jIn, in, 0);
    if(out)
        (*env)->ReleasePrimitiveArrayCritical(env, jOut, out, 0);
    
    return err;
}

JNIEXPORT jint JNICALL Java_com_pluggedin_dsp_FFTJNI_inv_1c2r
  (JNIEnv *env, jclass cls, jlong ptr, jdoubleArray jIn, jdoubleArray jOut) {
    plggdn_fft_t *fft = *(plggdn_fft_t**)&ptr;
    
    printf("fetch\n");
    /** fetch data from input array*/
    jint err = 0, n_elem = (*env)->GetArrayLength(env, jIn);
    jdouble *in = (jdouble*) (*env)->GetPrimitiveArrayCritical(env, jIn, 0);
    if(!in) {
        err = 1;
        goto exception;
    }
    memcpy((void*)fft->complex_in, (void*)in, sizeof(plggdn_float) * n_elem);
    (*env)->ReleasePrimitiveArrayCritical(env, jIn, in, 0);
    in = NULL;
    
    /** transform*/
    printf("transform\n");
    err = (jint) fft->vtable->ifft_c2r(fft, fft->complex_in, fft->real_out);
    if(err != 0)
        goto exception;
    
    printf("copy back\n");
    jdouble *out = (jdouble*) (*env)->GetPrimitiveArrayCritical(env, jOut, 0);
    if(!out) {
        err = 1;
        goto exception;
    }
    n_elem = (*env)->GetArrayLength(env, jOut);
    memcpy(out, fft->real_out, sizeof(plggdn_float) * n_elem);
    
    exception:
    if(in)
        (*env)->ReleasePrimitiveArrayCritical(env, jIn, in, 0);
    if(out)
        (*env)->ReleasePrimitiveArrayCritical(env, jOut, out, 0);
    
    return err;
}