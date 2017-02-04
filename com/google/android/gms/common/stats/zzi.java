package com.google.android.gms.common.stats;

import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.internal.zzmt;
import com.google.android.gms.internal.zznk;
import com.google.android.gms.internal.zznq;
import java.util.List;

public class zzi
{
  private static String TAG = "WakeLockTracker";
  private static Integer zzalE;
  private static zzi zzamh = new zzi();
  
  private static int getLogLevel()
  {
    try
    {
      if (zznk.zzka()) {
        return ((Integer)zzc.zzb.zzalI.get()).intValue();
      }
      int i = zzd.LOG_LEVEL_OFF;
      return i;
    }
    catch (SecurityException localSecurityException) {}
    return zzd.LOG_LEVEL_OFF;
  }
  
  private static boolean zzau(Context paramContext)
  {
    if (zzalE == null) {
      zzalE = Integer.valueOf(getLogLevel());
    }
    return zzalE.intValue() != zzd.LOG_LEVEL_OFF;
  }
  
  public static zzi zzrJ()
  {
    return zzamh;
  }
  
  public void zza(Context paramContext, String paramString1, int paramInt1, String paramString2, String paramString3, int paramInt2, List<String> paramList)
  {
    zza(paramContext, paramString1, paramInt1, paramString2, paramString3, paramInt2, paramList, 0L);
  }
  
  public void zza(Context paramContext, String paramString1, int paramInt1, String paramString2, String paramString3, int paramInt2, List<String> paramList, long paramLong)
  {
    if (!zzau(paramContext)) {}
    long l;
    do
    {
      return;
      if (TextUtils.isEmpty(paramString1))
      {
        Log.e(TAG, "missing wakeLock key. " + paramString1);
        return;
      }
      l = System.currentTimeMillis();
    } while ((7 != paramInt1) && (8 != paramInt1) && (10 != paramInt1) && (11 != paramInt1));
    paramString1 = new WakeLockEvent(l, paramInt1, paramString2, paramInt2, paramList, paramString1, SystemClock.elapsedRealtime(), zznq.zzaw(paramContext), paramString3, paramContext.getPackageName(), zznq.zzax(paramContext), paramLong);
    try
    {
      paramContext.startService(new Intent().setComponent(zzd.zzalO).putExtra("com.google.android.gms.common.stats.EXTRA_LOG_EVENT", paramString1));
      return;
    }
    catch (Exception paramContext)
    {
      Log.wtf(TAG, paramContext);
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/common/stats/zzi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */