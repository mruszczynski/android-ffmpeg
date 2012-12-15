#include "com_pluggedin_dsp_ComplexJNI.h"
#include "plggdn_fft.h"

jobject plggdn_complex_create_jni(JNIEnv *env, void *ptr, int jOwnMem) {
    jclass cls = (*env)->FindClass(env, "com/pluggedin/dsp/Complex");
    jmethodID constructor = (*env)->GetMethodID(env, cls, "<init>", "(JZ)V"); 
    
    return (*env)->NewObject(env, cls, constructor, (jlong)ptr, (jboolean)jOwnMem);
}

/**
 * 
 * @param env - JNIEnv
 * @param in - input array
 * @param N - number of elements
 * @param javaOwnMem - 0 - to return internal custom memory to java for read, 1 - to let java release it when it needs
 * @return Java ObjectArray
 */
jobjectArray plggdn_create_complex_array_jni(JNIEnv *env, plggdn_complex *in, int N, int javaOwnMem) {
    jclass cls = (*env)->FindClass(env, "com/pluggedin/dsp/Complex");
    jmethodID constructor = (*env)->GetMethodID(env, cls, "<init>", "(JZ)V"); 
    jobjectArray out = (*env)->NewObjectArray(env, N, cls, NULL);
    
    for(int i=0; i<N; i++) {
        jobject obj = (*env)->NewObject(env, cls, constructor, (jlong)&in[i], (jboolean)javaOwnMem);
        (*env)->SetObjectArrayElement(env, out, i, obj);
    }
    return out;
}

JNIEXPORT jlong JNICALL Java_com_pluggedin_dsp_ComplexJNI_create__
  (JNIEnv *env , jclass cls) {
    return (jlong) plggdn_complex_malloc(1);
}

JNIEXPORT jlong JNICALL Java_com_pluggedin_dsp_ComplexJNI_create__DD
  (JNIEnv *env, jclass cls, jdouble re, jdouble im) {
    return (jlong) plggdn_complex_create2(re, im);
}

JNIEXPORT void JNICALL Java_com_pluggedin_dsp_ComplexJNI_destroy
  (JNIEnv *env, jclass cls, jlong ptr) {
    plggdn_freep((void**)__plggdn_complex(ptr));
}

JNIEXPORT jdouble JNICALL Java_com_pluggedin_dsp_ComplexJNI_re
  (JNIEnv *env, jclass cls, jlong ptr) {
    return (jdouble) creal(*_plggdn_complex(ptr));
}

JNIEXPORT jdouble JNICALL Java_com_pluggedin_dsp_ComplexJNI_im
  (JNIEnv *env, jclass cls, jlong ptr) {
    return (jdouble) cimag(*_plggdn_complex(ptr));
}

JNIEXPORT jdouble JNICALL Java_com_pluggedin_dsp_ComplexJNI_abs
  (JNIEnv *env, jclass cls, jlong ptr) {
    return (jdouble) cabs(*_plggdn_complex(ptr));    
}

JNIEXPORT jdouble JNICALL Java_com_pluggedin_dsp_ComplexJNI_angle
  (JNIEnv *env, jclass cls, jlong ptr) {
    return (jdouble) carg(*_plggdn_complex(ptr));
}

JNIEXPORT jobject JNICALL Java_com_pluggedin_dsp_ComplexJNI_conj
  (JNIEnv *env, jclass cls, jlong ptrA, jint inPlaceA) {
    plggdn_complex *a = _plggdn_complex(ptrA);
    plggdn_complex *c = inPlaceA ? a : plggdn_complex_malloc(1);
    *c = conj(*a);
    return  inPlaceA ? NULL : plggdn_complex_create_jni(env, c, 1);
}

JNIEXPORT jobject JNICALL Java_com_pluggedin_dsp_ComplexJNI_add
  (JNIEnv *env, jclass cls, jlong ptrA, jlong ptrB, jint inPlaceA) {
    plggdn_complex *a = _plggdn_complex(ptrA);
    plggdn_complex *b = _plggdn_complex(ptrB);
    plggdn_complex *c = inPlaceA ? a : plggdn_complex_malloc(1);
    *c = (*a) + (*b);
    return  inPlaceA ? NULL : plggdn_complex_create_jni(env, c, 1);
}

JNIEXPORT jobject JNICALL Java_com_pluggedin_dsp_ComplexJNI_sub
  (JNIEnv *env, jclass cls, jlong ptrA, jlong ptrB, jint inPlaceA) {
    plggdn_complex *a = _plggdn_complex(ptrA);
    plggdn_complex *b = _plggdn_complex(ptrB);
    plggdn_complex *c = inPlaceA ? a : plggdn_complex_malloc(1);
    *c = (*a) - (*b);
    return  inPlaceA ? NULL : plggdn_complex_create_jni(env, c, 1);
}

JNIEXPORT jobject JNICALL Java_com_pluggedin_dsp_ComplexJNI_mul
  (JNIEnv *env, jclass cls, jlong ptrA, jlong ptrB, jint inPlaceA) {
    plggdn_complex *a = _plggdn_complex(ptrA);
    plggdn_complex *b = _plggdn_complex(ptrB);
    plggdn_complex *c = inPlaceA ? a : plggdn_complex_malloc(1);
    *c = (*a) * (*b);
    return  inPlaceA ? NULL : plggdn_complex_create_jni(env, c, 1);
}

JNIEXPORT jobject JNICALL Java_com_pluggedin_dsp_ComplexJNI_div
  (JNIEnv *env, jclass cls, jlong ptrA, jlong ptrB, jint inPlaceA) {
    plggdn_complex *a = _plggdn_complex(ptrA);
    plggdn_complex *b = _plggdn_complex(ptrB);
    plggdn_complex *c = inPlaceA ? a : plggdn_complex_malloc(1);
    *c = (*a) / (*b);
    return  inPlaceA ? NULL : plggdn_complex_create_jni(env, c, 1);
}

JNIEXPORT jobject JNICALL Java_com_pluggedin_dsp_ComplexJNI_inv
  (JNIEnv *env, jclass cls, jlong ptr, jint inPlaceA) {
    plggdn_complex *a = _plggdn_complex(ptr);
    plggdn_complex *c = inPlaceA ? a : plggdn_complex_malloc(1);
    *c = 1.0/(*a);
    return  inPlaceA ? NULL : plggdn_complex_create_jni(env, c, 1);
}

JNIEXPORT jobject JNICALL Java_com_pluggedin_dsp_ComplexJNI_pow
  (JNIEnv *env, jclass cls, jlong ptrA, jlong ptrB, jint inPlaceA) {
    plggdn_complex *a = _plggdn_complex(ptrA);
    plggdn_complex *b = _plggdn_complex(ptrB);
    plggdn_complex *c = inPlaceA ? a : plggdn_complex_malloc(1);
    *c = cpow(*a, *b);
    return  inPlaceA ? NULL : plggdn_complex_create_jni(env, c, 1);
}

JNIEXPORT jobject JNICALL Java_com_pluggedin_dsp_ComplexJNI_sqrt
  (JNIEnv *env, jclass cls, jlong ptr, jint inPlaceA) {
    plggdn_complex *a = _plggdn_complex(ptr);
    plggdn_complex *c = inPlaceA ? a : plggdn_complex_malloc(1);
    *c = csqrt(*a);
    return  inPlaceA ? NULL : plggdn_complex_create_jni(env, c, 1);
}

JNIEXPORT jobject JNICALL Java_com_pluggedin_dsp_ComplexJNI_log
  (JNIEnv *env, jclass cls, jlong ptrA, jint inPlaceA) {
    plggdn_complex *a = _plggdn_complex(ptrA);
    plggdn_complex *c = inPlaceA ? a : plggdn_complex_malloc(1);
    *c = clog(*a);
    return  inPlaceA ? NULL : plggdn_complex_create_jni(env, c, 1);
}

JNIEXPORT jobject JNICALL Java_com_pluggedin_dsp_ComplexJNI_exp
  (JNIEnv *env, jclass cls, jlong ptrA, jint inPlaceA) {
    plggdn_complex *a = _plggdn_complex(ptrA);
    plggdn_complex *c = inPlaceA ? a : plggdn_complex_malloc(1);
    *c = cexp(*a);
    return  inPlaceA ? NULL : plggdn_complex_create_jni(env, c, 1);
}

