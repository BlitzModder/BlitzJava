package com.google.ads.mediation.customevent;

import android.app.Activity;
import android.view.View;
import com.google.ads.AdRequest.ErrorCode;
import com.google.ads.AdSize;
import com.google.ads.mediation.MediationAdRequest;
import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationBannerListener;
import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.ads.mediation.MediationInterstitialListener;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.mediation.customevent.CustomEventExtras;

public final class CustomEventAdapter
  implements MediationBannerAdapter<CustomEventExtras, CustomEventServerParameters>, MediationInterstitialAdapter<CustomEventExtras, CustomEventServerParameters>
{
  private View zzbb;
  CustomEventBanner zzbc;
  CustomEventInterstitial zzbd;
  
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
  
  public void destroy()
  {
    if (this.zzbc != null) {
      this.zzbc.destroy();
    }
    if (this.zzbd != null) {
      this.zzbd.destroy();
    }
  }
  
  public Class<CustomEventExtras> getAdditionalParametersType()
  {
    return CustomEventExtras.class;
  }
  
  public View getBannerView()
  {
    return this.zzbb;
  }
  
  public Class<CustomEventServerParameters> getServerParametersType()
  {
    return CustomEventServerParameters.class;
  }
  
  public void requestBannerAd(MediationBannerListener paramMediationBannerListener, Activity paramActivity, CustomEventServerParameters paramCustomEventServerParameters, AdSize paramAdSize, MediationAdRequest paramMediationAdRequest, CustomEventExtras paramCustomEventExtras)
  {
    this.zzbc = ((CustomEventBanner)zzj(paramCustomEventServerParameters.className));
    if (this.zzbc == null)
    {
      paramMediationBannerListener.onFailedToReceiveAd(this, AdRequest.ErrorCode.INTERNAL_ERROR);
      return;
    }
    if (paramCustomEventExtras == null) {}
    for (paramCustomEventExtras = null;; paramCustomEventExtras = paramCustomEventExtras.getExtra(paramCustomEventServerParameters.label))
    {
      this.zzbc.requestBannerAd(new zza(this, paramMediationBannerListener), paramActivity, paramCustomEventServerParameters.label, paramCustomEventServerParameters.parameter, paramAdSize, paramMediationAdRequest, paramCustomEventExtras);
      return;
    }
  }
  
  public void requestInterstitialAd(MediationInterstitialListener paramMediationInterstitialListener, Activity paramActivity, CustomEventServerParameters paramCustomEventServerParameters, MediationAdRequest paramMediationAdRequest, CustomEventExtras paramCustomEventExtras)
  {
    this.zzbd = ((CustomEventInterstitial)zzj(paramCustomEventServerParameters.className));
    if (this.zzbd == null)
    {
      paramMediationInterstitialListener.onFailedToReceiveAd(this, AdRequest.ErrorCode.INTERNAL_ERROR);
      return;
    }
    if (paramCustomEventExtras == null) {}
    for (paramCustomEventExtras = null;; paramCustomEventExtras = paramCustomEventExtras.getExtra(paramCustomEventServerParameters.label))
    {
      this.zzbd.requestInterstitialAd(zza(paramMediationInterstitialListener), paramActivity, paramCustomEventServerParameters.label, paramCustomEventServerParameters.parameter, paramMediationAdRequest, paramCustomEventExtras);
      return;
    }
  }
  
  public void showInterstitial()
  {
    this.zzbd.showInterstitial();
  }
  
  zzb zza(MediationInterstitialListener paramMediationInterstitialListener)
  {
    return new zzb(this, paramMediationInterstitialListener);
  }
  
  static final class zza
    implements CustomEventBannerListener
  {
    private final CustomEventAdapter zzbe;
    private final MediationBannerListener zzbf;
    
    public zza(CustomEventAdapter paramCustomEventAdapter, MediationBannerListener paramMediationBannerListener)
    {
      this.zzbe = paramCustomEventAdapter;
      this.zzbf = paramMediationBannerListener;
    }
    
    public void onClick()
    {
      zzb.zzaF("Custom event adapter called onFailedToReceiveAd.");
      this.zzbf.onClick(this.zzbe);
    }
    
    public void onDismissScreen()
    {
      zzb.zzaF("Custom event adapter called onFailedToReceiveAd.");
      this.zzbf.onDismissScreen(this.zzbe);
    }
    
    public void onFailedToReceiveAd()
    {
      zzb.zzaF("Custom event adapter called onFailedToReceiveAd.");
      this.zzbf.onFailedToReceiveAd(this.zzbe, AdRequest.ErrorCode.NO_FILL);
    }
    
    public void onLeaveApplication()
    {
      zzb.zzaF("Custom event adapter called onFailedToReceiveAd.");
      this.zzbf.onLeaveApplication(this.zzbe);
    }
    
    public void onPresentScreen()
    {
      zzb.zzaF("Custom event adapter called onFailedToReceiveAd.");
      this.zzbf.onPresentScreen(this.zzbe);
    }
    
    public void onReceivedAd(View paramView)
    {
      zzb.zzaF("Custom event adapter called onReceivedAd.");
      CustomEventAdapter.zza(this.zzbe, paramView);
      this.zzbf.onReceivedAd(this.zzbe);
    }
  }
  
  class zzb
    implements CustomEventInterstitialListener
  {
    private final CustomEventAdapter zzbe;
    private final MediationInterstitialListener zzbg;
    
    public zzb(CustomEventAdapter paramCustomEventAdapter, MediationInterstitialListener paramMediationInterstitialListener)
    {
      this.zzbe = paramCustomEventAdapter;
      this.zzbg = paramMediationInterstitialListener;
    }
    
    public void onDismissScreen()
    {
      zzb.zzaF("Custom event adapter called onDismissScreen.");
      this.zzbg.onDismissScreen(this.zzbe);
    }
    
    public void onFailedToReceiveAd()
    {
      zzb.zzaF("Custom event adapter called onFailedToReceiveAd.");
      this.zzbg.onFailedToReceiveAd(this.zzbe, AdRequest.ErrorCode.NO_FILL);
    }
    
    public void onLeaveApplication()
    {
      zzb.zzaF("Custom event adapter called onLeaveApplication.");
      this.zzbg.onLeaveApplication(this.zzbe);
    }
    
    public void onPresentScreen()
    {
      zzb.zzaF("Custom event adapter called onPresentScreen.");
      this.zzbg.onPresentScreen(this.zzbe);
    }
    
    public void onReceivedAd()
    {
      zzb.zzaF("Custom event adapter called onReceivedAd.");
      this.zzbg.onReceivedAd(CustomEventAdapter.this);
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/ads/mediation/customevent/CustomEventAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */