package com.google.android.gms.cast;

import android.content.Context;
import android.os.Looper;
import android.view.Display;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.HasOptions;
import com.google.android.gms.common.api.Api.zza;
import com.google.android.gms.common.api.Api.zzc;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzlo;
import com.google.android.gms.internal.zzlp;

public final class CastRemoteDisplay
{
  public static final Api<CastRemoteDisplayOptions> API = new Api("CastRemoteDisplay.API", zzTp, zzTo);
  public static final CastRemoteDisplayApi CastRemoteDisplayApi = new zzlo(zzTo);
  private static final Api.zzc<zzlp> zzTo = new Api.zzc();
  private static final Api.zza<zzlp, CastRemoteDisplayOptions> zzTp = new Api.zza()
  {
    public zzlp zza(Context paramAnonymousContext, Looper paramAnonymousLooper, zzf paramAnonymouszzf, CastRemoteDisplay.CastRemoteDisplayOptions paramAnonymousCastRemoteDisplayOptions, GoogleApiClient.ConnectionCallbacks paramAnonymousConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramAnonymousOnConnectionFailedListener)
    {
      return new zzlp(paramAnonymousContext, paramAnonymousLooper, paramAnonymouszzf, paramAnonymousCastRemoteDisplayOptions.zzYf, paramAnonymousCastRemoteDisplayOptions.zzYw, paramAnonymousConnectionCallbacks, paramAnonymousOnConnectionFailedListener);
    }
  };
  
  public static final class CastRemoteDisplayOptions
    implements Api.ApiOptions.HasOptions
  {
    final CastDevice zzYf;
    final CastRemoteDisplay.CastRemoteDisplaySessionCallbacks zzYw;
    
    private CastRemoteDisplayOptions(Builder paramBuilder)
    {
      this.zzYf = paramBuilder.zzYi;
      this.zzYw = paramBuilder.zzYx;
    }
    
    public static final class Builder
    {
      CastDevice zzYi;
      CastRemoteDisplay.CastRemoteDisplaySessionCallbacks zzYx;
      
      public Builder(CastDevice paramCastDevice, CastRemoteDisplay.CastRemoteDisplaySessionCallbacks paramCastRemoteDisplaySessionCallbacks)
      {
        zzx.zzb(paramCastDevice, "CastDevice parameter cannot be null");
        this.zzYi = paramCastDevice;
        this.zzYx = paramCastRemoteDisplaySessionCallbacks;
      }
      
      public CastRemoteDisplay.CastRemoteDisplayOptions build()
      {
        return new CastRemoteDisplay.CastRemoteDisplayOptions(this, null);
      }
    }
  }
  
  public static abstract interface CastRemoteDisplaySessionCallbacks
  {
    public abstract void onRemoteDisplayEnded(Status paramStatus);
  }
  
  public static abstract interface CastRemoteDisplaySessionResult
    extends Result
  {
    public abstract Display getPresentationDisplay();
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/cast/CastRemoteDisplay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */