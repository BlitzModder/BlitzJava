package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.Looper;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzj;

public class zzn
  extends zzj<zzl>
{
  public zzn(Context paramContext, Looper paramLooper, zzf paramzzf, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    super(paramContext, paramLooper, 93, paramzzf, paramConnectionCallbacks, paramOnConnectionFailedListener);
  }
  
  public zzl zzdj(IBinder paramIBinder)
  {
    return zzl.zza.zzdi(paramIBinder);
  }
  
  protected String zzgh()
  {
    return "com.google.android.gms.measurement.START";
  }
  
  protected String zzgi()
  {
    return "com.google.android.gms.measurement.internal.IMeasurementService";
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/measurement/internal/zzn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */