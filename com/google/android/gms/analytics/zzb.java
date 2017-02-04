package com.google.android.gms.analytics;

import android.net.Uri;
import android.net.Uri.Builder;
import android.text.TextUtils;
import com.google.android.gms.analytics.ecommerce.Product;
import com.google.android.gms.analytics.ecommerce.ProductAction;
import com.google.android.gms.analytics.ecommerce.Promotion;
import com.google.android.gms.analytics.internal.zzab;
import com.google.android.gms.analytics.internal.zzaf;
import com.google.android.gms.analytics.internal.zzam;
import com.google.android.gms.analytics.internal.zze;
import com.google.android.gms.analytics.internal.zzf;
import com.google.android.gms.analytics.internal.zzh;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzjz;
import com.google.android.gms.internal.zzka;
import com.google.android.gms.internal.zzkb;
import com.google.android.gms.internal.zzkc;
import com.google.android.gms.internal.zzqh;
import com.google.android.gms.internal.zzqi;
import com.google.android.gms.internal.zzqj;
import com.google.android.gms.internal.zzqk;
import com.google.android.gms.internal.zzql;
import com.google.android.gms.internal.zzqm;
import com.google.android.gms.internal.zzqn;
import com.google.android.gms.internal.zzqo;
import com.google.android.gms.internal.zzqp;
import com.google.android.gms.measurement.zzi;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class zzb
  extends com.google.android.gms.analytics.internal.zzc
  implements zzi
{
  private static DecimalFormat zzNA;
  private final String zzNB;
  private final Uri zzNC;
  private final boolean zzND;
  private final boolean zzNE;
  private final zzf zzNq;
  
  public zzb(zzf paramzzf, String paramString)
  {
    this(paramzzf, paramString, true, false);
  }
  
  public zzb(zzf paramzzf, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    super(paramzzf);
    zzx.zzcG(paramString);
    this.zzNq = paramzzf;
    this.zzNB = paramString;
    this.zzND = paramBoolean1;
    this.zzNE = paramBoolean2;
    this.zzNC = zzaR(this.zzNB);
  }
  
  private static String zzA(Map<String, String> paramMap)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      if (localStringBuilder.length() != 0) {
        localStringBuilder.append(", ");
      }
      localStringBuilder.append((String)localEntry.getKey());
      localStringBuilder.append("=");
      localStringBuilder.append((String)localEntry.getValue());
    }
    return localStringBuilder.toString();
  }
  
  private static void zza(Map<String, String> paramMap, String paramString, double paramDouble)
  {
    if (paramDouble != 0.0D) {
      paramMap.put(paramString, zzb(paramDouble));
    }
  }
  
  private static void zza(Map<String, String> paramMap, String paramString, int paramInt1, int paramInt2)
  {
    if ((paramInt1 > 0) && (paramInt2 > 0)) {
      paramMap.put(paramString, paramInt1 + "x" + paramInt2);
    }
  }
  
  private static void zza(Map<String, String> paramMap, String paramString, boolean paramBoolean)
  {
    if (paramBoolean) {
      paramMap.put(paramString, "1");
    }
  }
  
  static Uri zzaR(String paramString)
  {
    zzx.zzcG(paramString);
    Uri.Builder localBuilder = new Uri.Builder();
    localBuilder.scheme("uri");
    localBuilder.authority("google-analytics.com");
    localBuilder.path(paramString);
    return localBuilder.build();
  }
  
  static String zzb(double paramDouble)
  {
    if (zzNA == null) {
      zzNA = new DecimalFormat("0.######");
    }
    return zzNA.format(paramDouble);
  }
  
  private static void zzb(Map<String, String> paramMap, String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString2)) {
      paramMap.put(paramString1, paramString2);
    }
  }
  
  public static Map<String, String> zzc(com.google.android.gms.measurement.zzc paramzzc)
  {
    HashMap localHashMap = new HashMap();
    Object localObject1 = (zzkb)paramzzc.zzd(zzkb.class);
    Object localObject2;
    Object localObject3;
    if (localObject1 != null)
    {
      localObject1 = ((zzkb)localObject1).zziz().entrySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Map.Entry)((Iterator)localObject1).next();
        localObject3 = zzh(((Map.Entry)localObject2).getValue());
        if (localObject3 != null) {
          localHashMap.put(((Map.Entry)localObject2).getKey(), localObject3);
        }
      }
    }
    localObject1 = (zzkc)paramzzc.zzd(zzkc.class);
    if (localObject1 != null)
    {
      zzb(localHashMap, "t", ((zzkc)localObject1).zziA());
      zzb(localHashMap, "cid", ((zzkc)localObject1).getClientId());
      zzb(localHashMap, "uid", ((zzkc)localObject1).getUserId());
      zzb(localHashMap, "sc", ((zzkc)localObject1).zziD());
      zza(localHashMap, "sf", ((zzkc)localObject1).zziF());
      zza(localHashMap, "ni", ((zzkc)localObject1).zziE());
      zzb(localHashMap, "adid", ((zzkc)localObject1).zziB());
      zza(localHashMap, "ate", ((zzkc)localObject1).zziC());
    }
    localObject1 = (zzqn)paramzzc.zzd(zzqn.class);
    if (localObject1 != null)
    {
      zzb(localHashMap, "cd", ((zzqn)localObject1).zzAm());
      zza(localHashMap, "a", ((zzqn)localObject1).zzAn());
      zzb(localHashMap, "dr", ((zzqn)localObject1).zzAo());
    }
    localObject1 = (zzql)paramzzc.zzd(zzql.class);
    if (localObject1 != null)
    {
      zzb(localHashMap, "ec", ((zzql)localObject1).zzAj());
      zzb(localHashMap, "ea", ((zzql)localObject1).getAction());
      zzb(localHashMap, "el", ((zzql)localObject1).getLabel());
      zza(localHashMap, "ev", ((zzql)localObject1).getValue());
    }
    localObject1 = (zzqi)paramzzc.zzd(zzqi.class);
    if (localObject1 != null)
    {
      zzb(localHashMap, "cn", ((zzqi)localObject1).getName());
      zzb(localHashMap, "cs", ((zzqi)localObject1).getSource());
      zzb(localHashMap, "cm", ((zzqi)localObject1).zzzU());
      zzb(localHashMap, "ck", ((zzqi)localObject1).zzzV());
      zzb(localHashMap, "cc", ((zzqi)localObject1).getContent());
      zzb(localHashMap, "ci", ((zzqi)localObject1).getId());
      zzb(localHashMap, "anid", ((zzqi)localObject1).zzzW());
      zzb(localHashMap, "gclid", ((zzqi)localObject1).zzzX());
      zzb(localHashMap, "dclid", ((zzqi)localObject1).zzzY());
      zzb(localHashMap, "aclid", ((zzqi)localObject1).zzzZ());
    }
    localObject1 = (zzqm)paramzzc.zzd(zzqm.class);
    if (localObject1 != null)
    {
      zzb(localHashMap, "exd", ((zzqm)localObject1).getDescription());
      zza(localHashMap, "exf", ((zzqm)localObject1).zzAk());
    }
    localObject1 = (zzqo)paramzzc.zzd(zzqo.class);
    if (localObject1 != null)
    {
      zzb(localHashMap, "sn", ((zzqo)localObject1).zzAq());
      zzb(localHashMap, "sa", ((zzqo)localObject1).getAction());
      zzb(localHashMap, "st", ((zzqo)localObject1).getTarget());
    }
    localObject1 = (zzqp)paramzzc.zzd(zzqp.class);
    if (localObject1 != null)
    {
      zzb(localHashMap, "utv", ((zzqp)localObject1).zzAr());
      zza(localHashMap, "utt", ((zzqp)localObject1).getTimeInMillis());
      zzb(localHashMap, "utc", ((zzqp)localObject1).zzAj());
      zzb(localHashMap, "utl", ((zzqp)localObject1).getLabel());
    }
    localObject1 = (zzjz)paramzzc.zzd(zzjz.class);
    if (localObject1 != null)
    {
      localObject1 = ((zzjz)localObject1).zzix().entrySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Map.Entry)((Iterator)localObject1).next();
        localObject3 = zzc.zzU(((Integer)((Map.Entry)localObject2).getKey()).intValue());
        if (!TextUtils.isEmpty((CharSequence)localObject3)) {
          localHashMap.put(localObject3, ((Map.Entry)localObject2).getValue());
        }
      }
    }
    localObject1 = (zzka)paramzzc.zzd(zzka.class);
    if (localObject1 != null)
    {
      localObject1 = ((zzka)localObject1).zziy().entrySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Map.Entry)((Iterator)localObject1).next();
        localObject3 = zzc.zzW(((Integer)((Map.Entry)localObject2).getKey()).intValue());
        if (!TextUtils.isEmpty((CharSequence)localObject3)) {
          localHashMap.put(localObject3, zzb(((Double)((Map.Entry)localObject2).getValue()).doubleValue()));
        }
      }
    }
    localObject1 = (zzqk)paramzzc.zzd(zzqk.class);
    if (localObject1 != null)
    {
      localObject2 = ((zzqk)localObject1).zzAf();
      if (localObject2 != null)
      {
        localObject2 = ((ProductAction)localObject2).build().entrySet().iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (Map.Entry)((Iterator)localObject2).next();
          if (((String)((Map.Entry)localObject3).getKey()).startsWith("&")) {
            localHashMap.put(((String)((Map.Entry)localObject3).getKey()).substring(1), ((Map.Entry)localObject3).getValue());
          } else {
            localHashMap.put(((Map.Entry)localObject3).getKey(), ((Map.Entry)localObject3).getValue());
          }
        }
      }
      localObject2 = ((zzqk)localObject1).zzAi().iterator();
      int i = 1;
      while (((Iterator)localObject2).hasNext())
      {
        localHashMap.putAll(((Promotion)((Iterator)localObject2).next()).zzaX(zzc.zzaa(i)));
        i += 1;
      }
      localObject2 = ((zzqk)localObject1).zzAg().iterator();
      i = 1;
      while (((Iterator)localObject2).hasNext())
      {
        localHashMap.putAll(((Product)((Iterator)localObject2).next()).zzaX(zzc.zzY(i)));
        i += 1;
      }
      localObject1 = ((zzqk)localObject1).zzAh().entrySet().iterator();
      i = 1;
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Map.Entry)((Iterator)localObject1).next();
        Object localObject4 = (List)((Map.Entry)localObject2).getValue();
        localObject3 = zzc.zzad(i);
        localObject4 = ((List)localObject4).iterator();
        int j = 1;
        while (((Iterator)localObject4).hasNext())
        {
          localHashMap.putAll(((Product)((Iterator)localObject4).next()).zzaX((String)localObject3 + zzc.zzab(j)));
          j += 1;
        }
        if (!TextUtils.isEmpty((CharSequence)((Map.Entry)localObject2).getKey())) {
          localHashMap.put((String)localObject3 + "nm", ((Map.Entry)localObject2).getKey());
        }
        i += 1;
      }
    }
    localObject1 = (zzqj)paramzzc.zzd(zzqj.class);
    if (localObject1 != null)
    {
      zzb(localHashMap, "ul", ((zzqj)localObject1).getLanguage());
      zza(localHashMap, "sd", ((zzqj)localObject1).zzAa());
      zza(localHashMap, "sr", ((zzqj)localObject1).zzAb(), ((zzqj)localObject1).zzAc());
      zza(localHashMap, "vp", ((zzqj)localObject1).zzAd(), ((zzqj)localObject1).zzAe());
    }
    paramzzc = (zzqh)paramzzc.zzd(zzqh.class);
    if (paramzzc != null)
    {
      zzb(localHashMap, "an", paramzzc.zzkP());
      zzb(localHashMap, "aid", paramzzc.zzwg());
      zzb(localHashMap, "aiid", paramzzc.zzzT());
      zzb(localHashMap, "av", paramzzc.zzkR());
    }
    return localHashMap;
  }
  
  private static String zzh(Object paramObject)
  {
    if (paramObject == null) {
      paramObject = null;
    }
    String str;
    do
    {
      return (String)paramObject;
      if (!(paramObject instanceof String)) {
        break;
      }
      str = (String)paramObject;
      paramObject = str;
    } while (!TextUtils.isEmpty(str));
    return null;
    if ((paramObject instanceof Double))
    {
      paramObject = (Double)paramObject;
      if (((Double)paramObject).doubleValue() != 0.0D) {
        return zzb(((Double)paramObject).doubleValue());
      }
      return null;
    }
    if ((paramObject instanceof Boolean))
    {
      if (paramObject != Boolean.FALSE) {
        return "1";
      }
      return null;
    }
    return String.valueOf(paramObject);
  }
  
  public void zzb(com.google.android.gms.measurement.zzc paramzzc)
  {
    zzx.zzy(paramzzc);
    zzx.zzb(paramzzc.zzzJ(), "Can't deliver not submitted measurement");
    zzx.zzcy("deliver should be called on worker thread");
    Object localObject2 = paramzzc.zzzE();
    Object localObject1 = (zzkc)((com.google.android.gms.measurement.zzc)localObject2).zze(zzkc.class);
    if (TextUtils.isEmpty(((zzkc)localObject1).zziA())) {
      zziU().zzh(zzc((com.google.android.gms.measurement.zzc)localObject2), "Ignoring measurement without type");
    }
    do
    {
      return;
      if (TextUtils.isEmpty(((zzkc)localObject1).getClientId()))
      {
        zziU().zzh(zzc((com.google.android.gms.measurement.zzc)localObject2), "Ignoring measurement without client id");
        return;
      }
    } while (this.zzNq.zzji().getAppOptOut());
    double d = ((zzkc)localObject1).zziF();
    if (zzam.zza(d, ((zzkc)localObject1).getClientId()))
    {
      zzb("Sampling enabled. Hit sampled out. sampling rate", Double.valueOf(d));
      return;
    }
    localObject2 = zzc((com.google.android.gms.measurement.zzc)localObject2);
    ((Map)localObject2).put("v", "1");
    ((Map)localObject2).put("_v", zze.zzOS);
    ((Map)localObject2).put("tid", this.zzNB);
    if (this.zzNq.zzji().isDryRunEnabled())
    {
      zzc("Dry run is enabled. GoogleAnalytics would have sent", zzA((Map)localObject2));
      return;
    }
    HashMap localHashMap = new HashMap();
    zzam.zzc(localHashMap, "uid", ((zzkc)localObject1).getUserId());
    Object localObject3 = (zzqh)paramzzc.zzd(zzqh.class);
    if (localObject3 != null)
    {
      zzam.zzc(localHashMap, "an", ((zzqh)localObject3).zzkP());
      zzam.zzc(localHashMap, "aid", ((zzqh)localObject3).zzwg());
      zzam.zzc(localHashMap, "av", ((zzqh)localObject3).zzkR());
      zzam.zzc(localHashMap, "aiid", ((zzqh)localObject3).zzzT());
    }
    localObject3 = ((zzkc)localObject1).getClientId();
    String str = this.zzNB;
    if (!TextUtils.isEmpty(((zzkc)localObject1).zziB())) {}
    for (boolean bool = true;; bool = false)
    {
      localObject1 = new zzh(0L, (String)localObject3, str, bool, 0L, localHashMap);
      ((Map)localObject2).put("_s", String.valueOf(zzip().zza((zzh)localObject1)));
      paramzzc = new zzab(zziU(), (Map)localObject2, paramzzc.zzzH(), true);
      zzip().zza(paramzzc);
      return;
    }
  }
  
  public Uri zzii()
  {
    return this.zzNC;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/analytics/zzb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */