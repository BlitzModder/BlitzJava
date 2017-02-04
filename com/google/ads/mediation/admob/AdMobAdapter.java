package com.google.ads.mediation.admob;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.ads.mediation.AbstractAdViewAdapter;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationNativeAdapter;
import com.google.android.gms.internal.zzjy;

public final class AdMobAdapter
  extends AbstractAdViewAdapter
  implements MediationBannerAdapter, MediationNativeAdapter, zzjy
{
  protected Bundle zza(Bundle paramBundle1, Bundle paramBundle2)
  {
    if (paramBundle1 != null) {}
    for (;;)
    {
      paramBundle1.putInt("gw", 1);
      paramBundle1.putString("mad_hac", paramBundle2.getString("mad_hac"));
      if (!TextUtils.isEmpty(paramBundle2.getString("adJson"))) {
        paramBundle1.putString("_ad", paramBundle2.getString("adJson"));
      }
      paramBundle1.putBoolean("_noRefresh", true);
      return paramBundle1;
      paramBundle1 = new Bundle();
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/ads/mediation/admob/AdMobAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */