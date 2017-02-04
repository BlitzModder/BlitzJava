package com.google.android.gms.measurement;

import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zznl;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class zzc
{
  private final zzf zzaRk;
  private boolean zzaRl;
  private long zzaRm;
  private long zzaRn;
  private long zzaRo;
  private long zzaRp;
  private long zzaRq;
  private boolean zzaRr;
  private final Map<Class<? extends zze>, zze> zzaRs;
  private final List<zzi> zzaRt;
  private final zznl zzqD;
  
  zzc(zzc paramzzc)
  {
    this.zzaRk = paramzzc.zzaRk;
    this.zzqD = paramzzc.zzqD;
    this.zzaRm = paramzzc.zzaRm;
    this.zzaRn = paramzzc.zzaRn;
    this.zzaRo = paramzzc.zzaRo;
    this.zzaRp = paramzzc.zzaRp;
    this.zzaRq = paramzzc.zzaRq;
    this.zzaRt = new ArrayList(paramzzc.zzaRt);
    this.zzaRs = new HashMap(paramzzc.zzaRs.size());
    paramzzc = paramzzc.zzaRs.entrySet().iterator();
    while (paramzzc.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramzzc.next();
      zze localzze = zzf((Class)localEntry.getKey());
      ((zze)localEntry.getValue()).zza(localzze);
      this.zzaRs.put(localEntry.getKey(), localzze);
    }
  }
  
  zzc(zzf paramzzf, zznl paramzznl)
  {
    zzx.zzy(paramzzf);
    zzx.zzy(paramzznl);
    this.zzaRk = paramzzf;
    this.zzqD = paramzznl;
    this.zzaRp = 1800000L;
    this.zzaRq = 3024000000L;
    this.zzaRs = new HashMap();
    this.zzaRt = new ArrayList();
  }
  
  private static <T extends zze> T zzf(Class<T> paramClass)
  {
    try
    {
      paramClass = (zze)paramClass.newInstance();
      return paramClass;
    }
    catch (InstantiationException paramClass)
    {
      throw new IllegalArgumentException("dataType doesn't have default constructor", paramClass);
    }
    catch (IllegalAccessException paramClass)
    {
      throw new IllegalArgumentException("dataType default constructor is not accessible", paramClass);
    }
  }
  
  public void zzM(long paramLong)
  {
    this.zzaRn = paramLong;
  }
  
  public void zzb(zze paramzze)
  {
    zzx.zzy(paramzze);
    Class localClass = paramzze.getClass();
    if (localClass.getSuperclass() != zze.class) {
      throw new IllegalArgumentException();
    }
    paramzze.zza(zze(localClass));
  }
  
  public <T extends zze> T zzd(Class<T> paramClass)
  {
    return (zze)this.zzaRs.get(paramClass);
  }
  
  public <T extends zze> T zze(Class<T> paramClass)
  {
    zze localzze2 = (zze)this.zzaRs.get(paramClass);
    zze localzze1 = localzze2;
    if (localzze2 == null)
    {
      localzze1 = zzf(paramClass);
      this.zzaRs.put(paramClass, localzze1);
    }
    return localzze1;
  }
  
  public zzc zzzE()
  {
    return new zzc(this);
  }
  
  public Collection<zze> zzzF()
  {
    return this.zzaRs.values();
  }
  
  public List<zzi> zzzG()
  {
    return this.zzaRt;
  }
  
  public long zzzH()
  {
    return this.zzaRm;
  }
  
  public void zzzI()
  {
    zzzM().zze(this);
  }
  
  public boolean zzzJ()
  {
    return this.zzaRl;
  }
  
  void zzzK()
  {
    this.zzaRo = this.zzqD.elapsedRealtime();
    if (this.zzaRn != 0L) {}
    for (this.zzaRm = this.zzaRn;; this.zzaRm = this.zzqD.currentTimeMillis())
    {
      this.zzaRl = true;
      return;
    }
  }
  
  zzf zzzL()
  {
    return this.zzaRk;
  }
  
  zzg zzzM()
  {
    return this.zzaRk.zzzM();
  }
  
  boolean zzzN()
  {
    return this.zzaRr;
  }
  
  void zzzO()
  {
    this.zzaRr = true;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/measurement/zzc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */