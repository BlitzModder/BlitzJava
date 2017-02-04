package com.google.android.gms.internal;

import android.os.Process;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzp;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

@zzha
public final class zzio
{
  private static final ExecutorService zzKA = Executors.newFixedThreadPool(10, zzay("Default"));
  private static final ExecutorService zzKB = Executors.newFixedThreadPool(5, zzay("Loader"));
  
  public static zzje<Void> zza(int paramInt, Runnable paramRunnable)
  {
    if (paramInt == 1) {
      zza(zzKB, new Callable()
      {
        public Void zzdm()
        {
          this.zzKC.run();
          return null;
        }
      });
    }
    zza(zzKA, new Callable()
    {
      public Void zzdm()
      {
        this.zzKC.run();
        return null;
      }
    });
  }
  
  public static zzje<Void> zza(Runnable paramRunnable)
  {
    return zza(0, paramRunnable);
  }
  
  public static <T> zzje<T> zza(Callable<T> paramCallable)
  {
    return zza(zzKA, paramCallable);
  }
  
  public static <T> zzje<T> zza(ExecutorService paramExecutorService, final Callable<T> paramCallable)
  {
    zzjb localzzjb = new zzjb();
    try
    {
      localzzjb.zzc(new Runnable()
      {
        public void run()
        {
          try
          {
            Process.setThreadPriority(10);
            this.zzKD.zzf(paramCallable.call());
            return;
          }
          catch (Exception localException)
          {
            zzp.zzbA().zzb(localException, true);
            this.zzKD.cancel(true);
          }
        }
      }
      {
        public void run()
        {
          if (this.zzKD.isCancelled()) {
            this.zzKF.cancel(true);
          }
        }
      });
      return localzzjb;
    }
    catch (RejectedExecutionException paramExecutorService)
    {
      zzb.zzd("Thread execution is rejected.", paramExecutorService);
      localzzjb.cancel(true);
    }
    return localzzjb;
  }
  
  private static ThreadFactory zzay(String paramString)
  {
    new ThreadFactory()
    {
      private final AtomicInteger zzKG = new AtomicInteger(1);
      
      public Thread newThread(Runnable paramAnonymousRunnable)
      {
        return new Thread(paramAnonymousRunnable, "AdWorker(" + this.zzKH + ") #" + this.zzKG.getAndIncrement());
      }
    };
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/internal/zzio.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */