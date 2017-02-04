package com.chartboost.sdk.impl;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.net.Uri;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.chartboost.sdk.Libraries.CBUtility;
import com.chartboost.sdk.Libraries.e;
import com.chartboost.sdk.Libraries.e.a;
import com.chartboost.sdk.Libraries.e.b;
import com.chartboost.sdk.Libraries.f;
import com.chartboost.sdk.Libraries.j;

public final class an
  extends RelativeLayout
  implements MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnPreparedListener
{
  private static final CharSequence a = "00:00";
  private static Handler l = CBUtility.e();
  private RelativeLayout b;
  private am c;
  private am d;
  private bj e;
  private TextView f;
  private aj g;
  private bf h;
  private ah i;
  private boolean j = false;
  private boolean k = false;
  private Runnable m = new Runnable()
  {
    public void run()
    {
      an.a(an.this, false);
    }
  };
  private Runnable n = new Runnable()
  {
    public void run()
    {
      if (an.c(an.this) != null) {
        an.c(an.this).setVisibility(8);
      }
      if (an.b(an.this).K) {
        an.d(an.this).setVisibility(8);
      }
      an.e(an.this).setVisibility(8);
      if (an.a(an.this) != null) {
        an.a(an.this).setEnabled(false);
      }
    }
  };
  private Runnable o = new Runnable()
  {
    private int b = 0;
    
    public void run()
    {
      if (an.f(an.this).a().e())
      {
        int i = an.f(an.this).a().d();
        if (i > 0)
        {
          an.b(an.this).u = i;
          f = an.b(an.this).u;
          if ((an.f(an.this).a().e()) && (f / 1000.0F > 0.0F) && (!an.b(an.this).u()))
          {
            an.b(an.this).s();
            an.b(an.this).a(true);
          }
        }
        float f = i / an.f(an.this).a().c();
        if (an.b(an.this).K) {
          an.d(an.this).a(f);
        }
        i /= 1000;
        if (this.b != i)
        {
          this.b = i;
          int j = i / 60;
          an.g(an.this).setText(String.format("%02d:%02d", new Object[] { Integer.valueOf(j), Integer.valueOf(i % 60) }));
        }
      }
      Object localObject = an.b(an.this).r();
      if (((ah.a)localObject).g())
      {
        localObject = ((ah.a)localObject).b(true);
        if (((bj)localObject).getVisibility() == 8)
        {
          an.b(an.this).a(true, (View)localObject);
          ((bj)localObject).setEnabled(true);
        }
      }
      an.j().removeCallbacks(an.h(an.this));
      an.j().postDelayed(an.h(an.this), 16L);
    }
  };
  
  public an(Context paramContext, ah paramah)
  {
    super(paramContext);
    this.i = paramah;
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    paramContext = getContext();
    Object localObject1 = this.i.g();
    float f1 = getContext().getResources().getDisplayMetrics().density;
    int i1 = Math.round(f1 * 10.0F);
    this.h = new bf(paramContext);
    this.i.r().a(this.h);
    Object localObject2 = new RelativeLayout.LayoutParams(-1, -2);
    ((RelativeLayout.LayoutParams)localObject2).addRule(13);
    addView(this.h, (ViewGroup.LayoutParams)localObject2);
    this.b = new RelativeLayout(paramContext);
    if ((((e.a)localObject1).c()) && (((e.a)localObject1).a("video-click-button").c()))
    {
      this.c = new am(paramContext);
      this.c.setVisibility(8);
      this.e = new bj(paramContext)
      {
        protected void a(MotionEvent paramAnonymousMotionEvent)
        {
          e.a locala = e.a(new e.b[] { e.a("paused", Integer.valueOf(1)) });
          locala.a("click_coordinates", e.a(new e.b[] { e.a("x", Float.valueOf(paramAnonymousMotionEvent.getX())), e.a("y", Float.valueOf(paramAnonymousMotionEvent.getY())), e.a("w", Integer.valueOf(an.a(an.this).getWidth())), e.a("h", Integer.valueOf(an.a(an.this).getHeight())) }));
          an.b(an.this).a(null, locala);
        }
      };
      this.e.a(ImageView.ScaleType.FIT_CENTER);
      localObject1 = this.i.G;
      localObject2 = this.i.b("video-click-button");
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
      localLayoutParams.leftMargin = Math.round(((Point)localObject2).x / ((j)localObject1).g());
      localLayoutParams.topMargin = Math.round(((Point)localObject2).y / ((j)localObject1).g());
      this.i.a(localLayoutParams, (j)localObject1, 1.0F);
      this.e.a((j)localObject1);
      this.c.addView(this.e, localLayoutParams);
      localObject1 = new RelativeLayout.LayoutParams(-1, Math.round(localLayoutParams.height + 10.0F * f1));
      ((RelativeLayout.LayoutParams)localObject1).addRule(10);
      this.b.addView(this.c, (ViewGroup.LayoutParams)localObject1);
    }
    this.d = new am(paramContext);
    this.d.setVisibility(8);
    localObject1 = new RelativeLayout.LayoutParams(-1, Math.round(32.5F * f1));
    ((RelativeLayout.LayoutParams)localObject1).addRule(12);
    this.b.addView(this.d, (ViewGroup.LayoutParams)localObject1);
    this.d.setGravity(16);
    this.d.setPadding(i1, i1, i1, i1);
    this.f = new TextView(paramContext);
    this.f.setTextColor(-1);
    this.f.setTextSize(2, 11.0F);
    this.f.setText(a);
    this.f.setPadding(0, 0, i1, 0);
    this.f.setSingleLine();
    this.f.measure(0, 0);
    i1 = this.f.getMeasuredWidth();
    this.f.setGravity(17);
    localObject1 = new LinearLayout.LayoutParams(i1, -1);
    this.d.addView(this.f, (ViewGroup.LayoutParams)localObject1);
    this.g = new aj(paramContext);
    this.g.setVisibility(8);
    paramContext = new LinearLayout.LayoutParams(-1, Math.round(10.0F * f1));
    paramContext.setMargins(0, CBUtility.a(1, getContext()), 0, 0);
    this.d.addView(this.g, paramContext);
    paramContext = new RelativeLayout.LayoutParams(-1, -1);
    paramContext.addRule(6, this.h.getId());
    paramContext.addRule(8, this.h.getId());
    paramContext.addRule(5, this.h.getId());
    paramContext.addRule(7, this.h.getId());
    addView(this.b, paramContext);
    a();
  }
  
  private void d(boolean paramBoolean)
  {
    if (!this.j) {}
    for (boolean bool = true;; bool = false)
    {
      a(bool, paramBoolean);
      return;
    }
  }
  
  public void a()
  {
    b(CBUtility.c().a());
  }
  
  public void a(int paramInt)
  {
    if (this.c != null) {
      this.c.setBackgroundColor(paramInt);
    }
    this.d.setBackgroundColor(paramInt);
  }
  
  public void a(String paramString)
  {
    this.h.a().a(this);
    this.h.a().a(this);
    this.h.a().a(this);
    this.h.a().a(Uri.parse(paramString));
  }
  
  public void a(boolean paramBoolean)
  {
    l.removeCallbacks(this.m);
    l.removeCallbacks(this.n);
    if (paramBoolean)
    {
      if ((!this.k) && (this.c != null)) {
        this.c.setVisibility(0);
      }
      if (this.i.K) {
        this.g.setVisibility(0);
      }
      this.d.setVisibility(0);
      if (this.e != null) {
        this.e.setEnabled(true);
      }
    }
    for (;;)
    {
      this.j = paramBoolean;
      return;
      if (this.c != null)
      {
        this.c.clearAnimation();
        this.c.setVisibility(8);
      }
      this.d.clearAnimation();
      if (this.i.K) {
        this.g.setVisibility(8);
      }
      this.d.setVisibility(8);
      if (this.e != null) {
        this.e.setEnabled(false);
      }
    }
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    l.removeCallbacks(this.m);
    l.removeCallbacks(this.n);
    if ((!this.i.w) || (!this.i.q())) {}
    while (paramBoolean1 == this.j) {
      return;
    }
    this.j = paramBoolean1;
    AlphaAnimation localAlphaAnimation;
    if (this.j)
    {
      localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
      if (!paramBoolean2) {
        break label209;
      }
    }
    label209:
    for (long l1 = 100L;; l1 = 200L)
    {
      localAlphaAnimation.setDuration(l1);
      localAlphaAnimation.setFillAfter(true);
      if ((!this.k) && (this.c != null))
      {
        this.c.setVisibility(0);
        this.c.startAnimation(localAlphaAnimation);
        if (this.e != null) {
          this.e.setEnabled(true);
        }
      }
      if (this.i.K) {
        this.g.setVisibility(0);
      }
      this.d.setVisibility(0);
      this.d.startAnimation(localAlphaAnimation);
      if (!this.j) {
        break label216;
      }
      l.postDelayed(this.m, 3000L);
      return;
      localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
      break;
    }
    label216:
    l.postDelayed(this.n, localAlphaAnimation.getDuration());
  }
  
  public bf.a b()
  {
    return this.h.a();
  }
  
  public void b(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i1 = -16777216;; i1 = 0)
    {
      setBackgroundColor(i1);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
      if (!paramBoolean)
      {
        localLayoutParams.addRule(6, this.h.getId());
        localLayoutParams.addRule(8, this.h.getId());
        localLayoutParams.addRule(5, this.h.getId());
        localLayoutParams.addRule(7, this.h.getId());
      }
      this.b.setLayoutParams(localLayoutParams);
      if (this.c != null)
      {
        this.c.setGravity(19);
        this.c.requestLayout();
      }
      return;
    }
  }
  
  public aj c()
  {
    return this.g;
  }
  
  public void c(boolean paramBoolean)
  {
    TextView localTextView = this.f;
    if (paramBoolean) {}
    for (int i1 = 0;; i1 = 8)
    {
      localTextView.setVisibility(i1);
      return;
    }
  }
  
  public void d()
  {
    if (this.c != null) {
      this.c.setVisibility(8);
    }
    this.k = true;
    if (this.e != null) {
      this.e.setEnabled(false);
    }
  }
  
  public void e()
  {
    l.postDelayed(new Runnable()
    {
      public void run()
      {
        an.f(an.this).setVisibility(0);
      }
    }, 500L);
    this.h.a().a();
    l.removeCallbacks(this.o);
    l.postDelayed(this.o, 16L);
  }
  
  public void f()
  {
    if (this.h.a().e())
    {
      this.i.u = this.h.a().d();
      this.h.a().b();
    }
    if (this.i.r().d.getVisibility() == 0) {
      this.i.r().d.postInvalidate();
    }
    l.removeCallbacks(this.o);
  }
  
  public void g()
  {
    if (this.h.a().e()) {
      this.i.u = this.h.a().d();
    }
    this.h.a().b();
    l.removeCallbacks(this.o);
  }
  
  public void h()
  {
    this.h.setVisibility(8);
    invalidate();
  }
  
  public boolean i()
  {
    return this.h.a().e();
  }
  
  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    this.i.u = this.h.a().c();
    if (this.i.r() != null) {
      this.i.r().f();
    }
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    l.removeCallbacks(this.o);
  }
  
  public boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    this.i.v();
    return false;
  }
  
  public void onPrepared(MediaPlayer paramMediaPlayer)
  {
    this.i.v = this.h.a().c();
    this.i.r().a(true);
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((this.h.a().e()) && (paramMotionEvent.getActionMasked() == 0))
    {
      if (this.i != null) {
        d(true);
      }
      return true;
    }
    return false;
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    super.setEnabled(paramBoolean);
    if (this.e != null) {
      this.e.setEnabled(paramBoolean);
    }
    if (paramBoolean) {
      a(false);
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/chartboost/sdk/impl/an.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */