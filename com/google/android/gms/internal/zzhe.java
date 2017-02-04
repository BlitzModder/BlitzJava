package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.util.client.zzb;
import java.util.Map;
import java.util.concurrent.Future;

@zzha
public final class zzhe
{
  private String zzDX;
  private String zzHV;
  private zzjb<zzhh> zzHW = new zzjb();
  zzei.zzd zzHX;
  public final zzdl zzHY = new zzdl()
  {
    public void zza(zzjn arg1, Map<String, String> paramAnonymousMap)
    {
      synchronized (zzhe.zza(zzhe.this))
      {
        if (zzhe.zzb(zzhe.this).isDone()) {
          return;
        }
        if (!zzhe.zzc(zzhe.this).equals(paramAnonymousMap.get("request_id"))) {
          return;
        }
      }
      paramAnonymousMap = new zzhh(1, paramAnonymousMap);
      zzb.zzaH("Invalid " + paramAnonymousMap.getType() + " request error: " + paramAnonymousMap.zzgr());
      zzhe.zzb(zzhe.this).zzf(paramAnonymousMap);
    }
  };
  public final zzdl zzHZ = new zzdl()
  {
    public void zza(zzjn paramAnonymouszzjn, Map<String, String> paramAnonymousMap)
    {
      zzhh localzzhh;
      synchronized (zzhe.zza(zzhe.this))
      {
        if (zzhe.zzb(zzhe.this).isDone()) {
          return;
        }
        localzzhh = new zzhh(-2, paramAnonymousMap);
        if (!zzhe.zzc(zzhe.this).equals(localzzhh.getRequestId()))
        {
          zzb.zzaH(localzzhh.getRequestId() + " ==== " + zzhe.zzc(zzhe.this));
          return;
        }
      }
      String str = localzzhh.getUrl();
      if (str == null)
      {
        zzb.zzaH("URL missing in loadAdUrl GMSG.");
        return;
      }
      if (str.contains("%40mediation_adapters%40"))
      {
        paramAnonymouszzjn = str.replaceAll("%40mediation_adapters%40", zzik.zza(paramAnonymouszzjn.getContext(), (String)paramAnonymousMap.get("check_adapters"), zzhe.zzd(zzhe.this)));
        localzzhh.setUrl(paramAnonymouszzjn);
        zzb.v("Ad request URL modified to " + paramAnonymouszzjn);
      }
      zzhe.zzb(zzhe.this).zzf(localzzhh);
    }
  };
  private final Object zzpK = new Object();
  zzjn zzps;
  
  public zzhe(String paramString1, String paramString2)
  {
    this.zzHV = paramString2;
    this.zzDX = paramString1;
  }
  
  public void zzb(zzei.zzd paramzzd)
  {
    this.zzHX = paramzzd;
  }
  
  public void zze(zzjn paramzzjn)
  {
    this.zzps = paramzzjn;
  }
  
  public zzei.zzd zzgo()
  {
    return this.zzHX;
  }
  
  public Future<zzhh> zzgp()
  {
    return this.zzHW;
  }
  
  public void zzgq()
  {
    if (this.zzps != null)
    {
      this.zzps.destroy();
      this.zzps = null;
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/internal/zzhe.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */