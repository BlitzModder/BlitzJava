package com.google.android.gms.tagmanager;

import android.os.Build.VERSION;
import com.google.android.gms.internal.zzad;
import com.google.android.gms.internal.zzag.zza;
import java.util.Map;

class zzcr
  extends zzak
{
  private static final String ID = zzad.zzbK.toString();
  
  public zzcr()
  {
    super(ID, new String[0]);
  }
  
  public boolean zzEa()
  {
    return true;
  }
  
  public zzag.zza zzI(Map<String, zzag.zza> paramMap)
  {
    return zzdf.zzR(Integer.valueOf(Build.VERSION.SDK_INT));
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/tagmanager/zzcr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */