package com.google.android.gms.internal;

import java.util.HashMap;
import java.util.Map;

@zzha
public class zzcg
{
  private final zzch zzoU;
  private final Map<String, zzcf> zzxa;
  
  public zzcg(zzch paramzzch)
  {
    this.zzoU = paramzzch;
    this.zzxa = new HashMap();
  }
  
  public void zza(String paramString, zzcf paramzzcf)
  {
    this.zzxa.put(paramString, paramzzcf);
  }
  
  public void zza(String paramString1, String paramString2, long paramLong)
  {
    zzcd.zza(this.zzoU, (zzcf)this.zzxa.get(paramString2), paramLong, new String[] { paramString1 });
    this.zzxa.put(paramString1, zzcd.zza(this.zzoU, paramLong));
  }
  
  public zzch zzdt()
  {
    return this.zzoU;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/internal/zzcg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */