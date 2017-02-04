package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzad;
import com.google.android.gms.internal.zzae;
import com.google.android.gms.internal.zzag.zza;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class zzt
  extends zzak
{
  private static final String ID = zzad.zzbA.toString();
  private static final String zzbcy = zzae.zzdz.toString();
  private static final String zzbdi = zzae.zzfy.toString();
  private final zza zzbdj;
  
  public zzt(zza paramzza)
  {
    super(ID, new String[] { zzbdi });
    this.zzbdj = paramzza;
  }
  
  public boolean zzEa()
  {
    return false;
  }
  
  public zzag.zza zzI(Map<String, zzag.zza> paramMap)
  {
    String str = zzdf.zzg((zzag.zza)paramMap.get(zzbdi));
    HashMap localHashMap = new HashMap();
    paramMap = (zzag.zza)paramMap.get(zzbcy);
    if (paramMap != null)
    {
      paramMap = zzdf.zzl(paramMap);
      if (!(paramMap instanceof Map))
      {
        zzbg.zzaH("FunctionCallMacro: expected ADDITIONAL_PARAMS to be a map.");
        return zzdf.zzFJ();
      }
      paramMap = ((Map)paramMap).entrySet().iterator();
      while (paramMap.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramMap.next();
        localHashMap.put(localEntry.getKey().toString(), localEntry.getValue());
      }
    }
    try
    {
      paramMap = zzdf.zzR(this.zzbdj.zzc(str, localHashMap));
      return paramMap;
    }
    catch (Exception paramMap)
    {
      zzbg.zzaH("Custom macro/tag " + str + " threw exception " + paramMap.getMessage());
    }
    return zzdf.zzFJ();
  }
  
  public static abstract interface zza
  {
    public abstract Object zzc(String paramString, Map<String, Object> paramMap);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/tagmanager/zzt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */