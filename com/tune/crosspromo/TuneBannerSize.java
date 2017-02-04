package com.tune.crosspromo;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

class TuneBannerSize
{
  public static final int AUTO_HEIGHT = -2;
  public static final int FULL_WIDTH = -1;
  
  private static int getBannerHeight(Context paramContext, int paramInt1, int paramInt2)
  {
    if (paramInt2 == 1) {
      return (int)(paramContext.getResources().getDisplayMetrics().density * 50.0F);
    }
    paramInt1 = (int)(paramInt1 / paramContext.getResources().getDisplayMetrics().density);
    if (paramInt1 <= 400) {
      return (int)(32.0F * paramContext.getResources().getDisplayMetrics().density);
    }
    if (paramInt1 <= 720) {
      return (int)(paramContext.getResources().getDisplayMetrics().density * 50.0F);
    }
    return (int)(90.0F * paramContext.getResources().getDisplayMetrics().density);
  }
  
  public static int getBannerHeightPixels(Context paramContext, int paramInt)
  {
    return getBannerHeight(paramContext, getScreenHeightPixels(paramContext), paramInt);
  }
  
  public static int getBannerHeightPixelsLandscape(Context paramContext, int paramInt)
  {
    int i = getScreenHeightPixels(paramContext);
    if (paramInt == 1) {
      i = getScreenWidthPixels(paramContext);
    }
    return getBannerHeight(paramContext, i, 2);
  }
  
  public static int getBannerHeightPixelsPortrait(Context paramContext, int paramInt)
  {
    int i = getScreenHeightPixels(paramContext);
    if (paramInt == 2) {
      i = getScreenWidthPixels(paramContext);
    }
    return getBannerHeight(paramContext, i, 1);
  }
  
  @SuppressLint({"NewApi"})
  public static int getScreenHeightPixels(Context paramContext)
  {
    paramContext = ((Activity)paramContext).getWindowManager().getDefaultDisplay();
    Point localPoint = new Point();
    if (Build.VERSION.SDK_INT >= 17)
    {
      paramContext.getRealSize(localPoint);
      return localPoint.y;
    }
    if (Build.VERSION.SDK_INT >= 13)
    {
      paramContext.getSize(localPoint);
      return localPoint.y;
    }
    return paramContext.getHeight();
  }
  
  @SuppressLint({"NewApi"})
  public static int getScreenWidthPixels(Context paramContext)
  {
    paramContext = ((Activity)paramContext).getWindowManager().getDefaultDisplay();
    Point localPoint = new Point();
    if (Build.VERSION.SDK_INT >= 17)
    {
      paramContext.getRealSize(localPoint);
      return localPoint.x;
    }
    if (Build.VERSION.SDK_INT >= 13)
    {
      paramContext.getSize(localPoint);
      return localPoint.x;
    }
    return paramContext.getWidth();
  }
  
  public static int getScreenWidthPixelsLandscape(Context paramContext, int paramInt)
  {
    if (paramInt == 1) {
      return getScreenHeightPixels(paramContext);
    }
    return getScreenWidthPixels(paramContext);
  }
  
  public static int getScreenWidthPixelsPortrait(Context paramContext, int paramInt)
  {
    if (paramInt == 2) {
      return getScreenHeightPixels(paramContext);
    }
    return getScreenWidthPixels(paramContext);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/tune/crosspromo/TuneBannerSize.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */