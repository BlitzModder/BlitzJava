package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.HasOptions;
import com.google.android.gms.common.api.Api.zza;
import com.google.android.gms.common.api.Api.zzc;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.signin.internal.zzh;
import com.google.android.gms.signin.internal.zzi;
import java.util.concurrent.Executors;

public final class zzsa
{
  public static final Api<zzsd> API = new Api("SignIn.API", zzTp, zzTo);
  public static final Api.zzc<zzi> zzTo = new Api.zzc();
  public static final Api.zza<zzi, zzsd> zzTp;
  public static final Scope zzVA;
  public static final Scope zzVB;
  public static final Api<zza> zzamM = new Api("SignIn.INTERNAL_API", zzbbE, zzatI);
  public static final Api.zzc<zzi> zzatI = new Api.zzc();
  static final Api.zza<zzi, zza> zzbbE;
  public static final zzsb zzbbF = new zzh();
  
  static
  {
    zzTp = new Api.zza()
    {
      public zzi zza(Context paramAnonymousContext, Looper paramAnonymousLooper, zzf paramAnonymouszzf, zzsd paramAnonymouszzsd, GoogleApiClient.ConnectionCallbacks paramAnonymousConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramAnonymousOnConnectionFailedListener)
      {
        if (paramAnonymouszzsd == null) {
          paramAnonymouszzsd = zzsd.zzbbH;
        }
        for (;;)
        {
          return new zzi(paramAnonymousContext, paramAnonymousLooper, true, paramAnonymouszzf, paramAnonymouszzsd, paramAnonymousConnectionCallbacks, paramAnonymousOnConnectionFailedListener, Executors.newSingleThreadExecutor());
        }
      }
    };
    zzbbE = new Api.zza()
    {
      public zzi zza(Context paramAnonymousContext, Looper paramAnonymousLooper, zzf paramAnonymouszzf, zzsa.zza paramAnonymouszza, GoogleApiClient.ConnectionCallbacks paramAnonymousConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramAnonymousOnConnectionFailedListener)
      {
        return new zzi(paramAnonymousContext, paramAnonymousLooper, false, paramAnonymouszzf, paramAnonymouszza.zzDK(), paramAnonymousConnectionCallbacks, paramAnonymousOnConnectionFailedListener);
      }
    };
    zzVA = new Scope("profile");
    zzVB = new Scope("email");
  }
  
  public static class zza
    implements Api.ApiOptions.HasOptions
  {
    private final Bundle zzbbG;
    
    public Bundle zzDK()
    {
      return this.zzbbG;
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/internal/zzsa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */