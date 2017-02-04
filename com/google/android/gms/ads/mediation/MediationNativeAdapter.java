package com.google.android.gms.ads.mediation;

import android.content.Context;
import android.os.Bundle;

public abstract interface MediationNativeAdapter
  extends MediationAdapter
{
  public abstract void requestNativeAd(Context paramContext, MediationNativeListener paramMediationNativeListener, Bundle paramBundle1, NativeMediationAdRequest paramNativeMediationAdRequest, Bundle paramBundle2);
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/ads/mediation/MediationNativeAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */