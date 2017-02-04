package com.tune.crosspromo;

import android.webkit.WebView;
import java.net.URLEncoder;

class TuneAdView
{
  public boolean loaded;
  public boolean loading;
  public TuneAdMetadata metadata;
  public String placement;
  public String requestId;
  public WebView webView;
  
  public TuneAdView(String paramString, TuneAdMetadata paramTuneAdMetadata, WebView paramWebView)
  {
    this.placement = paramString;
    this.metadata = paramTuneAdMetadata;
    this.webView = paramWebView;
  }
  
  public void destroy()
  {
    this.webView = null;
  }
  
  public void loadView(String paramString)
  {
    try
    {
      this.webView.loadData(URLEncoder.encode(paramString, "utf-8").replaceAll("\\+", " "), "text/html", "utf-8");
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/tune/crosspromo/TuneAdView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */