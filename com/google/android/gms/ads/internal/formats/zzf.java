package com.google.android.gms.ads.internal.formats;

import android.support.v4.util.SimpleArrayMap;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.internal.zzcn;
import com.google.android.gms.internal.zzcv.zza;
import com.google.android.gms.internal.zzha;
import java.util.Arrays;
import java.util.List;

@zzha
public class zzf
  extends zzcv.zza
  implements zzh.zza
{
  private final Object zzpK = new Object();
  private final zza zzxG;
  private zzh zzxH;
  private final String zzxK;
  private final SimpleArrayMap<String, zzc> zzxL;
  private final SimpleArrayMap<String, String> zzxM;
  
  public zzf(String paramString, SimpleArrayMap<String, zzc> paramSimpleArrayMap, SimpleArrayMap<String, String> paramSimpleArrayMap1, zza paramzza)
  {
    this.zzxK = paramString;
    this.zzxL = paramSimpleArrayMap;
    this.zzxM = paramSimpleArrayMap1;
    this.zzxG = paramzza;
  }
  
  public List<String> getAvailableAssetNames()
  {
    int n = 0;
    String[] arrayOfString = new String[this.zzxL.size() + this.zzxM.size()];
    int j = 0;
    int i = 0;
    int k;
    int m;
    for (;;)
    {
      k = n;
      m = i;
      if (j >= this.zzxL.size()) {
        break;
      }
      arrayOfString[i] = ((String)this.zzxL.keyAt(j));
      i += 1;
      j += 1;
    }
    while (k < this.zzxM.size())
    {
      arrayOfString[m] = ((String)this.zzxM.keyAt(k));
      k += 1;
      m += 1;
    }
    return Arrays.asList(arrayOfString);
  }
  
  public String getCustomTemplateId()
  {
    return this.zzxK;
  }
  
  public void performClick(String paramString)
  {
    synchronized (this.zzpK)
    {
      if (this.zzxH == null)
      {
        zzb.e("Attempt to call performClick before ad initialized.");
        return;
      }
      this.zzxH.zza(paramString, null, null, null);
      return;
    }
  }
  
  public void recordImpression()
  {
    synchronized (this.zzpK)
    {
      if (this.zzxH == null)
      {
        zzb.e("Attempt to perform recordImpression before ad initialized.");
        return;
      }
      this.zzxH.recordImpression();
      return;
    }
  }
  
  public String zzS(String paramString)
  {
    return (String)this.zzxM.get(paramString);
  }
  
  public zzcn zzT(String paramString)
  {
    return (zzcn)this.zzxL.get(paramString);
  }
  
  public void zzb(zzh paramzzh)
  {
    synchronized (this.zzpK)
    {
      this.zzxH = paramzzh;
      return;
    }
  }
  
  public String zzdF()
  {
    return "3";
  }
  
  public zza zzdG()
  {
    return this.zzxG;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/ads/internal/formats/zzf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */