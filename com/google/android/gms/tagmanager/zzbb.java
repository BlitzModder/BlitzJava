package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzad;
import com.google.android.gms.internal.zzag.zza;
import java.util.Locale;
import java.util.Map;

public class zzbb
  extends zzak
{
  private static final String ID = zzad.zzbD.toString();
  
  public zzbb()
  {
    super(ID, new String[0]);
  }
  
  public boolean zzEa()
  {
    return false;
  }
  
  public zzag.zza zzI(Map<String, zzag.zza> paramMap)
  {
    paramMap = Locale.getDefault();
    if (paramMap == null) {
      return zzdf.zzFJ();
    }
    paramMap = paramMap.getLanguage();
    if (paramMap == null) {
      return zzdf.zzFJ();
    }
    return zzdf.zzR(paramMap.toLowerCase());
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/tagmanager/zzbb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */