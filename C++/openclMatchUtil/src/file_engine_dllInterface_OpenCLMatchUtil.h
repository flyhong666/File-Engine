﻿/* DO NOT EDIT THIS FILE - it is machine generated */
#include "jni.h"
/* Header for class file_engine_dllInterface_OpenCLMatchUtil */

#ifndef _Included_file_engine_dllInterface_OpenCLMatchUtil
#define _Included_file_engine_dllInterface_OpenCLMatchUtil
#ifdef __cplusplus
extern "C" {
#endif
/*
 * Class:     file_engine_dllInterface_OpenCLMatchUtil
 * Method:    isOpenCLAvailable
 * Signature: ()Z
 */
JNIEXPORT jboolean JNICALL Java_file_engine_dllInterface_OpenCLMatchUtil_isOpenCLAvailable
  (JNIEnv *, jclass);

/*
 * Class:     file_engine_dllInterface_OpenCLMatchUtil
 * Method:    check
 * Signature: ([Ljava/lang/Object;[Ljava/lang/String;ZLjava/lang/String;[Ljava/lang/String;[Ljava/lang/String;[ZLjava/util/function/Consumer;)I
 */
JNIEXPORT jint JNICALL Java_file_engine_dllInterface_OpenCLMatchUtil_check
  (JNIEnv *, jclass, jobjectArray, jobjectArray, jboolean, jstring, jobjectArray, jobjectArray, jbooleanArray, jobject);

#ifdef __cplusplus
}
#endif
#endif
