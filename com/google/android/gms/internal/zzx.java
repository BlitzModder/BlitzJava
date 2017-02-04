package com.google.android.gms.internal;

import java.util.Date;
import java.util.Map;
import org.apache.http.impl.cookie.DateParseException;
import org.apache.http.impl.cookie.DateUtils;

public class zzx
{
  public static String zza(Map<String, String> paramMap)
  {
    return zzb(paramMap, "ISO-8859-1");
  }
  
  public static zzb.zza zzb(zzi paramzzi)
  {
    long l9 = System.currentTimeMillis();
    Map localMap = paramzzi.zzA;
    long l3 = 0L;
    long l7 = 0L;
    long l8 = 0L;
    l1 = 0L;
    l2 = 0L;
    int m = 0;
    int k = 0;
    int i = 0;
    Object localObject1 = (String)localMap.get("Date");
    if (localObject1 != null) {
      l3 = zzg((String)localObject1);
    }
    localObject1 = (String)localMap.get("Cache-Control");
    l4 = l2;
    long l6 = l1;
    int j;
    Object localObject2;
    if (localObject1 != null)
    {
      int n = 1;
      localObject1 = ((String)localObject1).split(",");
      j = 0;
      k = i;
      l4 = l2;
      l6 = l1;
      m = n;
      if (j < localObject1.length)
      {
        localObject2 = localObject1[j].trim();
        if ((((String)localObject2).equals("no-cache")) || (((String)localObject2).equals("no-store"))) {
          return null;
        }
        if (!((String)localObject2).startsWith("max-age=")) {}
      }
    }
    for (;;)
    {
      try
      {
        l5 = Long.parseLong(((String)localObject2).substring(8));
        l4 = l2;
      }
      catch (Exception localException2)
      {
        l4 = l2;
        long l5 = l1;
        continue;
        l1 = 0L;
        l2 = 0L;
        continue;
      }
      j += 1;
      l2 = l4;
      l1 = l5;
      break;
      if (((String)localObject2).startsWith("stale-while-revalidate=")) {}
      try
      {
        l4 = Long.parseLong(((String)localObject2).substring(23));
        l5 = l1;
      }
      catch (Exception localException1)
      {
        l4 = l2;
        l5 = l1;
      }
      if (!((String)localObject2).equals("must-revalidate"))
      {
        l4 = l2;
        l5 = l1;
        if (!((String)localObject2).equals("proxy-revalidate")) {}
      }
      else
      {
        i = 1;
        l4 = l2;
        l5 = l1;
        continue;
        localObject1 = (String)localMap.get("Expires");
        l1 = l8;
        if (localObject1 != null) {
          l1 = zzg((String)localObject1);
        }
        localObject1 = (String)localMap.get("Last-Modified");
        l5 = l7;
        if (localObject1 != null) {
          l5 = zzg((String)localObject1);
        }
        localObject1 = (String)localMap.get("ETag");
        if (m != 0)
        {
          l2 = l6 * 1000L + l9;
          if (k != 0)
          {
            l1 = l2;
            localObject2 = new zzb.zza();
            ((zzb.zza)localObject2).data = paramzzi.data;
            ((zzb.zza)localObject2).zzb = ((String)localObject1);
            ((zzb.zza)localObject2).zzf = l2;
            ((zzb.zza)localObject2).zze = l1;
            ((zzb.zza)localObject2).zzc = l3;
            ((zzb.zza)localObject2).zzd = l5;
            ((zzb.zza)localObject2).zzg = localMap;
            return (zzb.zza)localObject2;
          }
          l1 = 1000L * l4 + l2;
          continue;
        }
        if ((l3 <= 0L) || (l1 < l3)) {
          continue;
        }
        l1 = l1 - l3 + l9;
        l2 = l1;
      }
    }
  }
  
  public static String zzb(Map<String, String> paramMap, String paramString)
  {
    Object localObject = (String)paramMap.get("Content-Type");
    paramMap = paramString;
    int i;
    if (localObject != null)
    {
      localObject = ((String)localObject).split(";");
      i = 1;
    }
    for (;;)
    {
      paramMap = paramString;
      if (i < localObject.length)
      {
        paramMap = localObject[i].trim().split("=");
        if ((paramMap.length == 2) && (paramMap[0].equals("charset"))) {
          paramMap = paramMap[1];
        }
      }
      else
      {
        return paramMap;
      }
      i += 1;
    }
  }
  
  public static long zzg(String paramString)
  {
    try
    {
      long l = DateUtils.parseDate(paramString).getTime();
      return l;
    }
    catch (DateParseException paramString) {}
    return 0L;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/internal/zzx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */