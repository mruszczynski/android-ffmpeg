#include "com_pluggedin_dsp_AECJNI.h"
#include <stdlib.h>

#include "plggdn_aec.h"
#include "plggdn_aec_speex.h"

/*
 * Class:     com_pluggedin_dsp_AECJNI
 * Method:    create
 * Signature: (II)J
 */
JNIEXPORT jlong JNICALL Java_com_pluggedin_dsp_AECJNI_create
  (JNIEnv *env, jclass cls, jint frame_size, jint filter_length) {
    
    plggdn_aec_base_attr args = {
        .frame_size = frame_size,
        .filter_length = filter_length
    };
    
    // pick speex implementation
    return (jlong) plggdn_aec_create(&plggdn_aec_speex_vt, &args);
}

/*
 * Class:     com_pluggedin_dsp_AECJNI
 * Method:    destroy
 * Signature: (J)V
 */
JNIEXPORT void JNICALL Java_com_pluggedin_dsp_AECJNI_destroy
  (JNIEnv *env, jclass cls, jlong ptr) {
    
    plggdn_aec_release((plggdn_aec_t**)&ptr);
    
}

/*
 * Class:     com_pluggedin_dsp_AECJNI
 * Method:    echo_cancel
 * Signature: (J[S[S)[S
 */
JNIEXPORT jshortArray JNICALL Java_com_pluggedin_dsp_AECJNI_echo_1cancel
  (JNIEnv *env, jclass cls, jlong ptr, jshortArray input, jshortArray echo) {
    
    plggdn_aec_t *aec = (plggdn_aec_t*)ptr;
    
    jint N = _plggdn_aec_base(aec)->frame_size;
    
    jshort *cin = (*env)->GetShortArrayElements(env, input, 0);
    jshort *cecho = (*env)->GetShortArrayElements(env, echo, 0);  
    jshort *cout = malloc(sizeof(jshort) * N);
    
    plggdn_aec_echo_cancel(aec, cin, cecho, cout);
    
    jshortArray out = (*env)->NewShortArray(env, N);
    (*env)->SetShortArrayRegion(env, out, 0, N, cout);
    
    free(cin);
    free(cecho);
    free(cout);
    
    return out;
}

/*
 * Class:     com_pluggedin_dsp_AECJNI
 * Method:    echo_playback
 * Signature: (J[S)V
 */
JNIEXPORT void JNICALL Java_com_pluggedin_dsp_AECJNI_echo_1playback
  (JNIEnv *env, jclass cls, jlong ptr, jshortArray echo) {
    
    plggdn_aec_t *aec = (plggdn_aec_t*)ptr;
    
    jshort *cecho = (*env)->GetShortArrayElements(env, echo, 0);  
    
    plggdn_aec_echo_playback(aec,  cecho);
    
    free(cecho);
}

/*
 * Class:     com_pluggedin_dsp_AECJNI
 * Method:    echo_capture
 * Signature: (J[S)[S
 */
JNIEXPORT jshortArray JNICALL Java_com_pluggedin_dsp_AECJNI_echo_1capture
  (JNIEnv *env, jclass cls, jlong ptr, jshortArray input) {
    
    plggdn_aec_t *aec = (plggdn_aec_t*)ptr;
    
    jint N = _plggdn_aec_base(aec)->frame_size;
    
    jshort *cin = (*env)->GetShortArrayElements(env, input, 0);
    jshort *cout = malloc(sizeof(jshort) * N);
    
    plggdn_aec_echo_capture(aec, cin, cout);
    
    jshortArray out = (*env)->NewShortArray(env, N);
    (*env)->SetShortArrayRegion(env, out, 0, N, cout);
    
    free(cin);
    free(cout);
    
    return out;
}
