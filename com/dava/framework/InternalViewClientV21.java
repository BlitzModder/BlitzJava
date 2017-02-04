package com.dava.framework;

import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import java.io.ByteArrayInputStream;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class InternalViewClientV21
  extends InternalViewClientV14
{
  public InternalViewClientV21(int paramInt)
  {
    super(paramInt);
  }
  
  private ByteArrayInputStream createEmptyStream()
  {
    return new ByteArrayInputStream(new byte[0]);
  }
  
  public WebResourceResponse shouldInterceptRequest(final WebView paramWebView, WebResourceRequest paramWebResourceRequest)
  {
    FutureTask localFutureTask;
    int i;
    if (paramWebResourceRequest.isForMainFrame())
    {
      boolean bool = paramWebResourceRequest.hasGesture();
      paramWebResourceRequest = paramWebResourceRequest.getUrl();
      localFutureTask = PostOnUrlChangeTask(paramWebResourceRequest.toString(), bool);
      i = eAction.PROCESS_IN_WEBVIEW;
    }
    try
    {
      int j = ((Integer)localFutureTask.get()).intValue();
      i = j;
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;)
      {
        localInterruptedException.printStackTrace();
      }
    }
    catch (ExecutionException localExecutionException)
    {
      for (;;)
      {
        localExecutionException.printStackTrace();
      }
      if (eAction.PROCESS_IN_SYSTEM_BROWSER != i) {
        break label152;
      }
      paramWebResourceRequest = new Intent("android.intent.action.VIEW", paramWebResourceRequest);
      JNIActivity.GetActivity().startActivity(paramWebResourceRequest);
      paramWebResourceRequest = new WebResourceResponse("text/plain", "UTF-8", createEmptyStream());
      paramWebView = new Runnable()
      {
        public void run()
        {
          paramWebView.loadUrl(this.val$currentViewUrl);
        }
      };
      JNIActivity.GetActivity().runOnUiThread(paramWebView);
      return paramWebResourceRequest;
      Log.e("JNIWebView", "unknown result code res = " + i);
    }
    if (eAction.PROCESS_IN_WEBVIEW == i) {
      return null;
    }
    label152:
    return null;
  }
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    return false;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/dava/framework/InternalViewClientV21.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */