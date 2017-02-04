package com.dava.framework;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.net.Uri;
import android.util.Log;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class InternalViewClientV14
  extends WebViewClient
{
  Bitmap bitmapCache = null;
  Canvas canvas = null;
  int height = 0;
  int id;
  volatile boolean isRenderToTexture = false;
  volatile boolean pendingVisible = true;
  int[] pixels = null;
  int width = 0;
  
  public InternalViewClientV14(int paramInt)
  {
    this.id = paramInt;
  }
  
  private void renderToBitmapAndCopyPixels(WebView paramWebView)
  {
    paramWebView = renderWebViewIntoBitmap(paramWebView);
    if (paramWebView != null)
    {
      if ((this.pixels == null) || (this.width != paramWebView.getWidth()) || (this.height != paramWebView.getHeight()))
      {
        this.width = paramWebView.getWidth();
        this.height = paramWebView.getHeight();
        this.pixels = new int[this.width * this.height];
      }
      paramWebView.getPixels(this.pixels, 0, this.width, 0, 0, this.width, this.height);
    }
  }
  
  private Bitmap renderWebViewIntoBitmap(WebView paramWebView)
  {
    if (this.bitmapCache != null) {
      this.bitmapCache.recycle();
    }
    paramWebView.setDrawingCacheEnabled(true);
    paramWebView.buildDrawingCache();
    Bitmap localBitmap = paramWebView.getDrawingCache();
    if (localBitmap == null) {
      Log.e("JNIWebView", "can't render WebView into bitmap");
    }
    for (;;)
    {
      paramWebView.setDrawingCacheEnabled(false);
      return this.bitmapCache;
      this.bitmapCache = Bitmap.createBitmap(localBitmap);
    }
  }
  
  FutureTask<Integer> PostOnUrlChangeTask(final String paramString, final boolean paramBoolean)
  {
    paramString = new FutureTask(new Callable()
    {
      public Integer call()
        throws Exception
      {
        return Integer.valueOf(JNIWebView.OnUrlChange(InternalViewClientV14.this.id, paramString, paramBoolean));
      }
    });
    JNIActivity.GetActivity().RunOnMainLoopThread(paramString);
    return paramString;
  }
  
  public boolean isRenderToTexture()
  {
    return this.isRenderToTexture;
  }
  
  public boolean isVisible()
  {
    return this.pendingVisible;
  }
  
  public void onPageFinished(WebView paramWebView, String paramString)
  {
    super.onPageFinished(paramWebView, paramString);
    paramWebView = (JNIWebView.WebViewWrapper)paramWebView;
    paramString = JNIActivity.GetActivity();
    if ((paramString == null) || (paramString.GetIsPausing())) {
      return;
    }
    if (this.isRenderToTexture)
    {
      paramWebView.getInternalViewClient().renderToTexture(paramWebView);
      JNIWebView.startRecursiveRefreshSequence(paramWebView);
      return;
    }
    paramString.RunOnMainLoopThread(new OnPageLoadedNativeRunnable(null, 0, 0));
  }
  
  public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    Log.e("JNIWebView", "Error in webview errorCode:" + paramInt + " description:" + paramString1 + " failingUrl:" + paramString2);
  }
  
  void renderToTexture(JNIWebView.WebViewWrapper paramWebViewWrapper)
  {
    renderToBitmapAndCopyPixels(paramWebViewWrapper);
    paramWebViewWrapper = JNIActivity.GetActivity();
    if (!paramWebViewWrapper.GetIsPausing()) {
      paramWebViewWrapper.RunOnMainLoopThread(new OnPageLoadedNativeRunnable(this.pixels, this.width, this.height));
    }
  }
  
  public void setRenderToTexture(JNIWebView.WebViewWrapper paramWebViewWrapper, boolean paramBoolean)
  {
    this.isRenderToTexture = paramBoolean;
    paramWebViewWrapper.updateViewRectPosition();
    if (paramBoolean)
    {
      renderToTexture(paramWebViewWrapper);
      return;
    }
    paramWebViewWrapper.invalidate();
  }
  
  public void setVisible(JNIWebView.WebViewWrapper paramWebViewWrapper, boolean paramBoolean)
  {
    this.pendingVisible = paramBoolean;
    if (!paramBoolean) {
      updateVisible(paramWebViewWrapper);
    }
  }
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    if ((JNIActivity.GetActivity() == null) || (JNIActivity.GetActivity().GetIsPausing())) {
      return false;
    }
    paramWebView = PostOnUrlChangeTask(paramString, true);
    i = eAction.PROCESS_IN_WEBVIEW;
    try
    {
      int j = ((Integer)paramWebView.get()).intValue();
      i = j;
    }
    catch (InterruptedException paramWebView)
    {
      for (;;)
      {
        paramWebView.printStackTrace();
      }
    }
    catch (ExecutionException paramWebView)
    {
      for (;;)
      {
        paramWebView.printStackTrace();
      }
      if (eAction.PROCESS_IN_SYSTEM_BROWSER != i) {
        break label98;
      }
      paramWebView = new Intent("android.intent.action.VIEW", Uri.parse(paramString));
      JNIActivity.GetActivity().startActivity(paramWebView);
      return true;
      Log.e("JNIWebView", "unknown result code res = " + i);
    }
    return eAction.PROCESS_IN_WEBVIEW != i;
  }
  
  public void updateVisible(JNIWebView.WebViewWrapper paramWebViewWrapper)
  {
    if (paramWebViewWrapper.getVisibility() == 0) {}
    for (int i = 1;; i = 0)
    {
      if (i != this.pendingVisible)
      {
        if (!this.pendingVisible) {
          break;
        }
        paramWebViewWrapper.setVisibility(0);
      }
      return;
    }
    paramWebViewWrapper.setVisibility(8);
  }
  
  class OnPageLoadedNativeRunnable
    implements Runnable
  {
    int height;
    int[] pixels;
    int width;
    
    OnPageLoadedNativeRunnable(int[] paramArrayOfInt, int paramInt1, int paramInt2)
    {
      this.pixels = paramArrayOfInt;
      this.width = paramInt1;
      this.height = paramInt2;
    }
    
    public void run()
    {
      if (!JNIActivity.GetActivity().GetIsPausing()) {
        JNIWebView.OnPageLoaded(InternalViewClientV14.this.id, this.pixels, this.width, this.height);
      }
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/dava/framework/InternalViewClientV14.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */