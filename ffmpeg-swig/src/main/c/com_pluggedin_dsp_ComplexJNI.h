/* DO NOT EDIT THIS FILE - it is machine generated */
#include <jni.h>
/* Header for class com_pluggedin_dsp_ComplexJNI */

#ifndef _Included_com_pluggedin_dsp_ComplexJNI
#define _Included_com_pluggedin_dsp_ComplexJNI
#ifdef __cplusplus
extern "C" {
#endif
/*
 * Class:     com_pluggedin_dsp_ComplexJNI
 * Method:    create
 * Signature: ()J
 */
JNIEXPORT jlong JNICALL Java_com_pluggedin_dsp_ComplexJNI_create__
  (JNIEnv *, jclass);

/*
 * Class:     com_pluggedin_dsp_ComplexJNI
 * Method:    create
 * Signature: (DD)J
 */
JNIEXPORT jlong JNICALL Java_com_pluggedin_dsp_ComplexJNI_create__DD
  (JNIEnv *, jclass, jdouble, jdouble);

/*
 * Class:     com_pluggedin_dsp_ComplexJNI
 * Method:    destroy
 * Signature: (J)V
 */
JNIEXPORT void JNICALL Java_com_pluggedin_dsp_ComplexJNI_destroy
  (JNIEnv *, jclass, jlong);

/*
 * Class:     com_pluggedin_dsp_ComplexJNI
 * Method:    re
 * Signature: (J)D
 */
JNIEXPORT jdouble JNICALL Java_com_pluggedin_dsp_ComplexJNI_re
  (JNIEnv *, jclass, jlong);

/*
 * Class:     com_pluggedin_dsp_ComplexJNI
 * Method:    im
 * Signature: (J)D
 */
JNIEXPORT jdouble JNICALL Java_com_pluggedin_dsp_ComplexJNI_im
  (JNIEnv *, jclass, jlong);

/*
 * Class:     com_pluggedin_dsp_ComplexJNI
 * Method:    abs
 * Signature: (J)D
 */
JNIEXPORT jdouble JNICALL Java_com_pluggedin_dsp_ComplexJNI_abs
  (JNIEnv *, jclass, jlong);

/*
 * Class:     com_pluggedin_dsp_ComplexJNI
 * Method:    angle
 * Signature: (J)D
 */
JNIEXPORT jdouble JNICALL Java_com_pluggedin_dsp_ComplexJNI_angle
  (JNIEnv *, jclass, jlong);

/*
 * Class:     com_pluggedin_dsp_ComplexJNI
 * Method:    conj
 * Signature: (JI)Lcom/pluggedin/dsp/Complex;
 */
JNIEXPORT jobject JNICALL Java_com_pluggedin_dsp_ComplexJNI_conj
  (JNIEnv *, jclass, jlong, jint);

/*
 * Class:     com_pluggedin_dsp_ComplexJNI
 * Method:    add
 * Signature: (JJI)Lcom/pluggedin/dsp/Complex;
 */
JNIEXPORT jobject JNICALL Java_com_pluggedin_dsp_ComplexJNI_add
  (JNIEnv *, jclass, jlong, jlong, jint);

/*
 * Class:     com_pluggedin_dsp_ComplexJNI
 * Method:    sub
 * Signature: (JJI)Lcom/pluggedin/dsp/Complex;
 */
JNIEXPORT jobject JNICALL Java_com_pluggedin_dsp_ComplexJNI_sub
  (JNIEnv *, jclass, jlong, jlong, jint);

/*
 * Class:     com_pluggedin_dsp_ComplexJNI
 * Method:    mul
 * Signature: (JJI)Lcom/pluggedin/dsp/Complex;
 */
JNIEXPORT jobject JNICALL Java_com_pluggedin_dsp_ComplexJNI_mul
  (JNIEnv *, jclass, jlong, jlong, jint);

/*
 * Class:     com_pluggedin_dsp_ComplexJNI
 * Method:    div
 * Signature: (JJI)Lcom/pluggedin/dsp/Complex;
 */
JNIEXPORT jobject JNICALL Java_com_pluggedin_dsp_ComplexJNI_div
  (JNIEnv *, jclass, jlong, jlong, jint);

/*
 * Class:     com_pluggedin_dsp_ComplexJNI
 * Method:    inv
 * Signature: (JI)Lcom/pluggedin/dsp/Complex;
 */
JNIEXPORT jobject JNICALL Java_com_pluggedin_dsp_ComplexJNI_inv
  (JNIEnv *, jclass, jlong, jint);

/*
 * Class:     com_pluggedin_dsp_ComplexJNI
 * Method:    pow
 * Signature: (JJI)Lcom/pluggedin/dsp/Complex;
 */
JNIEXPORT jobject JNICALL Java_com_pluggedin_dsp_ComplexJNI_pow
  (JNIEnv *, jclass, jlong, jlong, jint);

/*
 * Class:     com_pluggedin_dsp_ComplexJNI
 * Method:    sqrt
 * Signature: (JI)Lcom/pluggedin/dsp/Complex;
 */
JNIEXPORT jobject JNICALL Java_com_pluggedin_dsp_ComplexJNI_sqrt
  (JNIEnv *, jclass, jlong, jint);

/*
 * Class:     com_pluggedin_dsp_ComplexJNI
 * Method:    log
 * Signature: (JI)Lcom/pluggedin/dsp/Complex;
 */
JNIEXPORT jobject JNICALL Java_com_pluggedin_dsp_ComplexJNI_log
  (JNIEnv *, jclass, jlong, jint);

/*
 * Class:     com_pluggedin_dsp_ComplexJNI
 * Method:    exp
 * Signature: (JI)Lcom/pluggedin/dsp/Complex;
 */
JNIEXPORT jobject JNICALL Java_com_pluggedin_dsp_ComplexJNI_exp
  (JNIEnv *, jclass, jlong, jint);

#ifdef __cplusplus
}
#endif
#endif
