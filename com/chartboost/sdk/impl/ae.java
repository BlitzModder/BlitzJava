package com.chartboost.sdk.impl;

import android.os.Handler;
import com.chartboost.sdk.Libraries.CBLogging;
import com.chartboost.sdk.Model.CBError.CBImpressionError;
import com.chartboost.sdk.Model.a.a;
import com.chartboost.sdk.Model.a.b;
import com.chartboost.sdk.c;

public class ae
  extends ad
{
  private static ae d;
  private static String e = "CBRewardedVideo";
  
  public static ae k()
  {
    if (d == null) {
      d = new ae();
    }
    return d;
  }
  
  protected com.chartboost.sdk.Model.a a(String paramString, boolean paramBoolean)
  {
    return new com.chartboost.sdk.Model.a(a.a.c, paramBoolean, paramString, false, g());
  }
  
  protected boolean b(com.chartboost.sdk.Model.a parama, com.chartboost.sdk.Libraries.e.a parama1)
  {
    return true;
  }
  
  public com.chartboost.sdk.e.a c()
  {
    new com.chartboost.sdk.e.a()
    {
      public void a(com.chartboost.sdk.Model.a paramAnonymousa)
      {
        if (c.h() != null) {
          c.h().didClickRewardedVideo(paramAnonymousa.e);
        }
      }
      
      public void a(com.chartboost.sdk.Model.a paramAnonymousa, CBError.CBImpressionError paramAnonymousCBImpressionError)
      {
        if (c.h() != null) {
          c.h().didFailToLoadRewardedVideo(paramAnonymousa.e, paramAnonymousCBImpressionError);
        }
      }
      
      public void b(com.chartboost.sdk.Model.a paramAnonymousa)
      {
        if (c.h() != null) {
          c.h().didCloseRewardedVideo(paramAnonymousa.e);
        }
      }
      
      public void c(com.chartboost.sdk.Model.a paramAnonymousa)
      {
        ae.this.r(paramAnonymousa);
        if (c.h() != null) {
          c.h().didDismissRewardedVideo(paramAnonymousa.e);
        }
      }
      
      public void d(com.chartboost.sdk.Model.a paramAnonymousa)
      {
        if (c.h() != null) {
          c.h().didCacheRewardedVideo(paramAnonymousa.e);
        }
      }
      
      public void e(com.chartboost.sdk.Model.a paramAnonymousa)
      {
        if (c.h() != null) {
          c.h().didDisplayRewardedVideo(paramAnonymousa.e);
        }
      }
      
      public boolean f(com.chartboost.sdk.Model.a paramAnonymousa)
      {
        if (c.h() != null) {
          return c.h().shouldDisplayRewardedVideo(paramAnonymousa.e);
        }
        return true;
      }
      
      public boolean g(com.chartboost.sdk.Model.a paramAnonymousa)
      {
        return true;
      }
      
      public boolean h(com.chartboost.sdk.Model.a paramAnonymousa)
      {
        if (c.h() != null) {
          return c.v();
        }
        return true;
      }
    };
  }
  
  protected ay e(com.chartboost.sdk.Model.a parama)
  {
    if (!c.H().booleanValue())
    {
      parama.a = a.b.a;
      localObject1 = j();
      localObject2 = new ay(c.B());
      ((ay)localObject2).a("local-videos", localObject1);
      ((ay)localObject2).a(l.a.c);
      ((ay)localObject2).a("location", parama.e);
      if (parama.j)
      {
        ((ay)localObject2).a("cache", "1");
        ((ay)localObject2).b(true);
      }
      ((ay)localObject2).a(com.chartboost.sdk.Model.b.b);
      return (ay)localObject2;
    }
    parama.a = a.b.b;
    Object localObject1 = com.chartboost.sdk.b.c();
    Object localObject2 = new bc(c.B());
    ((bc)localObject2).a("cache_assets", localObject1, bc.a.a);
    ((bc)localObject2).a(l.a.c);
    ((bc)localObject2).a(com.chartboost.sdk.Model.b.f);
    ((bc)localObject2).a("location", parama.e, bc.a.a);
    if (parama.j)
    {
      ((bc)localObject2).a("cache", Boolean.valueOf(true), bc.a.a);
      ((bc)localObject2).b(true);
      return (ay)localObject2;
    }
    ((bc)localObject2).a("cache", Boolean.valueOf(false), bc.a.a);
    return (ay)localObject2;
  }
  
  public String f()
  {
    return String.format("%s-%s", new Object[] { "rewarded-video", h() });
  }
  
  protected void h(final com.chartboost.sdk.Model.a parama)
  {
    final com.chartboost.sdk.Libraries.e.a locala = parama.A().a("ux").a("pre-popup");
    if ((locala.c()) && (locala.a("title").d()) && (locala.a("text").d()) && (locala.a("confirm").d()) && (locala.a("cancel").d()) && (e() != null))
    {
      a.post(new Runnable()
      {
        public void run()
        {
          bk.a locala = new bk.a();
          locala.a(locala.e("title")).b(locala.e("text")).d(locala.e("confirm")).c(locala.e("cancel"));
          locala.a(ae.a(ae.this), new bk.b()
          {
            public void a(bk paramAnonymous2bk)
            {
              ae.a(ae.this, ae.1.this.b, CBError.CBImpressionError.USER_CANCELLATION);
            }
            
            public void a(bk paramAnonymous2bk, int paramAnonymous2Int)
            {
              if (paramAnonymous2Int == 1)
              {
                ae.a(ae.this, ae.1.this.b);
                return;
              }
              ae.b(ae.this, ae.1.this.b, CBError.CBImpressionError.USER_CANCELLATION);
            }
          });
        }
      });
      return;
    }
    super.h(parama);
  }
  
  protected void i(com.chartboost.sdk.Model.a parama) {}
  
  public ay l(com.chartboost.sdk.Model.a parama)
  {
    parama = super.l(parama);
    parama.a("/reward/show");
    return parama;
  }
  
  protected void r(com.chartboost.sdk.Model.a parama)
  {
    final com.chartboost.sdk.Libraries.e.a locala = parama.A().a("ux").a("post-popup");
    if ((locala.c()) && (locala.a("title").d()) && (locala.a("text").d()) && (locala.a("confirm").d()) && (e() != null) && (parama.p)) {
      a.post(new Runnable()
      {
        public void run()
        {
          bk.a locala = new bk.a();
          locala.a(locala.e("title")).b(locala.e("text")).c(locala.e("confirm"));
          locala.a(ae.b(ae.this), new bk.b()
          {
            public void a(bk paramAnonymous2bk, int paramAnonymous2Int)
            {
              CBLogging.c(ae.l(), "post-popup dismissed");
            }
          });
        }
      });
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/chartboost/sdk/impl/ae.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */