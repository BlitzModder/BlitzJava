package com.google.android.gms.ads.reward.mediation;

import com.google.android.gms.ads.reward.RewardItem;

public abstract interface MediationRewardedVideoAdListener
{
  public abstract void onAdClicked(MediationRewardedVideoAdAdapter paramMediationRewardedVideoAdAdapter);
  
  public abstract void onAdClosed(MediationRewardedVideoAdAdapter paramMediationRewardedVideoAdAdapter);
  
  public abstract void onAdFailedToLoad(MediationRewardedVideoAdAdapter paramMediationRewardedVideoAdAdapter, int paramInt);
  
  public abstract void onAdLeftApplication(MediationRewardedVideoAdAdapter paramMediationRewardedVideoAdAdapter);
  
  public abstract void onAdLoaded(MediationRewardedVideoAdAdapter paramMediationRewardedVideoAdAdapter);
  
  public abstract void onAdOpened(MediationRewardedVideoAdAdapter paramMediationRewardedVideoAdAdapter);
  
  public abstract void onInitializationFailed(MediationRewardedVideoAdAdapter paramMediationRewardedVideoAdAdapter, int paramInt);
  
  public abstract void onInitializationSucceeded(MediationRewardedVideoAdAdapter paramMediationRewardedVideoAdAdapter);
  
  public abstract void onRewarded(MediationRewardedVideoAdAdapter paramMediationRewardedVideoAdAdapter, RewardItem paramRewardItem);
  
  public abstract void onVideoStarted(MediationRewardedVideoAdAdapter paramMediationRewardedVideoAdAdapter);
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/ads/reward/mediation/MediationRewardedVideoAdListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */