package com.google.android.gms.ads.reward;

import com.google.android.gms.ads.AdRequest;

public abstract interface RewardedVideoAd
{
  public abstract void destroy();
  
  public abstract RewardedVideoAdListener getRewardedVideoAdListener();
  
  public abstract String getUserId();
  
  public abstract boolean isLoaded();
  
  public abstract void loadAd(String paramString, AdRequest paramAdRequest);
  
  public abstract void pause();
  
  public abstract void resume();
  
  public abstract void setRewardedVideoAdListener(RewardedVideoAdListener paramRewardedVideoAdListener);
  
  public abstract void setUserId(String paramString);
  
  public abstract void show();
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/ads/reward/RewardedVideoAd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */