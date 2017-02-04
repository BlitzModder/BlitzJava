package com.google.android.gms.internal;

import android.text.TextUtils;
import com.google.android.gms.measurement.zze;
import java.util.HashMap;
import java.util.Map;

public final class zzqh
  extends zze<zzqh>
{
  private String zzRk;
  private String zzRl;
  private String zzaRG;
  private String zzaRd;
  
  public void setAppId(String paramString)
  {
    this.zzaRd = paramString;
  }
  
  public void setAppInstallerId(String paramString)
  {
    this.zzaRG = paramString;
  }
  
  public void setAppName(String paramString)
  {
    this.zzRk = paramString;
  }
  
  public void setAppVersion(String paramString)
  {
    this.zzRl = paramString;
  }
  
  public String toString()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("appName", this.zzRk);
    localHashMap.put("appVersion", this.zzRl);
    localHashMap.put("appId", this.zzaRd);
    localHashMap.put("appInstallerId", this.zzaRG);
    return zzE(localHashMap);
  }
  
  public void zza(zzqh paramzzqh)
  {
    if (!TextUtils.isEmpty(this.zzRk)) {
      paramzzqh.setAppName(this.zzRk);
    }
    if (!TextUtils.isEmpty(this.zzRl)) {
      paramzzqh.setAppVersion(this.zzRl);
    }
    if (!TextUtils.isEmpty(this.zzaRd)) {
      paramzzqh.setAppId(this.zzaRd);
    }
    if (!TextUtils.isEmpty(this.zzaRG)) {
      paramzzqh.setAppInstallerId(this.zzaRG);
    }
  }
  
  public String zzkP()
  {
    return this.zzRk;
  }
  
  public String zzkR()
  {
    return this.zzRl;
  }
  
  public String zzwg()
  {
    return this.zzaRd;
  }
  
  public String zzzT()
  {
    return this.zzaRG;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/internal/zzqh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */