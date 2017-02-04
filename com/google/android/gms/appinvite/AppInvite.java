package com.google.android.gms.appinvite;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.Api.zza;
import com.google.android.gms.common.api.Api.zzc;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.internal.zzkj;
import com.google.android.gms.internal.zzkk;

public final class AppInvite
{
  public static final Api<Api.ApiOptions.NoOptions> API = new Api("AppInvite.API", zzTp, zzTo);
  public static final AppInviteApi AppInviteApi = new zzkj();
  public static final Api.zzc<zzkk> zzTo = new Api.zzc();
  private static final Api.zza<zzkk, Api.ApiOptions.NoOptions> zzTp = new Api.zza()
  {
    public zzkk zzb(Context paramAnonymousContext, Looper paramAnonymousLooper, zzf paramAnonymouszzf, Api.ApiOptions.NoOptions paramAnonymousNoOptions, GoogleApiClient.ConnectionCallbacks paramAnonymousConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramAnonymousOnConnectionFailedListener)
    {
      return new zzkk(paramAnonymousContext, paramAnonymousLooper, paramAnonymousConnectionCallbacks, paramAnonymousOnConnectionFailedListener, paramAnonymouszzf);
    }
  };
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/appinvite/AppInvite.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */