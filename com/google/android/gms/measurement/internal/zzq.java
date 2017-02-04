package com.google.android.gms.measurement.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.google.android.gms.common.internal.zzx;

class zzq
  extends BroadcastReceiver
{
  static final String zzRF = zzq.class.getName();
  private boolean zzRG;
  private boolean zzRH;
  private final zzt zzaQX;
  
  zzq(zzt paramzzt)
  {
    zzx.zzy(paramzzt);
    this.zzaQX = paramzzt;
  }
  
  private Context getContext()
  {
    return this.zzaQX.getContext();
  }
  
  private zzo zzzz()
  {
    return this.zzaQX.zzzz();
  }
  
  public boolean isRegistered()
  {
    this.zzaQX.zziS();
    return this.zzRG;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    this.zzaQX.zzje();
    paramContext = paramIntent.getAction();
    zzzz().zzBr().zzj("NetworkBroadcastReceiver received action", paramContext);
    if ("android.net.conn.CONNECTIVITY_CHANGE".equals(paramContext))
    {
      final boolean bool = this.zzaQX.zzBE().zzlk();
      if (this.zzRH != bool)
      {
        this.zzRH = bool;
        this.zzaQX.zzAV().zzg(new Runnable()
        {
          public void run()
          {
            zzq.zza(zzq.this).zzJ(bool);
          }
        });
      }
      return;
    }
    zzzz().zzBm().zzj("NetworkBroadcastReceiver received unknown action", paramContext);
  }
  
  public void unregister()
  {
    this.zzaQX.zzje();
    this.zzaQX.zziS();
    if (!isRegistered()) {
      return;
    }
    zzzz().zzBr().zzez("Unregistering connectivity change receiver");
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
      zzzz().zzBl().zzj("Failed to unregister the network broadcast receiver", localIllegalArgumentException);
    }
  }
  
  public void zzlh()
  {
    this.zzaQX.zzje();
    this.zzaQX.zziS();
    if (this.zzRG) {
      return;
    }
    getContext().registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
    this.zzRH = this.zzaQX.zzBE().zzlk();
    zzzz().zzBr().zzj("Registering connectivity change receiver. Network connected", Boolean.valueOf(this.zzRH));
    this.zzRG = true;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/measurement/internal/zzq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */