package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.zzd;
import com.google.android.gms.ads.internal.zzp;
import java.util.Map;

@zzha
public class zzdx
  implements zzdl
{
  public void zza(zzjn paramzzjn, Map<String, String> paramMap)
  {
    zzdv localzzdv = zzp.zzbL();
    if (paramMap.containsKey("abort"))
    {
      if (!localzzdv.zza(paramzzjn)) {
        com.google.android.gms.ads.internal.util.client.zzb.zzaH("Precache abort but no preload task running.");
      }
      return;
    }
    String str = (String)paramMap.get("src");
    if (str == null)
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzaH("Precache video action is missing the src parameter.");
      return;
    }
    try
    {
      i = Integer.parseInt((String)paramMap.get("player"));
      if (paramMap.containsKey("mimetype"))
      {
        paramMap = (String)paramMap.get("mimetype");
        if (!localzzdv.zzb(paramzzjn)) {
          break label121;
        }
        com.google.android.gms.ads.internal.util.client.zzb.zzaH("Precache task already running.");
      }
    }
    catch (NumberFormatException localNumberFormatException)
    {
      int i;
      for (;;)
      {
        i = 0;
        continue;
        paramMap = "";
      }
      label121:
      com.google.android.gms.common.internal.zzb.zzu(paramzzjn.zzhz());
      new zzdu(paramzzjn, paramzzjn.zzhz().zzpm.zza(paramzzjn, i, paramMap), str).zzgX();
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/internal/zzdx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */