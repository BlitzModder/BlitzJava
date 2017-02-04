package com.chartboost.sdk.impl;

import android.os.Handler;
import java.util.concurrent.Executor;

public class e
  implements o
{
  private final Executor a;
  
  public e(final Handler paramHandler)
  {
    this.a = new Executor()
    {
      public void execute(Runnable paramAnonymousRunnable)
      {
        paramHandler.post(paramAnonymousRunnable);
      }
    };
  }
  
  public void a(l<?> paraml, n<?> paramn)
  {
    a(paraml, paramn, null);
  }
  
  public void a(l<?> paraml, n<?> paramn, Runnable paramRunnable)
  {
    paraml.v();
    paraml.a("post-response");
    this.a.execute(new a(paraml, paramn, paramRunnable));
  }
  
  public void a(l<?> paraml, s params)
  {
    paraml.a("post-error");
    params = n.a(params);
    this.a.execute(new a(paraml, params, null));
  }
  
  private class a
    implements Runnable
  {
    private final l b;
    private final n c;
    private final Runnable d;
    
    public a(l paraml, n paramn, Runnable paramRunnable)
    {
      this.b = paraml;
      this.c = paramn;
      this.d = paramRunnable;
    }
    
    public void run()
    {
      if (this.b.h()) {
        this.b.b("canceled-at-delivery");
      }
      label97:
      label107:
      for (;;)
      {
        return;
        if (this.c.a())
        {
          this.b.b(this.c.a);
          if (!this.c.d) {
            break label97;
          }
          this.b.a("intermediate-response");
        }
        for (;;)
        {
          if (this.d == null) {
            break label107;
          }
          this.d.run();
          return;
          this.b.b(this.c.c);
          break;
          this.b.b("done");
        }
      }
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/chartboost/sdk/impl/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */