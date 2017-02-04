package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzad;
import com.google.android.gms.internal.zzae;
import com.google.android.gms.internal.zzag.zza;
import java.util.Map;

class zzdh
  extends zzak
{
  private static final String ID = zzad.zzbZ.toString();
  private static final String zzbdJ = zzae.zzdM.toString();
  
  public zzdh()
  {
    super(ID, new String[] { zzbdJ });
  }
  
  public boolean zzEa()
  {
    return true;
  }
  
  public zzag.zza zzI(Map<String, zzag.zza> paramMap)
  {
    return zzdf.zzR(zzdf.zzg((zzag.zza)paramMap.get(zzbdJ)).toUpperCase());
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/tagmanager/zzdh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */