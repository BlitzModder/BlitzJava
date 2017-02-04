package com.google.android.gms.internal;

import java.util.concurrent.TimeUnit;

@zzha
public class zzjc<T>
  implements zzje<T>
{
  private final T zzLI;
  private final zzjf zzLK;
  
  public zzjc(T paramT)
  {
    this.zzLI = paramT;
    this.zzLK = new zzjf();
    this.zzLK.zzht();
  }
  
  public boolean cancel(boolean paramBoolean)
  {
    return false;
  }
  
  public T get()
  {
    return (T)this.zzLI;
  }
  
  public T get(long paramLong, TimeUnit paramTimeUnit)
  {
    return (T)this.zzLI;
  }
  
  public boolean isCancelled()
  {
    return false;
  }
  
  public boolean isDone()
  {
    return true;
  }
  
  public void zzb(Runnable paramRunnable)
  {
    this.zzLK.zzb(paramRunnable);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/internal/zzjc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */