package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.util.client.zzb;
import java.util.Map;

@zzha
public class zzdo
  implements zzdl
{
  private final zzdp zzyZ;
  
  public zzdo(zzdp paramzzdp)
  {
    this.zzyZ = paramzzdp;
  }
  
  public void zza(zzjn paramzzjn, Map<String, String> paramMap)
  {
    boolean bool1 = "1".equals(paramMap.get("transparentBackground"));
    boolean bool2 = "1".equals(paramMap.get("blur"));
    try
    {
      if (paramMap.get("blurRadius") != null)
      {
        f = Float.parseFloat((String)paramMap.get("blurRadius"));
        this.zzyZ.zzd(bool1);
        this.zzyZ.zza(bool2, f);
        return;
      }
    }
    catch (NumberFormatException paramzzjn)
    {
      for (;;)
      {
        zzb.zzb("Fail to parse float", paramzzjn);
        float f = 0.0F;
      }
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/internal/zzdo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */