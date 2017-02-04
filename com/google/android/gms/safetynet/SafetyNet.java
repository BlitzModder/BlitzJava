package com.google.android.gms.safetynet;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.Api.zza;
import com.google.android.gms.common.api.Api.zzc;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.internal.zzrt;
import com.google.android.gms.internal.zzru;
import com.google.android.gms.internal.zzrv;

public final class SafetyNet
{
  public static final Api<Api.ApiOptions.NoOptions> API = new Api("SafetyNet.API", zzTp, zzTo);
  public static final SafetyNetApi SafetyNetApi = new zzrt();
  public static final Api.zzc<zzru> zzTo = new Api.zzc();
  public static final Api.zza<zzru, Api.ApiOptions.NoOptions> zzTp = new Api.zza()
  {
    public zzru zzs(Context paramAnonymousContext, Looper paramAnonymousLooper, zzf paramAnonymouszzf, Api.ApiOptions.NoOptions paramAnonymousNoOptions, GoogleApiClient.ConnectionCallbacks paramAnonymousConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramAnonymousOnConnectionFailedListener)
    {
      return new zzru(paramAnonymousContext, paramAnonymousLooper, paramAnonymouszzf, paramAnonymousConnectionCallbacks, paramAnonymousOnConnectionFailedListener);
    }
  };
  public static final zzc zzbbj = new zzrv();
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/safetynet/SafetyNet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */