package com.chartboost.sdk;

import android.app.Activity;
import android.os.Bundle;
import com.chartboost.sdk.Model.CBError.CBClickError;
import com.chartboost.sdk.Model.CBError.CBImpressionError;

@Deprecated
public abstract class ChartboostActivity
  extends Activity
  implements a
{
  public void didCacheInPlay(String paramString) {}
  
  public void didCacheInterstitial(String paramString) {}
  
  public void didCacheMoreApps(String paramString) {}
  
  public void didCacheRewardedVideo(String paramString) {}
  
  public void didClickInterstitial(String paramString) {}
  
  public void didClickMoreApps(String paramString) {}
  
  public void didClickRewardedVideo(String paramString) {}
  
  public void didCloseInterstitial(String paramString) {}
  
  public void didCloseMoreApps(String paramString) {}
  
  public void didCloseRewardedVideo(String paramString) {}
  
  public void didCompleteRewardedVideo(String paramString, int paramInt) {}
  
  public void didDismissInterstitial(String paramString) {}
  
  public void didDismissMoreApps(String paramString) {}
  
  public void didDismissRewardedVideo(String paramString) {}
  
  public void didDisplayInterstitial(String paramString) {}
  
  public void didDisplayMoreApps(String paramString) {}
  
  public void didDisplayRewardedVideo(String paramString) {}
  
  public void didFailToLoadInPlay(String paramString, CBError.CBImpressionError paramCBImpressionError) {}
  
  public void didFailToLoadInterstitial(String paramString, CBError.CBImpressionError paramCBImpressionError) {}
  
  public void didFailToLoadMoreApps(String paramString, CBError.CBImpressionError paramCBImpressionError) {}
  
  public void didFailToLoadRewardedVideo(String paramString, CBError.CBImpressionError paramCBImpressionError) {}
  
  public void didFailToRecordClick(String paramString, CBError.CBClickError paramCBClickError) {}
  
  public void didInitialize() {}
  
  public void didPauseClickForConfirmation() {}
  
  public void onBackPressed()
  {
    if (Chartboost.onBackPressed()) {
      return;
    }
    super.onBackPressed();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    c.a(this);
    Chartboost.onCreate(this);
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if (isFinishing()) {
      Chartboost.onDestroy(this);
    }
  }
  
  protected void onPause()
  {
    super.onPause();
    Chartboost.onPause(this);
  }
  
  protected void onResume()
  {
    super.onResume();
    Chartboost.onResume(this);
  }
  
  protected void onStart()
  {
    super.onStart();
    Chartboost.onStart(this);
  }
  
  protected void onStop()
  {
    super.onStop();
    Chartboost.onStop(this);
  }
  
  public boolean shouldDisplayInterstitial(String paramString)
  {
    return true;
  }
  
  public boolean shouldDisplayMoreApps(String paramString)
  {
    return true;
  }
  
  public boolean shouldDisplayRewardedVideo(String paramString)
  {
    return true;
  }
  
  public boolean shouldRequestInterstitial(String paramString)
  {
    return true;
  }
  
  public boolean shouldRequestMoreApps(String paramString)
  {
    return true;
  }
  
  public void willDisplayVideo(String paramString) {}
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/chartboost/sdk/ChartboostActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */