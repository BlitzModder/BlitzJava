package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.Looper;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.Api.zza;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.fitness.Fitness;

public class zzot
  extends zzor<zzpe>
{
  public zzot(Context paramContext, Looper paramLooper, zzf paramzzf, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    super(paramContext, paramLooper, 60, paramConnectionCallbacks, paramOnConnectionFailedListener, paramzzf);
  }
  
  protected zzpe zzbv(IBinder paramIBinder)
  {
    return zzpe.zza.zzbG(paramIBinder);
  }
  
  protected String zzgh()
  {
    return "com.google.android.gms.fitness.ConfigApi";
  }
  
  protected String zzgi()
  {
    return "com.google.android.gms.fitness.internal.IGoogleFitConfigApi";
  }
  
  static abstract class zza<R extends Result>
    extends zzlx.zza<R, zzot>
  {
    public zza(GoogleApiClient paramGoogleApiClient)
    {
      super(paramGoogleApiClient);
    }
  }
  
  public static class zzb
    extends Api.zza<zzot, Api.ApiOptions.NoOptions>
  {
    public zzot zzh(Context paramContext, Looper paramLooper, zzf paramzzf, Api.ApiOptions.NoOptions paramNoOptions, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
    {
      return new zzot(paramContext, paramLooper, paramzzf, paramConnectionCallbacks, paramOnConnectionFailedListener);
    }
  }
  
  static abstract class zzc
    extends zzot.zza<Status>
  {
    zzc(GoogleApiClient paramGoogleApiClient)
    {
      super();
    }
    
    protected Status zzb(Status paramStatus)
    {
      if (!paramStatus.isSuccess()) {}
      for (boolean bool = true;; bool = false)
      {
        zzx.zzab(bool);
        return paramStatus;
      }
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/internal/zzot.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */