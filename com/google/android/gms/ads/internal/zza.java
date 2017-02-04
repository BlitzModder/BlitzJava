package com.google.android.gms.ads.internal;

import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.View;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.ThinAdSizeParcel;
import com.google.android.gms.ads.internal.client.zzf;
import com.google.android.gms.ads.internal.client.zzl;
import com.google.android.gms.ads.internal.client.zzs.zza;
import com.google.android.gms.ads.internal.client.zzu;
import com.google.android.gms.ads.internal.client.zzv;
import com.google.android.gms.ads.internal.request.AdResponseParcel;
import com.google.android.gms.ads.internal.request.zza.zza;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.internal.zzay;
import com.google.android.gms.internal.zzbi;
import com.google.android.gms.internal.zzbl;
import com.google.android.gms.internal.zzbv;
import com.google.android.gms.internal.zzbz;
import com.google.android.gms.internal.zzcb;
import com.google.android.gms.internal.zzcf;
import com.google.android.gms.internal.zzch;
import com.google.android.gms.internal.zzcl;
import com.google.android.gms.internal.zzdh;
import com.google.android.gms.internal.zzgc;
import com.google.android.gms.internal.zzgg;
import com.google.android.gms.internal.zzgq.zza;
import com.google.android.gms.internal.zzha;
import com.google.android.gms.internal.zzie;
import com.google.android.gms.internal.zzie.zza;
import com.google.android.gms.internal.zzif;
import com.google.android.gms.internal.zzig;
import com.google.android.gms.internal.zzii;
import com.google.android.gms.internal.zzij;
import com.google.android.gms.internal.zzip;
import com.google.android.gms.internal.zziq;
import com.google.android.gms.internal.zzjn;
import com.google.android.gms.internal.zzjo;
import java.util.HashSet;

@zzha
public abstract class zza
  extends zzs.zza
  implements com.google.android.gms.ads.internal.client.zza, com.google.android.gms.ads.internal.overlay.zzn, zza.zza, zzdh, zzgq.zza, zzii
{
  protected zzch zzoU;
  protected zzcf zzoV;
  protected zzcf zzoW;
  protected boolean zzoX = false;
  protected final zzo zzoY;
  protected final zzq zzoZ;
  protected transient AdRequestParcel zzpa;
  protected final zzay zzpb;
  protected final zzd zzpc;
  
  zza(zzq paramzzq, zzo paramzzo, zzd paramzzd)
  {
    this.zzoZ = paramzzq;
    if (paramzzo != null) {}
    for (;;)
    {
      this.zzoY = paramzzo;
      this.zzpc = paramzzd;
      zzp.zzbx().zzK(this.zzoZ.context);
      zzp.zzbA().zzb(this.zzoZ.context, this.zzoZ.zzqR);
      this.zzpb = zzp.zzbA().zzgR();
      return;
      paramzzo = new zzo(this);
    }
  }
  
  private AdRequestParcel zza(AdRequestParcel paramAdRequestParcel)
  {
    AdRequestParcel localAdRequestParcel = paramAdRequestParcel;
    if (GooglePlayServicesUtil.zzao(this.zzoZ.context))
    {
      localAdRequestParcel = paramAdRequestParcel;
      if (paramAdRequestParcel.zzty != null) {
        localAdRequestParcel = new zzf(paramAdRequestParcel).zza(null).zzcI();
      }
    }
    return localAdRequestParcel;
  }
  
  private boolean zzaT()
  {
    zzb.zzaG("Ad leaving application.");
    if (this.zzoZ.zzra == null) {
      return false;
    }
    try
    {
      this.zzoZ.zzra.onAdLeftApplication();
      return true;
    }
    catch (RemoteException localRemoteException)
    {
      zzb.zzd("Could not call AdListener.onAdLeftApplication().", localRemoteException);
    }
    return false;
  }
  
  public void destroy()
  {
    zzx.zzcx("destroy must be called on the main UI thread.");
    this.zzoY.cancel();
    this.zzpb.zzf(this.zzoZ.zzqW);
    this.zzoZ.destroy();
  }
  
  public boolean isLoading()
  {
    return this.zzoX;
  }
  
  public boolean isReady()
  {
    zzx.zzcx("isLoaded must be called on the main UI thread.");
    return (this.zzoZ.zzqT == null) && (this.zzoZ.zzqU == null) && (this.zzoZ.zzqW != null);
  }
  
  public void onAdClicked()
  {
    if (this.zzoZ.zzqW == null) {
      zzb.zzaH("Ad state was null when trying to ping click URLs.");
    }
    do
    {
      return;
      zzb.zzaF("Pinging click URLs.");
      this.zzoZ.zzqY.zzgE();
      if (this.zzoZ.zzqW.zzAQ != null) {
        zzp.zzbx().zza(this.zzoZ.context, this.zzoZ.zzqR.afmaVersion, this.zzoZ.zzqW.zzAQ);
      }
    } while (this.zzoZ.zzqZ == null);
    try
    {
      this.zzoZ.zzqZ.onAdClicked();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      zzb.zzd("Could not notify onAdClicked event.", localRemoteException);
    }
  }
  
  public void onAppEvent(String paramString1, String paramString2)
  {
    if (this.zzoZ.zzrb != null) {}
    try
    {
      this.zzoZ.zzrb.onAppEvent(paramString1, paramString2);
      return;
    }
    catch (RemoteException paramString1)
    {
      zzb.zzd("Could not call the AppEventListener.", paramString1);
    }
  }
  
  public void pause()
  {
    zzx.zzcx("pause must be called on the main UI thread.");
  }
  
  protected void recordImpression()
  {
    zzc(this.zzoZ.zzqW);
  }
  
  public void resume()
  {
    zzx.zzcx("resume must be called on the main UI thread.");
  }
  
  public void setManualImpressionsEnabled(boolean paramBoolean)
  {
    throw new UnsupportedOperationException("Attempt to call setManualImpressionsEnabled for an unsupported ad type.");
  }
  
  public void stopLoading()
  {
    zzx.zzcx("stopLoading must be called on the main UI thread.");
    this.zzoX = false;
    this.zzoZ.zzf(true);
  }
  
  Bundle zza(zzbl paramzzbl)
  {
    if (paramzzbl == null) {}
    for (;;)
    {
      return null;
      if (paramzzbl.zzcF()) {
        paramzzbl.wakeup();
      }
      Object localObject = paramzzbl.zzcD();
      if (localObject != null)
      {
        paramzzbl = ((zzbi)localObject).zzcu();
        zzb.zzaF("In AdManger: loadAd, " + ((zzbi)localObject).toString());
      }
      while (paramzzbl != null)
      {
        localObject = new Bundle(1);
        ((Bundle)localObject).putString("fingerprint", paramzzbl);
        ((Bundle)localObject).putInt("v", 1);
        return (Bundle)localObject;
        paramzzbl = null;
      }
    }
  }
  
  public void zza(AdSizeParcel paramAdSizeParcel)
  {
    zzx.zzcx("setAdSize must be called on the main UI thread.");
    this.zzoZ.zzqV = paramAdSizeParcel;
    if ((this.zzoZ.zzqW != null) && (this.zzoZ.zzqW.zzDC != null) && (this.zzoZ.zzrp == 0)) {
      this.zzoZ.zzqW.zzDC.zza(paramAdSizeParcel);
    }
    if (this.zzoZ.zzqS == null) {
      return;
    }
    if (this.zzoZ.zzqS.getChildCount() > 1) {
      this.zzoZ.zzqS.removeView(this.zzoZ.zzqS.getNextView());
    }
    this.zzoZ.zzqS.setMinimumWidth(paramAdSizeParcel.widthPixels);
    this.zzoZ.zzqS.setMinimumHeight(paramAdSizeParcel.heightPixels);
    this.zzoZ.zzqS.requestLayout();
  }
  
  public void zza(com.google.android.gms.ads.internal.client.zzn paramzzn)
  {
    zzx.zzcx("setAdListener must be called on the main UI thread.");
    this.zzoZ.zzqZ = paramzzn;
  }
  
  public void zza(com.google.android.gms.ads.internal.client.zzo paramzzo)
  {
    zzx.zzcx("setAdListener must be called on the main UI thread.");
    this.zzoZ.zzra = paramzzo;
  }
  
  public void zza(zzu paramzzu)
  {
    zzx.zzcx("setAppEventListener must be called on the main UI thread.");
    this.zzoZ.zzrb = paramzzu;
  }
  
  public void zza(zzv paramzzv)
  {
    zzx.zzcx("setCorrelationIdProvider must be called on the main UI thread");
    this.zzoZ.zzrc = paramzzv;
  }
  
  public void zza(zzcl paramzzcl)
  {
    throw new IllegalStateException("setOnCustomRenderedAdLoadedListener is not supported for current ad type");
  }
  
  public void zza(zzgc paramzzgc)
  {
    throw new IllegalStateException("setInAppPurchaseListener is not supported for current ad type");
  }
  
  public void zza(zzgg paramzzgg, String paramString)
  {
    throw new IllegalStateException("setPlayStorePurchaseParams is not supported for current ad type");
  }
  
  public void zza(zzie.zza paramzza)
  {
    if ((paramzza.zzJL.zzGR != -1L) && (!TextUtils.isEmpty(paramzza.zzJL.zzHb)))
    {
      long l = zzo(paramzza.zzJL.zzHb);
      if (l != -1L)
      {
        zzcf localzzcf = this.zzoU.zzb(l + paramzza.zzJL.zzGR);
        this.zzoU.zza(localzzcf, new String[] { "stc" });
      }
    }
    this.zzoU.zzR(paramzza.zzJL.zzHb);
    this.zzoU.zza(this.zzoV, new String[] { "arf" });
    this.zzoW = this.zzoU.zzdu();
    this.zzoU.zzd("gqi", paramzza.zzJL.zzHc);
    this.zzoZ.zzqT = null;
    this.zzoZ.zzqX = paramzza;
    zza(paramzza, this.zzoU);
  }
  
  protected abstract void zza(zzie.zza paramzza, zzch paramzzch);
  
  public void zza(HashSet<zzif> paramHashSet)
  {
    this.zzoZ.zza(paramHashSet);
  }
  
  protected abstract boolean zza(AdRequestParcel paramAdRequestParcel, zzch paramzzch);
  
  boolean zza(zzie paramzzie)
  {
    return false;
  }
  
  protected abstract boolean zza(zzie paramzzie1, zzie paramzzie2);
  
  void zzaN()
  {
    this.zzoU = new zzch(((Boolean)zzbz.zzvL.get()).booleanValue(), "load_ad", this.zzoZ.zzqV.zztV);
    this.zzoV = new zzcf(-1L, null, null);
    this.zzoW = new zzcf(-1L, null, null);
  }
  
  public com.google.android.gms.dynamic.zzd zzaO()
  {
    zzx.zzcx("getAdFrame must be called on the main UI thread.");
    return zze.zzB(this.zzoZ.zzqS);
  }
  
  public AdSizeParcel zzaP()
  {
    zzx.zzcx("getAdSize must be called on the main UI thread.");
    if (this.zzoZ.zzqV == null) {
      return null;
    }
    return new ThinAdSizeParcel(this.zzoZ.zzqV);
  }
  
  public void zzaQ()
  {
    zzaT();
  }
  
  public void zzaR()
  {
    zzx.zzcx("recordManualImpression must be called on the main UI thread.");
    if (this.zzoZ.zzqW == null) {
      zzb.zzaH("Ad state was null when trying to ping manual tracking URLs.");
    }
    do
    {
      return;
      zzb.zzaF("Pinging manual tracking URLs.");
    } while (this.zzoZ.zzqW.zzGP == null);
    zzp.zzbx().zza(this.zzoZ.context, this.zzoZ.zzqR.afmaVersion, this.zzoZ.zzqW.zzGP);
  }
  
  protected boolean zzaS()
  {
    zzb.v("Ad closing.");
    if (this.zzoZ.zzra == null) {
      return false;
    }
    try
    {
      this.zzoZ.zzra.onAdClosed();
      return true;
    }
    catch (RemoteException localRemoteException)
    {
      zzb.zzd("Could not call AdListener.onAdClosed().", localRemoteException);
    }
    return false;
  }
  
  protected boolean zzaU()
  {
    zzb.zzaG("Ad opening.");
    if (this.zzoZ.zzra == null) {
      return false;
    }
    try
    {
      this.zzoZ.zzra.onAdOpened();
      return true;
    }
    catch (RemoteException localRemoteException)
    {
      zzb.zzd("Could not call AdListener.onAdOpened().", localRemoteException);
    }
    return false;
  }
  
  protected boolean zzaV()
  {
    zzb.zzaG("Ad finished loading.");
    this.zzoX = false;
    if (this.zzoZ.zzra == null) {
      return false;
    }
    try
    {
      this.zzoZ.zzra.onAdLoaded();
      return true;
    }
    catch (RemoteException localRemoteException)
    {
      zzb.zzd("Could not call AdListener.onAdLoaded().", localRemoteException);
    }
    return false;
  }
  
  protected void zzb(View paramView)
  {
    this.zzoZ.zzqS.addView(paramView, zzp.zzbz().zzhg());
  }
  
  public void zzb(zzie paramzzie)
  {
    this.zzoU.zza(this.zzoW, new String[] { "awr" });
    this.zzoZ.zzqU = null;
    if ((paramzzie.errorCode != -2) && (paramzzie.errorCode != 3)) {
      zzp.zzbA().zzb(this.zzoZ.zzbM());
    }
    if (paramzzie.errorCode == -1) {
      this.zzoX = false;
    }
    do
    {
      return;
      if (zza(paramzzie)) {
        zzb.zzaF("Ad refresh scheduled.");
      }
      if (paramzzie.errorCode != -2)
      {
        zzf(paramzzie.errorCode);
        return;
      }
      if (this.zzoZ.zzrn == null) {
        this.zzoZ.zzrn = new zzij(this.zzoZ.zzqP);
      }
      this.zzpb.zze(this.zzoZ.zzqW);
    } while (!zza(this.zzoZ.zzqW, paramzzie));
    this.zzoZ.zzqW = paramzzie;
    this.zzoZ.zzbV();
    zzch localzzch = this.zzoU;
    if (this.zzoZ.zzqW.zzcb())
    {
      paramzzie = "1";
      label204:
      localzzch.zzd("is_mraid", paramzzie);
      localzzch = this.zzoU;
      if (!this.zzoZ.zzqW.zzGN) {
        break label379;
      }
      paramzzie = "1";
      label234:
      localzzch.zzd("is_mediation", paramzzie);
      if ((this.zzoZ.zzqW.zzDC != null) && (this.zzoZ.zzqW.zzDC.zzhC() != null))
      {
        localzzch = this.zzoU;
        if (!this.zzoZ.zzqW.zzDC.zzhC().zzhP()) {
          break label386;
        }
      }
    }
    label379:
    label386:
    for (paramzzie = "1";; paramzzie = "0")
    {
      localzzch.zzd("is_video", paramzzie);
      this.zzoU.zza(this.zzoV, new String[] { "ttc" });
      if (zzp.zzbA().zzgM() != null) {
        zzp.zzbA().zzgM().zza(this.zzoU);
      }
      if (!this.zzoZ.zzbQ()) {
        break;
      }
      zzaV();
      return;
      paramzzie = "0";
      break label204;
      paramzzie = "0";
      break label234;
    }
  }
  
  public boolean zzb(AdRequestParcel paramAdRequestParcel)
  {
    zzx.zzcx("loadAd must be called on the main UI thread.");
    paramAdRequestParcel = zza(paramAdRequestParcel);
    if ((this.zzoZ.zzqT != null) || (this.zzoZ.zzqU != null))
    {
      if (this.zzpa != null) {
        zzb.zzaH("Aborting last ad request since another ad request is already in progress. The current request object will still be cached for future refreshes.");
      }
      for (;;)
      {
        this.zzpa = paramAdRequestParcel;
        return false;
        zzb.zzaH("Loading already in progress, saving this object for future refreshes.");
      }
    }
    zzb.zzaG("Starting ad request.");
    zzaN();
    this.zzoV = this.zzoU.zzdu();
    if (!paramAdRequestParcel.zztt) {
      zzb.zzaG("Use AdRequest.Builder.addTestDevice(\"" + zzl.zzcN().zzS(this.zzoZ.context) + "\") to get test ads on this device.");
    }
    this.zzoX = zza(paramAdRequestParcel, this.zzoU);
    return this.zzoX;
  }
  
  protected void zzc(zzie paramzzie)
  {
    if (paramzzie == null) {
      zzb.zzaH("Ad state was null when trying to ping impression URLs.");
    }
    do
    {
      return;
      zzb.zzaF("Pinging Impression URLs.");
      this.zzoZ.zzqY.zzgD();
    } while (paramzzie.zzAR == null);
    zzp.zzbx().zza(this.zzoZ.context, this.zzoZ.zzqR.afmaVersion, paramzzie.zzAR);
  }
  
  protected boolean zzc(AdRequestParcel paramAdRequestParcel)
  {
    paramAdRequestParcel = this.zzoZ.zzqS.getParent();
    return ((paramAdRequestParcel instanceof View)) && (((View)paramAdRequestParcel).isShown()) && (zzp.zzbx().zzgY());
  }
  
  public void zzd(AdRequestParcel paramAdRequestParcel)
  {
    if (zzc(paramAdRequestParcel))
    {
      zzb(paramAdRequestParcel);
      return;
    }
    zzb.zzaG("Ad is not visible. Not refreshing ad.");
    this.zzoY.zzg(paramAdRequestParcel);
  }
  
  protected boolean zzf(int paramInt)
  {
    zzb.zzaH("Failed to load ad: " + paramInt);
    this.zzoX = false;
    if (this.zzoZ.zzra == null) {
      return false;
    }
    try
    {
      this.zzoZ.zzra.onAdFailedToLoad(paramInt);
      return true;
    }
    catch (RemoteException localRemoteException)
    {
      zzb.zzd("Could not call AdListener.onAdFailedToLoad().", localRemoteException);
    }
    return false;
  }
  
  long zzo(String paramString)
  {
    int k = paramString.indexOf("ufe");
    int j = paramString.indexOf(',', k);
    int i = j;
    if (j == -1) {
      i = paramString.length();
    }
    try
    {
      long l = Long.parseLong(paramString.substring(k + 4, i));
      return l;
    }
    catch (IndexOutOfBoundsException paramString)
    {
      zzb.zzaH("Invalid index for Url fetch time in CSI latency info.");
      return -1L;
    }
    catch (NumberFormatException paramString)
    {
      for (;;)
      {
        zzb.zzaH("Cannot find valid format of Url fetch time in CSI latency info.");
      }
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/ads/internal/zza.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */