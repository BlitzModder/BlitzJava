package com.google.android.gms.internal;

import android.text.TextUtils;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.measurement.zze;
import java.util.HashMap;
import java.util.Map;

public final class zzkc
  extends zze<zzkc>
{
  private String zzJg;
  private String zzOt;
  private String zzOu;
  private String zzOv;
  private boolean zzOw;
  private String zzOx;
  private boolean zzOy;
  private double zzOz;
  
  public String getClientId()
  {
    return this.zzOu;
  }
  
  public String getUserId()
  {
    return this.zzJg;
  }
  
  public void setClientId(String paramString)
  {
    this.zzOu = paramString;
  }
  
  public void setSampleRate(double paramDouble)
  {
    if ((paramDouble >= 0.0D) && (paramDouble <= 100.0D)) {}
    for (boolean bool = true;; bool = false)
    {
      zzx.zzb(bool, "Sample rate must be between 0% and 100%");
      this.zzOz = paramDouble;
      return;
    }
  }
  
  public void setUserId(String paramString)
  {
    this.zzJg = paramString;
  }
  
  public String toString()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("hitType", this.zzOt);
    localHashMap.put("clientId", this.zzOu);
    localHashMap.put("userId", this.zzJg);
    localHashMap.put("androidAdId", this.zzOv);
    localHashMap.put("AdTargetingEnabled", Boolean.valueOf(this.zzOw));
    localHashMap.put("sessionControl", this.zzOx);
    localHashMap.put("nonInteraction", Boolean.valueOf(this.zzOy));
    localHashMap.put("sampleRate", Double.valueOf(this.zzOz));
    return zzE(localHashMap);
  }
  
  public void zzH(boolean paramBoolean)
  {
    this.zzOw = paramBoolean;
  }
  
  public void zzI(boolean paramBoolean)
  {
    this.zzOy = paramBoolean;
  }
  
  public void zza(zzkc paramzzkc)
  {
    if (!TextUtils.isEmpty(this.zzOt)) {
      paramzzkc.zzaU(this.zzOt);
    }
    if (!TextUtils.isEmpty(this.zzOu)) {
      paramzzkc.setClientId(this.zzOu);
    }
    if (!TextUtils.isEmpty(this.zzJg)) {
      paramzzkc.setUserId(this.zzJg);
    }
    if (!TextUtils.isEmpty(this.zzOv)) {
      paramzzkc.zzaV(this.zzOv);
    }
    if (this.zzOw) {
      paramzzkc.zzH(true);
    }
    if (!TextUtils.isEmpty(this.zzOx)) {
      paramzzkc.zzaW(this.zzOx);
    }
    if (this.zzOy) {
      paramzzkc.zzI(this.zzOy);
    }
    if (this.zzOz != 0.0D) {
      paramzzkc.setSampleRate(this.zzOz);
    }
  }
  
  public void zzaU(String paramString)
  {
    this.zzOt = paramString;
  }
  
  public void zzaV(String paramString)
  {
    this.zzOv = paramString;
  }
  
  public void zzaW(String paramString)
  {
    this.zzOx = paramString;
  }
  
  public String zziA()
  {
    return this.zzOt;
  }
  
  public String zziB()
  {
    return this.zzOv;
  }
  
  public boolean zziC()
  {
    return this.zzOw;
  }
  
  public String zziD()
  {
    return this.zzOx;
  }
  
  public boolean zziE()
  {
    return this.zzOy;
  }
  
  public double zziF()
  {
    return this.zzOz;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/internal/zzkc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */