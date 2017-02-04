package com.google.android.gms.internal;

import android.text.TextUtils;
import com.google.android.gms.measurement.zze;
import java.util.HashMap;
import java.util.Map;

public final class zzql
  extends zze<zzql>
{
  private String mCategory;
  private String zzRA;
  private long zzaBq;
  private String zzaRQ;
  
  public String getAction()
  {
    return this.zzRA;
  }
  
  public String getLabel()
  {
    return this.zzaRQ;
  }
  
  public long getValue()
  {
    return this.zzaBq;
  }
  
  public String toString()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("category", this.mCategory);
    localHashMap.put("action", this.zzRA);
    localHashMap.put("label", this.zzaRQ);
    localHashMap.put("value", Long.valueOf(this.zzaBq));
    return zzE(localHashMap);
  }
  
  public String zzAj()
  {
    return this.mCategory;
  }
  
  public void zzN(long paramLong)
  {
    this.zzaBq = paramLong;
  }
  
  public void zza(zzql paramzzql)
  {
    if (!TextUtils.isEmpty(this.mCategory)) {
      paramzzql.zzen(this.mCategory);
    }
    if (!TextUtils.isEmpty(this.zzRA)) {
      paramzzql.zzeo(this.zzRA);
    }
    if (!TextUtils.isEmpty(this.zzaRQ)) {
      paramzzql.zzep(this.zzaRQ);
    }
    if (this.zzaBq != 0L) {
      paramzzql.zzN(this.zzaBq);
    }
  }
  
  public void zzen(String paramString)
  {
    this.mCategory = paramString;
  }
  
  public void zzeo(String paramString)
  {
    this.zzRA = paramString;
  }
  
  public void zzep(String paramString)
  {
    this.zzaRQ = paramString;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/internal/zzql.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */