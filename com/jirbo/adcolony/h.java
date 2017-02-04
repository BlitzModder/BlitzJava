package com.jirbo.adcolony;

import android.app.Activity;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout.LayoutParams;
import java.util.ArrayList;

class h
  extends View
{
  static double p;
  static String q = "";
  static String r = "";
  static boolean s = true;
  static Paint t = new Paint(1);
  static float[] u = new float[80];
  int A;
  int B;
  int C;
  int D;
  int E;
  String F;
  AdColonyV4VCAd G;
  ADCImage a;
  ADCImage b;
  ADCImage c;
  ADCImage d;
  ADCImage e;
  ADCImage f;
  ADCImage g;
  ADCImage h;
  double i = 2.8D;
  double j = 2.05D;
  double k = 1.3D;
  double l = 2.5D;
  double m = 1.5D;
  boolean n;
  ArrayList<ADCImage> o = new ArrayList();
  AdColonyInterstitialAd v;
  long w = System.currentTimeMillis();
  int x;
  int y;
  int z;
  
  h()
  {
    super(a.b());
  }
  
  public h(String paramString, int paramInt, AdColonyInterstitialAd paramAdColonyInterstitialAd)
  {
    super(AdColony.activity());
    this.F = paramString;
    this.E = paramInt;
    this.v = paramAdColonyInterstitialAd;
    if (!a()) {
      return;
    }
    AdColony.activity().addContentView(this, new FrameLayout.LayoutParams(-1, -1, 17));
  }
  
  int a(String paramString)
  {
    t.getTextWidths(paramString, u);
    float f1 = 0.0F;
    int i2 = paramString.length();
    int i1 = 0;
    while (i1 < i2)
    {
      f1 += u[i1];
      i1 += 1;
    }
    return (int)f1;
  }
  
  void a(String paramString, int paramInt1, int paramInt2, Canvas paramCanvas)
  {
    paramInt1 -= a(paramString) / 2;
    t.setColor(-986896);
    paramCanvas.drawText(paramString, paramInt1 + 1, paramInt2 + 1, t);
    t.setColor(-8355712);
    paramCanvas.drawText(paramString, paramInt1, paramInt2, t);
  }
  
  void a(String paramString1, String paramString2)
  {
    int i1 = a(paramString1);
    q = "";
    r = "";
    if (i1 > this.a.f - a("WW") - a(paramString2))
    {
      s = false;
      int i3 = 0;
      String str = "";
      for (i1 = 0; i1 < this.a.f - a("WW") - a(paramString2); i1 = a(str))
      {
        str = str + paramString1.charAt(i3);
        i3 += 1;
      }
      i1 = 0;
      int i2 = 0;
      while (i1 < i3) {
        if ((str.charAt(i1) == ' ') && (i1 >= 5))
        {
          q = paramString1.substring(0, i1);
          i2 = i1;
          i1 += 1;
        }
        else
        {
          if (i2 < 5) {}
          for (paramString2 = paramString1.substring(0, i3);; paramString2 = q)
          {
            q = paramString2;
            break;
          }
        }
      }
      if (i2 < 5) {}
      for (paramString1 = paramString1.substring(i3);; paramString1 = paramString1.substring(i2))
      {
        r = paramString1;
        return;
      }
    }
    s = true;
    q = paramString1;
    r = "";
  }
  
  public boolean a()
  {
    double d3 = 2.5D;
    double d2 = 0.8D;
    if (this.a != null) {
      return true;
    }
    this.a = new ADCImage(a.j("pre_popup_bg"));
    this.b = new ADCImage(a.j("v4vc_logo"));
    this.c = new ADCImage(a.j("yes_button_normal"));
    this.d = new ADCImage(a.j("yes_button_down"));
    this.e = new ADCImage(a.j("no_button_normal"));
    this.f = new ADCImage(a.j("no_button_down"));
    this.h = new ADCImage(a.j("done_button_normal"));
    this.g = new ADCImage(a.j("done_button_down"));
    this.o.add(this.a);
    this.o.add(this.b);
    this.o.add(this.c);
    this.o.add(this.d);
    this.o.add(this.e);
    this.o.add(this.f);
    this.o.add(this.h);
    this.o.add(this.g);
    if (a.b() == null) {
      return false;
    }
    Display localDisplay = a.b().getWindowManager().getDefaultDisplay();
    int i1 = localDisplay.getWidth();
    int i2 = localDisplay.getHeight();
    double d1;
    if (i2 > i1)
    {
      d1 = (i2 - i1) / 360.0D;
      if ((d1 < 0.8D) && (!a.m)) {
        this.n = true;
      }
      if (d1 <= 2.5D) {
        break label545;
      }
      d1 = d3;
    }
    label545:
    for (;;)
    {
      if (d1 < 0.8D) {
        if (a.m) {
          d1 = d2;
        }
      }
      for (;;)
      {
        p = d1;
        if (this.n)
        {
          this.i = 2.6D;
          this.j = 1.8D;
          this.k = 1.0D;
          this.l = 2.2D;
          this.m = 1.2D;
        }
        this.a.a(d1 / 1.8D);
        this.b.a(d1 / 1.8D);
        this.d.a(d1 / 1.8D);
        this.f.a(d1 / 1.8D);
        this.c.a(d1 / 1.8D);
        this.e.a(d1 / 1.8D);
        this.g.a(d1 / 1.8D);
        this.h.a(d1 / 1.8D);
        t.setTextSize((float)(18.0D * d1));
        if (this.n) {
          t.setTextSize((float)(d1 * 9.0D));
        }
        t.setFakeBoldText(true);
        return true;
        d1 = (i1 - i2) / 360.0D;
        break;
        d1 = 1.7D;
      }
    }
  }
  
  boolean a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramInt1 < paramInt3) {}
    while ((paramInt2 < paramInt4) || (paramInt1 >= this.c.f + paramInt3) || (paramInt2 >= this.c.g + paramInt4)) {
      return false;
    }
    return true;
  }
  
  int b()
  {
    return (int)t.getTextSize();
  }
  
  void b(String paramString, int paramInt1, int paramInt2, Canvas paramCanvas)
  {
    paramInt1 -= a(paramString) / 2;
    t.setColor(-8355712);
    paramCanvas.drawText(paramString, paramInt1 + 2, paramInt2 + 2, t);
    t.setColor(-1);
    paramCanvas.drawText(paramString, paramInt1, paramInt2, t);
  }
  
  ViewGroup c()
  {
    return (ViewGroup)getParent();
  }
  
  void c(String paramString, int paramInt1, int paramInt2, Canvas paramCanvas)
  {
    b(paramString, this.c.f / 2 + paramInt1, this.c.g / 2 + paramInt2 + b() * 4 / 10, paramCanvas);
  }
  
  void d()
  {
    if (this.n) {}
    for (double d1 = 12.0D;; d1 = 16.0D)
    {
      if (a.b() != null)
      {
        Display localDisplay = a.b().getWindowManager().getDefaultDisplay();
        int i1 = localDisplay.getWidth();
        int i2 = localDisplay.getHeight();
        this.x = ((i1 - this.a.f) / 2);
        this.y = ((i2 - this.a.g) / 2 - 80);
        this.z = (this.x + this.a.f / 2);
        this.A = (this.y + this.a.g / 2);
        this.D = (this.y + (int)(this.a.g - (this.c.g + p * d1)));
        this.B = (this.x + (int)(p * d1));
        i1 = this.x;
        double d2 = this.a.f;
        double d3 = this.c.f;
        this.C = ((int)(d2 - (d1 * p + d3)) + i1);
      }
      return;
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/jirbo/adcolony/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */