package com.chartboost.sdk.impl;

import android.os.Process;
import java.util.concurrent.BlockingQueue;

public class c
  extends Thread
{
  private static final boolean a = t.b;
  private final BlockingQueue<l<?>> b;
  private final BlockingQueue<l<?>> c;
  private final b d;
  private final o e;
  private volatile boolean f = false;
  
  public c(BlockingQueue<l<?>> paramBlockingQueue1, BlockingQueue<l<?>> paramBlockingQueue2, b paramb, o paramo)
  {
    this.b = paramBlockingQueue1;
    this.c = paramBlockingQueue2;
    this.d = paramb;
    this.e = paramo;
  }
  
  public void a()
  {
    this.f = true;
    interrupt();
  }
  
  public void run()
  {
    if (a) {
      t.a("start new dispatcher", new Object[0]);
    }
    Process.setThreadPriority(10);
    this.d.a();
    for (;;)
    {
      try
      {
        l locall = (l)this.b.take();
        locall.a("cache-queue-take");
        if (!locall.h()) {
          break label73;
        }
        locall.b("cache-discard-canceled");
        continue;
        if (!this.f) {
          continue;
        }
      }
      catch (InterruptedException localInterruptedException) {}
      return;
      label73:
      b.a locala = this.d.a(localInterruptedException.e());
      if (locala == null)
      {
        localInterruptedException.a("cache-miss");
        this.c.put(localInterruptedException);
      }
      else if (locala.a())
      {
        localInterruptedException.a("cache-hit-expired");
        localInterruptedException.a(locala);
        this.c.put(localInterruptedException);
      }
      else
      {
        localInterruptedException.a("cache-hit");
        n localn = localInterruptedException.a(new i(locala.a, locala.g));
        localInterruptedException.a("cache-hit-parsed");
        if (!locala.b())
        {
          this.e.a(localInterruptedException, localn);
        }
        else
        {
          localInterruptedException.a("cache-hit-refresh-needed");
          localInterruptedException.a(locala);
          localn.d = true;
          this.e.a(localInterruptedException, localn, new Runnable()
          {
            public void run()
            {
              try
              {
                c.a(c.this).put(localInterruptedException);
                return;
              }
              catch (InterruptedException localInterruptedException) {}
            }
          });
        }
      }
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/chartboost/sdk/impl/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */