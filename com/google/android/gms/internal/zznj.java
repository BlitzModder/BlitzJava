package com.google.android.gms.internal;

import android.content.Context;
import android.content.pm.PackageManager;
import java.util.regex.Pattern;

public final class zznj
{
  private static Pattern zzamj = null;
  
  public static boolean zzav(Context paramContext)
  {
    return paramContext.getPackageManager().hasSystemFeature("android.hardware.type.watch");
  }
  
  public static int zzcp(int paramInt)
  {
    return paramInt / 1000;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/internal/zznj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */