package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzad;
import com.google.android.gms.internal.zzae;
import com.google.android.gms.internal.zzag.zza;
import java.util.Map;

class zzn
  extends zzak
{
  private static final String ID = zzad.zzbo.toString();
  private static final String VALUE = zzae.zzhY.toString();
  
  public zzn()
  {
    super(ID, new String[] { VALUE });
  }
  
  public static String zzEd()
  {
    return ID;
  }
  
  public static String zzEe()
  {
    return VALUE;
  }
  
  public boolean zzEa()
  {
    return true;
  }
  
  public zzag.zza zzI(Map<String, zzag.zza> paramMap)
  {
    return (zzag.zza)paramMap.get(VALUE);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/tagmanager/zzn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */