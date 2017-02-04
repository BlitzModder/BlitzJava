package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.zzad;
import com.google.android.gms.internal.zzag.zza;
import java.util.Map;

class zzb
  extends zzak
{
  private static final String ID = zzad.zzbi.toString();
  private final zza zzbcv;
  
  public zzb(Context paramContext)
  {
    this(zza.zzaW(paramContext));
  }
  
  zzb(zza paramzza)
  {
    super(ID, new String[0]);
    this.zzbcv = paramzza;
  }
  
  public boolean zzEa()
  {
    return false;
  }
  
  public zzag.zza zzI(Map<String, zzag.zza> paramMap)
  {
    paramMap = this.zzbcv.zzDU();
    if (paramMap == null) {
      return zzdf.zzFJ();
    }
    return zzdf.zzR(paramMap);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/tagmanager/zzb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */