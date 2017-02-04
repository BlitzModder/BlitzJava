package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.os.RemoteException;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.Correlator;
import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.ads.doubleclick.OnCustomRenderedAdLoadedListener;
import com.google.android.gms.ads.purchase.InAppPurchaseListener;
import com.google.android.gms.ads.purchase.PlayStorePurchaseListener;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.internal.zzcm;
import com.google.android.gms.internal.zzev;
import com.google.android.gms.internal.zzgh;
import com.google.android.gms.internal.zzgl;
import com.google.android.gms.internal.zzha;
import java.util.concurrent.atomic.AtomicBoolean;

@zzha
public class zzz
{
  private final zzh zzoq;
  private String zzpH;
  private boolean zzpt;
  private zza zztn;
  private AdListener zzto;
  private PlayStorePurchaseListener zzuA;
  private OnCustomRenderedAdLoadedListener zzuB;
  private Correlator zzuC;
  private boolean zzuD;
  private AppEventListener zzub;
  private AdSize[] zzuc;
  private final zzev zzuu = new zzev();
  private final AtomicBoolean zzuv;
  private zzs zzuw;
  private String zzux;
  private ViewGroup zzuy;
  private InAppPurchaseListener zzuz;
  
  public zzz(ViewGroup paramViewGroup)
  {
    this(paramViewGroup, null, false, zzh.zzcJ(), false);
  }
  
  public zzz(ViewGroup paramViewGroup, AttributeSet paramAttributeSet, boolean paramBoolean)
  {
    this(paramViewGroup, paramAttributeSet, paramBoolean, zzh.zzcJ(), false);
  }
  
  zzz(ViewGroup paramViewGroup, AttributeSet paramAttributeSet, boolean paramBoolean1, zzh paramzzh, zzs paramzzs, boolean paramBoolean2)
  {
    this.zzuy = paramViewGroup;
    this.zzoq = paramzzh;
    this.zzuw = paramzzs;
    this.zzuv = new AtomicBoolean(false);
    this.zzuD = paramBoolean2;
    if (paramAttributeSet != null) {
      paramzzh = paramViewGroup.getContext();
    }
    try
    {
      paramAttributeSet = new zzk(paramzzh, paramAttributeSet);
      this.zzuc = paramAttributeSet.zzj(paramBoolean1);
      this.zzpH = paramAttributeSet.getAdUnitId();
      if (paramViewGroup.isInEditMode()) {
        zzl.zzcN().zza(paramViewGroup, zza(paramzzh, this.zzuc[0], this.zzuD), "Ads by Google");
      }
      return;
    }
    catch (IllegalArgumentException paramAttributeSet)
    {
      zzl.zzcN().zza(paramViewGroup, new AdSizeParcel(paramzzh, AdSize.BANNER), paramAttributeSet.getMessage(), paramAttributeSet.getMessage());
    }
  }
  
  zzz(ViewGroup paramViewGroup, AttributeSet paramAttributeSet, boolean paramBoolean1, zzh paramzzh, boolean paramBoolean2)
  {
    this(paramViewGroup, paramAttributeSet, paramBoolean1, paramzzh, null, paramBoolean2);
  }
  
  public zzz(ViewGroup paramViewGroup, AttributeSet paramAttributeSet, boolean paramBoolean1, boolean paramBoolean2)
  {
    this(paramViewGroup, paramAttributeSet, paramBoolean1, zzh.zzcJ(), paramBoolean2);
  }
  
  public zzz(ViewGroup paramViewGroup, boolean paramBoolean)
  {
    this(paramViewGroup, null, false, zzh.zzcJ(), paramBoolean);
  }
  
  private static AdSizeParcel zza(Context paramContext, AdSize paramAdSize, boolean paramBoolean)
  {
    paramContext = new AdSizeParcel(paramContext, paramAdSize);
    paramContext.zzi(paramBoolean);
    return paramContext;
  }
  
  private static AdSizeParcel zza(Context paramContext, AdSize[] paramArrayOfAdSize, boolean paramBoolean)
  {
    paramContext = new AdSizeParcel(paramContext, paramArrayOfAdSize);
    paramContext.zzi(paramBoolean);
    return paramContext;
  }
  
  private void zzcZ()
  {
    try
    {
      zzd localzzd = this.zzuw.zzaO();
      if (localzzd == null) {
        return;
      }
      this.zzuy.addView((View)com.google.android.gms.dynamic.zze.zzp(localzzd));
      return;
    }
    catch (RemoteException localRemoteException)
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzd("Failed to get an ad frame.", localRemoteException);
    }
  }
  
  public void destroy()
  {
    try
    {
      if (this.zzuw != null) {
        this.zzuw.destroy();
      }
      return;
    }
    catch (RemoteException localRemoteException)
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzd("Failed to destroy AdView.", localRemoteException);
    }
  }
  
  public AdListener getAdListener()
  {
    return this.zzto;
  }
  
  public AdSize getAdSize()
  {
    try
    {
      if (this.zzuw != null)
      {
        Object localObject = this.zzuw.zzaP();
        if (localObject != null)
        {
          localObject = ((AdSizeParcel)localObject).zzcL();
          return (AdSize)localObject;
        }
      }
    }
    catch (RemoteException localRemoteException)
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzd("Failed to get the current AdSize.", localRemoteException);
      if (this.zzuc != null) {
        return this.zzuc[0];
      }
    }
    return null;
  }
  
  public AdSize[] getAdSizes()
  {
    return this.zzuc;
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
  
  public boolean isLoading()
  {
    try
    {
      if (this.zzuw != null)
      {
        boolean bool = this.zzuw.isLoading();
        return bool;
      }
    }
    catch (RemoteException localRemoteException)
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzd("Failed to check if ad is loading.", localRemoteException);
    }
    return false;
  }
  
  public void pause()
  {
    try
    {
      if (this.zzuw != null) {
        this.zzuw.pause();
      }
      return;
    }
    catch (RemoteException localRemoteException)
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzd("Failed to call pause.", localRemoteException);
    }
  }
  
  public void recordManualImpression()
  {
    if (this.zzuv.getAndSet(true)) {}
    for (;;)
    {
      return;
      try
      {
        if (this.zzuw != null)
        {
          this.zzuw.zzaR();
          return;
        }
      }
      catch (RemoteException localRemoteException)
      {
        com.google.android.gms.ads.internal.util.client.zzb.zzd("Failed to record impression.", localRemoteException);
      }
    }
  }
  
  public void resume()
  {
    try
    {
      if (this.zzuw != null) {
        this.zzuw.resume();
      }
      return;
    }
    catch (RemoteException localRemoteException)
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzd("Failed to call resume.", localRemoteException);
    }
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
  
  public void setAdSizes(AdSize... paramVarArgs)
  {
    if (this.zzuc != null) {
      throw new IllegalStateException("The ad size can only be set once on AdView.");
    }
    zza(paramVarArgs);
  }
  
  public void setAdUnitId(String paramString)
  {
    if (this.zzpH != null) {
      throw new IllegalStateException("The ad unit ID can only be set once on AdView.");
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
          break label56;
        }
      }
      label56:
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
  
  public void setManualImpressionsEnabled(boolean paramBoolean)
  {
    this.zzpt = paramBoolean;
    try
    {
      if (this.zzuw != null) {
        this.zzuw.setManualImpressionsEnabled(this.zzpt);
      }
      return;
    }
    catch (RemoteException localRemoteException)
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzd("Failed to set manual impressions.", localRemoteException);
    }
  }
  
  public void setOnCustomRenderedAdLoadedListener(OnCustomRenderedAdLoadedListener paramOnCustomRenderedAdLoadedListener)
  {
    this.zzuB = paramOnCustomRenderedAdLoadedListener;
    try
    {
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
      com.google.android.gms.ads.internal.util.client.zzb.zzd("Failed to set the onCustomRenderedAdLoadedListener.", paramOnCustomRenderedAdLoadedListener);
    }
  }
  
  public void setPlayStorePurchaseParams(PlayStorePurchaseListener paramPlayStorePurchaseListener, String paramString)
  {
    if (this.zzuz != null) {
      throw new IllegalStateException("InAppPurchaseListener has already been set.");
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
          break label62;
        }
      }
      label62:
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
        zzda();
      }
      if (this.zzuw.zzb(this.zzoq.zza(this.zzuy.getContext(), paramzzy))) {
        this.zzuu.zze(paramzzy.zzcV());
      }
      return;
    }
    catch (RemoteException paramzzy)
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzd("Failed to load ad.", paramzzy);
    }
  }
  
  public void zza(AdSize... paramVarArgs)
  {
    this.zzuc = paramVarArgs;
    try
    {
      if (this.zzuw != null) {
        this.zzuw.zza(zza(this.zzuy.getContext(), this.zzuc, this.zzuD));
      }
      this.zzuy.requestLayout();
      return;
    }
    catch (RemoteException paramVarArgs)
    {
      for (;;)
      {
        com.google.android.gms.ads.internal.util.client.zzb.zzd("Failed to set the ad size.", paramVarArgs);
      }
    }
  }
  
  void zzda()
    throws RemoteException
  {
    if (((this.zzuc == null) || (this.zzpH == null)) && (this.zzuw == null)) {
      throw new IllegalStateException("The ad size and ad unit ID must be set before loadAd is called.");
    }
    this.zzuw = zzdb();
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
    this.zzuw.setManualImpressionsEnabled(this.zzpt);
    zzcZ();
  }
  
  protected zzs zzdb()
    throws RemoteException
  {
    Context localContext = this.zzuy.getContext();
    return zzl.zzcO().zza(localContext, zza(localContext, this.zzuc, this.zzuD), this.zzpH, this.zzuu);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/ads/internal/client/zzz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */