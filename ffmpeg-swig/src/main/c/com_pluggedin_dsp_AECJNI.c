#include "com_pluggedin_dsp_AECJNI.h"
#include <stdlib.h>

#include "plggdn_aec.h"
#include "plggdn_aec_speex.h"

JNIEXPORT jlong JNICALL Java_com_pluggedin_dsp_AECJNI_create
  (JNIEnv *env, jclass cls, jint frame_size, jint filter_length) {
    
    plggdn_aec_base_attr args = {
        .frame_size = frame_size,
        .filter_length = filter_length
    };
    
    // pick speex implementation
    return (jlong) plggdn_aec_create(&plggdn_aec_speex_vt, &args);
}

JNIEXPORT jint JNICALL Java_com_pluggedin_dsp_AECJNI_destroy
  (JNIEnv *env, jclass cls, jlong ptr) {
    
    return plggdn_aec_release((plggdn_aec_t**)&ptr);
    
}

JNIEXPORT jint JNICALL Java_com_pluggedin_dsp_AECJNI_echo_1cancel
  (JNIEnv *env, jclass cls, jlong ptr, jshortArray input, jshortArray echo, jshortArray filtered) {
    
    plggdn_aec_t *aec = (plggdn_aec_t*)ptr;
    int err = 0;
    
    jshort *cin = (*env)->GetPrimitiveArrayCritical(env, input, 0);
    jshort *cecho = (*env)->GetPrimitiveArrayCritical(env, echo, 0);  
    jshort *cfiltered = (*env)->GetPrimitiveArrayCritical(env, filtered, 0);
    
    if(cin == NULL || cecho == NULL || cfiltered == NULL) { // memory exception
        err = 1;
        goto memory_exception;
    }
    
    err = plggdn_aec_echo_cancel(aec, cin, cecho, cfiltered);
        
    memory_exception:
    if(cfiltered)
        (*env)->ReleasePrimitiveArrayCritical(env, filtered, cfiltered, 0);
    if(cecho)
        (*env)->ReleasePrimitiveArrayCritical(env, echo, cecho, 0);
    if(cin)
        (*env)->ReleasePrimitiveArrayCritical(env, input, cin, 0);
    
    return err;
}

JNIEXPORT jint JNICALL Java_com_pluggedin_dsp_AECJNI_echo_1playback
  (JNIEnv *env, jclass cls, jlong ptr, jshortArray echo) {
    
    plggdn_aec_t *aec = (plggdn_aec_t*)ptr;
    int err = 0;
    
    jshort *cecho = (*env)->GetPrimitiveArrayCritical(env, echo, 0);  
    if(!cecho) {// memory exception
        err = 1;
        goto memory_exception;
    }
    
    err = plggdn_aec_echo_playback(aec,  cecho);
    
    memory_exception:
    (*env)->ReleasePrimitiveArrayCritical(env, echo, cecho, 0);
    return err;
}

JNIEXPORT jint JNICALL Java_com_pluggedin_dsp_AECJNI_echo_1capture
  (JNIEnv *env, jclass cls, jlong ptr, jshortArray input, jshortArray filtered) {
    
    plggdn_aec_t *aec = (plggdn_aec_t*)ptr;
    int err = 0;
    
    jint N = _plggdn_aec_base(aec)->frame_size;
    jshort *cin = (*env)->GetPrimitiveArrayCritical(env, input, 0);
    jshort *cfiltered = (*env)->GetPrimitiveArrayCritical(env, filtered, 0);
    if(cin == NULL || cfiltered == NULL) { // memory exception
        err = 1;
        goto memory_exception;    
    }
    
    err = plggdn_aec_echo_capture(aec, cin, cfiltered);
    
    memory_exception:
    if(cfiltered)
        (*env)->ReleasePrimitiveArrayCritical(env, filtered, cfiltered, 0);
    if(cin)
        (*env)->ReleasePrimitiveArrayCritical(env, input, cin, 0);
    
    return err;
}
