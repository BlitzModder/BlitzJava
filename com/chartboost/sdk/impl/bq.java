package com.chartboost.sdk.impl;

import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.webkit.ConsoleMessage;
import android.webkit.JsPromptResult;
import android.webkit.WebChromeClient;
import android.webkit.WebChromeClient.CustomViewCallback;
import android.webkit.WebView;
import android.widget.FrameLayout;
import com.chartboost.sdk.Libraries.CBLogging;
import com.chartboost.sdk.Libraries.CBUtility;
import org.json.JSONException;
import org.json.JSONObject;

public class bq
  extends WebChromeClient
{
  private static final String a = bq.class.getSimpleName();
  private View b;
  private ViewGroup c;
  private View d;
  private br e;
  private boolean f;
  private FrameLayout g;
  private WebChromeClient.CustomViewCallback h;
  private a i;
  private bs j;
  private Handler k = CBUtility.e();
  
  public bq() {}
  
  public bq(View paramView1, ViewGroup paramViewGroup, View paramView2, br parambr, bs parambs)
  {
    this.b = paramView1;
    this.c = paramViewGroup;
    this.d = paramView2;
    this.e = parambr;
    this.f = false;
    this.j = parambs;
  }
  
  public String a(JSONObject paramJSONObject, String paramString)
  {
    if (paramString.equals("click")) {
      l(paramJSONObject);
    }
    for (;;)
    {
      return "Native function successfully called.";
      if (paramString.equals("close"))
      {
        Log.d(a, "JavaScript to native close callback triggered");
        m(paramJSONObject);
      }
      else if (paramString.equals("videoCompleted"))
      {
        Log.d(a, "JavaScript to native video complete callback triggered");
        c(paramJSONObject);
      }
      else if (paramString.equals("videoPlaying"))
      {
        Log.d(a, "JavaScript to native video playing callback triggered");
        i(paramJSONObject);
      }
      else if (paramString.equals("videoPaused"))
      {
        Log.d(a, "JavaScript to native video pause callback triggered");
        h(paramJSONObject);
      }
      else if (paramString.equals("videoReplay"))
      {
        Log.d(a, "JavaScript to native video replay callback triggered");
        g(paramJSONObject);
      }
      else if (paramString.equals("currentVideoDuration"))
      {
        j(paramJSONObject);
      }
      else if (paramString.equals("totalVideoDuration"))
      {
        Log.d(a, "JavaScript to native total duration callback triggered");
        k(paramJSONObject);
      }
      else if (paramString.equals("show"))
      {
        Log.d(a, "JavaScript to native show callback triggered");
        f(paramJSONObject);
      }
      else if (paramString.equals("error"))
      {
        Log.d(a, "JavaScript to native error callback triggered");
        d(paramJSONObject);
      }
      else if (paramString.equals("warning"))
      {
        Log.d(a, "JavaScript to native warning callback triggered");
        e(paramJSONObject);
      }
      else if (paramString.equals("debug"))
      {
        Log.d(a, "JavaScript to native webview debug event callback triggered");
        b(paramJSONObject);
      }
      else
      {
        if (!paramString.equals("tracking")) {
          break;
        }
        Log.d(a, "JavaScript to native webview vast tracking event callback triggered");
        a(paramJSONObject);
      }
    }
    return "Function name not recognized.";
  }
  
  public void a(final JSONObject paramJSONObject)
  {
    this.k.post(new Runnable()
    {
      public void run()
      {
        try
        {
          String str = paramJSONObject.getString("event");
          bq.a(bq.this).b(str);
          Log.d(br.class.getName(), "JS->Native Track VAST event message: " + str);
          return;
        }
        catch (Exception localException)
        {
          CBLogging.b(bq.a(), "Exception occured while parsing the message for webview tracking VAST events");
        }
      }
    });
  }
  
  public void b(final JSONObject paramJSONObject)
  {
    this.k.post(new Runnable()
    {
      public void run()
      {
        try
        {
          String str = paramJSONObject.getString("message");
          Log.d(br.class.getName(), "JS->Native Debug message: " + str);
          bq.a(bq.this).c(str);
          return;
        }
        catch (Exception localException)
        {
          CBLogging.b(bq.a(), "Exception occured while parsing the message for webview debug track event");
          bq.a(bq.this).c("Exception occured while parsing the message for webview debug track event");
        }
      }
    });
  }
  
  public void c(JSONObject paramJSONObject)
  {
    Log.d(br.class.getName(), "Video is Completed");
    this.k.post(new Runnable()
    {
      public void run()
      {
        if (bq.this != null) {
          bq.this.onHideCustomView();
        }
        bq.a(bq.this).a(bs.b.b);
        bq.a(bq.this).o();
      }
    });
  }
  
  public void d(final JSONObject paramJSONObject)
  {
    Log.d(br.class.getName(), "Javascript Error occured");
    this.k.post(new Runnable()
    {
      public void run()
      {
        try
        {
          String str = paramJSONObject.getString("message");
          Log.d(br.class.getName(), "JS->Native Error message: " + str);
          bq.a(bq.this).d(str);
          return;
        }
        catch (Exception localException)
        {
          CBLogging.b(bq.a(), "Error message is empty");
          bq.a(bq.this).d("");
        }
      }
    });
  }
  
  public void e(final JSONObject paramJSONObject)
  {
    Log.d(br.class.getName(), "Javascript warning occurred");
    this.k.post(new Runnable()
    {
      public void run()
      {
        try
        {
          String str = paramJSONObject.getString("message");
          Log.d(br.class.getName(), "JS->Native Warning message: " + str);
          bq.a(bq.this).e(str);
          return;
        }
        catch (Exception localException)
        {
          CBLogging.b(bq.a(), "Warning message is empty");
          bq.a(bq.this).e("");
        }
      }
    });
  }
  
  public void f(JSONObject paramJSONObject)
  {
    this.k.post(new Runnable()
    {
      public void run()
      {
        bq.a(bq.this).r();
      }
    });
  }
  
  public void g(final JSONObject paramJSONObject)
  {
    this.k.post(new Runnable()
    {
      public void run()
      {
        try
        {
          String str = paramJSONObject.getString("name");
          if (!TextUtils.isEmpty(str)) {
            bq.a(bq.this).l = str;
          }
          bq.a(bq.this).p();
          return;
        }
        catch (Exception localException)
        {
          CBLogging.b(bq.a(), "Cannot find video file name");
          bq.a(bq.this).e("Parsing exception unknown field for video replay");
        }
      }
    });
  }
  
  public void h(final JSONObject paramJSONObject)
  {
    this.k.post(new Runnable()
    {
      public void run()
      {
        try
        {
          String str = paramJSONObject.getString("name");
          if (!TextUtils.isEmpty(str)) {
            bq.a(bq.this).l = str;
          }
          bq.a(bq.this).a(bs.b.d);
          return;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            CBLogging.b(bq.a(), "Cannot find video file name");
            bq.a(bq.this).e("Parsing exception unknown field for video pause");
          }
        }
      }
    });
  }
  
  public void i(final JSONObject paramJSONObject)
  {
    this.k.post(new Runnable()
    {
      public void run()
      {
        try
        {
          String str = paramJSONObject.getString("name");
          if (!TextUtils.isEmpty(str)) {
            bq.a(bq.this).l = str;
          }
          bq.a(bq.this).a(bs.b.c);
          return;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            CBLogging.b(bq.a(), "Cannot find video file name");
            bq.a(bq.this).e("Parsing exception unknown field for video play");
          }
        }
      }
    });
  }
  
  public void j(final JSONObject paramJSONObject)
  {
    this.k.post(new Runnable()
    {
      public void run()
      {
        try
        {
          float f = (float)paramJSONObject.getDouble("duration");
          CBLogging.a(bq.a(), "######### JS->Native Video current player duration" + f * 1000.0F);
          bq.a(bq.this).a(f * 1000.0F);
          return;
        }
        catch (Exception localException)
        {
          bq.a(bq.this).e("Parsing exception unknown field for current player duration");
          CBLogging.b(bq.a(), "Cannot find duration parameter for the video");
        }
      }
    });
  }
  
  public void k(final JSONObject paramJSONObject)
  {
    this.k.post(new Runnable()
    {
      public void run()
      {
        try
        {
          float f = (float)paramJSONObject.getDouble("duration");
          CBLogging.a(bq.a(), "######### JS->Native Video total player duration" + f * 1000.0F);
          bq.a(bq.this).b(f * 1000.0F);
          return;
        }
        catch (Exception localException)
        {
          bq.a(bq.this).e("Parsing exception unknown field for total player duration");
          CBLogging.b(bq.a(), "Cannot find duration parameter for the video");
        }
      }
    });
  }
  
  public void l(JSONObject paramJSONObject)
  {
    this.k.post(new Runnable()
    {
      public void run()
      {
        bq.a(bq.this).a(null, null);
      }
    });
  }
  
  public void m(JSONObject paramJSONObject)
  {
    this.k.post(new Runnable()
    {
      public void run()
      {
        bq.a(bq.this).h();
      }
    });
  }
  
  public boolean onConsoleMessage(ConsoleMessage paramConsoleMessage)
  {
    Log.d(bq.class.getSimpleName(), "Chartboost Webview:" + paramConsoleMessage.message() + " -- From line " + paramConsoleMessage.lineNumber() + " of " + paramConsoleMessage.sourceId());
    return true;
  }
  
  public void onHideCustomView()
  {
    if (this.f)
    {
      this.c.setVisibility(4);
      this.c.removeView(this.g);
      this.b.setVisibility(0);
      if ((this.h != null) && (!this.h.getClass().getName().contains(".chromium."))) {
        this.h.onCustomViewHidden();
      }
      this.f = false;
      this.g = null;
      this.h = null;
      if (this.i != null) {
        this.i.a(false);
      }
    }
  }
  
  public boolean onJsPrompt(WebView paramWebView, String paramString1, String paramString2, String paramString3, JsPromptResult paramJsPromptResult)
  {
    try
    {
      paramString1 = new JSONObject(paramString2);
      paramWebView = paramString1.getString("eventType");
      paramString1 = paramString1.getJSONObject("eventArgs");
      paramJsPromptResult.confirm(a(paramString1, paramWebView));
      return true;
    }
    catch (JSONException paramWebView)
    {
      CBLogging.b(a, "Exception caught parsing the function name from js to native");
    }
    return true;
  }
  
  public void onShowCustomView(View paramView, int paramInt, WebChromeClient.CustomViewCallback paramCustomViewCallback)
  {
    onShowCustomView(paramView, paramCustomViewCallback);
  }
  
  public void onShowCustomView(View paramView, WebChromeClient.CustomViewCallback paramCustomViewCallback)
  {
    if ((paramView instanceof FrameLayout))
    {
      paramView = (FrameLayout)paramView;
      paramView.getFocusedChild();
      this.f = true;
      this.g = paramView;
      this.h = paramCustomViewCallback;
      this.b.setVisibility(4);
      this.c.addView(this.g, new ViewGroup.LayoutParams(-1, -1));
      this.c.setVisibility(0);
      if (this.i != null) {
        this.i.a(true);
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(boolean paramBoolean);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/chartboost/sdk/impl/bq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */