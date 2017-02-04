package com.google.android.gms.internal;

import com.google.android.gms.measurement.zze;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class zzjz
  extends zze<zzjz>
{
  private Map<Integer, String> zzOr = new HashMap(4);
  
  public String toString()
  {
    HashMap localHashMap = new HashMap();
    Iterator localIterator = this.zzOr.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      localHashMap.put("dimension" + localEntry.getKey(), localEntry.getValue());
    }
    return zzE(localHashMap);
  }
  
  public void zza(zzjz paramzzjz)
  {
    paramzzjz.zzOr.putAll(this.zzOr);
  }
  
  public Map<Integer, String> zzix()
  {
    return Collections.unmodifiableMap(this.zzOr);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/internal/zzjz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */