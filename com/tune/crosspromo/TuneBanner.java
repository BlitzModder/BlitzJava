package com.tune.crosspromo;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.ViewSwitcher;
import com.mobileapptracker.MATParameters;
import java.io.UnsupportedEncodingException;
import java.net.ConnectException;
import java.net.URLEncoder;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

public class TuneBanner
  extends FrameLayout
  implements TuneAd
{
  private static final int DEFAULT_REFRESH_DURATION_SEC = 60;
  private static final String TAG = "TUNE";
  private ScheduledFuture<?> loadFuture;
  private TuneAdParams mAdParams;
  private TuneAdView mAdView;
  private Context mContext;
  private int mDuration;
  private Handler mHandler;
  private int mLastOrientation;
  private TuneAdListener mListener;
  private TuneAdMetadata mMetadata;
  private TuneAdOrientation mOrientation;
  private String mPlacement;
  private TuneBannerPosition mPosition;
  private ScheduledThreadPoolExecutor mScheduler;
  private ViewSwitcher mViewSwitcher;
  private WebView mWebView1;
  private WebView mWebView2;
  private TuneAdUtils utils;
  private WebViewClient webViewClient;
  
  public TuneBanner(Context paramContext)
  {
    super(paramContext);
    init(paramContext, null, null);
  }
  
  public TuneBanner(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    String str = paramAttributeSet.getAttributeValue(null, "advertiserId");
    paramAttributeSet = paramAttributeSet.getAttributeValue(null, "conversionKey");
    if ((str != null) && (paramAttributeSet != null))
    {
      init(paramContext, str, paramAttributeSet);
      return;
    }
    Log.e("TUNE", "TuneBanner XML requires advertiserId and conversionKey");
  }
  
  private void buildViewSwitcher()
  {
    this.mWebView1 = buildWebView(this.mContext);
    this.mWebView2 = buildWebView(this.mContext);
    this.mViewSwitcher = new ViewSwitcher(this.mContext);
    this.mViewSwitcher.setVisibility(8);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
    this.mViewSwitcher.addView(this.mWebView1, localLayoutParams);
    this.mViewSwitcher.addView(this.mWebView2, localLayoutParams);
    localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
    addView(this.mViewSwitcher, localLayoutParams);
  }
  
  @SuppressLint({"SetJavaScriptEnabled"})
  private WebView buildWebView(Context paramContext)
  {
    paramContext = new WebView(paramContext);
    paramContext.setWebViewClient(this.webViewClient);
    paramContext.setBackgroundColor(0);
    paramContext.setScrollBarStyle(0);
    paramContext.setVerticalScrollBarEnabled(false);
    paramContext.setHorizontalScrollBarEnabled(false);
    WebSettings localWebSettings = paramContext.getSettings();
    localWebSettings.setJavaScriptEnabled(true);
    localWebSettings.setLoadWithOverviewMode(true);
    localWebSettings.setUseWideViewPort(true);
    return paramContext;
  }
  
  private void init(Context paramContext, String paramString1, String paramString2)
  {
    this.mContext = paramContext;
    this.mHandler = new Handler(paramContext.getMainLooper());
    this.mLastOrientation = getResources().getConfiguration().orientation;
    this.mOrientation = TuneAdOrientation.ALL;
    int i = ((Activity)paramContext).getRequestedOrientation();
    if (i == 1) {
      this.mOrientation = TuneAdOrientation.PORTRAIT_ONLY;
    }
    for (;;)
    {
      this.utils = TuneAdUtils.getInstance();
      this.utils.init(paramContext, paramString1, paramString2);
      this.mDuration = 60;
      this.mPosition = TuneBannerPosition.BOTTOM_CENTER;
      this.mScheduler = new ScheduledThreadPoolExecutor(1);
      this.webViewClient = new WebViewClient()
      {
        public void onPageFinished(WebView paramAnonymousWebView, String paramAnonymousString)
        {
          TuneBanner.this.notifyOnLoad();
          if (TuneBanner.this.mViewSwitcher != null)
          {
            TuneBanner.this.mViewSwitcher.setVisibility(0);
            if (TuneBanner.this.mViewSwitcher.getCurrentView() != TuneBanner.this.mWebView1) {
              break label105;
            }
            TuneBanner.this.mHandler.postDelayed(new Runnable()
            {
              public void run()
              {
                if (TuneBanner.this.mViewSwitcher != null) {
                  TuneBanner.this.mViewSwitcher.showNext();
                }
              }
            }, 50L);
          }
          for (;;)
          {
            TuneAdClient.logView(TuneBanner.this.mAdView, TuneBanner.this.mAdParams.toJSON());
            TuneBanner.this.positionAd();
            TuneBanner.this.notifyOnShow();
            return;
            label105:
            TuneBanner.this.mHandler.postDelayed(new Runnable()
            {
              public void run()
              {
                if (TuneBanner.this.mViewSwitcher != null) {
                  TuneBanner.this.mViewSwitcher.showPrevious();
                }
              }
            }, 50L);
          }
        }
        
        public boolean shouldOverrideUrlLoading(WebView paramAnonymousWebView, String paramAnonymousString)
        {
          TuneBanner.this.processClick(paramAnonymousString);
          return true;
        }
      };
      buildViewSwitcher();
      bringToFront();
      return;
      if (i == 0) {
        this.mOrientation = TuneAdOrientation.LANDSCAPE_ONLY;
      }
    }
  }
  
  private void loadAd()
  {
    long l = System.currentTimeMillis();
    for (;;)
    {
      label30:
      int i;
      if ((this.utils.getParams().getGoogleAdvertisingId() != null) || (this.utils.getParams().getAndroidId() != null))
      {
        this.mAdParams = new TuneAdParams(this.mPlacement, this.utils.getParams(), this.mMetadata, this.mOrientation, this.mLastOrientation);
        i = getResources().getConfiguration().orientation;
        this.mAdParams.adWidthPortrait = TuneBannerSize.getScreenWidthPixelsPortrait(this.mContext, i);
        this.mAdParams.adHeightPortrait = TuneBannerSize.getBannerHeightPixelsPortrait(this.mContext, i);
        this.mAdParams.adWidthLandscape = TuneBannerSize.getScreenWidthPixelsLandscape(this.mContext, i);
        this.mAdParams.adHeightLandscape = TuneBannerSize.getBannerHeightPixelsLandscape(this.mContext, i);
        if (this.mAdParams.debugMode) {
          Log.d("TUNE", "Requesting banner with: " + this.mAdParams.toJSON().toString());
        }
      }
      try
      {
        Object localObject = TuneAdClient.requestBannerAd(this.mAdParams);
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
                notifyOnFailed(((JSONObject)localObject).optString("message"));
                return;
                if (System.currentTimeMillis() - l > 500L) {
                  break label30;
                }
                try
                {
                  Thread.sleep(50L);
                }
                catch (InterruptedException localInterruptedException)
                {
                  localInterruptedException.printStackTrace();
                }
                continue;
              }
              String str = localInterruptedException.optString("html");
              if (!str.equals(""))
              {
                i = Integer.parseInt(localInterruptedException.getString("duration"));
                if (i != this.mDuration)
                {
                  this.mDuration = i;
                  restartWithDuration(i);
                }
                this.mAdView.requestId = localInterruptedException.optString("requestId");
                this.mAdParams.setRefs(localInterruptedException.optJSONObject("refs"));
                loadWebView(str);
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
        notifyOnFailed("Network error");
      }
      catch (TuneBadRequestException localTuneBadRequestException)
      {
        notifyOnFailed("Bad request");
        return;
        notifyOnFailed("Unknown error");
        return;
      }
      catch (TuneServerErrorException localTuneServerErrorException)
      {
        notifyOnFailed("Server error");
        return;
        notifyOnFailed("Unknown error");
        return;
      }
      catch (ConnectException localConnectException)
      {
        notifyOnFailed("Request timed out");
        return;
      }
    }
  }
  
  private void loadWebView(final String paramString)
  {
    this.mHandler.post(new Runnable()
    {
      public void run()
      {
        if (TuneBanner.this.mViewSwitcher != null) {
          if (TuneBanner.this.mViewSwitcher.getCurrentView() != TuneBanner.this.mWebView1) {
            break label63;
          }
        }
        for (WebView localWebView = TuneBanner.this.mWebView2;; localWebView = TuneBanner.this.mWebView1) {
          try
          {
            localWebView.loadData(URLEncoder.encode(paramString, "utf-8").replaceAll("\\+", " "), "text/html", "utf-8");
            return;
          }
          catch (UnsupportedEncodingException localUnsupportedEncodingException)
          {
            label63:
            localUnsupportedEncodingException.printStackTrace();
          }
        }
      }
    });
  }
  
  private void notifyOnClick()
  {
    this.mHandler.post(new Runnable()
    {
      public void run()
      {
        if (TuneBanner.this.mListener != null) {
          TuneBanner.this.mListener.onAdClick(TuneBanner.this);
        }
      }
    });
  }
  
  private void notifyOnFailed(final String paramString)
  {
    if (this.mAdParams.debugMode) {
      Log.d("TUNE", "Request failed with error: " + paramString);
    }
    this.mHandler.post(new Runnable()
    {
      public void run()
      {
        if (TuneBanner.this.mListener != null) {
          TuneBanner.this.mListener.onAdLoadFailed(TuneBanner.this, paramString);
        }
      }
    });
  }
  
  private void notifyOnLoad()
  {
    this.mHandler.post(new Runnable()
    {
      public void run()
      {
        if (TuneBanner.this.mListener != null) {
          TuneBanner.this.mListener.onAdLoad(TuneBanner.this);
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
        if (TuneBanner.this.mListener != null) {
          TuneBanner.this.mListener.onAdShown(TuneBanner.this);
        }
      }
    });
  }
  
  private void positionAd()
  {
    ViewGroup.LayoutParams localLayoutParams = getLayoutParams();
    if (localLayoutParams != null)
    {
      localLayoutParams.width = TuneBannerSize.getScreenWidthPixels(this.mContext);
      localLayoutParams.height = TuneBannerSize.getBannerHeightPixels(this.mContext, getResources().getConfiguration().orientation);
    }
    if ((localLayoutParams instanceof FrameLayout.LayoutParams))
    {
      localObject = new FrameLayout.LayoutParams(localLayoutParams.width, localLayoutParams.height);
      switch (this.mPosition)
      {
      default: 
        ((FrameLayout.LayoutParams)localObject).gravity = 81;
      }
    }
    do
    {
      for (;;)
      {
        setLayoutParams((ViewGroup.LayoutParams)localObject);
        return;
        ((FrameLayout.LayoutParams)localObject).gravity = 49;
      }
      localObject = localLayoutParams;
    } while (!(localLayoutParams instanceof RelativeLayout.LayoutParams));
    Object localObject = new RelativeLayout.LayoutParams(localLayoutParams.width, localLayoutParams.height);
    switch (this.mPosition)
    {
    default: 
      ((RelativeLayout.LayoutParams)localObject).addRule(12);
      ((RelativeLayout.LayoutParams)localObject).addRule(14);
    }
    for (;;)
    {
      break;
      ((RelativeLayout.LayoutParams)localObject).addRule(10);
      ((RelativeLayout.LayoutParams)localObject).addRule(14);
    }
  }
  
  private void processClick(String paramString)
  {
    Intent localIntent = new Intent(getContext(), TuneAdActivity.class);
    localIntent.putExtra("INTERSTITIAL", false);
    localIntent.putExtra("REDIRECT_URI", paramString);
    ((Activity)getContext()).startActivity(localIntent);
    notifyOnClick();
    TuneAdClient.logClick(this.mAdView, this.mAdParams.toJSON());
  }
  
  private void restartWithDuration(int paramInt)
  {
    if (this.loadFuture != null) {
      this.loadFuture.cancel(false);
    }
    if (paramInt > 0) {
      this.loadFuture = this.mScheduler.scheduleAtFixedRate(new RefreshTask(null), paramInt, paramInt, TimeUnit.SECONDS);
    }
  }
  
  public void destroy()
  {
    pause();
    this.mScheduler.shutdown();
    setListener(null);
    if (this.mViewSwitcher != null)
    {
      this.mViewSwitcher.removeAllViews();
      removeView(this.mViewSwitcher);
    }
    this.mViewSwitcher = null;
    if (this.mWebView1 != null) {
      this.mWebView1.destroy();
    }
    if (this.mWebView2 != null) {
      this.mWebView2.destroy();
    }
    this.mWebView1 = null;
    this.mWebView2 = null;
    this.utils.destroyAdViews();
    this.utils = null;
    this.mOrientation = null;
    this.mMetadata = null;
  }
  
  public TuneAdView getCurrentAd()
  {
    return this.mAdView;
  }
  
  public TuneAdParams getParams()
  {
    return this.mAdParams;
  }
  
  public TuneBannerPosition getPosition()
  {
    return this.mPosition;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    paramInt2 = getResources().getConfiguration().orientation;
    if (paramInt2 != this.mLastOrientation)
    {
      this.mLastOrientation = paramInt2;
      paramInt1 = TuneBannerSize.getScreenWidthPixels(this.mContext);
      paramInt2 = TuneBannerSize.getBannerHeightPixels(this.mContext, paramInt2);
      paramInt1 = View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824);
      paramInt2 = View.MeasureSpec.makeMeasureSpec(paramInt2, 1073741824);
      super.onMeasure(paramInt1, paramInt2);
      measureChildren(paramInt1, paramInt2);
    }
  }
  
  public void pause()
  {
    if (this.loadFuture != null) {
      this.loadFuture.cancel(true);
    }
  }
  
  public void resume()
  {
    if ((this.loadFuture != null) && (this.loadFuture.isCancelled()) && (this.mDuration > 0)) {
      this.loadFuture = this.mScheduler.scheduleAtFixedRate(new RefreshTask(null), 0L, this.mDuration, TimeUnit.SECONDS);
    }
  }
  
  public void setListener(TuneAdListener paramTuneAdListener)
  {
    this.mListener = paramTuneAdListener;
  }
  
  public void setPosition(TuneBannerPosition paramTuneBannerPosition)
  {
    this.mPosition = paramTuneBannerPosition;
  }
  
  public void show(String paramString)
  {
    if (this.mMetadata == null) {
      this.mMetadata = new TuneAdMetadata();
    }
    show(paramString, this.mMetadata);
  }
  
  public void show(String paramString, TuneAdMetadata paramTuneAdMetadata)
  {
    if ((paramString == null) || (paramString.isEmpty()) || (paramString.equals("null"))) {
      throw new IllegalArgumentException("Placement must not be null or empty");
    }
    if (this.mAdView == null) {
      this.mAdView = new TuneAdView(paramString, paramTuneAdMetadata, (WebView)this.mViewSwitcher.getCurrentView());
    }
    this.mPlacement = paramString;
    this.mMetadata = paramTuneAdMetadata;
    if (this.loadFuture != null) {
      this.loadFuture.cancel(true);
    }
    if (this.mDuration > 0) {
      this.loadFuture = this.mScheduler.scheduleAtFixedRate(new RefreshTask(null), 0L, this.mDuration, TimeUnit.SECONDS);
    }
  }
  
  private class RefreshTask
    implements Runnable
  {
    private RefreshTask() {}
    
    public void run()
    {
      TuneBanner.this.loadAd();
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/tune/crosspromo/TuneBanner.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */