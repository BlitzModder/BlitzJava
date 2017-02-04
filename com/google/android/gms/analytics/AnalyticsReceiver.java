package com.google.android.gms.analytics;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.analytics.internal.zzaf;
import com.google.android.gms.analytics.internal.zzam;
import com.google.android.gms.analytics.internal.zzf;
import com.google.android.gms.analytics.internal.zzr;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzse;

public final class AnalyticsReceiver
  extends BroadcastReceiver
{
  static zzse zzNs;
  static Boolean zzNt;
  static Object zzqf = new Object();
  
  public static boolean zzX(Context paramContext)
  {
    zzx.zzy(paramContext);
    if (zzNt != null) {
      return zzNt.booleanValue();
    }
    boolean bool = zzam.zza(paramContext, AnalyticsReceiver.class, false);
    zzNt = Boolean.valueOf(bool);
    return bool;
  }
  
  public void onReceive(Context paramContext, Intent arg2)
  {
    Object localObject = zzf.zzZ(paramContext);
    localzzaf = ((zzf)localObject).zziU();
    ??? = ???.getAction();
    if (((zzf)localObject).zziV().zzka()) {
      localzzaf.zza("Device AnalyticsReceiver got", ???);
    }
    for (;;)
    {
      boolean bool;
      if ("com.google.android.gms.analytics.ANALYTICS_DISPATCH".equals(???))
      {
        bool = AnalyticsService.zzY(paramContext);
        localObject = new Intent(paramContext, AnalyticsService.class);
        ((Intent)localObject).setAction("com.google.android.gms.analytics.ANALYTICS_DISPATCH");
      }
      synchronized (zzqf)
      {
        paramContext.startService((Intent)localObject);
        if (!bool)
        {
          return;
          localzzaf.zza("Local AnalyticsReceiver got", ???);
          continue;
        }
        try
        {
          if (zzNs == null)
          {
            zzNs = new zzse(paramContext, 1, "Analytics WakeLock");
            zzNs.setReferenceCounted(false);
          }
          zzNs.acquire(1000L);
        }
        catch (SecurityException paramContext)
        {
          for (;;)
          {
            localzzaf.zzbd("Analytics service at risk of not starting. For more reliable analytics, add the WAKE_LOCK permission to your manifest. See http://goo.gl/8Rd3yj for instructions.");
          }
        }
        return;
      }
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/analytics/AnalyticsReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */