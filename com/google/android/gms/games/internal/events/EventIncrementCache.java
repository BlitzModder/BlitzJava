package com.google.android.gms.games.internal.events;

import android.os.Handler;
import android.os.Looper;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class EventIncrementCache
{
  final Object zzaFt = new Object();
  private Handler zzaFu;
  private boolean zzaFv;
  private HashMap<String, AtomicInteger> zzaFw;
  private int zzaFx;
  
  public EventIncrementCache(Looper paramLooper, int paramInt)
  {
    this.zzaFu = new Handler(paramLooper);
    this.zzaFw = new HashMap();
    this.zzaFx = paramInt;
  }
  
  private void zzwE()
  {
    synchronized (this.zzaFt)
    {
      this.zzaFv = false;
      flush();
      return;
    }
  }
  
  public void flush()
  {
    synchronized (this.zzaFt)
    {
      Iterator localIterator = this.zzaFw.entrySet().iterator();
      if (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        zzs((String)localEntry.getKey(), ((AtomicInteger)localEntry.getValue()).get());
      }
    }
    this.zzaFw.clear();
  }
  
  protected abstract void zzs(String paramString, int paramInt);
  
  public void zzw(String paramString, int paramInt)
  {
    synchronized (this.zzaFt)
    {
      if (!this.zzaFv)
      {
        this.zzaFv = true;
        this.zzaFu.postDelayed(new Runnable()
        {
          public void run()
          {
            EventIncrementCache.zza(EventIncrementCache.this);
          }
        }, this.zzaFx);
      }
      AtomicInteger localAtomicInteger2 = (AtomicInteger)this.zzaFw.get(paramString);
      AtomicInteger localAtomicInteger1 = localAtomicInteger2;
      if (localAtomicInteger2 == null)
      {
        localAtomicInteger1 = new AtomicInteger();
        this.zzaFw.put(paramString, localAtomicInteger1);
      }
      localAtomicInteger1.addAndGet(paramInt);
      return;
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/games/internal/events/EventIncrementCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */