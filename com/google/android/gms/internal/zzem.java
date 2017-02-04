package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.zzp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@zzha
public final class zzem
{
  public final String zzAE;
  public final String zzAF;
  public final List<String> zzAG;
  public final String zzAH;
  public final String zzAI;
  public final List<String> zzAJ;
  public final List<String> zzAK;
  public final String zzAL;
  public final List<String> zzAM;
  public final List<String> zzAN;
  
  public zzem(JSONObject paramJSONObject)
    throws JSONException
  {
    this.zzAF = paramJSONObject.getString("id");
    Object localObject1 = paramJSONObject.getJSONArray("adapters");
    ArrayList localArrayList = new ArrayList(((JSONArray)localObject1).length());
    int i = 0;
    while (i < ((JSONArray)localObject1).length())
    {
      localArrayList.add(((JSONArray)localObject1).getString(i));
      i += 1;
    }
    this.zzAG = Collections.unmodifiableList(localArrayList);
    this.zzAH = paramJSONObject.optString("allocation_id", null);
    this.zzAJ = zzp.zzbK().zza(paramJSONObject, "clickurl");
    this.zzAK = zzp.zzbK().zza(paramJSONObject, "imp_urls");
    this.zzAM = zzp.zzbK().zza(paramJSONObject, "video_start_urls");
    this.zzAN = zzp.zzbK().zza(paramJSONObject, "video_complete_urls");
    localObject1 = paramJSONObject.optJSONObject("ad");
    if (localObject1 != null)
    {
      localObject1 = ((JSONObject)localObject1).toString();
      this.zzAE = ((String)localObject1);
      localObject1 = paramJSONObject.optJSONObject("data");
      if (localObject1 == null) {
        break label206;
      }
    }
    label206:
    for (paramJSONObject = ((JSONObject)localObject1).toString();; paramJSONObject = null)
    {
      this.zzAL = paramJSONObject;
      paramJSONObject = (JSONObject)localObject2;
      if (localObject1 != null) {
        paramJSONObject = ((JSONObject)localObject1).optString("class_name");
      }
      this.zzAI = paramJSONObject;
      return;
      localObject1 = null;
      break;
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/internal/zzem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */