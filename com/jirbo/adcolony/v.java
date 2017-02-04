package com.jirbo.adcolony;

import android.graphics.Canvas;
import android.view.KeyEvent;
import android.view.MotionEvent;

class v
  extends h
{
  static boolean H;
  static v I;
  boolean J;
  boolean K;
  ADCVideo L;
  
  public v(ADCVideo paramADCVideo, AdColonyV4VCAd paramAdColonyV4VCAd)
  {
    this.L = paramADCVideo;
    this.G = paramAdColonyV4VCAd;
    paramADCVideo.G.pause();
    I = this;
    if (!a()) {}
  }
  
  void d()
  {
    int i = this.L.t;
    int j = this.L.u;
    this.x = ((i - this.a.f) / 2);
    this.y = ((j - this.a.g) / 2);
    this.z = (this.x + this.a.f / 2);
    this.A = (this.y + this.a.g / 2);
    this.D = (this.y + (int)(this.a.g - (this.c.g + p * 16.0D)));
    this.B = (this.x + (int)(p * 16.0D));
    this.C = (this.x + (int)(this.a.f - (this.c.f + p * 16.0D)));
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    int i = 128;
    if (this.L.G == null) {
      return;
    }
    H = true;
    d();
    int j = (int)(System.currentTimeMillis() - this.w) * 255 / 1000;
    if (j > 128) {}
    for (;;)
    {
      paramCanvas.drawARGB(i, 0, 0, 0);
      this.a.a(paramCanvas, this.x, this.y);
      i = b() * 3 / 2;
      a("Completion is required to receive", this.z, (int)(this.A - i * 2.75D), paramCanvas);
      a("your reward.", this.z, this.A - i * 2, paramCanvas);
      a("Are you sure you want to skip?", this.z, (int)(this.A - i * 1.25D), paramCanvas);
      this.b.a(paramCanvas, this.z - this.b.f / 2, this.A - this.b.g / 2);
      if (!this.J)
      {
        this.c.a(paramCanvas, this.B, this.D);
        if (this.K) {
          break label280;
        }
        this.e.a(paramCanvas, this.C, this.D);
      }
      for (;;)
      {
        c("Yes", this.B, this.D, paramCanvas);
        c("No", this.C, this.D, paramCanvas);
        return;
        this.d.a(paramCanvas, this.B, this.D);
        break;
        label280:
        this.f.a(paramCanvas, this.C, this.D);
      }
      i = j;
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (this.L.G == null) {}
    while (paramInt != 4) {
      return false;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      I = null;
      this.L.G.start();
      return true;
    }
    return false;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool2 = true;
    ADCVideo localADCVideo = this.L;
    boolean bool1;
    if (ADCVideo.d)
    {
      I = null;
      bool1 = this.L.H.onTouchEvent(paramMotionEvent);
    }
    int i;
    int j;
    label181:
    label226:
    do
    {
      return bool1;
      i = (int)paramMotionEvent.getX();
      j = (int)paramMotionEvent.getY();
      if (paramMotionEvent.getAction() == 1)
      {
        if ((!a(i, j, this.B, this.D)) || (!this.J)) {
          break label181;
        }
        I = null;
        H = false;
        a.D = false;
        a.ak = true;
        a.W.b(this.G);
        AdColonyBrowser.A = true;
        this.L.finish();
        a.E = true;
        this.L.I = null;
      }
      for (;;)
      {
        this.J = false;
        this.K = false;
        invalidate();
        bool1 = bool2;
        if (paramMotionEvent.getAction() != 0) {
          break;
        }
        if (!a(i, j, this.B, this.D)) {
          break label226;
        }
        this.J = true;
        invalidate();
        return true;
        if ((a(i, j, this.C, this.D)) && (this.K))
        {
          I = null;
          H = false;
          this.L.G.start();
        }
      }
      bool1 = bool2;
    } while (!a(i, j, this.C, this.D));
    this.K = true;
    invalidate();
    return true;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/jirbo/adcolony/v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */