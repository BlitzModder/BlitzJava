package com.google.android.gms.auth.api;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import com.google.android.gms.auth.api.consent.zza;
import com.google.android.gms.auth.api.credentials.CredentialsApi;
import com.google.android.gms.auth.api.credentials.PasswordSpecification;
import com.google.android.gms.auth.api.proxy.ProxyApi;
import com.google.android.gms.auth.api.signin.GoogleSignInApi;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.internal.zzc;
import com.google.android.gms.auth.api.signin.internal.zzk;
import com.google.android.gms.auth.api.signin.internal.zzl;
import com.google.android.gms.auth.api.signin.zzg;
import com.google.android.gms.auth.api.signin.zzh;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.Api.ApiOptions.Optional;
import com.google.android.gms.common.api.Api.zza;
import com.google.android.gms.common.api.Api.zzc;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.internal.zzko;
import com.google.android.gms.internal.zzkp;
import com.google.android.gms.internal.zzkq;
import com.google.android.gms.internal.zzkt;
import com.google.android.gms.internal.zzku;
import com.google.android.gms.internal.zzkx;
import com.google.android.gms.internal.zzlb;
import java.util.Collections;
import java.util.List;

public final class Auth
{
  public static final Api<AuthCredentialsOptions> CREDENTIALS_API;
  public static final CredentialsApi CredentialsApi;
  public static final Api<GoogleSignInOptions> GOOGLE_SIGN_IN_API;
  public static final GoogleSignInApi GoogleSignInApi = new zzc();
  public static final Api<zza> PROXY_API;
  public static final ProxyApi ProxyApi;
  public static final Api.zzc<zzkx> zzTW = new Api.zzc();
  public static final Api.zzc<com.google.android.gms.auth.api.credentials.internal.zzf> zzTX = new Api.zzc();
  public static final Api.zzc<zzkq> zzTY = new Api.zzc();
  public static final Api.zzc<zzl> zzTZ = new Api.zzc();
  public static final Api.zzc<com.google.android.gms.auth.api.signin.internal.zzd> zzUa = new Api.zzc();
  public static final Api.zzc<zzku> zzUb = new Api.zzc();
  private static final Api.zza<zzkx, zza> zzUc = new Api.zza()
  {
    public zzkx zza(Context paramAnonymousContext, Looper paramAnonymousLooper, com.google.android.gms.common.internal.zzf paramAnonymouszzf, Auth.zza paramAnonymouszza, GoogleApiClient.ConnectionCallbacks paramAnonymousConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramAnonymousOnConnectionFailedListener)
    {
      return new zzkx(paramAnonymousContext, paramAnonymousLooper, paramAnonymouszzf, paramAnonymouszza, paramAnonymousConnectionCallbacks, paramAnonymousOnConnectionFailedListener);
    }
  };
  private static final Api.zza<com.google.android.gms.auth.api.credentials.internal.zzf, AuthCredentialsOptions> zzUd = new Api.zza()
  {
    public com.google.android.gms.auth.api.credentials.internal.zzf zza(Context paramAnonymousContext, Looper paramAnonymousLooper, com.google.android.gms.common.internal.zzf paramAnonymouszzf, Auth.AuthCredentialsOptions paramAnonymousAuthCredentialsOptions, GoogleApiClient.ConnectionCallbacks paramAnonymousConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramAnonymousOnConnectionFailedListener)
    {
      return new com.google.android.gms.auth.api.credentials.internal.zzf(paramAnonymousContext, paramAnonymousLooper, paramAnonymouszzf, paramAnonymousAuthCredentialsOptions, paramAnonymousConnectionCallbacks, paramAnonymousOnConnectionFailedListener);
    }
  };
  private static final Api.zza<zzkq, Api.ApiOptions.NoOptions> zzUe = new Api.zza()
  {
    public zzkq zzc(Context paramAnonymousContext, Looper paramAnonymousLooper, com.google.android.gms.common.internal.zzf paramAnonymouszzf, Api.ApiOptions.NoOptions paramAnonymousNoOptions, GoogleApiClient.ConnectionCallbacks paramAnonymousConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramAnonymousOnConnectionFailedListener)
    {
      return new zzkq(paramAnonymousContext, paramAnonymousLooper, paramAnonymouszzf, paramAnonymousConnectionCallbacks, paramAnonymousOnConnectionFailedListener);
    }
  };
  private static final Api.zza<zzku, Api.ApiOptions.NoOptions> zzUf = new Api.zza()
  {
    public zzku zzd(Context paramAnonymousContext, Looper paramAnonymousLooper, com.google.android.gms.common.internal.zzf paramAnonymouszzf, Api.ApiOptions.NoOptions paramAnonymousNoOptions, GoogleApiClient.ConnectionCallbacks paramAnonymousConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramAnonymousOnConnectionFailedListener)
    {
      return new zzku(paramAnonymousContext, paramAnonymousLooper, paramAnonymouszzf, paramAnonymousConnectionCallbacks, paramAnonymousOnConnectionFailedListener);
    }
  };
  private static final Api.zza<zzl, zzh> zzUg = new Api.zza()
  {
    public zzl zza(Context paramAnonymousContext, Looper paramAnonymousLooper, com.google.android.gms.common.internal.zzf paramAnonymouszzf, zzh paramAnonymouszzh, GoogleApiClient.ConnectionCallbacks paramAnonymousConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramAnonymousOnConnectionFailedListener)
    {
      return new zzl(paramAnonymousContext, paramAnonymousLooper, paramAnonymouszzf, paramAnonymouszzh, paramAnonymousConnectionCallbacks, paramAnonymousOnConnectionFailedListener);
    }
  };
  private static final Api.zza<com.google.android.gms.auth.api.signin.internal.zzd, GoogleSignInOptions> zzUh = new Api.zza()
  {
    public com.google.android.gms.auth.api.signin.internal.zzd zza(Context paramAnonymousContext, Looper paramAnonymousLooper, com.google.android.gms.common.internal.zzf paramAnonymouszzf, GoogleSignInOptions paramAnonymousGoogleSignInOptions, GoogleApiClient.ConnectionCallbacks paramAnonymousConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramAnonymousOnConnectionFailedListener)
    {
      return new com.google.android.gms.auth.api.signin.internal.zzd(paramAnonymousContext, paramAnonymousLooper, paramAnonymouszzf, paramAnonymousGoogleSignInOptions, paramAnonymousConnectionCallbacks, paramAnonymousOnConnectionFailedListener);
    }
    
    public List<Scope> zza(GoogleSignInOptions paramAnonymousGoogleSignInOptions)
    {
      if (paramAnonymousGoogleSignInOptions == null) {
        return Collections.emptyList();
      }
      return paramAnonymousGoogleSignInOptions.zzmu();
    }
  };
  public static final Api<zzh> zzUi;
  public static final Api<Api.ApiOptions.NoOptions> zzUj;
  public static final Api<Api.ApiOptions.NoOptions> zzUk;
  public static final zzko zzUl;
  public static final zzg zzUm;
  public static final zza zzUn = new zzkt();
  
  static
  {
    PROXY_API = new Api("Auth.PROXY_API", zzUc, zzTW);
    CREDENTIALS_API = new Api("Auth.CREDENTIALS_API", zzUd, zzTX);
    zzUi = new Api("Auth.SIGN_IN_API", zzUg, zzTZ);
    GOOGLE_SIGN_IN_API = new Api("Auth.GOOGLE_SIGN_IN_API", zzUh, zzUa);
    zzUj = new Api("Auth.ACCOUNT_STATUS_API", zzUe, zzTY);
    zzUk = new Api("Auth.CONSENT_API", zzUf, zzUb);
    ProxyApi = new zzlb();
    CredentialsApi = new com.google.android.gms.auth.api.credentials.internal.zzd();
    zzUl = new zzkp();
    zzUm = new zzk();
  }
  
  public static final class AuthCredentialsOptions
    implements Api.ApiOptions.Optional
  {
    private final String zzUo;
    private final PasswordSpecification zzUp;
    
    public Bundle zzlU()
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("consumer_package", this.zzUo);
      localBundle.putParcelable("password_specification", this.zzUp);
      return localBundle;
    }
    
    public PasswordSpecification zzma()
    {
      return this.zzUp;
    }
    
    public static class Builder
    {
      private PasswordSpecification zzUp = PasswordSpecification.zzUO;
    }
  }
  
  public static final class zza
    implements Api.ApiOptions.Optional
  {
    private final Bundle zzUq;
    
    public Bundle zzmb()
    {
      return new Bundle(this.zzUq);
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/auth/api/Auth.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */