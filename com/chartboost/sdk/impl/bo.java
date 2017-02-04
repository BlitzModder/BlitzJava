package com.chartboost.sdk.impl;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.chartboost.sdk.Model.a;
import com.chartboost.sdk.Model.a.b;
import com.chartboost.sdk.g.a;

public final class bo
  extends RelativeLayout
{
  private g.a a;
  private bh b;
  private bh c;
  private bn d;
  private a e = null;
  
  public bo(Context paramContext, a parama)
  {
    super(paramContext);
    this.e = parama;
    if (parama.a == a.b.a)
    {
      this.b = new bh(paramContext);
      addView(this.b, new RelativeLayout.LayoutParams(-1, -1));
      this.c = new bh(paramContext);
      addView(this.c, new RelativeLayout.LayoutParams(-1, -1));
      this.c.setVisibility(8);
    }
  }
  
  public void a()
  {
    if (this.a == null)
    {
      this.a = this.e.m();
      if (this.a != null)
      {
        addView(this.a, new RelativeLayout.LayoutParams(-1, -1));
        this.a.a();
      }
    }
    c();
  }
  
  public void b()
  {
    int i;
    if (!this.e.n)
    {
      i = 1;
      this.e.n = true;
      if (this.d != null) {
        break label122;
      }
      this.d = new bn(getContext());
      this.d.setVisibility(8);
      addView(this.d, new RelativeLayout.LayoutParams(-1, -1));
    }
    for (;;)
    {
      if (!g())
      {
        this.d.setVisibility(0);
        if (i != 0)
        {
          if ((this.c != null) && (this.b != null)) {
            e().a();
          }
          bg.a(true, this.d);
        }
      }
      return;
      i = 0;
      break;
      label122:
      if ((this.c != null) && (this.b != null))
      {
        this.c.bringToFront();
        this.c.setVisibility(0);
        this.c.a();
        bg.a(false, this.b);
      }
      this.d.bringToFront();
      this.d.a();
    }
  }
  
  public void c()
  {
    if (this.d != null)
    {
      this.d.clearAnimation();
      this.d.setVisibility(8);
    }
  }
  
  public void d() {}
  
  public bh e()
  {
    return this.b;
  }
  
  public View f()
  {
    return this.a;
  }
  
  public boolean g()
  {
    return (this.d != null) && (this.d.getVisibility() == 0);
  }
  
  public a h()
  {
    return this.e;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    return true;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/chartboost/sdk/impl/bo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */