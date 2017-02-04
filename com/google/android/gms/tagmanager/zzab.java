package com.google.android.gms.tagmanager;

import android.os.Build;
import com.google.android.gms.internal.zzad;
import com.google.android.gms.internal.zzag.zza;
import java.util.Map;

class zzab
  extends zzak
{
  private static final String ID = zzad.zzbt.toString();
  
  public zzab()
  {
    super(ID, new String[0]);
  }
  
  public boolean zzEa()
  {
    return true;
  }
  
  public zzag.zza zzI(Map<String, zzag.zza> paramMap)
  {
    String str2 = Build.MANUFACTURER;
    String str1 = Build.MODEL;
    paramMap = str1;
    if (!str1.startsWith(str2))
    {
      paramMap = str1;
      if (!str2.equals("unknown")) {
        paramMap = str2 + " " + str1;
      }
    }
    return zzdf.zzR(paramMap);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/tagmanager/zzab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */