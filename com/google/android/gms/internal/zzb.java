package com.google.android.gms.internal;

import java.util.Collections;
import java.util.Map;

public abstract interface zzb
{
  public abstract zza zza(String paramString);
  
  public abstract void zza();
  
  public abstract void zza(String paramString, zza paramzza);
  
  public static class zza
  {
    public byte[] data;
    public String zzb;
    public long zzc;
    public long zzd;
    public long zze;
    public long zzf;
    public Map<String, String> zzg = Collections.emptyMap();
    
    public boolean zzb()
    {
      return this.zze < System.currentTimeMillis();
    }
    
    public boolean zzc()
    {
      return this.zzf < System.currentTimeMillis();
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/internal/zzb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */