package com.google.android.gms.internal;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Process;
import com.google.android.gms.common.internal.zzd;

public class zznk
{
  public static boolean zzj(Context paramContext, String paramString)
  {
    boolean bool = false;
    paramContext = paramContext.getPackageManager();
    try
    {
      int i = paramContext.getApplicationInfo(paramString, 0).flags;
      if ((i & 0x200000) != 0) {
        bool = true;
      }
      return bool;
    }
    catch (PackageManager.NameNotFoundException paramContext) {}
    return false;
  }
  
  public static boolean zzka()
  {
    return (zzd.zzaiU) && (zzmt.isInitialized()) && (zzmt.zzpE() == Process.myUid());
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/internal/zznk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */