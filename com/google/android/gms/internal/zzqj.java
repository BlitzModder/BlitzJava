package com.google.android.gms.internal;

import android.text.TextUtils;
import com.google.android.gms.measurement.zze;
import java.util.HashMap;
import java.util.Map;

public final class zzqj
  extends zze<zzqj>
{
  public int zzCC;
  public int zzCD;
  private String zzZe;
  public int zzaRN;
  public int zzaRO;
  public int zzaRP;
  
  public String getLanguage()
  {
    return this.zzZe;
  }
  
  public void setLanguage(String paramString)
  {
    this.zzZe = paramString;
  }
  
  public String toString()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("language", this.zzZe);
    localHashMap.put("screenColors", Integer.valueOf(this.zzaRN));
    localHashMap.put("screenWidth", Integer.valueOf(this.zzCC));
    localHashMap.put("screenHeight", Integer.valueOf(this.zzCD));
    localHashMap.put("viewportWidth", Integer.valueOf(this.zzaRO));
    localHashMap.put("viewportHeight", Integer.valueOf(this.zzaRP));
    return zzE(localHashMap);
  }
  
  public int zzAa()
  {
    return this.zzaRN;
  }
  
  public int zzAb()
  {
    return this.zzCC;
  }
  
  public int zzAc()
  {
    return this.zzCD;
  }
  
  public int zzAd()
  {
    return this.zzaRO;
  }
  
  public int zzAe()
  {
    return this.zzaRP;
  }
  
  public void zza(zzqj paramzzqj)
  {
    if (this.zzaRN != 0) {
      paramzzqj.zzio(this.zzaRN);
    }
    if (this.zzCC != 0) {
      paramzzqj.zzip(this.zzCC);
    }
    if (this.zzCD != 0) {
      paramzzqj.zziq(this.zzCD);
    }
    if (this.zzaRO != 0) {
      paramzzqj.zzir(this.zzaRO);
    }
    if (this.zzaRP != 0) {
      paramzzqj.zzis(this.zzaRP);
    }
    if (!TextUtils.isEmpty(this.zzZe)) {
      paramzzqj.setLanguage(this.zzZe);
    }
  }
  
  public void zzio(int paramInt)
  {
    this.zzaRN = paramInt;
  }
  
  public void zzip(int paramInt)
  {
    this.zzCC = paramInt;
  }
  
  public void zziq(int paramInt)
  {
    this.zzCD = paramInt;
  }
  
  public void zzir(int paramInt)
  {
    this.zzaRO = paramInt;
  }
  
  public void zzis(int paramInt)
  {
    this.zzaRP = paramInt;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/internal/zzqj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */