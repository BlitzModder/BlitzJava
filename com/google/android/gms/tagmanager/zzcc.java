package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzad;
import com.google.android.gms.internal.zzae;
import com.google.android.gms.internal.zzag.zza;
import java.util.Map;

class zzcc
  extends zzak
{
  private static final String ID = zzad.zzbG.toString();
  private static final String zzbeR = zzae.zzgd.toString();
  private static final String zzbeS = zzae.zzgb.toString();
  
  public zzcc()
  {
    super(ID, new String[0]);
  }
  
  public boolean zzEa()
  {
    return false;
  }
  
  public zzag.zza zzI(Map<String, zzag.zza> paramMap)
  {
    Object localObject = (zzag.zza)paramMap.get(zzbeR);
    paramMap = (zzag.zza)paramMap.get(zzbeS);
    double d2;
    double d1;
    if ((localObject != null) && (localObject != zzdf.zzFJ()) && (paramMap != null) && (paramMap != zzdf.zzFJ()))
    {
      localObject = zzdf.zzh((zzag.zza)localObject);
      paramMap = zzdf.zzh(paramMap);
      if ((localObject != zzdf.zzFH()) && (paramMap != zzdf.zzFH()))
      {
        d2 = ((zzde)localObject).doubleValue();
        d1 = paramMap.doubleValue();
        if (d2 > d1) {}
      }
    }
    for (;;)
    {
      return zzdf.zzR(Long.valueOf(Math.round((d1 - d2) * Math.random() + d2)));
      d1 = 2.147483647E9D;
      d2 = 0.0D;
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/tagmanager/zzcc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */