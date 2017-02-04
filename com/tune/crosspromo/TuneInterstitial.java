package com.tune.crosspromo;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout.LayoutParams;
import com.mobileapptracker.MATParameters;
import java.net.SocketException;
import java.util.concurrent.ExecutorService;
import org.json.JSONException;
import org.json.JSONObject;

public class TuneInterstitial
  implements TuneAd
{
  private static final String TAG = "TUNE";
  private TuneAdParams mAdParams;
  private Context mContext;
  private Handler mHandler;
  private int mLastOrientation;
  private TuneAdListener mListener;
  private TuneAdOrientation mOrientation;
  private boolean mShowOnLoad;
  private boolean nativeCloseButton;
  private TuneAdUtils utils;
  
  public TuneInterstitial(Context paramContext)
  {
    this(paramContext, TuneAdOrientation.ALL);
  }
  
  public TuneInterstitial(Context paramContext, TuneAdOrientation paramTuneAdOrientation)
  {
    this.mContext = paramContext;
    this.mHandler = new Handler(this.mContext.getMainLooper());
    this.utils = TuneAdUtils.getInstance();
    this.utils.init(paramContext, null, null);
    this.mOrientation = paramTuneAdOrientation;
    this.mLastOrientation = ((Activity)paramContext).getWindow().getDecorView().getResources().getConfiguration().orientation;
    int i;
    if (this.mOrientation == TuneAdOrientation.ALL)
    {
      i = ((Activity)paramContext).getRequestedOrientation();
      if (i != 1) {
        break label103;
      }
      this.mOrientation = TuneAdOrientation.PORTRAIT_ONLY;
    }
    label103:
    while (i != 0) {
      return;
    }
    this.mOrientation = TuneAdOrientation.LANDSCAPE_ONLY;
  }
  
  private void displayInterstitial(TuneAdView paramTuneAdView)
  {
    Activity localActivity = (Activity)this.mContext;
    Intent localIntent = new Intent(this.mContext, TuneAdActivity.class);
    localIntent.putExtra("INTERSTITIAL", true);
    localIntent.putExtra("REQUESTID", paramTuneAdView.requestId);
    localIntent.putExtra("ADPARAMS", this.mAdParams.toJSON().toString());
    localIntent.putExtra("NATIVECLOSEBUTTON", this.nativeCloseButton);
    localIntent.putExtra("PLACEMENT", paramTuneAdView.placement);
    localIntent.putExtra("ORIENTATION", this.mOrientation.value());
    localActivity.startActivity(localIntent);
    localActivity.overridePendingTransition(17432576, 17432577);
    TuneAdClient.logView(paramTuneAdView, this.mAdParams.toJSON());
    this.utils.changeView(paramTuneAdView.placement);
    notifyOnShow();
    cache(paramTuneAdView.placement, paramTuneAdView.metadata);
  }
  
  private TuneAdView getCurrentAd(String paramString)
  {
    return this.utils.getCurrentView(paramString);
  }
  
  private void initAdViewSet(String paramString, TuneAdMetadata paramTuneAdMetadata)
  {
    paramString = new TuneAdViewSet(paramString, new TuneAdView(paramString, paramTuneAdMetadata, initializeWebView(this.mContext, paramString)), new TuneAdView(paramString, paramTuneAdMetadata, initializeWebView(this.mContext, paramString)));
    this.utils.addViewSet(paramString);
  }
  
  @SuppressLint({"SetJavaScriptEnabled"})
  private WebView initializeWebView(Context paramContext, final String paramString)
  {
    paramContext = new WebView(paramContext);
    Object localObject = new FrameLayout.LayoutParams(-1, -1);
    ((FrameLayout.LayoutParams)localObject).gravity = 17;
    paramContext.setLayoutParams((ViewGroup.LayoutParams)localObject);
    paramContext.setBackgroundColor(0);
    paramContext.setScrollBarStyle(0);
    localObject = paramContext.getSettings();
    ((WebSettings)localObject).setJavaScriptEnabled(true);
    ((WebSettings)localObject).setLoadWithOverviewMode(true);
    ((WebSettings)localObject).setUseWideViewPort(true);
    paramContext.setWebViewClient(new WebViewClient()
    {
      public void onPageFinished(WebView paramAnonymousWebView, String paramAnonymousString)
      {
        if (!paramAnonymousString.equals("about:blank")) {
          TuneInterstitial.this.notifyOnLoad(paramString);
        }
      }
      
      public boolean shouldOverrideUrlLoading(WebView paramAnonymousWebView, String paramAnonymousString)
      {
        ((ViewGroup)paramAnonymousWebView.getParent()).removeView(paramAnonymousWebView);
        TuneInterstitial.this.processClick(paramAnonymousString, paramString);
        ((Activity)TuneInterstitial.this.utils.getAdContext()).finish();
        return true;
      }
    });
    return paramContext;
  }
  
  private void loadAd(String paramString, TuneAdMetadata paramTuneAdMetadata)
  {
    long l = System.currentTimeMillis();
    for (;;)
    {
      if ((this.utils.getParams().getGoogleAdvertisingId() != null) && (this.utils.getParams().getAndroidId() != null)) {}
      while (System.currentTimeMillis() - l > 500L)
      {
        this.mAdParams = new TuneAdParams(paramString, this.utils.getParams(), paramTuneAdMetadata, this.mOrientation, this.mLastOrientation);
        requestAd(paramString, 0);
        return;
      }
      try
      {
        Thread.sleep(50L);
      }
      catch (InterruptedException localInterruptedException)
      {
        localInterruptedException.printStackTrace();
      }
    }
  }
  
  private void loadWebView(final String paramString1, final String paramString2)
  {
    this.mHandler.post(new Runnable()
    {
      public void run()
      {
        TuneInterstitial.this.getCurrentAd(paramString1).loadView(paramString2);
      }
    });
  }
  
  private void notifyOnClick()
  {
    this.mHandler.post(new Runnable()
    {
      public void run()
      {
        if (TuneInterstitial.this.mListener != null) {
          TuneInterstitial.this.mListener.onAdClick(TuneInterstitial.this);
        }
      }
    });
  }
  
  private void notifyOnFailed(String paramString1, final String paramString2)
  {
    getCurrentAd(paramString1).loading = false;
    this.mShowOnLoad = false;
    if (this.mAdParams.debugMode) {
      Log.d("TUNE", "Request failed with error: " + paramString2);
    }
    this.mHandler.post(new Runnable()
    {
      public void run()
      {
        if (TuneInterstitial.this.mListener != null) {
          TuneInterstitial.this.mListener.onAdLoadFailed(TuneInterstitial.this, paramString2);
        }
      }
    });
  }
  
  private void notifyOnLoad(String paramString)
  {
    paramString = getCurrentAd(paramString);
    paramString.loaded = true;
    paramString.loading = false;
    if (this.mShowOnLoad)
    {
      this.mShowOnLoad = false;
      displayInterstitial(paramString);
    }
    this.mHandler.post(new Runnable()
    {
      public void run()
      {
        if (TuneInterstitial.this.mListener != null) {
          TuneInterstitial.this.mListener.onAdLoad(TuneInterstitial.this);
        }
      }
    });
  }
  
  private void notifyOnShow()
  {
    this.mHandler.post(new Runnable()
    {
      public void run()
      {
        if (TuneInterstitial.this.mListener != null) {
          TuneInterstitial.this.mListener.onAdShown(TuneInterstitial.this);
        }
      }
    });
  }
  
  private void processClick(String paramString1, String paramString2)
  {
    paramString2 = this.utils.getPreviousView(paramString2);
    if (paramString1.contains("#close"))
    {
      TuneAdClient.logClose(paramString2, this.mAdParams.toJSON());
      return;
    }
    Intent localIntent = new Intent(this.mContext, TuneAdActivity.class);
    localIntent.putExtra("INTERSTITIAL", false);
    localIntent.putExtra("REDIRECT_URI", paramString1);
    ((Activity)this.mContext).startActivity(localIntent);
    notifyOnClick();
    TuneAdClient.logClick(paramString2, this.mAdParams.toJSON());
  }
  
  private void requestAd(String paramString, int paramInt)
  {
    if (this.mAdParams.debugMode) {
      Log.d("TUNE", "Requesting interstitial with: " + this.mAdParams.toJSON().toString());
    }
    try
    {
      Object localObject = TuneAdClient.requestInterstitialAd(this.mAdParams);
      if (localObject != null)
      {
        boolean bool = ((String)localObject).equals("");
        if (!bool) {
          try
          {
            localObject = new JSONObject((String)localObject);
            if ((((JSONObject)localObject).has("error")) && (((JSONObject)localObject).has("message")))
            {
              Log.d("TUNE", ((JSONObject)localObject).optString("error") + ": " + ((JSONObject)localObject).optString("message"));
              if (this.mAdParams.debugMode) {
                Log.d("TUNE", "Debug request url: " + ((JSONObject)localObject).optString("requestUrl"));
              }
              notifyOnFailed(paramString, ((JSONObject)localObject).optString("message"));
              return;
            }
            String str = ((JSONObject)localObject).optString("html");
            if (!str.equals(""))
            {
              getCurrentAd(paramString).requestId = ((JSONObject)localObject).optString("requestId");
              this.mAdParams.setRefs(((JSONObject)localObject).optJSONObject("refs"));
              if (((JSONObject)localObject).has("close")) {
                this.nativeCloseButton = ((JSONObject)localObject).optString("close").equals("native");
              }
              loadWebView(paramString, str);
              return;
            }
          }
          catch (JSONException localJSONException)
          {
            localJSONException.printStackTrace();
            return;
          }
        }
      }
      return;
    }
    catch (TuneBadRequestException localTuneBadRequestException)
    {
      if (paramInt == 4)
      {
        notifyOnFailed(paramString, "Bad request");
        return;
        notifyOnFailed(paramString, "Unknown error");
        return;
      }
    }
    catch (TuneServerErrorException localTuneServerErrorException)
    {
      if (paramInt == 4)
      {
        notifyOnFailed(paramString, "Server error");
        return;
        notifyOnFailed(paramString, "Unknown error");
        return;
      }
    }
    catch (SocketException localSocketException)
    {
      if (paramInt == 4)
      {
        notifyOnFailed(paramString, "Request timed out");
        return;
        notifyOnFailed(paramString, "Network error");
        return;
        requestAd(paramString, paramInt + 1);
        return;
        requestAd(paramString, paramInt + 1);
        return;
      }
      requestAd(paramString, paramInt + 1);
    }
  }
  
  public void cache(String paramString)
  {
    cache(paramString, new TuneAdMetadata());
  }
  
  public void cache(final String paramString, final TuneAdMetadata paramTuneAdMetadata)
  {
    if ((paramString == null) || (paramString.isEmpty()) || (paramString.equals("null"))) {
      throw new IllegalArgumentException("Placement must not be null or empty");
    }
    if (!this.utils.hasViewSet(paramString)) {
      initAdViewSet(paramString, paramTuneAdMetadata);
    }
    TuneAdView localTuneAdView = getCurrentAd(paramString);
    localTuneAdView.metadata = paramTuneAdMetadata;
    localTuneAdView.loaded = false;
    localTuneAdView.loading = true;
    this.utils.getAdThread().execute(new Runnable()
    {
      public void run()
      {
        TuneInterstitial.this.loadAd(paramString, paramTuneAdMetadata);
      }
    });
  }
  
  public void destroy()
  {
    this.utils.destroyAdViews();
    this.utils = null;
    this.mListener = null;
    this.mContext = null;
    this.mOrientation = null;
    this.mHandler = null;
  }
  
  public TuneAdParams getParams()
  {
    return this.mAdParams;
  }
  
  public void setListener(TuneAdListener paramTuneAdListener)
  {
    this.mListener = paramTuneAdListener;
  }
  
  public void show(String paramString)
  {
    show(paramString, new TuneAdMetadata());
  }
  
  public void show(String paramString, TuneAdMetadata paramTuneAdMetadata)
  {
    if ((paramString == null) || (paramString.isEmpty()) || (paramString.equals("null"))) {
      throw new IllegalArgumentException("Placement must not be null or empty");
    }
    if (!this.utils.hasViewSet(paramString)) {
      initAdViewSet(paramString, paramTuneAdMetadata);
    }
    TuneAdView localTuneAdView = getCurrentAd(paramString);
    localTuneAdView.metadata = paramTuneAdMetadata;
    if (localTuneAdView.loaded) {
      displayInterstitial(localTuneAdView);
    }
    while (localTuneAdView.loading) {
      return;
    }
    cache(paramString, paramTuneAdMetadata);
    this.mShowOnLoad = true;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/tune/crosspromo/TuneInterstitial.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */