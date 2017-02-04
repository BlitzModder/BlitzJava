package com.chartboost.sdk.impl;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public final class aw
{
  private static ExecutorService a = null;
  private static ThreadFactory b = null;
  
  public static ExecutorService a()
  {
    if (b == null) {
      b = new ThreadFactory()
      {
        private final AtomicInteger a = new AtomicInteger(1);
        
        public Thread newThread(Runnable paramAnonymousRunnable)
        {
          return new Thread(paramAnonymousRunnable, "Chartboost Thread #" + this.a.getAndIncrement());
        }
      };
    }
    if (a == null) {
      a = Executors.newFixedThreadPool(2, b);
    }
    return a;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/chartboost/sdk/impl/aw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */