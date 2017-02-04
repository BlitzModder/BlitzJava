package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzag.zza;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

abstract class zzak
{
  private final Set<String> zzbdN;
  private final String zzbdO;
  
  public zzak(String paramString, String... paramVarArgs)
  {
    this.zzbdO = paramString;
    this.zzbdN = new HashSet(paramVarArgs.length);
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      paramString = paramVarArgs[i];
      this.zzbdN.add(paramString);
      i += 1;
    }
  }
  
  public String zzEF()
  {
    return this.zzbdO;
  }
  
  public Set<String> zzEG()
  {
    return this.zzbdN;
  }
  
  public abstract boolean zzEa();
  
  public abstract zzag.zza zzI(Map<String, zzag.zza> paramMap);
  
  boolean zzf(Set<String> paramSet)
  {
    return paramSet.containsAll(this.zzbdN);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/tagmanager/zzak.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */