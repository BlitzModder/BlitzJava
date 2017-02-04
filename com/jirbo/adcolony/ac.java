package com.jirbo.adcolony;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.view.Display;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout.LayoutParams;
import java.util.ArrayList;

class ac
  extends h
{
  boolean H;
  
  public ac(String paramString, AdColonyV4VCAd paramAdColonyV4VCAd)
  {
    this.F = paramString;
    this.G = paramAdColonyV4VCAd;
    if (!a()) {
      return;
    }
    AdColony.activity().addContentView(this, new FrameLayout.LayoutParams(-1, -1, 17));
  }
  
  void d()
  {
    int i;
    int j;
    if (a.b() != null)
    {
      Display localDisplay = a.b().getWindowManager().getDefaultDisplay();
      i = localDisplay.getWidth();
      j = localDisplay.getHeight();
      if (!this.n) {
        break label177;
      }
    }
    label177:
    for (double d1 = 12.0D;; d1 = 16.0D)
    {
      this.x = ((i - this.a.f) / 2);
      this.y = ((j - this.a.g) / 2 - 80);
      this.z = (this.x + this.a.f / 2);
      this.A = (this.y + this.a.g / 2);
      i = this.y;
      double d2 = this.a.g;
      double d3 = this.h.g;
      this.D = ((int)(d2 - (d1 * p + d3)) + i);
      this.B = (this.z - this.h.f / 2);
      return;
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
    if ((k == this.G.getViewsPerReward()) || (k == 0))
    {
      a(this.F, "video. You earned");
      if (s)
      {
        a("Thanks for watching the sponsored", this.z, (int)(this.A - j * 2.5D), paramCanvas);
        a("video. You earned " + q + ".", this.z, (int)(this.A - j * 1.5D), paramCanvas);
        this.b.a(paramCanvas, this.z - this.b.f / 2, this.A - this.b.g / 2);
        if (this.H) {
          break label658;
        }
        this.h.a(paramCanvas, this.B, this.D);
      }
    }
    for (;;)
    {
      c("Ok", this.B, this.D, paramCanvas);
      if (i != 128) {
        invalidate();
      }
      return;
      a("Thanks for watching the sponsored", this.z, (int)(this.A - j * 2.8D), paramCanvas);
      a("video. You earned " + q, this.z, (int)(this.A - j * 2.05D), paramCanvas);
      a(r + ".", this.z, (int)(this.A - j * 1.3D), paramCanvas);
      break;
      a(this.F, "to earn ");
      if (k == 1) {}
      for (String str = "video";; str = "videos")
      {
        if (!s) {
          break label517;
        }
        a("Thank you. Watch " + k + " more " + str, this.z, (int)(this.A - j * 2.5D), paramCanvas);
        a("to earn " + q + ".", this.z, (int)(this.A - j * 1.5D), paramCanvas);
        break;
      }
      label517:
      a("Thank you. Watch " + k + " more " + str, this.z, (int)(this.A - j * 2.8D), paramCanvas);
      a("to earn " + q, this.z, (int)(this.A - j * 2.05D), paramCanvas);
      a(r + ".", this.z, (int)(this.A - j * 1.3D), paramCanvas);
      break;
      label658:
      this.g.a(paramCanvas, this.B, this.D);
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int j = (int)paramMotionEvent.getX();
    int k = (int)paramMotionEvent.getY();
    if (paramMotionEvent.getAction() == 1)
    {
      if ((a(j, k, this.B, this.D)) && (this.H))
      {
        a.S = null;
        ((ViewGroup)getParent()).removeView(this);
        int i = 0;
        while (i < a.an.size())
        {
          ((Bitmap)a.an.get(i)).recycle();
          i += 1;
        }
        a.an.clear();
        a.E = true;
      }
      this.H = false;
      invalidate();
    }
    if ((paramMotionEvent.getAction() == 0) && (a(j, k, this.B, this.D)))
    {
      this.H = true;
      invalidate();
    }
    return true;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/jirbo/adcolony/ac.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */