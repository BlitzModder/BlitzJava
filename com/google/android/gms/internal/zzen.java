package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@zzha
public final class zzen
{
  public final List<zzem> zzAO;
  public final long zzAP;
  public final List<String> zzAQ;
  public final List<String> zzAR;
  public final List<String> zzAS;
  public final String zzAT;
  public final long zzAU;
  public final String zzAV;
  public final int zzAW;
  public final int zzAX;
  public final long zzAY;
  public int zzAZ;
  public int zzBa;
  
  public zzen(String paramString)
    throws JSONException
  {
    paramString = new JSONObject(paramString);
    if (zzb.zzQ(2)) {
      zzb.v("Mediation Response JSON: " + paramString.toString(2));
    }
    JSONArray localJSONArray = paramString.getJSONArray("ad_networks");
    ArrayList localArrayList = new ArrayList(localJSONArray.length());
    int i = 0;
    int k;
    for (int j = -1; i < localJSONArray.length(); j = k)
    {
      zzem localzzem = new zzem(localJSONArray.getJSONObject(i));
      localArrayList.add(localzzem);
      k = j;
      if (j < 0)
      {
        k = j;
        if (zza(localzzem)) {
          k = i;
        }
      }
      i += 1;
    }
    this.zzAZ = j;
    this.zzBa = localJSONArray.length();
    this.zzAO = Collections.unmodifiableList(localArrayList);
    this.zzAT = paramString.getString("qdata");
    this.zzAX = paramString.optInt("fs_model_type", -1);
    this.zzAY = paramString.optLong("timeout_ms", -1L);
    paramString = paramString.optJSONObject("settings");
    if (paramString != null)
    {
      this.zzAP = paramString.optLong("ad_network_timeout_millis", -1L);
      this.zzAQ = zzp.zzbK().zza(paramString, "click_urls");
      this.zzAR = zzp.zzbK().zza(paramString, "imp_urls");
      this.zzAS = zzp.zzbK().zza(paramString, "nofill_urls");
      long l = paramString.optLong("refresh", -1L);
      if (l > 0L) {}
      for (l *= 1000L;; l = -1L)
      {
        this.zzAU = l;
        paramString = paramString.optJSONArray("rewards");
        if ((paramString != null) && (paramString.length() != 0)) {
          break;
        }
        this.zzAV = null;
        this.zzAW = 0;
        return;
      }
      this.zzAV = paramString.getJSONObject(0).optString("rb_type");
      this.zzAW = paramString.getJSONObject(0).optInt("rb_amount");
      return;
    }
    this.zzAP = -1L;
    this.zzAQ = null;
    this.zzAR = null;
    this.zzAS = null;
    this.zzAU = -1L;
    this.zzAV = null;
    this.zzAW = 0;
  }
  
  private boolean zza(zzem paramzzem)
  {
    paramzzem = paramzzem.zzAG.iterator();
    while (paramzzem.hasNext()) {
      if (((String)paramzzem.next()).equals("com.google.ads.mediation.admob.AdMobAdapter")) {
        return true;
      }
    }
    return false;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/internal/zzen.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */