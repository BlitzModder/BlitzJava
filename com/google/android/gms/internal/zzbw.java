package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

@zzha
public class zzbw
{
  private final Collection<zzbv> zzuZ = new ArrayList();
  private final Collection<zzbv<String>> zzva = new ArrayList();
  private final Collection<zzbv<String>> zzvb = new ArrayList();
  
  public void zza(zzbv paramzzbv)
  {
    this.zzuZ.add(paramzzbv);
  }
  
  public void zzb(zzbv<String> paramzzbv)
  {
    this.zzva.add(paramzzbv);
  }
  
  public void zzc(zzbv<String> paramzzbv)
  {
    this.zzvb.add(paramzzbv);
  }
  
  public List<String> zzdl()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.zzva.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)((zzbv)localIterator.next()).get();
      if (str != null) {
        localArrayList.add(str);
      }
    }
    return localArrayList;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/internal/zzbw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */