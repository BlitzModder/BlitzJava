package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.zzad;
import com.google.android.gms.internal.zzag.zza;
import java.util.Map;

class zzf
  extends zzak
{
  private static final String ID = zzad.zzbk.toString();
  private final Context mContext;
  
  public zzf(Context paramContext)
  {
    super(ID, new String[0]);
    this.mContext = paramContext;
  }
  
  public boolean zzEa()
  {
    return true;
  }
  
  public zzag.zza zzI(Map<String, zzag.zza> paramMap)
  {
    return zzdf.zzR(this.mContext.getPackageName());
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/tagmanager/zzf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */