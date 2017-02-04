package com.google.android.gms.appdatasearch;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.Api.zza;
import com.google.android.gms.common.api.Api.zzc;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.internal.zzkg;
import com.google.android.gms.internal.zzki;

public final class zza
{
  public static final Api.zzc<zzkg> zzSe = new Api.zzc();
  private static final Api.zza<zzkg, Api.ApiOptions.NoOptions> zzSf = new Api.zza()
  {
    public zzkg zza(Context paramAnonymousContext, Looper paramAnonymousLooper, zzf paramAnonymouszzf, Api.ApiOptions.NoOptions paramAnonymousNoOptions, GoogleApiClient.ConnectionCallbacks paramAnonymousConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramAnonymousOnConnectionFailedListener)
    {
      return new zzkg(paramAnonymousContext, paramAnonymousLooper, paramAnonymouszzf, paramAnonymousConnectionCallbacks, paramAnonymousOnConnectionFailedListener);
    }
  };
  public static final Api<Api.ApiOptions.NoOptions> zzSg = new Api("AppDataSearch.LIGHTWEIGHT_API", zzSf, zzSe);
  public static final zzk zzSh = new zzki();
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/appdatasearch/zza.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */