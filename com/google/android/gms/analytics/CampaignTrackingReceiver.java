package com.google.android.gms.analytics;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.google.android.gms.analytics.internal.zzaf;
import com.google.android.gms.analytics.internal.zzam;
import com.google.android.gms.analytics.internal.zzf;
import com.google.android.gms.analytics.internal.zzr;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzse;

public class CampaignTrackingReceiver
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
    boolean bool = zzam.zza(paramContext, CampaignTrackingReceiver.class, true);
    zzNt = Boolean.valueOf(bool);
    return bool;
  }
  
  public void onReceive(Context paramContext, Intent arg2)
  {
    Object localObject = zzf.zzZ(paramContext);
    localzzaf = ((zzf)localObject).zziU();
    String str = ???.getStringExtra("referrer");
    ??? = ???.getAction();
    localzzaf.zza("CampaignTrackingReceiver received", ???);
    if ((!"com.android.vending.INSTALL_REFERRER".equals(???)) || (TextUtils.isEmpty(str)))
    {
      localzzaf.zzbd("CampaignTrackingReceiver received unexpected intent without referrer extra");
      return;
    }
    boolean bool = CampaignTrackingService.zzY(paramContext);
    if (!bool) {
      localzzaf.zzbd("CampaignTrackingService not registered or disabled. Installation tracking not possible. See http://goo.gl/8Rd3yj for instructions.");
    }
    zzaS(str);
    if (((zzf)localObject).zziV().zzka())
    {
      localzzaf.zzbe("Received unexpected installation campaign on package side");
      return;
    }
    ??? = zzij();
    zzx.zzy(???);
    localObject = new Intent(paramContext, ???);
    ((Intent)localObject).putExtra("referrer", str);
    synchronized (zzqf)
    {
      paramContext.startService((Intent)localObject);
      if (!bool) {
        return;
      }
    }
    try
    {
      if (zzNs == null)
      {
        zzNs = new zzse(paramContext, 1, "Analytics campaign WakeLock");
        zzNs.setReferenceCounted(false);
      }
      zzNs.acquire(1000L);
    }
    catch (SecurityException paramContext)
    {
      for (;;)
      {
        localzzaf.zzbd("CampaignTrackingService service at risk of not starting. For more reliable installation campaign reports, add the WAKE_LOCK permission to your manifest. See http://goo.gl/8Rd3yj for instructions.");
      }
    }
  }
  
  protected void zzaS(String paramString) {}
  
  protected Class<? extends CampaignTrackingService> zzij()
  {
    return CampaignTrackingService.class;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/analytics/CampaignTrackingReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */