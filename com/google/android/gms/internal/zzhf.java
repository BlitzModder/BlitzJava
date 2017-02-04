package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.request.AdRequestInfoParcel;
import com.google.android.gms.ads.internal.request.AdResponseParcel;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzp;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@zzha
public final class zzhf
{
  private int mOrientation = -1;
  private final AdRequestInfoParcel zzBu;
  private List<String> zzFH;
  private String zzIb;
  private String zzIc;
  private List<String> zzId;
  private String zzIe;
  private String zzIf;
  private List<String> zzIg;
  private long zzIh = -1L;
  private boolean zzIi = false;
  private final long zzIj = -1L;
  private long zzIk = -1L;
  private boolean zzIl = false;
  private boolean zzIm = false;
  private boolean zzIn = false;
  private boolean zzIo = true;
  private int zzIp = 0;
  private String zzIq = "";
  private boolean zzIr = false;
  private String zzxA;
  
  public zzhf(AdRequestInfoParcel paramAdRequestInfoParcel)
  {
    this.zzBu = paramAdRequestInfoParcel;
  }
  
  static String zzd(Map<String, List<String>> paramMap, String paramString)
  {
    paramMap = (List)paramMap.get(paramString);
    if ((paramMap != null) && (!paramMap.isEmpty())) {
      return (String)paramMap.get(0);
    }
    return null;
  }
  
  static long zze(Map<String, List<String>> paramMap, String paramString)
  {
    paramMap = (List)paramMap.get(paramString);
    if ((paramMap != null) && (!paramMap.isEmpty()))
    {
      paramMap = (String)paramMap.get(0);
      try
      {
        float f = Float.parseFloat(paramMap);
        return (f * 1000.0F);
      }
      catch (NumberFormatException localNumberFormatException)
      {
        zzb.zzaH("Could not parse float from " + paramString + " header: " + paramMap);
      }
    }
    return -1L;
  }
  
  static List<String> zzf(Map<String, List<String>> paramMap, String paramString)
  {
    paramMap = (List)paramMap.get(paramString);
    if ((paramMap != null) && (!paramMap.isEmpty()))
    {
      paramMap = (String)paramMap.get(0);
      if (paramMap != null) {
        return Arrays.asList(paramMap.trim().split("\\s+"));
      }
    }
    return null;
  }
  
  private boolean zzg(Map<String, List<String>> paramMap, String paramString)
  {
    paramMap = (List)paramMap.get(paramString);
    return (paramMap != null) && (!paramMap.isEmpty()) && (Boolean.valueOf((String)paramMap.get(0)).booleanValue());
  }
  
  private void zzi(Map<String, List<String>> paramMap)
  {
    this.zzIb = zzd(paramMap, "X-Afma-Ad-Size");
  }
  
  private void zzj(Map<String, List<String>> paramMap)
  {
    paramMap = zzf(paramMap, "X-Afma-Click-Tracking-Urls");
    if (paramMap != null) {
      this.zzId = paramMap;
    }
  }
  
  private void zzk(Map<String, List<String>> paramMap)
  {
    paramMap = (List)paramMap.get("X-Afma-Debug-Dialog");
    if ((paramMap != null) && (!paramMap.isEmpty())) {
      this.zzIe = ((String)paramMap.get(0));
    }
  }
  
  private void zzl(Map<String, List<String>> paramMap)
  {
    paramMap = zzf(paramMap, "X-Afma-Tracking-Urls");
    if (paramMap != null) {
      this.zzIg = paramMap;
    }
  }
  
  private void zzm(Map<String, List<String>> paramMap)
  {
    long l = zze(paramMap, "X-Afma-Interstitial-Timeout");
    if (l != -1L) {
      this.zzIh = l;
    }
  }
  
  private void zzn(Map<String, List<String>> paramMap)
  {
    this.zzIf = zzd(paramMap, "X-Afma-ActiveView");
  }
  
  private void zzo(Map<String, List<String>> paramMap)
  {
    this.zzIm = "native".equals(zzd(paramMap, "X-Afma-Ad-Format"));
  }
  
  private void zzp(Map<String, List<String>> paramMap)
  {
    this.zzIl |= zzg(paramMap, "X-Afma-Custom-Rendering-Allowed");
  }
  
  private void zzq(Map<String, List<String>> paramMap)
  {
    this.zzIi |= zzg(paramMap, "X-Afma-Mediation");
  }
  
  private void zzr(Map<String, List<String>> paramMap)
  {
    paramMap = zzf(paramMap, "X-Afma-Manual-Tracking-Urls");
    if (paramMap != null) {
      this.zzFH = paramMap;
    }
  }
  
  private void zzs(Map<String, List<String>> paramMap)
  {
    long l = zze(paramMap, "X-Afma-Refresh-Rate");
    if (l != -1L) {
      this.zzIk = l;
    }
  }
  
  private void zzt(Map<String, List<String>> paramMap)
  {
    paramMap = (List)paramMap.get("X-Afma-Orientation");
    if ((paramMap != null) && (!paramMap.isEmpty()))
    {
      paramMap = (String)paramMap.get(0);
      if (!"portrait".equalsIgnoreCase(paramMap)) {
        break label56;
      }
      this.mOrientation = zzp.zzbz().zzhe();
    }
    label56:
    while (!"landscape".equalsIgnoreCase(paramMap)) {
      return;
    }
    this.mOrientation = zzp.zzbz().zzhd();
  }
  
  private void zzu(Map<String, List<String>> paramMap)
  {
    paramMap = (List)paramMap.get("X-Afma-Use-HTTPS");
    if ((paramMap != null) && (!paramMap.isEmpty())) {
      this.zzIn = Boolean.valueOf((String)paramMap.get(0)).booleanValue();
    }
  }
  
  private void zzv(Map<String, List<String>> paramMap)
  {
    paramMap = (List)paramMap.get("X-Afma-Content-Url-Opted-Out");
    if ((paramMap != null) && (!paramMap.isEmpty())) {
      this.zzIo = Boolean.valueOf((String)paramMap.get(0)).booleanValue();
    }
  }
  
  private void zzw(Map<String, List<String>> paramMap)
  {
    paramMap = zzf(paramMap, "X-Afma-OAuth-Token-Status");
    this.zzIp = 0;
    if (paramMap == null) {}
    String str;
    do
    {
      return;
      while (!paramMap.hasNext()) {
        paramMap = paramMap.iterator();
      }
      str = (String)paramMap.next();
      if ("Clear".equalsIgnoreCase(str))
      {
        this.zzIp = 1;
        return;
      }
    } while (!"No-Op".equalsIgnoreCase(str));
    this.zzIp = 0;
  }
  
  private void zzx(Map<String, List<String>> paramMap)
  {
    paramMap = (List)paramMap.get("X-Afma-Gws-Query-Id");
    if ((paramMap != null) && (!paramMap.isEmpty())) {
      this.zzIq = ((String)paramMap.get(0));
    }
  }
  
  private void zzy(Map<String, List<String>> paramMap)
  {
    paramMap = zzd(paramMap, "X-Afma-Fluid");
    if ((paramMap != null) && (paramMap.equals("height"))) {
      this.zzIr = true;
    }
  }
  
  public void zzb(String paramString1, Map<String, List<String>> paramMap, String paramString2)
  {
    this.zzIc = paramString1;
    this.zzxA = paramString2;
    zzh(paramMap);
  }
  
  public void zzh(Map<String, List<String>> paramMap)
  {
    zzi(paramMap);
    zzj(paramMap);
    zzk(paramMap);
    zzl(paramMap);
    zzm(paramMap);
    zzq(paramMap);
    zzr(paramMap);
    zzs(paramMap);
    zzt(paramMap);
    zzn(paramMap);
    zzu(paramMap);
    zzp(paramMap);
    zzo(paramMap);
    zzv(paramMap);
    zzw(paramMap);
    zzx(paramMap);
    zzy(paramMap);
  }
  
  public AdResponseParcel zzj(long paramLong)
  {
    return new AdResponseParcel(this.zzBu, this.zzIc, this.zzxA, this.zzId, this.zzIg, this.zzIh, this.zzIi, -1L, this.zzFH, this.zzIk, this.mOrientation, this.zzIb, paramLong, this.zzIe, this.zzIf, this.zzIl, this.zzIm, this.zzIn, this.zzIo, false, this.zzIp, this.zzIq, this.zzIr);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/internal/zzhf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */