package com.google.android.gms.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import com.google.android.gms.common.GoogleApiAvailability;

abstract class zzmk
  extends BroadcastReceiver
{
  protected Context mContext;
  
  public static <T extends zzmk> T zza(Context paramContext, T paramT)
  {
    return zza(paramContext, paramT, GoogleApiAvailability.getInstance());
  }
  
  public static <T extends zzmk> T zza(Context paramContext, T paramT, GoogleApiAvailability paramGoogleApiAvailability)
  {
    Object localObject = new IntentFilter("android.intent.action.PACKAGE_ADDED");
    ((IntentFilter)localObject).addDataScheme("package");
    paramContext.registerReceiver(paramT, (IntentFilter)localObject);
    paramT.mContext = paramContext;
    localObject = paramT;
    if (!paramGoogleApiAvailability.zzh(paramContext, "com.google.android.gms"))
    {
      paramT.zzpv();
      paramT.unregister();
      localObject = null;
    }
    return (T)localObject;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramIntent = paramIntent.getData();
    paramContext = null;
    if (paramIntent != null) {
      paramContext = paramIntent.getSchemeSpecificPart();
    }
    if ("com.google.android.gms".equals(paramContext))
    {
      zzpv();
      unregister();
    }
  }
  
  public void unregister()
  {
    try
    {
      if (this.mContext != null) {
        this.mContext.unregisterReceiver(this);
      }
      this.mContext = null;
      return;
    }
    finally {}
  }
  
  protected abstract void zzpv();
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/internal/zzmk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */