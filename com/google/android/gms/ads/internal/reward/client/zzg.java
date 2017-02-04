package com.google.android.gms.ads.internal.reward.client;

import com.google.android.gms.ads.reward.RewardedVideoAdListener;
import com.google.android.gms.internal.zzha;

@zzha
public class zzg
  extends zzd.zza
{
  private final RewardedVideoAdListener zzJl;
  
  public zzg(RewardedVideoAdListener paramRewardedVideoAdListener)
  {
    this.zzJl = paramRewardedVideoAdListener;
  }
  
  public void onRewardedVideoAdClosed()
  {
    if (this.zzJl != null) {
      this.zzJl.onRewardedVideoAdClosed();
    }
  }
  
  public void onRewardedVideoAdFailedToLoad(int paramInt)
  {
    if (this.zzJl != null) {
      this.zzJl.onRewardedVideoAdFailedToLoad(paramInt);
    }
  }
  
  public void onRewardedVideoAdLeftApplication()
  {
    if (this.zzJl != null) {
      this.zzJl.onRewardedVideoAdLeftApplication();
    }
  }
  
  public void onRewardedVideoAdLoaded()
  {
    if (this.zzJl != null) {
      this.zzJl.onRewardedVideoAdLoaded();
    }
  }
  
  public void onRewardedVideoAdOpened()
  {
    if (this.zzJl != null) {
      this.zzJl.onRewardedVideoAdOpened();
    }
  }
  
  public void onRewardedVideoStarted()
  {
    if (this.zzJl != null) {
      this.zzJl.onRewardedVideoStarted();
    }
  }
  
  public void zza(zza paramzza)
  {
    if (this.zzJl != null) {
      this.zzJl.onRewarded(new zze(paramzza));
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/ads/internal/reward/client/zzg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */