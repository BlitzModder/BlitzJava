package com.chartboost.sdk.impl;

import android.content.Context;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout.LayoutParams;
import com.chartboost.sdk.Libraries.CBLogging;
import com.chartboost.sdk.Libraries.CBUtility;
import com.chartboost.sdk.Libraries.e.a;

public class as
  extends ao
{
  private WebView a;
  private View.OnClickListener b = null;
  
  public as(av paramav, Context paramContext)
  {
    super(paramContext);
    this.a = new WebView(paramContext);
    addView(this.a, new LinearLayout.LayoutParams(-1, -1));
    this.a.setBackgroundColor(0);
    this.a.setWebViewClient(new WebViewClient()
    {
      public boolean shouldOverrideUrlLoading(WebView paramAnonymousWebView, String paramAnonymousString)
      {
        if (paramAnonymousString == null) {
          return false;
        }
        if ((paramAnonymousString.contains("chartboost")) && (paramAnonymousString.contains("click")) && (as.a(as.this) != null)) {
          as.a(as.this).onClick(as.this);
        }
        return true;
      }
    });
  }
  
  public int a()
  {
    return CBUtility.a(100, getContext());
  }
  
  public void a(e.a parama, int paramInt)
  {
    parama = parama.e("html");
    if (parama != null) {}
    try
    {
      this.a.loadDataWithBaseURL("file:///android_res/", parama, "text/html", "UTF-8", null);
      return;
    }
    catch (Exception parama)
    {
      CBLogging.b("AppCellWebView", "Exception raised loading data into webview", parama);
    }
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    super.setOnClickListener(paramOnClickListener);
    this.b = paramOnClickListener;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/chartboost/sdk/impl/as.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */