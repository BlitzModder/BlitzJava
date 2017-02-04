package com.google.android.gms.tagmanager;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class zzcw<K, V>
  implements zzl<K, V>
{
  private final Map<K, V> zzbfW = new HashMap();
  private final int zzbfX;
  private final zzm.zza<K, V> zzbfY;
  private int zzbfZ;
  
  zzcw(int paramInt, zzm.zza<K, V> paramzza)
  {
    this.zzbfX = paramInt;
    this.zzbfY = paramzza;
  }
  
  public V get(K paramK)
  {
    try
    {
      paramK = this.zzbfW.get(paramK);
      return paramK;
    }
    finally
    {
      paramK = finally;
      throw paramK;
    }
  }
  
  public void zzh(K paramK, V paramV)
  {
    if ((paramK == null) || (paramV == null)) {
      try
      {
        throw new NullPointerException("key == null || value == null");
      }
      finally {}
    }
    this.zzbfZ += this.zzbfY.sizeOf(paramK, paramV);
    if (this.zzbfZ > this.zzbfX)
    {
      Iterator localIterator = this.zzbfW.entrySet().iterator();
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        this.zzbfZ -= this.zzbfY.sizeOf(localEntry.getKey(), localEntry.getValue());
        localIterator.remove();
      } while (this.zzbfZ > this.zzbfX);
    }
    this.zzbfW.put(paramK, paramV);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/tagmanager/zzcw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */