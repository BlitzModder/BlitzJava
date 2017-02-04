package com.google.android.gms.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.client.zza;
import com.google.android.gms.ads.internal.client.zzaa;
import com.google.android.gms.ads.purchase.InAppPurchaseListener;
import com.google.android.gms.ads.purchase.PlayStorePurchaseListener;

public final class InterstitialAd
{
  private final zzaa zzoA;
  
  public InterstitialAd(Context paramContext)
  {
    this.zzoA = new zzaa(paramContext);
  }
  
  public AdListener getAdListener()
  {
    return this.zzoA.getAdListener();
  }
  
  public String getAdUnitId()
  {
    return this.zzoA.getAdUnitId();
  }
  
  public InAppPurchaseListener getInAppPurchaseListener()
  {
    return this.zzoA.getInAppPurchaseListener();
  }
  
  public String getMediationAdapterClassName()
  {
    return this.zzoA.getMediationAdapterClassName();
  }
  
  public boolean isLoaded()
  {
    return this.zzoA.isLoaded();
  }
  
  public boolean isLoading()
  {
    return this.zzoA.isLoading();
  }
  
  public void loadAd(AdRequest paramAdRequest)
  {
    this.zzoA.zza(paramAdRequest.zzaG());
  }
  
  public void setAdListener(AdListener paramAdListener)
  {
    this.zzoA.setAdListener(paramAdListener);
    if ((paramAdListener != null) && ((paramAdListener instanceof zza))) {
      this.zzoA.zza((zza)paramAdListener);
    }
    while (paramAdListener != null) {
      return;
    }
    this.zzoA.zza(null);
  }
  
  public void setAdUnitId(String paramString)
  {
    this.zzoA.setAdUnitId(paramString);
  }
  
  public void setInAppPurchaseListener(InAppPurchaseListener paramInAppPurchaseListener)
  {
    this.zzoA.setInAppPurchaseListener(paramInAppPurchaseListener);
  }
  
  public void setPlayStorePurchaseParams(PlayStorePurchaseListener paramPlayStorePurchaseListener, String paramString)
  {
    this.zzoA.setPlayStorePurchaseParams(paramPlayStorePurchaseListener, paramString);
  }
  
  public void show()
  {
    this.zzoA.show();
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/ads/InterstitialAd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */