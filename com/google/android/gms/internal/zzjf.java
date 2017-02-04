package com.google.android.gms.internal;

import android.os.Handler;
import com.google.android.gms.ads.internal.util.client.zza;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@zzha
class zzjf
{
  private final Object zzLS = new Object();
  private final List<Runnable> zzLT = new ArrayList();
  private final List<Runnable> zzLU = new ArrayList();
  private boolean zzLV = false;
  
  private void zzd(Runnable paramRunnable)
  {
    zzio.zza(paramRunnable);
  }
  
  private void zze(Runnable paramRunnable)
  {
    zza.zzLE.post(paramRunnable);
  }
  
  public void zzb(Runnable paramRunnable)
  {
    synchronized (this.zzLS)
    {
      if (this.zzLV)
      {
        zzd(paramRunnable);
        return;
      }
      this.zzLT.add(paramRunnable);
    }
  }
  
  public void zzc(Runnable paramRunnable)
  {
    synchronized (this.zzLS)
    {
      if (this.zzLV)
      {
        zze(paramRunnable);
        return;
      }
      this.zzLU.add(paramRunnable);
    }
  }
  
  public void zzht()
  {
    synchronized (this.zzLS)
    {
      if (this.zzLV) {
        return;
      }
      Iterator localIterator1 = this.zzLT.iterator();
      if (localIterator1.hasNext()) {
        zzd((Runnable)localIterator1.next());
      }
    }
    Iterator localIterator2 = this.zzLU.iterator();
    while (localIterator2.hasNext()) {
      zze((Runnable)localIterator2.next());
    }
    this.zzLT.clear();
    this.zzLU.clear();
    this.zzLV = true;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/internal/zzjf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */