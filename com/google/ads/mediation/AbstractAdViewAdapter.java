package com.google.ads.mediation;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import android.view.View;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdLoader;
import com.google.android.gms.ads.AdLoader.Builder;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdRequest.Builder;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.ads.formats.NativeAdView;
import com.google.android.gms.ads.formats.NativeAppInstallAd;
import com.google.android.gms.ads.formats.NativeAppInstallAd.OnAppInstallAdLoadedListener;
import com.google.android.gms.ads.formats.NativeContentAd;
import com.google.android.gms.ads.formats.NativeContentAd.OnContentAdLoadedListener;
import com.google.android.gms.ads.internal.client.zzl;
import com.google.android.gms.ads.mediation.MediationAdRequest;
import com.google.android.gms.ads.mediation.MediationAdapter.zza;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationBannerListener;
import com.google.android.gms.ads.mediation.MediationInterstitialListener;
import com.google.android.gms.ads.mediation.MediationNativeAdapter;
import com.google.android.gms.ads.mediation.MediationNativeListener;
import com.google.android.gms.ads.mediation.NativeAppInstallAdMapper;
import com.google.android.gms.ads.mediation.NativeContentAdMapper;
import com.google.android.gms.ads.mediation.NativeMediationAdRequest;
import com.google.android.gms.internal.zzha;
import com.google.android.gms.internal.zzjy;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

@zzha
public abstract class AbstractAdViewAdapter
  implements MediationBannerAdapter, MediationNativeAdapter, zzjy
{
  public static final String AD_UNIT_ID_PARAMETER = "pubid";
  protected AdView zzaN;
  protected InterstitialAd zzaO;
  private AdLoader zzaP;
  
  public String getAdUnitId(Bundle paramBundle)
  {
    return paramBundle.getString("pubid");
  }
  
  public View getBannerView()
  {
    return this.zzaN;
  }
  
  public Bundle getInterstitialAdapterInfo()
  {
    return new MediationAdapter.zza().zzS(1).zzie();
  }
  
  public void onDestroy()
  {
    if (this.zzaN != null)
    {
      this.zzaN.destroy();
      this.zzaN = null;
    }
    if (this.zzaO != null) {
      this.zzaO = null;
    }
    if (this.zzaP != null) {
      this.zzaP = null;
    }
  }
  
  public void onPause()
  {
    if (this.zzaN != null) {
      this.zzaN.pause();
    }
  }
  
  public void onResume()
  {
    if (this.zzaN != null) {
      this.zzaN.resume();
    }
  }
  
  public void requestBannerAd(Context paramContext, MediationBannerListener paramMediationBannerListener, Bundle paramBundle1, AdSize paramAdSize, MediationAdRequest paramMediationAdRequest, Bundle paramBundle2)
  {
    this.zzaN = new AdView(paramContext);
    this.zzaN.setAdSize(new AdSize(paramAdSize.getWidth(), paramAdSize.getHeight()));
    this.zzaN.setAdUnitId(getAdUnitId(paramBundle1));
    this.zzaN.setAdListener(new zzc(this, paramMediationBannerListener));
    this.zzaN.loadAd(zza(paramContext, paramMediationAdRequest, paramBundle2, paramBundle1));
  }
  
  public void requestInterstitialAd(Context paramContext, MediationInterstitialListener paramMediationInterstitialListener, Bundle paramBundle1, MediationAdRequest paramMediationAdRequest, Bundle paramBundle2)
  {
    this.zzaO = new InterstitialAd(paramContext);
    this.zzaO.setAdUnitId(getAdUnitId(paramBundle1));
    this.zzaO.setAdListener(new zzd(this, paramMediationInterstitialListener));
    this.zzaO.loadAd(zza(paramContext, paramMediationAdRequest, paramBundle2, paramBundle1));
  }
  
  public void requestNativeAd(Context paramContext, MediationNativeListener paramMediationNativeListener, Bundle paramBundle1, NativeMediationAdRequest paramNativeMediationAdRequest, Bundle paramBundle2)
  {
    paramMediationNativeListener = new zze(this, paramMediationNativeListener);
    AdLoader.Builder localBuilder = zza(paramContext, paramBundle1.getString("pubid")).withAdListener(paramMediationNativeListener);
    NativeAdOptions localNativeAdOptions = paramNativeMediationAdRequest.getNativeAdOptions();
    if (localNativeAdOptions != null) {
      localBuilder.withNativeAdOptions(localNativeAdOptions);
    }
    if (paramNativeMediationAdRequest.isAppInstallAdRequested()) {
      localBuilder.forAppInstallAd(paramMediationNativeListener);
    }
    if (paramNativeMediationAdRequest.isContentAdRequested()) {
      localBuilder.forContentAd(paramMediationNativeListener);
    }
    this.zzaP = localBuilder.build();
    this.zzaP.loadAd(zza(paramContext, paramNativeMediationAdRequest, paramBundle2, paramBundle1));
  }
  
  public void showInterstitial()
  {
    this.zzaO.show();
  }
  
  protected abstract Bundle zza(Bundle paramBundle1, Bundle paramBundle2);
  
  AdLoader.Builder zza(Context paramContext, String paramString)
  {
    return new AdLoader.Builder(paramContext, paramString);
  }
  
  AdRequest zza(Context paramContext, MediationAdRequest paramMediationAdRequest, Bundle paramBundle1, Bundle paramBundle2)
  {
    AdRequest.Builder localBuilder = new AdRequest.Builder();
    Object localObject = paramMediationAdRequest.getBirthday();
    if (localObject != null) {
      localBuilder.setBirthday((Date)localObject);
    }
    int i = paramMediationAdRequest.getGender();
    if (i != 0) {
      localBuilder.setGender(i);
    }
    localObject = paramMediationAdRequest.getKeywords();
    if (localObject != null)
    {
      localObject = ((Set)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        localBuilder.addKeyword((String)((Iterator)localObject).next());
      }
    }
    localObject = paramMediationAdRequest.getLocation();
    if (localObject != null) {
      localBuilder.setLocation((Location)localObject);
    }
    if (paramMediationAdRequest.isTesting()) {
      localBuilder.addTestDevice(zzl.zzcN().zzS(paramContext));
    }
    if (paramMediationAdRequest.taggedForChildDirectedTreatment() != -1) {
      if (paramMediationAdRequest.taggedForChildDirectedTreatment() != 1) {
        break label210;
      }
    }
    label210:
    for (boolean bool = true;; bool = false)
    {
      localBuilder.tagForChildDirectedTreatment(bool);
      localBuilder.setIsDesignedForFamilies(paramMediationAdRequest.isDesignedForFamilies());
      localBuilder.addNetworkExtrasBundle(AdMobAdapter.class, zza(paramBundle1, paramBundle2));
      return localBuilder.build();
    }
  }
  
  static class zza
    extends NativeAppInstallAdMapper
  {
    private final NativeAppInstallAd zzaQ;
    
    public zza(NativeAppInstallAd paramNativeAppInstallAd)
    {
      this.zzaQ = paramNativeAppInstallAd;
      setHeadline(paramNativeAppInstallAd.getHeadline().toString());
      setImages(paramNativeAppInstallAd.getImages());
      setBody(paramNativeAppInstallAd.getBody().toString());
      setIcon(paramNativeAppInstallAd.getIcon());
      setCallToAction(paramNativeAppInstallAd.getCallToAction().toString());
      setStarRating(paramNativeAppInstallAd.getStarRating().doubleValue());
      setStore(paramNativeAppInstallAd.getStore().toString());
      setPrice(paramNativeAppInstallAd.getPrice().toString());
      setOverrideImpressionRecording(true);
      setOverrideClickHandling(true);
    }
    
    public void trackView(View paramView)
    {
      if ((paramView instanceof NativeAdView)) {
        ((NativeAdView)paramView).setNativeAd(this.zzaQ);
      }
    }
  }
  
  static class zzb
    extends NativeContentAdMapper
  {
    private final NativeContentAd zzaR;
    
    public zzb(NativeContentAd paramNativeContentAd)
    {
      this.zzaR = paramNativeContentAd;
      setHeadline(paramNativeContentAd.getHeadline().toString());
      setImages(paramNativeContentAd.getImages());
      setBody(paramNativeContentAd.getBody().toString());
      setLogo(paramNativeContentAd.getLogo());
      setCallToAction(paramNativeContentAd.getCallToAction().toString());
      setAdvertiser(paramNativeContentAd.getAdvertiser().toString());
      setOverrideImpressionRecording(true);
      setOverrideClickHandling(true);
    }
    
    public void trackView(View paramView)
    {
      if ((paramView instanceof NativeAdView)) {
        ((NativeAdView)paramView).setNativeAd(this.zzaR);
      }
    }
  }
  
  static final class zzc
    extends AdListener
    implements com.google.android.gms.ads.internal.client.zza
  {
    final AbstractAdViewAdapter zzaS;
    final MediationBannerListener zzaT;
    
    public zzc(AbstractAdViewAdapter paramAbstractAdViewAdapter, MediationBannerListener paramMediationBannerListener)
    {
      this.zzaS = paramAbstractAdViewAdapter;
      this.zzaT = paramMediationBannerListener;
    }
    
    public void onAdClicked()
    {
      this.zzaT.onAdClicked(this.zzaS);
    }
    
    public void onAdClosed()
    {
      this.zzaT.onAdClosed(this.zzaS);
    }
    
    public void onAdFailedToLoad(int paramInt)
    {
      this.zzaT.onAdFailedToLoad(this.zzaS, paramInt);
    }
    
    public void onAdLeftApplication()
    {
      this.zzaT.onAdLeftApplication(this.zzaS);
    }
    
    public void onAdLoaded()
    {
      this.zzaT.onAdLoaded(this.zzaS);
    }
    
    public void onAdOpened()
    {
      this.zzaT.onAdOpened(this.zzaS);
    }
  }
  
  static final class zzd
    extends AdListener
    implements com.google.android.gms.ads.internal.client.zza
  {
    final AbstractAdViewAdapter zzaS;
    final MediationInterstitialListener zzaU;
    
    public zzd(AbstractAdViewAdapter paramAbstractAdViewAdapter, MediationInterstitialListener paramMediationInterstitialListener)
    {
      this.zzaS = paramAbstractAdViewAdapter;
      this.zzaU = paramMediationInterstitialListener;
    }
    
    public void onAdClicked()
    {
      this.zzaU.onAdClicked(this.zzaS);
    }
    
    public void onAdClosed()
    {
      this.zzaU.onAdClosed(this.zzaS);
    }
    
    public void onAdFailedToLoad(int paramInt)
    {
      this.zzaU.onAdFailedToLoad(this.zzaS, paramInt);
    }
    
    public void onAdLeftApplication()
    {
      this.zzaU.onAdLeftApplication(this.zzaS);
    }
    
    public void onAdLoaded()
    {
      this.zzaU.onAdLoaded(this.zzaS);
    }
    
    public void onAdOpened()
    {
      this.zzaU.onAdOpened(this.zzaS);
    }
  }
  
  static final class zze
    extends AdListener
    implements NativeAppInstallAd.OnAppInstallAdLoadedListener, NativeContentAd.OnContentAdLoadedListener, com.google.android.gms.ads.internal.client.zza
  {
    final AbstractAdViewAdapter zzaS;
    final MediationNativeListener zzaV;
    
    public zze(AbstractAdViewAdapter paramAbstractAdViewAdapter, MediationNativeListener paramMediationNativeListener)
    {
      this.zzaS = paramAbstractAdViewAdapter;
      this.zzaV = paramMediationNativeListener;
    }
    
    public void onAdClicked()
    {
      this.zzaV.onAdClicked(this.zzaS);
    }
    
    public void onAdClosed()
    {
      this.zzaV.onAdClosed(this.zzaS);
    }
    
    public void onAdFailedToLoad(int paramInt)
    {
      this.zzaV.onAdFailedToLoad(this.zzaS, paramInt);
    }
    
    public void onAdLeftApplication()
    {
      this.zzaV.onAdLeftApplication(this.zzaS);
    }
    
    public void onAdLoaded() {}
    
    public void onAdOpened()
    {
      this.zzaV.onAdOpened(this.zzaS);
    }
    
    public void onAppInstallAdLoaded(NativeAppInstallAd paramNativeAppInstallAd)
    {
      this.zzaV.onAdLoaded(this.zzaS, new AbstractAdViewAdapter.zza(paramNativeAppInstallAd));
    }
    
    public void onContentAdLoaded(NativeContentAd paramNativeContentAd)
    {
      this.zzaV.onAdLoaded(this.zzaS, new AbstractAdViewAdapter.zzb(paramNativeContentAd));
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/ads/mediation/AbstractAdViewAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */