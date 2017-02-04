package com.google.android.gms.analytics.internal;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zznl;
import com.google.android.gms.measurement.zzg;

abstract class zzt
{
  private static volatile Handler zzQi;
  private final zzf zzOP;
  private volatile long zzQj;
  private boolean zzQk;
  private final Runnable zzx;
  
  zzt(zzf paramzzf)
  {
    zzx.zzy(paramzzf);
    this.zzOP = paramzzf;
    this.zzx = new Runnable()
    {
      public void run()
      {
        if (Looper.myLooper() == Looper.getMainLooper()) {
          zzt.zza(zzt.this).zziW().zzf(this);
        }
        boolean bool;
        do
        {
          return;
          bool = zzt.this.zzbr();
          zzt.zza(zzt.this, 0L);
        } while ((!bool) || (zzt.zzb(zzt.this)));
        zzt.this.run();
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
        zzQi = new Handler(this.zzOP.getContext().getMainLooper());
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
  
  public long zzkH()
  {
    if (this.zzQj == 0L) {
      return 0L;
    }
    return Math.abs(this.zzOP.zziT().currentTimeMillis() - this.zzQj);
  }
  
  public void zzt(long paramLong)
  {
    cancel();
    if (paramLong >= 0L)
    {
      this.zzQj = this.zzOP.zziT().currentTimeMillis();
      if (!getHandler().postDelayed(this.zzx, paramLong)) {
        this.zzOP.zziU().zze("Failed to schedule delayed post. time", Long.valueOf(paramLong));
      }
    }
  }
  
  public void zzu(long paramLong)
  {
    long l = 0L;
    if (!zzbr()) {
      return;
    }
    if (paramLong < 0L)
    {
      cancel();
      return;
    }
    paramLong -= Math.abs(this.zzOP.zziT().currentTimeMillis() - this.zzQj);
    if (paramLong < 0L) {
      paramLong = l;
    }
    for (;;)
    {
      getHandler().removeCallbacks(this.zzx);
      if (getHandler().postDelayed(this.zzx, paramLong)) {
        break;
      }
      this.zzOP.zziU().zze("Failed to adjust delayed post. time", Long.valueOf(paramLong));
      return;
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/analytics/internal/zzt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */