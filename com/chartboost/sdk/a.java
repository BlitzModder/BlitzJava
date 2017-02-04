package com.chartboost.sdk;

import android.app.Activity;
import com.chartboost.sdk.Model.CBError.CBClickError;
import com.chartboost.sdk.Model.CBError.CBImpressionError;

public abstract interface a
{
  public abstract void didCacheInPlay(String paramString);
  
  public abstract void didCacheInterstitial(String paramString);
  
  public abstract void didCacheMoreApps(String paramString);
  
  public abstract void didCacheRewardedVideo(String paramString);
  
  public abstract void didClickInterstitial(String paramString);
  
  public abstract void didClickMoreApps(String paramString);
  
  public abstract void didClickRewardedVideo(String paramString);
  
  public abstract void didCloseInterstitial(String paramString);
  
  public abstract void didCloseMoreApps(String paramString);
  
  public abstract void didCloseRewardedVideo(String paramString);
  
  public abstract void didCompleteRewardedVideo(String paramString, int paramInt);
  
  public abstract void didDismissInterstitial(String paramString);
  
  public abstract void didDismissMoreApps(String paramString);
  
  public abstract void didDismissRewardedVideo(String paramString);
  
  public abstract void didDisplayInterstitial(String paramString);
  
  public abstract void didDisplayMoreApps(String paramString);
  
  public abstract void didDisplayRewardedVideo(String paramString);
  
  public abstract void didFailToLoadInPlay(String paramString, CBError.CBImpressionError paramCBImpressionError);
  
  public abstract void didFailToLoadInterstitial(String paramString, CBError.CBImpressionError paramCBImpressionError);
  
  public abstract void didFailToLoadMoreApps(String paramString, CBError.CBImpressionError paramCBImpressionError);
  
  public abstract void didFailToLoadRewardedVideo(String paramString, CBError.CBImpressionError paramCBImpressionError);
  
  public abstract void didFailToRecordClick(String paramString, CBError.CBClickError paramCBClickError);
  
  public abstract void didInitialize();
  
  public abstract void didPauseClickForConfirmation(Activity paramActivity);
  
  public abstract boolean shouldDisplayInterstitial(String paramString);
  
  public abstract boolean shouldDisplayMoreApps(String paramString);
  
  public abstract boolean shouldDisplayRewardedVideo(String paramString);
  
  public abstract boolean shouldRequestInterstitial(String paramString);
  
  public abstract boolean shouldRequestMoreApps(String paramString);
  
  public abstract void willDisplayVideo(String paramString);
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/chartboost/sdk/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */