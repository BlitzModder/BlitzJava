package com.google.android.gms.analytics.internal;

import android.util.Log;
import com.google.android.gms.analytics.Logger;

@Deprecated
public class zzae
{
  private static volatile Logger zzRB;
  
  static
  {
    setLogger(new zzs());
  }
  
  public static Logger getLogger()
  {
    return zzRB;
  }
  
  public static void setLogger(Logger paramLogger)
  {
    zzRB = paramLogger;
  }
  
  public static void v(String paramString)
  {
    Object localObject = zzaf.zzlg();
    if (localObject != null) {
      ((zzaf)localObject).zzba(paramString);
    }
    for (;;)
    {
      localObject = zzRB;
      if (localObject != null) {
        ((Logger)localObject).verbose(paramString);
      }
      return;
      if (zzQ(0)) {
        Log.v((String)zzy.zzQr.get(), paramString);
      }
    }
  }
  
  public static boolean zzQ(int paramInt)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (getLogger() != null)
    {
      bool1 = bool2;
      if (getLogger().getLogLevel() <= paramInt) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static void zzaG(String paramString)
  {
    Object localObject = zzaf.zzlg();
    if (localObject != null) {
      ((zzaf)localObject).zzbc(paramString);
    }
    for (;;)
    {
      localObject = zzRB;
      if (localObject != null) {
        ((Logger)localObject).info(paramString);
      }
      return;
      if (zzQ(1)) {
        Log.i((String)zzy.zzQr.get(), paramString);
      }
    }
  }
  
  public static void zzaH(String paramString)
  {
    Object localObject = zzaf.zzlg();
    if (localObject != null) {
      ((zzaf)localObject).zzbd(paramString);
    }
    for (;;)
    {
      localObject = zzRB;
      if (localObject != null) {
        ((Logger)localObject).warn(paramString);
      }
      return;
      if (zzQ(2)) {
        Log.w((String)zzy.zzQr.get(), paramString);
      }
    }
  }
  
  public static void zzf(String paramString, Object paramObject)
  {
    zzaf localzzaf = zzaf.zzlg();
    if (localzzaf != null) {
      localzzaf.zze(paramString, paramObject);
    }
    while (!zzQ(3))
    {
      paramObject = zzRB;
      if (paramObject != null) {
        ((Logger)paramObject).error(paramString);
      }
      return;
    }
    if (paramObject != null) {}
    for (paramObject = paramString + ":" + paramObject;; paramObject = paramString)
    {
      Log.e((String)zzy.zzQr.get(), (String)paramObject);
      break;
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/analytics/internal/zzae.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */