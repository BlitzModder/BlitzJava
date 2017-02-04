package com.google.android.gms.measurement;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.PowerManager.WakeLock;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.measurement.internal.zzae;
import com.google.android.gms.measurement.internal.zzc;
import com.google.android.gms.measurement.internal.zzo;
import com.google.android.gms.measurement.internal.zzo.zza;
import com.google.android.gms.measurement.internal.zzs;
import com.google.android.gms.measurement.internal.zzt;
import com.google.android.gms.measurement.internal.zzu;

public final class AppMeasurementService
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
    boolean bool = zzae.zza(paramContext, AppMeasurementService.class);
    zzNu = Boolean.valueOf(bool);
    return bool;
  }
  
  private void zzih()
  {
    try
    {
      synchronized (AppMeasurementReceiver.zzqf)
      {
        PowerManager.WakeLock localWakeLock = AppMeasurementReceiver.zzaQY;
        if ((localWakeLock != null) && (localWakeLock.isHeld())) {
          localWakeLock.release();
        }
        return;
      }
      return;
    }
    catch (SecurityException localSecurityException) {}
  }
  
  private zzo zzzz()
  {
    return zzt.zzaU(this).zzzz();
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    if (paramIntent == null)
    {
      zzzz().zzBl().zzez("onBind called with null intent");
      return null;
    }
    paramIntent = paramIntent.getAction();
    if ("com.google.android.gms.measurement.START".equals(paramIntent)) {
      return new zzu(zzt.zzaU(this));
    }
    zzzz().zzBm().zzj("onBind received unknown action", paramIntent);
    return null;
  }
  
  public void onCreate()
  {
    super.onCreate();
    zzt localzzt = zzt.zzaU(this);
    zzo localzzo = localzzt.zzzz();
    if (localzzt.zzAX().zzka())
    {
      localzzo.zzBr().zzez("Device AppMeasurementService is starting up");
      return;
    }
    localzzo.zzBr().zzez("Local AppMeasurementService is starting up");
  }
  
  public void onDestroy()
  {
    zzt localzzt = zzt.zzaU(this);
    zzo localzzo = localzzt.zzzz();
    if (localzzt.zzAX().zzka()) {
      localzzo.zzBr().zzez("Device AppMeasurementService is shutting down");
    }
    for (;;)
    {
      super.onDestroy();
      return;
      localzzo.zzBr().zzez("Local AppMeasurementService is shutting down");
    }
  }
  
  public void onRebind(Intent paramIntent)
  {
    if (paramIntent == null)
    {
      zzzz().zzBl().zzez("onRebind called with null intent");
      return;
    }
    paramIntent = paramIntent.getAction();
    zzzz().zzBr().zzj("onRebind called. action", paramIntent);
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, final int paramInt2)
  {
    zzih();
    final zzt localzzt = zzt.zzaU(this);
    final zzo localzzo = localzzt.zzzz();
    paramIntent = paramIntent.getAction();
    if (localzzt.zzAX().zzka()) {
      localzzo.zzBr().zze("Device AppMeasurementService called. startId, action", Integer.valueOf(paramInt2), paramIntent);
    }
    for (;;)
    {
      if ("com.google.android.gms.measurement.UPLOAD".equals(paramIntent)) {
        localzzt.zzAV().zzg(new Runnable()
        {
          public void run()
          {
            localzzt.zzBK();
            AppMeasurementService.zza(AppMeasurementService.this).post(new Runnable()
            {
              public void run()
              {
                if (AppMeasurementService.this.stopSelfResult(AppMeasurementService.1.this.zzNv))
                {
                  if (AppMeasurementService.1.this.zzaQZ.zzAX().zzka()) {
                    AppMeasurementService.1.this.zzaRa.zzBr().zzez("Device AppMeasurementService processed last upload request");
                  }
                }
                else {
                  return;
                }
                AppMeasurementService.1.this.zzaRa.zzBr().zzez("Local AppMeasurementService processed last upload request");
              }
            });
          }
        });
      }
      return 2;
      localzzo.zzBr().zze("Local AppMeasurementService called. startId, action", Integer.valueOf(paramInt2), paramIntent);
    }
  }
  
  public boolean onUnbind(Intent paramIntent)
  {
    if (paramIntent == null)
    {
      zzzz().zzBl().zzez("onUnbind called with null intent");
      return true;
    }
    paramIntent = paramIntent.getAction();
    zzzz().zzBr().zzj("onUnbind called for intent. action", paramIntent);
    return true;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/measurement/AppMeasurementService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */