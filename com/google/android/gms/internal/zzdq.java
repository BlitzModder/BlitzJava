package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.util.client.zzb;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Future;
import org.json.JSONException;
import org.json.JSONObject;

@zzha
public class zzdq
  implements zzdl
{
  final HashMap<String, zzjb<JSONObject>> zzza = new HashMap();
  
  public Future<JSONObject> zzW(String paramString)
  {
    zzjb localzzjb = new zzjb();
    this.zzza.put(paramString, localzzjb);
    return localzzjb;
  }
  
  public void zzX(String paramString)
  {
    zzjb localzzjb = (zzjb)this.zzza.get(paramString);
    if (localzzjb == null)
    {
      zzb.e("Could not find the ad request for the corresponding ad response.");
      return;
    }
    if (!localzzjb.isDone()) {
      localzzjb.cancel(true);
    }
    this.zzza.remove(paramString);
  }
  
  public void zza(zzjn paramzzjn, Map<String, String> paramMap)
  {
    zze((String)paramMap.get("request_id"), (String)paramMap.get("fetched_ad"));
  }
  
  public void zze(String paramString1, String paramString2)
  {
    zzb.zzaF("Received ad from the cache.");
    zzjb localzzjb = (zzjb)this.zzza.get(paramString1);
    if (localzzjb == null)
    {
      zzb.e("Could not find the ad request for the corresponding ad response.");
      return;
    }
    try
    {
      localzzjb.zzf(new JSONObject(paramString2));
      return;
    }
    catch (JSONException paramString2)
    {
      zzb.zzb("Failed constructing JSON object from value passed from javascript", paramString2);
      localzzjb.zzf(null);
      return;
    }
    finally
    {
      this.zzza.remove(paramString1);
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/internal/zzdq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */