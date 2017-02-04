package com.google.android.gms.panorama;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.Api.zza;
import com.google.android.gms.common.api.Api.zzc;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.internal.zzrf;
import com.google.android.gms.internal.zzrg;

public final class Panorama
{
  public static final Api<Api.ApiOptions.NoOptions> API = new Api("Panorama.API", zzTp, zzTo);
  public static final PanoramaApi PanoramaApi = new zzrf();
  public static final Api.zzc<zzrg> zzTo = new Api.zzc();
  static final Api.zza<zzrg, Api.ApiOptions.NoOptions> zzTp = new Api.zza()
  {
    public zzrg zzr(Context paramAnonymousContext, Looper paramAnonymousLooper, zzf paramAnonymouszzf, Api.ApiOptions.NoOptions paramAnonymousNoOptions, GoogleApiClient.ConnectionCallbacks paramAnonymousConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramAnonymousOnConnectionFailedListener)
    {
      return new zzrg(paramAnonymousContext, paramAnonymousLooper, paramAnonymouszzf, paramAnonymousConnectionCallbacks, paramAnonymousOnConnectionFailedListener);
    }
  };
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/panorama/Panorama.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */