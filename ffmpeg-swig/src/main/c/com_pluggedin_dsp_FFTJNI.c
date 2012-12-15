#include "com_pluggedin_dsp_ComplexJNI_help.h"
#include "com_pluggedin_dsp_FFTJNI.h"

#include "plggdn_fft.h"
#include "plggdn_fft_base.h"

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

/*
 * Class:     com_pluggedin_fft_FFTJNI
 * Method:    create
 * Signature: (I)J
 */
JNIEXPORT jlong JNICALL Java_com_pluggedin_dsp_FFTJNI_create
  (JNIEnv *env, jclass cls, jint N) {    
    return (jlong) plggdn_fft_create(N);
}

/*
 * Class:     com_pluggedin_fft_FFTJNI
 * Method:    destroy
 * Signature: (J)V
 */
JNIEXPORT void JNICALL Java_com_pluggedin_dsp_FFTJNI_destroy
  (JNIEnv *env, jclass cls, jlong ptr) {
    plggdn_fft_release((plggdn_fft_t**)&ptr);
}

/*
 * Class:     com_pluggedin_fft_FFTJNI
 * Method:    fwd
 * Signature: (J[Lcom/pluggedin/fft/Complex;)[Lcom/pluggedin/fft/Complex;
 */
JNIEXPORT jobjectArray JNICALL Java_com_pluggedin_dsp_FFTJNI_fwd
  (JNIEnv *env, jclass cls, jlong ptr, jobjectArray jIn) {
    plggdn_fft_t *fft = (plggdn_fft_t*)ptr;
    
    /** fetch data from input array*/
    int n_elem = (*env)->GetArrayLength(env, jIn);
    for(int i=0; i<n_elem; i++) {
        jobject element = (*env)->GetObjectArrayElement(env, jIn, i);
        jclass cls = (*env)->GetObjectClass(env, element);
        jfieldID field = (*env)->GetFieldID(env, cls, "cPtr", "J");
        jlong elem_ptr = (*env)->GetLongField(env, element, field);
        
        // assign value to internally allocd memory
        _plggdn_fft(fft)->complex_in[i] = *(plggdn_complex*)elem_ptr;
    }
    
    /** transform*/
    _plggdn_fft_vt(fft)->fft(fft, _plggdn_fft(fft)->complex_in, _plggdn_fft(fft)->complex_out);
    
    /** return back internal data struct wrapped in Complex[] Java array*/
    return plggdn_create_complex_array_jni(env, _plggdn_fft(fft)->complex_out, n_elem, 0);
}

/*
 * Class:     com_pluggedin_fft_FFTJNI
 * Method:    inv
 * Signature: (J[Lcom/pluggedin/fft/Complex;)[Lcom/pluggedin/fft/Complex;
 */
JNIEXPORT jobjectArray JNICALL Java_com_pluggedin_dsp_FFTJNI_inv
  (JNIEnv *env, jclass cls, jlong ptr, jobjectArray jIn) {
    plggdn_fft_t *fft = (plggdn_fft_t*)ptr;
    
    /** fetch data from input array*/
    int n_elem = (*env)->GetArrayLength(env, jIn);
    for(int i=0; i<n_elem; i++) {
        jobject element = (*env)->GetObjectArrayElement(env, jIn, i);
        jclass cls = (*env)->GetObjectClass(env, element);
        jfieldID field = (*env)->GetFieldID(env, cls, "cPtr", "J");
        jlong elem_ptr = (*env)->GetLongField(env, element, field);
        
        // assign value directly to internally allocd memory
        _plggdn_fft(fft)->complex_in[i] = *(plggdn_complex*)elem_ptr;
    }
    
    /** transform*/
    _plggdn_fft_vt(fft)->ifft(fft, _plggdn_fft(fft)->complex_in, _plggdn_fft(fft)->complex_out);
    
    /** return back internal data struct wrapped in new Complex[] Java array, with memory owned by C*/
    return plggdn_create_complex_array_jni(env, _plggdn_fft(fft)->complex_out, n_elem, 0);
}

/*
 * Class:     com_pluggedin_fft_FFTJNI
 * Method:    fwd_r2c
 * Signature: (J[D)Lcom/pluggedin/fft/Complex;
 */
JNIEXPORT jobjectArray JNICALL Java_com_pluggedin_dsp_FFTJNI_fwd_1r2c
  (JNIEnv *env, jclass cls, jlong ptr, jdoubleArray jIn) {
    plggdn_fft_t *fft = (plggdn_fft_t*)ptr;
    
    /** fetch data from input array*/
    int n_elem = (*env)->GetArrayLength(env, jIn);
    jdouble *elems = (*env)->GetDoubleArrayElements(env, jIn, NULL);
    for(int i=0; i<n_elem; i++) {
        
        // assign value directly to internally allocd memory
        _plggdn_fft(fft)->real_in[i] = elems[i];
    }
    
    /** transform*/
    _plggdn_fft_vt(fft)->fft_r2c(fft, _plggdn_fft(fft)->real_in, _plggdn_fft(fft)->complex_out);
    
    /** return back internal data struct wrapped in new Complex[] Java array, with memory owned by C*/
    return plggdn_create_complex_array_jni(env, _plggdn_fft(fft)->complex_out, n_elem, 0);
}

/*
 * Class:     com_pluggedin_fft_FFTJNI
 * Method:    inv_c2r
 * Signature: (J[Lcom/pluggedin/fft/Complex;)[D
 */
JNIEXPORT jdoubleArray JNICALL Java_com_pluggedin_dsp_FFTJNI_inv_1c2r
  (JNIEnv *env, jclass cls, jlong ptr, jobjectArray jIn) {
    plggdn_fft_t *fft = (plggdn_fft_t*)ptr;
    
    /** fetch data from input array*/
    int n_elem = (*env)->GetArrayLength(env, jIn);
    for(int i=0; i<n_elem; i++) {
        jobject element = (*env)->GetObjectArrayElement(env, jIn, i);
        jclass cls = (*env)->GetObjectClass(env, element);
        jfieldID field = (*env)->GetFieldID(env, cls, "cPtr", "J");
        jlong elem_ptr = (*env)->GetLongField(env, element, field);
        
        // assign value directly to internally allocd memory
        _plggdn_fft(fft)->complex_in[i] = *(plggdn_complex*)elem_ptr;
    }
    
    /** transform*/
    _plggdn_fft_vt(fft)->ifft_c2r(fft, _plggdn_fft(fft)->complex_in, _plggdn_fft(fft)->real_out);
    
    /** return back internal data struct wrapped in new Complex[] Java array, with memory owned by C*/
    return plggdn_create_float_array_jni(env, _plggdn_fft(fft)->real_out, n_elem, 0);
}