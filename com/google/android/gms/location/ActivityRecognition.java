package com.google.android.gms.location;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.Api.zza;
import com.google.android.gms.common.api.Api.zzc;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.internal.zzlx.zza;
import com.google.android.gms.location.internal.zza;
import com.google.android.gms.location.internal.zzl;

public class ActivityRecognition
{
  public static final Api<Api.ApiOptions.NoOptions> API = new Api("ActivityRecognition.API", zzTp, zzTo);
  public static final ActivityRecognitionApi ActivityRecognitionApi = new zza();
  public static final String CLIENT_NAME = "activity_recognition";
  private static final Api.zzc<zzl> zzTo = new Api.zzc();
  private static final Api.zza<zzl, Api.ApiOptions.NoOptions> zzTp = new Api.zza()
  {
    public zzl zzn(Context paramAnonymousContext, Looper paramAnonymousLooper, zzf paramAnonymouszzf, Api.ApiOptions.NoOptions paramAnonymousNoOptions, GoogleApiClient.ConnectionCallbacks paramAnonymousConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramAnonymousOnConnectionFailedListener)
    {
      return new zzl(paramAnonymousContext, paramAnonymousLooper, paramAnonymousConnectionCallbacks, paramAnonymousOnConnectionFailedListener, "activity_recognition");
    }
  };
  
  public static abstract class zza<R extends Result>
    extends zzlx.zza<R, zzl>
  {
    public zza(GoogleApiClient paramGoogleApiClient)
    {
      super(paramGoogleApiClient);
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/location/ActivityRecognition.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */