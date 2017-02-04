package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.zzad;
import com.google.android.gms.internal.zzae;
import com.google.android.gms.internal.zzag.zza;
import java.util.Map;

class zze
  extends zzak
{
  private static final String ID = zzad.zzbO.toString();
  private static final String zzbcw = zzae.zzeo.toString();
  private static final String zzbcx = zzae.zzer.toString();
  private final Context context;
  
  public zze(Context paramContext)
  {
    super(ID, new String[] { zzbcx });
    this.context = paramContext;
  }
  
  public boolean zzEa()
  {
    return true;
  }
  
  public zzag.zza zzI(Map<String, zzag.zza> paramMap)
  {
    Object localObject = (zzag.zza)paramMap.get(zzbcx);
    if (localObject == null) {
      return zzdf.zzFJ();
    }
    localObject = zzdf.zzg((zzag.zza)localObject);
    paramMap = (zzag.zza)paramMap.get(zzbcw);
    if (paramMap != null) {}
    for (paramMap = zzdf.zzg(paramMap);; paramMap = null)
    {
      paramMap = zzax.zzf(this.context, (String)localObject, paramMap);
      if (paramMap == null) {
        break;
      }
      return zzdf.zzR(paramMap);
    }
    return zzdf.zzFJ();
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/tagmanager/zze.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */