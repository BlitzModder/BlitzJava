package com.jirbo.adcolony;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import java.util.ArrayList;

class ab
  extends h
{
  boolean H;
  boolean I;
  boolean J = true;
  
  public ab(String paramString, AdColonyV4VCAd paramAdColonyV4VCAd)
  {
    this.F = paramString;
    this.G = paramAdColonyV4VCAd;
    if (!a()) {}
    do
    {
      return;
      AdColony.activity().addContentView(this, new FrameLayout.LayoutParams(-1, -1, 17));
    } while (!this.n);
    this.D += 20;
  }
  
  protected void onDetachedFromWindow()
  {
    if (this.J)
    {
      a.S = null;
      this.J = false;
      this.G.c(false);
      a.E = true;
      int i = 0;
      while (i < a.an.size())
      {
        ((Bitmap)a.an.get(i)).recycle();
        i += 1;
      }
      a.an.clear();
    }
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    d();
    int j = (int)(System.currentTimeMillis() - this.w) * 255 / 1000;
    int i = j;
    if (j > 128) {
      i = 128;
    }
    paramCanvas.drawARGB(i, 0, 0, 0);
    this.a.a(paramCanvas, this.x, this.y);
    j = b() * 3 / 2;
    int k = this.G.getRemainingViewsUntilReward();
    if ((this.G.getViewsPerReward() == 1) || (this.G.getViewsPerReward() == 0))
    {
      a(this.F, "");
      if (!s)
      {
        a("Watch a video to earn", this.z, (int)(this.A - j * this.i), paramCanvas);
        a(q, this.z, (int)(this.A - j * this.j), paramCanvas);
        a(r + ".", this.z, (int)(this.A - j * this.k), paramCanvas);
        this.b.a(paramCanvas, this.z - this.b.f / 2, this.A - this.b.g / 2);
        if (this.I) {
          break label704;
        }
        this.c.a(paramCanvas, this.B, this.D);
        label268:
        if (this.H) {
          break label723;
        }
        this.e.a(paramCanvas, this.C, this.D);
      }
    }
    for (;;)
    {
      c("Yes", this.B, this.D, paramCanvas);
      c("No", this.C, this.D, paramCanvas);
      if (i != 128) {
        invalidate();
      }
      return;
      a("Watch a video to earn", this.z, (int)(this.A - j * this.l), paramCanvas);
      a(q + ".", this.z, (int)(this.A - j * this.m), paramCanvas);
      break;
      if (k == 1) {}
      for (String str = "video";; str = "videos")
      {
        a(this.F, "" + k + " more " + str + " to earn )?");
        if (s) {
          break label607;
        }
        a("Watch a sponsored video now (Only", this.z, (int)(this.A - j * this.i), paramCanvas);
        a("" + k + " more " + str + " to earn " + q, this.z, (int)(this.A - j * this.j), paramCanvas);
        a(r + ")?", this.z, (int)(this.A - j * this.k), paramCanvas);
        break;
      }
      label607:
      a("Watch a sponsored video now (Only", this.z, (int)(this.A - j * this.l), paramCanvas);
      a("" + k + " more " + str + " to earn " + q + ")?", this.z, (int)(this.A - j * this.m), paramCanvas);
      break;
      label704:
      this.d.a(paramCanvas, this.B, this.D);
      break label268;
      label723:
      this.f.a(paramCanvas, this.C, this.D);
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int j = (int)paramMotionEvent.getX();
    int k = (int)paramMotionEvent.getY();
    if (paramMotionEvent.getAction() == 1)
    {
      if ((a(j, k, this.B, this.D)) && (this.I))
      {
        a.S = null;
        this.J = false;
        ((ViewGroup)getParent()).removeView(this);
        this.G.c(true);
        this.H = false;
        this.I = false;
        invalidate();
      }
    }
    else if (paramMotionEvent.getAction() == 0)
    {
      if (!a(j, k, this.B, this.D)) {
        break label222;
      }
      this.I = true;
      invalidate();
    }
    label222:
    while (!a(j, k, this.C, this.D))
    {
      return true;
      if ((!a(j, k, this.C, this.D)) || (!this.H)) {
        break;
      }
      a.S = null;
      this.J = false;
      ((ViewGroup)getParent()).removeView(this);
      this.G.c(false);
      a.E = true;
      int i = 0;
      while (i < a.an.size())
      {
        ((Bitmap)a.an.get(i)).recycle();
        i += 1;
      }
      a.an.clear();
      break;
    }
    this.H = true;
    invalidate();
    return true;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/jirbo/adcolony/ab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */