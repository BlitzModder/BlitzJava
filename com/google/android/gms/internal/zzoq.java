package com.google.android.gms.internal;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class zzoq
{
  private static final double zzaxl = 1000.0D / TimeUnit.SECONDS.toNanos(1L);
  private static final double zzaxm = 1000.0D / TimeUnit.SECONDS.toNanos(1L);
  private static final zzoq zzaxp = new zzoq();
  private final Map<String, Map<String, zza>> zzaxn;
  private final Map<String, zza> zzaxo;
  
  private zzoq()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put(zzom.zzavw.name, new zza(-90.0D, 90.0D, null));
    localHashMap.put(zzom.zzavx.name, new zza(-180.0D, 180.0D, null));
    localHashMap.put(zzom.zzavy.name, new zza(0.0D, 10000.0D, null));
    localHashMap.put(zzom.zzavv.name, new zza(0.0D, 1000.0D, null));
    localHashMap.put(zzom.zzavz.name, new zza(-100000.0D, 100000.0D, null));
    localHashMap.put(zzom.zzavE.name, new zza(0.0D, 100.0D, null));
    localHashMap.put(zzom.zzavo.name, new zza(0.0D, 100.0D, null));
    localHashMap.put(zzom.zzavr.name, new zza(0.0D, 9.223372036854776E18D, null));
    localHashMap.put(zzom.zzavB.name, new zza(0.0D, 10.0D, null));
    localHashMap.put(zzom.zzavC.name, new zza(0.0D, 1000.0D, null));
    localHashMap.put(zzom.zzavF.name, new zza(0.0D, 200000.0D, null));
    this.zzaxo = Collections.unmodifiableMap(localHashMap);
    localHashMap = new HashMap();
    localHashMap.put("com.google.step_count.delta", zzf(zzom.zzavq.name, new zza(0.0D, zzaxl, null)));
    localHashMap.put("com.google.calories.consumed", zzf(zzom.zzavI.name, new zza(0.0D, zzaxm, null)));
    localHashMap.put("com.google.calories.expended", zzf(zzom.zzavI.name, new zza(0.0D, zzaxm, null)));
    this.zzaxn = Collections.unmodifiableMap(localHashMap);
  }
  
  private static <K, V> Map<K, V> zzf(K paramK, V paramV)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put(paramK, paramV);
    return localHashMap;
  }
  
  public static zzoq zzud()
  {
    return zzaxp;
  }
  
  public zza zzD(String paramString1, String paramString2)
  {
    paramString1 = (Map)this.zzaxn.get(paramString1);
    if (paramString1 != null) {
      return (zza)paramString1.get(paramString2);
    }
    return null;
  }
  
  public zza zzdq(String paramString)
  {
    return (zza)this.zzaxo.get(paramString);
  }
  
  public static class zza
  {
    private final double zzaxq;
    private final double zzaxr;
    
    private zza(double paramDouble1, double paramDouble2)
    {
      this.zzaxq = paramDouble1;
      this.zzaxr = paramDouble2;
    }
    
    public boolean zzh(double paramDouble)
    {
      return (paramDouble >= this.zzaxq) && (paramDouble <= this.zzaxr);
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/internal/zzoq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */