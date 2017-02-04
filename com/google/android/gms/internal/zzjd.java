package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.util.client.zzb;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicInteger;

@zzha
public class zzjd
{
  public static <A, B> zzje<B> zza(final zzje<A> paramzzje, final zza<A, B> paramzza)
  {
    zzjb localzzjb = new zzjb();
    paramzzje.zzb(new Runnable()
    {
      public void run()
      {
        try
        {
          this.zzLL.zzf(paramzza.zze(paramzzje.get()));
          return;
        }
        catch (ExecutionException localExecutionException)
        {
          this.zzLL.cancel(true);
          return;
        }
        catch (InterruptedException localInterruptedException)
        {
          for (;;) {}
        }
        catch (CancellationException localCancellationException)
        {
          for (;;) {}
        }
      }
    });
    return localzzjb;
  }
  
  public static <V> zzje<List<V>> zzj(final List<zzje<V>> paramList)
  {
    final zzjb localzzjb = new zzjb();
    final int i = paramList.size();
    AtomicInteger localAtomicInteger = new AtomicInteger(0);
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext()) {
      ((zzje)localIterator.next()).zzb(new Runnable()
      {
        public void run()
        {
          if (this.zzLO.incrementAndGet() >= i) {}
          try
          {
            localzzjb.zzf(zzjd.zzl(paramList));
            return;
          }
          catch (InterruptedException localInterruptedException)
          {
            zzb.zzd("Unable to convert list of futures to a future of list", localInterruptedException);
            return;
          }
          catch (ExecutionException localExecutionException)
          {
            for (;;) {}
          }
        }
      });
    }
    return localzzjb;
  }
  
  private static <V> List<V> zzk(List<zzje<V>> paramList)
    throws ExecutionException, InterruptedException
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = ((zzje)paramList.next()).get();
      if (localObject != null) {
        localArrayList.add(localObject);
      }
    }
    return localArrayList;
  }
  
  public static abstract interface zza<D, R>
  {
    public abstract R zze(D paramD);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/internal/zzjd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */