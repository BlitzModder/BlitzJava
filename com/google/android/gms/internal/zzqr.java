package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.Looper;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzj;

public class zzqr
  extends zzj<zzqw>
{
  public zzqr(Context paramContext, Looper paramLooper, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener, zzf paramzzf)
  {
    super(paramContext, paramLooper, 69, paramzzf, paramConnectionCallbacks, paramOnConnectionFailedListener);
  }
  
  protected zzqw zzdk(IBinder paramIBinder)
  {
    return zzqw.zza.zzdo(paramIBinder);
  }
  
  protected String zzgh()
  {
    return "com.google.android.gms.nearby.bootstrap.service.NearbyBootstrapService.START";
  }
  
  protected String zzgi()
  {
    return "com.google.android.gms.nearby.bootstrap.internal.INearbyBootstrapService";
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/internal/zzqr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */