package com.google.android.gms.internal;

import android.app.Activity;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.ads.mediation.MediationAdapter;
import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.ads.mediation.MediationServerParameters;
import com.google.ads.mediation.NetworkExtras;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.ads.internal.reward.mediation.client.zza;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zze;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

@zzha
public final class zzfi<NETWORK_EXTRAS extends NetworkExtras, SERVER_PARAMETERS extends MediationServerParameters>
  extends zzex.zza
{
  private final MediationAdapter<NETWORK_EXTRAS, SERVER_PARAMETERS> zzBO;
  private final NETWORK_EXTRAS zzBP;
  
  public zzfi(MediationAdapter<NETWORK_EXTRAS, SERVER_PARAMETERS> paramMediationAdapter, NETWORK_EXTRAS paramNETWORK_EXTRAS)
  {
    this.zzBO = paramMediationAdapter;
    this.zzBP = paramNETWORK_EXTRAS;
  }
  
  private SERVER_PARAMETERS zzb(String paramString1, int paramInt, String paramString2)
    throws RemoteException
  {
    if (paramString1 != null) {
      try
      {
        localObject = new JSONObject(paramString1);
        paramString2 = new HashMap(((JSONObject)localObject).length());
        Iterator localIterator = ((JSONObject)localObject).keys();
        for (;;)
        {
          paramString1 = paramString2;
          if (!localIterator.hasNext()) {
            break;
          }
          paramString1 = (String)localIterator.next();
          paramString2.put(paramString1, ((JSONObject)localObject).getString(paramString1));
        }
        paramString1 = new HashMap(0);
      }
      catch (Throwable paramString1)
      {
        zzb.zzd("Could not get MediationServerParameters.", paramString1);
        throw new RemoteException();
      }
    }
    Object localObject = this.zzBO.getServerParametersType();
    paramString2 = null;
    if (localObject != null)
    {
      paramString2 = (MediationServerParameters)((Class)localObject).newInstance();
      paramString2.load(paramString1);
    }
    return paramString2;
  }
  
  public void destroy()
    throws RemoteException
  {
    try
    {
      this.zzBO.destroy();
      return;
    }
    catch (Throwable localThrowable)
    {
      zzb.zzd("Could not destroy adapter.", localThrowable);
      throw new RemoteException();
    }
  }
  
  public Bundle getInterstitialAdapterInfo()
  {
    return new Bundle();
  }
  
  public zzd getView()
    throws RemoteException
  {
    if (!(this.zzBO instanceof MediationBannerAdapter))
    {
      zzb.zzaH("MediationAdapter is not a MediationBannerAdapter: " + this.zzBO.getClass().getCanonicalName());
      throw new RemoteException();
    }
    try
    {
      zzd localzzd = zze.zzB(((MediationBannerAdapter)this.zzBO).getBannerView());
      return localzzd;
    }
    catch (Throwable localThrowable)
    {
      zzb.zzd("Could not get banner view from adapter.", localThrowable);
      throw new RemoteException();
    }
  }
  
  public boolean isInitialized()
  {
    return true;
  }
  
  public void pause()
    throws RemoteException
  {
    throw new RemoteException();
  }
  
  public void resume()
    throws RemoteException
  {
    throw new RemoteException();
  }
  
  public void showInterstitial()
    throws RemoteException
  {
    if (!(this.zzBO instanceof MediationInterstitialAdapter))
    {
      zzb.zzaH("MediationAdapter is not a MediationInterstitialAdapter: " + this.zzBO.getClass().getCanonicalName());
      throw new RemoteException();
    }
    zzb.zzaF("Showing interstitial from adapter.");
    try
    {
      ((MediationInterstitialAdapter)this.zzBO).showInterstitial();
      return;
    }
    catch (Throwable localThrowable)
    {
      zzb.zzd("Could not show interstitial from adapter.", localThrowable);
      throw new RemoteException();
    }
  }
  
  public void showVideo() {}
  
  public void zza(zzd paramzzd, AdRequestParcel paramAdRequestParcel, String paramString1, zza paramzza, String paramString2)
    throws RemoteException
  {}
  
  public void zza(zzd paramzzd, AdRequestParcel paramAdRequestParcel, String paramString, zzey paramzzey)
    throws RemoteException
  {
    zza(paramzzd, paramAdRequestParcel, paramString, null, paramzzey);
  }
  
  public void zza(zzd paramzzd, AdRequestParcel paramAdRequestParcel, String paramString1, String paramString2, zzey paramzzey)
    throws RemoteException
  {
    if (!(this.zzBO instanceof MediationInterstitialAdapter))
    {
      zzb.zzaH("MediationAdapter is not a MediationInterstitialAdapter: " + this.zzBO.getClass().getCanonicalName());
      throw new RemoteException();
    }
    zzb.zzaF("Requesting interstitial ad from adapter.");
    try
    {
      ((MediationInterstitialAdapter)this.zzBO).requestInterstitialAd(new zzfj(paramzzey), (Activity)zze.zzp(paramzzd), zzb(paramString1, paramAdRequestParcel.zztu, paramString2), zzfk.zzi(paramAdRequestParcel), this.zzBP);
      return;
    }
    catch (Throwable paramzzd)
    {
      zzb.zzd("Could not request interstitial ad from adapter.", paramzzd);
      throw new RemoteException();
    }
  }
  
  public void zza(zzd paramzzd, AdRequestParcel paramAdRequestParcel, String paramString1, String paramString2, zzey paramzzey, NativeAdOptionsParcel paramNativeAdOptionsParcel, List<String> paramList) {}
  
  public void zza(zzd paramzzd, AdSizeParcel paramAdSizeParcel, AdRequestParcel paramAdRequestParcel, String paramString, zzey paramzzey)
    throws RemoteException
  {
    zza(paramzzd, paramAdSizeParcel, paramAdRequestParcel, paramString, null, paramzzey);
  }
  
  public void zza(zzd paramzzd, AdSizeParcel paramAdSizeParcel, AdRequestParcel paramAdRequestParcel, String paramString1, String paramString2, zzey paramzzey)
    throws RemoteException
  {
    if (!(this.zzBO instanceof MediationBannerAdapter))
    {
      zzb.zzaH("MediationAdapter is not a MediationBannerAdapter: " + this.zzBO.getClass().getCanonicalName());
      throw new RemoteException();
    }
    zzb.zzaF("Requesting banner ad from adapter.");
    try
    {
      ((MediationBannerAdapter)this.zzBO).requestBannerAd(new zzfj(paramzzey), (Activity)zze.zzp(paramzzd), zzb(paramString1, paramAdRequestParcel.zztu, paramString2), zzfk.zzb(paramAdSizeParcel), zzfk.zzi(paramAdRequestParcel), this.zzBP);
      return;
    }
    catch (Throwable paramzzd)
    {
      zzb.zzd("Could not request banner ad from adapter.", paramzzd);
      throw new RemoteException();
    }
  }
  
  public void zzc(AdRequestParcel paramAdRequestParcel, String paramString) {}
  
  public zzfa zzeu()
  {
    return null;
  }
  
  public zzfb zzev()
  {
    return null;
  }
  
  public Bundle zzew()
  {
    return new Bundle();
  }
  
  public Bundle zzex()
  {
    return new Bundle();
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/internal/zzfi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */