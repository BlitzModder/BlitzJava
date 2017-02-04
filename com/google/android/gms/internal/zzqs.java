package com.google.android.gms.internal;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.Api.zza;
import com.google.android.gms.common.api.Api.zzc;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.nearby.bootstrap.zza;

public class zzqs
  implements zza
{
  public static final Api.zzc<zzqr> zzTo = new Api.zzc();
  public static final Api.zza<zzqr, Api.ApiOptions.NoOptions> zzTp = new Api.zza()
  {
    public zzqr zzo(Context paramAnonymousContext, Looper paramAnonymousLooper, zzf paramAnonymouszzf, Api.ApiOptions.NoOptions paramAnonymousNoOptions, GoogleApiClient.ConnectionCallbacks paramAnonymousConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramAnonymousOnConnectionFailedListener)
    {
      return new zzqr(paramAnonymousContext, paramAnonymousLooper, paramAnonymousConnectionCallbacks, paramAnonymousOnConnectionFailedListener, paramAnonymouszzf);
    }
  };
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/internal/zzqs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */