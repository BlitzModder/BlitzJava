package com.google.android.gms.ads.internal.reward.mediation.client;

import android.os.RemoteException;
import com.google.android.gms.ads.reward.RewardItem;
import com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdAdapter;
import com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdListener;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.internal.zzha;

@zzha
public class zzb
  implements MediationRewardedVideoAdListener
{
  private final zza zzJC;
  
  public zzb(zza paramzza)
  {
    this.zzJC = paramzza;
  }
  
  public void onAdClicked(MediationRewardedVideoAdAdapter paramMediationRewardedVideoAdAdapter)
  {
    zzx.zzcx("onAdClicked must be called on the main UI thread.");
    com.google.android.gms.ads.internal.util.client.zzb.zzaF("Adapter called onAdClicked.");
    try
    {
      this.zzJC.zzl(zze.zzB(paramMediationRewardedVideoAdAdapter));
      return;
    }
    catch (RemoteException paramMediationRewardedVideoAdAdapter)
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not call onAdClicked.", paramMediationRewardedVideoAdAdapter);
    }
  }
  
  public void onAdClosed(MediationRewardedVideoAdAdapter paramMediationRewardedVideoAdAdapter)
  {
    zzx.zzcx("onAdClosed must be called on the main UI thread.");
    com.google.android.gms.ads.internal.util.client.zzb.zzaF("Adapter called onAdClosed.");
    try
    {
      this.zzJC.zzk(zze.zzB(paramMediationRewardedVideoAdAdapter));
      return;
    }
    catch (RemoteException paramMediationRewardedVideoAdAdapter)
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not call onAdClosed.", paramMediationRewardedVideoAdAdapter);
    }
  }
  
  public void onAdFailedToLoad(MediationRewardedVideoAdAdapter paramMediationRewardedVideoAdAdapter, int paramInt)
  {
    zzx.zzcx("onAdFailedToLoad must be called on the main UI thread.");
    com.google.android.gms.ads.internal.util.client.zzb.zzaF("Adapter called onAdFailedToLoad.");
    try
    {
      this.zzJC.zzc(zze.zzB(paramMediationRewardedVideoAdAdapter), paramInt);
      return;
    }
    catch (RemoteException paramMediationRewardedVideoAdAdapter)
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not call onAdFailedToLoad.", paramMediationRewardedVideoAdAdapter);
    }
  }
  
  public void onAdLeftApplication(MediationRewardedVideoAdAdapter paramMediationRewardedVideoAdAdapter)
  {
    zzx.zzcx("onAdLeftApplication must be called on the main UI thread.");
    com.google.android.gms.ads.internal.util.client.zzb.zzaF("Adapter called onAdLeftApplication.");
    try
    {
      this.zzJC.zzm(zze.zzB(paramMediationRewardedVideoAdAdapter));
      return;
    }
    catch (RemoteException paramMediationRewardedVideoAdAdapter)
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not call onAdLeftApplication.", paramMediationRewardedVideoAdAdapter);
    }
  }
  
  public void onAdLoaded(MediationRewardedVideoAdAdapter paramMediationRewardedVideoAdAdapter)
  {
    zzx.zzcx("onAdLoaded must be called on the main UI thread.");
    com.google.android.gms.ads.internal.util.client.zzb.zzaF("Adapter called onAdLoaded.");
    try
    {
      this.zzJC.zzh(zze.zzB(paramMediationRewardedVideoAdAdapter));
      return;
    }
    catch (RemoteException paramMediationRewardedVideoAdAdapter)
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not call onAdLoaded.", paramMediationRewardedVideoAdAdapter);
    }
  }
  
  public void onAdOpened(MediationRewardedVideoAdAdapter paramMediationRewardedVideoAdAdapter)
  {
    zzx.zzcx("onAdOpened must be called on the main UI thread.");
    com.google.android.gms.ads.internal.util.client.zzb.zzaF("Adapter called onAdOpened.");
    try
    {
      this.zzJC.zzi(zze.zzB(paramMediationRewardedVideoAdAdapter));
      return;
    }
    catch (RemoteException paramMediationRewardedVideoAdAdapter)
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not call onAdOpened.", paramMediationRewardedVideoAdAdapter);
    }
  }
  
  public void onInitializationFailed(MediationRewardedVideoAdAdapter paramMediationRewardedVideoAdAdapter, int paramInt)
  {
    zzx.zzcx("onInitializationFailed must be called on the main UI thread.");
    com.google.android.gms.ads.internal.util.client.zzb.zzaF("Adapter called onInitializationFailed.");
    try
    {
      this.zzJC.zzb(zze.zzB(paramMediationRewardedVideoAdAdapter), paramInt);
      return;
    }
    catch (RemoteException paramMediationRewardedVideoAdAdapter)
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not call onInitializationFailed.", paramMediationRewardedVideoAdAdapter);
    }
  }
  
  public void onInitializationSucceeded(MediationRewardedVideoAdAdapter paramMediationRewardedVideoAdAdapter)
  {
    zzx.zzcx("onInitializationSucceeded must be called on the main UI thread.");
    com.google.android.gms.ads.internal.util.client.zzb.zzaF("Adapter called onInitializationSucceeded.");
    try
    {
      this.zzJC.zzg(zze.zzB(paramMediationRewardedVideoAdAdapter));
      return;
    }
    catch (RemoteException paramMediationRewardedVideoAdAdapter)
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not call onInitializationSucceeded.", paramMediationRewardedVideoAdAdapter);
    }
  }
  
  public void onRewarded(MediationRewardedVideoAdAdapter paramMediationRewardedVideoAdAdapter, RewardItem paramRewardItem)
  {
    zzx.zzcx("onRewarded must be called on the main UI thread.");
    com.google.android.gms.ads.internal.util.client.zzb.zzaF("Adapter called onRewarded.");
    if (paramRewardItem != null) {}
    try
    {
      this.zzJC.zza(zze.zzB(paramMediationRewardedVideoAdAdapter), new RewardItemParcel(paramRewardItem));
      return;
    }
    catch (RemoteException paramMediationRewardedVideoAdAdapter)
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not call onRewarded.", paramMediationRewardedVideoAdAdapter);
    }
    this.zzJC.zza(zze.zzB(paramMediationRewardedVideoAdAdapter), new RewardItemParcel(paramMediationRewardedVideoAdAdapter.getClass().getName(), 1));
    return;
  }
  
  public void onVideoStarted(MediationRewardedVideoAdAdapter paramMediationRewardedVideoAdAdapter)
  {
    zzx.zzcx("onVideoStarted must be called on the main UI thread.");
    com.google.android.gms.ads.internal.util.client.zzb.zzaF("Adapter called onVideoStarted.");
    try
    {
      this.zzJC.zzj(zze.zzB(paramMediationRewardedVideoAdAdapter));
      return;
    }
    catch (RemoteException paramMediationRewardedVideoAdAdapter)
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not call onVideoStarted.", paramMediationRewardedVideoAdAdapter);
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/ads/internal/reward/mediation/client/zzb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */