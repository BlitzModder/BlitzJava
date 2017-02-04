package com.google.android.gms.internal;

import android.text.TextUtils;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.common.internal.zzw;
import java.net.URI;
import java.net.URISyntaxException;

@zzha
public class zzjw
  extends WebViewClient
{
  private final zzgn zzFr;
  private final String zzMR = zzaO(paramString);
  private boolean zzMS = false;
  private final zzjn zzps;
  
  public zzjw(zzgn paramzzgn, zzjn paramzzjn, String paramString)
  {
    this.zzps = paramzzjn;
    this.zzFr = paramzzgn;
  }
  
  private String zzaO(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return paramString;
      try
      {
        if (paramString.endsWith("/"))
        {
          String str = paramString.substring(0, paramString.length() - 1);
          return str;
        }
      }
      catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
      {
        zzb.e(localIndexOutOfBoundsException.getMessage());
      }
    }
    return paramString;
  }
  
  public void onLoadResource(WebView paramWebView, String paramString)
  {
    zzb.zzaF("JavascriptAdWebViewClient::onLoadResource: " + paramString);
    if (!zzaN(paramString)) {
      this.zzps.zzhC().onLoadResource(this.zzps.getWebView(), paramString);
    }
  }
  
  public void onPageFinished(WebView paramWebView, String paramString)
  {
    zzb.zzaF("JavascriptAdWebViewClient::onPageFinished: " + paramString);
    if (!this.zzMS)
    {
      this.zzFr.zzfS();
      this.zzMS = true;
    }
  }
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    zzb.zzaF("JavascriptAdWebViewClient::shouldOverrideUrlLoading: " + paramString);
    if (zzaN(paramString))
    {
      zzb.zzaF("shouldOverrideUrlLoading: received passback url");
      return true;
    }
    return this.zzps.zzhC().shouldOverrideUrlLoading(this.zzps.getWebView(), paramString);
  }
  
  protected boolean zzaN(String paramString)
  {
    paramString = zzaO(paramString);
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return false;
      try
      {
        Object localObject1 = new URI(paramString);
        if ("passback".equals(((URI)localObject1).getScheme()))
        {
          zzb.zzaF("Passback received");
          this.zzFr.zzfT();
          return true;
        }
        if (!TextUtils.isEmpty(this.zzMR))
        {
          Object localObject2 = new URI(this.zzMR);
          paramString = ((URI)localObject2).getHost();
          String str = ((URI)localObject1).getHost();
          localObject2 = ((URI)localObject2).getPath();
          localObject1 = ((URI)localObject1).getPath();
          if ((zzw.equal(paramString, str)) && (zzw.equal(localObject2, localObject1)))
          {
            zzb.zzaF("Passback received");
            this.zzFr.zzfT();
            return true;
          }
        }
      }
      catch (URISyntaxException paramString)
      {
        zzb.e(paramString.getMessage());
      }
    }
    return false;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/internal/zzjw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */