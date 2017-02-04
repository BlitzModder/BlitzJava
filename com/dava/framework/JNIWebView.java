package com.dava.framework;

import android.content.Context;
import android.graphics.Paint;
import android.os.Build.VERSION;
import android.os.Handler;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.webkit.CookieManager;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.FrameLayout.LayoutParams;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class JNIWebView
{
  private static final int MOVE_VIEW_OFFSCREEN_STEP = 10000;
  static final String TAG = "JNIWebView";
  private static final Paint paint = new Paint();
  static Map<Integer, WebViewWrapper> views = new HashMap();
  
  public static void Deinitialize(int paramInt)
  {
    JNIActivity localJNIActivity = JNIActivity.GetActivity();
    if (localJNIActivity == null) {
      return;
    }
    localJNIActivity.runOnUiThread(new Runnable()
    {
      public void run()
      {
        if (!JNIWebView.views.containsKey(Integer.valueOf(this.val$id)))
        {
          Log.e("JNIWebView", String.format("Unknown view id %d", new Object[] { Integer.valueOf(this.val$id) }));
          return;
        }
        WebView localWebView = (WebView)JNIWebView.views.get(Integer.valueOf(this.val$id));
        JNIWebView.views.remove(Integer.valueOf(this.val$id));
        ((ViewGroup)localWebView.getParent()).removeView(localWebView);
      }
    });
  }
  
  public static void DeleteCookies(String paramString)
  {
    CookieManager localCookieManager = CookieManager.getInstance();
    if (localCookieManager.hasCookies())
    {
      String[] arrayOfString = localCookieManager.getCookie(paramString).split(";");
      int i = 0;
      while (i < arrayOfString.length)
      {
        String str = arrayOfString[i].split("=")[0].trim();
        localCookieManager.setCookie(paramString, str + "=; Expires=Mon, 31 Dec 2012 23:59:59 GMT");
        i += 1;
      }
      localCookieManager.flush();
    }
  }
  
  public static void ExecuteJScript(int paramInt, final String paramString)
  {
    JNIActivity localJNIActivity = JNIActivity.GetActivity();
    if ((localJNIActivity == null) || (localJNIActivity.GetIsPausing())) {
      return;
    }
    localJNIActivity.runOnUiThread(new Runnable()
    {
      public void run()
      {
        if (!JNIWebView.views.containsKey(Integer.valueOf(this.val$id)))
        {
          Log.e("JNIWebView", String.format("Unknown view id %d", new Object[] { Integer.valueOf(this.val$id) }));
          return;
        }
        JNIWebView.WebViewWrapper localWebViewWrapper = (JNIWebView.WebViewWrapper)JNIWebView.views.get(Integer.valueOf(this.val$id));
        String str = paramString.replace("\"", "\\\"");
        localWebViewWrapper.loadUrl("javascript:function call_back_func(){    return \"\" + eval(\"" + str + "\");" + "}" + "javascript:alert(call_back_func())");
        JNIWebView.startRecursiveRefreshSequence(localWebViewWrapper);
      }
    });
  }
  
  public static String GetCookie(String paramString1, String paramString2)
  {
    Object localObject = CookieManager.getInstance();
    if (((CookieManager)localObject).hasCookies())
    {
      paramString1 = ((CookieManager)localObject).getCookie(paramString1).split(";");
      int i = 0;
      while (i < paramString1.length)
      {
        localObject = paramString1[i].split("=");
        if (localObject[0].trim().compareTo(paramString2) == 0) {
          return localObject[1];
        }
        i += 1;
      }
    }
    return "";
  }
  
  public static Object[] GetCookies(String paramString)
  {
    return CookieManager.getInstance().getCookie(paramString).split(";");
  }
  
  public static void HideAllWebViews()
  {
    Iterator localIterator = views.values().iterator();
    while (localIterator.hasNext()) {
      ((WebViewWrapper)localIterator.next()).setVisibility(8);
    }
  }
  
  public static void Initialize(int paramInt, final float paramFloat1, final float paramFloat2, final float paramFloat3, final float paramFloat4)
  {
    final JNIActivity localJNIActivity = JNIActivity.GetActivity();
    if ((localJNIActivity == null) || (localJNIActivity.GetIsPausing())) {
      return;
    }
    localJNIActivity.runOnUiThread(new Runnable()
    {
      public void run()
      {
        if (JNIWebView.views.containsKey(Integer.valueOf(this.val$id)))
        {
          Log.e("JNIWebView", String.format("WebView with id %d already initialized", new Object[] { Integer.valueOf(this.val$id) }));
          return;
        }
        if (Build.VERSION.SDK_INT >= 21) {}
        for (Object localObject = new InternalViewClientV21(this.val$id);; localObject = new InternalViewClientV14(this.val$id))
        {
          localObject = new JNIWebView.WebViewWrapper(localJNIActivity, (InternalViewClientV14)localObject);
          FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(new ViewGroup.MarginLayoutParams((int)(paramFloat3 + 0.5F), (int)(paramFloat4 + 0.5F)));
          localLayoutParams.leftMargin = ((int)(paramFloat1 + 0.5D));
          localLayoutParams.topMargin = ((int)(paramFloat2 + 0.5D));
          localLayoutParams.width = ((int)paramFloat3);
          localLayoutParams.height = ((int)paramFloat4);
          ((JNIWebView.WebViewWrapper)localObject).getSettings().setJavaScriptEnabled(true);
          ((JNIWebView.WebViewWrapper)localObject).getSettings().setLoadWithOverviewMode(true);
          ((JNIWebView.WebViewWrapper)localObject).getSettings().setUseWideViewPort(false);
          ((JNIWebView.WebViewWrapper)localObject).setLayerType(1, null);
          ((JNIWebView.WebViewWrapper)localObject).setDrawingCacheEnabled(true);
          ((JNIWebView.WebViewWrapper)localObject).setWebChromeClient(new JNIWebView.InternalWebClient(this.val$id));
          ((JNIWebView.WebViewWrapper)localObject).setOnTouchListener(new View.OnTouchListener()
          {
            public boolean onTouch(View paramAnonymous2View, MotionEvent paramAnonymous2MotionEvent)
            {
              switch (paramAnonymous2MotionEvent.getAction())
              {
              }
              for (;;)
              {
                return false;
                if (!paramAnonymous2View.hasFocus()) {
                  paramAnonymous2View.requestFocus();
                }
              }
            }
          });
          localJNIActivity.addContentView((View)localObject, localLayoutParams);
          JNIWebView.views.put(Integer.valueOf(this.val$id), localObject);
          return;
        }
      }
    });
  }
  
  public static void LoadHtmlString(int paramInt, final String paramString)
  {
    JNIActivity localJNIActivity = JNIActivity.GetActivity();
    if ((localJNIActivity == null) || (localJNIActivity.GetIsPausing())) {
      return;
    }
    localJNIActivity.runOnUiThread(new Runnable()
    {
      public void run()
      {
        if (!JNIWebView.views.containsKey(Integer.valueOf(this.val$id)))
        {
          Log.e("JNIWebView", String.format("Unknown view id %d", new Object[] { Integer.valueOf(this.val$id) }));
          return;
        }
        JNIWebView.WebViewWrapper localWebViewWrapper = (JNIWebView.WebViewWrapper)JNIWebView.views.get(Integer.valueOf(this.val$id));
        localWebViewWrapper.loadData(paramString, "text/html", null);
        JNIWebView.startRecursiveRefreshSequence(localWebViewWrapper);
      }
    });
  }
  
  static native void OnExecuteJScript(int paramInt, String paramString);
  
  static native int OnPageLoaded(int paramInt1, int[] paramArrayOfInt, int paramInt2, int paramInt3);
  
  static native int OnUrlChange(int paramInt, String paramString, boolean paramBoolean);
  
  public static void OpenFromBuffer(int paramInt, final String paramString1, final String paramString2)
  {
    JNIActivity localJNIActivity = JNIActivity.GetActivity();
    if ((localJNIActivity == null) || (localJNIActivity.GetIsPausing())) {
      return;
    }
    localJNIActivity.runOnUiThread(new Runnable()
    {
      public void run()
      {
        if (!JNIWebView.views.containsKey(Integer.valueOf(this.val$id)))
        {
          Log.e("JNIWebView", String.format("Unknown view id %d", new Object[] { Integer.valueOf(this.val$id) }));
          return;
        }
        JNIWebView.WebViewWrapper localWebViewWrapper = (JNIWebView.WebViewWrapper)JNIWebView.views.get(Integer.valueOf(this.val$id));
        localWebViewWrapper.loadDataWithBaseURL(paramString2, paramString1, "text/html", "utf-8", null);
        JNIWebView.startRecursiveRefreshSequence(localWebViewWrapper);
      }
    });
  }
  
  public static void OpenURL(int paramInt, final String paramString)
  {
    JNIActivity localJNIActivity = JNIActivity.GetActivity();
    if ((localJNIActivity == null) || (localJNIActivity.GetIsPausing())) {
      return;
    }
    localJNIActivity.runOnUiThread(new Runnable()
    {
      public void run()
      {
        if (!JNIWebView.views.containsKey(Integer.valueOf(this.val$id)))
        {
          Log.d("JNIWebView", String.format("Unknown view id %d", new Object[] { Integer.valueOf(this.val$id) }));
          return;
        }
        ((JNIWebView.WebViewWrapper)JNIWebView.views.get(Integer.valueOf(this.val$id))).loadUrl(paramString);
      }
    });
  }
  
  protected static void RelinkNativeControls()
  {
    Iterator localIterator = views.values().iterator();
    while (localIterator.hasNext())
    {
      WebViewWrapper localWebViewWrapper = (WebViewWrapper)localIterator.next();
      ((ViewGroup)localWebViewWrapper.getParent()).removeView(localWebViewWrapper);
      JNIActivity.GetActivity().addContentView(localWebViewWrapper, localWebViewWrapper.getLayoutParams());
    }
  }
  
  public static void SetBackgroundTransparency(int paramInt, final boolean paramBoolean)
  {
    JNIActivity localJNIActivity = JNIActivity.GetActivity();
    if ((localJNIActivity == null) || (localJNIActivity.GetIsPausing())) {
      return;
    }
    localJNIActivity.runOnUiThread(new Runnable()
    {
      public void run()
      {
        int i = 0;
        if (!JNIWebView.views.containsKey(Integer.valueOf(this.val$id)))
        {
          Log.e("JNIWebView", String.format("Unknown view id %d", new Object[] { Integer.valueOf(this.val$id) }));
          return;
        }
        WebView localWebView = (WebView)JNIWebView.views.get(Integer.valueOf(this.val$id));
        if (paramBoolean) {}
        for (;;)
        {
          localWebView.setBackgroundColor(i);
          return;
          i = -1;
        }
      }
    });
  }
  
  public static void SetRect(int paramInt, final float paramFloat1, final float paramFloat2, final float paramFloat3, final float paramFloat4)
  {
    JNIActivity localJNIActivity = JNIActivity.GetActivity();
    if ((localJNIActivity == null) || (localJNIActivity.GetIsPausing())) {
      return;
    }
    localJNIActivity.runOnUiThread(new Runnable()
    {
      public void run()
      {
        if (!JNIWebView.views.containsKey(Integer.valueOf(this.val$id)))
        {
          Log.e("JNIWebView", String.format("Unknown view id %d", new Object[] { Integer.valueOf(this.val$id) }));
          return;
        }
        JNIWebView.WebViewWrapper localWebViewWrapper = (JNIWebView.WebViewWrapper)JNIWebView.views.get(Integer.valueOf(this.val$id));
        FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)localWebViewWrapper.getLayoutParams();
        int i = (int)(paramFloat1 + 0.5F);
        if (JNIWebView.isRenderToTexture(this.val$id)) {}
        for (localLayoutParams.leftMargin = (i + 10000);; localLayoutParams.leftMargin = i)
        {
          localLayoutParams.topMargin = ((int)(paramFloat2 + 0.5F));
          localLayoutParams.width = ((int)paramFloat3);
          localLayoutParams.height = ((int)paramFloat4);
          localWebViewWrapper.setLayoutParams(localLayoutParams);
          return;
        }
      }
    });
  }
  
  public static void SetVisible(int paramInt, final boolean paramBoolean)
  {
    JNIActivity localJNIActivity = JNIActivity.GetActivity();
    if ((localJNIActivity == null) || (localJNIActivity.GetIsPausing())) {
      return;
    }
    localJNIActivity.runOnUiThread(new Runnable()
    {
      public void run()
      {
        if (!JNIWebView.views.containsKey(Integer.valueOf(this.val$id)))
        {
          Log.e("JNIWebView", String.format("Unknown view id %d", new Object[] { Integer.valueOf(this.val$id) }));
          return;
        }
        JNIWebView.WebViewWrapper localWebViewWrapper = (JNIWebView.WebViewWrapper)JNIWebView.views.get(Integer.valueOf(this.val$id));
        localWebViewWrapper.getInternalViewClient().setVisible(localWebViewWrapper, paramBoolean);
      }
    });
  }
  
  public static void ShowVisibleWebViews()
  {
    JNIActivity.GetActivity().runOnUiThread(new Runnable()
    {
      public void run()
      {
        Iterator localIterator = JNIWebView.views.values().iterator();
        while (localIterator.hasNext())
        {
          JNIWebView.WebViewWrapper localWebViewWrapper = (JNIWebView.WebViewWrapper)localIterator.next();
          localWebViewWrapper.restoreVisibility();
          JNIWebView.refreshStaticTexture(localWebViewWrapper);
        }
      }
    });
  }
  
  public static void WillDraw(int paramInt)
  {
    JNIActivity localJNIActivity = JNIActivity.GetActivity();
    if ((localJNIActivity == null) || (localJNIActivity.GetIsPausing())) {
      return;
    }
    localJNIActivity.runOnUiThread(new Runnable()
    {
      public void run()
      {
        if (!JNIWebView.views.containsKey(Integer.valueOf(this.val$id)))
        {
          Log.e("JNIWebView", String.format("Unknown view id %d", new Object[] { Integer.valueOf(this.val$id) }));
          return;
        }
        JNIWebView.WebViewWrapper localWebViewWrapper = (JNIWebView.WebViewWrapper)JNIWebView.views.get(Integer.valueOf(this.val$id));
        localWebViewWrapper.getInternalViewClient().updateVisible(localWebViewWrapper);
      }
    });
  }
  
  public static boolean isRenderToTexture(int paramInt)
  {
    if (!views.containsKey(Integer.valueOf(paramInt)))
    {
      Log.e("JNIWebView", String.format("Unknown view id %d", new Object[] { Integer.valueOf(paramInt) }));
      return false;
    }
    return ((WebViewWrapper)views.get(Integer.valueOf(paramInt))).getInternalViewClient().isRenderToTexture();
  }
  
  private static void refreshStaticTexture(WebViewWrapper paramWebViewWrapper)
  {
    if (paramWebViewWrapper.getInternalViewClient().isRenderToTexture())
    {
      if (paramWebViewWrapper.delay < 1600)
      {
        new Handler().postDelayed(new Runnable()
        {
          public void run()
          {
            this.val$webView.getInternalViewClient().renderToTexture(this.val$webView);
            JNIWebView.refreshStaticTexture(this.val$webView);
          }
        }, paramWebViewWrapper.delay);
        WebViewWrapper.access$028(paramWebViewWrapper, 2);
      }
    }
    else {
      return;
    }
    WebViewWrapper.access$002(paramWebViewWrapper, 50);
  }
  
  public static void setRenderToTexture(int paramInt, final boolean paramBoolean)
  {
    JNIActivity localJNIActivity = JNIActivity.GetActivity();
    if ((localJNIActivity == null) || (localJNIActivity.GetIsPausing())) {
      return;
    }
    localJNIActivity.runOnUiThread(new Runnable()
    {
      public void run()
      {
        if (!JNIWebView.views.containsKey(Integer.valueOf(this.val$id)))
        {
          Log.e("JNIWebView", String.format("Unknown view id %d", new Object[] { Integer.valueOf(this.val$id) }));
          return;
        }
        JNIWebView.WebViewWrapper localWebViewWrapper = (JNIWebView.WebViewWrapper)JNIWebView.views.get(Integer.valueOf(this.val$id));
        localWebViewWrapper.getInternalViewClient().setRenderToTexture(localWebViewWrapper, paramBoolean);
      }
    });
  }
  
  static void startRecursiveRefreshSequence(WebViewWrapper paramWebViewWrapper)
  {
    WebViewWrapper.access$002(paramWebViewWrapper, 50);
    refreshStaticTexture(paramWebViewWrapper);
  }
  
  static class InternalWebClient
    extends WebChromeClient
  {
    int id;
    
    InternalWebClient(int paramInt)
    {
      this.id = paramInt;
    }
    
    public boolean onJsAlert(WebView paramWebView, String paramString1, String paramString2, JsResult paramJsResult)
    {
      JNIActivity.GetActivity().RunOnMainLoopThread(new Runnable()
      {
        int id;
        String result;
        
        public void run()
        {
          JNIWebView.OnExecuteJScript(this.id, this.result);
        }
      });
      paramJsResult.confirm();
      return true;
    }
  }
  
  public static class WebViewWrapper
    extends WebView
  {
    private static final int MAX_DELAY = 1600;
    private static final int START_DELAY = 50;
    private InternalViewClientV14 client = null;
    private int delay = 50;
    private String[] lastLoadData = null;
    
    public WebViewWrapper(Context paramContext, InternalViewClientV14 paramInternalViewClientV14)
    {
      super();
      this.client = paramInternalViewClientV14;
      super.setWebViewClient(paramInternalViewClientV14);
    }
    
    InternalViewClientV14 getInternalViewClient()
    {
      return this.client;
    }
    
    public String getLastLoadedUrl()
    {
      if ((this.lastLoadData != null) && (this.lastLoadData.length > 0)) {
        return this.lastLoadData[0];
      }
      return null;
    }
    
    public void loadData(String paramString1, String paramString2, String paramString3)
    {
      this.lastLoadData = new String[] { paramString1, paramString2, paramString3 };
      super.loadData(paramString1, paramString2, paramString3);
    }
    
    public void loadDataWithBaseURL(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
    {
      this.lastLoadData = new String[] { paramString1, paramString2, paramString3, paramString4, paramString5 };
      super.loadDataWithBaseURL(paramString1, paramString2, paramString3, paramString4, paramString5);
    }
    
    public void loadUrl(String paramString)
    {
      this.lastLoadData = new String[] { paramString };
      super.loadUrl(paramString);
    }
    
    public boolean onKeyPreIme(int paramInt, KeyEvent paramKeyEvent)
    {
      if (paramInt == 4)
      {
        if (paramKeyEvent.getAction() == 0) {}
        for (;;)
        {
          return true;
          clearFocus();
        }
      }
      return super.onKeyPreIme(paramInt, paramKeyEvent);
    }
    
    public void restoreVisibility()
    {
      this.client.setVisible(this, this.client.isVisible());
      if (this.lastLoadData != null) {}
      switch (this.lastLoadData.length)
      {
      case 2: 
      case 4: 
      default: 
        Log.e(JNIConst.LOG_TAG, "Incorrect data to reload WebView content");
        return;
      case 1: 
        super.loadUrl(this.lastLoadData[0]);
        return;
      case 3: 
        super.loadData(this.lastLoadData[0], this.lastLoadData[1], this.lastLoadData[2]);
        return;
      }
      super.loadDataWithBaseURL(this.lastLoadData[0], this.lastLoadData[1], this.lastLoadData[2], this.lastLoadData[3], this.lastLoadData[4]);
    }
    
    public void updateViewRectPosition()
    {
      FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)getLayoutParams();
      if (this.client.isRenderToTexture()) {
        if (localLayoutParams.leftMargin < 10000) {
          localLayoutParams.leftMargin += 10000;
        }
      }
      for (;;)
      {
        setLayoutParams(localLayoutParams);
        return;
        if (localLayoutParams.leftMargin >= 10000) {
          localLayoutParams.leftMargin -= 10000;
        }
      }
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/dava/framework/JNIWebView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */