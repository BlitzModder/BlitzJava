package com.google.android.gms.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.client.zzab;
import com.google.android.gms.ads.internal.client.zzac;
import com.google.android.gms.ads.reward.RewardedVideoAd;

public class MobileAds
{
  public static RewardedVideoAd getRewardedVideoAdInstance(Context paramContext)
  {
    return zzab.zzdc().getRewardedVideoAdInstance(paramContext);
  }
  
  public static void initialize(Context paramContext)
  {
    zzab.zzdc().initialize(paramContext);
  }
  
  @Deprecated
  public static void initialize(Context paramContext, String paramString)
  {
    initialize(paramContext, paramString, null);
  }
  
  @Deprecated
  public static void initialize(Context paramContext, String paramString, Settings paramSettings)
  {
    zzab localzzab = zzab.zzdc();
    if (paramSettings == null) {}
    for (paramSettings = null;; paramSettings = paramSettings.zzaI())
    {
      localzzab.zza(paramContext, paramString, paramSettings);
      return;
    }
  }
  
  public static final class Settings
  {
    private final zzac zzoB = new zzac();
    
    @Deprecated
    public String getTrackingId()
    {
      return this.zzoB.getTrackingId();
    }
    
    @Deprecated
    public boolean isGoogleAnalyticsEnabled()
    {
      return this.zzoB.isGoogleAnalyticsEnabled();
    }
    
    @Deprecated
    public Settings setGoogleAnalyticsEnabled(boolean paramBoolean)
    {
      this.zzoB.zzm(paramBoolean);
      return this;
    }
    
    @Deprecated
    public Settings setTrackingId(String paramString)
    {
      this.zzoB.zzO(paramString);
      return this;
    }
    
    zzac zzaI()
    {
      return this.zzoB;
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/ads/MobileAds.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */