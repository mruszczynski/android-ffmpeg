/* 
 * File:   ComplexJNI_help.h
 * Author: michu
 *
 * Created on 13 grudzień 2012, 13:36
 */

#include <jni.h>

#ifndef COMPLEXJNI_HELP_H
#define	COMPLEXJNI_HELP_H

#ifdef	__cplusplus
extern "C" {
#endif
    
#include "plggdn_fft.h"

jobject plggdn_complex_create_jni(JNIEnv *env, void *ptr, int jOwnMem);

/**
 * 
 * @param env - JNIEnv
 * @param in - input array
 * @param N - number of elements
 * @param javaOwnMem - 0 - to return internal custom memory to java for read, 1 - to let java release it when it needs
 * @return Java ObjectArray
 */
jobjectArray plggdn_create_complex_array_jni(JNIEnv *env, plggdn_complex *in, int N, int javaOwnMem) ;


#ifdef	__cplusplus
}
#endif

#endif	/* COMPLEXJNI_HELP_H */

