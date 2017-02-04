package com.google.android.gms.analytics.internal;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import com.google.android.gms.analytics.AnalyticsReceiver;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zznl;

public class zzv
  extends zzd
{
  private boolean zzQm;
  private boolean zzQn;
  private AlarmManager zzQo = (AlarmManager)getContext().getSystemService("alarm");
  
  protected zzv(zzf paramzzf)
  {
    super(paramzzf);
  }
  
  private PendingIntent zzkM()
  {
    Intent localIntent = new Intent(getContext(), AnalyticsReceiver.class);
    localIntent.setAction("com.google.android.gms.analytics.ANALYTICS_DISPATCH");
    return PendingIntent.getBroadcast(getContext(), 0, localIntent, 0);
  }
  
  public void cancel()
  {
    zzje();
    this.zzQn = false;
    this.zzQo.cancel(zzkM());
  }
  
  public boolean zzbr()
  {
    return this.zzQn;
  }
  
  protected void zzir()
  {
    try
    {
      this.zzQo.cancel(zzkM());
      if (zziV().zzkj() > 0L)
      {
        ActivityInfo localActivityInfo = getContext().getPackageManager().getReceiverInfo(new ComponentName(getContext(), AnalyticsReceiver.class), 2);
        if ((localActivityInfo != null) && (localActivityInfo.enabled))
        {
          zzba("Receiver registered. Using alarm for local dispatch.");
          this.zzQm = true;
        }
      }
      return;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException) {}
  }
  
  public boolean zzkK()
  {
    return this.zzQm;
  }
  
  public void zzkL()
  {
    zzje();
    zzx.zza(zzkK(), "Receiver not registered");
    long l1 = zziV().zzkj();
    if (l1 > 0L)
    {
      cancel();
      long l2 = zziT().elapsedRealtime();
      this.zzQn = true;
      this.zzQo.setInexactRepeating(2, l2 + l1, 0L, zzkM());
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/analytics/internal/zzv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */