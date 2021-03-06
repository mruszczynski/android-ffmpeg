/* DO NOT EDIT THIS FILE - it is machine generated */
#include <jni.h>
/* Header for class com_pluggedin_dsp_AECJNI */

#ifndef _Included_com_pluggedin_dsp_AECJNI
#define _Included_com_pluggedin_dsp_AECJNI
#ifdef __cplusplus
extern "C" {
#endif
/*
 * Class:     com_pluggedin_dsp_AECJNI
 * Method:    create
 * Signature: (III)J
 */
JNIEXPORT jlong JNICALL Java_com_pluggedin_dsp_AECJNI_create
  (JNIEnv *, jclass, jint, jint, jint);

/*
 * Class:     com_pluggedin_dsp_AECJNI
 * Method:    destroy
 * Signature: (J)I
 */
JNIEXPORT jint JNICALL Java_com_pluggedin_dsp_AECJNI_destroy
  (JNIEnv *, jclass, jlong);

/*
 * Class:     com_pluggedin_dsp_AECJNI
 * Method:    echo_cancel
 * Signature: (J[S[S[S)I
 */
JNIEXPORT jint JNICALL Java_com_pluggedin_dsp_AECJNI_echo_1cancel
  (JNIEnv *, jclass, jlong, jshortArray, jshortArray, jshortArray);

/*
 * Class:     com_pluggedin_dsp_AECJNI
 * Method:    echo_playback
 * Signature: (J[S)I
 */
JNIEXPORT jint JNICALL Java_com_pluggedin_dsp_AECJNI_echo_1playback
  (JNIEnv *, jclass, jlong, jshortArray);

/*
 * Class:     com_pluggedin_dsp_AECJNI
 * Method:    echo_capture
 * Signature: (J[S[S)I
 */
JNIEXPORT jint JNICALL Java_com_pluggedin_dsp_AECJNI_echo_1capture
  (JNIEnv *, jclass, jlong, jshortArray, jshortArray);

#ifdef __cplusplus
}
#endif
#endif
