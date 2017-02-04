package com.google.android.gms.wearable;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.Optional;
import com.google.android.gms.common.api.Api.zza;
import com.google.android.gms.common.api.Api.zzc;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.wearable.internal.zzbc;
import com.google.android.gms.wearable.internal.zzbm;
import com.google.android.gms.wearable.internal.zzbo;
import com.google.android.gms.wearable.internal.zzcb;
import com.google.android.gms.wearable.internal.zzce;
import com.google.android.gms.wearable.internal.zzcg;
import com.google.android.gms.wearable.internal.zze;
import com.google.android.gms.wearable.internal.zzg;
import com.google.android.gms.wearable.internal.zzw;
import com.google.android.gms.wearable.internal.zzx;

public class Wearable
{
  public static final Api<WearableOptions> API = new Api("Wearable.API", zzTp, zzTo);
  public static final CapabilityApi CapabilityApi;
  public static final ChannelApi ChannelApi;
  public static final DataApi DataApi = new zzx();
  public static final MessageApi MessageApi;
  public static final NodeApi NodeApi;
  public static final Api.zzc<zzce> zzTo;
  private static final Api.zza<zzce, WearableOptions> zzTp;
  public static final LargeAssetApi zzbma;
  public static final zzc zzbmb;
  public static final zza zzbmc;
  public static final zzf zzbmd;
  public static final zzj zzbme;
  public static final zzl zzbmf;
  
  static
  {
    CapabilityApi = new com.google.android.gms.wearable.internal.zzj();
    MessageApi = new zzbm();
    NodeApi = new zzbo();
    ChannelApi = new com.google.android.gms.wearable.internal.zzl();
    zzbma = new zzbc();
    zzbmb = new zzg();
    zzbmc = new zze();
    zzbmd = new zzw();
    zzbme = new zzcb();
    zzbmf = new zzcg();
    zzTo = new Api.zzc();
    zzTp = new Api.zza()
    {
      public zzce zza(Context paramAnonymousContext, Looper paramAnonymousLooper, com.google.android.gms.common.internal.zzf paramAnonymouszzf, Wearable.WearableOptions paramAnonymousWearableOptions, GoogleApiClient.ConnectionCallbacks paramAnonymousConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramAnonymousOnConnectionFailedListener)
      {
        if (paramAnonymousWearableOptions != null) {}
        for (;;)
        {
          return new zzce(paramAnonymousContext, paramAnonymousLooper, paramAnonymousConnectionCallbacks, paramAnonymousOnConnectionFailedListener, paramAnonymouszzf);
          new Wearable.WearableOptions(new Wearable.WearableOptions.Builder(), null);
        }
      }
    };
  }
  
  public static final class WearableOptions
    implements Api.ApiOptions.Optional
  {
    private WearableOptions(Builder paramBuilder) {}
    
    public static class Builder
    {
      public Wearable.WearableOptions build()
      {
        return new Wearable.WearableOptions(this, null);
      }
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/wearable/Wearable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */