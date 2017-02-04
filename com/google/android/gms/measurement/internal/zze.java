package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zznl;

abstract class zze
{
  private static volatile Handler zzQi;
  private volatile long zzQj;
  private final zzt zzaQX;
  private boolean zzaSy;
  private final Runnable zzx;
  
  zze(zzt paramzzt)
  {
    zzx.zzy(paramzzt);
    this.zzaQX = paramzzt;
    this.zzaSy = true;
    this.zzx = new Runnable()
    {
      public void run()
      {
        if (Looper.myLooper() == Looper.getMainLooper()) {
          zze.zza(zze.this).zzAV().zzg(this);
        }
        boolean bool;
        do
        {
          return;
          bool = zze.this.zzbr();
          zze.zza(zze.this, 0L);
        } while ((!bool) || (!zze.zzb(zze.this)));
        zze.this.run();
      }
    };
  }
  
  private Handler getHandler()
  {
    if (zzQi != null) {
      return zzQi;
    }
    try
    {
      if (zzQi == null) {
        zzQi = new Handler(this.zzaQX.getContext().getMainLooper());
      }
      Handler localHandler = zzQi;
      return localHandler;
    }
    finally {}
  }
  
  public void cancel()
  {
    this.zzQj = 0L;
    getHandler().removeCallbacks(this.zzx);
  }
  
  public abstract void run();
  
  public boolean zzbr()
  {
    return this.zzQj != 0L;
  }
  
  public void zzt(long paramLong)
  {
    cancel();
    if (paramLong >= 0L)
    {
      this.zzQj = this.zzaQX.zziT().currentTimeMillis();
      if (!getHandler().postDelayed(this.zzx, paramLong)) {
        this.zzaQX.zzzz().zzBl().zzj("Failed to schedule delayed post. time", Long.valueOf(paramLong));
      }
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/measurement/internal/zze.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */