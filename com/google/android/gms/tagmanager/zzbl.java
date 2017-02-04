package com.google.android.gms.tagmanager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;

class zzbl
  extends BroadcastReceiver
{
  static final String zzRF = zzbl.class.getName();
  private final zzct zzbet;
  
  zzbl(zzct paramzzct)
  {
    this.zzbet = paramzzct;
  }
  
  public static void zzbb(Context paramContext)
  {
    Intent localIntent = new Intent("com.google.analytics.RADIO_POWERED");
    localIntent.addCategory(paramContext.getPackageName());
    localIntent.putExtra(zzRF, true);
    paramContext.sendBroadcast(localIntent);
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if ("android.net.conn.CONNECTIVITY_CHANGE".equals(paramContext))
    {
      localBundle = paramIntent.getExtras();
      paramContext = Boolean.FALSE;
      if (localBundle != null) {
        paramContext = Boolean.valueOf(paramIntent.getExtras().getBoolean("noConnectivity"));
      }
      paramIntent = this.zzbet;
      if (!paramContext.booleanValue())
      {
        bool = true;
        paramIntent.zzaw(bool);
      }
    }
    while ((!"com.google.analytics.RADIO_POWERED".equals(paramContext)) || (paramIntent.hasExtra(zzRF))) {
      for (;;)
      {
        Bundle localBundle;
        return;
        boolean bool = false;
      }
    }
    this.zzbet.zziO();
  }
  
  public void zzba(Context paramContext)
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
    paramContext.registerReceiver(this, localIntentFilter);
    localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("com.google.analytics.RADIO_POWERED");
    localIntentFilter.addCategory(paramContext.getPackageName());
    paramContext.registerReceiver(this, localIntentFilter);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/tagmanager/zzbl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */