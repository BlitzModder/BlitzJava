package com.google.android.gms.cast.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;

public abstract class zzc
  extends zzd
{
  protected final Handler mHandler = new Handler(Looper.getMainLooper());
  protected final long zzabJ;
  protected final Runnable zzabK = new zza(null);
  protected boolean zzabL;
  
  public zzc(String paramString1, String paramString2, String paramString3)
  {
    this(paramString1, paramString2, paramString3, 1000L);
  }
  
  public zzc(String paramString1, String paramString2, String paramString3, long paramLong)
  {
    super(paramString1, paramString2, paramString3);
    this.zzabJ = paramLong;
    zzW(false);
  }
  
  protected final void zzW(boolean paramBoolean)
  {
    if (this.zzabL != paramBoolean)
    {
      this.zzabL = paramBoolean;
      if (paramBoolean) {
        this.mHandler.postDelayed(this.zzabK, this.zzabJ);
      }
    }
    else
    {
      return;
    }
    this.mHandler.removeCallbacks(this.zzabK);
  }
  
  public void zznN()
  {
    zzW(false);
  }
  
  protected abstract boolean zzz(long paramLong);
  
  private class zza
    implements Runnable
  {
    private zza() {}
    
    public void run()
    {
      zzc.this.zzabL = false;
      long l = SystemClock.elapsedRealtime();
      boolean bool = zzc.this.zzz(l);
      zzc.this.zzW(bool);
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/cast/internal/zzc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */