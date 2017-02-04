package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.ads.mediation.MediationAdRequest;
import com.google.android.gms.ads.mediation.MediationAdapter;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.MediationNativeAdapter;
import com.google.android.gms.ads.mediation.NativeAdMapper;
import com.google.android.gms.ads.mediation.NativeAppInstallAdMapper;
import com.google.android.gms.ads.mediation.NativeContentAdMapper;
import com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdAdapter;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zze;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONObject;

@zzha
public final class zzfd
  extends zzex.zza
{
  private final MediationAdapter zzBI;
  private zzfe zzBJ;
  
  public zzfd(MediationAdapter paramMediationAdapter)
  {
    this.zzBI = paramMediationAdapter;
  }
  
  private Bundle zza(String paramString1, int paramInt, String paramString2)
    throws RemoteException
  {
    com.google.android.gms.ads.internal.util.client.zzb.zzaH("Server parameters: " + paramString1);
    Bundle localBundle;
    try
    {
      localBundle = new Bundle();
      if (paramString1 != null)
      {
        paramString1 = new JSONObject(paramString1);
        localBundle = new Bundle();
        Iterator localIterator = paramString1.keys();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          localBundle.putString(str, paramString1.getString(str));
        }
      }
      if (!(this.zzBI instanceof AdMobAdapter)) {
        break label138;
      }
    }
    catch (Throwable paramString1)
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not get Server Parameters Bundle.", paramString1);
      throw new RemoteException();
    }
    localBundle.putString("adJson", paramString2);
    localBundle.putInt("tagForChildDirectedTreatment", paramInt);
    label138:
    return localBundle;
  }
  
  public void destroy()
    throws RemoteException
  {
    try
    {
      this.zzBI.onDestroy();
      return;
    }
    catch (Throwable localThrowable)
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not destroy adapter.", localThrowable);
      throw new RemoteException();
    }
  }
  
  public Bundle getInterstitialAdapterInfo()
  {
    if (!(this.zzBI instanceof zzjy))
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzaH("MediationAdapter is not a v2 MediationInterstitialAdapter: " + this.zzBI.getClass().getCanonicalName());
      return new Bundle();
    }
    return ((zzjy)this.zzBI).getInterstitialAdapterInfo();
  }
  
  public zzd getView()
    throws RemoteException
  {
    if (!(this.zzBI instanceof MediationBannerAdapter))
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzaH("MediationAdapter is not a MediationBannerAdapter: " + this.zzBI.getClass().getCanonicalName());
      throw new RemoteException();
    }
    try
    {
      zzd localzzd = zze.zzB(((MediationBannerAdapter)this.zzBI).getBannerView());
      return localzzd;
    }
    catch (Throwable localThrowable)
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not get banner view from adapter.", localThrowable);
      throw new RemoteException();
    }
  }
  
  public boolean isInitialized()
    throws RemoteException
  {
    if (!(this.zzBI instanceof MediationRewardedVideoAdAdapter))
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzaH("MediationAdapter is not a MediationRewardedVideoAdAdapter: " + this.zzBI.getClass().getCanonicalName());
      throw new RemoteException();
    }
    com.google.android.gms.ads.internal.util.client.zzb.zzaF("Check if adapter is initialized.");
    try
    {
      boolean bool = ((MediationRewardedVideoAdAdapter)this.zzBI).isInitialized();
      return bool;
    }
    catch (Throwable localThrowable)
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not check if adapter is initialized.", localThrowable);
      throw new RemoteException();
    }
  }
  
  public void pause()
    throws RemoteException
  {
    try
    {
      this.zzBI.onPause();
      return;
    }
    catch (Throwable localThrowable)
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not pause adapter.", localThrowable);
      throw new RemoteException();
    }
  }
  
  public void resume()
    throws RemoteException
  {
    try
    {
      this.zzBI.onResume();
      return;
    }
    catch (Throwable localThrowable)
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not resume adapter.", localThrowable);
      throw new RemoteException();
    }
  }
  
  public void showInterstitial()
    throws RemoteException
  {
    if (!(this.zzBI instanceof MediationInterstitialAdapter))
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzaH("MediationAdapter is not a MediationInterstitialAdapter: " + this.zzBI.getClass().getCanonicalName());
      throw new RemoteException();
    }
    com.google.android.gms.ads.internal.util.client.zzb.zzaF("Showing interstitial from adapter.");
    try
    {
      ((MediationInterstitialAdapter)this.zzBI).showInterstitial();
      return;
    }
    catch (Throwable localThrowable)
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not show interstitial from adapter.", localThrowable);
      throw new RemoteException();
    }
  }
  
  public void showVideo()
    throws RemoteException
  {
    if (!(this.zzBI instanceof MediationRewardedVideoAdAdapter))
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzaH("MediationAdapter is not a MediationRewardedVideoAdAdapter: " + this.zzBI.getClass().getCanonicalName());
      throw new RemoteException();
    }
    com.google.android.gms.ads.internal.util.client.zzb.zzaF("Show rewarded video ad from adapter.");
    try
    {
      ((MediationRewardedVideoAdAdapter)this.zzBI).showVideo();
      return;
    }
    catch (Throwable localThrowable)
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not show rewarded video ad from adapter.", localThrowable);
      throw new RemoteException();
    }
  }
  
  public void zza(zzd paramzzd, AdRequestParcel paramAdRequestParcel, String paramString1, com.google.android.gms.ads.internal.reward.mediation.client.zza paramzza, String paramString2)
    throws RemoteException
  {
    if (!(this.zzBI instanceof MediationRewardedVideoAdAdapter))
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzaH("MediationAdapter is not a MediationRewardedVideoAdAdapter: " + this.zzBI.getClass().getCanonicalName());
      throw new RemoteException();
    }
    com.google.android.gms.ads.internal.util.client.zzb.zzaF("Initialize rewarded video adapter.");
    for (;;)
    {
      try
      {
        MediationRewardedVideoAdAdapter localMediationRewardedVideoAdAdapter = (MediationRewardedVideoAdAdapter)this.zzBI;
        if (paramAdRequestParcel.zzts == null) {
          break label232;
        }
        localObject1 = new HashSet(paramAdRequestParcel.zzts);
        Object localObject2;
        if (paramAdRequestParcel.zztq == -1L)
        {
          localObject2 = null;
          localObject2 = new zzfc((Date)localObject2, paramAdRequestParcel.zztr, (Set)localObject1, paramAdRequestParcel.zzty, paramAdRequestParcel.zztt, paramAdRequestParcel.zztu, paramAdRequestParcel.zztF);
          if (paramAdRequestParcel.zztA != null)
          {
            localObject1 = paramAdRequestParcel.zztA.getBundle(localMediationRewardedVideoAdAdapter.getClass().getName());
            localMediationRewardedVideoAdAdapter.initialize((Context)zze.zzp(paramzzd), (MediationAdRequest)localObject2, paramString1, new com.google.android.gms.ads.internal.reward.mediation.client.zzb(paramzza), zza(paramString2, paramAdRequestParcel.zztu, null), (Bundle)localObject1);
          }
        }
        else
        {
          localObject2 = new Date(paramAdRequestParcel.zztq);
          continue;
        }
        localObject1 = null;
      }
      catch (Throwable paramzzd)
      {
        com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not initialize rewarded video adapter.", paramzzd);
        throw new RemoteException();
      }
      continue;
      label232:
      Object localObject1 = null;
    }
  }
  
  public void zza(zzd paramzzd, AdRequestParcel paramAdRequestParcel, String paramString, zzey paramzzey)
    throws RemoteException
  {
    zza(paramzzd, paramAdRequestParcel, paramString, null, paramzzey);
  }
  
  public void zza(zzd paramzzd, AdRequestParcel paramAdRequestParcel, String paramString1, String paramString2, zzey paramzzey)
    throws RemoteException
  {
    if (!(this.zzBI instanceof MediationInterstitialAdapter))
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzaH("MediationAdapter is not a MediationInterstitialAdapter: " + this.zzBI.getClass().getCanonicalName());
      throw new RemoteException();
    }
    com.google.android.gms.ads.internal.util.client.zzb.zzaF("Requesting interstitial ad from adapter.");
    for (;;)
    {
      try
      {
        MediationInterstitialAdapter localMediationInterstitialAdapter = (MediationInterstitialAdapter)this.zzBI;
        if (paramAdRequestParcel.zzts == null) {
          break label232;
        }
        localObject1 = new HashSet(paramAdRequestParcel.zzts);
        Object localObject2;
        if (paramAdRequestParcel.zztq == -1L)
        {
          localObject2 = null;
          localObject2 = new zzfc((Date)localObject2, paramAdRequestParcel.zztr, (Set)localObject1, paramAdRequestParcel.zzty, paramAdRequestParcel.zztt, paramAdRequestParcel.zztu, paramAdRequestParcel.zztF);
          if (paramAdRequestParcel.zztA != null)
          {
            localObject1 = paramAdRequestParcel.zztA.getBundle(localMediationInterstitialAdapter.getClass().getName());
            localMediationInterstitialAdapter.requestInterstitialAd((Context)zze.zzp(paramzzd), new zzfe(paramzzey), zza(paramString1, paramAdRequestParcel.zztu, paramString2), (MediationAdRequest)localObject2, (Bundle)localObject1);
          }
        }
        else
        {
          localObject2 = new Date(paramAdRequestParcel.zztq);
          continue;
        }
        localObject1 = null;
      }
      catch (Throwable paramzzd)
      {
        com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not request interstitial ad from adapter.", paramzzd);
        throw new RemoteException();
      }
      continue;
      label232:
      Object localObject1 = null;
    }
  }
  
  public void zza(zzd paramzzd, AdRequestParcel paramAdRequestParcel, String paramString1, String paramString2, zzey paramzzey, NativeAdOptionsParcel paramNativeAdOptionsParcel, List<String> paramList)
    throws RemoteException
  {
    if (!(this.zzBI instanceof MediationNativeAdapter))
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzaH("MediationAdapter is not a MediationNativeAdapter: " + this.zzBI.getClass().getCanonicalName());
      throw new RemoteException();
    }
    for (;;)
    {
      try
      {
        MediationNativeAdapter localMediationNativeAdapter = (MediationNativeAdapter)this.zzBI;
        if (paramAdRequestParcel.zzts == null) {
          break label239;
        }
        localHashSet = new HashSet(paramAdRequestParcel.zzts);
        Date localDate;
        if (paramAdRequestParcel.zztq == -1L)
        {
          localDate = null;
          paramList = new zzfh(localDate, paramAdRequestParcel.zztr, localHashSet, paramAdRequestParcel.zzty, paramAdRequestParcel.zztt, paramAdRequestParcel.zztu, paramNativeAdOptionsParcel, paramList, paramAdRequestParcel.zztF);
          if (paramAdRequestParcel.zztA != null)
          {
            paramNativeAdOptionsParcel = paramAdRequestParcel.zztA.getBundle(localMediationNativeAdapter.getClass().getName());
            this.zzBJ = new zzfe(paramzzey);
            localMediationNativeAdapter.requestNativeAd((Context)zze.zzp(paramzzd), this.zzBJ, zza(paramString1, paramAdRequestParcel.zztu, paramString2), paramList, paramNativeAdOptionsParcel);
          }
        }
        else
        {
          localDate = new Date(paramAdRequestParcel.zztq);
          continue;
        }
        paramNativeAdOptionsParcel = null;
      }
      catch (Throwable paramzzd)
      {
        com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not request interstitial ad from adapter.", paramzzd);
        throw new RemoteException();
      }
      continue;
      label239:
      HashSet localHashSet = null;
    }
  }
  
  public void zza(zzd paramzzd, AdSizeParcel paramAdSizeParcel, AdRequestParcel paramAdRequestParcel, String paramString, zzey paramzzey)
    throws RemoteException
  {
    zza(paramzzd, paramAdSizeParcel, paramAdRequestParcel, paramString, null, paramzzey);
  }
  
  public void zza(zzd paramzzd, AdSizeParcel paramAdSizeParcel, AdRequestParcel paramAdRequestParcel, String paramString1, String paramString2, zzey paramzzey)
    throws RemoteException
  {
    if (!(this.zzBI instanceof MediationBannerAdapter))
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzaH("MediationAdapter is not a MediationBannerAdapter: " + this.zzBI.getClass().getCanonicalName());
      throw new RemoteException();
    }
    com.google.android.gms.ads.internal.util.client.zzb.zzaF("Requesting banner ad from adapter.");
    for (;;)
    {
      try
      {
        MediationBannerAdapter localMediationBannerAdapter = (MediationBannerAdapter)this.zzBI;
        if (paramAdRequestParcel.zzts == null) {
          break label248;
        }
        localObject1 = new HashSet(paramAdRequestParcel.zzts);
        Object localObject2;
        if (paramAdRequestParcel.zztq == -1L)
        {
          localObject2 = null;
          localObject2 = new zzfc((Date)localObject2, paramAdRequestParcel.zztr, (Set)localObject1, paramAdRequestParcel.zzty, paramAdRequestParcel.zztt, paramAdRequestParcel.zztu, paramAdRequestParcel.zztF);
          if (paramAdRequestParcel.zztA != null)
          {
            localObject1 = paramAdRequestParcel.zztA.getBundle(localMediationBannerAdapter.getClass().getName());
            localMediationBannerAdapter.requestBannerAd((Context)zze.zzp(paramzzd), new zzfe(paramzzey), zza(paramString1, paramAdRequestParcel.zztu, paramString2), com.google.android.gms.ads.zza.zza(paramAdSizeParcel.width, paramAdSizeParcel.height, paramAdSizeParcel.zztV), (MediationAdRequest)localObject2, (Bundle)localObject1);
          }
        }
        else
        {
          localObject2 = new Date(paramAdRequestParcel.zztq);
          continue;
        }
        localObject1 = null;
      }
      catch (Throwable paramzzd)
      {
        com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not request banner ad from adapter.", paramzzd);
        throw new RemoteException();
      }
      continue;
      label248:
      Object localObject1 = null;
    }
  }
  
  public void zzc(AdRequestParcel paramAdRequestParcel, String paramString)
    throws RemoteException
  {
    if (!(this.zzBI instanceof MediationRewardedVideoAdAdapter))
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzaH("MediationAdapter is not a MediationRewardedVideoAdAdapter: " + this.zzBI.getClass().getCanonicalName());
      throw new RemoteException();
    }
    com.google.android.gms.ads.internal.util.client.zzb.zzaF("Requesting rewarded video ad from adapter.");
    for (;;)
    {
      try
      {
        MediationRewardedVideoAdAdapter localMediationRewardedVideoAdAdapter = (MediationRewardedVideoAdAdapter)this.zzBI;
        if (paramAdRequestParcel.zzts == null) {
          break label210;
        }
        localObject1 = new HashSet(paramAdRequestParcel.zzts);
        Object localObject2;
        if (paramAdRequestParcel.zztq == -1L)
        {
          localObject2 = null;
          localObject2 = new zzfc((Date)localObject2, paramAdRequestParcel.zztr, (Set)localObject1, paramAdRequestParcel.zzty, paramAdRequestParcel.zztt, paramAdRequestParcel.zztu, paramAdRequestParcel.zztF);
          if (paramAdRequestParcel.zztA != null)
          {
            localObject1 = paramAdRequestParcel.zztA.getBundle(localMediationRewardedVideoAdAdapter.getClass().getName());
            localMediationRewardedVideoAdAdapter.loadAd((MediationAdRequest)localObject2, zza(paramString, paramAdRequestParcel.zztu, null), (Bundle)localObject1);
          }
        }
        else
        {
          localObject2 = new Date(paramAdRequestParcel.zztq);
          continue;
        }
        localObject1 = null;
      }
      catch (Throwable paramAdRequestParcel)
      {
        com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not load rewarded video ad from adapter.", paramAdRequestParcel);
        throw new RemoteException();
      }
      continue;
      label210:
      Object localObject1 = null;
    }
  }
  
  public zzfa zzeu()
  {
    NativeAdMapper localNativeAdMapper = this.zzBJ.zzey();
    if ((localNativeAdMapper instanceof NativeAppInstallAdMapper)) {
      return new zzff((NativeAppInstallAdMapper)localNativeAdMapper);
    }
    return null;
  }
  
  public zzfb zzev()
  {
    NativeAdMapper localNativeAdMapper = this.zzBJ.zzey();
    if ((localNativeAdMapper instanceof NativeContentAdMapper)) {
      return new zzfg((NativeContentAdMapper)localNativeAdMapper);
    }
    return null;
  }
  
  public Bundle zzew()
  {
    if (!(this.zzBI instanceof zzjx))
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzaH("MediationAdapter is not a v2 MediationBannerAdapter: " + this.zzBI.getClass().getCanonicalName());
      return new Bundle();
    }
    return ((zzjx)this.zzBI).zzew();
  }
  
  public Bundle zzex()
  {
    return new Bundle();
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/internal/zzfd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */