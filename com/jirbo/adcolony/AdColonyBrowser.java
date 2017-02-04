package com.jirbo.adcolony;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.webkit.GeolocationPermissions.Callback;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class AdColonyBrowser
  extends Activity
{
  static boolean A = false;
  static boolean B = false;
  static boolean C = false;
  static boolean a = true;
  public static String url;
  static boolean v = false;
  static boolean w = false;
  static boolean x = false;
  static boolean y = false;
  static boolean z = true;
  WebView b;
  ADCImage c;
  ADCImage d;
  ADCImage e;
  ADCImage f;
  ADCImage g;
  ADCImage h;
  ADCImage i;
  ADCImage j;
  ADCImage k;
  RelativeLayout l;
  RelativeLayout m;
  boolean n = false;
  boolean o = false;
  boolean p = false;
  boolean q = false;
  ProgressBar r;
  DisplayMetrics s;
  a t;
  c u;
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    paramConfiguration = new RelativeLayout.LayoutParams(-2, this.s.heightPixels - (int)(1.5D * this.g.g));
    paramConfiguration.addRule(3, this.l.getId());
    this.b.setLayoutParams(paramConfiguration);
    z = true;
    this.t.invalidate();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    B = true;
    this.c = new ADCImage(a.j("browser_back_image_normal"));
    this.d = new ADCImage(a.j("browser_stop_image_normal"));
    this.e = new ADCImage(a.j("browser_reload_image_normal"));
    this.f = new ADCImage(a.j("browser_forward_image_normal"));
    this.g = new ADCImage(a.j("browser_close_image_normal"));
    this.h = new ADCImage(a.j("browser_glow_button"));
    this.i = new ADCImage(a.j("browser_icon"));
    this.j = new ADCImage(a.j("browser_back_image_normal"), true);
    this.k = new ADCImage(a.j("browser_forward_image_normal"), true);
    this.s = AdColony.activity().getResources().getDisplayMetrics();
    float f1 = this.s.widthPixels / this.s.xdpi;
    float f2 = this.s.heightPixels / this.s.ydpi;
    double d1 = Math.sqrt(f1 * f1 + f2 * f2);
    double d2 = Math.sqrt(this.s.widthPixels * this.s.widthPixels + this.s.heightPixels * this.s.heightPixels) / d1 / 220.0D;
    d1 = d2;
    if (d2 > 1.8D) {
      d1 = 1.8D;
    }
    z = true;
    v = false;
    w = false;
    C = false;
    this.c.a(d1);
    this.d.a(d1);
    this.e.a(d1);
    this.f.a(d1);
    this.g.a(d1);
    this.h.a(d1);
    this.j.a(d1);
    this.k.a(d1);
    this.r = new ProgressBar(this);
    this.r.setVisibility(4);
    this.m = new RelativeLayout(this);
    this.l = new RelativeLayout(this);
    this.l.setBackgroundColor(-3355444);
    if (!a.m)
    {
      this.l.setLayoutParams(new RelativeLayout.LayoutParams(-1, (int)(this.c.g * 1.5D)));
      requestWindowFeature(1);
      getWindow().setFlags(1024, 1024);
      getWindow().requestFeature(2);
      setVolumeControlStream(3);
      this.b = new WebView(this);
      this.b.getSettings().setJavaScriptEnabled(true);
      this.b.getSettings().setBuiltInZoomControls(true);
      this.b.getSettings().setUseWideViewPort(true);
      this.b.getSettings().setLoadWithOverviewMode(true);
      this.b.getSettings().setGeolocationEnabled(true);
      if (a)
      {
        if (a.m) {
          break label949;
        }
        if (Build.VERSION.SDK_INT < 10) {
          break label941;
        }
        setRequestedOrientation(6);
      }
      label572:
      a = true;
      this.b.setWebChromeClient(new WebChromeClient()
      {
        public void onGeolocationPermissionsShowPrompt(String paramAnonymousString, GeolocationPermissions.Callback paramAnonymousCallback)
        {
          paramAnonymousCallback.invoke(paramAnonymousString, true, false);
        }
        
        public void onProgressChanged(WebView paramAnonymousWebView, int paramAnonymousInt)
        {
          AdColonyBrowser.this.setProgress(paramAnonymousInt * 1000);
        }
      });
      this.b.setWebViewClient(new WebViewClient()
      {
        public void onPageFinished(WebView paramAnonymousWebView, String paramAnonymousString)
        {
          if (!AdColonyBrowser.C)
          {
            AdColonyBrowser.y = true;
            AdColonyBrowser.x = false;
            AdColonyBrowser.this.r.setVisibility(4);
            AdColonyBrowser.v = AdColonyBrowser.this.b.canGoBack();
            AdColonyBrowser.w = AdColonyBrowser.this.b.canGoForward();
          }
          AdColonyBrowser.this.t.invalidate();
        }
        
        public void onPageStarted(WebView paramAnonymousWebView, String paramAnonymousString, Bitmap paramAnonymousBitmap)
        {
          if (!AdColonyBrowser.C)
          {
            AdColonyBrowser.x = true;
            AdColonyBrowser.y = false;
            AdColonyBrowser.this.r.setVisibility(0);
          }
          AdColonyBrowser.this.t.invalidate();
        }
        
        public void onReceivedError(WebView paramAnonymousWebView, int paramAnonymousInt, String paramAnonymousString1, String paramAnonymousString2)
        {
          l.d.a("Error viewing URL: ").b(paramAnonymousString1);
          AdColonyBrowser.this.finish();
        }
        
        public boolean shouldOverrideUrlLoading(WebView paramAnonymousWebView, String paramAnonymousString)
        {
          if ((paramAnonymousString.startsWith("market://")) || (paramAnonymousString.startsWith("amzn://")))
          {
            paramAnonymousWebView = new Intent("android.intent.action.VIEW", Uri.parse(paramAnonymousString));
            if (a.U != null) {
              a.U.startActivity(paramAnonymousWebView);
            }
            return true;
          }
          return false;
        }
      });
      this.t = new a(this);
      this.u = new c(this);
      this.m.setBackgroundColor(16777215);
      this.m.addView(this.l);
      this.l.setId(12345);
      paramBundle = new RelativeLayout.LayoutParams(-2, this.s.heightPixels - (int)(this.g.g * 1.5D));
      paramBundle.addRule(3, this.l.getId());
      this.m.addView(this.b, paramBundle);
      paramBundle = new RelativeLayout.LayoutParams(-2, 20);
      paramBundle.addRule(3, this.l.getId());
      paramBundle.setMargins(0, -10, 0, 0);
      this.m.addView(this.u, paramBundle);
      if (this.s.widthPixels <= this.s.heightPixels) {
        break label959;
      }
    }
    label941:
    label949:
    label959:
    for (int i1 = this.s.widthPixels;; i1 = this.s.heightPixels)
    {
      this.m.addView(this.t, new RelativeLayout.LayoutParams(i1 * 2, i1 * 2));
      paramBundle = new RelativeLayout.LayoutParams(-2, this.s.heightPixels - (int)(this.g.g * 1.5D));
      paramBundle.addRule(3, this.l.getId());
      this.m.addView(new b(this), paramBundle);
      setContentView(this.m);
      this.b.loadUrl(url);
      l.c.a("Viewing ").b(url);
      return;
      this.l.setLayoutParams(new RelativeLayout.LayoutParams(-1, (int)(this.c.g * 1.5D)));
      break;
      setRequestedOrientation(0);
      break label572;
      setRequestedOrientation(a.F);
      break label572;
    }
  }
  
  public void onDestroy()
  {
    if ((!a.D) && (A == true))
    {
      int i1 = 0;
      while (i1 < a.an.size())
      {
        ((Bitmap)a.an.get(i1)).recycle();
        i1 += 1;
      }
      a.an.clear();
    }
    A = false;
    B = false;
    super.onDestroy();
  }
  
  public void onPause()
  {
    super.onPause();
    this.t.b();
  }
  
  public void onResume()
  {
    super.onResume();
    z = true;
    this.t.invalidate();
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
  }
  
  class a
    extends View
  {
    Rect a = new Rect();
    Paint b = new Paint();
    
    public a(Activity paramActivity)
    {
      super();
    }
    
    public void a()
    {
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(AdColonyBrowser.this.r.getWidth(), AdColonyBrowser.this.r.getHeight());
      localLayoutParams.topMargin = ((AdColonyBrowser.this.l.getHeight() - AdColonyBrowser.this.d.g) / 2);
      localLayoutParams.leftMargin = (AdColonyBrowser.this.l.getWidth() / 10 + AdColonyBrowser.this.d.c() + AdColonyBrowser.this.d.f);
      if ((AdColonyBrowser.z) && (AdColonyBrowser.this.d.c() != 0))
      {
        AdColonyBrowser.this.m.removeView(AdColonyBrowser.this.r);
        AdColonyBrowser.this.m.addView(AdColonyBrowser.this.r, localLayoutParams);
        AdColonyBrowser.z = false;
      }
      if (AdColonyBrowser.this.r.getLayoutParams() == null) {
        return;
      }
      AdColonyBrowser.this.r.getLayoutParams().height = AdColonyBrowser.this.d.g;
      AdColonyBrowser.this.r.getLayoutParams().width = AdColonyBrowser.this.d.f;
    }
    
    public boolean a(ADCImage paramADCImage, int paramInt1, int paramInt2)
    {
      return (paramInt1 < paramADCImage.c() + paramADCImage.f + 16) && (paramInt1 > paramADCImage.c() - 16) && (paramInt2 < paramADCImage.d() + paramADCImage.g + 16) && (paramInt2 > paramADCImage.d() - 16);
    }
    
    public void b()
    {
      AdColonyBrowser.this.n = false;
      AdColonyBrowser.this.o = false;
      AdColonyBrowser.this.p = false;
      AdColonyBrowser.this.q = false;
      invalidate();
    }
    
    public void onDraw(Canvas paramCanvas)
    {
      getDrawingRect(this.a);
      int i = (AdColonyBrowser.this.l.getHeight() - AdColonyBrowser.this.c.g) / 2;
      if (!AdColonyBrowser.v)
      {
        AdColonyBrowser.this.c.a(paramCanvas, AdColonyBrowser.this.c.f, i);
        if (AdColonyBrowser.w) {
          break label643;
        }
        AdColonyBrowser.this.f.a(paramCanvas, AdColonyBrowser.this.c.c() + AdColonyBrowser.this.l.getWidth() / 10 + AdColonyBrowser.this.c.f, i);
        label113:
        if (!AdColonyBrowser.x) {
          break label693;
        }
        AdColonyBrowser.this.d.a(paramCanvas, AdColonyBrowser.this.f.c() + AdColonyBrowser.this.f.f + AdColonyBrowser.this.l.getWidth() / 10, i);
      }
      for (;;)
      {
        AdColonyBrowser.this.g.a(paramCanvas, AdColonyBrowser.this.l.getWidth() - AdColonyBrowser.this.g.f * 2, i);
        if (AdColonyBrowser.this.n)
        {
          AdColonyBrowser.this.h.c(AdColonyBrowser.this.c.c() - AdColonyBrowser.this.h.f / 2 + AdColonyBrowser.this.c.f / 2, AdColonyBrowser.this.c.d() - AdColonyBrowser.this.h.g / 2 + AdColonyBrowser.this.c.g / 2);
          AdColonyBrowser.this.h.a(paramCanvas);
        }
        if (AdColonyBrowser.this.o)
        {
          AdColonyBrowser.this.h.c(AdColonyBrowser.this.f.c() - AdColonyBrowser.this.h.f / 2 + AdColonyBrowser.this.f.f / 2, AdColonyBrowser.this.f.d() - AdColonyBrowser.this.h.g / 2 + AdColonyBrowser.this.f.g / 2);
          AdColonyBrowser.this.h.a(paramCanvas);
        }
        if (AdColonyBrowser.this.p)
        {
          AdColonyBrowser.this.h.c(AdColonyBrowser.this.e.c() - AdColonyBrowser.this.h.f / 2 + AdColonyBrowser.this.e.f / 2, AdColonyBrowser.this.e.d() - AdColonyBrowser.this.h.g / 2 + AdColonyBrowser.this.e.g / 2);
          AdColonyBrowser.this.h.a(paramCanvas);
        }
        if (AdColonyBrowser.this.q)
        {
          AdColonyBrowser.this.h.c(AdColonyBrowser.this.g.c() - AdColonyBrowser.this.h.f / 2 + AdColonyBrowser.this.g.f / 2, AdColonyBrowser.this.g.d() - AdColonyBrowser.this.h.g / 2 + AdColonyBrowser.this.g.g / 2);
          AdColonyBrowser.this.h.a(paramCanvas);
        }
        a();
        return;
        AdColonyBrowser.this.j.a(paramCanvas, AdColonyBrowser.this.c.f, i);
        break;
        label643:
        AdColonyBrowser.this.k.a(paramCanvas, AdColonyBrowser.this.c.c() + AdColonyBrowser.this.l.getWidth() / 10 + AdColonyBrowser.this.c.f, i);
        break label113;
        label693:
        AdColonyBrowser.this.e.a(paramCanvas, AdColonyBrowser.this.f.c() + AdColonyBrowser.this.f.f + AdColonyBrowser.this.l.getWidth() / 10, i);
      }
    }
    
    public boolean onTouchEvent(MotionEvent paramMotionEvent)
    {
      int i = paramMotionEvent.getAction();
      int j = (int)paramMotionEvent.getX();
      int k = (int)paramMotionEvent.getY();
      if (i == 0)
      {
        if ((a(AdColonyBrowser.this.c, j, k)) && (AdColonyBrowser.v))
        {
          AdColonyBrowser.this.n = true;
          invalidate();
          return true;
        }
        if ((a(AdColonyBrowser.this.f, j, k)) && (AdColonyBrowser.w))
        {
          AdColonyBrowser.this.o = true;
          invalidate();
          return true;
        }
        if (a(AdColonyBrowser.this.e, j, k))
        {
          AdColonyBrowser.this.p = true;
          invalidate();
          return true;
        }
        if (a(AdColonyBrowser.this.g, j, k))
        {
          AdColonyBrowser.this.q = true;
          invalidate();
          return true;
        }
      }
      if (i == 1)
      {
        if ((a(AdColonyBrowser.this.c, j, k)) && (AdColonyBrowser.v))
        {
          AdColonyBrowser.this.b.goBack();
          b();
          return true;
        }
        if ((a(AdColonyBrowser.this.f, j, k)) && (AdColonyBrowser.w))
        {
          AdColonyBrowser.this.b.goForward();
          b();
          return true;
        }
        if ((a(AdColonyBrowser.this.e, j, k)) && (AdColonyBrowser.x))
        {
          AdColonyBrowser.this.b.stopLoading();
          b();
          return true;
        }
        if ((a(AdColonyBrowser.this.e, j, k)) && (!AdColonyBrowser.x))
        {
          AdColonyBrowser.this.b.reload();
          b();
          return true;
        }
        if (a(AdColonyBrowser.this.g, j, k))
        {
          AdColonyBrowser.C = true;
          AdColonyBrowser.this.b.loadData("", "text/html", "utf-8");
          AdColonyBrowser.w = false;
          AdColonyBrowser.v = false;
          AdColonyBrowser.x = false;
          b();
          AdColonyBrowser.this.finish();
          return true;
        }
        b();
      }
      return false;
    }
  }
  
  class b
    extends View
  {
    Rect a = new Rect();
    
    public b(Activity paramActivity)
    {
      super();
    }
    
    public void onDraw(Canvas paramCanvas)
    {
      if (!AdColonyBrowser.y)
      {
        paramCanvas.drawARGB(255, 0, 0, 0);
        getDrawingRect(this.a);
        AdColonyBrowser.this.i.a(paramCanvas, (this.a.width() - AdColonyBrowser.this.i.f) / 2, (this.a.height() - AdColonyBrowser.this.i.g) / 2);
        invalidate();
      }
    }
  }
  
  class c
    extends View
  {
    Paint a = new Paint();
    ADCImage b = new ADCImage(a.j("close_image_normal"));
    ADCImage c = new ADCImage(a.j("close_image_down"));
    
    public c(Activity paramActivity)
    {
      super();
      try
      {
        getClass().getMethod("setLayerType", new Class[] { Integer.TYPE, Paint.class }).invoke(this, new Object[] { Integer.valueOf(1), null });
        this.a.setColor(-3355444);
        this.a.setStrokeWidth(10.0F);
        this.a.setStyle(Paint.Style.STROKE);
        this.a.setShadowLayer(3.0F, 0.0F, 1.0F, -16777216);
        return;
      }
      catch (Exception this$1)
      {
        for (;;) {}
      }
    }
    
    public void onDraw(Canvas paramCanvas)
    {
      paramCanvas.drawRect(0.0F, 0.0F, AdColonyBrowser.this.l.getWidth(), 10.0F, this.a);
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/jirbo/adcolony/AdColonyBrowser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */