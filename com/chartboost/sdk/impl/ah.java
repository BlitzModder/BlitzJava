package com.chartboost.sdk.impl;

import android.content.Context;
import android.graphics.Point;
import android.os.Handler;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import com.chartboost.sdk.Libraries.CBLogging;
import com.chartboost.sdk.Libraries.CBUtility;
import com.chartboost.sdk.Libraries.e;
import com.chartboost.sdk.Libraries.e.a;
import com.chartboost.sdk.Libraries.e.b;
import com.chartboost.sdk.Libraries.f;
import com.chartboost.sdk.Libraries.h;
import com.chartboost.sdk.Libraries.j;
import com.chartboost.sdk.Model.CBError.CBImpressionError;
import com.chartboost.sdk.Model.a;
import com.chartboost.sdk.Model.a.c;
import com.chartboost.sdk.g;
import com.chartboost.sdk.g.a;
import java.util.Map;

public class ah
  extends ag
{
  protected boolean A = false;
  protected int B = 0;
  protected j C = new j(this);
  protected j D = new j(this);
  protected j E = new j(this);
  protected j F = new j(this);
  protected j G = new j(this);
  protected j H = new j(this);
  protected j I = new j(this);
  protected j J = new j(this);
  protected boolean K = false;
  protected boolean L = false;
  protected boolean M = false;
  private boolean N = true;
  private boolean O = false;
  private boolean P = false;
  private boolean Q = false;
  private boolean R = false;
  protected b q = b.a;
  protected int r = 0;
  protected String s;
  protected String t;
  protected int u = 0;
  protected int v = 0;
  protected boolean w;
  protected boolean x;
  protected boolean y;
  protected boolean z;
  
  public ah(a parama)
  {
    super(parama);
  }
  
  public void a(boolean paramBoolean)
  {
    this.Q = paramBoolean;
  }
  
  public boolean a(e.a parama)
  {
    boolean bool2 = false;
    if (!super.a(parama)) {
      return false;
    }
    if ((this.f.b("video-landscape")) || (this.f.b("replay-landscape"))) {
      this.k = false;
    }
    this.C.a("replay-landscape");
    this.D.a("replay-portrait");
    this.G.a("video-click-button");
    this.H.a("post-video-reward-icon");
    this.I.a("post-video-button");
    this.E.a("video-confirmation-button");
    this.F.a("video-confirmation-icon");
    this.J.a("post-video-reward-icon");
    this.w = parama.a("ux").j("video-controls-togglable");
    if (parama.a("fullscreen").b())
    {
      bool1 = false;
      this.L = bool1;
      if (!parama.a("preroll_popup_fullscreen").b()) {
        break label315;
      }
    }
    label315:
    for (boolean bool1 = bool2;; bool1 = parama.a("preroll_popup_fullscreen").n())
    {
      this.M = bool1;
      if ((this.g.f == a.c.c) && (this.n.a("post-video-toaster").c("title")) && (this.n.a("post-video-toaster").c("tagline"))) {
        this.y = true;
      }
      if ((this.g.f == a.c.c) && (this.n.a("confirmation").c("text")) && (this.n.a("confirmation").c("color"))) {
        this.x = true;
      }
      if ((this.g.f == a.c.c) && (this.n.c("post-video-reward-toaster"))) {
        this.z = true;
      }
      return true;
      bool1 = parama.a("fullscreen").n();
      break;
    }
  }
  
  protected g.a b(Context paramContext)
  {
    return new a(paramContext, null);
  }
  
  public void d()
  {
    super.d();
    this.C.d();
    this.D.d();
    this.G.d();
    this.H.d();
    this.I.d();
    this.E.d();
    this.F.d();
    this.J.d();
    this.C = null;
    this.D = null;
    this.G = null;
    this.H = null;
    this.I = null;
    this.E = null;
    this.F = null;
    this.J = null;
  }
  
  protected void i()
  {
    if ((this.x) && ((!this.E.e()) || (!this.F.e()))) {
      this.x = false;
    }
    if (this.N)
    {
      super.i();
      return;
    }
    a(CBError.CBImpressionError.ERROR_DISPLAYING_VIEW);
  }
  
  public float j()
  {
    return this.v;
  }
  
  public float k()
  {
    return this.u;
  }
  
  public boolean l()
  {
    if ((r().b(true).getVisibility() == 4) || (r().b(true).getVisibility() == 8)) {
      return true;
    }
    r().e();
    return true;
  }
  
  public void m()
  {
    super.m();
    if ((this.q == b.b) && (this.O))
    {
      a.b(r()).b().a(this.u);
      if (!this.P) {
        a.b(r()).e();
      }
    }
    this.P = false;
    this.O = false;
  }
  
  public void n()
  {
    super.n();
    if ((this.q == b.b) && (!this.O))
    {
      if (!a.b(r()).i()) {
        this.P = true;
      }
      this.O = true;
      a.b(r()).g();
    }
  }
  
  public boolean o()
  {
    return this.g.f == a.c.b;
  }
  
  public void p()
  {
    bk.a locala = new bk.a();
    locala.a(this.n.a("cancel-popup").e("title")).b(this.n.a("cancel-popup").e("text")).d(this.n.a("cancel-popup").e("confirm")).c(this.n.a("cancel-popup").e("cancel"));
    locala.a(r().getContext(), new bk.b()
    {
      public void a(bk paramAnonymousbk)
      {
        paramAnonymousbk = ah.this.r();
        if (paramAnonymousbk != null) {
          ah.a.b(paramAnonymousbk).e();
        }
      }
      
      public void a(bk paramAnonymousbk, int paramAnonymousInt)
      {
        paramAnonymousbk = ah.this.r();
        if (paramAnonymousInt == 1)
        {
          if (paramAnonymousbk != null) {
            ah.a.b(paramAnonymousbk).e();
          }
          return;
        }
        if (paramAnonymousbk != null)
        {
          ah.a.a(paramAnonymousbk, false);
          ah.a.b(paramAnonymousbk).h();
        }
        ah.u(ah.this);
      }
    });
  }
  
  public boolean q()
  {
    return this.q == b.b;
  }
  
  public a r()
  {
    return (a)super.e();
  }
  
  protected void s()
  {
    this.g.v();
  }
  
  protected boolean t()
  {
    boolean bool1 = true;
    if (this.q == b.c) {}
    boolean bool2;
    do
    {
      do
      {
        return false;
        bool2 = CBUtility.c().a();
        if (this.q != b.a) {
          break;
        }
      } while ((!this.M) && (!bool2));
      return true;
      if (this.q != b.b) {
        break;
      }
    } while ((!this.L) && (!bool2));
    return true;
    if ((bool2) && (this.q != b.c)) {}
    for (;;)
    {
      return bool1;
      bool1 = false;
    }
  }
  
  public boolean u()
  {
    return this.Q;
  }
  
  public void v()
  {
    this.R = true;
    a(CBError.CBImpressionError.ERROR_PLAYING_VIDEO);
  }
  
  public class a
    extends ag.a
  {
    private bj h;
    private an i;
    private ak j;
    private View k;
    private af l;
    private ai m;
    private bj n;
    
    private a(Context paramContext)
    {
      super(paramContext);
      if (ah.this.L)
      {
        this.k = new View(paramContext);
        this.k.setBackgroundColor(-16777216);
        this.k.setVisibility(8);
        addView(this.k);
      }
      if (ah.a(ah.this).f == a.c.c)
      {
        this.j = new ak(paramContext, ah.this);
        this.j.setVisibility(8);
        addView(this.j);
      }
      this.i = new an(paramContext, ah.this);
      this.i.setVisibility(8);
      addView(this.i);
      this.l = new af(paramContext, ah.this);
      this.l.setVisibility(8);
      addView(this.l);
      if (ah.b(ah.this).f == a.c.c)
      {
        this.m = new ai(paramContext, ah.this);
        this.m.setVisibility(8);
        addView(this.m);
      }
      this.h = new bj(getContext())
      {
        protected void a(MotionEvent paramAnonymousMotionEvent)
        {
          if (ah.c(ah.this).f == a.c.c) {
            ah.a.a(ah.a.this).a(false);
          }
          if (ah.this.q == ah.b.b) {
            ah.a.a(ah.a.this, false);
          }
          ah.a.b(ah.a.this, true);
        }
      };
      this.h.setVisibility(8);
      addView(this.h);
      this.n = new bj(getContext())
      {
        protected void a(MotionEvent paramAnonymousMotionEvent)
        {
          ah.a.this.e();
        }
      };
      this.n.setVisibility(8);
      addView(this.n);
      if ((ah.this.n.a("progress").c("background-color")) && (ah.this.n.a("progress").c("border-color")) && (ah.this.n.a("progress").c("progress-color")) && (ah.this.n.a("progress").c("radius")))
      {
        ah.this.K = true;
        paramContext = this.i.c();
        paramContext.a(g.a(ah.this.n.a("progress").e("background-color")));
        paramContext.b(g.a(ah.this.n.a("progress").e("border-color")));
        paramContext.c(g.a(ah.this.n.a("progress").e("progress-color")));
        paramContext.b(ah.this.n.a("progress").a("radius").k());
      }
      if (ah.this.n.a("video-controls-background").c("color")) {
        this.i.a(g.a(ah.this.n.a("video-controls-background").e("color")));
      }
      if ((ah.d(ah.this).f == a.c.c) && (ah.this.y)) {
        this.l.a(ah.this.n.a("post-video-toaster").e("title"), ah.this.n.a("post-video-toaster").e("tagline"));
      }
      if ((ah.e(ah.this).f == a.c.c) && (ah.this.x)) {
        this.j.a(ah.this.n.a("confirmation").e("text"), g.a(ah.this.n.a("confirmation").e("color")));
      }
      if ((ah.f(ah.this).f == a.c.c) && (ah.this.z))
      {
        if (!ah.this.n.a("post-video-reward-toaster").a("position").equals("inside-top")) {
          break label801;
        }
        paramContext = al.a.a;
        this.m.a(paramContext);
        this.m.a(ah.this.n.a("post-video-reward-toaster").e("text"));
        if (ah.this.H.e()) {
          this.m.a(ah.this.J);
        }
      }
      if (ah.g(ah.this).a("video-click-button").b()) {
        this.i.d();
      }
      this.i.c(ah.this.n.j("video-progress-timer-enabled"));
      if ((ah.this.M) || (ah.this.L)) {
        this.e.setVisibility(4);
      }
      boolean bool = ah.this.a().a();
      e.a locala = ah.h(ah.this);
      if (bool) {}
      for (paramContext = "video-portrait";; paramContext = "video-landscape")
      {
        ah.this.t = locala.a(paramContext).e("id");
        if (!TextUtils.isEmpty(ah.this.t)) {
          break label815;
        }
        ah.a(ah.this, CBError.CBImpressionError.VIDEO_ID_MISSING);
        return;
        label801:
        paramContext = al.a.b;
        break;
      }
      label815:
      if (ah.this.s == null) {
        ah.this.s = h.a(ah.this.t);
      }
      if (ah.this.s == null)
      {
        ah.b(ah.this, CBError.CBImpressionError.VIDEO_UNAVAILABLE);
        return;
      }
      this.i.a(ah.this.s);
    }
    
    private void a(ah.b paramb, boolean paramBoolean)
    {
      boolean bool2 = true;
      ah.this.q = paramb;
      boolean bool1;
      Object localObject;
      switch (ah.2.a[paramb.ordinal()])
      {
      default: 
        bool1 = g();
        localObject = b(true);
        ((View)localObject).setEnabled(bool1);
        ah.this.a(bool1, (View)localObject, paramBoolean);
        localObject = b(false);
        ((View)localObject).setEnabled(false);
        ah.this.a(false, (View)localObject, paramBoolean);
        if ((ah.this.M) || (ah.this.L))
        {
          localObject = ah.this;
          if (!ah.this.t())
          {
            bool1 = true;
            label135:
            ((ah)localObject).a(bool1, this.e, paramBoolean);
          }
        }
        else
        {
          localObject = ah.this;
          if (ah.this.t()) {
            break label668;
          }
          bool1 = true;
          label164:
          ((ah)localObject).a(bool1, this.b, paramBoolean);
          if (paramb == ah.b.a) {
            break label673;
          }
        }
        break;
      }
      label668:
      label673:
      for (paramBoolean = bool2;; paramBoolean = false)
      {
        a(paramBoolean);
        return;
        localObject = ah.this;
        if (!ah.this.t()) {}
        for (bool1 = true;; bool1 = false)
        {
          ((ah)localObject).a(bool1, this.d, paramBoolean);
          if (ah.n(ah.this).f == a.c.c) {
            ah.this.a(true, this.j, paramBoolean);
          }
          if (ah.this.L) {
            ah.this.a(false, this.k, paramBoolean);
          }
          ah.this.a(false, this.i, paramBoolean);
          ah.this.a(false, this.h, paramBoolean);
          ah.this.a(false, this.l, paramBoolean);
          this.d.setEnabled(false);
          this.h.setEnabled(false);
          this.i.setEnabled(false);
          break;
        }
        ah.this.a(false, this.d, paramBoolean);
        if (ah.o(ah.this).f == a.c.c) {
          ah.this.a(false, this.j, paramBoolean);
        }
        if (ah.this.L) {
          ah.this.a(true, this.k, paramBoolean);
        }
        ah.this.a(true, this.i, paramBoolean);
        ah.this.a(false, this.h, paramBoolean);
        ah.this.a(false, this.l, paramBoolean);
        this.d.setEnabled(true);
        this.h.setEnabled(false);
        this.i.setEnabled(true);
        break;
        ah.this.a(true, this.d, paramBoolean);
        if (ah.p(ah.this).f == a.c.c) {
          ah.this.a(false, this.j, paramBoolean);
        }
        if (ah.this.L) {
          ah.this.a(false, this.k, paramBoolean);
        }
        ah.this.a(false, this.i, paramBoolean);
        ah.this.a(true, this.h, paramBoolean);
        if ((ah.this.I.e()) && (ah.this.H.e()) && (ah.this.y)) {}
        for (bool1 = true;; bool1 = false)
        {
          ah.this.a(bool1, this.l, paramBoolean);
          this.h.setEnabled(true);
          this.d.setEnabled(true);
          this.i.setEnabled(false);
          if (!ah.this.A) {
            break;
          }
          e(false);
          break;
        }
        bool1 = false;
        break label135;
        bool1 = false;
        break label164;
      }
    }
    
    private void c(boolean paramBoolean)
    {
      if (ah.this.q == ah.b.b) {
        return;
      }
      if (ah.this.x)
      {
        a(ah.b.a, paramBoolean);
        return;
      }
      a(ah.b.b, paramBoolean);
      if ((ah.this.r < 1) && (ah.this.n.a("timer").c("delay")))
      {
        if (ah.this.w) {}
        for (localObject = "visible";; localObject = "hidden")
        {
          CBLogging.c("InterstitialVideoViewProtocol", String.format("controls starting %s, setting timer", new Object[] { localObject }));
          this.i.a(ah.this.w);
          long l1 = Math.round(1000.0D * ah.this.n.a("timer").h("delay"));
          ah.a(ah.this, this.i, new Runnable()
          {
            public void run()
            {
              Object localObject;
              if (ah.this.w)
              {
                localObject = "hidden";
                CBLogging.c("InterstitialVideoViewProtocol", String.format("controls %s automatically from timer", new Object[] { localObject }));
                localObject = ah.a.b(ah.a.this);
                if (ah.this.w) {
                  break label99;
                }
              }
              label99:
              for (boolean bool = true;; bool = false)
              {
                ((an)localObject).a(bool, true);
                ah.this.i.remove(Integer.valueOf(ah.a.b(ah.a.this).hashCode()));
                return;
                localObject = "shown";
                break;
              }
            }
          }, l1);
          this.i.e();
          if (ah.this.r > 1) {
            break;
          }
          ah.m(ah.this).h();
          return;
        }
      }
      Object localObject = this.i;
      if (!ah.this.w) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        ((an)localObject).a(paramBoolean);
        break;
      }
    }
    
    private void d(boolean paramBoolean)
    {
      this.i.f();
      if (ah.this.q != ah.b.b) {}
      do
      {
        do
        {
          return;
        } while (!paramBoolean);
        if ((ah.this.r < 1) && (ah.this.n.c("post-video-reward-toaster")) && (ah.this.z) && (ah.this.H.e()) && (ah.this.I.e())) {
          e(true);
        }
        a(ah.b.c, true);
      } while (!CBUtility.c().a());
      requestLayout();
    }
    
    private void e(boolean paramBoolean)
    {
      if (paramBoolean) {
        this.m.a(true);
      }
      for (;;)
      {
        g.a.postDelayed(new Runnable()
        {
          public void run()
          {
            ah.a.a(ah.a.this).a(false);
          }
        }, 2500L);
        return;
        this.m.setVisibility(0);
      }
    }
    
    protected void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
    {
      if (((ah.this.w) && (ah.this.q == ah.b.b)) || (ah.this.q == ah.b.a)) {
        return;
      }
      b(paramFloat1, paramFloat2, paramFloat3, paramFloat4);
    }
    
    protected void a(int paramInt1, int paramInt2)
    {
      super.a(paramInt1, paramInt2);
      a(ah.this.q, false);
      boolean bool = ah.this.a().a();
      RelativeLayout.LayoutParams localLayoutParams1 = new RelativeLayout.LayoutParams(-1, -1);
      RelativeLayout.LayoutParams localLayoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
      RelativeLayout.LayoutParams localLayoutParams3 = new RelativeLayout.LayoutParams(-1, -1);
      RelativeLayout.LayoutParams localLayoutParams4 = new RelativeLayout.LayoutParams(-1, -1);
      RelativeLayout.LayoutParams localLayoutParams5 = new RelativeLayout.LayoutParams(-1, -1);
      RelativeLayout.LayoutParams localLayoutParams6 = (RelativeLayout.LayoutParams)this.b.getLayoutParams();
      Object localObject2 = ah.this;
      if (bool)
      {
        localObject1 = ah.this.D;
        ((ah)localObject2).a(localLayoutParams2, (j)localObject1, 1.0F);
        localObject2 = ah.this;
        if (!bool) {
          break label560;
        }
        localObject1 = "replay-portrait";
        label145:
        localObject1 = ((ah)localObject2).b((String)localObject1);
        int i1 = Math.round(localLayoutParams6.leftMargin + localLayoutParams6.width / 2.0F + ((Point)localObject1).x - localLayoutParams2.width / 2.0F);
        float f = localLayoutParams6.topMargin;
        int i2 = Math.round(localLayoutParams6.height / 2.0F + f + ((Point)localObject1).y - localLayoutParams2.height / 2.0F);
        localLayoutParams2.leftMargin = Math.min(Math.max(0, i1), paramInt1 - localLayoutParams2.width);
        localLayoutParams2.topMargin = Math.min(Math.max(0, i2), paramInt2 - localLayoutParams2.height);
        this.h.bringToFront();
        if (!bool) {
          break label568;
        }
        this.h.a(ah.this.D);
      }
      for (;;)
      {
        localLayoutParams6 = (RelativeLayout.LayoutParams)this.d.getLayoutParams();
        if (ah.this.t()) {
          break label585;
        }
        localLayoutParams3.width = localLayoutParams6.width;
        localLayoutParams3.height = localLayoutParams6.height;
        localLayoutParams3.leftMargin = localLayoutParams6.leftMargin;
        localLayoutParams3.topMargin = localLayoutParams6.topMargin;
        localLayoutParams4.width = localLayoutParams6.width;
        localLayoutParams4.height = localLayoutParams6.height;
        localLayoutParams4.leftMargin = localLayoutParams6.leftMargin;
        localLayoutParams4.topMargin = localLayoutParams6.topMargin;
        localLayoutParams5.width = localLayoutParams6.width;
        localLayoutParams5.height = 72;
        localLayoutParams5.leftMargin = localLayoutParams6.leftMargin;
        paramInt1 = localLayoutParams6.topMargin;
        localLayoutParams5.topMargin = (localLayoutParams6.height + paramInt1 - 72);
        if (ah.this.L) {
          this.k.setLayoutParams(localLayoutParams1);
        }
        if (ah.k(ah.this).f == a.c.c) {
          this.j.setLayoutParams(localLayoutParams3);
        }
        this.i.setLayoutParams(localLayoutParams4);
        this.l.setLayoutParams(localLayoutParams5);
        this.h.setLayoutParams(localLayoutParams2);
        if (ah.l(ah.this).f == a.c.c) {
          this.j.a();
        }
        this.i.a();
        return;
        localObject1 = ah.this.C;
        break;
        label560:
        localObject1 = "replay-landscape";
        break label145;
        label568:
        this.h.a(ah.this.C);
      }
      label585:
      localObject2 = new RelativeLayout.LayoutParams(-2, -2);
      if (bool) {}
      for (Object localObject1 = ah.this.l;; localObject1 = ah.this.m)
      {
        ah.this.a((ViewGroup.LayoutParams)localObject2, (j)localObject1, 1.0F);
        ((RelativeLayout.LayoutParams)localObject2).leftMargin = 0;
        ((RelativeLayout.LayoutParams)localObject2).topMargin = 0;
        ((RelativeLayout.LayoutParams)localObject2).addRule(11);
        this.n.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        this.n.a((j)localObject1);
        break;
      }
    }
    
    public bj b(boolean paramBoolean)
    {
      if (((ah.this.t()) && (paramBoolean)) || ((!ah.this.t()) && (!paramBoolean))) {
        return this.n;
      }
      return this.c;
    }
    
    public void b()
    {
      ah.this.n();
      super.b();
    }
    
    protected void b(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
    {
      if (ah.this.q == ah.b.b) {
        d(false);
      }
      ah.a(ah.this, e.a(new e.b[] { e.a("click_coordinates", e.a(new e.b[] { e.a("x", Float.valueOf(paramFloat1)), e.a("y", Float.valueOf(paramFloat2)), e.a("w", Float.valueOf(paramFloat3)), e.a("h", Float.valueOf(paramFloat4)) })) }));
      ah.this.a(null, ah.t(ah.this));
    }
    
    protected void d()
    {
      super.d();
      if ((ah.this.q == ah.b.a) && ((!ah.this.x) || (ah.this.o())))
      {
        c(false);
        return;
      }
      a(ah.this.q, false);
    }
    
    protected void e()
    {
      if ((ah.this.q == ah.b.b) && (ah.this.n.a("cancel-popup").c("title")) && (ah.this.n.a("cancel-popup").c("text")) && (ah.this.n.a("cancel-popup").c("cancel")) && (ah.this.n.a("cancel-popup").c("confirm")))
      {
        this.i.g();
        if (ah.this.r < 1)
        {
          ah.this.p();
          return;
        }
      }
      if (ah.this.q == ah.b.b)
      {
        d(false);
        this.i.h();
        if (ah.this.r < 1)
        {
          ah localah = ah.this;
          localah.r += 1;
          ah.r(ah.this).g();
        }
      }
      g.a.post(new Runnable()
      {
        public void run()
        {
          ah.s(ah.this);
        }
      });
    }
    
    public void f()
    {
      d(true);
      this.i.h();
      ah localah = ah.this;
      localah.r += 1;
      if ((ah.this.r <= 1) && (!ah.i(ah.this)) && (ah.this.u >= 1)) {
        ah.j(ah.this).g();
      }
    }
    
    protected boolean g()
    {
      if ((ah.this.q == ah.b.b) && (ah.this.r < 1))
      {
        e.a locala = ah.q(ah.this);
        StringBuilder localStringBuilder = new StringBuilder().append("close-");
        String str;
        float f;
        if (ah.this.a().a())
        {
          str = "portrait";
          f = locala.a(str).a("delay").a(-1.0F);
          if (f < 0.0F) {
            break label144;
          }
        }
        label144:
        for (int i1 = Math.round(f * 1000.0F);; i1 = -1)
        {
          ah.this.B = i1;
          if (i1 < 0) {
            break label149;
          }
          if (i1 <= this.i.b().d()) {
            break label151;
          }
          return false;
          str = "landscape";
          break;
        }
        label149:
        return false;
      }
      label151:
      return true;
    }
    
    protected void h()
    {
      ah.this.x = false;
      c(true);
    }
  }
  
  protected static enum b
  {
    private b() {}
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/chartboost/sdk/impl/ah.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */