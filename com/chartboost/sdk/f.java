package com.chartboost.sdk;

import android.app.Activity;
import android.os.Build.VERSION;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout.LayoutParams;
import com.chartboost.sdk.Libraries.CBLogging;
import com.chartboost.sdk.Libraries.CBUtility;
import com.chartboost.sdk.Model.CBError.CBImpressionError;
import com.chartboost.sdk.Model.a.a;
import com.chartboost.sdk.Model.a.b;
import com.chartboost.sdk.Model.a.c;
import com.chartboost.sdk.Model.a.e;
import com.chartboost.sdk.impl.bg;
import com.chartboost.sdk.impl.bg.a;
import com.chartboost.sdk.impl.bg.b;
import com.chartboost.sdk.impl.bh;
import com.chartboost.sdk.impl.bo;

public final class f
{
  private static f c;
  private bo a = null;
  private com.chartboost.sdk.Model.a b;
  private int d = -1;
  
  public static f a()
  {
    if (c == null) {
      c = new f();
    }
    return c;
  }
  
  private void e(com.chartboost.sdk.Model.a parama)
  {
    if ((this.a != null) && (this.a.h() != parama))
    {
      CBLogging.b("CBViewController", "Impression already visible");
      parama.a(CBError.CBImpressionError.IMPRESSION_ALREADY_VISIBLE);
    }
    label103:
    label108:
    do
    {
      int i;
      do
      {
        return;
        Activity localActivity;
        if (parama.c != a.e.c)
        {
          i = 1;
          parama.c = a.e.c;
          localActivity = Chartboost.f();
          if (localActivity != null) {
            break label103;
          }
        }
        for (localObject1 = CBError.CBImpressionError.NO_HOST_ACTIVITY;; localObject1 = null)
        {
          localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = parama.l();
          }
          if (localObject2 == null) {
            break label108;
          }
          CBLogging.b("CBViewController", "Unable to create the view while trying th display the impression");
          parama.a((CBError.CBImpressionError)localObject2);
          return;
          i = 0;
          break;
        }
        if (this.a == null)
        {
          this.a = new bo(localActivity, parama);
          localActivity.addContentView(this.a, new FrameLayout.LayoutParams(-1, -1));
        }
        CBUtility.a(localActivity, parama.a);
        if ((Build.VERSION.SDK_INT >= 11) && (this.d == -1) && ((parama.f == a.c.b) || (parama.f == a.c.c)))
        {
          this.d = localActivity.getWindow().getDecorView().getSystemUiVisibility();
          CBUtility.a(localActivity);
        }
        this.a.a();
        CBLogging.e("CBViewController", "Displaying the impression");
        parama.l = this.a;
      } while (i == 0);
      if (parama.a == a.b.a) {
        this.a.e().a();
      }
      Object localObject1 = bg.b.a;
      if (parama.a == a.b.b) {
        localObject1 = bg.b.f;
      }
      if (parama.d == a.a.b) {
        localObject1 = bg.b.c;
      }
      Object localObject2 = bg.b.a(parama.A().f("animation"));
      if (localObject2 != null) {
        localObject1 = localObject2;
      }
      if (c.j()) {
        localObject1 = bg.b.g;
      }
      parama.r();
      bg.a((bg.b)localObject1, parama, new bg.a()
      {
        public void a(com.chartboost.sdk.Model.a paramAnonymousa)
        {
          paramAnonymousa.s();
        }
      });
      b.h();
      h.f();
      if ((c.h() != null) && ((parama.f == a.c.b) || (parama.f == a.c.c))) {
        c.h().willDisplayVideo(parama.e);
      }
    } while (parama.u().b() == null);
    parama.u().b().e(parama);
  }
  
  private void f(com.chartboost.sdk.Model.a parama)
  {
    Activity localActivity = Chartboost.f();
    if (localActivity == null)
    {
      CBLogging.d(this, "No host activity to display loading view");
      return;
    }
    if (this.a == null)
    {
      this.a = new bo(localActivity, parama);
      localActivity.addContentView(this.a, new FrameLayout.LayoutParams(-1, -1));
    }
    this.a.b();
    this.b = parama;
  }
  
  public void a(com.chartboost.sdk.Model.a parama)
  {
    switch (3.a[parama.c.ordinal()])
    {
    default: 
      e(parama);
    }
    do
    {
      return;
    } while ((!parama.m) || (!c.w()));
    f(parama);
  }
  
  public void a(com.chartboost.sdk.Model.a parama, boolean paramBoolean)
  {
    if ((parama == null) || ((parama != this.b) && (parama != d.a().c()))) {}
    do
    {
      do
      {
        return;
        this.b = null;
        CBLogging.e("CBViewController", "Dismissing loading view");
      } while (!c());
      this.a.c();
    } while ((!paramBoolean) || (this.a == null) || (this.a.h() == null));
    d(this.a.h());
  }
  
  public void b()
  {
    CBLogging.e("CBViewController", "Attempting to close impression activity");
    Activity localActivity = Chartboost.f();
    if ((localActivity != null) && ((localActivity instanceof CBImpressionActivity)))
    {
      CBLogging.e("CBViewController", "Closing impression activity");
      Chartboost.g();
      localActivity.finish();
    }
  }
  
  public void b(final com.chartboost.sdk.Model.a parama)
  {
    CBLogging.e("CBViewController", "Dismissing impression");
    Runnable local2 = new Runnable()
    {
      public void run()
      {
        parama.c = a.e.e;
        Object localObject = bg.b.a;
        if (parama.a == a.b.b) {
          localObject = bg.b.f;
        }
        if (parama.d == a.a.b) {
          localObject = bg.b.c;
        }
        bg.b localb = bg.b.a(parama.A().f("animation"));
        if (localb != null) {
          localObject = localb;
        }
        if (c.j()) {
          localObject = bg.b.g;
        }
        bg.b((bg.b)localObject, parama, new bg.a()
        {
          public void a(final com.chartboost.sdk.Model.a paramAnonymous2a)
          {
            CBUtility.e().post(new Runnable()
            {
              public void run()
              {
                f.this.d(paramAnonymous2a);
              }
            });
            paramAnonymous2a.o();
            CBUtility.b(f.2.this.b, paramAnonymous2a.a);
            if ((Build.VERSION.SDK_INT >= 11) && (f.a(f.this) != -1) && ((paramAnonymous2a.f == a.c.b) || (paramAnonymous2a.f == a.c.c)))
            {
              f.2.this.b.getWindow().getDecorView().setSystemUiVisibility(f.a(f.this));
              f.a(f.this, -1);
            }
          }
        });
      }
    };
    if (parama.o)
    {
      parama.a(local2);
      return;
    }
    local2.run();
  }
  
  public void c(com.chartboost.sdk.Model.a parama)
  {
    CBLogging.e("CBViewController", "Removing impression silently");
    if (c()) {
      a(parama, false);
    }
    parama.k();
    try
    {
      ((ViewGroup)this.a.getParent()).removeView(this.a);
      this.a = null;
      return;
    }
    catch (Exception parama)
    {
      for (;;)
      {
        CBLogging.b("CBViewController", "Exception removing impression silently", parama);
      }
    }
  }
  
  public boolean c()
  {
    return (this.a != null) && (this.a.g());
  }
  
  public void d(com.chartboost.sdk.Model.a parama)
  {
    CBLogging.e("CBViewController", "Removing impression");
    parama.c = a.e.f;
    if (this.a == null) {
      if (c.i()) {
        b();
      }
    }
    for (;;)
    {
      return;
      try
      {
        ((ViewGroup)this.a.getParent()).removeView(this.a);
        parama.j();
        this.a = null;
        b.i();
        h.g();
        if (c.i()) {
          b();
        }
        parama.u().b().c(parama);
        if (!parama.C()) {
          continue;
        }
        parama.u().b().b(parama);
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          CBLogging.b("CBViewController", "Exception removing impression ", localException);
        }
      }
    }
  }
  
  public boolean d()
  {
    return d.a().c() != null;
  }
  
  public bo e()
  {
    return this.a;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/chartboost/sdk/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */