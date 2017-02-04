package com.google.android.gms.internal;

import android.support.v4.util.ArrayMap;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public class zzng<E>
  extends AbstractSet<E>
{
  private final ArrayMap<E, E> zzami;
  
  public zzng()
  {
    this.zzami = new ArrayMap();
  }
  
  public zzng(int paramInt)
  {
    this.zzami = new ArrayMap(paramInt);
  }
  
  public zzng(Collection<E> paramCollection)
  {
    this(paramCollection.size());
    addAll(paramCollection);
  }
  
  public boolean add(E paramE)
  {
    if (this.zzami.containsKey(paramE)) {
      return false;
    }
    this.zzami.put(paramE, paramE);
    return true;
  }
  
  public boolean addAll(Collection<? extends E> paramCollection)
  {
    if ((paramCollection instanceof zzng)) {
      return zza((zzng)paramCollection);
    }
    return super.addAll(paramCollection);
  }
  
  public void clear()
  {
    this.zzami.clear();
  }
  
  public boolean contains(Object paramObject)
  {
    return this.zzami.containsKey(paramObject);
  }
  
  public Iterator<E> iterator()
  {
    return this.zzami.keySet().iterator();
  }
  
  public boolean remove(Object paramObject)
  {
    if (!this.zzami.containsKey(paramObject)) {
      return false;
    }
    this.zzami.remove(paramObject);
    return true;
  }
  
  public int size()
  {
    return this.zzami.size();
  }
  
  public boolean zza(zzng<? extends E> paramzzng)
  {
    int i = size();
    this.zzami.putAll(paramzzng.zzami);
    return size() > i;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/internal/zzng.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */