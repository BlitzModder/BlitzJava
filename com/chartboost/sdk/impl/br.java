package com.chartboost.sdk.impl;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build.VERSION;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import java.util.Map;

public class br
  extends WebView
{
  private bq a;
  private boolean b = false;
  
  public br(Context paramContext)
  {
    super(paramContext);
  }
  
  private void a()
  {
    if (!this.b) {
      this.b = true;
    }
  }
  
  public void loadData(String paramString1, String paramString2, String paramString3)
  {
    a();
    super.loadData(paramString1, paramString2, paramString3);
  }
  
  public void loadDataWithBaseURL(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    a();
    super.loadDataWithBaseURL(paramString1, paramString2, paramString3, paramString4, paramString5);
  }
  
  public void loadUrl(String paramString)
  {
    a();
    super.loadUrl(paramString);
  }
  
  public void loadUrl(String paramString, Map<String, String> paramMap)
  {
    a();
    super.loadUrl(paramString, paramMap);
  }
  
  @SuppressLint({"SetJavaScriptEnabled"})
  public void setWebChromeClient(WebChromeClient paramWebChromeClient)
  {
    WebSettings localWebSettings = getSettings();
    localWebSettings.setJavaScriptEnabled(true);
    localWebSettings.setAllowFileAccess(true);
    localWebSettings.setLoadWithOverviewMode(true);
    localWebSettings.setUseWideViewPort(true);
    if (Build.VERSION.SDK_INT >= 11) {
      localWebSettings.setAllowContentAccess(true);
    }
    if (Build.VERSION.SDK_INT >= 16)
    {
      localWebSettings.setAllowFileAccessFromFileURLs(true);
      localWebSettings.setAllowUniversalAccessFromFileURLs(true);
    }
    if (Build.VERSION.SDK_INT >= 17) {
      localWebSettings.setMediaPlaybackRequiresUserGesture(false);
    }
    if (Build.VERSION.SDK_INT >= 11)
    {
      localWebSettings.setBuiltInZoomControls(false);
      localWebSettings.setDisplayZoomControls(false);
    }
    if (Build.VERSION.SDK_INT >= 19) {
      setWebContentsDebuggingEnabled(true);
    }
    if ((paramWebChromeClient instanceof bq)) {
      this.a = ((bq)paramWebChromeClient);
    }
    super.setWebChromeClient(paramWebChromeClient);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/chartboost/sdk/impl/br.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */