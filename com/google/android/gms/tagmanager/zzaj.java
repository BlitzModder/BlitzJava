package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzaf.zzc;
import com.google.android.gms.internal.zzaf.zzd;
import com.google.android.gms.internal.zzaf.zzi;
import com.google.android.gms.internal.zzag.zza;
import java.util.Map;

class zzaj
{
  private static void zza(DataLayer paramDataLayer, zzaf.zzd paramzzd)
  {
    paramzzd = paramzzd.zziu;
    int j = paramzzd.length;
    int i = 0;
    while (i < j)
    {
      paramDataLayer.zzfj(zzdf.zzg(paramzzd[i]));
      i += 1;
    }
  }
  
  public static void zza(DataLayer paramDataLayer, zzaf.zzi paramzzi)
  {
    if (paramzzi.zzjj == null)
    {
      zzbg.zzaH("supplemental missing experimentSupplemental");
      return;
    }
    zza(paramDataLayer, paramzzi.zzjj);
    zzb(paramDataLayer, paramzzi.zzjj);
    zzc(paramDataLayer, paramzzi.zzjj);
  }
  
  private static void zzb(DataLayer paramDataLayer, zzaf.zzd paramzzd)
  {
    paramzzd = paramzzd.zzit;
    int j = paramzzd.length;
    int i = 0;
    while (i < j)
    {
      Map localMap = zzc(paramzzd[i]);
      if (localMap != null) {
        paramDataLayer.push(localMap);
      }
      i += 1;
    }
  }
  
  private static Map<String, Object> zzc(zzag.zza paramzza)
  {
    paramzza = zzdf.zzl(paramzza);
    if (!(paramzza instanceof Map))
    {
      zzbg.zzaH("value: " + paramzza + " is not a map value, ignored.");
      return null;
    }
    return (Map)paramzza;
  }
  
  private static void zzc(DataLayer paramDataLayer, zzaf.zzd paramzzd)
  {
    zzaf.zzc[] arrayOfzzc = paramzzd.zziv;
    int j = arrayOfzzc.length;
    int i = 0;
    while (i < j)
    {
      zzaf.zzc localzzc = arrayOfzzc[i];
      if (localzzc.key == null)
      {
        zzbg.zzaH("GaExperimentRandom: No key");
        i += 1;
      }
      else
      {
        Object localObject = paramDataLayer.get(localzzc.key);
        if (!(localObject instanceof Number))
        {
          paramzzd = null;
          label64:
          long l1 = localzzc.zzip;
          long l2 = localzzc.zziq;
          if ((!localzzc.zzir) || (paramzzd == null) || (paramzzd.longValue() < l1) || (paramzzd.longValue() > l2))
          {
            if (l1 > l2) {
              break label237;
            }
            localObject = Long.valueOf(Math.round(Math.random() * (l2 - l1) + l1));
          }
          paramDataLayer.zzfj(localzzc.key);
          paramzzd = paramDataLayer.zzn(localzzc.key, localObject);
          if (localzzc.zzis > 0L)
          {
            if (paramzzd.containsKey("gtm")) {
              break label245;
            }
            paramzzd.put("gtm", DataLayer.mapOf(new Object[] { "lifetime", Long.valueOf(localzzc.zzis) }));
          }
        }
        for (;;)
        {
          paramDataLayer.push(paramzzd);
          break;
          paramzzd = Long.valueOf(((Number)localObject).longValue());
          break label64;
          label237:
          zzbg.zzaH("GaExperimentRandom: random range invalid");
          break;
          label245:
          localObject = paramzzd.get("gtm");
          if ((localObject instanceof Map)) {
            ((Map)localObject).put("lifetime", Long.valueOf(localzzc.zzis));
          } else {
            zzbg.zzaH("GaExperimentRandom: gtm not a map");
          }
        }
      }
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/tagmanager/zzaj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */