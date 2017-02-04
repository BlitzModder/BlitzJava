package com.google.android.gms.internal;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources.NotFoundException;
import android.telephony.TelephonyManager;
import android.util.Log;

public class zzoo
{
  private static int zzaxj = -1;
  
  public static boolean zzaC(Context paramContext)
  {
    return zzaF(paramContext) == 3;
  }
  
  private static int zzaD(Context paramContext)
  {
    return zzaE(paramContext) % 1000 / 100 + 5;
  }
  
  private static int zzaE(Context paramContext)
  {
    try
    {
      int i = paramContext.getPackageManager().getPackageInfo("com.google.android.gms", 0).versionCode;
      return i;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      Log.w("Fitness", "Could not find package info for Google Play Services");
    }
    return -1;
  }
  
  public static int zzaF(Context paramContext)
  {
    if (zzaxj == -1) {
      switch (zzaD(paramContext))
      {
      case 9: 
      case 11: 
      case 12: 
      default: 
        if (!zzaG(paramContext)) {
          break;
        }
      }
    }
    for (int i = 1;; i = 2)
    {
      zzaxj = i;
      for (;;)
      {
        return zzaxj;
        zzaxj = 3;
        continue;
        zzaxj = 0;
      }
    }
  }
  
  private static boolean zzaG(Context paramContext)
  {
    try
    {
      int i = ((TelephonyManager)paramContext.getSystemService("phone")).getPhoneType();
      return i != 0;
    }
    catch (Resources.NotFoundException localNotFoundException)
    {
      Log.wtf("Fitness", "Unable to determine type of device, assuming phone.  Version: " + zzaE(paramContext), localNotFoundException);
    }
    return true;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/internal/zzoo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */