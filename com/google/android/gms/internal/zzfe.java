package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationBannerListener;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialListener;
import com.google.android.gms.ads.mediation.MediationNativeAdapter;
import com.google.android.gms.ads.mediation.MediationNativeListener;
import com.google.android.gms.ads.mediation.NativeAdMapper;
import com.google.android.gms.common.internal.zzx;

@zzha
public final class zzfe
  implements MediationBannerListener, MediationInterstitialListener, MediationNativeListener
{
  private final zzey zzBK;
  private NativeAdMapper zzBL;
  
  public zzfe(zzey paramzzey)
  {
    this.zzBK = paramzzey;
  }
  
  public void onAdClicked(MediationBannerAdapter paramMediationBannerAdapter)
  {
    zzx.zzcx("onAdClicked must be called on the main UI thread.");
    zzb.zzaF("Adapter called onAdClicked.");
    try
    {
      this.zzBK.onAdClicked();
      return;
    }
    catch (RemoteException paramMediationBannerAdapter)
    {
      zzb.zzd("Could not call onAdClicked.", paramMediationBannerAdapter);
    }
  }
  
  public void onAdClicked(MediationInterstitialAdapter paramMediationInterstitialAdapter)
  {
    zzx.zzcx("onAdClicked must be called on the main UI thread.");
    zzb.zzaF("Adapter called onAdClicked.");
    try
    {
      this.zzBK.onAdClicked();
      return;
    }
    catch (RemoteException paramMediationInterstitialAdapter)
    {
      zzb.zzd("Could not call onAdClicked.", paramMediationInterstitialAdapter);
    }
  }
  
  public void onAdClicked(MediationNativeAdapter paramMediationNativeAdapter)
  {
    zzx.zzcx("onAdClicked must be called on the main UI thread.");
    zzb.zzaF("Adapter called onAdClicked.");
    try
    {
      this.zzBK.onAdClicked();
      return;
    }
    catch (RemoteException paramMediationNativeAdapter)
    {
      zzb.zzd("Could not call onAdClicked.", paramMediationNativeAdapter);
    }
  }
  
  public void onAdClosed(MediationBannerAdapter paramMediationBannerAdapter)
  {
    zzx.zzcx("onAdClosed must be called on the main UI thread.");
    zzb.zzaF("Adapter called onAdClosed.");
    try
    {
      this.zzBK.onAdClosed();
      return;
    }
    catch (RemoteException paramMediationBannerAdapter)
    {
      zzb.zzd("Could not call onAdClosed.", paramMediationBannerAdapter);
    }
  }
  
  public void onAdClosed(MediationInterstitialAdapter paramMediationInterstitialAdapter)
  {
    zzx.zzcx("onAdClosed must be called on the main UI thread.");
    zzb.zzaF("Adapter called onAdClosed.");
    try
    {
      this.zzBK.onAdClosed();
      return;
    }
    catch (RemoteException paramMediationInterstitialAdapter)
    {
      zzb.zzd("Could not call onAdClosed.", paramMediationInterstitialAdapter);
    }
  }
  
  public void onAdClosed(MediationNativeAdapter paramMediationNativeAdapter)
  {
    zzx.zzcx("onAdClosed must be called on the main UI thread.");
    zzb.zzaF("Adapter called onAdClosed.");
    try
    {
      this.zzBK.onAdClosed();
      return;
    }
    catch (RemoteException paramMediationNativeAdapter)
    {
      zzb.zzd("Could not call onAdClosed.", paramMediationNativeAdapter);
    }
  }
  
  public void onAdFailedToLoad(MediationBannerAdapter paramMediationBannerAdapter, int paramInt)
  {
    zzx.zzcx("onAdFailedToLoad must be called on the main UI thread.");
    zzb.zzaF("Adapter called onAdFailedToLoad with error. " + paramInt);
    try
    {
      this.zzBK.onAdFailedToLoad(paramInt);
      return;
    }
    catch (RemoteException paramMediationBannerAdapter)
    {
      zzb.zzd("Could not call onAdFailedToLoad.", paramMediationBannerAdapter);
    }
  }
  
  public void onAdFailedToLoad(MediationInterstitialAdapter paramMediationInterstitialAdapter, int paramInt)
  {
    zzx.zzcx("onAdFailedToLoad must be called on the main UI thread.");
    zzb.zzaF("Adapter called onAdFailedToLoad with error " + paramInt + ".");
    try
    {
      this.zzBK.onAdFailedToLoad(paramInt);
      return;
    }
    catch (RemoteException paramMediationInterstitialAdapter)
    {
      zzb.zzd("Could not call onAdFailedToLoad.", paramMediationInterstitialAdapter);
    }
  }
  
  public void onAdFailedToLoad(MediationNativeAdapter paramMediationNativeAdapter, int paramInt)
  {
    zzx.zzcx("onAdFailedToLoad must be called on the main UI thread.");
    zzb.zzaF("Adapter called onAdFailedToLoad with error " + paramInt + ".");
    try
    {
      this.zzBK.onAdFailedToLoad(paramInt);
      return;
    }
    catch (RemoteException paramMediationNativeAdapter)
    {
      zzb.zzd("Could not call onAdFailedToLoad.", paramMediationNativeAdapter);
    }
  }
  
  public void onAdLeftApplication(MediationBannerAdapter paramMediationBannerAdapter)
  {
    zzx.zzcx("onAdLeftApplication must be called on the main UI thread.");
    zzb.zzaF("Adapter called onAdLeftApplication.");
    try
    {
      this.zzBK.onAdLeftApplication();
      return;
    }
    catch (RemoteException paramMediationBannerAdapter)
    {
      zzb.zzd("Could not call onAdLeftApplication.", paramMediationBannerAdapter);
    }
  }
  
  public void onAdLeftApplication(MediationInterstitialAdapter paramMediationInterstitialAdapter)
  {
    zzx.zzcx("onAdLeftApplication must be called on the main UI thread.");
    zzb.zzaF("Adapter called onAdLeftApplication.");
    try
    {
      this.zzBK.onAdLeftApplication();
      return;
    }
    catch (RemoteException paramMediationInterstitialAdapter)
    {
      zzb.zzd("Could not call onAdLeftApplication.", paramMediationInterstitialAdapter);
    }
  }
  
  public void onAdLeftApplication(MediationNativeAdapter paramMediationNativeAdapter)
  {
    zzx.zzcx("onAdLeftApplication must be called on the main UI thread.");
    zzb.zzaF("Adapter called onAdLeftApplication.");
    try
    {
      this.zzBK.onAdLeftApplication();
      return;
    }
    catch (RemoteException paramMediationNativeAdapter)
    {
      zzb.zzd("Could not call onAdLeftApplication.", paramMediationNativeAdapter);
    }
  }
  
  public void onAdLoaded(MediationBannerAdapter paramMediationBannerAdapter)
  {
    zzx.zzcx("onAdLoaded must be called on the main UI thread.");
    zzb.zzaF("Adapter called onAdLoaded.");
    try
    {
      this.zzBK.onAdLoaded();
      return;
    }
    catch (RemoteException paramMediationBannerAdapter)
    {
      zzb.zzd("Could not call onAdLoaded.", paramMediationBannerAdapter);
    }
  }
  
  public void onAdLoaded(MediationInterstitialAdapter paramMediationInterstitialAdapter)
  {
    zzx.zzcx("onAdLoaded must be called on the main UI thread.");
    zzb.zzaF("Adapter called onAdLoaded.");
    try
    {
      this.zzBK.onAdLoaded();
      return;
    }
    catch (RemoteException paramMediationInterstitialAdapter)
    {
      zzb.zzd("Could not call onAdLoaded.", paramMediationInterstitialAdapter);
    }
  }
  
  public void onAdLoaded(MediationNativeAdapter paramMediationNativeAdapter, NativeAdMapper paramNativeAdMapper)
  {
    zzx.zzcx("onAdLoaded must be called on the main UI thread.");
    zzb.zzaF("Adapter called onAdLoaded.");
    this.zzBL = paramNativeAdMapper;
    try
    {
      this.zzBK.onAdLoaded();
      return;
    }
    catch (RemoteException paramMediationNativeAdapter)
    {
      zzb.zzd("Could not call onAdLoaded.", paramMediationNativeAdapter);
    }
  }
  
  public void onAdOpened(MediationBannerAdapter paramMediationBannerAdapter)
  {
    zzx.zzcx("onAdOpened must be called on the main UI thread.");
    zzb.zzaF("Adapter called onAdOpened.");
    try
    {
      this.zzBK.onAdOpened();
      return;
    }
    catch (RemoteException paramMediationBannerAdapter)
    {
      zzb.zzd("Could not call onAdOpened.", paramMediationBannerAdapter);
    }
  }
  
  public void onAdOpened(MediationInterstitialAdapter paramMediationInterstitialAdapter)
  {
    zzx.zzcx("onAdOpened must be called on the main UI thread.");
    zzb.zzaF("Adapter called onAdOpened.");
    try
    {
      this.zzBK.onAdOpened();
      return;
    }
    catch (RemoteException paramMediationInterstitialAdapter)
    {
      zzb.zzd("Could not call onAdOpened.", paramMediationInterstitialAdapter);
    }
  }
  
  public void onAdOpened(MediationNativeAdapter paramMediationNativeAdapter)
  {
    zzx.zzcx("onAdOpened must be called on the main UI thread.");
    zzb.zzaF("Adapter called onAdOpened.");
    try
    {
      this.zzBK.onAdOpened();
      return;
    }
    catch (RemoteException paramMediationNativeAdapter)
    {
      zzb.zzd("Could not call onAdOpened.", paramMediationNativeAdapter);
    }
  }
  
  public NativeAdMapper zzey()
  {
    return this.zzBL;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/internal/zzfe.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */