package com.google.android.gms.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Base64;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.ads.internal.zzp;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

@zzha
public class zzed
{
  private final Map<zzee, zzef> zzzS = new HashMap();
  private final LinkedList<zzee> zzzT = new LinkedList();
  private zzea zzzU;
  
  private static void zza(String paramString, zzee paramzzee)
  {
    if (zzb.zzQ(2)) {
      zzb.v(String.format(paramString, new Object[] { paramzzee }));
    }
  }
  
  private String[] zzad(String paramString)
  {
    try
    {
      String[] arrayOfString = paramString.split("\000");
      int i = 0;
      for (;;)
      {
        paramString = arrayOfString;
        if (i >= arrayOfString.length) {
          break;
        }
        arrayOfString[i] = new String(Base64.decode(arrayOfString[i], 0), "UTF-8");
        i += 1;
      }
      return paramString;
    }
    catch (UnsupportedEncodingException paramString)
    {
      paramString = new String[0];
    }
  }
  
  private String zzdY()
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      Iterator localIterator = this.zzzT.iterator();
      while (localIterator.hasNext())
      {
        localStringBuilder.append(Base64.encodeToString(((zzee)localIterator.next()).toString().getBytes("UTF-8"), 0));
        if (localIterator.hasNext()) {
          localStringBuilder.append("\000");
        }
      }
      str = localUnsupportedEncodingException.toString();
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      return "";
    }
    String str;
    return str;
  }
  
  void flush()
  {
    while (this.zzzT.size() > 0)
    {
      zzee localzzee = (zzee)this.zzzT.remove();
      zzef localzzef = (zzef)this.zzzS.get(localzzee);
      zza("Flushing interstitial queue for %s.", localzzee);
      while (localzzef.size() > 0) {
        localzzef.zzec().zzzX.zzbo();
      }
      this.zzzS.remove(localzzee);
    }
  }
  
  void restore()
  {
    if (this.zzzU == null) {}
    for (;;)
    {
      return;
      Object localObject2 = this.zzzU.zzdW().getSharedPreferences("com.google.android.gms.ads.internal.interstitial.InterstitialAdPool", 0);
      flush();
      HashMap localHashMap = new HashMap();
      Iterator localIterator = ((SharedPreferences)localObject2).getAll().entrySet().iterator();
      label55:
      Object localObject1;
      if (localIterator.hasNext()) {
        localObject1 = (Map.Entry)localIterator.next();
      }
      try
      {
        if (((String)((Map.Entry)localObject1).getKey()).equals("PoolKeys")) {
          break label55;
        }
        Object localObject3 = new zzeh((String)((Map.Entry)localObject1).getValue());
        localObject1 = new zzee(((zzeh)localObject3).zzqo, ((zzeh)localObject3).zzpH);
        if (this.zzzS.containsKey(localObject1)) {
          break label55;
        }
        localObject3 = new zzef(((zzeh)localObject3).zzqo, ((zzeh)localObject3).zzpH);
        this.zzzS.put(localObject1, localObject3);
        localHashMap.put(((zzee)localObject1).toString(), localObject1);
        zza("Restored interstitial queue for %s.", (zzee)localObject1);
      }
      catch (IOException localIOException)
      {
        zzb.zzd("Malformed preferences value for InterstitialAdPool.", localIOException);
        break label55;
        String[] arrayOfString = zzad(((SharedPreferences)localObject2).getString("PoolKeys", ""));
        int j = arrayOfString.length;
        int i = 0;
        while (i < j)
        {
          localObject2 = (zzee)localHashMap.get(arrayOfString[i]);
          if (this.zzzS.containsKey(localObject2)) {
            this.zzzT.add(localObject2);
          }
          i += 1;
        }
      }
      catch (ClassCastException localClassCastException)
      {
        for (;;) {}
      }
    }
  }
  
  void save()
  {
    if (this.zzzU == null) {
      return;
    }
    SharedPreferences.Editor localEditor = this.zzzU.zzdW().getSharedPreferences("com.google.android.gms.ads.internal.interstitial.InterstitialAdPool", 0).edit();
    localEditor.clear();
    Iterator localIterator = this.zzzS.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Map.Entry)localIterator.next();
      zzee localzzee = (zzee)((Map.Entry)localObject).getKey();
      if (localzzee.zzea())
      {
        localObject = (zzef)((Map.Entry)localObject).getValue();
        localObject = new zzeh(((zzef)localObject).zzeb(), ((zzef)localObject).getAdUnitId()).zzef();
        localEditor.putString(localzzee.toString(), (String)localObject);
        zza("Saved interstitial queue for %s.", localzzee);
      }
    }
    localEditor.putString("PoolKeys", zzdY());
    localEditor.commit();
  }
  
  zzef.zza zza(AdRequestParcel paramAdRequestParcel, String paramString)
  {
    zzee localzzee = new zzee(paramAdRequestParcel, paramString);
    zzef localzzef = (zzef)this.zzzS.get(localzzee);
    if (localzzef == null)
    {
      zza("Interstitial pool created at %s.", localzzee);
      paramAdRequestParcel = new zzef(paramAdRequestParcel, paramString);
      this.zzzS.put(localzzee, paramAdRequestParcel);
    }
    for (;;)
    {
      this.zzzT.remove(localzzee);
      this.zzzT.add(localzzee);
      localzzee.zzdZ();
      while (this.zzzT.size() > ((Integer)zzbz.zzwl.get()).intValue())
      {
        paramString = (zzee)this.zzzT.remove();
        localzzef = (zzef)this.zzzS.get(paramString);
        zza("Evicting interstitial queue for %s.", paramString);
        while (localzzef.size() > 0) {
          localzzef.zzec().zzzX.zzbo();
        }
        this.zzzS.remove(paramString);
      }
      while (paramAdRequestParcel.size() > 0)
      {
        paramString = paramAdRequestParcel.zzec();
        if ((paramString.zzAa) && (zzp.zzbB().currentTimeMillis() - paramString.zzzZ > 1000L * ((Integer)zzbz.zzwn.get()).intValue()))
        {
          zza("Expired interstitial at %s.", localzzee);
        }
        else
        {
          zza("Pooled interstitial returned at %s.", localzzee);
          return paramString;
        }
      }
      return null;
      paramAdRequestParcel = localzzef;
    }
  }
  
  void zza(zzea paramzzea)
  {
    if (this.zzzU == null)
    {
      this.zzzU = paramzzea;
      restore();
    }
  }
  
  void zzdX()
  {
    if (this.zzzU == null) {
      return;
    }
    Iterator localIterator = this.zzzS.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Map.Entry)localIterator.next();
      zzee localzzee = (zzee)((Map.Entry)localObject).getKey();
      localObject = (zzef)((Map.Entry)localObject).getValue();
      while (((zzef)localObject).size() < ((Integer)zzbz.zzwm.get()).intValue())
      {
        zza("Pooling one interstitial for %s.", localzzee);
        ((zzef)localObject).zzb(this.zzzU);
      }
    }
    save();
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/internal/zzed.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */