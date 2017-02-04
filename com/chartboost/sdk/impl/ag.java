package com.chartboost.sdk.impl;

import android.content.Context;
import android.graphics.Point;
import android.view.MotionEvent;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout.LayoutParams;
import com.chartboost.sdk.Libraries.e;
import com.chartboost.sdk.Libraries.e.a;
import com.chartboost.sdk.Libraries.e.b;
import com.chartboost.sdk.Libraries.f;
import com.chartboost.sdk.Libraries.j;
import com.chartboost.sdk.Model.a;
import com.chartboost.sdk.g;
import com.chartboost.sdk.g.a;

public class ag
  extends g
{
  protected j l = new j(this);
  protected j m = new j(this);
  protected e.a n;
  protected String o;
  protected float p = 1.0F;
  private j q = new j(this);
  private j r = new j(this);
  private j s = new j(this);
  private j t = new j(this);
  
  public ag(a parama)
  {
    super(parama);
  }
  
  public void a(ViewGroup.LayoutParams paramLayoutParams, j paramj, float paramFloat)
  {
    paramLayoutParams.width = ((int)(paramj.b() / paramj.g() * paramFloat));
    paramLayoutParams.height = ((int)(paramj.c() / paramj.g() * paramFloat));
  }
  
  public boolean a(e.a parama)
  {
    if (!super.a(parama)) {
      return false;
    }
    this.o = parama.e("ad_id");
    this.n = parama.a("ux");
    if ((this.f.b("frame-portrait")) || (this.f.b("close-portrait"))) {
      this.j = false;
    }
    if ((this.f.b("frame-landscape")) || (this.f.b("close-landscape"))) {
      this.k = false;
    }
    this.r.a("frame-landscape");
    this.q.a("frame-portrait");
    this.m.a("close-landscape");
    this.l.a("close-portrait");
    if (this.f.b("ad-portrait")) {
      this.j = false;
    }
    if (this.f.b("ad-landscape")) {
      this.k = false;
    }
    this.t.a("ad-landscape");
    this.s.a("ad-portrait");
    return true;
  }
  
  protected Point b(String paramString)
  {
    paramString = this.f.a(paramString).a("offset");
    if (paramString.c()) {
      return new Point(paramString.f("x"), paramString.f("y"));
    }
    return new Point(0, 0);
  }
  
  protected g.a b(Context paramContext)
  {
    return new a(paramContext);
  }
  
  public void d()
  {
    super.d();
    this.r.d();
    this.q.d();
    this.m.d();
    this.l.d();
    this.t.d();
    this.s.d();
    this.r = null;
    this.q = null;
    this.m = null;
    this.l = null;
    this.t = null;
    this.s = null;
  }
  
  public class a
    extends g.a
  {
    protected bi b;
    protected bj c;
    protected bj d;
    protected ImageView e;
    private boolean g = false;
    
    protected a(Context paramContext)
    {
      super(paramContext);
      setBackgroundColor(0);
      setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
      this.b = new bi(paramContext);
      addView(this.b, new RelativeLayout.LayoutParams(-1, -1));
      this.d = new bj(paramContext)
      {
        protected void a(MotionEvent paramAnonymousMotionEvent)
        {
          ag.a.this.a(paramAnonymousMotionEvent.getX(), paramAnonymousMotionEvent.getY(), ag.a.this.d.getWidth(), ag.a.this.d.getHeight());
        }
      };
      a(this.d);
      this.e = new ImageView(paramContext);
      this.e.setBackgroundColor(-16777216);
      addView(this.e);
      addView(this.d);
    }
    
    protected void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
    {
      ag.a(ag.this, e.a(new e.b[] { e.a("click_coordinates", e.a(new e.b[] { e.a("x", Float.valueOf(paramFloat1)), e.a("y", Float.valueOf(paramFloat2)), e.a("w", Float.valueOf(paramFloat3)), e.a("h", Float.valueOf(paramFloat4)) })) }));
      ag.this.a(null, ag.a(ag.this));
    }
    
    protected void a(int paramInt1, int paramInt2)
    {
      if (!this.g)
      {
        d();
        this.g = true;
      }
      boolean bool = ag.this.a().a();
      Object localObject3;
      label56:
      Object localObject1;
      label89:
      label122:
      Object localObject4;
      RelativeLayout.LayoutParams localLayoutParams;
      float f1;
      label249:
      label365:
      int i;
      int j;
      if (bool)
      {
        localObject2 = ag.b(ag.this);
        if (!bool) {
          break label764;
        }
        localObject3 = ag.this.l;
        localObject1 = localObject2;
        if (!((j)localObject2).e())
        {
          if (localObject2 != ag.b(ag.this)) {
            break label776;
          }
          localObject1 = ag.c(ag.this);
        }
        localObject2 = localObject3;
        if (!((j)localObject3).e())
        {
          if (localObject3 != ag.this.l) {
            break label788;
          }
          localObject2 = ag.this.m;
        }
        localObject4 = new RelativeLayout.LayoutParams(-2, -2);
        localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
        ag.this.a((ViewGroup.LayoutParams)localObject4, (j)localObject1, 1.0F);
        f1 = Math.min(paramInt1 / ((RelativeLayout.LayoutParams)localObject4).width, paramInt2 / ((RelativeLayout.LayoutParams)localObject4).height);
        ag.this.p = Math.min(f1, 1.0F);
        ((RelativeLayout.LayoutParams)localObject4).width = ((int)(((RelativeLayout.LayoutParams)localObject4).width * ag.this.p));
        ((RelativeLayout.LayoutParams)localObject4).height = ((int)(((RelativeLayout.LayoutParams)localObject4).height * ag.this.p));
        ag localag = ag.this;
        if (!bool) {
          break label800;
        }
        localObject3 = "frame-portrait";
        localObject3 = localag.b((String)localObject3);
        ((RelativeLayout.LayoutParams)localObject4).leftMargin = Math.round((paramInt1 - ((RelativeLayout.LayoutParams)localObject4).width) / 2.0F + ((Point)localObject3).x / ((j)localObject1).g() * ag.this.p);
        f1 = (paramInt2 - ((RelativeLayout.LayoutParams)localObject4).height) / 2.0F;
        ((RelativeLayout.LayoutParams)localObject4).topMargin = Math.round(((Point)localObject3).y / ((j)localObject1).g() * ag.this.p + f1);
        ag.this.a(localLayoutParams, (j)localObject2, 1.0F);
        localag = ag.this;
        if (!bool) {
          break label807;
        }
        localObject3 = "close-portrait";
        localObject3 = localag.b((String)localObject3);
        if ((((Point)localObject3).x != 0) || (((Point)localObject3).y != 0)) {
          break label814;
        }
        i = ((RelativeLayout.LayoutParams)localObject4).leftMargin;
        j = ((RelativeLayout.LayoutParams)localObject4).width;
        j = Math.round(-localLayoutParams.width / 2.0F) + (i + j);
        i = ((RelativeLayout.LayoutParams)localObject4).topMargin + Math.round(-localLayoutParams.height / 2.0F);
        label444:
        localLayoutParams.leftMargin = Math.min(Math.max(0, j), paramInt1 - localLayoutParams.width);
        localLayoutParams.topMargin = Math.min(Math.max(0, i), paramInt2 - localLayoutParams.height);
        this.b.setLayoutParams((ViewGroup.LayoutParams)localObject4);
        this.c.setLayoutParams(localLayoutParams);
        this.b.setScaleType(ImageView.ScaleType.FIT_CENTER);
        this.b.a((j)localObject1);
        this.c.a((j)localObject2);
        if (!bool) {
          break label895;
        }
        localObject2 = ag.d(ag.this);
        label546:
        localObject1 = localObject2;
        if (!((j)localObject2).e())
        {
          if (localObject2 != ag.d(ag.this)) {
            break label907;
          }
          localObject1 = ag.e(ag.this);
        }
        label579:
        localObject3 = new RelativeLayout.LayoutParams(-2, -2);
        ag.this.a((ViewGroup.LayoutParams)localObject3, (j)localObject1, ag.this.p);
        localObject4 = ag.this;
        if (!bool) {
          break label919;
        }
      }
      label764:
      label776:
      label788:
      label800:
      label807:
      label814:
      label895:
      label907:
      label919:
      for (Object localObject2 = "ad-portrait";; localObject2 = "ad-landscape")
      {
        localObject2 = ((ag)localObject4).b((String)localObject2);
        ((RelativeLayout.LayoutParams)localObject3).leftMargin = Math.round((paramInt1 - ((RelativeLayout.LayoutParams)localObject3).width) / 2.0F + ((Point)localObject2).x / ((j)localObject1).g() * ag.this.p);
        f1 = (paramInt2 - ((RelativeLayout.LayoutParams)localObject3).height) / 2.0F;
        ((RelativeLayout.LayoutParams)localObject3).topMargin = Math.round(((Point)localObject2).y / ((j)localObject1).g() * ag.this.p + f1);
        this.e.setLayoutParams((ViewGroup.LayoutParams)localObject3);
        this.d.setLayoutParams((ViewGroup.LayoutParams)localObject3);
        this.d.a(ImageView.ScaleType.FIT_CENTER);
        this.d.a((j)localObject1);
        return;
        localObject2 = ag.c(ag.this);
        break;
        localObject3 = ag.this.m;
        break label56;
        localObject1 = ag.b(ag.this);
        break label89;
        localObject2 = ag.this.l;
        break label122;
        localObject3 = "frame-landscape";
        break label249;
        localObject3 = "close-landscape";
        break label365;
        j = Math.round(((RelativeLayout.LayoutParams)localObject4).leftMargin + ((RelativeLayout.LayoutParams)localObject4).width / 2.0F + ((Point)localObject3).x - localLayoutParams.width / 2.0F);
        f1 = ((RelativeLayout.LayoutParams)localObject4).topMargin;
        float f2 = ((RelativeLayout.LayoutParams)localObject4).height / 2.0F;
        i = Math.round(((Point)localObject3).y + (f1 + f2) - localLayoutParams.height / 2.0F);
        break label444;
        localObject2 = ag.e(ag.this);
        break label546;
        localObject1 = ag.d(ag.this);
        break label579;
      }
    }
    
    public void b()
    {
      super.b();
      this.b = null;
      this.c = null;
      this.d = null;
      this.e = null;
    }
    
    protected void d()
    {
      this.c = new bj(getContext())
      {
        protected void a(MotionEvent paramAnonymousMotionEvent)
        {
          ag.a.this.e();
        }
      };
      addView(this.c);
    }
    
    protected void e()
    {
      ag.f(ag.this);
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/chartboost/sdk/impl/ag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */