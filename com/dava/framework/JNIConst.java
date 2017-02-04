package com.dava.framework;

import android.opengl.GLES20;
import android.opengl.GLUtils;
import android.util.Log;
import javax.microedition.khronos.egl.EGL10;

public class JNIConst
{
  public static String LOG_TAG = "DAVA";
  
  public static void checkEglError(String paramString, EGL10 paramEGL10)
  {
    for (;;)
    {
      int i = paramEGL10.eglGetError();
      if (i == 12288) {
        break;
      }
      Log.e(LOG_TAG, String.format("%s: EGL error: 0x%x (%s)", new Object[] { paramString, Integer.valueOf(i), GLUtils.getEGLErrorString(i) }));
    }
  }
  
  public static void checkGlError(String paramString)
  {
    int i = GLES20.glGetError();
    if (i != 0)
    {
      Log.e(LOG_TAG, paramString + ": glError " + i);
      throw new RuntimeException(paramString + ": glError " + i + "( " + GLUtils.getEGLErrorString(i) + ")");
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/dava/framework/JNIConst.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */