package com.google.android.gms.tagmanager;

import android.util.LruCache;

class zzba<K, V>
  implements zzl<K, V>
{
  private LruCache<K, V> zzbej;
  
  zzba(int paramInt, final zzm.zza<K, V> paramzza)
  {
    this.zzbej = new LruCache(paramInt)
    {
      protected int sizeOf(K paramAnonymousK, V paramAnonymousV)
      {
        return paramzza.sizeOf(paramAnonymousK, paramAnonymousV);
      }
    };
  }
  
  public V get(K paramK)
  {
    return (V)this.zzbej.get(paramK);
  }
  
  public void zzh(K paramK, V paramV)
  {
    this.zzbej.put(paramK, paramV);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/tagmanager/zzba.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */