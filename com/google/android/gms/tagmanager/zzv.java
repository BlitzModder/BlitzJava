package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzad;
import com.google.android.gms.internal.zzae;
import com.google.android.gms.internal.zzag.zza;
import java.util.Map;

class zzv
  extends zzak
{
  private static final String ID = zzad.zzbq.toString();
  private static final String NAME = zzae.zzgf.toString();
  private static final String zzbdt = zzae.zzeP.toString();
  private final DataLayer zzbcG;
  
  public zzv(DataLayer paramDataLayer)
  {
    super(ID, new String[] { NAME });
    this.zzbcG = paramDataLayer;
  }
  
  public boolean zzEa()
  {
    return false;
  }
  
  public zzag.zza zzI(Map<String, zzag.zza> paramMap)
  {
    Object localObject = this.zzbcG.get(zzdf.zzg((zzag.zza)paramMap.get(NAME)));
    if (localObject == null)
    {
      paramMap = (zzag.zza)paramMap.get(zzbdt);
      if (paramMap != null) {
        return paramMap;
      }
      return zzdf.zzFJ();
    }
    return zzdf.zzR(localObject);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/tagmanager/zzv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */