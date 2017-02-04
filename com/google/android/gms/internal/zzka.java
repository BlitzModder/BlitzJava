package com.google.android.gms.internal;

import com.google.android.gms.measurement.zze;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class zzka
  extends zze<zzka>
{
  private Map<Integer, Double> zzOs = new HashMap(4);
  
  public String toString()
  {
    HashMap localHashMap = new HashMap();
    Iterator localIterator = this.zzOs.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      localHashMap.put("metric" + localEntry.getKey(), localEntry.getValue());
    }
    return zzE(localHashMap);
  }
  
  public void zza(zzka paramzzka)
  {
    paramzzka.zzOs.putAll(this.zzOs);
  }
  
  public Map<Integer, Double> zziy()
  {
    return Collections.unmodifiableMap(this.zzOs);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/internal/zzka.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */