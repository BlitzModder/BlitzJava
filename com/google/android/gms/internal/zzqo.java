package com.google.android.gms.internal;

import android.text.TextUtils;
import com.google.android.gms.measurement.zze;
import java.util.HashMap;
import java.util.Map;

public final class zzqo
  extends zze<zzqo>
{
  public String zzRA;
  public String zzaSa;
  public String zzaSb;
  
  public String getAction()
  {
    return this.zzRA;
  }
  
  public String getTarget()
  {
    return this.zzaSb;
  }
  
  public String toString()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("network", this.zzaSa);
    localHashMap.put("action", this.zzRA);
    localHashMap.put("target", this.zzaSb);
    return zzE(localHashMap);
  }
  
  public String zzAq()
  {
    return this.zzaSa;
  }
  
  public void zza(zzqo paramzzqo)
  {
    if (!TextUtils.isEmpty(this.zzaSa)) {
      paramzzqo.zzes(this.zzaSa);
    }
    if (!TextUtils.isEmpty(this.zzRA)) {
      paramzzqo.zzeo(this.zzRA);
    }
    if (!TextUtils.isEmpty(this.zzaSb)) {
      paramzzqo.zzet(this.zzaSb);
    }
  }
  
  public void zzeo(String paramString)
  {
    this.zzRA = paramString;
  }
  
  public void zzes(String paramString)
  {
    this.zzaSa = paramString;
  }
  
  public void zzet(String paramString)
  {
    this.zzaSb = paramString;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/internal/zzqo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */