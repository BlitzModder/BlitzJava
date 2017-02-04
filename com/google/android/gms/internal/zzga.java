package com.google.android.gms.internal;

import android.content.Context;
import android.os.Handler;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.android.gms.ads.internal.util.client.zzb;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@zzha
public class zzga
  implements zzfy
{
  private final Context mContext;
  final Set<WebView> zzEq = Collections.synchronizedSet(new HashSet());
  
  public zzga(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  public void zza(String paramString1, final String paramString2, final String paramString3)
  {
    zzb.zzaF("Fetching assets for the given html");
    zzip.zzKO.post(new Runnable()
    {
      public void run()
      {
        final WebView localWebView = zzga.this.zzfE();
        localWebView.setWebViewClient(new WebViewClient()
        {
          public void onPageFinished(WebView paramAnonymous2WebView, String paramAnonymous2String)
          {
            zzb.zzaF("Loading assets have finished");
            zzga.this.zzEq.remove(localWebView);
          }
          
          public void onReceivedError(WebView paramAnonymous2WebView, int paramAnonymous2Int, String paramAnonymous2String1, String paramAnonymous2String2)
          {
            zzb.zzaH("Loading assets have failed.");
            zzga.this.zzEq.remove(localWebView);
          }
        });
        zzga.this.zzEq.add(localWebView);
        localWebView.loadDataWithBaseURL(paramString2, paramString3, "text/html", "UTF-8", null);
        zzb.zzaF("Fetching assets finished.");
      }
    });
  }
  
  public WebView zzfE()
  {
    WebView localWebView = new WebView(this.mContext);
    localWebView.getSettings().setJavaScriptEnabled(true);
    return localWebView;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/internal/zzga.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */