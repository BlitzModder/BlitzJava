package com.google.android.gms.measurement;

import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zznl;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class zzf<T extends zzf>
{
  private final zzg zzaRu;
  protected final zzc zzaRv;
  private final List<zzd> zzaRw;
  
  protected zzf(zzg paramzzg, zznl paramzznl)
  {
    zzx.zzy(paramzzg);
    this.zzaRu = paramzzg;
    this.zzaRw = new ArrayList();
    paramzzg = new zzc(this, paramzznl);
    paramzzg.zzzO();
    this.zzaRv = paramzzg;
  }
  
  protected void zza(zzc paramzzc) {}
  
  protected void zzd(zzc paramzzc)
  {
    Iterator localIterator = this.zzaRw.iterator();
    while (localIterator.hasNext()) {
      ((zzd)localIterator.next()).zza(this, paramzzc);
    }
  }
  
  public zzc zzig()
  {
    zzc localzzc = this.zzaRv.zzzE();
    zzd(localzzc);
    return localzzc;
  }
  
  protected zzg zzzM()
  {
    return this.zzaRu;
  }
  
  public zzc zzzP()
  {
    return this.zzaRv;
  }
  
  public List<zzi> zzzQ()
  {
    return this.zzaRv.zzzG();
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/measurement/zzf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */