package com.google.android.gms.analytics.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build.VERSION;
import com.google.android.gms.common.internal.zzx;

class zzag
  extends BroadcastReceiver
{
  static final String zzRF = zzag.class.getName();
  private final zzf zzOP;
  private boolean zzRG;
  private boolean zzRH;
  
  zzag(zzf paramzzf)
  {
    zzx.zzy(paramzzf);
    this.zzOP = paramzzf;
  }
  
  private Context getContext()
  {
    return this.zzOP.getContext();
  }
  
  private zzaf zziU()
  {
    return this.zzOP.zziU();
  }
  
  private zzb zzip()
  {
    return this.zzOP.zzip();
  }
  
  private void zzli()
  {
    zziU();
    zzip();
  }
  
  public boolean isConnected()
  {
    if (!this.zzRG) {
      this.zzOP.zziU().zzbd("Connectivity unknown. Receiver not registered");
    }
    return this.zzRH;
  }
  
  public boolean isRegistered()
  {
    return this.zzRG;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    zzli();
    paramContext = paramIntent.getAction();
    this.zzOP.zziU().zza("NetworkBroadcastReceiver received action", paramContext);
    if ("android.net.conn.CONNECTIVITY_CHANGE".equals(paramContext))
    {
      boolean bool = zzlk();
      if (this.zzRH != bool)
      {
        this.zzRH = bool;
        zzip().zzJ(bool);
      }
    }
    do
    {
      return;
      if (!"com.google.analytics.RADIO_POWERED".equals(paramContext)) {
        break;
      }
    } while (paramIntent.hasExtra(zzRF));
    zzip().zziO();
    return;
    this.zzOP.zziU().zzd("NetworkBroadcastReceiver received unknown action", paramContext);
  }
  
  public void unregister()
  {
    if (!isRegistered()) {
      return;
    }
    this.zzOP.zziU().zzba("Unregistering connectivity change receiver");
    this.zzRG = false;
    this.zzRH = false;
    Context localContext = getContext();
    try
    {
      localContext.unregisterReceiver(this);
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      zziU().zze("Failed to unregister the network broadcast receiver", localIllegalArgumentException);
    }
  }
  
  public void zzlh()
  {
    zzli();
    if (this.zzRG) {
      return;
    }
    Context localContext = getContext();
    localContext.registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
    IntentFilter localIntentFilter = new IntentFilter("com.google.analytics.RADIO_POWERED");
    localIntentFilter.addCategory(localContext.getPackageName());
    localContext.registerReceiver(this, localIntentFilter);
    this.zzRH = zzlk();
    this.zzOP.zziU().zza("Registering connectivity change receiver. Network connected", Boolean.valueOf(this.zzRH));
    this.zzRG = true;
  }
  
  public void zzlj()
  {
    if (Build.VERSION.SDK_INT <= 10) {
      return;
    }
    Context localContext = getContext();
    Intent localIntent = new Intent("com.google.analytics.RADIO_POWERED");
    localIntent.addCategory(localContext.getPackageName());
    localIntent.putExtra(zzRF, true);
    localContext.sendOrderedBroadcast(localIntent, null);
  }
  
  protected boolean zzlk()
  {
    Object localObject = (ConnectivityManager)getContext().getSystemService("connectivity");
    try
    {
      localObject = ((ConnectivityManager)localObject).getActiveNetworkInfo();
      if (localObject != null)
      {
        boolean bool = ((NetworkInfo)localObject).isConnected();
        if (bool) {
          return true;
        }
      }
      return false;
    }
    catch (SecurityException localSecurityException) {}
    return false;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/analytics/internal/zzag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */