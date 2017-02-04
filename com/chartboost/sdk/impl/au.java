package com.chartboost.sdk.impl;

import com.chartboost.sdk.Model.CBError.CBImpressionError;
import com.chartboost.sdk.Model.a.a;
import com.chartboost.sdk.Model.b;
import com.chartboost.sdk.c;
import com.chartboost.sdk.e;

public class au
  extends e
{
  private static final String e = au.class.getSimpleName();
  private static au f;
  protected int d;
  private com.chartboost.sdk.Model.a g = null;
  private boolean h;
  private boolean i;
  
  public static au i()
  {
    if (f == null) {}
    try
    {
      if (f == null) {
        f = new au();
      }
      return f;
    }
    finally {}
  }
  
  protected com.chartboost.sdk.Model.a a(String paramString, boolean paramBoolean)
  {
    return new com.chartboost.sdk.Model.a(a.a.b, paramBoolean, paramString, false, g());
  }
  
  public void a()
  {
    this.g = null;
  }
  
  protected void a(com.chartboost.sdk.Model.a parama, com.chartboost.sdk.Libraries.e.a parama1)
  {
    if ((!this.h) && (this.i))
    {
      this.i = false;
      this.d = parama1.a("cells").p();
    }
    super.a(parama, parama1);
  }
  
  public void a(String paramString)
  {
    this.d = 0;
    j();
    super.a(paramString);
  }
  
  protected com.chartboost.sdk.e.a c()
  {
    new com.chartboost.sdk.e.a()
    {
      public void a(com.chartboost.sdk.Model.a paramAnonymousa)
      {
        if (c.h() != null) {
          c.h().didClickMoreApps(paramAnonymousa.e);
        }
      }
      
      public void a(com.chartboost.sdk.Model.a paramAnonymousa, CBError.CBImpressionError paramAnonymousCBImpressionError)
      {
        if (c.h() != null) {
          c.h().didFailToLoadMoreApps(paramAnonymousa.e, paramAnonymousCBImpressionError);
        }
      }
      
      public void b(com.chartboost.sdk.Model.a paramAnonymousa)
      {
        if (c.h() != null) {
          c.h().didCloseMoreApps(paramAnonymousa.e);
        }
      }
      
      public void c(com.chartboost.sdk.Model.a paramAnonymousa)
      {
        if (c.h() != null) {
          c.h().didDismissMoreApps(paramAnonymousa.e);
        }
      }
      
      public void d(com.chartboost.sdk.Model.a paramAnonymousa)
      {
        if (c.h() != null) {
          c.h().didCacheMoreApps(paramAnonymousa.e);
        }
      }
      
      public void e(com.chartboost.sdk.Model.a paramAnonymousa)
      {
        au.this.d = 0;
        au.this.j();
        if (c.h() != null) {
          c.h().didDisplayMoreApps(paramAnonymousa.e);
        }
      }
      
      public boolean f(com.chartboost.sdk.Model.a paramAnonymousa)
      {
        if (c.h() != null) {
          return c.h().shouldDisplayMoreApps(paramAnonymousa.e);
        }
        return true;
      }
      
      public boolean g(com.chartboost.sdk.Model.a paramAnonymousa)
      {
        if (c.h() != null) {
          return c.h().shouldRequestMoreApps(paramAnonymousa.e);
        }
        return true;
      }
      
      public boolean h(com.chartboost.sdk.Model.a paramAnonymousa)
      {
        return true;
      }
    };
  }
  
  protected com.chartboost.sdk.Model.a e(String paramString)
  {
    return this.g;
  }
  
  protected ay e(com.chartboost.sdk.Model.a parama)
  {
    parama = new ay("/more/get");
    parama.a(l.a.c);
    parama.a(b.d);
    return parama;
  }
  
  public String f()
  {
    return "more-apps";
  }
  
  protected void f(String paramString)
  {
    this.g = null;
  }
  
  protected void j() {}
  
  protected ay l(com.chartboost.sdk.Model.a parama)
  {
    ay localay = new ay("/more/show");
    if (parama.e != null) {
      localay.a("location", parama.e);
    }
    if (parama.A().c("cells")) {
      localay.a("cells", parama.A().a("cells"));
    }
    return localay;
  }
  
  protected void p(com.chartboost.sdk.Model.a parama)
  {
    this.g = parama;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/chartboost/sdk/impl/au.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */