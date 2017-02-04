package com.google.android.gms.internal;

import android.text.TextUtils;
import com.google.android.gms.measurement.zze;
import java.util.HashMap;
import java.util.Map;

public final class zzqi
  extends zze<zzqi>
{
  private String mName;
  private String zzaMP;
  private String zzaRH;
  private String zzaRI;
  private String zzaRJ;
  private String zzaRK;
  private String zzaRL;
  private String zzaRM;
  private String zzxX;
  private String zzxi;
  
  public String getContent()
  {
    return this.zzxi;
  }
  
  public String getId()
  {
    return this.zzxX;
  }
  
  public String getName()
  {
    return this.mName;
  }
  
  public String getSource()
  {
    return this.zzaMP;
  }
  
  public void setName(String paramString)
  {
    this.mName = paramString;
  }
  
  public String toString()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("name", this.mName);
    localHashMap.put("source", this.zzaMP);
    localHashMap.put("medium", this.zzaRH);
    localHashMap.put("keyword", this.zzaRI);
    localHashMap.put("content", this.zzxi);
    localHashMap.put("id", this.zzxX);
    localHashMap.put("adNetworkId", this.zzaRJ);
    localHashMap.put("gclid", this.zzaRK);
    localHashMap.put("dclid", this.zzaRL);
    localHashMap.put("aclid", this.zzaRM);
    return zzE(localHashMap);
  }
  
  public void zza(zzqi paramzzqi)
  {
    if (!TextUtils.isEmpty(this.mName)) {
      paramzzqi.setName(this.mName);
    }
    if (!TextUtils.isEmpty(this.zzaMP)) {
      paramzzqi.zzee(this.zzaMP);
    }
    if (!TextUtils.isEmpty(this.zzaRH)) {
      paramzzqi.zzef(this.zzaRH);
    }
    if (!TextUtils.isEmpty(this.zzaRI)) {
      paramzzqi.zzeg(this.zzaRI);
    }
    if (!TextUtils.isEmpty(this.zzxi)) {
      paramzzqi.zzeh(this.zzxi);
    }
    if (!TextUtils.isEmpty(this.zzxX)) {
      paramzzqi.zzei(this.zzxX);
    }
    if (!TextUtils.isEmpty(this.zzaRJ)) {
      paramzzqi.zzej(this.zzaRJ);
    }
    if (!TextUtils.isEmpty(this.zzaRK)) {
      paramzzqi.zzek(this.zzaRK);
    }
    if (!TextUtils.isEmpty(this.zzaRL)) {
      paramzzqi.zzel(this.zzaRL);
    }
    if (!TextUtils.isEmpty(this.zzaRM)) {
      paramzzqi.zzem(this.zzaRM);
    }
  }
  
  public void zzee(String paramString)
  {
    this.zzaMP = paramString;
  }
  
  public void zzef(String paramString)
  {
    this.zzaRH = paramString;
  }
  
  public void zzeg(String paramString)
  {
    this.zzaRI = paramString;
  }
  
  public void zzeh(String paramString)
  {
    this.zzxi = paramString;
  }
  
  public void zzei(String paramString)
  {
    this.zzxX = paramString;
  }
  
  public void zzej(String paramString)
  {
    this.zzaRJ = paramString;
  }
  
  public void zzek(String paramString)
  {
    this.zzaRK = paramString;
  }
  
  public void zzel(String paramString)
  {
    this.zzaRL = paramString;
  }
  
  public void zzem(String paramString)
  {
    this.zzaRM = paramString;
  }
  
  public String zzzU()
  {
    return this.zzaRH;
  }
  
  public String zzzV()
  {
    return this.zzaRI;
  }
  
  public String zzzW()
  {
    return this.zzaRJ;
  }
  
  public String zzzX()
  {
    return this.zzaRK;
  }
  
  public String zzzY()
  {
    return this.zzaRL;
  }
  
  public String zzzZ()
  {
    return this.zzaRM;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/internal/zzqi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */