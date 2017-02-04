package com.google.android.gms.ads.mediation.customevent;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.mediation.MediationAdRequest;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationBannerListener;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialListener;
import com.google.android.gms.ads.mediation.MediationNativeAdapter;
import com.google.android.gms.ads.mediation.MediationNativeListener;
import com.google.android.gms.ads.mediation.NativeAdMapper;
import com.google.android.gms.ads.mediation.NativeMediationAdRequest;

public final class CustomEventAdapter
  implements MediationBannerAdapter, MediationInterstitialAdapter, MediationNativeAdapter
{
  CustomEventBanner zzMW;
  CustomEventInterstitial zzMX;
  CustomEventNative zzMY;
  private View zzbb;
  
  private void zza(View paramView)
  {
    this.zzbb = paramView;
  }
  
  private static <T> T zzj(String paramString)
  {
    try
    {
      Object localObject = Class.forName(paramString).newInstance();
      return (T)localObject;
    }
    catch (Throwable localThrowable)
    {
      zzb.zzaH("Could not instantiate custom event adapter: " + paramString + ". " + localThrowable.getMessage());
    }
    return null;
  }
  
  public View getBannerView()
  {
    return this.zzbb;
  }
  
  public void onDestroy()
  {
    if (this.zzMW != null) {
      this.zzMW.onDestroy();
    }
    if (this.zzMX != null) {
      this.zzMX.onDestroy();
    }
    if (this.zzMY != null) {
      this.zzMY.onDestroy();
    }
  }
  
  public void onPause()
  {
    if (this.zzMW != null) {
      this.zzMW.onPause();
    }
    if (this.zzMX != null) {
      this.zzMX.onPause();
    }
    if (this.zzMY != null) {
      this.zzMY.onPause();
    }
  }
  
  public void onResume()
  {
    if (this.zzMW != null) {
      this.zzMW.onResume();
    }
    if (this.zzMX != null) {
      this.zzMX.onResume();
    }
    if (this.zzMY != null) {
      this.zzMY.onResume();
    }
  }
  
  public void requestBannerAd(Context paramContext, MediationBannerListener paramMediationBannerListener, Bundle paramBundle1, AdSize paramAdSize, MediationAdRequest paramMediationAdRequest, Bundle paramBundle2)
  {
    this.zzMW = ((CustomEventBanner)zzj(paramBundle1.getString("class_name")));
    if (this.zzMW == null)
    {
      paramMediationBannerListener.onAdFailedToLoad(this, 0);
      return;
    }
    if (paramBundle2 == null) {}
    for (paramBundle2 = null;; paramBundle2 = paramBundle2.getBundle(paramBundle1.getString("class_name")))
    {
      this.zzMW.requestBannerAd(paramContext, new zza(this, paramMediationBannerListener), paramBundle1.getString("parameter"), paramAdSize, paramMediationAdRequest, paramBundle2);
      return;
    }
  }
  
  public void requestInterstitialAd(Context paramContext, MediationInterstitialListener paramMediationInterstitialListener, Bundle paramBundle1, MediationAdRequest paramMediationAdRequest, Bundle paramBundle2)
  {
    this.zzMX = ((CustomEventInterstitial)zzj(paramBundle1.getString("class_name")));
    if (this.zzMX == null)
    {
      paramMediationInterstitialListener.onAdFailedToLoad(this, 0);
      return;
    }
    if (paramBundle2 == null) {}
    for (paramBundle2 = null;; paramBundle2 = paramBundle2.getBundle(paramBundle1.getString("class_name")))
    {
      this.zzMX.requestInterstitialAd(paramContext, zza(paramMediationInterstitialListener), paramBundle1.getString("parameter"), paramMediationAdRequest, paramBundle2);
      return;
    }
  }
  
  public void requestNativeAd(Context paramContext, MediationNativeListener paramMediationNativeListener, Bundle paramBundle1, NativeMediationAdRequest paramNativeMediationAdRequest, Bundle paramBundle2)
  {
    this.zzMY = ((CustomEventNative)zzj(paramBundle1.getString("class_name")));
    if (this.zzMY == null)
    {
      paramMediationNativeListener.onAdFailedToLoad(this, 0);
      return;
    }
    if (paramBundle2 == null) {}
    for (paramBundle2 = null;; paramBundle2 = paramBundle2.getBundle(paramBundle1.getString("class_name")))
    {
      this.zzMY.requestNativeAd(paramContext, new zzc(this, paramMediationNativeListener), paramBundle1.getString("parameter"), paramNativeMediationAdRequest, paramBundle2);
      return;
    }
  }
  
  public void showInterstitial()
  {
    this.zzMX.showInterstitial();
  }
  
  zzb zza(MediationInterstitialListener paramMediationInterstitialListener)
  {
    return new zzb(this, paramMediationInterstitialListener);
  }
  
  static final class zza
    implements CustomEventBannerListener
  {
    private final CustomEventAdapter zzMZ;
    private final MediationBannerListener zzaT;
    
    public zza(CustomEventAdapter paramCustomEventAdapter, MediationBannerListener paramMediationBannerListener)
    {
      this.zzMZ = paramCustomEventAdapter;
      this.zzaT = paramMediationBannerListener;
    }
    
    public void onAdClicked()
    {
      zzb.zzaF("Custom event adapter called onAdClicked.");
      this.zzaT.onAdClicked(this.zzMZ);
    }
    
    public void onAdClosed()
    {
      zzb.zzaF("Custom event adapter called onAdClosed.");
      this.zzaT.onAdClosed(this.zzMZ);
    }
    
    public void onAdFailedToLoad(int paramInt)
    {
      zzb.zzaF("Custom event adapter called onAdFailedToLoad.");
      this.zzaT.onAdFailedToLoad(this.zzMZ, paramInt);
    }
    
    public void onAdLeftApplication()
    {
      zzb.zzaF("Custom event adapter called onAdLeftApplication.");
      this.zzaT.onAdLeftApplication(this.zzMZ);
    }
    
    public void onAdLoaded(View paramView)
    {
      zzb.zzaF("Custom event adapter called onAdLoaded.");
      CustomEventAdapter.zza(this.zzMZ, paramView);
      this.zzaT.onAdLoaded(this.zzMZ);
    }
    
    public void onAdOpened()
    {
      zzb.zzaF("Custom event adapter called onAdOpened.");
      this.zzaT.onAdOpened(this.zzMZ);
    }
  }
  
  class zzb
    implements CustomEventInterstitialListener
  {
    private final CustomEventAdapter zzMZ;
    private final MediationInterstitialListener zzaU;
    
    public zzb(CustomEventAdapter paramCustomEventAdapter, MediationInterstitialListener paramMediationInterstitialListener)
    {
      this.zzMZ = paramCustomEventAdapter;
      this.zzaU = paramMediationInterstitialListener;
    }
    
    public void onAdClicked()
    {
      zzb.zzaF("Custom event adapter called onAdClicked.");
      this.zzaU.onAdClicked(this.zzMZ);
    }
    
    public void onAdClosed()
    {
      zzb.zzaF("Custom event adapter called onAdClosed.");
      this.zzaU.onAdClosed(this.zzMZ);
    }
    
    public void onAdFailedToLoad(int paramInt)
    {
      zzb.zzaF("Custom event adapter called onFailedToReceiveAd.");
      this.zzaU.onAdFailedToLoad(this.zzMZ, paramInt);
    }
    
    public void onAdLeftApplication()
    {
      zzb.zzaF("Custom event adapter called onAdLeftApplication.");
      this.zzaU.onAdLeftApplication(this.zzMZ);
    }
    
    public void onAdLoaded()
    {
      zzb.zzaF("Custom event adapter called onReceivedAd.");
      this.zzaU.onAdLoaded(CustomEventAdapter.this);
    }
    
    public void onAdOpened()
    {
      zzb.zzaF("Custom event adapter called onAdOpened.");
      this.zzaU.onAdOpened(this.zzMZ);
    }
  }
  
  static class zzc
    implements CustomEventNativeListener
  {
    private final CustomEventAdapter zzMZ;
    private final MediationNativeListener zzaV;
    
    public zzc(CustomEventAdapter paramCustomEventAdapter, MediationNativeListener paramMediationNativeListener)
    {
      this.zzMZ = paramCustomEventAdapter;
      this.zzaV = paramMediationNativeListener;
    }
    
    public void onAdClicked()
    {
      zzb.zzaF("Custom event adapter called onAdClicked.");
      this.zzaV.onAdClicked(this.zzMZ);
    }
    
    public void onAdClosed()
    {
      zzb.zzaF("Custom event adapter called onAdClosed.");
      this.zzaV.onAdClosed(this.zzMZ);
    }
    
    public void onAdFailedToLoad(int paramInt)
    {
      zzb.zzaF("Custom event adapter called onAdFailedToLoad.");
      this.zzaV.onAdFailedToLoad(this.zzMZ, paramInt);
    }
    
    public void onAdLeftApplication()
    {
      zzb.zzaF("Custom event adapter called onAdLeftApplication.");
      this.zzaV.onAdLeftApplication(this.zzMZ);
    }
    
    public void onAdLoaded(NativeAdMapper paramNativeAdMapper)
    {
      zzb.zzaF("Custom event adapter called onAdLoaded.");
      this.zzaV.onAdLoaded(this.zzMZ, paramNativeAdMapper);
    }
    
    public void onAdOpened()
    {
      zzb.zzaF("Custom event adapter called onAdOpened.");
      this.zzaV.onAdOpened(this.zzMZ);
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/ads/mediation/customevent/CustomEventAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */