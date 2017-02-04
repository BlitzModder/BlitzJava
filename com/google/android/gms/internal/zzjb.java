package com.google.android.gms.internal;

import java.util.concurrent.CancellationException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@zzha
public class zzjb<T>
  implements zzje<T>
{
  private boolean zzBy = false;
  private T zzLI = null;
  private boolean zzLJ = false;
  private final zzjf zzLK = new zzjf();
  private final Object zzpK = new Object();
  
  public boolean cancel(boolean paramBoolean)
  {
    if (!paramBoolean) {
      return false;
    }
    synchronized (this.zzpK)
    {
      if (this.zzLJ) {
        return false;
      }
    }
    this.zzBy = true;
    this.zzLJ = true;
    this.zzpK.notifyAll();
    this.zzLK.zzht();
    return true;
  }
  
  public T get()
  {
    synchronized (this.zzpK)
    {
      boolean bool = this.zzLJ;
      if (bool) {}
    }
    try
    {
      this.zzpK.wait();
      if (this.zzBy)
      {
        throw new CancellationException("CallbackFuture was cancelled.");
        localObject2 = finally;
        throw ((Throwable)localObject2);
      }
      Object localObject3 = this.zzLI;
      return (T)localObject3;
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;) {}
    }
  }
  
  public T get(long paramLong, TimeUnit paramTimeUnit)
    throws TimeoutException
  {
    synchronized (this.zzpK)
    {
      boolean bool = this.zzLJ;
      if (!bool) {}
      try
      {
        paramLong = paramTimeUnit.toMillis(paramLong);
        if (paramLong != 0L) {
          this.zzpK.wait(paramLong);
        }
      }
      catch (InterruptedException paramTimeUnit)
      {
        for (;;) {}
      }
      if (!this.zzLJ) {
        throw new TimeoutException("CallbackFuture timed out.");
      }
    }
    if (this.zzBy) {
      throw new CancellationException("CallbackFuture was cancelled.");
    }
    paramTimeUnit = this.zzLI;
    return paramTimeUnit;
  }
  
  public boolean isCancelled()
  {
    synchronized (this.zzpK)
    {
      boolean bool = this.zzBy;
      return bool;
    }
  }
  
  public boolean isDone()
  {
    synchronized (this.zzpK)
    {
      boolean bool = this.zzLJ;
      return bool;
    }
  }
  
  public void zzb(Runnable paramRunnable)
  {
    this.zzLK.zzb(paramRunnable);
  }
  
  public void zzc(Runnable paramRunnable)
  {
    this.zzLK.zzc(paramRunnable);
  }
  
  public void zzf(T paramT)
  {
    synchronized (this.zzpK)
    {
      if (this.zzBy) {
        return;
      }
      if (this.zzLJ) {
        throw new IllegalStateException("Provided CallbackFuture with multiple values.");
      }
    }
    this.zzLJ = true;
    this.zzLI = paramT;
    this.zzpK.notifyAll();
    this.zzLK.zzht();
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/internal/zzjb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */