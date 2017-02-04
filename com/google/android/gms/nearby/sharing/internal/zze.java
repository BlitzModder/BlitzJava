package com.google.android.gms.nearby.sharing.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.Looper;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzj;

class zze
  extends zzj<zzd>
{
  public zze(Context paramContext, Looper paramLooper, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener, zzf paramzzf)
  {
    super(paramContext, paramLooper, 49, paramzzf, paramConnectionCallbacks, paramOnConnectionFailedListener);
  }
  
  protected zzd zzdE(IBinder paramIBinder)
  {
    return zzd.zza.zzdD(paramIBinder);
  }
  
  protected String zzgh()
  {
    return "com.google.android.gms.nearby.sharing.service.NearbySharingService.START";
  }
  
  protected String zzgi()
  {
    return "com.google.android.gms.nearby.sharing.internal.INearbySharingService";
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/nearby/sharing/internal/zze.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */