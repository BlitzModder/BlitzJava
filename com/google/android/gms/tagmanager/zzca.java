package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzae;
import com.google.android.gms.internal.zzag.zza;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

public abstract class zzca
  extends zzak
{
  private static final String zzbdJ = zzae.zzdM.toString();
  private static final String zzbeH = zzae.zzdN.toString();
  
  public zzca(String paramString)
  {
    super(paramString, new String[] { zzbdJ, zzbeH });
  }
  
  public boolean zzEa()
  {
    return true;
  }
  
  public zzag.zza zzI(Map<String, zzag.zza> paramMap)
  {
    Object localObject = paramMap.values().iterator();
    while (((Iterator)localObject).hasNext()) {
      if ((zzag.zza)((Iterator)localObject).next() == zzdf.zzFJ()) {
        return zzdf.zzR(Boolean.valueOf(false));
      }
    }
    localObject = (zzag.zza)paramMap.get(zzbdJ);
    zzag.zza localzza = (zzag.zza)paramMap.get(zzbeH);
    if ((localObject == null) || (localzza == null)) {}
    for (boolean bool = false;; bool = zza((zzag.zza)localObject, localzza, paramMap)) {
      return zzdf.zzR(Boolean.valueOf(bool));
    }
  }
  
  protected abstract boolean zza(zzag.zza paramzza1, zzag.zza paramzza2, Map<String, zzag.zza> paramMap);
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/tagmanager/zzca.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */