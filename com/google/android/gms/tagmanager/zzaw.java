package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.zzad;
import com.google.android.gms.internal.zzae;
import com.google.android.gms.internal.zzag.zza;
import java.util.Map;

class zzaw
  extends zzak
{
  private static final String ID = zzad.zzbT.toString();
  private static final String zzbcw = zzae.zzeo.toString();
  private final Context context;
  
  public zzaw(Context paramContext)
  {
    super(ID, new String[0]);
    this.context = paramContext;
  }
  
  public boolean zzEa()
  {
    return true;
  }
  
  public zzag.zza zzI(Map<String, zzag.zza> paramMap)
  {
    if ((zzag.zza)paramMap.get(zzbcw) != null) {}
    for (paramMap = zzdf.zzg((zzag.zza)paramMap.get(zzbcw));; paramMap = null)
    {
      paramMap = zzax.zzl(this.context, paramMap);
      if (paramMap == null) {
        break;
      }
      return zzdf.zzR(paramMap);
    }
    return zzdf.zzFJ();
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/tagmanager/zzaw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */