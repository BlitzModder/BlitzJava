package com.google.android.gms.analytics;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.text.TextUtils;
import com.google.android.gms.analytics.internal.zzaf;
import com.google.android.gms.analytics.internal.zzam;
import com.google.android.gms.analytics.internal.zzb;
import com.google.android.gms.analytics.internal.zzf;
import com.google.android.gms.analytics.internal.zzr;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzse;
import com.google.android.gms.measurement.zzg;

public class CampaignTrackingService
  extends Service
{
  private static Boolean zzNu;
  private Handler mHandler;
  
  private Handler getHandler()
  {
    Handler localHandler2 = this.mHandler;
    Handler localHandler1 = localHandler2;
    if (localHandler2 == null)
    {
      localHandler1 = new Handler(getMainLooper());
      this.mHandler = localHandler1;
    }
    return localHandler1;
  }
  
  public static boolean zzY(Context paramContext)
  {
    zzx.zzy(paramContext);
    if (zzNu != null) {
      return zzNu.booleanValue();
    }
    boolean bool = zzam.zza(paramContext, CampaignTrackingService.class);
    zzNu = Boolean.valueOf(bool);
    return bool;
  }
  
  private void zzih()
  {
    try
    {
      synchronized (CampaignTrackingReceiver.zzqf)
      {
        zzse localzzse = CampaignTrackingReceiver.zzNs;
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
    zzf.zzZ(this).zziU().zzba("CampaignTrackingService is starting up");
  }
  
  public void onDestroy()
  {
    zzf.zzZ(this).zziU().zzba("CampaignTrackingService is shutting down");
    super.onDestroy();
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, final int paramInt2)
  {
    zzih();
    zzf localzzf = zzf.zzZ(this);
    final zzaf localzzaf = localzzf.zziU();
    final Handler localHandler = null;
    if (localzzf.zziV().zzka()) {
      localzzaf.zzbe("Unexpected installation campaign (package side)");
    }
    for (paramIntent = localHandler;; paramIntent = paramIntent.getStringExtra("referrer"))
    {
      localHandler = getHandler();
      if (!TextUtils.isEmpty(paramIntent)) {
        break;
      }
      if (!localzzf.zziV().zzka()) {
        localzzaf.zzbd("No campaign found on com.android.vending.INSTALL_REFERRER \"referrer\" extra");
      }
      localzzf.zziW().zzf(new Runnable()
      {
        public void run()
        {
          CampaignTrackingService.this.zza(localzzaf, localHandler, paramInt2);
        }
      });
      return 2;
    }
    paramInt1 = localzzf.zziV().zzke();
    if (paramIntent.length() <= paramInt1) {}
    for (;;)
    {
      localzzaf.zza("CampaignTrackingService called. startId, campaign", Integer.valueOf(paramInt2), paramIntent);
      localzzf.zzip().zza(paramIntent, new Runnable()
      {
        public void run()
        {
          CampaignTrackingService.this.zza(localzzaf, localHandler, paramInt2);
        }
      });
      return 2;
      localzzaf.zzc("Campaign data exceed the maximum supported size and will be clipped. size, limit", Integer.valueOf(paramIntent.length()), Integer.valueOf(paramInt1));
      paramIntent = paramIntent.substring(0, paramInt1);
    }
  }
  
  protected void zza(final zzaf paramzzaf, Handler paramHandler, final int paramInt)
  {
    paramHandler.post(new Runnable()
    {
      public void run()
      {
        boolean bool = CampaignTrackingService.this.stopSelfResult(paramInt);
        if (bool) {
          paramzzaf.zza("Install campaign broadcast processed", Boolean.valueOf(bool));
        }
      }
    });
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/analytics/CampaignTrackingService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */