package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.util.Log;

@Deprecated
public class zzri
  implements zzrj.zza
{
  private final zzrj zzaYj;
  private boolean zzaYk;
  
  public zzri(Context paramContext, int paramInt)
  {
    this(paramContext, paramInt, null);
  }
  
  public zzri(Context paramContext, int paramInt, String paramString)
  {
    this(paramContext, paramInt, paramString, null, true);
  }
  
  public zzri(Context paramContext, int paramInt, String paramString1, String paramString2, boolean paramBoolean)
  {
    if (paramContext != paramContext.getApplicationContext()) {}
    for (String str = paramContext.getClass().getName();; str = "OneTimePlayLogger")
    {
      this.zzaYj = new zzrj(paramContext, paramInt, paramString1, paramString2, this, paramBoolean, str);
      this.zzaYk = true;
      return;
    }
  }
  
  private void zzCW()
  {
    if (!this.zzaYk) {
      throw new IllegalStateException("Cannot reuse one-time logger after sending.");
    }
  }
  
  public void send()
  {
    zzCW();
    this.zzaYj.start();
    this.zzaYk = false;
  }
  
  public void zzCX()
  {
    this.zzaYj.stop();
  }
  
  public void zzCY()
  {
    Log.w("OneTimePlayLogger", "logger connection failed");
  }
  
  public void zza(String paramString, byte[] paramArrayOfByte, String... paramVarArgs)
  {
    zzCW();
    this.zzaYj.zzb(paramString, paramArrayOfByte, paramVarArgs);
  }
  
  public void zze(PendingIntent paramPendingIntent)
  {
    Log.w("OneTimePlayLogger", "logger connection failed: " + paramPendingIntent);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/internal/zzri.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */