package com.google.android.gms.analytics;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import com.google.android.gms.analytics.internal.zzaf;
import com.google.android.gms.analytics.internal.zzam;
import com.google.android.gms.analytics.internal.zzb;
import com.google.android.gms.analytics.internal.zzf;
import com.google.android.gms.analytics.internal.zzr;
import com.google.android.gms.analytics.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzse;

public final class AnalyticsService
  extends Service
{
  private static Boolean zzNu;
  private final Handler mHandler = new Handler();
  
  public static boolean zzY(Context paramContext)
  {
    zzx.zzy(paramContext);
    if (zzNu != null) {
      return zzNu.booleanValue();
    }
    boolean bool = zzam.zza(paramContext, AnalyticsService.class);
    zzNu = Boolean.valueOf(bool);
    return bool;
  }
  
  private void zzih()
  {
    try
    {
      synchronized (AnalyticsReceiver.zzqf)
      {
        zzse localzzse = AnalyticsReceiver.zzNs;
        if ((localzzse != null) && (localzzse.isHeld())) {
          localzzse.release();
        }
        return;
      }
      return;
    }
    catch (SecurityException localSecurityException) {}
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    return null;
  }
  
  public void onCreate()
  {
    super.onCreate();
    zzf localzzf = zzf.zzZ(this);
    zzaf localzzaf = localzzf.zziU();
    if (localzzf.zziV().zzka())
    {
      localzzaf.zzba("Device AnalyticsService is starting up");
      return;
    }
    localzzaf.zzba("Local AnalyticsService is starting up");
  }
  
  public void onDestroy()
  {
    zzf localzzf = zzf.zzZ(this);
    zzaf localzzaf = localzzf.zziU();
    if (localzzf.zziV().zzka()) {
      localzzaf.zzba("Device AnalyticsService is shutting down");
    }
    for (;;)
    {
      super.onDestroy();
      return;
      localzzaf.zzba("Local AnalyticsService is shutting down");
    }
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, final int paramInt2)
  {
    zzih();
    final zzf localzzf = zzf.zzZ(this);
    final zzaf localzzaf = localzzf.zziU();
    paramIntent = paramIntent.getAction();
    if (localzzf.zziV().zzka()) {
      localzzaf.zza("Device AnalyticsService called. startId, action", Integer.valueOf(paramInt2), paramIntent);
    }
    for (;;)
    {
      if ("com.google.android.gms.analytics.ANALYTICS_DISPATCH".equals(paramIntent)) {
        localzzf.zzip().zza(new zzw()
        {
          public void zzc(Throwable paramAnonymousThrowable)
          {
            AnalyticsService.zza(AnalyticsService.this).post(new Runnable()
            {
              public void run()
              {
                if (AnalyticsService.this.stopSelfResult(AnalyticsService.1.this.zzNv))
                {
                  if (AnalyticsService.1.this.zzNw.zziV().zzka()) {
                    AnalyticsService.1.this.zzNx.zzba("Device AnalyticsService processed last dispatch request");
                  }
                }
                else {
                  return;
                }
                AnalyticsService.1.this.zzNx.zzba("Local AnalyticsService processed last dispatch request");
              }
            });
          }
        });
      }
      return 2;
      localzzaf.zza("Local AnalyticsService called. startId, action", Integer.valueOf(paramInt2), paramIntent);
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/analytics/AnalyticsService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */