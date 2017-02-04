package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.util.Log;
import com.google.android.gms.playlog.internal.LogEvent;
import com.google.android.gms.playlog.internal.PlayLoggerContext;
import com.google.android.gms.playlog.internal.zzd;

@Deprecated
public class zzrj
{
  private final com.google.android.gms.playlog.internal.zzf zzaYl;
  private PlayLoggerContext zzaYm;
  
  public zzrj(Context paramContext, int paramInt, String paramString1, String paramString2, zza paramzza, boolean paramBoolean, String paramString3)
  {
    String str = paramContext.getPackageName();
    int i = 0;
    try
    {
      int j = paramContext.getPackageManager().getPackageInfo(str, 0).versionCode;
      i = j;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      for (;;)
      {
        Log.wtf("PlayLogger", "This can't happen.", localNameNotFoundException);
      }
    }
    this.zzaYm = new PlayLoggerContext(str, i, paramInt, paramString1, paramString2, paramBoolean);
    this.zzaYl = new com.google.android.gms.playlog.internal.zzf(paramContext, paramContext.getMainLooper(), new zzd(paramzza), new com.google.android.gms.common.internal.zzf(null, null, null, 49, null, str, paramString3, null));
  }
  
  public void start()
  {
    this.zzaYl.start();
  }
  
  public void stop()
  {
    this.zzaYl.stop();
  }
  
  public void zza(long paramLong, String paramString, byte[] paramArrayOfByte, String... paramVarArgs)
  {
    this.zzaYl.zzb(this.zzaYm, new LogEvent(paramLong, 0L, paramString, paramArrayOfByte, paramVarArgs));
  }
  
  public void zzb(String paramString, byte[] paramArrayOfByte, String... paramVarArgs)
  {
    zza(System.currentTimeMillis(), paramString, paramArrayOfByte, paramVarArgs);
  }
  
  public static abstract interface zza
  {
    public abstract void zzCX();
    
    public abstract void zzCY();
    
    public abstract void zze(PendingIntent paramPendingIntent);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/internal/zzrj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */