package com.google.android.gms.internal;

import android.text.TextUtils;
import com.google.android.gms.measurement.zze;
import java.util.HashMap;
import java.util.Map;

public final class zzqp
  extends zze<zzqp>
{
  public String mCategory;
  public String zzaRQ;
  public String zzaSc;
  public long zzaSd;
  
  public String getLabel()
  {
    return this.zzaRQ;
  }
  
  public long getTimeInMillis()
  {
    return this.zzaSd;
  }
  
  public void setTimeInMillis(long paramLong)
  {
    this.zzaSd = paramLong;
  }
  
  public String toString()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("variableName", this.zzaSc);
    localHashMap.put("timeInMillis", Long.valueOf(this.zzaSd));
    localHashMap.put("category", this.mCategory);
    localHashMap.put("label", this.zzaRQ);
    return zzE(localHashMap);
  }
  
  public String zzAj()
  {
    return this.mCategory;
  }
  
  public String zzAr()
  {
    return this.zzaSc;
  }
  
  public void zza(zzqp paramzzqp)
  {
    if (!TextUtils.isEmpty(this.zzaSc)) {
      paramzzqp.zzeu(this.zzaSc);
    }
    if (this.zzaSd != 0L) {
      paramzzqp.setTimeInMillis(this.zzaSd);
    }
    if (!TextUtils.isEmpty(this.mCategory)) {
      paramzzqp.zzen(this.mCategory);
    }
    if (!TextUtils.isEmpty(this.zzaRQ)) {
      paramzzqp.zzep(this.zzaRQ);
    }
  }
  
  public void zzen(String paramString)
  {
    this.mCategory = paramString;
  }
  
  public void zzep(String paramString)
  {
    this.zzaRQ = paramString;
  }
  
  public void zzeu(String paramString)
  {
    this.zzaSc = paramString;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/internal/zzqp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */