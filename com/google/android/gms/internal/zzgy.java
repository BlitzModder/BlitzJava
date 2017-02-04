package com.google.android.gms.internal;

import android.support.v4.util.SimpleArrayMap;
import com.google.android.gms.ads.internal.formats.zza;
import com.google.android.gms.ads.internal.formats.zzc;
import com.google.android.gms.ads.internal.formats.zzf;
import com.google.android.gms.ads.internal.util.client.zzb;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@zzha
public class zzgy
  implements zzgv.zza<zzf>
{
  private final boolean zzFZ;
  
  public zzgy(boolean paramBoolean)
  {
    this.zzFZ = paramBoolean;
  }
  
  private void zza(zzgv paramzzgv, JSONObject paramJSONObject, SimpleArrayMap<String, Future<zzc>> paramSimpleArrayMap)
    throws JSONException
  {
    paramSimpleArrayMap.put(paramJSONObject.getString("name"), paramzzgv.zza(paramJSONObject, "image_value", this.zzFZ));
  }
  
  private void zza(JSONObject paramJSONObject, SimpleArrayMap<String, String> paramSimpleArrayMap)
    throws JSONException
  {
    paramSimpleArrayMap.put(paramJSONObject.getString("name"), paramJSONObject.getString("string_value"));
  }
  
  private <K, V> SimpleArrayMap<K, V> zzc(SimpleArrayMap<K, Future<V>> paramSimpleArrayMap)
    throws InterruptedException, ExecutionException
  {
    SimpleArrayMap localSimpleArrayMap = new SimpleArrayMap();
    int i = 0;
    while (i < paramSimpleArrayMap.size())
    {
      localSimpleArrayMap.put(paramSimpleArrayMap.keyAt(i), ((Future)paramSimpleArrayMap.valueAt(i)).get());
      i += 1;
    }
    return localSimpleArrayMap;
  }
  
  public zzf zzd(zzgv paramzzgv, JSONObject paramJSONObject)
    throws JSONException, InterruptedException, ExecutionException
  {
    SimpleArrayMap localSimpleArrayMap1 = new SimpleArrayMap();
    SimpleArrayMap localSimpleArrayMap2 = new SimpleArrayMap();
    zzje localzzje = paramzzgv.zze(paramJSONObject);
    JSONArray localJSONArray = paramJSONObject.getJSONArray("custom_assets");
    int i = 0;
    if (i < localJSONArray.length())
    {
      JSONObject localJSONObject = localJSONArray.getJSONObject(i);
      String str = localJSONObject.getString("type");
      if ("string".equals(str)) {
        zza(localJSONObject, localSimpleArrayMap2);
      }
      for (;;)
      {
        i += 1;
        break;
        if ("image".equals(str)) {
          zza(paramzzgv, localJSONObject, localSimpleArrayMap1);
        } else {
          zzb.zzaH("Unknown custom asset type: " + str);
        }
      }
    }
    return new zzf(paramJSONObject.getString("custom_template_id"), zzc(localSimpleArrayMap1), localSimpleArrayMap2, (zza)localzzje.get());
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/internal/zzgy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */