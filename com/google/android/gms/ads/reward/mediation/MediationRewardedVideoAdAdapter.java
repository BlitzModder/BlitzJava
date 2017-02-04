package com.google.android.gms.ads.reward.mediation;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.ads.mediation.MediationAdRequest;
import com.google.android.gms.ads.mediation.MediationAdapter;

public abstract interface MediationRewardedVideoAdAdapter
  extends MediationAdapter
{
  public abstract void initialize(Context paramContext, MediationAdRequest paramMediationAdRequest, String paramString, MediationRewardedVideoAdListener paramMediationRewardedVideoAdListener, Bundle paramBundle1, Bundle paramBundle2);
  
  public abstract boolean isInitialized();
  
  public abstract void loadAd(MediationAdRequest paramMediationAdRequest, Bundle paramBundle1, Bundle paramBundle2);
  
  public abstract void showVideo();
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/ads/reward/mediation/MediationRewardedVideoAdAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */