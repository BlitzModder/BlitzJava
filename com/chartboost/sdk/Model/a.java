package com.chartboost.sdk.Model;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewParent;
import com.chartboost.sdk.Libraries.CBLogging;
import com.chartboost.sdk.Libraries.e.a;
import com.chartboost.sdk.c;
import com.chartboost.sdk.e;
import com.chartboost.sdk.g;
import com.chartboost.sdk.g.a;
import com.chartboost.sdk.impl.ad;
import com.chartboost.sdk.impl.ae;
import com.chartboost.sdk.impl.ag;
import com.chartboost.sdk.impl.ah;
import com.chartboost.sdk.impl.au;
import com.chartboost.sdk.impl.av;
import com.chartboost.sdk.impl.ay;
import com.chartboost.sdk.impl.ba;
import com.chartboost.sdk.impl.bo;
import com.chartboost.sdk.impl.bs;
import java.util.Date;

public final class a
{
  private d A;
  private Runnable B;
  public b a = b.a;
  public Date b;
  public e c = e.a;
  public a d;
  public String e;
  public c f;
  public int g = 0;
  public String h = "";
  public String i;
  public boolean j;
  public boolean k;
  public bo l;
  public boolean m;
  public boolean n = false;
  public boolean o = false;
  public boolean p = false;
  public boolean q = false;
  public ay r;
  public boolean s;
  public boolean t = false;
  public boolean u = false;
  public boolean v = false;
  private e.a w;
  private boolean x;
  private Boolean y = null;
  private g z;
  
  public a(a parama, boolean paramBoolean1, String paramString, boolean paramBoolean2, b paramb)
  {
    this.j = paramBoolean1;
    this.b = new Date();
    this.k = false;
    this.s = false;
    this.u = true;
    this.d = parama;
    this.m = paramBoolean2;
    this.w = e.a.a;
    this.f = c.d;
    this.e = paramString;
    this.x = true;
    this.a = paramb;
    if (this.e == null) {
      this.e = "Default";
    }
  }
  
  public e.a A()
  {
    if (this.w == null) {
      return e.a.a;
    }
    return this.w;
  }
  
  public g B()
  {
    return this.z;
  }
  
  public boolean C()
  {
    return this.u;
  }
  
  public void a(e.a parama)
  {
    e.a locala = parama;
    if (parama == null) {
      locala = e.a.a;
    }
    this.w = locala;
  }
  
  public void a(e.a parama, d paramd)
  {
    int i2 = 0;
    e.a locala = parama;
    if (parama == null) {
      locala = e.a.a();
    }
    this.w = locala;
    this.c = e.a;
    this.A = paramd;
    parama = this.w.e("type");
    int i1;
    if ((!TextUtils.isEmpty(parama)) && (parama.equals("native")))
    {
      this.a = b.a;
      if (this.a != b.a) {
        break label145;
      }
      i1 = 1;
      label78:
      if (i1 == 0) {
        break label291;
      }
      switch (1.a[this.d.ordinal()])
      {
      }
    }
    for (;;)
    {
      this.z.a(locala);
      return;
      this.a = b.b;
      break;
      label145:
      i1 = 0;
      break label78;
      if (locala.a("media-type").equals("video"))
      {
        this.f = c.b;
        this.z = new ah(this);
        this.x = false;
      }
      else
      {
        this.f = c.a;
        this.z = new ag(this);
        continue;
        this.f = c.c;
        this.z = new ah(this);
        this.x = false;
        if (locala.c())
        {
          this.g = locala.f("reward");
          this.h = locala.e("currency-name");
          continue;
          this.z = new av(this);
          this.x = false;
        }
      }
    }
    label291:
    switch (1.a[this.d.ordinal()])
    {
    }
    for (;;)
    {
      this.z = new bs(this);
      break;
      if ((locala.a("media-type").c()) && (locala.a("media-type").equals("video")))
      {
        this.f = c.b;
        this.x = false;
      }
      else if ((locala.a("media-type").c()) && (locala.a("media-type").equals("image")))
      {
        this.f = c.a;
      }
      else
      {
        CBLogging.b("CBImpression", "Unknown media type in the response, so have issues determining which ad type to create the view for.");
        a(CBError.CBImpressionError.ERROR_CREATING_VIEW);
        continue;
        this.f = c.c;
        this.x = false;
        if (locala.c()) {
          this.g = locala.f("reward");
        }
        if (this.g <= 0)
        {
          try
          {
            parama = locala.a("webview");
            if ((!parama.c()) || (!parama.a("elements").c())) {
              continue;
            }
            parama = parama.a("elements");
            if (parama.p() <= 0) {
              continue;
            }
            i1 = i2;
            while (i1 < parama.p())
            {
              paramd = parama.c(i1);
              String str = paramd.e("param");
              if ((!TextUtils.isEmpty(str)) && (str.contains("reward_amount"))) {
                this.g = Integer.valueOf(paramd.f("value")).intValue();
              }
              if ((!TextUtils.isEmpty(str)) && (str.contains("reward_currency"))) {
                this.h = paramd.e("value");
              }
              i1 += 1;
            }
          }
          catch (Exception parama)
          {
            parama.printStackTrace();
          }
          this.x = false;
        }
      }
    }
  }
  
  public void a(CBError.CBImpressionError paramCBImpressionError)
  {
    if (this.A != null) {
      this.A.a(this, paramCBImpressionError);
    }
  }
  
  public void a(Runnable paramRunnable)
  {
    this.B = paramRunnable;
  }
  
  public boolean a()
  {
    return this.x;
  }
  
  public boolean a(String paramString, e.a parama)
  {
    if ((this.c != e.c) || (this.o)) {
      return false;
    }
    String str1;
    if (paramString != null)
    {
      str3 = this.w.e("deep-link");
      str1 = paramString;
      if (TextUtils.isEmpty(str3)) {}
    }
    for (;;)
    {
      try
      {
        boolean bool = ba.a(str3);
        if (!bool) {}
      }
      catch (Exception localException)
      {
        str2 = paramString;
        continue;
        this.s = true;
        this.u = false;
        this.A.a(this, str2, parama);
        return true;
      }
      try
      {
        this.y = new Boolean(true);
        str1 = str3;
      }
      catch (Exception paramString)
      {
        str2 = str3;
        continue;
      }
      if (!this.s) {
        continue;
      }
      return false;
      paramString = this.w.e("link");
      break;
      this.y = new Boolean(false);
      str1 = paramString;
    }
  }
  
  public boolean b()
  {
    return c.b() != null;
  }
  
  public void c()
  {
    if (this.A != null)
    {
      this.u = true;
      this.A.b(this);
    }
  }
  
  public void d()
  {
    if (this.A != null) {
      this.A.a(this);
    }
  }
  
  public boolean e()
  {
    return this.y != null;
  }
  
  public boolean f()
  {
    return this.y.booleanValue();
  }
  
  public void g()
  {
    if (this.A != null) {
      this.A.c(this);
    }
  }
  
  public void h()
  {
    if (this.A != null) {
      this.A.d(this);
    }
  }
  
  public boolean i()
  {
    if (this.z != null)
    {
      this.z.b();
      if (this.z.e() != null) {
        return true;
      }
    }
    else
    {
      CBLogging.b("CBImpression", "reinitializing -- no view protocol exists!!");
    }
    CBLogging.e("CBImpression", "reinitializing -- view not yet created");
    return false;
  }
  
  public void j()
  {
    k();
    if (!this.k) {
      return;
    }
    if (this.z != null) {
      this.z.d();
    }
    this.z = null;
    CBLogging.e("CBImpression", "Destroying the view and view data");
  }
  
  public void k()
  {
    if (this.l != null) {
      this.l.d();
    }
    try
    {
      if ((this.z != null) && (this.z.e() != null) && (this.z.e().getParent() != null)) {
        this.l.removeView(this.z.e());
      }
      this.l = null;
      if (this.z != null) {
        this.z.f();
      }
      CBLogging.e("CBImpression", "Destroying the view");
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        CBLogging.b("CBImpression", "Exception raised while cleaning up views", localException);
      }
    }
  }
  
  public CBError.CBImpressionError l()
  {
    if (this.z != null) {
      return this.z.c();
    }
    return CBError.CBImpressionError.ERROR_CREATING_VIEW;
  }
  
  public g.a m()
  {
    if (this.z != null) {
      return this.z.e();
    }
    return null;
  }
  
  public void n()
  {
    if ((this.z != null) && (this.z.e() != null)) {
      this.z.e().setVisibility(0);
    }
  }
  
  public void o()
  {
    if ((this.z != null) && (this.z.e() != null)) {
      this.z.e().setVisibility(8);
    }
  }
  
  public void p()
  {
    if ((this.z != null) && (this.z.e() != null))
    {
      ViewParent localViewParent = this.z.e().getParent();
      if ((localViewParent != null) && ((localViewParent instanceof View))) {
        ((View)localViewParent).setVisibility(0);
      }
    }
    else
    {
      return;
    }
    o();
  }
  
  public void q()
  {
    if ((this.z != null) && (this.z.e() != null))
    {
      ViewParent localViewParent = this.z.e().getParent();
      if ((localViewParent != null) && ((localViewParent instanceof View))) {
        ((View)localViewParent).setVisibility(8);
      }
    }
    else
    {
      return;
    }
    n();
  }
  
  public void r()
  {
    this.o = true;
  }
  
  public void s()
  {
    if (this.B != null)
    {
      this.B.run();
      this.B = null;
    }
    this.o = false;
    this.n = false;
  }
  
  public String t()
  {
    return this.w.e("ad_id");
  }
  
  public e u()
  {
    switch (1.a[this.d.ordinal()])
    {
    default: 
      return ad.i();
    case 3: 
      return au.i();
    }
    return ae.k();
  }
  
  public void v()
  {
    u().j(this);
  }
  
  public boolean w()
  {
    if (this.z != null) {
      return this.z.l();
    }
    return false;
  }
  
  public void x()
  {
    this.s = false;
    if ((this.z != null) && (this.t))
    {
      this.t = false;
      this.z.m();
    }
  }
  
  public void y()
  {
    this.s = false;
  }
  
  public void z()
  {
    if ((this.z != null) && (!this.t))
    {
      this.t = true;
      this.z.n();
    }
  }
  
  public static enum a
  {
    private a() {}
  }
  
  public static enum b
  {
    private b() {}
  }
  
  public static enum c
  {
    private c() {}
  }
  
  public static abstract interface d
  {
    public abstract void a(a parama);
    
    public abstract void a(a parama, CBError.CBImpressionError paramCBImpressionError);
    
    public abstract void a(a parama, String paramString, e.a parama1);
    
    public abstract void b(a parama);
    
    public abstract void c(a parama);
    
    public abstract void d(a parama);
  }
  
  public static enum e
  {
    private e() {}
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/chartboost/sdk/Model/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */