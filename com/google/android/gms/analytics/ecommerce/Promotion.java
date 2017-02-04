package com.google.android.gms.analytics.ecommerce;

import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.measurement.zze;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Promotion
{
  public static final String ACTION_CLICK = "click";
  public static final String ACTION_VIEW = "view";
  Map<String, String> zzOA = new HashMap();
  
  void put(String paramString1, String paramString2)
  {
    zzx.zzb(paramString1, "Name should be non-null");
    this.zzOA.put(paramString1, paramString2);
  }
  
  public Promotion setCreative(String paramString)
  {
    put("cr", paramString);
    return this;
  }
  
  public Promotion setId(String paramString)
  {
    put("id", paramString);
    return this;
  }
  
  public Promotion setName(String paramString)
  {
    put("nm", paramString);
    return this;
  }
  
  public Promotion setPosition(String paramString)
  {
    put("ps", paramString);
    return this;
  }
  
  public String toString()
  {
    return zze.zzH(this.zzOA);
  }
  
  public Map<String, String> zzaX(String paramString)
  {
    HashMap localHashMap = new HashMap();
    Iterator localIterator = this.zzOA.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      localHashMap.put(paramString + (String)localEntry.getKey(), localEntry.getValue());
    }
    return localHashMap;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/analytics/ecommerce/Promotion.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */