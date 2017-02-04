package com.dava.framework;

import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

public class JNIDpiHelper
{
  public static int GetScreenDPI()
  {
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    JNIActivity.GetActivity().getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
    return localDisplayMetrics.densityDpi;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/dava/framework/JNIDpiHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */