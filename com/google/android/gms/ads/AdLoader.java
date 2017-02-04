package com.google.android.gms.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.doubleclick.PublisherAdRequest;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.ads.formats.NativeAppInstallAd.OnAppInstallAdLoadedListener;
import com.google.android.gms.ads.formats.NativeContentAd.OnContentAdLoadedListener;
import com.google.android.gms.ads.formats.NativeCustomTemplateAd.OnCustomClickListener;
import com.google.android.gms.ads.formats.NativeCustomTemplateAd.OnCustomTemplateAdLoadedListener;
import com.google.android.gms.ads.internal.client.zzc;
import com.google.android.gms.ads.internal.client.zzd;
import com.google.android.gms.ads.internal.client.zzh;
import com.google.android.gms.ads.internal.client.zzp;
import com.google.android.gms.ads.internal.client.zzq;
import com.google.android.gms.ads.internal.client.zzy;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzdc;
import com.google.android.gms.internal.zzdd;
import com.google.android.gms.internal.zzde;
import com.google.android.gms.internal.zzdf;
import com.google.android.gms.internal.zzev;

public class AdLoader
{
  private final Context mContext;
  private final zzh zzoq;
  private final zzp zzor;
  
  AdLoader(Context paramContext, zzp paramzzp)
  {
    this(paramContext, paramzzp, zzh.zzcJ());
  }
  
  AdLoader(Context paramContext, zzp paramzzp, zzh paramzzh)
  {
    this.mContext = paramContext;
    this.zzor = paramzzp;
    this.zzoq = paramzzh;
  }
  
  private void zza(zzy paramzzy)
  {
    try
    {
      this.zzor.zzf(this.zzoq.zza(this.mContext, paramzzy));
      return;
    }
    catch (RemoteException paramzzy)
    {
      zzb.zzb("Failed to load ad.", paramzzy);
    }
  }
  
  public String getMediationAdapterClassName()
  {
    try
    {
      String str = this.zzor.getMediationAdapterClassName();
      return str;
    }
    catch (RemoteException localRemoteException)
    {
      zzb.zzd("Failed to get the mediation adapter class name.", localRemoteException);
    }
    return null;
  }
  
  public boolean isLoading()
  {
    try
    {
      boolean bool = this.zzor.isLoading();
      return bool;
    }
    catch (RemoteException localRemoteException)
    {
      zzb.zzd("Failed to check if ad is loading.", localRemoteException);
    }
    return false;
  }
  
  public void loadAd(AdRequest paramAdRequest)
  {
    zza(paramAdRequest.zzaG());
  }
  
  public void loadAd(PublisherAdRequest paramPublisherAdRequest)
  {
    zza(paramPublisherAdRequest.zzaG());
  }
  
  public static class Builder
  {
    private final Context mContext;
    private final zzq zzos;
    
    Builder(Context paramContext, zzq paramzzq)
    {
      this.mContext = paramContext;
      this.zzos = paramzzq;
    }
    
    public Builder(Context paramContext, String paramString)
    {
      this((Context)zzx.zzb(paramContext, "context cannot be null"), zzd.zza(paramContext, paramString, new zzev()));
    }
    
    public AdLoader build()
    {
      try
      {
        AdLoader localAdLoader = new AdLoader(this.mContext, this.zzos.zzbm());
        return localAdLoader;
      }
      catch (RemoteException localRemoteException)
      {
        zzb.zzb("Failed to build AdLoader.", localRemoteException);
      }
      return null;
    }
    
    public Builder forAppInstallAd(NativeAppInstallAd.OnAppInstallAdLoadedListener paramOnAppInstallAdLoadedListener)
    {
      try
      {
        this.zzos.zza(new zzdc(paramOnAppInstallAdLoadedListener));
        return this;
      }
      catch (RemoteException paramOnAppInstallAdLoadedListener)
      {
        zzb.zzd("Failed to add app install ad listener", paramOnAppInstallAdLoadedListener);
      }
      return this;
    }
    
    public Builder forContentAd(NativeContentAd.OnContentAdLoadedListener paramOnContentAdLoadedListener)
    {
      try
      {
        this.zzos.zza(new zzdd(paramOnContentAdLoadedListener));
        return this;
      }
      catch (RemoteException paramOnContentAdLoadedListener)
      {
        zzb.zzd("Failed to add content ad listener", paramOnContentAdLoadedListener);
      }
      return this;
    }
    
    public Builder forCustomTemplateAd(String paramString, NativeCustomTemplateAd.OnCustomTemplateAdLoadedListener paramOnCustomTemplateAdLoadedListener, NativeCustomTemplateAd.OnCustomClickListener paramOnCustomClickListener)
    {
      try
      {
        zzq localzzq = this.zzos;
        zzdf localzzdf = new zzdf(paramOnCustomTemplateAdLoadedListener);
        if (paramOnCustomClickListener == null) {}
        for (paramOnCustomTemplateAdLoadedListener = null;; paramOnCustomTemplateAdLoadedListener = new zzde(paramOnCustomClickListener))
        {
          localzzq.zza(paramString, localzzdf, paramOnCustomTemplateAdLoadedListener);
          return this;
        }
        return this;
      }
      catch (RemoteException paramString)
      {
        zzb.zzd("Failed to add custom template ad listener", paramString);
      }
    }
    
    public Builder withAdListener(AdListener paramAdListener)
    {
      try
      {
        this.zzos.zzb(new zzc(paramAdListener));
        return this;
      }
      catch (RemoteException paramAdListener)
      {
        zzb.zzd("Failed to set AdListener.", paramAdListener);
      }
      return this;
    }
    
    public Builder withCorrelator(Correlator paramCorrelator)
    {
      zzx.zzy(paramCorrelator);
      try
      {
        this.zzos.zzb(paramCorrelator.zzaH());
        return this;
      }
      catch (RemoteException paramCorrelator)
      {
        zzb.zzd("Failed to set correlator.", paramCorrelator);
      }
      return this;
    }
    
    public Builder withNativeAdOptions(NativeAdOptions paramNativeAdOptions)
    {
      try
      {
        this.zzos.zza(new NativeAdOptionsParcel(paramNativeAdOptions));
        return this;
      }
      catch (RemoteException paramNativeAdOptions)
      {
        zzb.zzd("Failed to specify native ad options", paramNativeAdOptions);
      }
      return this;
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/ads/AdLoader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */