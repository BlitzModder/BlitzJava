package com.google.android.gms.internal;

import java.util.Iterator;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

@zzha
public class zzjh<T>
  implements zzjg<T>
{
  protected int zzAk = 0;
  protected final BlockingQueue<zzjh<T>.zza> zzLW = new LinkedBlockingQueue();
  protected T zzLX;
  private final Object zzpK = new Object();
  
  public int getStatus()
  {
    return this.zzAk;
  }
  
  public void reject()
  {
    synchronized (this.zzpK)
    {
      if (this.zzAk != 0) {
        throw new UnsupportedOperationException();
      }
    }
    this.zzAk = -1;
    Iterator localIterator = this.zzLW.iterator();
    while (localIterator.hasNext()) {
      ((zza)localIterator.next()).zzLZ.run();
    }
    this.zzLW.clear();
  }
  
  public void zza(zzjg.zzc<T> paramzzc, zzjg.zza paramzza)
  {
    for (;;)
    {
      synchronized (this.zzpK)
      {
        if (this.zzAk == 1)
        {
          paramzzc.zzc(this.zzLX);
          return;
        }
        if (this.zzAk == -1) {
          paramzza.run();
        }
      }
      if (this.zzAk == 0) {
        this.zzLW.add(new zza(paramzzc, paramzza));
      }
    }
  }
  
  public void zzg(T paramT)
  {
    synchronized (this.zzpK)
    {
      if (this.zzAk != 0) {
        throw new UnsupportedOperationException();
      }
    }
    this.zzLX = paramT;
    this.zzAk = 1;
    Iterator localIterator = this.zzLW.iterator();
    while (localIterator.hasNext()) {
      ((zza)localIterator.next()).zzLY.zzc(paramT);
    }
    this.zzLW.clear();
  }
  
  class zza
  {
    public final zzjg.zzc<T> zzLY;
    public final zzjg.zza zzLZ;
    
    public zza(zzjg.zza paramzza)
    {
      this.zzLY = paramzza;
      zzjg.zza localzza;
      this.zzLZ = localzza;
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/internal/zzjh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */