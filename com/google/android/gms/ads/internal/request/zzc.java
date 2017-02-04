package com.google.android.gms.ads.internal.request;

import android.content.Context;
import com.google.android.gms.ads.internal.client.zzl;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zza;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.internal.zzbv;
import com.google.android.gms.internal.zzbz;
import com.google.android.gms.internal.zzha;
import com.google.android.gms.internal.zzir;
import com.google.android.gms.internal.zzjg;

@zzha
public final class zzc
{
  public static zzir zza(Context paramContext, VersionInfoParcel paramVersionInfoParcel, zzjg<AdRequestInfoParcel> paramzzjg, zza paramzza)
  {
    zza(paramContext, paramVersionInfoParcel, paramzzjg, paramzza, new zzb()
    {
      public boolean zza(VersionInfoParcel paramAnonymousVersionInfoParcel)
      {
        return (paramAnonymousVersionInfoParcel.zzLH) || ((GooglePlayServicesUtil.zzao(this.zzsm)) && (!((Boolean)zzbz.zzvG.get()).booleanValue()));
      }
    });
  }
  
  static zzir zza(Context paramContext, VersionInfoParcel paramVersionInfoParcel, zzjg<AdRequestInfoParcel> paramzzjg, zza paramzza, zzb paramzzb)
  {
    if (paramzzb.zza(paramVersionInfoParcel)) {
      return zza(paramContext, paramzzjg, paramzza);
    }
    return zzb(paramContext, paramVersionInfoParcel, paramzzjg, paramzza);
  }
  
  private static zzir zza(Context paramContext, zzjg<AdRequestInfoParcel> paramzzjg, zza paramzza)
  {
    zzb.zzaF("Fetching ad response from local ad request service.");
    paramContext = new zzd.zza(paramContext, paramzzjg, paramzza);
    paramContext.zzfO();
    return paramContext;
  }
  
  private static zzir zzb(Context paramContext, VersionInfoParcel paramVersionInfoParcel, zzjg<AdRequestInfoParcel> paramzzjg, zza paramzza)
  {
    zzb.zzaF("Fetching ad response from remote ad request service.");
    if (!zzl.zzcN().zzT(paramContext))
    {
      zzb.zzaH("Failed to connect to remote ad request service.");
      return null;
    }
    return new zzd.zzb(paramContext, paramVersionInfoParcel, paramzzjg, paramzza);
  }
  
  public static abstract interface zza
  {
    public abstract void zzb(AdResponseParcel paramAdResponseParcel);
  }
  
  static abstract interface zzb
  {
    public abstract boolean zza(VersionInfoParcel paramVersionInfoParcel);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/ads/internal/request/zzc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */