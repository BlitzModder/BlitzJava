package com.google.android.gms.measurement;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.measurement.internal.zzae;
import com.google.android.gms.measurement.internal.zzc;
import com.google.android.gms.measurement.internal.zzo;
import com.google.android.gms.measurement.internal.zzo.zza;
import com.google.android.gms.measurement.internal.zzt;

public final class AppMeasurementReceiver
  extends BroadcastReceiver
{
  static Boolean zzNt;
  static PowerManager.WakeLock zzaQY;
  static final Object zzqf = new Object();
  
  public static boolean zzX(Context paramContext)
  {
    zzx.zzy(paramContext);
    if (zzNt != null) {
      return zzNt.booleanValue();
    }
    boolean bool = zzae.zza(paramContext, AppMeasurementReceiver.class, false);
    zzNt = Boolean.valueOf(bool);
    return bool;
  }
  
  public void onReceive(Context paramContext, Intent arg2)
  {
    Object localObject = zzt.zzaU(paramContext);
    localzzo = ((zzt)localObject).zzzz();
    ??? = ???.getAction();
    if (((zzt)localObject).zzAX().zzka()) {
      localzzo.zzBr().zzj("Device AppMeasurementReceiver got", ???);
    }
    for (;;)
    {
      boolean bool;
      if ("com.google.android.gms.measurement.UPLOAD".equals(???))
      {
        bool = AppMeasurementService.zzY(paramContext);
        localObject = new Intent(paramContext, AppMeasurementService.class);
        ((Intent)localObject).setAction("com.google.android.gms.measurement.UPLOAD");
      }
      synchronized (zzqf)
      {
        paramContext.startService((Intent)localObject);
        if (!bool)
        {
          return;
          localzzo.zzBr().zzj("Local AppMeasurementReceiver got", ???);
          continue;
        }
        try
        {
          paramContext = (PowerManager)paramContext.getSystemService("power");
          if (zzaQY == null)
          {
            zzaQY = paramContext.newWakeLock(1, "AppMeasurement WakeLock");
            zzaQY.setReferenceCounted(false);
          }
          zzaQY.acquire(1000L);
        }
        catch (SecurityException paramContext)
        {
          for (;;)
          {
            localzzo.zzBm().zzez("AppMeasurementService at risk of not starting. For more reliable app measurements, add the WAKE_LOCK permission to your manifest.");
          }
        }
        return;
      }
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/measurement/AppMeasurementReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */