package com.google.android.gms.plus;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.Optional;
import com.google.android.gms.common.api.Api.zza;
import com.google.android.gms.common.api.Api.zzc;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzlx.zza;
import com.google.android.gms.internal.zzoa;
import com.google.android.gms.internal.zzrk;
import com.google.android.gms.internal.zzrl;
import com.google.android.gms.internal.zzrm;
import com.google.android.gms.internal.zzrn;
import com.google.android.gms.internal.zzro;
import com.google.android.gms.plus.internal.PlusCommonExtras;
import com.google.android.gms.plus.internal.PlusSession;
import com.google.android.gms.plus.internal.zze;
import java.util.HashSet;
import java.util.Set;

public final class Plus
{
  public static final Api<PlusOptions> API;
  @Deprecated
  public static final Account AccountApi = new zzrk();
  public static final Moments MomentsApi;
  public static final People PeopleApi;
  public static final Scope SCOPE_PLUS_LOGIN;
  public static final Scope SCOPE_PLUS_PROFILE;
  public static final Api.zzc<zze> zzTo = new Api.zzc();
  static final Api.zza<zze, PlusOptions> zzTp = new Api.zza()
  {
    public int getPriority()
    {
      return 2;
    }
    
    public zze zza(Context paramAnonymousContext, Looper paramAnonymousLooper, zzf paramAnonymouszzf, Plus.PlusOptions paramAnonymousPlusOptions, GoogleApiClient.ConnectionCallbacks paramAnonymousConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramAnonymousOnConnectionFailedListener)
    {
      Object localObject = paramAnonymousPlusOptions;
      if (paramAnonymousPlusOptions == null) {
        localObject = new Plus.PlusOptions(null);
      }
      paramAnonymousPlusOptions = paramAnonymouszzf.zzpY().name;
      String[] arrayOfString = zzoa.zzc(paramAnonymouszzf.zzqb());
      localObject = (String[])((Plus.PlusOptions)localObject).zzaYM.toArray(new String[0]);
      String str1 = paramAnonymousContext.getPackageName();
      String str2 = paramAnonymousContext.getPackageName();
      PlusCommonExtras localPlusCommonExtras = new PlusCommonExtras();
      return new zze(paramAnonymousContext, paramAnonymousLooper, paramAnonymouszzf, new PlusSession(paramAnonymousPlusOptions, arrayOfString, (String[])localObject, new String[0], str1, str2, null, localPlusCommonExtras), paramAnonymousConnectionCallbacks, paramAnonymousOnConnectionFailedListener);
    }
  };
  public static final zzb zzaYJ = new zzrm();
  public static final zza zzaYK = new zzrl();
  
  static
  {
    API = new Api("Plus.API", zzTp, zzTo);
    SCOPE_PLUS_LOGIN = new Scope("https://www.googleapis.com/auth/plus.login");
    SCOPE_PLUS_PROFILE = new Scope("https://www.googleapis.com/auth/plus.me");
    MomentsApi = new zzrn();
    PeopleApi = new zzro();
  }
  
  public static zze zzf(GoogleApiClient paramGoogleApiClient, boolean paramBoolean)
  {
    if (paramGoogleApiClient != null) {}
    for (boolean bool = true;; bool = false)
    {
      zzx.zzb(bool, "GoogleApiClient parameter is required.");
      zzx.zza(paramGoogleApiClient.isConnected(), "GoogleApiClient must be connected.");
      zzx.zza(paramGoogleApiClient.zza(API), "GoogleApiClient is not configured to use the Plus.API Api. Pass this into GoogleApiClient.Builder#addApi() to use this feature.");
      bool = paramGoogleApiClient.hasConnectedApi(API);
      if ((!paramBoolean) || (bool)) {
        break;
      }
      throw new IllegalStateException("GoogleApiClient has an optional Plus.API and is not connected to Plus. Use GoogleApiClient.hasConnectedApi(Plus.API) to guard this call.");
    }
    if (bool) {
      return (zze)paramGoogleApiClient.zza(zzTo);
    }
    return null;
  }
  
  public static final class PlusOptions
    implements Api.ApiOptions.Optional
  {
    final String zzaYL;
    final Set<String> zzaYM;
    
    private PlusOptions()
    {
      this.zzaYL = null;
      this.zzaYM = new HashSet();
    }
    
    private PlusOptions(Builder paramBuilder)
    {
      this.zzaYL = paramBuilder.zzaYL;
      this.zzaYM = paramBuilder.zzaYM;
    }
    
    public static Builder builder()
    {
      return new Builder();
    }
    
    public static final class Builder
    {
      String zzaYL;
      final Set<String> zzaYM = new HashSet();
      
      public Builder addActivityTypes(String... paramVarArgs)
      {
        zzx.zzb(paramVarArgs, "activityTypes may not be null.");
        int i = 0;
        while (i < paramVarArgs.length)
        {
          this.zzaYM.add(paramVarArgs[i]);
          i += 1;
        }
        return this;
      }
      
      public Plus.PlusOptions build()
      {
        return new Plus.PlusOptions(this, null);
      }
      
      public Builder setServerClientId(String paramString)
      {
        this.zzaYL = paramString;
        return this;
      }
    }
  }
  
  public static abstract class zza<R extends Result>
    extends zzlx.zza<R, zze>
  {
    public zza(GoogleApiClient paramGoogleApiClient)
    {
      super(paramGoogleApiClient);
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/plus/Plus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */