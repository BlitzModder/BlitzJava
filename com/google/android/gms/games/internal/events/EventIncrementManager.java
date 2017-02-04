package com.google.android.gms.games.internal.events;

import java.util.concurrent.atomic.AtomicReference;

public abstract class EventIncrementManager
{
  private final AtomicReference<EventIncrementCache> zzaFz = new AtomicReference();
  
  public void flush()
  {
    EventIncrementCache localEventIncrementCache = (EventIncrementCache)this.zzaFz.get();
    if (localEventIncrementCache != null) {
      localEventIncrementCache.flush();
    }
  }
  
  public void zzp(String paramString, int paramInt)
  {
    EventIncrementCache localEventIncrementCache2 = (EventIncrementCache)this.zzaFz.get();
    EventIncrementCache localEventIncrementCache1 = localEventIncrementCache2;
    if (localEventIncrementCache2 == null)
    {
      localEventIncrementCache2 = zzwo();
      localEventIncrementCache1 = localEventIncrementCache2;
      if (!this.zzaFz.compareAndSet(null, localEventIncrementCache2)) {
        localEventIncrementCache1 = (EventIncrementCache)this.zzaFz.get();
      }
    }
    localEventIncrementCache1.zzw(paramString, paramInt);
  }
  
  protected abstract EventIncrementCache zzwo();
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/games/internal/events/EventIncrementManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */