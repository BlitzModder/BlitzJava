package com.google.android.gms.internal;

import com.google.android.gms.common.internal.zzx;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class zzod
  implements ThreadFactory
{
  private final int mPriority;
  private final String zzamw;
  private final AtomicInteger zzamx = new AtomicInteger();
  private final ThreadFactory zzamy = Executors.defaultThreadFactory();
  
  public zzod(String paramString)
  {
    this(paramString, 0);
  }
  
  public zzod(String paramString, int paramInt)
  {
    this.zzamw = ((String)zzx.zzb(paramString, "Name must not be null"));
    this.mPriority = paramInt;
  }
  
  public Thread newThread(Runnable paramRunnable)
  {
    paramRunnable = this.zzamy.newThread(new zzoe(paramRunnable, this.mPriority));
    paramRunnable.setName(this.zzamw + "[" + this.zzamx.getAndIncrement() + "]");
    return paramRunnable;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/internal/zzod.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */