package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.util.client.zzb;
import java.util.AbstractMap.SimpleEntry;
import java.util.HashSet;
import java.util.Iterator;
import org.json.JSONObject;

@zzha
public class zzbg
  implements zzbf
{
  private final zzbe zzsA;
  private final HashSet<AbstractMap.SimpleEntry<String, zzdl>> zzsB;
  
  public zzbg(zzbe paramzzbe)
  {
    this.zzsA = paramzzbe;
    this.zzsB = new HashSet();
  }
  
  public void zza(String paramString, zzdl paramzzdl)
  {
    this.zzsA.zza(paramString, paramzzdl);
    this.zzsB.add(new AbstractMap.SimpleEntry(paramString, paramzzdl));
  }
  
  public void zza(String paramString1, String paramString2)
  {
    this.zzsA.zza(paramString1, paramString2);
  }
  
  public void zza(String paramString, JSONObject paramJSONObject)
  {
    this.zzsA.zza(paramString, paramJSONObject);
  }
  
  public void zzb(String paramString, zzdl paramzzdl)
  {
    this.zzsA.zzb(paramString, paramzzdl);
    this.zzsB.remove(new AbstractMap.SimpleEntry(paramString, paramzzdl));
  }
  
  public void zzb(String paramString, JSONObject paramJSONObject)
  {
    this.zzsA.zzb(paramString, paramJSONObject);
  }
  
  public void zzcs()
  {
    Iterator localIterator = this.zzsB.iterator();
    while (localIterator.hasNext())
    {
      AbstractMap.SimpleEntry localSimpleEntry = (AbstractMap.SimpleEntry)localIterator.next();
      zzb.v("Unregistering eventhandler: " + ((zzdl)localSimpleEntry.getValue()).toString());
      this.zzsA.zzb((String)localSimpleEntry.getKey(), (zzdl)localSimpleEntry.getValue());
    }
    this.zzsB.clear();
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/internal/zzbg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */