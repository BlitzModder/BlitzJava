package com.google.android.gms.ads.doubleclick;

import android.content.Context;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.Correlator;
import com.google.android.gms.ads.internal.client.zzaa;

public final class PublisherInterstitialAd
{
  private final zzaa zzoA = new zzaa(paramContext, this);
  
  public PublisherInterstitialAd(Context paramContext) {}
  
  public AdListener getAdListener()
  {
    return this.zzoA.getAdListener();
  }
  
  public String getAdUnitId()
  {
    return this.zzoA.getAdUnitId();
  }
  
  public AppEventListener getAppEventListener()
  {
    return this.zzoA.getAppEventListener();
  }
  
  public String getMediationAdapterClassName()
  {
    return this.zzoA.getMediationAdapterClassName();
  }
  
  public OnCustomRenderedAdLoadedListener getOnCustomRenderedAdLoadedListener()
  {
    return this.zzoA.getOnCustomRenderedAdLoadedListener();
  }
  
  public boolean isLoaded()
  {
    return this.zzoA.isLoaded();
  }
  
  public boolean isLoading()
  {
    return this.zzoA.isLoading();
  }
  
  public void loadAd(PublisherAdRequest paramPublisherAdRequest)
  {
    this.zzoA.zza(paramPublisherAdRequest.zzaG());
  }
  
  public void setAdListener(AdListener paramAdListener)
  {
    this.zzoA.setAdListener(paramAdListener);
  }
  
  public void setAdUnitId(String paramString)
  {
    this.zzoA.setAdUnitId(paramString);
  }
  
  public void setAppEventListener(AppEventListener paramAppEventListener)
  {
    this.zzoA.setAppEventListener(paramAppEventListener);
  }
  
  public void setCorrelator(Correlator paramCorrelator)
  {
    this.zzoA.setCorrelator(paramCorrelator);
  }
  
  public void setOnCustomRenderedAdLoadedListener(OnCustomRenderedAdLoadedListener paramOnCustomRenderedAdLoadedListener)
  {
    this.zzoA.setOnCustomRenderedAdLoadedListener(paramOnCustomRenderedAdLoadedListener);
  }
  
  public void show()
  {
    this.zzoA.show();
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/ads/doubleclick/PublisherInterstitialAd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */