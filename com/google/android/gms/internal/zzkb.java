package com.google.android.gms.internal;

import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.measurement.zze;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class zzkb
  extends zze<zzkb>
{
  private final Map<String, Object> zzxc = new HashMap();
  
  private String zzaT(String paramString)
  {
    zzx.zzcG(paramString);
    String str = paramString;
    if (paramString != null)
    {
      str = paramString;
      if (paramString.startsWith("&")) {
        str = paramString.substring(1);
      }
    }
    zzx.zzh(str, "Name can not be empty or \"&\"");
    return str;
  }
  
  public void set(String paramString1, String paramString2)
  {
    paramString1 = zzaT(paramString1);
    this.zzxc.put(paramString1, paramString2);
  }
  
  public String toString()
  {
    return zzE(this.zzxc);
  }
  
  public void zza(zzkb paramzzkb)
  {
    zzx.zzy(paramzzkb);
    paramzzkb.zzxc.putAll(this.zzxc);
  }
  
  public Map<String, Object> zziz()
  {
    return Collections.unmodifiableMap(this.zzxc);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/internal/zzkb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */