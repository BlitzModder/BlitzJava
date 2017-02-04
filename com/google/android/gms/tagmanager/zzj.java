package com.google.android.gms.tagmanager;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.net.Uri.Builder;
import com.google.android.gms.internal.zzad;
import com.google.android.gms.internal.zzae;
import com.google.android.gms.internal.zzag.zza;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class zzj
  extends zzdd
{
  private static final String ID = zzad.zzcA.toString();
  private static final String URL = zzae.zzhQ.toString();
  static final String zzbcA = "gtm_" + ID + "_unrepeatable";
  private static final Set<String> zzbcB = new HashSet();
  private static final String zzbcy = zzae.zzdz.toString();
  private static final String zzbcz = zzae.zzhP.toString();
  private final Context mContext;
  private final zza zzbcC;
  
  public zzj(Context paramContext)
  {
    this(paramContext, new zza()
    {
      public zzar zzEb()
      {
        return zzz.zzaX(zzj.this);
      }
    });
  }
  
  zzj(Context paramContext, zza paramzza)
  {
    super(ID, new String[] { URL });
    this.zzbcC = paramzza;
    this.mContext = paramContext;
  }
  
  private boolean zzeX(String paramString)
  {
    boolean bool1 = true;
    for (;;)
    {
      try
      {
        boolean bool2 = zzeZ(paramString);
        if (bool2) {
          return bool1;
        }
        if (zzeY(paramString)) {
          zzbcB.add(paramString);
        } else {
          bool1 = false;
        }
      }
      finally {}
    }
  }
  
  public void zzK(Map<String, zzag.zza> paramMap)
  {
    String str;
    if (paramMap.get(zzbcz) != null)
    {
      str = zzdf.zzg((zzag.zza)paramMap.get(zzbcz));
      if ((str == null) || (!zzeX(str))) {
        break label46;
      }
    }
    label46:
    do
    {
      return;
      str = null;
      break;
      Uri.Builder localBuilder = Uri.parse(zzdf.zzg((zzag.zza)paramMap.get(URL))).buildUpon();
      paramMap = (zzag.zza)paramMap.get(zzbcy);
      if (paramMap != null)
      {
        paramMap = zzdf.zzl(paramMap);
        if (!(paramMap instanceof List))
        {
          zzbg.e("ArbitraryPixel: additional params not a list: not sending partial hit: " + localBuilder.build().toString());
          return;
        }
        paramMap = ((List)paramMap).iterator();
        while (paramMap.hasNext())
        {
          Object localObject = paramMap.next();
          if (!(localObject instanceof Map))
          {
            zzbg.e("ArbitraryPixel: additional params contains non-map: not sending partial hit: " + localBuilder.build().toString());
            return;
          }
          localObject = ((Map)localObject).entrySet().iterator();
          while (((Iterator)localObject).hasNext())
          {
            Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
            localBuilder.appendQueryParameter(localEntry.getKey().toString(), localEntry.getValue().toString());
          }
        }
      }
      paramMap = localBuilder.build().toString();
      this.zzbcC.zzEb().zzfo(paramMap);
      zzbg.v("ArbitraryPixel: url = " + paramMap);
    } while (str == null);
    try
    {
      zzbcB.add(str);
      zzcv.zzb(this.mContext, zzbcA, str, "true");
      return;
    }
    finally {}
  }
  
  boolean zzeY(String paramString)
  {
    return this.mContext.getSharedPreferences(zzbcA, 0).contains(paramString);
  }
  
  boolean zzeZ(String paramString)
  {
    return zzbcB.contains(paramString);
  }
  
  public static abstract interface zza
  {
    public abstract zzar zzEb();
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/tagmanager/zzj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */