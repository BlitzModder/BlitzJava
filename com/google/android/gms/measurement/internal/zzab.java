package com.google.android.gms.measurement.internal;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zznl;
import com.google.android.gms.measurement.AppMeasurementReceiver;
import com.google.android.gms.measurement.AppMeasurementService;

public class zzab
  extends zzw
{
  private boolean zzQn;
  private final AlarmManager zzQo = (AlarmManager)getContext().getSystemService("alarm");
  
  protected zzab(zzt paramzzt)
  {
    super(paramzzt);
  }
  
  private PendingIntent zzkM()
  {
    Intent localIntent = new Intent(getContext(), AppMeasurementReceiver.class);
    localIntent.setAction("com.google.android.gms.measurement.UPLOAD");
    return PendingIntent.getBroadcast(getContext(), 0, localIntent, 0);
  }
  
  public void cancel()
  {
    zzje();
    this.zzQn = false;
    this.zzQo.cancel(zzkM());
  }
  
  protected void zzir()
  {
    this.zzQo.cancel(zzkM());
  }
  
  public void zzt(long paramLong)
  {
    zzje();
    if (paramLong > 0L) {}
    for (boolean bool = true;; bool = false)
    {
      zzx.zzab(bool);
      zzx.zza(AppMeasurementReceiver.zzX(getContext()), "Receiver not registered/enabled");
      zzx.zza(AppMeasurementService.zzY(getContext()), "Service not registered/enabled");
      cancel();
      long l = zziT().elapsedRealtime();
      this.zzQn = true;
      this.zzQo.setInexactRepeating(2, l + paramLong, Math.max(zzAX().zzAN(), paramLong), zzkM());
      return;
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/measurement/internal/zzab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */