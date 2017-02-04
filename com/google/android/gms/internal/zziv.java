package com.google.android.gms.internal;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.common.internal.zzx;

@zzha
public class zziv
{
  private Handler mHandler = null;
  private HandlerThread zzLs = null;
  private int zzLt = 0;
  private final Object zzpK = new Object();
  
  public Looper zzhk()
  {
    for (;;)
    {
      synchronized (this.zzpK)
      {
        if (this.zzLt == 0)
        {
          if (this.zzLs == null)
          {
            zzb.v("Starting the looper thread.");
            this.zzLs = new HandlerThread("LooperProvider");
            this.zzLs.start();
            this.mHandler = new Handler(this.zzLs.getLooper());
            zzb.v("Looper thread started.");
            this.zzLt += 1;
            Looper localLooper = this.zzLs.getLooper();
            return localLooper;
          }
          zzb.v("Resuming the looper thread");
          this.zzpK.notifyAll();
        }
      }
      zzx.zzb(this.zzLs, "Invalid state: mHandlerThread should already been initialized.");
    }
  }
  
  public void zzhl()
  {
    for (;;)
    {
      synchronized (this.zzpK)
      {
        if (this.zzLt > 0)
        {
          bool = true;
          zzx.zzb(bool, "Invalid state: release() called more times than expected.");
          int i = this.zzLt - 1;
          this.zzLt = i;
          if (i == 0) {
            this.mHandler.post(new Runnable()
            {
              public void run()
              {
                synchronized (zziv.zza(zziv.this))
                {
                  zzb.v("Suspending the looper thread");
                  for (;;)
                  {
                    int i = zziv.zzb(zziv.this);
                    if (i == 0) {
                      try
                      {
                        zziv.zza(zziv.this).wait();
                        zzb.v("Looper thread resumed");
                      }
                      catch (InterruptedException localInterruptedException)
                      {
                        zzb.v("Looper thread interrupted.");
                      }
                    }
                  }
                }
              }
            });
          }
          return;
        }
      }
      boolean bool = false;
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/internal/zziv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */