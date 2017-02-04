package com.google.android.gms.internal;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzp;
import java.util.Map;

@zzha
public final class zzdj
  implements zzdl
{
  private void zzb(zzjn paramzzjn, Map<String, String> paramMap)
  {
    String str2 = (String)paramMap.get("label");
    String str1 = (String)paramMap.get("start_label");
    paramMap = (String)paramMap.get("timestamp");
    if (TextUtils.isEmpty(str2))
    {
      zzb.zzaH("No label given for CSI tick.");
      return;
    }
    if (TextUtils.isEmpty(paramMap))
    {
      zzb.zzaH("No timestamp given for CSI tick.");
      return;
    }
    try
    {
      long l = zzc(Long.parseLong(paramMap));
      paramMap = str1;
      if (TextUtils.isEmpty(str1)) {
        paramMap = "native:view_load";
      }
      paramzzjn.zzhL().zza(str2, paramMap, l);
      return;
    }
    catch (NumberFormatException paramzzjn)
    {
      zzb.zzd("Malformed timestamp for CSI tick.", paramzzjn);
    }
  }
  
  private long zzc(long paramLong)
  {
    return paramLong - zzp.zzbB().currentTimeMillis() + zzp.zzbB().elapsedRealtime();
  }
  
  private void zzc(zzjn paramzzjn, Map<String, String> paramMap)
  {
    paramMap = (String)paramMap.get("value");
    if (TextUtils.isEmpty(paramMap))
    {
      zzb.zzaH("No value given for CSI experiment.");
      return;
    }
    paramzzjn = paramzzjn.zzhL().zzdt();
    if (paramzzjn == null)
    {
      zzb.zzaH("No ticker for WebView, dropping experiment ID.");
      return;
    }
    paramzzjn.zzd("e", paramMap);
  }
  
  private void zzd(zzjn paramzzjn, Map<String, String> paramMap)
  {
    String str = (String)paramMap.get("name");
    paramMap = (String)paramMap.get("value");
    if (TextUtils.isEmpty(paramMap))
    {
      zzb.zzaH("No value given for CSI extra.");
      return;
    }
    if (TextUtils.isEmpty(str))
    {
      zzb.zzaH("No name given for CSI extra.");
      return;
    }
    paramzzjn = paramzzjn.zzhL().zzdt();
    if (paramzzjn == null)
    {
      zzb.zzaH("No ticker for WebView, dropping extra parameter.");
      return;
    }
    paramzzjn.zzd(str, paramMap);
  }
  
  public void zza(zzjn paramzzjn, Map<String, String> paramMap)
  {
    String str = (String)paramMap.get("action");
    if ("tick".equals(str)) {
      zzb(paramzzjn, paramMap);
    }
    do
    {
      return;
      if ("experiment".equals(str))
      {
        zzc(paramzzjn, paramMap);
        return;
      }
    } while (!"extra".equals(str));
    zzd(paramzzjn, paramMap);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/internal/zzdj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */