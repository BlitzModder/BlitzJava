package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.zzp;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@zzha
public class zzdv
  implements Iterable<zzdu>
{
  private final List<zzdu> zzzm = new LinkedList();
  
  private zzdu zzc(zzjn paramzzjn)
  {
    Iterator localIterator = zzp.zzbL().iterator();
    while (localIterator.hasNext())
    {
      zzdu localzzdu = (zzdu)localIterator.next();
      if (localzzdu.zzps == paramzzjn) {
        return localzzdu;
      }
    }
    return null;
  }
  
  public Iterator<zzdu> iterator()
  {
    return this.zzzm.iterator();
  }
  
  public void zza(zzdu paramzzdu)
  {
    this.zzzm.add(paramzzdu);
  }
  
  public boolean zza(zzjn paramzzjn)
  {
    paramzzjn = zzc(paramzzjn);
    if (paramzzjn != null)
    {
      paramzzjn.zzzj.abort();
      return true;
    }
    return false;
  }
  
  public void zzb(zzdu paramzzdu)
  {
    this.zzzm.remove(paramzzdu);
  }
  
  public boolean zzb(zzjn paramzzjn)
  {
    return zzc(paramzzjn) != null;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/internal/zzdv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */