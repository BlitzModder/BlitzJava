package com.google.android.gms.search;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.Api.zza;
import com.google.android.gms.common.api.Api.zzc;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.internal.zzry;
import com.google.android.gms.internal.zzrz;

public class SearchAuth
{
  public static final Api<Api.ApiOptions.NoOptions> API = new Api("SearchAuth.API", zzbbw, zzTo);
  public static final SearchAuthApi SearchAuthApi = new zzrz();
  public static final Api.zzc<zzry> zzTo;
  private static final Api.zza<zzry, Api.ApiOptions.NoOptions> zzbbw = new Api.zza()
  {
    public zzry zzt(Context paramAnonymousContext, Looper paramAnonymousLooper, zzf paramAnonymouszzf, Api.ApiOptions.NoOptions paramAnonymousNoOptions, GoogleApiClient.ConnectionCallbacks paramAnonymousConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramAnonymousOnConnectionFailedListener)
    {
      return new zzry(paramAnonymousContext, paramAnonymousConnectionCallbacks, paramAnonymousOnConnectionFailedListener, paramAnonymouszzf);
    }
  };
  
  static
  {
    zzTo = new Api.zzc();
  }
  
  public static class StatusCodes
  {
    public static final int AUTH_DISABLED = 10000;
    public static final int AUTH_THROTTLED = 10001;
    public static final int DEVELOPER_ERROR = 10;
    public static final int INTERNAL_ERROR = 8;
    public static final int SUCCESS = 0;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/search/SearchAuth.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */