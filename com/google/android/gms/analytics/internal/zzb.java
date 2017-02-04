package com.google.android.gms.analytics.internal;

import android.content.Context;
import android.content.Intent;
import com.google.android.gms.analytics.AnalyticsReceiver;
import com.google.android.gms.analytics.AnalyticsService;
import com.google.android.gms.common.internal.zzx;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class zzb
  extends zzd
{
  private final zzl zzOH;
  
  public zzb(zzf paramzzf, zzg paramzzg)
  {
    super(paramzzf);
    zzx.zzy(paramzzg);
    this.zzOH = paramzzg.zzj(paramzzf);
  }
  
  void onServiceConnected()
  {
    zziS();
    this.zzOH.onServiceConnected();
  }
  
  public void setLocalDispatchPeriod(final int paramInt)
  {
    zzje();
    zzb("setLocalDispatchPeriod (sec)", Integer.valueOf(paramInt));
    zziW().zzf(new Runnable()
    {
      public void run()
      {
        zzb.zza(zzb.this).zzs(paramInt * 1000L);
      }
    });
  }
  
  public void start()
  {
    this.zzOH.start();
  }
  
  public void zzJ(final boolean paramBoolean)
  {
    zza("Network connectivity status changed", Boolean.valueOf(paramBoolean));
    zziW().zzf(new Runnable()
    {
      public void run()
      {
        zzb.zza(zzb.this).zzJ(paramBoolean);
      }
    });
  }
  
  public long zza(zzh paramzzh)
  {
    zzje();
    zzx.zzy(paramzzh);
    zziS();
    long l = this.zzOH.zza(paramzzh, true);
    if (l == 0L) {
      this.zzOH.zzc(paramzzh);
    }
    return l;
  }
  
  public void zza(final zzab paramzzab)
  {
    zzx.zzy(paramzzab);
    zzje();
    zzb("Hit delivery requested", paramzzab);
    zziW().zzf(new Runnable()
    {
      public void run()
      {
        zzb.zza(zzb.this).zza(paramzzab);
      }
    });
  }
  
  public void zza(final zzw paramzzw)
  {
    zzje();
    zziW().zzf(new Runnable()
    {
      public void run()
      {
        zzb.zza(zzb.this).zzb(paramzzw);
      }
    });
  }
  
  public void zza(final String paramString, final Runnable paramRunnable)
  {
    zzx.zzh(paramString, "campaign param can't be empty");
    zziW().zzf(new Runnable()
    {
      public void run()
      {
        zzb.zza(zzb.this).zzbi(paramString);
        if (paramRunnable != null) {
          paramRunnable.run();
        }
      }
    });
  }
  
  public void zziK()
  {
    zzje();
    zziR();
    zziW().zzf(new Runnable()
    {
      public void run()
      {
        zzb.zza(zzb.this).zziK();
      }
    });
  }
  
  public void zziL()
  {
    zzje();
    Context localContext = getContext();
    if ((AnalyticsReceiver.zzX(localContext)) && (AnalyticsService.zzY(localContext)))
    {
      Intent localIntent = new Intent(localContext, AnalyticsService.class);
      localIntent.setAction("com.google.android.gms.analytics.ANALYTICS_DISPATCH");
      localContext.startService(localIntent);
      return;
    }
    zza(null);
  }
  
  public boolean zziM()
  {
    zzje();
    Future localFuture = zziW().zzc(new Callable()
    {
      public Void zzdm()
        throws Exception
      {
        zzb.zza(zzb.this).zzjJ();
        return null;
      }
    });
    try
    {
      localFuture.get(4L, TimeUnit.SECONDS);
      return true;
    }
    catch (InterruptedException localInterruptedException)
    {
      zzd("syncDispatchLocalHits interrupted", localInterruptedException);
      return false;
    }
    catch (ExecutionException localExecutionException)
    {
      zze("syncDispatchLocalHits failed", localExecutionException);
      return false;
    }
    catch (TimeoutException localTimeoutException)
    {
      zzd("syncDispatchLocalHits timed out", localTimeoutException);
    }
    return false;
  }
  
  public void zziN()
  {
    zzje();
    com.google.android.gms.measurement.zzg.zziS();
    this.zzOH.zziN();
  }
  
  public void zziO()
  {
    zzba("Radio powered up");
    zziL();
  }
  
  void zziP()
  {
    zziS();
    this.zzOH.zziP();
  }
  
  protected void zzir()
  {
    this.zzOH.zza();
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/analytics/internal/zzb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */