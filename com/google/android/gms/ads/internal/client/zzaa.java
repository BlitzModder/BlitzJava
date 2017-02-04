package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.Correlator;
import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.ads.doubleclick.OnCustomRenderedAdLoadedListener;
import com.google.android.gms.ads.doubleclick.PublisherInterstitialAd;
import com.google.android.gms.ads.purchase.InAppPurchaseListener;
import com.google.android.gms.ads.purchase.PlayStorePurchaseListener;
import com.google.android.gms.internal.zzcm;
import com.google.android.gms.internal.zzev;
import com.google.android.gms.internal.zzgh;
import com.google.android.gms.internal.zzgl;
import com.google.android.gms.internal.zzha;

@zzha
public class zzaa
{
  private final Context mContext;
  private final zzh zzoq;
  private String zzpH;
  private zza zztn;
  private AdListener zzto;
  private PlayStorePurchaseListener zzuA;
  private OnCustomRenderedAdLoadedListener zzuB;
  private Correlator zzuC;
  private PublisherInterstitialAd zzuE;
  private AppEventListener zzub;
  private final zzev zzuu = new zzev();
  private zzs zzuw;
  private String zzux;
  private InAppPurchaseListener zzuz;
  
  public zzaa(Context paramContext)
  {
    this(paramContext, zzh.zzcJ(), null);
  }
  
  public zzaa(Context paramContext, PublisherInterstitialAd paramPublisherInterstitialAd)
  {
    this(paramContext, zzh.zzcJ(), paramPublisherInterstitialAd);
  }
  
  public zzaa(Context paramContext, zzh paramzzh, PublisherInterstitialAd paramPublisherInterstitialAd)
  {
    this.mContext = paramContext;
    this.zzoq = paramzzh;
    this.zzuE = paramPublisherInterstitialAd;
  }
  
  private void zzM(String paramString)
    throws RemoteException
  {
    if (this.zzpH == null) {
      zzN(paramString);
    }
    this.zzuw = zzl.zzcO().zzb(this.mContext, new AdSizeParcel(), this.zzpH, this.zzuu);
    if (this.zzto != null) {
      this.zzuw.zza(new zzc(this.zzto));
    }
    if (this.zztn != null) {
      this.zzuw.zza(new zzb(this.zztn));
    }
    if (this.zzub != null) {
      this.zzuw.zza(new zzj(this.zzub));
    }
    if (this.zzuz != null) {
      this.zzuw.zza(new zzgh(this.zzuz));
    }
    if (this.zzuA != null) {
      this.zzuw.zza(new zzgl(this.zzuA), this.zzux);
    }
    if (this.zzuB != null) {
      this.zzuw.zza(new zzcm(this.zzuB));
    }
    if (this.zzuC != null) {
      this.zzuw.zza(this.zzuC.zzaH());
    }
  }
  
  private void zzN(String paramString)
  {
    if (this.zzuw == null) {
      throw new IllegalStateException("The ad unit ID must be set on InterstitialAd before " + paramString + " is called.");
    }
  }
  
  public AdListener getAdListener()
  {
    return this.zzto;
  }
  
  public String getAdUnitId()
  {
    return this.zzpH;
  }
  
  public AppEventListener getAppEventListener()
  {
    return this.zzub;
  }
  
  public InAppPurchaseListener getInAppPurchaseListener()
  {
    return this.zzuz;
  }
  
  public String getMediationAdapterClassName()
  {
    try
    {
      if (this.zzuw != null)
      {
        String str = this.zzuw.getMediationAdapterClassName();
        return str;
      }
    }
    catch (RemoteException localRemoteException)
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzd("Failed to get the mediation adapter class name.", localRemoteException);
    }
    return null;
  }
  
  public OnCustomRenderedAdLoadedListener getOnCustomRenderedAdLoadedListener()
  {
    return this.zzuB;
  }
  
  public boolean isLoaded()
  {
    try
    {
      if (this.zzuw == null) {
        return false;
      }
      boolean bool = this.zzuw.isReady();
      return bool;
    }
    catch (RemoteException localRemoteException)
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzd("Failed to check if ad is ready.", localRemoteException);
    }
    return false;
  }
  
  public boolean isLoading()
  {
    try
    {
      if (this.zzuw == null) {
        return false;
      }
      boolean bool = this.zzuw.isLoading();
      return bool;
    }
    catch (RemoteException localRemoteException)
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzd("Failed to check if ad is loading.", localRemoteException);
    }
    return false;
  }
  
  public void setAdListener(AdListener paramAdListener)
  {
    try
    {
      this.zzto = paramAdListener;
      zzs localzzs;
      if (this.zzuw != null)
      {
        localzzs = this.zzuw;
        if (paramAdListener == null) {
          break label38;
        }
      }
      label38:
      for (paramAdListener = new zzc(paramAdListener);; paramAdListener = null)
      {
        localzzs.zza(paramAdListener);
        return;
      }
      return;
    }
    catch (RemoteException paramAdListener)
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzd("Failed to set the AdListener.", paramAdListener);
    }
  }
  
  public void setAdUnitId(String paramString)
  {
    if (this.zzpH != null) {
      throw new IllegalStateException("The ad unit ID can only be set once on InterstitialAd.");
    }
    this.zzpH = paramString;
  }
  
  public void setAppEventListener(AppEventListener paramAppEventListener)
  {
    try
    {
      this.zzub = paramAppEventListener;
      zzs localzzs;
      if (this.zzuw != null)
      {
        localzzs = this.zzuw;
        if (paramAppEventListener == null) {
          break label38;
        }
      }
      label38:
      for (paramAppEventListener = new zzj(paramAppEventListener);; paramAppEventListener = null)
      {
        localzzs.zza(paramAppEventListener);
        return;
      }
      return;
    }
    catch (RemoteException paramAppEventListener)
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzd("Failed to set the AppEventListener.", paramAppEventListener);
    }
  }
  
  public void setCorrelator(Correlator paramCorrelator)
  {
    this.zzuC = paramCorrelator;
    try
    {
      if (this.zzuw != null)
      {
        zzs localzzs = this.zzuw;
        if (this.zzuC == null) {}
        for (paramCorrelator = null;; paramCorrelator = this.zzuC.zzaH())
        {
          localzzs.zza(paramCorrelator);
          return;
        }
      }
      return;
    }
    catch (RemoteException paramCorrelator)
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzd("Failed to set correlator.", paramCorrelator);
    }
  }
  
  public void setInAppPurchaseListener(InAppPurchaseListener paramInAppPurchaseListener)
  {
    if (this.zzuA != null) {
      throw new IllegalStateException("Play store purchase parameter has already been set.");
    }
    try
    {
      this.zzuz = paramInAppPurchaseListener;
      zzs localzzs;
      if (this.zzuw != null)
      {
        localzzs = this.zzuw;
        if (paramInAppPurchaseListener == null) {
          break label55;
        }
      }
      label55:
      for (paramInAppPurchaseListener = new zzgh(paramInAppPurchaseListener);; paramInAppPurchaseListener = null)
      {
        localzzs.zza(paramInAppPurchaseListener);
        return;
      }
      return;
    }
    catch (RemoteException paramInAppPurchaseListener)
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzd("Failed to set the InAppPurchaseListener.", paramInAppPurchaseListener);
    }
  }
  
  public void setOnCustomRenderedAdLoadedListener(OnCustomRenderedAdLoadedListener paramOnCustomRenderedAdLoadedListener)
  {
    try
    {
      this.zzuB = paramOnCustomRenderedAdLoadedListener;
      zzs localzzs;
      if (this.zzuw != null)
      {
        localzzs = this.zzuw;
        if (paramOnCustomRenderedAdLoadedListener == null) {
          break label38;
        }
      }
      label38:
      for (paramOnCustomRenderedAdLoadedListener = new zzcm(paramOnCustomRenderedAdLoadedListener);; paramOnCustomRenderedAdLoadedListener = null)
      {
        localzzs.zza(paramOnCustomRenderedAdLoadedListener);
        return;
      }
      return;
    }
    catch (RemoteException paramOnCustomRenderedAdLoadedListener)
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzd("Failed to set the OnCustomRenderedAdLoadedListener.", paramOnCustomRenderedAdLoadedListener);
    }
  }
  
  public void setPlayStorePurchaseParams(PlayStorePurchaseListener paramPlayStorePurchaseListener, String paramString)
  {
    if (this.zzuz != null) {
      throw new IllegalStateException("In app purchase parameter has already been set.");
    }
    try
    {
      this.zzuA = paramPlayStorePurchaseListener;
      this.zzux = paramString;
      zzs localzzs;
      if (this.zzuw != null)
      {
        localzzs = this.zzuw;
        if (paramPlayStorePurchaseListener == null) {
          break label61;
        }
      }
      label61:
      for (paramPlayStorePurchaseListener = new zzgl(paramPlayStorePurchaseListener);; paramPlayStorePurchaseListener = null)
      {
        localzzs.zza(paramPlayStorePurchaseListener, paramString);
        return;
      }
      return;
    }
    catch (RemoteException paramPlayStorePurchaseListener)
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzd("Failed to set the play store purchase parameter.", paramPlayStorePurchaseListener);
    }
  }
  
  public void show()
  {
    try
    {
      zzN("show");
      this.zzuw.showInterstitial();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzd("Failed to show interstitial.", localRemoteException);
    }
  }
  
  public void zza(zza paramzza)
  {
    try
    {
      this.zztn = paramzza;
      zzs localzzs;
      if (this.zzuw != null)
      {
        localzzs = this.zzuw;
        if (paramzza == null) {
          break label38;
        }
      }
      label38:
      for (paramzza = new zzb(paramzza);; paramzza = null)
      {
        localzzs.zza(paramzza);
        return;
      }
      return;
    }
    catch (RemoteException paramzza)
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzd("Failed to set the AdClickListener.", paramzza);
    }
  }
  
  public void zza(zzy paramzzy)
  {
    try
    {
      if (this.zzuw == null) {
        zzM("loadAd");
      }
      if (this.zzuw.zzb(this.zzoq.zza(this.mContext, paramzzy))) {
        this.zzuu.zze(paramzzy.zzcV());
      }
      return;
    }
    catch (RemoteException paramzzy)
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzd("Failed to load ad.", paramzzy);
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/ads/internal/client/zzaa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */