package com.dava.framework;

import android.opengl.GLSurfaceView.EGLConfigChooser;
import android.util.Log;
import java.util.Vector;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLDisplay;

public class JNIConfigChooser
  implements GLSurfaceView.EGLConfigChooser
{
  private static final int EGL_DEPTH_ENCODING_NONLINEAR_NV = 12515;
  private static final int EGL_DEPTH_ENCODING_NV = 12514;
  private static final int EGL_OPENGL_ES2_BIT = 4;
  private static final int EGL_RENDERABLE_TYPE = 12352;
  private static int curDepthBufferSize = 0;
  protected int alphaSize = 8;
  protected int blueSize = 8;
  protected int depthSize = 24;
  protected int greenSize = 8;
  protected int redSize = 8;
  protected int stencilSize = 8;
  
  public static int GetDepthBufferSize()
  {
    return curDepthBufferSize;
  }
  
  private EGLConfig chooseConfig(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, Vector<Integer> paramVector1, Vector<Integer> paramVector2)
  {
    int j = paramVector1.size();
    if (paramVector2 == null) {}
    for (int i = 0;; i = paramVector2.size())
    {
      arrayOfInt2 = new int[i + j + 1];
      i = 0;
      while (i < paramVector1.size())
      {
        arrayOfInt2[i] = ((Integer)paramVector1.get(i)).intValue();
        i += 1;
      }
    }
    if (paramVector2 != null)
    {
      i = 0;
      while (i < paramVector2.size())
      {
        arrayOfInt2[(paramVector1.size() + i)] = ((Integer)paramVector2.get(i)).intValue();
        i += 1;
      }
    }
    arrayOfInt2[(arrayOfInt2.length - 1)] = 12344;
    EGLConfig[] arrayOfEGLConfig = new EGLConfig[20];
    int[] arrayOfInt1 = new int[1];
    paramEGL10.eglChooseConfig(paramEGLDisplay, arrayOfInt2, arrayOfEGLConfig, arrayOfEGLConfig.length, arrayOfInt1);
    if (paramEGL10.eglGetError() != 12288)
    {
      Log.w(JNIConst.LOG_TAG, "eglChooseConfig err: " + paramEGL10.eglGetError());
      paramVector2 = null;
      return paramVector2;
    }
    paramVector1 = null;
    j = 16777216;
    int[] arrayOfInt2 = new int[1];
    i = 0;
    for (;;)
    {
      paramVector2 = paramVector1;
      if (i >= arrayOfInt1[0]) {
        break;
      }
      paramEGL10.eglGetConfigAttrib(paramEGLDisplay, arrayOfEGLConfig[i], 12324, arrayOfInt2);
      int k = arrayOfInt2[0];
      paramEGL10.eglGetConfigAttrib(paramEGLDisplay, arrayOfEGLConfig[i], 12323, arrayOfInt2);
      int m = arrayOfInt2[0];
      paramEGL10.eglGetConfigAttrib(paramEGLDisplay, arrayOfEGLConfig[i], 12322, arrayOfInt2);
      int n = arrayOfInt2[0];
      paramEGL10.eglGetConfigAttrib(paramEGLDisplay, arrayOfEGLConfig[i], 12321, arrayOfInt2);
      int i1 = arrayOfInt2[0];
      paramEGL10.eglGetConfigAttrib(paramEGLDisplay, arrayOfEGLConfig[i], 12325, arrayOfInt2);
      int i2 = arrayOfInt2[0];
      paramEGL10.eglGetConfigAttrib(paramEGLDisplay, arrayOfEGLConfig[i], 12326, arrayOfInt2);
      int i3 = arrayOfInt2[0];
      m = (Math.abs(k - this.redSize) + Math.abs(m - this.greenSize) + Math.abs(n - this.blueSize) + Math.abs(i1 - this.alphaSize) << 16) + (Math.abs(i2 - this.depthSize) << 8) + Math.abs(i3 - this.stencilSize);
      k = j;
      if (m < j)
      {
        Log.w(JNIConst.LOG_TAG, "--------------------------");
        Log.w(JNIConst.LOG_TAG, "New config chosen: " + i);
        k = m;
        paramVector1 = arrayOfEGLConfig[i];
      }
      i += 1;
      j = k;
    }
  }
  
  public static void printConfig(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig)
  {
    int[] arrayOfInt1 = new int[33];
    int[] tmp8_6 = arrayOfInt1;
    tmp8_6[0] = '〠';
    int[] tmp14_8 = tmp8_6;
    tmp14_8[1] = '〡';
    int[] tmp20_14 = tmp14_8;
    tmp20_14[2] = '〢';
    int[] tmp26_20 = tmp20_14;
    tmp26_20[3] = '〣';
    int[] tmp32_26 = tmp26_20;
    tmp32_26[4] = '〤';
    int[] tmp38_32 = tmp32_26;
    tmp38_32[5] = '〥';
    int[] tmp44_38 = tmp38_32;
    tmp44_38[6] = '〦';
    int[] tmp51_44 = tmp44_38;
    tmp51_44[7] = '〧';
    int[] tmp58_51 = tmp51_44;
    tmp58_51[8] = '〨';
    int[] tmp65_58 = tmp58_51;
    tmp65_58[9] = '〩';
    int[] tmp72_65 = tmp65_58;
    tmp72_65[10] = '〪';
    int[] tmp79_72 = tmp72_65;
    tmp79_72[11] = '〫';
    int[] tmp86_79 = tmp79_72;
    tmp86_79[12] = '〬';
    int[] tmp93_86 = tmp86_79;
    tmp93_86[13] = '〭';
    int[] tmp100_93 = tmp93_86;
    tmp100_93[14] = '〮';
    int[] tmp107_100 = tmp100_93;
    tmp107_100[15] = '〯';
    int[] tmp114_107 = tmp107_100;
    tmp114_107[16] = '〰';
    int[] tmp121_114 = tmp114_107;
    tmp121_114[17] = '〱';
    int[] tmp128_121 = tmp121_114;
    tmp128_121[18] = '〲';
    int[] tmp135_128 = tmp128_121;
    tmp135_128[19] = '〳';
    int[] tmp142_135 = tmp135_128;
    tmp142_135[20] = '〴';
    int[] tmp149_142 = tmp142_135;
    tmp149_142[21] = '〷';
    int[] tmp156_149 = tmp149_142;
    tmp156_149[22] = '〶';
    int[] tmp163_156 = tmp156_149;
    tmp163_156[23] = '〵';
    int[] tmp170_163 = tmp163_156;
    tmp170_163[24] = '〹';
    int[] tmp177_170 = tmp170_163;
    tmp177_170[25] = '〺';
    int[] tmp184_177 = tmp177_170;
    tmp184_177[26] = '〻';
    int[] tmp191_184 = tmp184_177;
    tmp191_184[27] = '〼';
    int[] tmp198_191 = tmp191_184;
    tmp198_191[28] = '〽';
    int[] tmp205_198 = tmp198_191;
    tmp205_198[29] = '〾';
    int[] tmp212_205 = tmp205_198;
    tmp212_205[30] = '〿';
    int[] tmp219_212 = tmp212_205;
    tmp219_212[31] = '぀';
    int[] tmp226_219 = tmp219_212;
    tmp226_219[32] = 'あ';
    tmp226_219;
    int[] arrayOfInt2 = new int[1];
    int i = 0;
    if (i < arrayOfInt1.length)
    {
      int j = arrayOfInt1[i];
      String str = new String[] { "EGL_BUFFER_SIZE", "EGL_ALPHA_SIZE", "EGL_BLUE_SIZE", "EGL_GREEN_SIZE", "EGL_RED_SIZE", "EGL_DEPTH_SIZE", "EGL_STENCIL_SIZE", "EGL_CONFIG_CAVEAT", "EGL_CONFIG_ID", "EGL_LEVEL", "EGL_MAX_PBUFFER_HEIGHT", "EGL_MAX_PBUFFER_PIXELS", "EGL_MAX_PBUFFER_WIDTH", "EGL_NATIVE_RENDERABLE", "EGL_NATIVE_VISUAL_ID", "EGL_NATIVE_VISUAL_TYPE", "EGL_PRESERVED_RESOURCES", "EGL_SAMPLES", "EGL_SAMPLE_BUFFERS", "EGL_SURFACE_TYPE", "EGL_TRANSPARENT_TYPE", "EGL_TRANSPARENT_RED_VALUE", "EGL_TRANSPARENT_GREEN_VALUE", "EGL_TRANSPARENT_BLUE_VALUE", "EGL_BIND_TO_TEXTURE_RGB", "EGL_BIND_TO_TEXTURE_RGBA", "EGL_MIN_SWAP_INTERVAL", "EGL_MAX_SWAP_INTERVAL", "EGL_LUMINANCE_SIZE", "EGL_ALPHA_MASK_SIZE", "EGL_COLOR_BUFFER_TYPE", "EGL_RENDERABLE_TYPE", "EGL_CONFORMANT" }[i];
      if (paramEGL10.eglGetConfigAttrib(paramEGLDisplay, paramEGLConfig, j, arrayOfInt2)) {
        Log.w(JNIConst.LOG_TAG, String.format("  %s: %d\n", new Object[] { str, Integer.valueOf(arrayOfInt2[0]) }));
      }
      for (;;)
      {
        i += 1;
        break;
        Log.w(JNIConst.LOG_TAG, String.format("  %s: failed\n", new Object[] { str }));
        while (paramEGL10.eglGetError() != 12288) {}
      }
    }
  }
  
  public EGLConfig chooseConfig(EGL10 paramEGL10, EGLDisplay paramEGLDisplay)
  {
    if (!paramEGL10.eglInitialize(paramEGLDisplay, new int[2])) {
      return null;
    }
    if (paramEGL10.eglGetError() != 12288) {
      return null;
    }
    Vector localVector = new Vector();
    localVector.add(Integer.valueOf(12352));
    localVector.add(Integer.valueOf(4));
    localVector.add(Integer.valueOf(12324));
    localVector.add(Integer.valueOf(this.redSize));
    localVector.add(Integer.valueOf(12323));
    localVector.add(Integer.valueOf(this.greenSize));
    localVector.add(Integer.valueOf(12322));
    localVector.add(Integer.valueOf(this.blueSize));
    localVector.add(Integer.valueOf(12321));
    localVector.add(Integer.valueOf(this.alphaSize));
    localVector.add(Integer.valueOf(12326));
    localVector.add(Integer.valueOf(this.stencilSize));
    Object localObject1 = new Vector();
    this.depthSize = 24;
    ((Vector)localObject1).add(Integer.valueOf(12325));
    ((Vector)localObject1).add(Integer.valueOf(this.depthSize));
    Object localObject2 = chooseConfig(paramEGL10, paramEGLDisplay, localVector, (Vector)localObject1);
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      this.depthSize = 16;
      localObject1 = new Vector();
      ((Vector)localObject1).add(Integer.valueOf(12325));
      ((Vector)localObject1).add(Integer.valueOf(16));
      ((Vector)localObject1).add(Integer.valueOf(12514));
      ((Vector)localObject1).add(Integer.valueOf(12515));
      localObject1 = chooseConfig(paramEGL10, paramEGLDisplay, localVector, (Vector)localObject1);
    }
    localObject2 = localObject1;
    if (localObject1 == null)
    {
      this.depthSize = 16;
      localObject1 = new Vector();
      ((Vector)localObject1).add(Integer.valueOf(12325));
      ((Vector)localObject1).add(Integer.valueOf(16));
      localObject2 = chooseConfig(paramEGL10, paramEGLDisplay, localVector, (Vector)localObject1);
    }
    if (localObject2 == null)
    {
      Log.e(JNIConst.LOG_TAG, "Error initialize gl");
      curDepthBufferSize = 0;
      return null;
    }
    curDepthBufferSize = this.depthSize;
    printConfig(paramEGL10, paramEGLDisplay, (EGLConfig)localObject2);
    return (EGLConfig)localObject2;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/dava/framework/JNIConfigChooser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */