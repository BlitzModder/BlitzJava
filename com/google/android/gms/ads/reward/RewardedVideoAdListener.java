package com.google.android.gms.ads.reward;

public abstract interface RewardedVideoAdListener
{
  public abstract void onRewarded(RewardItem paramRewardItem);
  
  public abstract void onRewardedVideoAdClosed();
  
  public abstract void onRewardedVideoAdFailedToLoad(int paramInt);
  
  public abstract void onRewardedVideoAdLeftApplication();
  
  public abstract void onRewardedVideoAdLoaded();
  
  public abstract void onRewardedVideoAdOpened();
  
  public abstract void onRewardedVideoStarted();
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/ads/reward/RewardedVideoAdListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */