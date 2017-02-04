package com.chartboost.sdk.impl;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Handler;
import android.text.TextUtils;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.chartboost.sdk.Libraries.CBLogging;
import com.chartboost.sdk.Libraries.CBUtility;
import com.chartboost.sdk.Libraries.e.a;
import com.chartboost.sdk.Libraries.h;
import com.chartboost.sdk.Model.CBError.CBImpressionError;
import com.chartboost.sdk.b;
import com.chartboost.sdk.c;
import com.chartboost.sdk.e;
import com.chartboost.sdk.f;
import com.chartboost.sdk.g;
import com.chartboost.sdk.g.a;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

public final class bs
  extends g
{
  private static boolean v = false;
  public String l = "UNKNOWN";
  protected int m = 1;
  private String n = null;
  private String o = null;
  private e.a p;
  private float q = 0.0F;
  private float r = 0.0F;
  private boolean s = false;
  private long t = 0L;
  private long u = 0L;
  private b w = b.a;
  
  public bs(com.chartboost.sdk.Model.a parama)
  {
    super(parama);
  }
  
  public void a(float paramFloat)
  {
    this.r = paramFloat;
  }
  
  public void a(b paramb)
  {
    this.w = paramb;
  }
  
  public boolean a(e.a parama)
  {
    File localFile = h.a();
    this.p = parama.a("events");
    if (localFile == null)
    {
      CBLogging.b("CBWebViewProtocol", "External Storage path is unavailable or media not mounted");
      a(CBError.CBImpressionError.ERROR_LOADING_WEB_VIEW);
      return false;
    }
    this.o = ("file://" + localFile.getAbsolutePath() + "/");
    if (TextUtils.isEmpty(this.g.i))
    {
      CBLogging.b("CBWebViewProtocol", "Invalid adId being passed in th response");
      a(CBError.CBImpressionError.ERROR_DISPLAYING_VIEW);
      return false;
    }
    parama = b.d();
    if ((parama == null) || (parama.isEmpty()) || (!parama.containsKey(this.g.i)))
    {
      CBLogging.b("CBWebViewProtocol", "No html data found in memory");
      a(CBError.CBImpressionError.ERROR_LOADING_WEB_VIEW);
      return false;
    }
    this.n = ((String)parama.get(this.g.i));
    b();
    return true;
  }
  
  protected g.a b(Context paramContext)
  {
    return new c(paramContext, this.n);
  }
  
  public void b(float paramFloat)
  {
    this.q = paramFloat;
  }
  
  public void b(String paramString)
  {
    if ((this.p != null) && (this.p.c()) && (!TextUtils.isEmpty(paramString)))
    {
      Object localObject = (ArrayList)this.p.a(paramString).h();
      paramString = az.a(c.y()).a();
      if ((localObject != null) && (((ArrayList)localObject).size() > 0))
      {
        localObject = ((ArrayList)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          String str = (String)((Iterator)localObject).next();
          ac localac = new ac(1, str, new n.b()new n.a
          {
            public void a(String paramAnonymousString) {}
          }, new n.a()
          {
            public void a(s paramAnonymouss) {}
          });
          CBLogging.a("CBWebViewProtocol", "###### Sending VAST Tracking Event: " + str);
          paramString.a(localac);
        }
      }
    }
  }
  
  public void c(String paramString)
  {
    com.chartboost.sdk.Tracking.a.a(this.g.u().f(), this.g.e, this.g.t(), paramString);
  }
  
  public void d()
  {
    super.d();
  }
  
  public void d(String paramString)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "Unknown Webview error";
    }
    com.chartboost.sdk.Tracking.a.a(this.g.u().f(), this.g.e, this.g.t(), str, true);
    CBLogging.b("CBWebViewProtocol", "Webview error occurred closing the webview" + str);
    a(CBError.CBImpressionError.ERROR_LOADING_WEB_VIEW);
    h();
  }
  
  public void e(String paramString)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "Unknown Webview warning message";
    }
    com.chartboost.sdk.Tracking.a.b(this.g.u().f(), this.g.e, this.g.t(), str);
    CBLogging.d("CBWebViewProtocol", "Webview warning occurred closing the webview" + str);
  }
  
  public void h()
  {
    super.h();
  }
  
  public float j()
  {
    return this.q;
  }
  
  public float k()
  {
    return this.r;
  }
  
  public boolean l()
  {
    if (this.w == b.c) {
      return true;
    }
    c localc = q();
    if (localc != null) {
      localc.c.onHideCustomView();
    }
    h();
    return true;
  }
  
  public void m()
  {
    super.m();
    final c localc = q();
    if (localc != null)
    {
      CBUtility.e().post(new Runnable()
      {
        public void run()
        {
          CBLogging.a("CBWebViewProtocol", "Calling native to javascript: " + "javascript:Chartboost.EventHandler.handleNativeEvent(\"onForeground\", \"\")");
          localc.b.loadUrl("javascript:Chartboost.EventHandler.handleNativeEvent(\"onForeground\", \"\")");
        }
      });
      com.chartboost.sdk.Tracking.a.d(this.l, this.g.t());
    }
  }
  
  public void n()
  {
    super.n();
    final c localc = q();
    if (localc != null)
    {
      CBUtility.e().post(new Runnable()
      {
        public void run()
        {
          CBLogging.a("CBWebViewProtocol", "Calling native to javascript: " + "javascript:Chartboost.EventHandler.handleNativeEvent(\"onBackground\", \"\")");
          localc.b.loadUrl("javascript:Chartboost.EventHandler.handleNativeEvent(\"onBackground\", \"\")");
        }
      });
      com.chartboost.sdk.Tracking.a.e(this.l, this.g.t());
    }
  }
  
  public void o()
  {
    if (this.m <= 1)
    {
      this.g.g();
      this.m += 1;
      com.chartboost.sdk.Tracking.a.b(this.l, this.g.t());
    }
  }
  
  public void p()
  {
    com.chartboost.sdk.Tracking.a.c(this.l, this.g.t());
  }
  
  public c q()
  {
    return (c)super.e();
  }
  
  public void r()
  {
    if (!this.s)
    {
      com.chartboost.sdk.Tracking.a.d("", this.g.t());
      this.g.v();
      this.s = true;
    }
  }
  
  private class a
    extends WebViewClient
  {
    private a() {}
    
    public void onPageFinished(WebView paramWebView, String paramString)
    {
      super.onPageFinished(paramWebView, paramString);
      bs.a(true);
      bs.b(bs.this, System.currentTimeMillis());
      CBLogging.a("CBWebViewProtocol", "Total web view load response time " + (bs.f(bs.this) - bs.g(bs.this)) / 1000L);
      paramWebView = f.a();
      if (paramWebView != null)
      {
        paramWebView.a(bs.h(bs.this));
        return;
      }
      CBLogging.a("CBWebViewProtocol", "#### Error happened loading webview");
      bs.b(bs.this, CBError.CBImpressionError.ERROR_LOADING_WEB_VIEW);
    }
    
    public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
    {
      bs.c(bs.this, CBError.CBImpressionError.ERROR_LOADING_WEB_VIEW);
      bs.a(true);
      paramWebView = f.a();
      CBLogging.a("CBWebViewProtocol", "#### Error happened loading webview");
      if (paramWebView != null) {
        paramWebView.d(bs.i(bs.this));
      }
      CBLogging.a("CBWebViewProtocol", "Webview seems to have some issues loading html, onRecievedError callback triggered");
      com.chartboost.sdk.Tracking.a.a(bs.j(bs.this).u().f(), bs.k(bs.this).e, bs.l(bs.this).t(), "Webview seems to have some issues loading html, onRecievedError callback triggered", true);
    }
    
    public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
    {
      return false;
    }
  }
  
  public static enum b
  {
    private b() {}
  }
  
  public class c
    extends g.a
  {
    public br b;
    public bq c;
    public RelativeLayout d;
    public RelativeLayout e;
    
    public c(Context paramContext, String paramString)
    {
      super(paramContext);
      setFocusable(false);
      this.d = new RelativeLayout(paramContext);
      this.e = new RelativeLayout(paramContext);
      this.b = new br(paramContext);
      this.b.setWebViewClient(new bs.a(bs.this, null));
      this.c = new bq(this.d, this.e, null, this.b, bs.this);
      this.b.setWebChromeClient(this.c);
      if (Build.VERSION.SDK_INT >= 19)
      {
        paramContext = this.b;
        br.setWebContentsDebuggingEnabled(true);
      }
      this.b.loadDataWithBaseURL(bs.a(bs.this), paramString, "text/html", "utf-8", null);
      this.d.addView(this.b);
      this.b.getSettings().setSupportZoom(false);
      paramContext = new RelativeLayout.LayoutParams(-1, -1);
      this.d.setLayoutParams(paramContext);
      this.b.setLayoutParams(paramContext);
      this.b.setBackgroundColor(0);
      this.e.setVisibility(8);
      this.e.setLayoutParams(paramContext);
      addView(this.d);
      addView(this.e);
      bs.a(bs.this, System.currentTimeMillis());
      CBUtility.e().postDelayed(new Runnable()
      {
        public void run()
        {
          if (!bs.s())
          {
            CBLogging.a("CBWebViewProtocol", "Webview seems to be taking more time loading the html content, so closing the view.");
            com.chartboost.sdk.Tracking.a.a(bs.b(bs.this).u().f(), bs.c(bs.this).e, bs.d(bs.this).t(), "Webview seems to be taking more time loading the html content, so closing the view.", true);
            bs.a(bs.this, CBError.CBImpressionError.ERROR_LOADING_WEB_VIEW);
            f localf = f.a();
            if (localf != null) {
              localf.d(bs.e(bs.this));
            }
          }
        }
      }, 3000L);
    }
    
    protected void a(int paramInt1, int paramInt2) {}
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/chartboost/sdk/impl/bs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */