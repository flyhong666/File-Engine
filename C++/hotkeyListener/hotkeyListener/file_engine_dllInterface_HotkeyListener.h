﻿/* DO NOT EDIT THIS FILE - it is machine generated */
#include "jni.h"
/* Header for class file_engine_dllInterface_HotkeyListener */

#ifndef _Included_file_engine_dllInterface_HotkeyListener
#define _Included_file_engine_dllInterface_HotkeyListener
#ifdef __cplusplus
extern "C" {
#endif
/*
 * Class:     file_engine_dllInterface_HotkeyListener
 * Method:    registerHotKey
 * Signature: (IIIII)V
 */
JNIEXPORT void JNICALL Java_file_engine_dllInterface_HotkeyListener_registerHotKey
  (JNIEnv *, jobject, jint, jint, jint, jint, jint);

/*
 * Class:     file_engine_dllInterface_HotkeyListener
 * Method:    getKeyStatus
 * Signature: ()Z
 */
JNIEXPORT jboolean JNICALL Java_file_engine_dllInterface_HotkeyListener_getKeyStatus
  (JNIEnv *, jobject);

/*
 * Class:     file_engine_dllInterface_HotkeyListener
 * Method:    startListen
 * Signature: ()V
 */
JNIEXPORT void JNICALL Java_file_engine_dllInterface_HotkeyListener_startListen
  (JNIEnv *, jobject);

/*
 * Class:     file_engine_dllInterface_HotkeyListener
 * Method:    stopListen
 * Signature: ()V
 */
JNIEXPORT void JNICALL Java_file_engine_dllInterface_HotkeyListener_stopListen
  (JNIEnv *, jobject);

/*
 * Class:     file_engine_dllInterface_HotkeyListener
 * Method:    setCtrlDoubleClick
 * Signature: (Z)V
 */
JNIEXPORT void JNICALL Java_file_engine_dllInterface_HotkeyListener_setCtrlDoubleClick
  (JNIEnv *, jobject, jboolean);

#ifdef __cplusplus
}
#endif
#endif
