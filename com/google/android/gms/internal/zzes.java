package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.zzp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@zzha
public class zzes
{
  public List<String> zza(JSONObject paramJSONObject, String paramString)
    throws JSONException
  {
    paramJSONObject = paramJSONObject.optJSONArray(paramString);
    if (paramJSONObject != null)
    {
      paramString = new ArrayList(paramJSONObject.length());
      int i = 0;
      while (i < paramJSONObject.length())
      {
        paramString.add(paramJSONObject.getString(i));
        i += 1;
      }
      return Collections.unmodifiableList(paramString);
    }
    return null;
  }
  
  public void zza(Context paramContext, String paramString1, zzie paramzzie, String paramString2, boolean paramBoolean, List<String> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      return;
    }
    if (paramBoolean) {}
    for (String str1 = "1";; str1 = "0")
    {
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        String str2 = ((String)localIterator.next()).replaceAll("@gw_adlocid@", paramString2).replaceAll("@gw_adnetrefresh@", str1).replaceAll("@gw_qdata@", paramzzie.zzJF.zzAT).replaceAll("@gw_sdkver@", paramString1).replaceAll("@gw_sessid@", zzp.zzbA().getSessionId()).replaceAll("@gw_seqnum@", paramzzie.zzGt);
        paramList = str2;
        if (paramzzie.zzBp != null) {
          paramList = str2.replaceAll("@gw_adnetid@", paramzzie.zzBp.zzAF).replaceAll("@gw_allocid@", paramzzie.zzBp.zzAH);
        }
        new zziw(paramContext, paramString1, paramList).zzgX();
      }
      break;
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/internal/zzes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */