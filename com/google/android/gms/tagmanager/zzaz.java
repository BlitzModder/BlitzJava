package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzae;
import com.google.android.gms.internal.zzag.zza;
import com.google.android.gms.internal.zzsh.zza;
import com.google.android.gms.internal.zzsh.zzb;
import com.google.android.gms.internal.zzsh.zzc;
import com.google.android.gms.internal.zzsh.zzd;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class zzaz
{
  private static zzag.zza zzK(Object paramObject)
    throws JSONException
  {
    return zzdf.zzR(zzL(paramObject));
  }
  
  static Object zzL(Object paramObject)
    throws JSONException
  {
    if ((paramObject instanceof JSONArray)) {
      throw new RuntimeException("JSONArrays are not supported");
    }
    if (JSONObject.NULL.equals(paramObject)) {
      throw new RuntimeException("JSON nulls are not supported");
    }
    Object localObject = paramObject;
    if ((paramObject instanceof JSONObject))
    {
      paramObject = (JSONObject)paramObject;
      localObject = new HashMap();
      Iterator localIterator = ((JSONObject)paramObject).keys();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        ((Map)localObject).put(str, zzL(((JSONObject)paramObject).get(str)));
      }
    }
    return localObject;
  }
  
  public static zzsh.zzc zzfu(String paramString)
    throws JSONException
  {
    paramString = zzK(new JSONObject(paramString));
    zzsh.zzd localzzd = zzsh.zzc.zzFO();
    int i = 0;
    while (i < paramString.zzjq.length)
    {
      localzzd.zzc(zzsh.zza.zzFL().zzb(zzae.zzfI.toString(), paramString.zzjq[i]).zzb(zzae.zzfx.toString(), zzdf.zzfF(zzn.zzEd())).zzb(zzn.zzEe(), paramString.zzjr[i]).zzFN());
      i += 1;
    }
    return localzzd.zzFR();
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/tagmanager/zzaz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */