package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.Looper;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.Api.zza;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzf;

public class zzov
  extends zzor<zzpg>
{
  public zzov(Context paramContext, Looper paramLooper, zzf paramzzf, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    super(paramContext, paramLooper, 61, paramConnectionCallbacks, paramOnConnectionFailedListener, paramzzf);
  }
  
  protected zzpg zzbx(IBinder paramIBinder)
  {
    return zzpg.zza.zzbI(paramIBinder);
  }
  
  protected String zzgh()
  {
    return "com.google.android.gms.fitness.InternalApi";
  }
  
  protected String zzgi()
  {
    return "com.google.android.gms.fitness.internal.IGoogleFitInternalApi";
  }
  
  public static class zza
    extends Api.zza<zzov, Api.ApiOptions.NoOptions>
  {
    public zzov zzj(Context paramContext, Looper paramLooper, zzf paramzzf, Api.ApiOptions.NoOptions paramNoOptions, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
    {
      return new zzov(paramContext, paramLooper, paramzzf, paramConnectionCallbacks, paramOnConnectionFailedListener);
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/internal/zzov.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */